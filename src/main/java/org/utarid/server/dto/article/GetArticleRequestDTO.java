package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetArticleRequestDTO {

    @JsonProperty("articleID")
    private String articleID;

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }
}
