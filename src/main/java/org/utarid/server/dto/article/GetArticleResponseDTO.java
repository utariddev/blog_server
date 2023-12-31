package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;

public class GetArticleResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private ArticleDTO data;

    public GetArticleResponseDTO(Result result, ArticleDTO data) {
        this.result = result;
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ArticleDTO getData() {
        return data;
    }

    public void setData(ArticleDTO data) {
        this.data = data;
    }
}


