package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleSuggestionDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("web_title")
    private String webTitle;

    @JsonProperty("category_name")
    private String categoryName;

    public ArticleSuggestionDTO(String id, String title, String webTitle, String categoryName) {
        this.id = id;
        this.title = title;
        this.webTitle = webTitle;
        this.categoryName = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}