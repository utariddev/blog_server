package org.utarid.server.dto.article;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchArticlesRequestDTO {

    @JsonProperty("query")
    private String query;

    @JsonProperty("indicator")
    private int indicator;

    @JsonProperty("page_size")
    private int pageSize;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getIndicator() {
        return indicator;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}