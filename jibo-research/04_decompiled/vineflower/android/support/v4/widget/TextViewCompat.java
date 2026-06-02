package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.os.BuildCompat;
import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

public final class TextViewCompat {
   static final TextViewCompat.TextViewCompatBaseImpl a;

   static {
      if (BuildCompat.a()) {
         a = new TextViewCompat.TextViewCompatApi27Impl();
      } else if (VERSION.SDK_INT >= 26) {
         a = new TextViewCompat.TextViewCompatApi26Impl();
      } else if (VERSION.SDK_INT >= 23) {
         a = new TextViewCompat.TextViewCompatApi23Impl();
      } else if (VERSION.SDK_INT >= 18) {
         a = new TextViewCompat.TextViewCompatApi18Impl();
      } else if (VERSION.SDK_INT >= 17) {
         a = new TextViewCompat.TextViewCompatApi17Impl();
      } else if (VERSION.SDK_INT >= 16) {
         a = new TextViewCompat.TextViewCompatApi16Impl();
      } else {
         a = new TextViewCompat.TextViewCompatBaseImpl();
      }
   }

   public static int a(TextView var0) {
      return a.a(var0);
   }

   public static void a(TextView var0, int var1) {
      a.a(var0, var1);
   }

   public static void a(TextView var0, Drawable var1, Drawable var2, Drawable var3, Drawable var4) {
      a.a(var0, var1, var2, var3, var4);
   }

   public static Drawable[] b(TextView var0) {
      return a.b(var0);
   }

   static class TextViewCompatApi16Impl extends TextViewCompat.TextViewCompatBaseImpl {
      @Override
      public int a(TextView var1) {
         return var1.getMaxLines();
      }
   }

   static class TextViewCompatApi17Impl extends TextViewCompat.TextViewCompatApi16Impl {
      @Override
      public void a(TextView var1, Drawable var2, Drawable var3, Drawable var4, Drawable var5) {
         boolean var6;
         if (var1.getLayoutDirection() == 1) {
            var6 = true;
         } else {
            var6 = false;
         }

         Drawable var7;
         if (var6) {
            var7 = var4;
         } else {
            var7 = var2;
         }

         if (!var6) {
            var2 = var4;
         }

         var1.setCompoundDrawables(var7, var3, var2, var5);
      }

      @Override
      public Drawable[] b(TextView var1) {
         boolean var2 = true;
         if (var1.getLayoutDirection() != 1) {
            var2 = false;
         }

         Drawable[] var3 = var1.getCompoundDrawables();
         if (var2) {
            Drawable var4 = var3[2];
            Drawable var5 = var3[0];
            var3[0] = var4;
            var3[2] = var5;
         }

         return var3;
      }
   }

   static class TextViewCompatApi18Impl extends TextViewCompat.TextViewCompatApi17Impl {
      @Override
      public void a(TextView var1, Drawable var2, Drawable var3, Drawable var4, Drawable var5) {
         var1.setCompoundDrawablesRelative(var2, var3, var4, var5);
      }

      @Override
      public Drawable[] b(TextView var1) {
         return var1.getCompoundDrawablesRelative();
      }
   }

   static class TextViewCompatApi23Impl extends TextViewCompat.TextViewCompatApi18Impl {
      @Override
      public void a(TextView var1, int var2) {
         var1.setTextAppearance(var2);
      }
   }

   static class TextViewCompatApi26Impl extends TextViewCompat.TextViewCompatApi23Impl {
   }

   static class TextViewCompatApi27Impl extends TextViewCompat.TextViewCompatApi26Impl {
   }

   static class TextViewCompatBaseImpl {
      private static Field a;
      private static boolean b;
      private static Field c;
      private static boolean d;

      private static int a(Field var0, TextView var1) {
         int var2;
         try {
            var2 = var0.getInt(var1);
         } catch (IllegalAccessException var3) {
            Log.d("TextViewCompatBase", "Could not retrieve value of " + var0.getName() + " field.");
            var2 = -1;
         }

         return var2;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private static Field a(String var0) {
         Field var1 = null;

         Field var2;
         try {
            var2 = TextView.class.getDeclaredField(var0);
         } catch (NoSuchFieldException var4) {
            Log.e("TextViewCompatBase", "Could not retrieve " + var0 + " field.");
            return var1;
         }

         var1 = var2;

         try {
            var2.setAccessible(true);
         } catch (NoSuchFieldException var3) {
            Log.e("TextViewCompatBase", "Could not retrieve " + var0 + " field.");
            return var1;
         }

         return var2;
      }

      public int a(TextView var1) {
         if (!d) {
            c = a("mMaxMode");
            d = true;
         }

         if (c != null && a(c, var1) == 1) {
            if (!b) {
               a = a("mMaximum");
               b = true;
            }

            if (a != null) {
               return a(a, var1);
            }
         }

         return -1;
      }

      public void a(TextView var1, int var2) {
         var1.setTextAppearance(var1.getContext(), var2);
      }

      public void a(TextView var1, Drawable var2, Drawable var3, Drawable var4, Drawable var5) {
         var1.setCompoundDrawables(var2, var3, var4, var5);
      }

      public Drawable[] b(TextView var1) {
         return var1.getCompoundDrawables();
      }
   }
}
