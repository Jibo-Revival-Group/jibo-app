package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.utilities.spatial.Orientation;

@BatchedEvent(a = "orientationEvents")
public class OrientationEvent extends BaseEvent {
   @SerializedName(a = "orientation")
   private final String mOrientation;

   public OrientationEvent(String var1, String var2, Orientation var3) {
      super(var1, var2);
      if (var3.b()) {
         this.mOrientation = "LANDSCAPE_LEFT";
      } else if (var3.a()) {
         this.mOrientation = "PORTRAIT";
      } else {
         this.mOrientation = "UNDEFINED";
      }
   }
}
