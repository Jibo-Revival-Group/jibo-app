package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class zzbha implements Executor {
   private final Handler a;

   public zzbha(Looper var1) {
      this.a = new Handler(var1);
   }

   @Override
   public final void execute(Runnable var1) {
      this.a.post(var1);
   }
}
