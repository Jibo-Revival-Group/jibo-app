package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(a = "deviceEvents")
public class DeviceEvent extends BaseEvent {
   @SerializedName(a = "application")
   private final String mApplication;
   @SerializedName(a = "applicationVersion")
   private final String mApplicationVersion;
   @SerializedName(a = "device")
   private final String mDevice;
   @SerializedName(a = "os")
   private final String mOsVersion;
   @SerializedName(a = "sdk")
   private final String mSdkVersion;

   public DeviceEvent(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      super(var1, var2);
      this.mDevice = var4;
      this.mSdkVersion = var3;
      this.mApplication = var5;
      this.mApplicationVersion = var6;
      this.mOsVersion = var7;
   }
}
