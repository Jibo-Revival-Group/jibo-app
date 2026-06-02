package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class LiveStream extends GenericJson {
   @Key
   private CdnSettings cdn;
   @Key
   private LiveStreamContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private LiveStreamSnippet snippet;
   @Key
   private LiveStreamStatus status;

   public LiveStream clone() {
      return (LiveStream)super.clone();
   }

   public CdnSettings getCdn() {
      return this.cdn;
   }

   public LiveStreamContentDetails getContentDetails() {
      return this.contentDetails;
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

   public LiveStreamSnippet getSnippet() {
      return this.snippet;
   }

   public LiveStreamStatus getStatus() {
      return this.status;
   }

   public LiveStream set(String var1, Object var2) {
      return (LiveStream)super.set(var1, var2);
   }

   public LiveStream setCdn(CdnSettings var1) {
      this.cdn = var1;
      return this;
   }

   public LiveStream setContentDetails(LiveStreamContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public LiveStream setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public LiveStream setId(String var1) {
      this.id = var1;
      return this;
   }

   public LiveStream setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public LiveStream setSnippet(LiveStreamSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public LiveStream setStatus(LiveStreamStatus var1) {
      this.status = var1;
      return this;
   }
}
