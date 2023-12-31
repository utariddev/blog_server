package org.utarid.server.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.utarid.server.dto.Result;
import org.utarid.server.dto.article.*;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.mapper.CategoryMapper;
import org.utarid.server.repository.article.ArticleEntity;
import org.utarid.server.repository.article.ArticleRepository;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.category.CategoryRepository;

import java.util.List;

@Service
public class UtaridService implements IUtaridService {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    public UtaridService(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public GetCategoriesResponseDTO getCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findActiveCategoriesWithImages();
        List<CategoryDTO> categoryDTOList = categoryEntityList.stream().map(CategoryMapper.INSTANCE::categoryEntityToCategoryDTO).toList();
        return new GetCategoriesResponseDTO(Result.successResult(), categoryDTOList);
    }

    @Override
    public GetArticlesCountResponseDTO getArticlesCount() {
        long count = articleRepository.countActiveArticles();
        return new GetArticlesCountResponseDTO(Result.successResult(), new GetArticlesCountResponseDTO.Count(String.valueOf(count)));
    }

    @Override
    public GetArticlesResponseDTO getArticles(GetArticlesRequestDTO getArticlesRequestDTO) {
        Pageable pageable = PageRequest.of(getArticlesRequestDTO.getIndicator(), 3, Sort.by("articleUpdateDate").descending());
        List<ArticleEntity> articleEntities = articleRepository.findArticlesWithAuthorAndCategory(pageable);

        List<ArticleDTO> articleDTOList = articleEntities.stream().map(CategoryMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetArticlesResponseDTO(Result.successResult(), articleDTOList);
    }

    @Override
    public GetArticleResponseDTO getArticle(GetArticleRequestDTO getArticleRequestDTO) {
        articleRepository.incrementArticleRead(getArticleRequestDTO.getArticleID());
        ArticleEntity articleEntity = articleRepository.findArticlesByWebTitle(getArticleRequestDTO.getArticleID());
        if (articleEntity == null) {
            return new GetArticleResponseDTO(new Result("no article found", "113"), null);
        }
        ArticleDTO articleDTO = CategoryMapper.INSTANCE.articleEntityToArticleDTO(articleEntity);
        return new GetArticleResponseDTO(Result.successResult(), articleDTO);
    }

    @Override
    public GetCategoryArticlesResponseDTO getCategoryArticles(GetCategoryArticlesRequestDTO getCategoryArticlesRequestDTO) {
        List<ArticleEntity> articleEntities = articleRepository.findByCategoryName(getCategoryArticlesRequestDTO.getCategoryName());
        List<ArticleDTO> articleDTOList = articleEntities.stream().map(CategoryMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetCategoryArticlesResponseDTO(Result.successResult(), articleDTOList);
    }
}
