package com.salesforce.android.service.common.utilities.internal.android;

import android.os.Build;
import android.os.Build.VERSION;

public class AndroidInfo {
   public String a() {
      return Build.MANUFACTURER;
   }

   public String b() {
      return Build.MODEL;
   }

   public String c() {
      return VERSION.RELEASE;
   }
}
