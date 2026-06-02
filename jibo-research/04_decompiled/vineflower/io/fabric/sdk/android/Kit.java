package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Task;
import java.io.File;
import java.util.Collection;

public abstract class Kit<Result> implements Comparable<Kit> {
   Fabric e;
   InitializationTask<Result> f = new InitializationTask<>(this);
   Context g;
   InitializationCallback<Result> h;
   IdManager i;
   final DependsOn j = this.getClass().getAnnotation(DependsOn.class);

   public int a(Kit var1) {
      byte var2 = 1;
      if (!this.b(var1)) {
         if (var1.b(this)) {
            var2 = -1;
         } else if (!this.u() || var1.u()) {
            if (!this.u() && var1.u()) {
               var2 = -1;
            } else {
               var2 = 0;
            }
         }
      }

      return var2;
   }

   public abstract String a();

   void a(Context var1, Fabric var2, InitializationCallback<Result> var3, IdManager var4) {
      this.e = var2;
      this.g = new FabricContext(var1, this.b(), this.t());
      this.h = var3;
      this.i = var4;
   }

   protected void a(Result var1) {
   }

   protected boolean a_() {
      return true;
   }

   public abstract String b();

   protected void b(Result var1) {
   }

   boolean b(Kit var1) {
      boolean var5 = false;
      boolean var4 = var5;
      if (this.u()) {
         Class[] var6 = this.j.a();
         int var3 = var6.length;
         int var2 = 0;

         while (true) {
            var4 = var5;
            if (var2 >= var3) {
               break;
            }

            if (var6[var2].isAssignableFrom(var1.getClass())) {
               var4 = true;
               break;
            }

            var2++;
         }
      }

      return var4;
   }

   protected abstract Result f();

   final void p() {
      this.f.a(this.e.f(), (Void)null);
   }

   protected IdManager q() {
      return this.i;
   }

   public Context r() {
      return this.g;
   }

   public Fabric s() {
      return this.e;
   }

   public String t() {
      return ".Fabric" + File.separator + this.b();
   }

   boolean u() {
      boolean var1;
      if (this.j != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected Collection<Task> v() {
      return this.f.c();
   }
}
