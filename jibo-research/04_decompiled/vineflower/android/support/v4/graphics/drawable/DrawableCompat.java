package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
   private static Method a;
   private static boolean b;
   private static Method c;
   private static boolean d;

   @Deprecated
   public static void a(Drawable var0) {
      var0.jumpToCurrentState();
   }

   public static void a(Drawable var0, float var1, float var2) {
      if (VERSION.SDK_INT >= 21) {
         var0.setHotspot(var1, var2);
      }
   }

   public static void a(Drawable var0, int var1) {
      if (VERSION.SDK_INT >= 21) {
         var0.setTint(var1);
      } else if (var0 instanceof TintAwareDrawable) {
         ((TintAwareDrawable)var0).setTint(var1);
      }
   }

   public static void a(Drawable var0, int var1, int var2, int var3, int var4) {
      if (VERSION.SDK_INT >= 21) {
         var0.setHotspotBounds(var1, var2, var3, var4);
      }
   }

   public static void a(Drawable var0, ColorStateList var1) {
      if (VERSION.SDK_INT >= 21) {
         var0.setTintList(var1);
      } else if (var0 instanceof TintAwareDrawable) {
         ((TintAwareDrawable)var0).setTintList(var1);
      }
   }

   public static void a(Drawable var0, Theme var1) {
      if (VERSION.SDK_INT >= 21) {
         var0.applyTheme(var1);
      }
   }

   public static void a(Drawable var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      if (VERSION.SDK_INT >= 21) {
         var0.inflate(var1, var2, var3, var4);
      } else {
         var0.inflate(var1, var2, var3);
      }
   }

   public static void a(Drawable var0, Mode var1) {
      if (VERSION.SDK_INT >= 21) {
         var0.setTintMode(var1);
      } else if (var0 instanceof TintAwareDrawable) {
         ((TintAwareDrawable)var0).setTintMode(var1);
      }
   }

   public static void a(Drawable var0, boolean var1) {
      if (VERSION.SDK_INT >= 19) {
         var0.setAutoMirrored(var1);
      }
   }

   public static boolean b(Drawable var0) {
      boolean var1;
      if (VERSION.SDK_INT >= 19) {
         var1 = var0.isAutoMirrored();
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean b(Drawable var0, int var1) {
      boolean var2 = true;
      if (VERSION.SDK_INT >= 23) {
         var2 = var0.setLayoutDirection(var1);
      } else if (VERSION.SDK_INT >= 17) {
         if (!b) {
            try {
               a = Drawable.class.getDeclaredMethod("setLayoutDirection", int.class);
               a.setAccessible(true);
            } catch (NoSuchMethodException var4) {
               Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", var4);
            }

            b = true;
         }

         if (a != null) {
            try {
               a.invoke(var0, var1);
               return var2;
            } catch (Exception var5) {
               Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", var5);
               a = null;
            }
         }

         var2 = false;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static int c(Drawable var0) {
      int var1;
      if (VERSION.SDK_INT >= 19) {
         var1 = var0.getAlpha();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public static boolean d(Drawable var0) {
      boolean var1;
      if (VERSION.SDK_INT >= 21) {
         var1 = var0.canApplyTheme();
      } else {
         var1 = false;
      }

      return var1;
   }

   public static ColorFilter e(Drawable var0) {
      ColorFilter var1;
      if (VERSION.SDK_INT >= 21) {
         var1 = var0.getColorFilter();
      } else {
         var1 = null;
      }

      return var1;
   }

   public static void f(Drawable var0) {
      if (VERSION.SDK_INT >= 23) {
         var0.clearColorFilter();
      } else if (VERSION.SDK_INT >= 21) {
         var0.clearColorFilter();
         if (var0 instanceof InsetDrawable) {
            f(((InsetDrawable)var0).getDrawable());
         } else if (var0 instanceof WrappedDrawable) {
            f(((WrappedDrawable)var0).a());
         } else if (var0 instanceof DrawableContainer) {
            DrawableContainerState var3 = (DrawableContainerState)((DrawableContainer)var0).getConstantState();
            if (var3 != null) {
               int var1 = 0;

               for (int var2 = var3.getChildCount(); var1 < var2; var1++) {
                  var0 = var3.getChild(var1);
                  if (var0 != null) {
                     f(var0);
                  }
               }
            }
         }
      } else {
         var0.clearColorFilter();
      }
   }

   public static Drawable g(Drawable var0) {
      Drawable var1;
      if (VERSION.SDK_INT >= 23) {
         var1 = var0;
      } else if (VERSION.SDK_INT >= 21) {
         var1 = var0;
         if (!(var0 instanceof TintAwareDrawable)) {
            var1 = new WrappedDrawableApi21(var0);
         }
      } else if (VERSION.SDK_INT >= 19) {
         var1 = var0;
         if (!(var0 instanceof TintAwareDrawable)) {
            var1 = new WrappedDrawableApi19(var0);
         }
      } else {
         var1 = var0;
         if (!(var0 instanceof TintAwareDrawable)) {
            var1 = new WrappedDrawableApi14(var0);
         }
      }

      return var1;
   }

   public static <T extends Drawable> T h(Drawable var0) {
      Drawable var1 = var0;
      if (var0 instanceof WrappedDrawable) {
         var1 = ((WrappedDrawable)var0).a();
      }

      return (T)var1;
   }

   public static int i(Drawable var0) {
      int var1;
      if (VERSION.SDK_INT >= 23) {
         var1 = var0.getLayoutDirection();
      } else if (VERSION.SDK_INT >= 17) {
         if (!d) {
            try {
               c = Drawable.class.getDeclaredMethod("getLayoutDirection");
               c.setAccessible(true);
            } catch (NoSuchMethodException var3) {
               Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", var3);
            }

            d = true;
         }

         if (c != null) {
            try {
               var1 = (Integer)c.invoke(var0);
               return var1;
            } catch (Exception var4) {
               Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", var4);
               c = null;
            }
         }

         var1 = 0;
      } else {
         var1 = 0;
      }

      return var1;
   }
}
