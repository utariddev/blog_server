package org.utarid.server.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.utarid.server.dto.Result;
import org.utarid.server.dto.article.*;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.dto.category.GetCategoryArticlesRequestDTO;
import org.utarid.server.dto.category.GetCategoryArticlesResponseDTO;
import org.utarid.server.dto.constant.ConstantDTO;
import org.utarid.server.dto.constant.GetConstantRequestDTO;
import org.utarid.server.dto.constant.GetConstantResponseDTO;
import org.utarid.server.mapper.UtaridMapper;
import org.utarid.server.repository.article.ArticleEntity;
import org.utarid.server.repository.article.ArticleRepository;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.category.CategoryRepository;
import org.utarid.server.repository.contant.ConstantEntity;
import org.utarid.server.repository.contant.ConstantRepository;

import java.util.List;

@Service
public class UtaridService implements IUtaridService {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;
    private final ConstantRepository constantRepository;

    public UtaridService(CategoryRepository categoryRepository, ArticleRepository articleRepository, ConstantRepository constantRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
        this.constantRepository = constantRepository;
    }

    @Override
    public GetCategoriesResponseDTO getCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findActiveCategoriesWithImages();
        List<CategoryDTO> categoryDTOList = categoryEntityList.stream().map(UtaridMapper.INSTANCE::categoryEntityToCategoryDTO).toList();
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

        List<ArticleDTO> articleDTOList = articleEntities.stream().map(UtaridMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetArticlesResponseDTO(Result.successResult(), articleDTOList);
    }

    @Override
    public GetArticleResponseDTO getArticle(GetArticleRequestDTO getArticleRequestDTO) {
        articleRepository.incrementArticleRead(getArticleRequestDTO.getArticleID());
        ArticleEntity articleEntity = articleRepository.findArticlesByWebTitle(getArticleRequestDTO.getArticleID());
        if (articleEntity == null) {
            return new GetArticleResponseDTO(new Result("no article found", "113"), null);
        }
        ArticleDTO articleDTO = UtaridMapper.INSTANCE.articleEntityToArticleDTO(articleEntity);
        return new GetArticleResponseDTO(Result.successResult(), articleDTO);
    }

    @Override
    public GetCategoryArticlesResponseDTO getCategoryArticles(GetCategoryArticlesRequestDTO getCategoryArticlesRequestDTO) {
        List<ArticleEntity> articleEntities = articleRepository.findArticlesByCategory(getCategoryArticlesRequestDTO.getCategoryName());
        List<ArticleDTO> articleDTOList = articleEntities.stream().map(UtaridMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetCategoryArticlesResponseDTO(Result.successResult(), articleDTOList);
    }

    @Override
    public GetConstantResponseDTO getConstant(GetConstantRequestDTO getConstantRequestDTO) {
        ConstantEntity constantEntity = constantRepository.getConstant(getConstantRequestDTO.getKey());
        if (constantEntity == null) {
            return new GetConstantResponseDTO(Result.successResult(), "");
        }
        ConstantDTO constantDTO = UtaridMapper.INSTANCE.constantEntityToConstantDTO(constantEntity);
        return new GetConstantResponseDTO(Result.successResult(), constantDTO.getValue());
    }

    @Override
    public GetMostReadArticlesResponseDTO getMostReadArticles() {
        Pageable pageable = PageRequest.of(0, 4);
        List<ArticleEntity> mostReadArticles = articleRepository.findMostReadArticles(pageable);
        List<ArticleDTO> articleDTOList = mostReadArticles.stream().map(UtaridMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetMostReadArticlesResponseDTO(Result.successResult(), articleDTOList);
    }
}
