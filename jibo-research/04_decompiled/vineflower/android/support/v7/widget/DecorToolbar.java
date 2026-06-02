package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemSelectedListener;

public interface DecorToolbar {
   ViewPropertyAnimatorCompat a(int var1, long var2);

   ViewGroup a();

   void a(int var1);

   void a(Drawable var1);

   void a(MenuPresenter.Callback var1, MenuBuilder.Callback var2);

   void a(ScrollingTabContainerView var1);

   void a(Menu var1, MenuPresenter.Callback var2);

   void a(View var1);

   void a(Callback var1);

   void a(SpinnerAdapter var1, OnItemSelectedListener var2);

   void a(CharSequence var1);

   void a(boolean var1);

   Context b();

   void b(int var1);

   void b(Drawable var1);

   void b(CharSequence var1);

   void b(boolean var1);

   void c(int var1);

   void c(Drawable var1);

   void c(CharSequence var1);

   boolean c();

   void d();

   void d(int var1);

   void d(Drawable var1);

   void d(CharSequence var1);

   CharSequence e();

   void e(int var1);

   CharSequence f();

   void f(int var1);

   void g();

   void g(int var1);

   void h();

   void h(int var1);

   boolean i();

   boolean j();

   boolean k();

   boolean l();

   boolean m();

   void n();

   void o();

   int p();

   boolean q();

   int r();

   int s();

   int t();

   View u();

   int v();

   int w();

   Menu x();
}
