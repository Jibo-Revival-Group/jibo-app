package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
   static final Class<?>[] a = new Class[]{Context.class};
   static final Class<?>[] b = a;
   final Object[] c;
   final Object[] d;
   Context e;
   private Object f;

   public SupportMenuInflater(Context var1) {
      super(var1);
      this.e = var1;
      this.c = new Object[]{var1};
      this.d = this.c;
   }

   private Object a(Object var1) {
      Object var2;
      if (var1 instanceof Activity) {
         var2 = var1;
      } else {
         var2 = var1;
         if (var1 instanceof ContextWrapper) {
            var2 = this.a(((ContextWrapper)var1).getBaseContext());
         }
      }

      return var2;
   }

   private void a(XmlPullParser var1, AttributeSet var2, Menu var3) throws XmlPullParserException, IOException {
      SupportMenuInflater.MenuState var9 = new SupportMenuInflater.MenuState(this, var3);
      int var4 = var1.getEventType();

      while (true) {
         if (var4 == 2) {
            String var10 = var1.getName();
            if (!var10.equals("menu")) {
               throw new RuntimeException("Expecting menu, got " + var10);
            }

            var4 = var1.next();
            break;
         }

         int var5 = var1.next();
         var4 = var5;
         if (var5 == 1) {
            var4 = var5;
            break;
         }
      }

      String var11 = null;
      boolean var7 = false;
      int var6 = var4;
      boolean var14 = false;
      boolean var13 = var7;

      while (!var14) {
         switch (var6) {
            case 1:
               throw new RuntimeException("Unexpected end of document");
            case 2:
               if (!var13) {
                  String var15 = var1.getName();
                  if (var15.equals("group")) {
                     var9.a(var2);
                  } else if (var15.equals("item")) {
                     var9.b(var2);
                  } else if (var15.equals("menu")) {
                     this.a(var1, var2, var9.c());
                  } else {
                     var11 = var15;
                     var13 = true;
                  }
               }
               break;
            case 3:
               String var8 = var1.getName();
               if (var13 && var8.equals(var11)) {
                  var11 = null;
                  var13 = false;
               } else if (var8.equals("group")) {
                  var9.a();
               } else if (var8.equals("item")) {
                  if (!var9.d()) {
                     if (var9.a != null && var9.a.e()) {
                        var9.c();
                     } else {
                        var9.b();
                     }
                  }
               } else if (var8.equals("menu")) {
                  var14 = true;
               }
         }

         var6 = var1.next();
      }
   }

   Object a() {
      if (this.f == null) {
         this.f = this.a(this.e);
      }

      return this.f;
   }

   public void inflate(int param1, Menu param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: instanceof android/support/v4/internal/view/SupportMenu
      // 04: ifne 0e
      // 07: aload 0
      // 08: iload 1
      // 09: aload 2
      // 0a: invokespecial android/view/MenuInflater.inflate (ILandroid/view/Menu;)V
      // 0d: return
      // 0e: aconst_null
      // 0f: astore 3
      // 10: aconst_null
      // 11: astore 5
      // 13: aconst_null
      // 14: astore 4
      // 16: aload 0
      // 17: getfield android/support/v7/view/SupportMenuInflater.e Landroid/content/Context;
      // 1a: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 1d: iload 1
      // 1e: invokevirtual android/content/res/Resources.getLayout (I)Landroid/content/res/XmlResourceParser;
      // 21: astore 6
      // 23: aload 6
      // 25: astore 4
      // 27: aload 6
      // 29: astore 3
      // 2a: aload 6
      // 2c: astore 5
      // 2e: aload 0
      // 2f: aload 6
      // 31: aload 6
      // 33: invokestatic android/util/Xml.asAttributeSet (Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
      // 36: aload 2
      // 37: invokespecial android/support/v7/view/SupportMenuInflater.a (Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
      // 3a: aload 6
      // 3c: ifnull 0d
      // 3f: aload 6
      // 41: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 46: goto 0d
      // 49: astore 5
      // 4b: aload 4
      // 4d: astore 3
      // 4e: new android/view/InflateException
      // 51: astore 2
      // 52: aload 4
      // 54: astore 3
      // 55: aload 2
      // 56: ldc "Error inflating menu XML"
      // 58: aload 5
      // 5a: invokespecial android/view/InflateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 5d: aload 4
      // 5f: astore 3
      // 60: aload 2
      // 61: athrow
      // 62: astore 2
      // 63: aload 3
      // 64: ifnull 6d
      // 67: aload 3
      // 68: invokeinterface android/content/res/XmlResourceParser.close ()V 1
      // 6d: aload 2
      // 6e: athrow
      // 6f: astore 4
      // 71: aload 5
      // 73: astore 3
      // 74: new android/view/InflateException
      // 77: astore 2
      // 78: aload 5
      // 7a: astore 3
      // 7b: aload 2
      // 7c: ldc "Error inflating menu XML"
      // 7e: aload 4
      // 80: invokespecial android/view/InflateException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 83: aload 5
      // 85: astore 3
      // 86: aload 2
      // 87: athrow
      // try (14 -> 20): 37 org/xmlpull/v1/XmlPullParserException
      // try (14 -> 20): 59 java/io/IOException
      // try (14 -> 20): 52 null
      // try (26 -> 32): 37 org/xmlpull/v1/XmlPullParserException
      // try (26 -> 32): 59 java/io/IOException
      // try (26 -> 32): 52 null
      // try (40 -> 42): 52 null
      // try (44 -> 48): 52 null
      // try (50 -> 52): 52 null
      // try (62 -> 64): 52 null
      // try (66 -> 70): 52 null
      // try (72 -> 74): 52 null
   }

   private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
      private static final Class<?>[] a = new Class[]{MenuItem.class};
      private Object b;
      private Method c;

      public InflatedOnMenuItemClickListener(Object var1, String var2) {
         this.b = var1;
         Class var3 = var1.getClass();

         try {
            this.c = var3.getMethod(var2, a);
         } catch (Exception var4) {
            InflateException var5 = new InflateException("Couldn't resolve menu item onClick handler " + var2 + " in class " + var3.getName());
            var5.initCause(var4);
            throw var5;
         }
      }

      public boolean onMenuItemClick(MenuItem var1) {
         boolean var2 = true;

         try {
            if (this.c.getReturnType() == boolean.class) {
               var2 = (Boolean)this.c.invoke(this.b, var1);
            } else {
               this.c.invoke(this.b, var1);
            }

            return var2;
         } catch (Exception var3) {
            throw new RuntimeException(var3);
         }
      }
   }

   private class MenuState {
      private String A;
      private String B;
      private CharSequence C;
      private CharSequence D;
      private ColorStateList E;
      private Mode F;
      ActionProvider a;
      final SupportMenuInflater b;
      private Menu c;
      private int d;
      private int e;
      private int f;
      private int g;
      private boolean h;
      private boolean i;
      private boolean j;
      private int k;
      private int l;
      private CharSequence m;
      private CharSequence n;
      private int o;
      private char p;
      private int q;
      private char r;
      private int s;
      private int t;
      private boolean u;
      private boolean v;
      private boolean w;
      private int x;
      private int y;
      private String z;

      public MenuState(SupportMenuInflater var1, Menu var2) {
         this.b = var1;
         this.E = null;
         this.F = null;
         this.c = var2;
         this.a();
      }

      private char a(String var1) {
         char var2 = 0;
         if (var1 != null) {
            var2 = var1.charAt(0);
         }

         return var2;
      }

      private <T> T a(String var1, Class<?>[] var2, Object[] var3) {
         try {
            Constructor var6 = this.b.e.getClassLoader().loadClass(var1).getConstructor(var2);
            var6.setAccessible(true);
            var7 = var6.newInstance(var3);
         } catch (Exception var4) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + var1, var4);
            return null;
         }

         return (T)var7;
      }

      private void a(MenuItem var1) {
         boolean var2 = true;
         MenuItemImpl var4 = var1.setChecked(this.u).setVisible(this.v).setEnabled(this.w);
         boolean var3;
         if (this.t >= 1) {
            var3 = true;
         } else {
            var3 = false;
         }

         var4.setCheckable(var3).setTitleCondensed(this.n).setIcon(this.o);
         if (this.x >= 0) {
            var1.setShowAsAction(this.x);
         }

         if (this.B != null) {
            if (this.b.e.isRestricted()) {
               throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }

            var1.setOnMenuItemClickListener(new SupportMenuInflater.InflatedOnMenuItemClickListener(this.b.a(), this.B));
         }

         if (var1 instanceof MenuItemImpl) {
            var4 = (MenuItemImpl)var1;
         }

         if (this.t >= 2) {
            if (var1 instanceof MenuItemImpl) {
               ((MenuItemImpl)var1).a(true);
            } else if (var1 instanceof MenuItemWrapperICS) {
               ((MenuItemWrapperICS)var1).a(true);
            }
         }

         if (this.z != null) {
            var1.setActionView(this.a(this.z, SupportMenuInflater.a, this.b.c));
         } else {
            var2 = false;
         }

         if (this.y > 0) {
            if (!var2) {
               var1.setActionView(this.y);
            } else {
               Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
         }

         if (this.a != null) {
            MenuItemCompat.a(var1, this.a);
         }

         MenuItemCompat.a(var1, this.C);
         MenuItemCompat.b(var1, this.D);
         MenuItemCompat.b(var1, this.p, this.q);
         MenuItemCompat.a(var1, this.r, this.s);
         if (this.F != null) {
            MenuItemCompat.a(var1, this.F);
         }

         if (this.E != null) {
            MenuItemCompat.a(var1, this.E);
         }
      }

      public void a() {
         this.d = 0;
         this.e = 0;
         this.f = 0;
         this.g = 0;
         this.h = true;
         this.i = true;
      }

      public void a(AttributeSet var1) {
         TypedArray var2 = this.b.e.obtainStyledAttributes(var1, R.styleable.MenuGroup);
         this.d = var2.getResourceId(R.styleable.MenuGroup_android_id, 0);
         this.e = var2.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
         this.f = var2.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
         this.g = var2.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
         this.h = var2.getBoolean(R.styleable.MenuGroup_android_visible, true);
         this.i = var2.getBoolean(R.styleable.MenuGroup_android_enabled, true);
         var2.recycle();
      }

      public void b() {
         this.j = true;
         this.a(this.c.add(this.d, this.k, this.l, this.m));
      }

      public void b(AttributeSet var1) {
         boolean var3 = true;
         TypedArray var4 = this.b.e.obtainStyledAttributes(var1, R.styleable.MenuItem);
         this.k = var4.getResourceId(R.styleable.MenuItem_android_id, 0);
         this.l = var4.getInt(R.styleable.MenuItem_android_menuCategory, this.e) & -65536
            | var4.getInt(R.styleable.MenuItem_android_orderInCategory, this.f) & 65535;
         this.m = var4.getText(R.styleable.MenuItem_android_title);
         this.n = var4.getText(R.styleable.MenuItem_android_titleCondensed);
         this.o = var4.getResourceId(R.styleable.MenuItem_android_icon, 0);
         this.p = this.a(var4.getString(R.styleable.MenuItem_android_alphabeticShortcut));
         this.q = var4.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
         this.r = this.a(var4.getString(R.styleable.MenuItem_android_numericShortcut));
         this.s = var4.getInt(R.styleable.MenuItem_numericModifiers, 4096);
         if (var4.hasValue(R.styleable.MenuItem_android_checkable)) {
            byte var2;
            if (var4.getBoolean(R.styleable.MenuItem_android_checkable, false)) {
               var2 = 1;
            } else {
               var2 = 0;
            }

            this.t = var2;
         } else {
            this.t = this.g;
         }

         this.u = var4.getBoolean(R.styleable.MenuItem_android_checked, false);
         this.v = var4.getBoolean(R.styleable.MenuItem_android_visible, this.h);
         this.w = var4.getBoolean(R.styleable.MenuItem_android_enabled, this.i);
         this.x = var4.getInt(R.styleable.MenuItem_showAsAction, -1);
         this.B = var4.getString(R.styleable.MenuItem_android_onClick);
         this.y = var4.getResourceId(R.styleable.MenuItem_actionLayout, 0);
         this.z = var4.getString(R.styleable.MenuItem_actionViewClass);
         this.A = var4.getString(R.styleable.MenuItem_actionProviderClass);
         boolean var5;
         if (this.A != null) {
            var5 = var3;
         } else {
            var5 = false;
         }

         if (var5 && this.y == 0 && this.z == null) {
            this.a = this.a(this.A, SupportMenuInflater.b, this.b.d);
         } else {
            if (var5) {
               Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }

            this.a = null;
         }

         this.C = var4.getText(R.styleable.MenuItem_contentDescription);
         this.D = var4.getText(R.styleable.MenuItem_tooltipText);
         if (var4.hasValue(R.styleable.MenuItem_iconTintMode)) {
            this.F = DrawableUtils.a(var4.getInt(R.styleable.MenuItem_iconTintMode, -1), this.F);
         } else {
            this.F = null;
         }

         if (var4.hasValue(R.styleable.MenuItem_iconTint)) {
            this.E = var4.getColorStateList(R.styleable.MenuItem_iconTint);
         } else {
            this.E = null;
         }

         var4.recycle();
         this.j = false;
      }

      public SubMenu c() {
         this.j = true;
         SubMenu var1 = this.c.addSubMenu(this.d, this.k, this.l, this.m);
         this.a(var1.getItem());
         return var1;
      }

      public boolean d() {
         return this.j;
      }
   }
}
