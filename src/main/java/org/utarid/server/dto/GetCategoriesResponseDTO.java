package org.utarid.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetCategoriesResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private List<CategoryDTO> data;

    public GetCategoriesResponseDTO(Result result, List<CategoryDTO> data) {
        this.result = result;
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<CategoryDTO> getData() {
        return data;
    }

    public void setData(List<CategoryDTO> data) {
        this.data = data;
    }

    public static class Result {
        @JsonProperty("desc")
        private String desc;

        @JsonProperty("code")
        private String code;

        public Result(String desc, String code) {
            this.desc = desc;
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
