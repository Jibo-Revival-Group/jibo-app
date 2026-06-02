package com.salesforce.android.service.common.utilities.threading;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
   private final int a;

   public PriorityThreadFactory(int var1) {
      this.a = var1;
   }

   public static PriorityThreadFactory a() {
      return new PriorityThreadFactory(10);
   }

   @Override
   public Thread newThread(Runnable var1) {
      var1 = new Thread(var1);
      var1.setPriority(this.a);
      return var1;
   }
}
