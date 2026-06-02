package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SearchListResponse extends GenericJson {

    @Key
    private String etag;

    @Key
    private String eventId;

    @Key
    private List<SearchResult> items;

    @Key
    private String kind;

    @Key
    private String nextPageToken;

    @Key
    private PageInfo pageInfo;

    @Key
    private String prevPageToken;

    @Key
    private String regionCode;

    @Key
    private TokenPagination tokenPagination;

    @Key
    private String visitorId;

    public String getEtag() {
        return this.etag;
    }

    public SearchListResponse setEtag(String str) {
        this.etag = str;
        return this;
    }

    public String getEventId() {
        return this.eventId;
    }

    public SearchListResponse setEventId(String str) {
        this.eventId = str;
        return this;
    }

    public List<SearchResult> getItems() {
        return this.items;
    }

    public SearchListResponse setItems(List<SearchResult> list) {
        this.items = list;
        return this;
    }

    public String getKind() {
        return this.kind;
    }

    public SearchListResponse setKind(String str) {
        this.kind = str;
        return this;
    }

    public String getNextPageToken() {
        return this.nextPageToken;
    }

    public SearchListResponse setNextPageToken(String str) {
        this.nextPageToken = str;
        return this;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public SearchListResponse setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    public String getPrevPageToken() {
        return this.prevPageToken;
    }

    public SearchListResponse setPrevPageToken(String str) {
        this.prevPageToken = str;
        return this;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public SearchListResponse setRegionCode(String str) {
        this.regionCode = str;
        return this;
    }

    public TokenPagination getTokenPagination() {
        return this.tokenPagination;
    }

    public SearchListResponse setTokenPagination(TokenPagination tokenPagination) {
        this.tokenPagination = tokenPagination;
        return this;
    }

    public String getVisitorId() {
        return this.visitorId;
    }

    public SearchListResponse setVisitorId(String str) {
        this.visitorId = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public SearchListResponse set(String str, Object obj) {
        return (SearchListResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public SearchListResponse clone() {
        return (SearchListResponse) super.clone();
    }
}
