package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class PlaylistListResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Playlist> items;
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
      Data.nullOf(Playlist.class);
   }

   public PlaylistListResponse clone() {
      return (PlaylistListResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<Playlist> getItems() {
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

   public PlaylistListResponse set(String var1, Object var2) {
      return (PlaylistListResponse)super.set(var1, var2);
   }

   public PlaylistListResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public PlaylistListResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public PlaylistListResponse setItems(List<Playlist> var1) {
      this.items = var1;
      return this;
   }

   public PlaylistListResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public PlaylistListResponse setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public PlaylistListResponse setPageInfo(PageInfo var1) {
      this.pageInfo = var1;
      return this;
   }

   public PlaylistListResponse setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public PlaylistListResponse setTokenPagination(TokenPagination var1) {
      this.tokenPagination = var1;
      return this;
   }

   public PlaylistListResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
