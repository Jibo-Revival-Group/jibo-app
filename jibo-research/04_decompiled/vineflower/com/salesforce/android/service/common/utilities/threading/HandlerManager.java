package com.salesforce.android.service.common.utilities.threading;

public interface HandlerManager {
   void a();

   void b();

   interface Builder {
      HandlerManager.Builder b(HandlerManager.OnTimerElapsedListener var1);

      HandlerManager b();
   }

   interface OnTimerElapsedListener {
      void b();
   }
}
