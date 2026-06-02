package com.salesforce.android.service.common.liveagentclient.response;

import com.google.gson.annotations.SerializedName;

public class CreateSessionResponse {
   @SerializedName(a = "affinityToken")
   private String mAffinityToken;
   @SerializedName(a = "clientPollTimeout")
   private long mClientPollingTimeoutSeconds;
   @SerializedName(a = "id")
   private String mSessionId;
   @SerializedName(a = "key")
   private String mSessionKey;

   public String a() {
      return this.mSessionId;
   }

   public String b() {
      return this.mAffinityToken;
   }

   public String c() {
      return this.mSessionKey;
   }

   public long d() {
      return this.mClientPollingTimeoutSeconds * 1000L;
   }
}
