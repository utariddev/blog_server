package org.utarid.server.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;
import org.utarid.server.dto.article.ArticleDTO;

import java.util.List;

public class GetCategoryArticlesResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private List<ArticleDTO> data;

    public GetCategoryArticlesResponseDTO(Result result, List<ArticleDTO> data) {
        this.result = result;
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<ArticleDTO> getData() {
        return data;
    }

    public void setData(List<ArticleDTO> data) {
        this.data = data;
    }
}


