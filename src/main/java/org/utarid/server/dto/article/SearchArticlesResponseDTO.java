package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;

import java.util.List;

public class SearchArticlesResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private List<ArticleDTO> data;
    @JsonProperty("total_count")
    private long totalCount;

    public SearchArticlesResponseDTO(Result result, List<ArticleDTO> data, long totalCount) {
        this.result = result;
        this.data = data;
        this.totalCount = totalCount;
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

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}