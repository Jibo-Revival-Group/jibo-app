package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zza implements ServiceConnection {
   private boolean a = false;
   private final BlockingQueue<IBinder> b = new LinkedBlockingQueue<>();

   public final IBinder a() throws InterruptedException {
      zzbq.c("BlockingServiceConnection.getService() called on main thread");
      if (this.a) {
         throw new IllegalStateException("Cannot call get on this connection more than once");
      }

      this.a = true;
      return this.b.take();
   }

   public final IBinder a(long var1, TimeUnit var3) throws InterruptedException, TimeoutException {
      zzbq.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
      if (this.a) {
         throw new IllegalStateException("Cannot call get on this connection more than once");
      } else {
         this.a = true;
         IBinder var4 = this.b.poll(10000L, var3);
         if (var4 == null) {
            throw new TimeoutException("Timed out waiting for the service connection");
         } else {
            return var4;
         }
      }
   }

   public final void onServiceConnected(ComponentName var1, IBinder var2) {
      this.b.add(var2);
   }

   public final void onServiceDisconnected(ComponentName var1) {
   }
}
