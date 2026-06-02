package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class InvideoTiming extends GenericJson {
   @JsonString
   @Key
   private BigInteger durationMs;
   @JsonString
   @Key
   private BigInteger offsetMs;
   @Key
   private String type;

   public InvideoTiming clone() {
      return (InvideoTiming)super.clone();
   }

   public BigInteger getDurationMs() {
      return this.durationMs;
   }

   public BigInteger getOffsetMs() {
      return this.offsetMs;
   }

   public String getType() {
      return this.type;
   }

   public InvideoTiming set(String var1, Object var2) {
      return (InvideoTiming)super.set(var1, var2);
   }

   public InvideoTiming setDurationMs(BigInteger var1) {
      this.durationMs = var1;
      return this;
   }

   public InvideoTiming setOffsetMs(BigInteger var1) {
      this.offsetMs = var1;
      return this;
   }

   public InvideoTiming setType(String var1) {
      this.type = var1;
      return this;
   }
}
