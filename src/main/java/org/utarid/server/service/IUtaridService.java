package org.utarid.server.service;

import org.utarid.server.dto.article.*;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;

public interface IUtaridService {

    GetCategoriesResponseDTO getCategories();

    GetArticlesCountResponseDTO getArticlesCount();

    GetArticlesResponseDTO getArticles(GetArticlesRequestDTO getArticlesRequestDTO);

    GetArticleResponseDTO getArticle(GetArticleRequestDTO getArticleRequestDTO);
}
