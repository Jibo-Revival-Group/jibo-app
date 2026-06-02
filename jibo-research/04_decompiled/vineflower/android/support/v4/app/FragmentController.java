package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class FragmentController {
   private final FragmentHostCallback<?> a;

   private FragmentController(FragmentHostCallback<?> var1) {
      this.a = var1;
   }

   public static FragmentController a(FragmentHostCallback<?> var0) {
      return new FragmentController(var0);
   }

   public Fragment a(String var1) {
      return this.a.d.b(var1);
   }

   public FragmentManager a() {
      return this.a.k();
   }

   public View a(View var1, String var2, Context var3, AttributeSet var4) {
      return this.a.d.onCreateView(var1, var2, var3, var4);
   }

   public void a(Configuration var1) {
      this.a.d.a(var1);
   }

   public void a(Parcelable var1, FragmentManagerNonConfig var2) {
      this.a.d.a(var1, var2);
   }

   public void a(Fragment var1) {
      this.a.d.a(this.a, this.a, var1);
   }

   public void a(boolean var1) {
      this.a.d.a(var1);
   }

   public boolean a(Menu var1) {
      return this.a.d.a(var1);
   }

   public boolean a(Menu var1, MenuInflater var2) {
      return this.a.d.a(var1, var2);
   }

   public boolean a(MenuItem var1) {
      return this.a.d.a(var1);
   }

   public void b() {
      this.a.d.o();
   }

   public void b(Menu var1) {
      this.a.d.b(var1);
   }

   public void b(boolean var1) {
      this.a.d.b(var1);
   }

   public boolean b(MenuItem var1) {
      return this.a.d.b(var1);
   }

   public Parcelable c() {
      return this.a.d.n();
   }

   public FragmentManagerNonConfig d() {
      return this.a.d.l();
   }

   public void e() {
      this.a.d.p();
   }

   public void f() {
      this.a.d.q();
   }

   public void g() {
      this.a.d.r();
   }

   public void h() {
      this.a.d.s();
   }

   public void i() {
      this.a.d.t();
   }

   public void j() {
      this.a.d.u();
   }

   public void k() {
      this.a.d.v();
   }

   public void l() {
      this.a.d.x();
   }

   public void m() {
      this.a.d.y();
   }

   public boolean n() {
      return this.a.d.i();
   }
}
