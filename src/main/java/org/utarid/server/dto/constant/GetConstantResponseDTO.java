package org.utarid.server.dto.constant;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.utarid.server.dto.Result;

public class GetConstantResponseDTO {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("data")
    private String data;

    public GetConstantResponseDTO(Result result, String data) {
        this.result = result;
        this.data = data;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
