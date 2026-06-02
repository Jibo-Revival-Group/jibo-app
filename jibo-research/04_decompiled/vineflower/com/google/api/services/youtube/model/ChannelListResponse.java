package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class ChannelListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Channel> items;
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
      Data.nullOf(Channel.class);
   }

   public ChannelListResponse clone() {
      return (ChannelListResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<Channel> getItems() {
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

   public ChannelListResponse set(String var1, Object var2) {
      return (ChannelListResponse)super.set(var1, var2);
   }

   public ChannelListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public ChannelListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public ChannelListResponse setItems(List<Channel> var1) {
      this.items = var1;
      return this;
   }

   public ChannelListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public ChannelListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public ChannelListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public ChannelListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public ChannelListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public ChannelListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
