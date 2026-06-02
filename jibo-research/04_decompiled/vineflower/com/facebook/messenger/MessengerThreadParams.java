package com.facebook.messenger;

import java.util.List;

public class MessengerThreadParams {
   public final String metadata;
   public final MessengerThreadParams.Origin origin;
   public final List<String> participants;
   public final String threadToken;

   public MessengerThreadParams(MessengerThreadParams.Origin var1, String var2, String var3, List<String> var4) {
      this.threadToken = var2;
      this.metadata = var3;
      this.participants = var4;
      this.origin = var1;
   }

   public enum Origin {
      COMPOSE_FLOW,
      REPLY_FLOW,
      UNKNOWN;

      private static final MessengerThreadParams.Origin[] $VALUES = new MessengerThreadParams.Origin[]{
         MessengerThreadParams.Origin.REPLY_FLOW, MessengerThreadParams.Origin.COMPOSE_FLOW, MessengerThreadParams.Origin.UNKNOWN
      };
   }
}
