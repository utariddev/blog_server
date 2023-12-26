package org.utarid.server.service;

import org.springframework.stereotype.Service;
import org.utarid.server.dto.Result;
import org.utarid.server.dto.article.GetArticlesCountResponseDTO;
import org.utarid.server.dto.category.CategoryDTO;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.mapper.CategoryMapper;
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
        return new GetCategoriesResponseDTO(new Result("success", "1"), categoryDTOList);
    }

    public GetArticlesCountResponseDTO getArticlesCount() {
        long count = articleRepository.countActiveArticles();
        return new GetArticlesCountResponseDTO(
                new Result("success", "1"),
                new GetArticlesCountResponseDTO.Count(String.valueOf(count)));
    }
}
