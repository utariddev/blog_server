package org.utarid.server.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.utarid.server.dto.Result;
import org.utarid.server.dto.article.ArticleDTO;
import org.utarid.server.dto.article.GetArticlesCountResponseDTO;
import org.utarid.server.dto.article.GetArticlesRequestDTO;
import org.utarid.server.dto.article.GetArticlesResponseDTO;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.mapper.CategoryMapper;
import org.utarid.server.repository.article.ArticleEntity;
import org.utarid.server.repository.article.ArticleRepository;
import org.utarid.server.repository.category.CategoryEntity;
import org.utarid.server.repository.category.CategoryRepository;

import java.util.List;

@Service
public class UtaridService {

    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    public UtaridService(CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    public GetCategoriesResponseDTO getCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findActiveCategoriesWithImages();
        List<CategoryDTO> categoryDTOList = categoryEntityList.stream().map(CategoryMapper.INSTANCE::categoryEntityToCategoryDTO).toList();
        return new GetCategoriesResponseDTO(Result.successResult(), categoryDTOList);
    }

    public GetArticlesCountResponseDTO getArticlesCount() {
        long count = articleRepository.countActiveArticles();
        return new GetArticlesCountResponseDTO(Result.successResult(), new GetArticlesCountResponseDTO.Count(String.valueOf(count)));
    }

    public GetArticlesResponseDTO getArticles(GetArticlesRequestDTO getArticlesRequestDTO) {
        Pageable pageable = PageRequest.of(getArticlesRequestDTO.getIndicator(), 3, Sort.by("articleUpdateDate").descending());
        List<ArticleEntity> t = articleRepository.findArticlesWithAuthorAndCategory(pageable);

        List<ArticleDTO> categoryDTOList = t.stream().map(CategoryMapper.INSTANCE::articleEntityToArticleDTO).toList();
        return new GetArticlesResponseDTO(Result.successResult(), categoryDTOList);
    }
}
