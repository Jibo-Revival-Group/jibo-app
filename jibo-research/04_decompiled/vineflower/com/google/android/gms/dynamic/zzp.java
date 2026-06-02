package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;

public abstract class zzp<T> {
   private final String a;
   private T b;

   protected zzp(String var1) {
      this.a = var1;
   }

   protected final T a(Context var1) throws zzq {
      if (this.b == null) {
         zzbq.a(var1);
         var1 = com.google.android.gms.common.zzp.getRemoteContext(var1);
         if (var1 == null) {
            throw new zzq("Could not get remote context.");
         }

         ClassLoader var6 = var1.getClassLoader();

         try {
            this.b = this.a((IBinder)var6.loadClass(this.a).newInstance());
         } catch (ClassNotFoundException var2) {
            throw new zzq("Could not load creator class.", var2);
         } catch (InstantiationException var3) {
            throw new zzq("Could not instantiate creator.", var3);
         } catch (IllegalAccessException var4) {
            throw new zzq("Could not access creator.", var4);
         }
      }

      return this.b;
   }

   protected abstract T a(IBinder var1);
}
