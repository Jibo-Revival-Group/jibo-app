package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
   private static final CompoundButtonCompat.CompoundButtonCompatBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 23) {
         a = new CompoundButtonCompat.CompoundButtonCompatApi23Impl();
      } else if (VERSION.SDK_INT >= 21) {
         a = new CompoundButtonCompat.CompoundButtonCompatApi21Impl();
      } else {
         a = new CompoundButtonCompat.CompoundButtonCompatBaseImpl();
      }
   }

   public static Drawable a(CompoundButton var0) {
      return a.a(var0);
   }

   public static void a(CompoundButton var0, ColorStateList var1) {
      a.a(var0, var1);
   }

   public static void a(CompoundButton var0, Mode var1) {
      a.a(var0, var1);
   }

   static class CompoundButtonCompatApi21Impl extends CompoundButtonCompat.CompoundButtonCompatBaseImpl {
      @Override
      public void a(CompoundButton var1, ColorStateList var2) {
         var1.setButtonTintList(var2);
      }

      @Override
      public void a(CompoundButton var1, Mode var2) {
         var1.setButtonTintMode(var2);
      }
   }

   static class CompoundButtonCompatApi23Impl extends CompoundButtonCompat.CompoundButtonCompatApi21Impl {
      @Override
      public Drawable a(CompoundButton var1) {
         return var1.getButtonDrawable();
      }
   }

   static class CompoundButtonCompatBaseImpl {
      private static Field a;
      private static boolean b;

      public Drawable a(CompoundButton var1) {
         if (!b) {
            try {
               a = CompoundButton.class.getDeclaredField("mButtonDrawable");
               a.setAccessible(true);
            } catch (NoSuchFieldException var3) {
               Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", var3);
            }

            b = true;
         }

         if (a != null) {
            try {
               return (Drawable)a.get(var1);
            } catch (IllegalAccessException var4) {
               Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", var4);
               a = null;
            }
         }

         return null;
      }

      public void a(CompoundButton var1, ColorStateList var2) {
         if (var1 instanceof TintableCompoundButton) {
            ((TintableCompoundButton)var1).setSupportButtonTintList(var2);
         }
      }

      public void a(CompoundButton var1, Mode var2) {
         if (var1 instanceof TintableCompoundButton) {
            ((TintableCompoundButton)var1).setSupportButtonTintMode(var2);
         }
      }
   }
}
