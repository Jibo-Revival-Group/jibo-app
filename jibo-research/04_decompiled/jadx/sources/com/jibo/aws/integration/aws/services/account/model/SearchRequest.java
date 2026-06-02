package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class SearchRequest extends JiboAccountRequest {

    @Expose
    private String query;

    public SearchRequest(String str) {
        this.query = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SearchRequest)) {
            return false;
        }
        SearchRequest searchRequest = (SearchRequest) obj;
        if ((searchRequest.getQuery() == null) ^ (getQuery() == null)) {
            return false;
        }
        return searchRequest.getQuery() == null || searchRequest.getQuery().equals(getQuery());
    }

    public String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return (getQuery() == null ? 0 : getQuery().hashCode()) + 31;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String toString() {
        return "SearchRequest {query='" + this.query + "'}";
    }
}
