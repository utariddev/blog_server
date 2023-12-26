package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;

public class GetArticlesCountResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private Count data;

    public GetArticlesCountResponseDTO(Result result, Count data) {
        this.result = result;
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Count getData() {
        return data;
    }

    public void setData(Count data) {
        this.data = data;
    }

    public static class Count {
        @JsonProperty("count")
        private String countData;

        public Count(String countData) {
            this.countData = countData;
        }

        public String getCountData() {
            return countData;
        }

        public void setCountData(String countData) {
            this.countData = countData;
        }
    }
}
