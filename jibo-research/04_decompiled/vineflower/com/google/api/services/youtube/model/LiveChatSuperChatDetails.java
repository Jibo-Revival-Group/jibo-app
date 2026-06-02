package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;
import com.google.api.client.util.Key;
import java.math.BigInteger;

public final class LiveChatSuperChatDetails extends GenericJson {
   @Key
   private String amountDisplayString;
   @JsonString
   @Key
   private BigInteger amountMicros;
   @Key
   private String currency;
   @Key
   private Long tier;
   @Key
   private String userComment;

   public LiveChatSuperChatDetails clone() {
      return (LiveChatSuperChatDetails)super.clone();
   }

   public String getAmountDisplayString() {
      return this.amountDisplayString;
   }

   public BigInteger getAmountMicros() {
      return this.amountMicros;
   }

   public String getCurrency() {
      return this.currency;
   }

   public Long getTier() {
      return this.tier;
   }

   public String getUserComment() {
      return this.userComment;
   }

   public LiveChatSuperChatDetails set(String var1, Object var2) {
      return (LiveChatSuperChatDetails)super.set(var1, var2);
   }

   public LiveChatSuperChatDetails setAmountDisplayString(String var1) {
      this.amountDisplayString = var1;
      return this;
   }

   public LiveChatSuperChatDetails setAmountMicros(BigInteger var1) {
      this.amountMicros = var1;
      return this;
   }

   public LiveChatSuperChatDetails setCurrency(String var1) {
      this.currency = var1;
      return this;
   }

   public LiveChatSuperChatDetails setTier(Long var1) {
      this.tier = var1;
      return this;
   }

   public LiveChatSuperChatDetails setUserComment(String var1) {
      this.userComment = var1;
      return this;
   }
}
