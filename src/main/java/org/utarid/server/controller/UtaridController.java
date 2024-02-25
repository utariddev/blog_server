package org.utarid.server.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("testGet");
    }

    @PostMapping("/testPost")
    public ResponseEntity<String> testPost(@RequestBody String requestData) {
        return ResponseEntity.ok("testPost :" + requestData);
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
    public ResponseEntity<GetMostReadArticlesResponseDTO> getConstant() {
        return ResponseEntity.ok(utaridService.getMostReadArticles());
    }
}
