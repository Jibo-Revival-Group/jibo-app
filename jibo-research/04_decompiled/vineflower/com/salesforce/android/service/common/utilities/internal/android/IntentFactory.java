package com.salesforce.android.service.common.utilities.internal.android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class IntentFactory {
   public Intent a(Context var1, Class<?> var2) {
      return new Intent(var1, var2);
   }

   public IntentFilter a(String var1) {
      return new IntentFilter(var1);
   }
}
