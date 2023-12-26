package org.utarid.server.controller;

import org.springframework.web.bind.annotation.*;
import org.utarid.server.dto.GetCategoriesResponseDTO;
import org.utarid.server.service.UtaridService;

@RestController
@RequestMapping("/rest/message")
public class UtaridController {

    private final UtaridService utaridService;

    public UtaridController(UtaridService utaridService) {
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
}
