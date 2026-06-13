package org.utarid.server.service;

import org.utarid.server.dto.article.*;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.dto.category.GetCategoryArticlesRequestDTO;
import org.utarid.server.dto.category.GetCategoryArticlesResponseDTO;
import org.utarid.server.dto.article.ArticleSuggestionDTO;
import org.utarid.server.dto.article.SearchArticlesRequestDTO;
import org.utarid.server.dto.article.SearchArticlesResponseDTO;
import org.utarid.server.dto.constant.GetConstantRequestDTO;
import org.utarid.server.dto.constant.GetConstantResponseDTO;

import java.util.List;

public interface IUtaridService {

    GetCategoriesResponseDTO getCategories();

    GetArticlesCountResponseDTO getArticlesCount();

    GetArticlesResponseDTO getArticles(GetArticlesRequestDTO getArticlesRequestDTO);

    GetArticleResponseDTO getArticle(GetArticleRequestDTO getArticleRequestDTO);

    GetCategoryArticlesResponseDTO getCategoryArticles(GetCategoryArticlesRequestDTO getCategoryArticlesRequestDTO);

    GetConstantResponseDTO getConstant(GetConstantRequestDTO getConstantRequestDTO);

    GetMostReadArticlesResponseDTO getMostReadArticles();

    List<ArticleSuggestionDTO> getArticleSuggestions(String query, int limit);

    SearchArticlesResponseDTO searchArticles(SearchArticlesRequestDTO requestDTO);
}
