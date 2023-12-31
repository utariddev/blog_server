package org.utarid.server.controller;

import org.springframework.web.bind.annotation.*;
import org.utarid.server.dto.article.*;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.dto.category.GetCategoryArticlesRequestDTO;
import org.utarid.server.dto.category.GetCategoryArticlesResponseDTO;
import org.utarid.server.dto.constant.GetConstantRequestDTO;
import org.utarid.server.dto.constant.GetConstantResponseDTO;
import org.utarid.server.service.IUtaridService;

@RestController
@RequestMapping("/rest/message")
public class UtaridController {

    private final IUtaridService utaridService;

    public UtaridController(IUtaridService utaridService) {
        this.utaridService = utaridService;
    }

    @GetMapping("/testGet")
    public String testGet() {
        return "testGet";
    }

    @PostMapping("/testPost")
    public String testPost(@RequestBody String requestData) {
        return "testPost : " + requestData;
    }

    @PostMapping("/getCategories")
    public GetCategoriesResponseDTO getCategories() {
        return utaridService.getCategories();
    }

    @PostMapping("/getArticlesCount")
    public GetArticlesCountResponseDTO getArticlesCount() {
        return utaridService.getArticlesCount();
    }

    @PostMapping("/getArticles")
    public GetArticlesResponseDTO getArticles(@RequestBody GetArticlesRequestDTO getArticlesRequestDTO) {
        return utaridService.getArticles(getArticlesRequestDTO);
    }

    @PostMapping("/getArticle")
    public GetArticleResponseDTO getArticle(@RequestBody GetArticleRequestDTO getArticleRequestDTO) {
        return utaridService.getArticle(getArticleRequestDTO);
    }

    @PostMapping("/getCategoryArticles")
    public GetCategoryArticlesResponseDTO getCategoryArticles(@RequestBody GetCategoryArticlesRequestDTO getArticleRequestDTO) {
        return utaridService.getCategoryArticles(getArticleRequestDTO);
    }

    @PostMapping("/getConstant")
    public GetConstantResponseDTO getConstant(@RequestBody GetConstantRequestDTO getConstantRequestDTO) {
        return utaridService.getConstant(getConstantRequestDTO);
    }
}
