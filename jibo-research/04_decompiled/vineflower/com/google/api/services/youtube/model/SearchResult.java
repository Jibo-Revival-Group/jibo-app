package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class SearchResult extends GenericJson {
   @Key
   private String etag;
   @Key
   private ResourceId id;
   @Key
   private String kind;
   @Key
   private SearchResultSnippet snippet;

   public SearchResult clone() {
      return (SearchResult)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public ResourceId getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public SearchResultSnippet getSnippet() {
      return this.snippet;
   }

   public SearchResult set(String var1, Object var2) {
      return (SearchResult)super.set(var1, var2);
   }

   public SearchResult setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public SearchResult setId(ResourceId var1) {
      this.id = var1;
      return this;
   }

   public SearchResult setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public SearchResult setSnippet(SearchResultSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
