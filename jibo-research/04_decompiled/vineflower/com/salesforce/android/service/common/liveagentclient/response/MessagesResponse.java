package com.salesforce.android.service.common.liveagentclient.response;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.util.Arrays;
import java.util.List;

public class MessagesResponse {
   public static final MessagesResponse a = new MessagesResponse(0);
   @SerializedName(a = "messages")
   private List<LiveAgentMessage> mMessages;
   @SerializedName(a = "sequence")
   private Integer mSequence;

   public MessagesResponse(Integer var1, LiveAgentMessage... var2) {
      this.mMessages = Arrays.asList(var2);
      this.mSequence = var1;
   }

   public List<LiveAgentMessage> a() {
      return this.mMessages;
   }
}
