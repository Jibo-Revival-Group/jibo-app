package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AppCompatDrawableManager {
   private static final Mode a = Mode.SRC_IN;
   private static AppCompatDrawableManager b;
   private static final AppCompatDrawableManager.ColorFilterLruCache c = new AppCompatDrawableManager.ColorFilterLruCache(6);
   private static final int[] d = new int[]{
      R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha
   };
   private static final int[] e = new int[]{
      R.drawable.abc_ic_commit_search_api_mtrl_alpha,
      R.drawable.abc_seekbar_tick_mark_material,
      R.drawable.abc_ic_menu_share_mtrl_alpha,
      R.drawable.abc_ic_menu_copy_mtrl_am_alpha,
      R.drawable.abc_ic_menu_cut_mtrl_alpha,
      R.drawable.abc_ic_menu_selectall_mtrl_alpha,
      R.drawable.abc_ic_menu_paste_mtrl_am_alpha
   };
   private static final int[] f = new int[]{
      R.drawable.abc_textfield_activated_mtrl_alpha,
      R.drawable.abc_textfield_search_activated_mtrl_alpha,
      R.drawable.abc_cab_background_top_mtrl_alpha,
      R.drawable.abc_text_cursor_material,
      R.drawable.abc_text_select_handle_left_mtrl_dark,
      R.drawable.abc_text_select_handle_middle_mtrl_dark,
      R.drawable.abc_text_select_handle_right_mtrl_dark,
      R.drawable.abc_text_select_handle_left_mtrl_light,
      R.drawable.abc_text_select_handle_middle_mtrl_light,
      R.drawable.abc_text_select_handle_right_mtrl_light
   };
   private static final int[] g = new int[]{
      R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult
   };
   private static final int[] h = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
   private static final int[] i = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};
   private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> j;
   private ArrayMap<String, AppCompatDrawableManager.InflateDelegate> k;
   private SparseArrayCompat<String> l;
   private final Object m = new Object();
   private final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> n = new WeakHashMap<>(0);
   private TypedValue o;
   private boolean p;

   private static long a(TypedValue var0) {
      return (long)var0.assetCookie << 32 | var0.data;
   }

   static Mode a(int var0) {
      Mode var1 = null;
      if (var0 == R.drawable.abc_switch_thumb_material) {
         var1 = Mode.MULTIPLY;
      }

      return var1;
   }

   public static PorterDuffColorFilter a(int var0, Mode var1) {
      PorterDuffColorFilter var3 = c.a(var0, var1);
      PorterDuffColorFilter var2 = var3;
      if (var3 == null) {
         var2 = new PorterDuffColorFilter(var0, var1);
         c.a(var0, var1, var2);
      }

      return var2;
   }

   private static PorterDuffColorFilter a(ColorStateList var0, Mode var1, int[] var2) {
      PorterDuffColorFilter var3;
      if (var0 != null && var1 != null) {
         var3 = a(var0.getColorForState(var2, 0), var1);
      } else {
         var3 = null;
      }

      return var3;
   }

   private Drawable a(Context var1, int var2, boolean var3, Drawable var4) {
      ColorStateList var5 = this.b(var1, var2);
      Drawable var9;
      if (var5 != null) {
         Drawable var6 = var4;
         if (DrawableUtils.c(var4)) {
            var6 = var4.mutate();
         }

         Drawable var7 = DrawableCompat.g(var6);
         DrawableCompat.a(var7, var5);
         Mode var8 = a(var2);
         var9 = var7;
         if (var8 != null) {
            DrawableCompat.a(var7, var8);
            var9 = var7;
         }
      } else if (var2 == R.drawable.abc_seekbar_track_material) {
         LayerDrawable var10 = (LayerDrawable)var4;
         a(var10.findDrawableByLayerId(16908288), ThemeUtils.a(var1, R.attr.colorControlNormal), a);
         a(var10.findDrawableByLayerId(16908303), ThemeUtils.a(var1, R.attr.colorControlNormal), a);
         a(var10.findDrawableByLayerId(16908301), ThemeUtils.a(var1, R.attr.colorControlActivated), a);
         var9 = var4;
      } else if (var2 != R.drawable.abc_ratingbar_material
         && var2 != R.drawable.abc_ratingbar_indicator_material
         && var2 != R.drawable.abc_ratingbar_small_material) {
         var9 = var4;
         if (!a(var1, var2, var4)) {
            var9 = var4;
            if (var3) {
               var9 = null;
            }
         }
      } else {
         LayerDrawable var11 = (LayerDrawable)var4;
         a(var11.findDrawableByLayerId(16908288), ThemeUtils.c(var1, R.attr.colorControlNormal), a);
         a(var11.findDrawableByLayerId(16908303), ThemeUtils.a(var1, R.attr.colorControlActivated), a);
         a(var11.findDrawableByLayerId(16908301), ThemeUtils.a(var1, R.attr.colorControlActivated), a);
         var9 = var4;
      }

      return var9;
   }

   private Drawable a(Context param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/v7/widget/AppCompatDrawableManager.m Ljava/lang/Object;
      // 04: astore 4
      // 06: aload 4
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield android/support/v7/widget/AppCompatDrawableManager.n Ljava/util/WeakHashMap;
      // 0d: aload 1
      // 0e: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 11: checkcast android/support/v4/util/LongSparseArray
      // 14: astore 5
      // 16: aload 5
      // 18: ifnonnull 22
      // 1b: aload 4
      // 1d: monitorexit
      // 1e: aconst_null
      // 1f: astore 1
      // 20: aload 1
      // 21: areturn
      // 22: aload 5
      // 24: lload 2
      // 25: invokevirtual android/support/v4/util/LongSparseArray.a (J)Ljava/lang/Object;
      // 28: checkcast java/lang/ref/WeakReference
      // 2b: astore 6
      // 2d: aload 6
      // 2f: ifnull 5d
      // 32: aload 6
      // 34: invokevirtual java/lang/ref/WeakReference.get ()Ljava/lang/Object;
      // 37: checkcast android/graphics/drawable/Drawable$ConstantState
      // 3a: astore 6
      // 3c: aload 6
      // 3e: ifnull 57
      // 41: aload 6
      // 43: aload 1
      // 44: invokevirtual android/content/Context.getResources ()Landroid/content/res/Resources;
      // 47: invokevirtual android/graphics/drawable/Drawable$ConstantState.newDrawable (Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
      // 4a: astore 1
      // 4b: aload 4
      // 4d: monitorexit
      // 4e: goto 20
      // 51: astore 1
      // 52: aload 4
      // 54: monitorexit
      // 55: aload 1
      // 56: athrow
      // 57: aload 5
      // 59: lload 2
      // 5a: invokevirtual android/support/v4/util/LongSparseArray.b (J)V
      // 5d: aload 4
      // 5f: monitorexit
      // 60: aconst_null
      // 61: astore 1
      // 62: goto 20
      // try (5 -> 11): 40 null
      // try (13 -> 15): 40 null
      // try (19 -> 24): 40 null
      // try (26 -> 30): 40 null
      // try (32 -> 39): 40 null
      // try (41 -> 43): 40 null
      // try (45 -> 48): 40 null
      // try (48 -> 50): 40 null
   }

   public static AppCompatDrawableManager a() {
      if (b == null) {
         b = new AppCompatDrawableManager();
         a(b);
      }

      return b;
   }

   private void a(Context var1, int var2, ColorStateList var3) {
      if (this.j == null) {
         this.j = new WeakHashMap<>();
      }

      SparseArrayCompat var5 = this.j.get(var1);
      SparseArrayCompat var4 = var5;
      if (var5 == null) {
         var4 = new SparseArrayCompat();
         this.j.put(var1, var4);
      }

      var4.c(var2, var3);
   }

   private static void a(Drawable var0, int var1, Mode var2) {
      Drawable var3 = var0;
      if (DrawableUtils.c(var0)) {
         var3 = var0.mutate();
      }

      Mode var4 = var2;
      if (var2 == null) {
         var4 = a;
      }

      var3.setColorFilter(a(var1, var4));
   }

   static void a(Drawable var0, TintInfo var1, int[] var2) {
      if (DrawableUtils.c(var0) && var0.mutate() != var0) {
         Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
      } else {
         if (!var1.d && !var1.c) {
            var0.clearColorFilter();
         } else {
            ColorStateList var3;
            if (var1.d) {
               var3 = var1.a;
            } else {
               var3 = null;
            }

            Mode var4;
            if (var1.c) {
               var4 = var1.b;
            } else {
               var4 = a;
            }

            var0.setColorFilter(a(var3, var4, var2));
         }

         if (VERSION.SDK_INT <= 23) {
            var0.invalidateSelf();
         }
      }
   }

   private static void a(AppCompatDrawableManager var0) {
      if (VERSION.SDK_INT < 24) {
         var0.a("vector", new AppCompatDrawableManager.VdcInflateDelegate());
         var0.a("animated-vector", new AppCompatDrawableManager.AvdcInflateDelegate());
      }
   }

   private void a(String var1, AppCompatDrawableManager.InflateDelegate var2) {
      if (this.k == null) {
         this.k = new ArrayMap<>();
      }

      this.k.put(var1, var2);
   }

   static boolean a(Context var0, int var1, Drawable var2) {
      boolean var6 = true;
      Mode var7 = a;
      int var3;
      boolean var4;
      if (a(d, var1)) {
         var3 = R.attr.colorControlNormal;
         var4 = true;
         var1 = -1;
      } else if (a(f, var1)) {
         var3 = R.attr.colorControlActivated;
         var4 = true;
         var1 = -1;
      } else if (a(g, var1)) {
         var7 = Mode.MULTIPLY;
         var4 = true;
         var3 = 16842801;
         var1 = -1;
      } else if (var1 == R.drawable.abc_list_divider_mtrl_alpha) {
         var3 = 16842800;
         var1 = Math.round(40.8F);
         var4 = true;
      } else if (var1 == R.drawable.abc_dialog_material_background) {
         var3 = 16842801;
         var4 = true;
         var1 = -1;
      } else {
         var1 = -1;
         var3 = 0;
         var4 = false;
      }

      boolean var5;
      if (var4) {
         Drawable var8 = var2;
         if (DrawableUtils.c(var2)) {
            var8 = var2.mutate();
         }

         var8.setColorFilter(a(ThemeUtils.a(var0, var3), var7));
         var5 = var6;
         if (var1 != -1) {
            var8.setAlpha(var1);
            var5 = var6;
         }
      } else {
         var5 = false;
      }

      return var5;
   }

   private boolean a(Context param1, long param2, Drawable param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 4
      // 02: invokevirtual android/graphics/drawable/Drawable.getConstantState ()Landroid/graphics/drawable/Drawable$ConstantState;
      // 05: astore 8
      // 07: aload 8
      // 09: ifnull 60
      // 0c: aload 0
      // 0d: getfield android/support/v7/widget/AppCompatDrawableManager.m Ljava/lang/Object;
      // 10: astore 7
      // 12: aload 7
      // 14: monitorenter
      // 15: aload 0
      // 16: getfield android/support/v7/widget/AppCompatDrawableManager.n Ljava/util/WeakHashMap;
      // 19: aload 1
      // 1a: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 1d: checkcast android/support/v4/util/LongSparseArray
      // 20: astore 6
      // 22: aload 6
      // 24: astore 4
      // 26: aload 6
      // 28: ifnonnull 40
      // 2b: new android/support/v4/util/LongSparseArray
      // 2e: astore 4
      // 30: aload 4
      // 32: invokespecial android/support/v4/util/LongSparseArray.<init> ()V
      // 35: aload 0
      // 36: getfield android/support/v7/widget/AppCompatDrawableManager.n Ljava/util/WeakHashMap;
      // 39: aload 1
      // 3a: aload 4
      // 3c: invokevirtual java/util/WeakHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 3f: pop
      // 40: new java/lang/ref/WeakReference
      // 43: astore 1
      // 44: aload 1
      // 45: aload 8
      // 47: invokespecial java/lang/ref/WeakReference.<init> (Ljava/lang/Object;)V
      // 4a: aload 4
      // 4c: lload 2
      // 4d: aload 1
      // 4e: invokevirtual android/support/v4/util/LongSparseArray.b (JLjava/lang/Object;)V
      // 51: aload 7
      // 53: monitorexit
      // 54: bipush 1
      // 55: istore 5
      // 57: iload 5
      // 59: ireturn
      // 5a: astore 1
      // 5b: aload 7
      // 5d: monitorexit
      // 5e: aload 1
      // 5f: athrow
      // 60: bipush 0
      // 61: istore 5
      // 63: goto 57
      // try (10 -> 16): 45 null
      // try (20 -> 30): 45 null
      // try (30 -> 41): 45 null
      // try (46 -> 48): 45 null
   }

   private static boolean a(Drawable var0) {
      boolean var1;
      if (!(var0 instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(var0.getClass().getName())) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private static boolean a(int[] var0, int var1) {
      boolean var5 = false;
      int var3 = var0.length;
      int var2 = 0;

      boolean var4;
      while (true) {
         var4 = var5;
         if (var2 >= var3) {
            break;
         }

         if (var0[var2] == var1) {
            var4 = true;
            break;
         }

         var2++;
      }

      return var4;
   }

   private ColorStateList b(Context var1) {
      return this.f(var1, ThemeUtils.a(var1, R.attr.colorButtonNormal));
   }

   private ColorStateList c(Context var1) {
      return this.f(var1, 0);
   }

   private Drawable c(Context var1, int var2) {
      if (this.o == null) {
         this.o = new TypedValue();
      }

      TypedValue var7 = this.o;
      var1.getResources().getValue(var2, var7, true);
      long var3 = a(var7);
      Object var5 = this.a(var1, var3);
      Object var6;
      if (var5 != null) {
         var6 = var5;
      } else {
         if (var2 == R.drawable.abc_cab_background_top_material) {
            var5 = new LayerDrawable(
               new Drawable[]{this.a(var1, R.drawable.abc_cab_background_internal_bg), this.a(var1, R.drawable.abc_cab_background_top_mtrl_alpha)}
            );
         }

         var6 = var5;
         if (var5 != null) {
            var5.setChangingConfigurations(var7.changingConfigurations);
            this.a(var1, var3, (Drawable)var5);
            var6 = var5;
         }
      }

      return (Drawable)var6;
   }

   private ColorStateList d(Context var1) {
      return this.f(var1, ThemeUtils.a(var1, R.attr.colorAccent));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private Drawable d(Context var1, int var2) {
      Drawable var26;
      if (this.k != null && !this.k.isEmpty()) {
         if (this.l != null) {
            String var7 = this.l.a(var2);
            if ("appcompat_skip_skip".equals(var7) || var7 != null && this.k.get(var7) == null) {
               Object var32 = null;
               return (Drawable)var32;
            }
         } else {
            this.l = new SparseArrayCompat<>();
         }

         if (this.o == null) {
            this.o = new TypedValue();
         }

         TypedValue var10 = this.o;
         Resources var8 = var1.getResources();
         var8.getValue(var2, var10, true);
         long var4 = a(var10);
         Drawable var28 = this.a(var1, var4);
         if (var28 != null) {
            var26 = var28;
         } else {
            label141: {
               Drawable var9 = var28;
               if (var10.string != null) {
                  var9 = var28;
                  label139:
                  if (var10.string.toString().endsWith(".xml")) {
                     var9 = var28;

                     XmlResourceParser var12;
                     try {
                        var12 = var8.getXml(var2);
                     } catch (Exception var25) {
                        Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var25);
                        break label139;
                     }

                     var9 = var28;

                     AttributeSet var11;
                     try {
                        var11 = Xml.asAttributeSet(var12);
                     } catch (Exception var24) {
                        Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var24);
                        break label139;
                     }

                     while (true) {
                        var9 = var28;

                        int var3;
                        try {
                           var3 = var12.next();
                        } catch (Exception var23) {
                           Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var23);
                           break;
                        }

                        if (var3 == 2 || var3 == 1) {
                           if (var3 != 2) {
                              var9 = var28;

                              try {
                                 var27 = new XmlPullParserException;
                              } catch (Exception var16) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var16);
                                 break;
                              }

                              var9 = var28;

                              try {
                                 var27./* $VF: Unable to resugar constructor */<init>("No start tag found");
                              } catch (Exception var15) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var15);
                                 break;
                              }

                              var9 = var28;

                              try {
                                 throw var27;
                              } catch (Exception var14) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var14);
                                 break;
                              }
                           } else {
                              var9 = var28;

                              try {
                                 var30 = var12.getName();
                              } catch (Exception var22) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var22);
                                 break;
                              }

                              var9 = var28;

                              try {
                                 this.l.c(var2, var30);
                              } catch (Exception var21) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var21);
                                 break;
                              }

                              var9 = var28;

                              AppCompatDrawableManager.InflateDelegate var13;
                              try {
                                 var13 = this.k.get(var30);
                              } catch (Exception var20) {
                                 Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var20);
                                 break;
                              }

                              Drawable var31 = var28;
                              if (var13 != null) {
                                 var9 = var28;

                                 try {
                                    var31 = var13.a(var1, var12, var11, var1.getTheme());
                                 } catch (Exception var19) {
                                    Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var19);
                                    break;
                                 }
                              }

                              if (var31 != null) {
                                 var9 = var31;

                                 try {
                                    var31.setChangingConfigurations(var10.changingConfigurations);
                                 } catch (Exception var18) {
                                    Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var18);
                                    break;
                                 }

                                 var9 = var31;

                                 boolean var6;
                                 try {
                                    var6 = this.a(var1, var4, var31);
                                 } catch (Exception var17) {
                                    Log.e("AppCompatDrawableManag", "Exception while inflating drawable", var17);
                                    break;
                                 }

                                 if (var6) {
                                 }
                              }

                              var28 = var31;
                              break label141;
                           }
                        }
                     }
                  }
               }

               var28 = var9;
            }

            var26 = var28;
            if (var28 == null) {
               this.l.c(var2, "appcompat_skip_skip");
               var26 = var28;
            }
         }
      } else {
         var26 = null;
      }

      return var26;
   }

   private ColorStateList e(Context var1) {
      int[][] var2 = new int[3][];
      int[] var3 = new int[3];
      ColorStateList var4 = ThemeUtils.b(var1, R.attr.colorSwitchThumbNormal);
      if (var4 != null && var4.isStateful()) {
         var2[0] = ThemeUtils.a;
         var3[0] = var4.getColorForState(var2[0], 0);
         var2[1] = ThemeUtils.e;
         var3[1] = ThemeUtils.a(var1, R.attr.colorControlActivated);
         var2[2] = ThemeUtils.h;
         var3[2] = var4.getDefaultColor();
      } else {
         var2[0] = ThemeUtils.a;
         var3[0] = ThemeUtils.c(var1, R.attr.colorSwitchThumbNormal);
         var2[1] = ThemeUtils.e;
         var3[1] = ThemeUtils.a(var1, R.attr.colorControlActivated);
         var2[2] = ThemeUtils.h;
         var3[2] = ThemeUtils.a(var1, R.attr.colorSwitchThumbNormal);
      }

      return new ColorStateList(var2, var3);
   }

   private ColorStateList e(Context var1, int var2) {
      ColorStateList var4;
      if (this.j != null) {
         SparseArrayCompat var3 = this.j.get(var1);
         if (var3 != null) {
            var4 = (ColorStateList)var3.a(var2);
         } else {
            var4 = null;
         }
      } else {
         var4 = null;
      }

      return var4;
   }

   private ColorStateList f(Context var1, int var2) {
      int var5 = ThemeUtils.a(var1, R.attr.colorControlHighlight);
      int var4 = ThemeUtils.c(var1, R.attr.colorButtonNormal);
      int[] var6 = ThemeUtils.a;
      int[] var7 = ThemeUtils.d;
      int var3 = ColorUtils.a(var5, var2);
      int[] var8 = ThemeUtils.b;
      var5 = ColorUtils.a(var5, var2);
      return new ColorStateList(new int[][]{var6, var7, var8, ThemeUtils.h}, new int[]{var4, var3, var5, var2});
   }

   private void f(Context var1) {
      if (!this.p) {
         this.p = true;
         Drawable var2 = this.a(var1, R.drawable.abc_vector_test);
         if (var2 == null || !a(var2)) {
            this.p = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
         }
      }
   }

   public Drawable a(Context var1, int var2) {
      return this.a(var1, var2, false);
   }

   Drawable a(Context var1, int var2, boolean var3) {
      this.f(var1);
      Drawable var5 = this.d(var1, var2);
      Drawable var4 = var5;
      if (var5 == null) {
         var4 = this.c(var1, var2);
      }

      var5 = var4;
      if (var4 == null) {
         var5 = ContextCompat.a(var1, var2);
      }

      var4 = var5;
      if (var5 != null) {
         var4 = this.a(var1, var2, var3, var5);
      }

      if (var4 != null) {
         DrawableUtils.b(var4);
      }

      return var4;
   }

   Drawable a(Context var1, VectorEnabledTintResources var2, int var3) {
      Drawable var5 = this.d(var1, var3);
      Drawable var4 = var5;
      if (var5 == null) {
         var4 = var2.a(var3);
      }

      Drawable var6;
      if (var4 != null) {
         var6 = this.a(var1, var3, false, var4);
      } else {
         var6 = null;
      }

      return var6;
   }

   public void a(Context param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield android/support/v7/widget/AppCompatDrawableManager.m Ljava/lang/Object;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield android/support/v7/widget/AppCompatDrawableManager.n Ljava/util/WeakHashMap;
      // 0b: aload 1
      // 0c: invokevirtual java/util/WeakHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f: checkcast android/support/v4/util/LongSparseArray
      // 12: astore 1
      // 13: aload 1
      // 14: ifnull 1b
      // 17: aload 1
      // 18: invokevirtual android/support/v4/util/LongSparseArray.c ()V
      // 1b: aload 2
      // 1c: monitorexit
      // 1d: return
      // 1e: astore 1
      // 1f: aload 2
      // 20: monitorexit
      // 21: aload 1
      // 22: athrow
      // try (5 -> 11): 18 null
      // try (13 -> 15): 18 null
      // try (15 -> 17): 18 null
      // try (19 -> 21): 18 null
   }

   ColorStateList b(Context var1, int var2) {
      ColorStateList var3 = this.e(var1, var2);
      ColorStateList var4 = var3;
      if (var3 == null) {
         if (var2 == R.drawable.abc_edit_text_material) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_edittext);
         } else if (var2 == R.drawable.abc_switch_track_mtrl_alpha) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_switch_track);
         } else if (var2 == R.drawable.abc_switch_thumb_material) {
            var3 = this.e(var1);
         } else if (var2 == R.drawable.abc_btn_default_mtrl_shape) {
            var3 = this.b(var1);
         } else if (var2 == R.drawable.abc_btn_borderless_material) {
            var3 = this.c(var1);
         } else if (var2 == R.drawable.abc_btn_colored_material) {
            var3 = this.d(var1);
         } else if (var2 == R.drawable.abc_spinner_mtrl_am_alpha || var2 == R.drawable.abc_spinner_textfield_background_material) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_spinner);
         } else if (a(e, var2)) {
            var3 = ThemeUtils.b(var1, R.attr.colorControlNormal);
         } else if (a(h, var2)) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_default);
         } else if (a(i, var2)) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_btn_checkable);
         } else if (var2 == R.drawable.abc_seekbar_thumb_material) {
            var3 = AppCompatResources.a(var1, R.color.abc_tint_seek_thumb);
         }

         var4 = var3;
         if (var3 != null) {
            this.a(var1, var2, var3);
            var4 = var3;
         }
      }

      return var4;
   }

   private static class AvdcInflateDelegate implements AppCompatDrawableManager.InflateDelegate {
      AvdcInflateDelegate() {
      }

      @Override
      public Drawable a(Context var1, XmlPullParser var2, AttributeSet var3, Theme var4) {
         try {
            var6 = AnimatedVectorDrawableCompat.a(var1, var1.getResources(), var2, var3, var4);
         } catch (Exception var5) {
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", var5);
            var6 = null;
         }

         return var6;
      }
   }

   private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
      public ColorFilterLruCache(int var1) {
         super(var1);
      }

      private static int b(int var0, Mode var1) {
         return (var0 + 31) * 31 + var1.hashCode();
      }

      PorterDuffColorFilter a(int var1, Mode var2) {
         return this.a(Integer.valueOf(b(var1, var2)));
      }

      PorterDuffColorFilter a(int var1, Mode var2, PorterDuffColorFilter var3) {
         return this.a(b(var1, var2), var3);
      }
   }

   private interface InflateDelegate {
      Drawable a(Context var1, XmlPullParser var2, AttributeSet var3, Theme var4);
   }

   private static class VdcInflateDelegate implements AppCompatDrawableManager.InflateDelegate {
      VdcInflateDelegate() {
      }

      @Override
      public Drawable a(Context var1, XmlPullParser var2, AttributeSet var3, Theme var4) {
         try {
            var6 = VectorDrawableCompat.a(var1.getResources(), var2, var3, var4);
         } catch (Exception var5) {
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", var5);
            var6 = null;
         }

         return var6;
      }
   }
}
