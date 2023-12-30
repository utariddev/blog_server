package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetArticlesRequestDTO {

    @JsonProperty("indicator")
    private int indicator;

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }
}
