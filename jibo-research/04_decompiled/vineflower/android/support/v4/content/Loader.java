package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
   int n;
   Loader.OnLoadCompleteListener<D> o;
   Loader.OnLoadCanceledListener<D> p;
   Context q;
   boolean r = false;
   boolean s = false;
   boolean t = true;
   boolean u = false;
   boolean v = false;

   public Loader(Context var1) {
      this.q = var1.getApplicationContext();
   }

   public void A() {
      if (this.v) {
         this.B();
      }
   }

   public void B() {
      if (this.r) {
         this.t();
      } else {
         this.u = true;
      }
   }

   protected void a() {
   }

   public void a(int var1, Loader.OnLoadCompleteListener<D> var2) {
      if (this.o != null) {
         throw new IllegalStateException("There is already a listener registered");
      }

      this.o = var2;
      this.n = var1;
   }

   public void a(Loader.OnLoadCompleteListener<D> var1) {
      if (this.o == null) {
         throw new IllegalStateException("No listener register");
      }

      if (this.o != var1) {
         throw new IllegalArgumentException("Attempting to unregister the wrong listener");
      }

      this.o = null;
   }

   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.print(var1);
      var3.print("mId=");
      var3.print(this.n);
      var3.print(" mListener=");
      var3.println(this.o);
      if (this.r || this.u || this.v) {
         var3.print(var1);
         var3.print("mStarted=");
         var3.print(this.r);
         var3.print(" mContentChanged=");
         var3.print(this.u);
         var3.print(" mProcessingChange=");
         var3.println(this.v);
      }

      if (this.s || this.t) {
         var3.print(var1);
         var3.print("mAbandoned=");
         var3.print(this.s);
         var3.print(" mReset=");
         var3.println(this.t);
      }
   }

   public void b(D var1) {
      if (this.o != null) {
         this.o.a(this, (D)var1);
      }
   }

   protected boolean b() {
      return false;
   }

   public String c(D var1) {
      StringBuilder var2 = new StringBuilder(64);
      DebugUtils.a(var1, var2);
      var2.append("}");
      return var2.toString();
   }

   protected void i() {
   }

   protected void j() {
   }

   protected void k() {
   }

   public void l() {
      if (this.p != null) {
         this.p.a(this);
      }
   }

   public Context m() {
      return this.q;
   }

   public int n() {
      return this.n;
   }

   public boolean o() {
      return this.r;
   }

   public boolean p() {
      return this.s;
   }

   public boolean q() {
      return this.t;
   }

   public final void r() {
      this.r = true;
      this.t = false;
      this.s = false;
      this.i();
   }

   public boolean s() {
      return this.b();
   }

   public void t() {
      this.a();
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(64);
      DebugUtils.a(this, var1);
      var1.append(" id=");
      var1.append(this.n);
      var1.append("}");
      return var1.toString();
   }

   public void u() {
      this.r = false;
      this.j();
   }

   public void v() {
      this.s = true;
      this.w();
   }

   protected void w() {
   }

   public void x() {
      this.k();
      this.t = true;
      this.r = false;
      this.s = false;
      this.u = false;
      this.v = false;
   }

   public boolean y() {
      boolean var1 = this.u;
      this.u = false;
      this.v |= var1;
      return var1;
   }

   public void z() {
      this.v = false;
   }

   public final class ForceLoadContentObserver extends ContentObserver {
      final Loader a;

      public ForceLoadContentObserver(Loader var1) {
         super(new Handler());
         this.a = var1;
      }

      public boolean deliverSelfNotifications() {
         return true;
      }

      public void onChange(boolean var1) {
         this.a.B();
      }
   }

   public interface OnLoadCanceledListener<D> {
      void a(Loader<D> var1);
   }

   public interface OnLoadCompleteListener<D> {
      void a(Loader<D> var1, D var2);
   }
}
