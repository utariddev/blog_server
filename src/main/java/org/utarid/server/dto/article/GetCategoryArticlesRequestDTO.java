package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCategoryArticlesRequestDTO {

    @JsonProperty("categoryName")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
