package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import java.util.List;

public final class InvideoPromotion extends GenericJson {
   @Key
   private InvideoTiming defaultTiming;
   @Key
   private List<PromotedItem> items;
   @Key
   private InvideoPosition position;
   @Key
   private Boolean useSmartTiming;

   public InvideoPromotion clone() {
      return (InvideoPromotion)super.clone();
   }

   public InvideoTiming getDefaultTiming() {
      return this.defaultTiming;
   }

   public List<PromotedItem> getItems() {
      return this.items;
   }

   public InvideoPosition getPosition() {
      return this.position;
   }

   public Boolean getUseSmartTiming() {
      return this.useSmartTiming;
   }

   public InvideoPromotion set(String var1, Object var2) {
      return (InvideoPromotion)super.set(var1, var2);
   }

   public InvideoPromotion setDefaultTiming(InvideoTiming var1) {
      this.defaultTiming = var1;
      return this;
   }

   public InvideoPromotion setItems(List<PromotedItem> var1) {
      this.items = var1;
      return this;
   }

   public InvideoPromotion setPosition(InvideoPosition var1) {
      this.position = var1;
      return this;
   }

   public InvideoPromotion setUseSmartTiming(Boolean var1) {
      this.useSmartTiming = var1;
      return this;
   }
}
