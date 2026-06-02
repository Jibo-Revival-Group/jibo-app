package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ThumbnailDetails extends GenericJson {
   @Key("default")
   private Thumbnail default__;
   @Key
   private Thumbnail high;
   @Key
   private Thumbnail maxres;
   @Key
   private Thumbnail medium;
   @Key
   private Thumbnail standard;

   public ThumbnailDetails clone() {
      return (ThumbnailDetails)super.clone();
   }

   public Thumbnail getDefault() {
      return this.default__;
   }

   public Thumbnail getHigh() {
      return this.high;
   }

   public Thumbnail getMaxres() {
      return this.maxres;
   }

   public Thumbnail getMedium() {
      return this.medium;
   }

   public Thumbnail getStandard() {
      return this.standard;
   }

   public ThumbnailDetails set(String var1, Object var2) {
      return (ThumbnailDetails)super.set(var1, var2);
   }

   public ThumbnailDetails setDefault(Thumbnail var1) {
      this.default__ = var1;
      return this;
   }

   public ThumbnailDetails setHigh(Thumbnail var1) {
      this.high = var1;
      return this;
   }

   public ThumbnailDetails setMaxres(Thumbnail var1) {
      this.maxres = var1;
      return this;
   }

   public ThumbnailDetails setMedium(Thumbnail var1) {
      this.medium = var1;
      return this;
   }

   public ThumbnailDetails setStandard(Thumbnail var1) {
      this.standard = var1;
      return this;
   }
}
