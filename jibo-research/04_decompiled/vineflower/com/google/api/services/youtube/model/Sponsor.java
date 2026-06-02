package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Sponsor extends GenericJson {
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private SponsorSnippet snippet;

   public Sponsor clone() {
      return (Sponsor)super.clone();
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

   public SponsorSnippet getSnippet() {
      return this.snippet;
   }

   public Sponsor set(String var1, Object var2) {
      return (Sponsor)super.set(var1, var2);
   }

   public Sponsor setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Sponsor setId(String var1) {
      this.id = var1;
      return this;
   }

   public Sponsor setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Sponsor setSnippet(SponsorSnippet var1) {
      this.snippet = var1;
      return this;
   }
}
