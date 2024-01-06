package org.utarid.server.dto.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetConstantRequestDTO {

    @JsonProperty("key")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
