package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.Log;
import java.lang.reflect.Field;

public class DrawableUtils {
   public static final Rect a = new Rect();
   private static Class<?> b;

   static {
      if (VERSION.SDK_INT >= 18) {
         try {
            b = Class.forName("android.graphics.Insets");
         } catch (ClassNotFoundException var1) {
         }
      }
   }

   public static Mode a(int var0, Mode var1) {
      Mode var2 = var1;
      switch (var0) {
         case 3:
            var2 = Mode.SRC_OVER;
         case 4:
         case 6:
         case 7:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
            break;
         case 5:
            var2 = Mode.SRC_IN;
            break;
         case 9:
            var2 = Mode.SRC_ATOP;
            break;
         case 14:
            var2 = Mode.MULTIPLY;
            break;
         case 15:
            var2 = Mode.SCREEN;
            break;
         case 16:
            var2 = Mode.ADD;
            break;
         default:
            var2 = var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static Rect a(Drawable var0) {
      if (b != null) {
         Object var6;
         try {
            var0 = DrawableCompat.h(var0);
            var6 = var0.getClass().getMethod("getOpticalInsets").invoke(var0);
         } catch (Exception var19) {
            Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            return a;
         }

         if (var6 != null) {
            int var3;
            Rect var4;
            Field[] var5;
            try {
               var4 = new Rect();
               var5 = b.getFields();
               var3 = var5.length;
            } catch (Exception var18) {
               Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
               return a;
            }

            int var2 = 0;

            while (true) {
               Rect var21 = var4;
               if (var2 >= var3) {
                  return var21;
               }

               Field var7 = var5[var2];

               try {
                  var22 = var7.getName();
               } catch (Exception var12) {
                  Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                  break;
               }

               byte var1 = -1;

               label121: {
                  label122: {
                     label123: {
                        label124: {
                           try {
                              switch (var22.hashCode()) {
                                 case -1383228885:
                                    break label122;
                                 case 115029:
                                    break label124;
                                 case 3317767:
                                    break;
                                 case 108511772:
                                    break label123;
                                 default:
                                    break label121;
                              }
                           } catch (Exception var17) {
                              Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                              break;
                           }

                           try {
                              if (!var22.equals("left")) {
                                 break label121;
                              }
                           } catch (Exception var16) {
                              Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                              break;
                           }

                           var1 = 0;
                           break label121;
                        }

                        try {
                           if (!var22.equals("top")) {
                              break label121;
                           }
                        } catch (Exception var15) {
                           Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                           break;
                        }

                        var1 = 1;
                        break label121;
                     }

                     try {
                        if (!var22.equals("right")) {
                           break label121;
                        }
                     } catch (Exception var14) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                        break;
                     }

                     var1 = 2;
                     break label121;
                  }

                  try {
                     if (!var22.equals("bottom")) {
                        break label121;
                     }
                  } catch (Exception var13) {
                     Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                     break;
                  }

                  var1 = 3;
               }

               switch (var1) {
                  case 0:
                     try {
                        var4.left = var7.getInt(var6);
                        break;
                     } catch (Exception var11) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                        return a;
                     }
                  case 1:
                     try {
                        var4.top = var7.getInt(var6);
                        break;
                     } catch (Exception var10) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                        return a;
                     }
                  case 2:
                     try {
                        var4.right = var7.getInt(var6);
                        break;
                     } catch (Exception var9) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                        return a;
                     }
                  case 3:
                     try {
                        var4.bottom = var7.getInt(var6);
                     } catch (Exception var8) {
                        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
                        return a;
                     }
               }

               var2++;
            }
         }
      }

      return a;
   }

   static void b(Drawable var0) {
      if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(var0.getClass().getName())) {
         d(var0);
      }
   }

   public static boolean c(Drawable var0) {
      boolean var3;
      if (VERSION.SDK_INT < 15 && var0 instanceof InsetDrawable) {
         var3 = false;
      } else if (VERSION.SDK_INT < 15 && var0 instanceof GradientDrawable) {
         var3 = false;
      } else if (VERSION.SDK_INT < 17 && var0 instanceof LayerDrawable) {
         var3 = false;
      } else {
         if (var0 instanceof DrawableContainer) {
            ConstantState var4 = var0.getConstantState();
            if (var4 instanceof DrawableContainerState) {
               Drawable[] var5 = ((DrawableContainerState)var4).getChildren();
               int var2 = var5.length;

               for (int var1 = 0; var1 < var2; var1++) {
                  if (!c(var5[var1])) {
                     return false;
                  }
               }
            }
         } else {
            if (var0 instanceof WrappedDrawable) {
               var3 = c(((WrappedDrawable)var0).a());
               return var3;
            }

            if (var0 instanceof DrawableWrapper) {
               var3 = c(((DrawableWrapper)var0).b());
               return var3;
            }

            if (var0 instanceof ScaleDrawable) {
               var3 = c(((ScaleDrawable)var0).getDrawable());
               return var3;
            }
         }

         var3 = true;
      }

      return var3;
   }

   private static void d(Drawable var0) {
      int[] var1 = var0.getState();
      if (var1 != null && var1.length != 0) {
         var0.setState(ThemeUtils.h);
      } else {
         var0.setState(ThemeUtils.e);
      }

      var0.setState(var1);
   }
}
