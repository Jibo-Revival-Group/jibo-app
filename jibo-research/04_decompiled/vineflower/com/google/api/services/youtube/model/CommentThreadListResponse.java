package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class CommentThreadListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<CommentThread> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
   @Key
   private PageInfo pageInfo;
   @Key
   private TokenPagination tokenPagination;
   @Key
   private String visitorId;

   static {
      Data.nullOf(CommentThread.class);
   }

   public CommentThreadListResponse clone() {
      return (CommentThreadListResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<CommentThread> getItems() {
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

   public TokenPagination getTokenPagination() {
      return this.tokenPagination;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public CommentThreadListResponse set(String var1, Object var2) {
      return (CommentThreadListResponse)super.set(var1, var2);
   }

   public CommentThreadListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public CommentThreadListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public CommentThreadListResponse setItems(List<CommentThread> var1) {
      this.items = var1;
      return this;
   }

   public CommentThreadListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public CommentThreadListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public CommentThreadListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public CommentThreadListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public CommentThreadListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
