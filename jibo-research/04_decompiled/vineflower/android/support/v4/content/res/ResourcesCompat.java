package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
   public static Typeface a(Context var0, int var1, TypedValue var2, int var3, ResourcesCompat.FontCallback var4) throws NotFoundException {
      Object var5 = null;
      Typeface var6;
      if (var0.isRestricted()) {
         var6 = (Typeface)var5;
      } else {
         var6 = a(var0, var1, var2, var3, var4, null, true);
      }

      return var6;
   }

   private static Typeface a(Context var0, int var1, TypedValue var2, int var3, ResourcesCompat.FontCallback var4, Handler var5, boolean var6) {
      Resources var7 = var0.getResources();
      var7.getValue(var1, var2, true);
      Typeface var8 = a(var0, var7, var2, var1, var3, var4, var5, var6);
      if (var8 == null && var4 == null) {
         throw new NotFoundException("Font resource ID #0x" + Integer.toHexString(var1) + " could not be retrieved.");
      } else {
         return var8;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Typeface a(Context var0, Resources var1, TypedValue var2, int var3, int var4, ResourcesCompat.FontCallback var5, Handler var6, boolean var7) {
      if (var2.string == null) {
         throw new NotFoundException("Resource \"" + var1.getResourceName(var3) + "\" (" + Integer.toHexString(var3) + ") is not a Font: " + var2);
      }

      String var8 = var2.string.toString();
      Typeface var23;
      if (!var8.startsWith("res/")) {
         if (var5 != null) {
            var5.a(-3, var6);
         }

         var23 = null;
      } else {
         Typeface var25 = TypefaceCompat.a(var1, var3, var4);
         if (var25 != null) {
            var23 = var25;
            if (var5 != null) {
               var5.a(var25, var6);
               var23 = var25;
            }
         } else {
            label97: {
               label115: {
                  try {
                     if (var8.toLowerCase().endsWith(".xml")) {
                        var26 = FontResourcesParserCompat.a(var1.getXml(var3), var1);
                        break label115;
                     }
                  } catch (XmlPullParserException var21) {
                     Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var21);
                     break label97;
                  } catch (IOException var22) {
                     Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var22);
                     break label97;
                  }

                  try {
                     var24 = TypefaceCompat.a(var0, var1, var3, var8, var4);
                  } catch (XmlPullParserException var19) {
                     Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var19);
                     break label97;
                  } catch (IOException var20) {
                     Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var20);
                     break label97;
                  }

                  Typeface var27 = var24;
                  if (var5 == null) {
                     return var27;
                  }

                  Typeface var28;
                  if (var24 != null) {
                     try {
                        var5.a(var24, var6);
                     } catch (XmlPullParserException var15) {
                        Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var15);
                        break label97;
                     } catch (IOException var16) {
                        Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var16);
                        break label97;
                     }

                     var28 = var24;
                  } else {
                     try {
                        var5.a(-3, var6);
                     } catch (XmlPullParserException var17) {
                        Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var17);
                        break label97;
                     } catch (IOException var18) {
                        Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var18);
                        break label97;
                     }

                     var28 = var24;
                  }

                  return var28;
               }

               label78:
               if (var26 == null) {
                  try {
                     Log.e("ResourcesCompat", "Failed to find font-family tag");
                  } catch (XmlPullParserException var13) {
                     Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var13);
                     break label78;
                  } catch (IOException var14) {
                     Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var14);
                     break label78;
                  }

                  if (var5 != null) {
                     try {
                        var5.a(-3, var6);
                     } catch (XmlPullParserException var11) {
                        Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var11);
                        break label78;
                     } catch (IOException var12) {
                        Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var12);
                        break label78;
                     }
                  }

                  Object var29 = null;
                  return (Typeface)var29;
               } else {
                  try {
                     Typeface var30 = TypefaceCompat.a(var0, var26, var1, var3, var4, var5, var6, var7);
                     return var30;
                  } catch (XmlPullParserException var9) {
                     Log.e("ResourcesCompat", "Failed to parse xml resource " + var8, var9);
                  } catch (IOException var10) {
                     Log.e("ResourcesCompat", "Failed to read xml resource " + var8, var10);
                  }
               }
            }

            if (var5 != null) {
               var5.a(-3, var6);
            }

            var23 = null;
         }
      }

      return var23;
   }

   public static Drawable a(Resources var0, int var1, Theme var2) throws NotFoundException {
      Drawable var3;
      if (VERSION.SDK_INT >= 21) {
         var3 = var0.getDrawable(var1, var2);
      } else {
         var3 = var0.getDrawable(var1);
      }

      return var3;
   }

   public abstract static class FontCallback {
      public abstract void a(int var1);

      public final void a(int var1, Handler var2) {
         Handler var3 = var2;
         if (var2 == null) {
            var3 = new Handler(Looper.getMainLooper());
         }

         var3.post(new Runnable(this, var1) {
            final int a;
            final ResourcesCompat.FontCallback b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               this.b.a(this.a);
            }
         });
      }

      public abstract void a(Typeface var1);

      public final void a(Typeface var1, Handler var2) {
         Handler var3 = var2;
         if (var2 == null) {
            var3 = new Handler(Looper.getMainLooper());
         }

         var3.post(new Runnable(this, var1) {
            final Typeface a;
            final ResourcesCompat.FontCallback b;

            {
               this.b = var1;
               this.a = var2x;
            }

            @Override
            public void run() {
               this.b.a(this.a);
            }
         });
      }
   }
}
