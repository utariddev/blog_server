package org.utarid.server.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.utarid.server.dto.article.ArticleSuggestionDTO;
import org.utarid.server.dto.article.GetArticleRequestDTO;
import org.utarid.server.dto.article.GetArticleResponseDTO;
import org.utarid.server.dto.article.GetArticlesCountResponseDTO;
import org.utarid.server.dto.article.GetArticlesRequestDTO;
import org.utarid.server.dto.article.GetArticlesResponseDTO;
import org.utarid.server.dto.article.GetMostReadArticlesResponseDTO;
import org.utarid.server.dto.article.SearchArticlesRequestDTO;
import org.utarid.server.dto.article.SearchArticlesResponseDTO;
import org.utarid.server.dto.category.GetCategoriesResponseDTO;
import org.utarid.server.dto.category.GetCategoryArticlesRequestDTO;
import org.utarid.server.dto.category.GetCategoryArticlesResponseDTO;
import org.utarid.server.dto.constant.GetConstantRequestDTO;
import org.utarid.server.dto.constant.GetConstantResponseDTO;
import org.utarid.server.service.IUtaridService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/message")
public class UtaridController {

    private final IUtaridService utaridService;
    private final BuildProperties buildProperties;
    private final GitProperties gitProperties;

    public UtaridController(IUtaridService utaridService,
                            BuildProperties buildProperties,
                            GitProperties gitProperties) {
        this.utaridService = utaridService;
        this.buildProperties = buildProperties;
        this.gitProperties = gitProperties;
    }

    @GetMapping("/testGet")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("testGet");
    }

    @PostMapping("/testPost")
    public ResponseEntity<String> testPost(@RequestBody String requestData) {
        return ResponseEntity.ok("testPost :" + requestData);
    }

    @GetMapping("/buildInfo")
    public ResponseEntity<Map<String, Object>> buildInfo() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("time", buildProperties.getTime().toString());
        info.put("commitId", gitProperties.getShortCommitId());
        return ResponseEntity.ok(info);
    }

    @PostMapping("/getCategories")
    public ResponseEntity<GetCategoriesResponseDTO> getCategories() {
        return ResponseEntity.ok(utaridService.getCategories());
    }

    @PostMapping("/getArticlesCount")
    public ResponseEntity<GetArticlesCountResponseDTO> getArticlesCount() {
        return ResponseEntity.ok(utaridService.getArticlesCount());
    }

    @PostMapping("/getArticles")
    public ResponseEntity<GetArticlesResponseDTO> getArticles(@RequestBody GetArticlesRequestDTO getArticlesRequestDTO) {
        return ResponseEntity.ok(utaridService.getArticles(getArticlesRequestDTO));
    }

    @PostMapping("/getArticle")
    public ResponseEntity<GetArticleResponseDTO> getArticle(@RequestBody GetArticleRequestDTO getArticleRequestDTO) {
        return ResponseEntity.ok(utaridService.getArticle(getArticleRequestDTO));
    }

    @PostMapping("/getCategoryArticles")
    public ResponseEntity<GetCategoryArticlesResponseDTO> getCategoryArticles(@RequestBody GetCategoryArticlesRequestDTO getArticleRequestDTO) {
        return ResponseEntity.ok(utaridService.getCategoryArticles(getArticleRequestDTO));
    }

    @PostMapping("/getConstant")
    public ResponseEntity<GetConstantResponseDTO> getConstant(@RequestBody GetConstantRequestDTO getConstantRequestDTO) {
        return ResponseEntity.ok(utaridService.getConstant(getConstantRequestDTO));
    }

    @PostMapping("/getMostReadArticles")
    public ResponseEntity<GetMostReadArticlesResponseDTO> getMostReadArticles() {
        return ResponseEntity.ok(utaridService.getMostReadArticles());
    }

    @GetMapping("/suggest")
    public ResponseEntity<List<ArticleSuggestionDTO>> getSuggestions(
            @RequestParam("q") String query,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ) {
        return ResponseEntity.ok(utaridService.getArticleSuggestions(query, limit));
    }

    @PostMapping("/search")
    public ResponseEntity<SearchArticlesResponseDTO> searchArticles(@RequestBody SearchArticlesRequestDTO requestDTO) {
        return ResponseEntity.ok(utaridService.searchArticles(requestDTO));
    }
}
