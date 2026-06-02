package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class Subscription extends GenericJson {
   @Key
   private SubscriptionContentDetails contentDetails;
   @Key
   private String etag;
   @Key
   private String id;
   @Key
   private String kind;
   @Key
   private SubscriptionSnippet snippet;
   @Key
   private SubscriptionSubscriberSnippet subscriberSnippet;

   public Subscription clone() {
      return (Subscription)super.clone();
   }

   public SubscriptionContentDetails getContentDetails() {
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

   public SubscriptionSnippet getSnippet() {
      return this.snippet;
   }

   public SubscriptionSubscriberSnippet getSubscriberSnippet() {
      return this.subscriberSnippet;
   }

   public Subscription set(String var1, Object var2) {
      return (Subscription)super.set(var1, var2);
   }

   public Subscription setContentDetails(SubscriptionContentDetails var1) {
      this.contentDetails = var1;
      return this;
   }

   public Subscription setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public Subscription setId(String var1) {
      this.id = var1;
      return this;
   }

   public Subscription setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public Subscription setSnippet(SubscriptionSnippet var1) {
      this.snippet = var1;
      return this;
   }

   public Subscription setSubscriberSnippet(SubscriptionSubscriberSnippet var1) {
      this.subscriberSnippet = var1;
      return this;
   }
}
