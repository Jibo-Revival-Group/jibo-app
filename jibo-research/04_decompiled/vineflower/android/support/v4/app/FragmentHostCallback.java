package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
   private final Activity a;
   final Context b;
   final int c;
   final FragmentManagerImpl d = new FragmentManagerImpl();
   private final Handler e;

   FragmentHostCallback(Activity var1, Context var2, Handler var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.e = var3;
      this.c = var4;
   }

   FragmentHostCallback(FragmentActivity var1) {
      this(var1, var1, var1.mHandler, 0);
   }

   @Override
   public View a(int var1) {
      return null;
   }

   public void a(Fragment var1, Intent var2, int var3, Bundle var4) {
      if (var3 != -1) {
         throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
      }

      this.b.startActivity(var2);
   }

   public void a(Fragment var1, IntentSender var2, int var3, Intent var4, int var5, int var6, int var7, Bundle var8) throws SendIntentException {
      if (var3 != -1) {
         throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
      }

      ActivityCompat.a(this.a, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(Fragment var1, String[] var2, int var3) {
   }

   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
   }

   @Override
   public boolean a() {
      return true;
   }

   public boolean a(Fragment var1) {
      return true;
   }

   public boolean a(String var1) {
      return false;
   }

   public LayoutInflater b() {
      return LayoutInflater.from(this.b);
   }

   void b(Fragment var1) {
   }

   public void d() {
   }

   public boolean e() {
      return true;
   }

   public int f() {
      return this.c;
   }

   public abstract E g();

   Activity h() {
      return this.a;
   }

   Context i() {
      return this.b;
   }

   Handler j() {
      return this.e;
   }

   FragmentManagerImpl k() {
      return this.d;
   }
}
