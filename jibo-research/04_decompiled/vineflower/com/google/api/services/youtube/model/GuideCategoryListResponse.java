package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class GuideCategoryListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<GuideCategory> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private PageInfo pageInfo;
   @Key
   private String prevPageToken;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   static {
      Data.nullOf(GuideCategory.class);
   }

   public GuideCategoryListResponse clone() {
      return (GuideCategoryListResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<GuideCategory> getItems() {
      return this.items;
   }

   public String getKind() {
      return this.kind;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public PageInfo getPageInfo() {
      return this.pageInfo;
   }

   public String getPrevPageToken() {
      return this.prevPageToken;
   }

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public GuideCategoryListResponse set(String var1, Object var2) {
      return (GuideCategoryListResponse)super.set(var1, var2);
   }

   public GuideCategoryListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public GuideCategoryListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public GuideCategoryListResponse setItems(List<GuideCategory> var1) {
      this.items = var1;
      return this;
   }

   public GuideCategoryListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public GuideCategoryListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public GuideCategoryListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public GuideCategoryListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public GuideCategoryListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public GuideCategoryListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
