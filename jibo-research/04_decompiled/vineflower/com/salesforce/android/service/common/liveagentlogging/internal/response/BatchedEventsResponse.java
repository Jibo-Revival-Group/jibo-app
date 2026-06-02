package com.salesforce.android.service.common.liveagentlogging.internal.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Locale;

public class BatchedEventsResponse {
   @SerializedName(a = "messages")
   private List<Object> mMessages;

   @Override
   public String toString() {
      return String.format(Locale.getDefault(), "%s: %s", this.getClass().getSimpleName(), this.mMessages.toString());
   }
}
