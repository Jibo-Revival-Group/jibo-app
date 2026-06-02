package com.google.api.services.youtube.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public final class ChannelAuditDetails extends GenericJson {
   @Key
   private Boolean communityGuidelinesGoodStanding;
   @Key
   private Boolean contentIdClaimsGoodStanding;
   @Key
   private Boolean copyrightStrikesGoodStanding;
   @Key
   private Boolean overallGoodStanding;

   public ChannelAuditDetails clone() {
      return (ChannelAuditDetails)super.clone();
   }

   public Boolean getCommunityGuidelinesGoodStanding() {
      return this.communityGuidelinesGoodStanding;
   }

   public Boolean getContentIdClaimsGoodStanding() {
      return this.contentIdClaimsGoodStanding;
   }

   public Boolean getCopyrightStrikesGoodStanding() {
      return this.copyrightStrikesGoodStanding;
   }

   public Boolean getOverallGoodStanding() {
      return this.overallGoodStanding;
   }

   public ChannelAuditDetails set(String var1, Object var2) {
      return (ChannelAuditDetails)super.set(var1, var2);
   }

   public ChannelAuditDetails setCommunityGuidelinesGoodStanding(Boolean var1) {
      this.communityGuidelinesGoodStanding = var1;
      return this;
   }

   public ChannelAuditDetails setContentIdClaimsGoodStanding(Boolean var1) {
      this.contentIdClaimsGoodStanding = var1;
      return this;
   }

   public ChannelAuditDetails setCopyrightStrikesGoodStanding(Boolean var1) {
      this.copyrightStrikesGoodStanding = var1;
      return this;
   }

   public ChannelAuditDetails setOverallGoodStanding(Boolean var1) {
      this.overallGoodStanding = var1;
      return this;
   }
}
