package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors {
   public static final Executor a = new TaskExecutors.zza();
   static final Executor b = new zzm();

   static final class zza implements Executor {
      private final Handler a = new Handler(Looper.getMainLooper());

      public zza() {
      }

      @Override
      public final void execute(Runnable var1) {
         this.a.post(var1);
      }
   }
}
