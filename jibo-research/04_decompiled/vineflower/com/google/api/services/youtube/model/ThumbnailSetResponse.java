package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import java.util.List;

public final class ThumbnailSetResponse extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<ThumbnailDetails> items;
   @Key
   private String kind;
   @Key
   private String visitorId;

   static {
      Data.nullOf(ThumbnailDetails.class);
   }

   public ThumbnailSetResponse clone() {
      return (ThumbnailSetResponse)super.clone();
   }

   public String getEtag() {
      return this.etag;
   }

   public String getEventId() {
      return this.eventId;
   }

   public List<ThumbnailDetails> getItems() {
      return this.items;
   }

   public String getKind() {
      return this.kind;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public ThumbnailSetResponse set(String var1, Object var2) {
      return (ThumbnailSetResponse)super.set(var1, var2);
   }

   public ThumbnailSetResponse setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public ThumbnailSetResponse setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

   public ThumbnailSetResponse setItems(List<ThumbnailDetails> var1) {
      this.items = var1;
      return this;
   }

   public ThumbnailSetResponse setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public ThumbnailSetResponse setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }
}
