package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Key;

public final class SponsorSnippet extends GenericJson {
   @Key
   private String channelId;
   @Key
   private ChannelProfileDetails sponsorDetails;
   @Key
   private DateTime sponsorSince;

   public SponsorSnippet clone() {
      return (SponsorSnippet)super.clone();
   }

   public String getChannelId() {
      return this.channelId;
   }

   public ChannelProfileDetails getSponsorDetails() {
      return this.sponsorDetails;
   }

   public DateTime getSponsorSince() {
      return this.sponsorSince;
   }

   public SponsorSnippet set(String var1, Object var2) {
      return (SponsorSnippet)super.set(var1, var2);
   }

   public SponsorSnippet setChannelId(String var1) {
      this.channelId = var1;
      return this;
   }

   public SponsorSnippet setSponsorDetails(ChannelProfileDetails var1) {
      this.sponsorDetails = var1;
      return this;
   }

   public SponsorSnippet setSponsorSince(DateTime var1) {
      this.sponsorSince = var1;
      return this;
   }
}
