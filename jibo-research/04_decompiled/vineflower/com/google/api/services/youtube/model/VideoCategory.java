package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class VideoCategory extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private VideoCategorySnippet snippet;

   public VideoCategory clone() {
      return (VideoCategory)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getId() {
      return this.id;
   }

   public String getKind() {
      return this.kind;
   }

   public VideoCategorySnippet getSnippet() {
      return this.snippet;
   }

   public VideoCategory set(String var1, Object var2) {
      return (VideoCategory)super.set(var1, var2);
   }

   public VideoCategory setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public VideoCategory setId(String var1) {
      this.id = var1;
      return this;
   }

   public VideoCategory setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public VideoCategory setSnippet(VideoCategorySnippet var1) {
      this.snippet = var1;
      return this;
   }
}
