package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class VideoProcessingDetailsProcessingProgress extends GenericJson {
   @JsonString
   @Key
   private BigInteger partsProcessed;
   @JsonString
   @Key
   private BigInteger partsTotal;
   @JsonString
   @Key
   private BigInteger timeLeftMs;

   public VideoProcessingDetailsProcessingProgress clone() {
      return (VideoProcessingDetailsProcessingProgress)super.clone();
   }

   public BigInteger getPartsProcessed() {
      return this.partsProcessed;
   }

   public BigInteger getPartsTotal() {
      return this.partsTotal;
   }

   public BigInteger getTimeLeftMs() {
      return this.timeLeftMs;
   }

   public VideoProcessingDetailsProcessingProgress set(String var1, Object var2) {
      return (VideoProcessingDetailsProcessingProgress)super.set(var1, var2);
   }

   public VideoProcessingDetailsProcessingProgress setPartsProcessed(BigInteger var1) {
      this.partsProcessed = var1;
      return this;
   }

   public VideoProcessingDetailsProcessingProgress setPartsTotal(BigInteger var1) {
      this.partsTotal = var1;
      return this;
   }

   public VideoProcessingDetailsProcessingProgress setTimeLeftMs(BigInteger var1) {
      this.timeLeftMs = var1;
      return this;
   }
}
