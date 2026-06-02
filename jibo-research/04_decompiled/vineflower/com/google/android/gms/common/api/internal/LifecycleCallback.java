package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
   protected final zzcf a;

   protected LifecycleCallback(zzcf var1) {
      this.a = var1;
   }

   protected static zzcf a(zzce var0) {
      zzcf var1;
      if (var0.a()) {
         var1 = zzdb.a(var0.d());
      } else {
         if (!var0.b()) {
            throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
         }

         var1 = zzcg.a(var0.c());
      }

      return var1;
   }

   @Keep
   private static zzcf getChimeraLifecycleFragmentImpl(zzce var0) {
      throw new IllegalStateException("Method not available in SDK.");
   }

   public final Activity a() {
      return this.a.a();
   }

   public void a(int var1, int var2, Intent var3) {
   }

   public void a(Bundle var1) {
   }

   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
   }

   public void b() {
   }

   public void b(Bundle var1) {
   }

   public void c() {
   }

   public void d() {
   }

   public void e() {
   }
}
