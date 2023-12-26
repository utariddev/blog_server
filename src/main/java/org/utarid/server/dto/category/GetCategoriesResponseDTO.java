package org.utarid.server.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;

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
}
