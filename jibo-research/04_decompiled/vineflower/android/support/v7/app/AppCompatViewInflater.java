package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
   private static final Class<?>[] a = new Class[]{Context.class, AttributeSet.class};
   private static final int[] b = new int[]{16843375};
   private static final String[] c = new String[]{"android.widget.", "android.view.", "android.webkit."};
   private static final Map<String, Constructor<? extends View>> d = new ArrayMap<>();
   private final Object[] e = new Object[2];

   private static Context a(Context var0, AttributeSet var1, boolean var2, boolean var3) {
      TypedArray var6 = var0.obtainStyledAttributes(var1, R.styleable.View, 0, 0);
      int var4;
      if (var2) {
         var4 = var6.getResourceId(R.styleable.View_android_theme, 0);
      } else {
         var4 = 0;
      }

      int var5 = var4;
      if (var3) {
         var5 = var4;
         if (var4 == 0) {
            var4 = var6.getResourceId(R.styleable.View_theme, 0);
            var5 = var4;
            if (var4 != 0) {
               Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
               var5 = var4;
            }
         }
      }

      var6.recycle();
      Context var7 = var0;
      if (var5 != 0) {
         if (var0 instanceof ContextThemeWrapper) {
            var7 = var0;
            if (((ContextThemeWrapper)var0).a() == var5) {
               return var7;
            }
         }

         var7 = new ContextThemeWrapper(var0, var5);
      }

      return var7;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private View a(Context var1, String var2, String var3) throws ClassNotFoundException, InflateException {
      Constructor var5 = d.get(var2);
      Constructor var4 = var5;
      if (var5 == null) {
         try {
            var13 = var1.getClassLoader();
         } catch (Exception var9) {
            return null;
         }

         String var12;
         if (var3 != null) {
            try {
               StringBuilder var11 = new StringBuilder();
               var12 = var11.append(var3).append(var2).toString();
            } catch (Exception var8) {
               return null;
            }
         } else {
            var12 = var2;
         }

         try {
            var4 = var13.loadClass(var12).asSubclass(View.class).getConstructor(a);
            d.put(var2, var4);
         } catch (Exception var7) {
            return null;
         }
      }

      try {
         var4.setAccessible(true);
         var10 = (View)var4.newInstance(this.e);
      } catch (Exception var6) {
         var10 = null;
      }

      return var10;
   }

   private void a(View var1, AttributeSet var2) {
      Context var3 = var1.getContext();
      if (var3 instanceof ContextWrapper && (VERSION.SDK_INT < 15 || ViewCompat.C(var1))) {
         TypedArray var5 = var3.obtainStyledAttributes(var2, b);
         String var4 = var5.getString(0);
         if (var4 != null) {
            var1.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(var1, var4));
         }

         var5.recycle();
      }
   }

   private void a(View var1, String var2) {
      if (var1 == null) {
         throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + var2 + ">, but returned null");
      }
   }

   private View b(Context param1, String param2, AttributeSet param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 2
      // 01: astore 5
      // 03: aload 2
      // 04: ldc "view"
      // 06: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09: ifeq 17
      // 0c: aload 3
      // 0d: aconst_null
      // 0e: ldc "class"
      // 10: invokeinterface android/util/AttributeSet.getAttributeValue (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 3
      // 15: astore 5
      // 17: aload 0
      // 18: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 1b: bipush 0
      // 1c: aload 1
      // 1d: aastore
      // 1e: aload 0
      // 1f: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 22: bipush 1
      // 23: aload 3
      // 24: aastore
      // 25: bipush -1
      // 26: aload 5
      // 28: bipush 46
      // 2a: invokevirtual java/lang/String.indexOf (I)I
      // 2d: if_icmpne 79
      // 30: bipush 0
      // 31: istore 4
      // 33: iload 4
      // 35: getstatic android/support/v7/app/AppCompatViewInflater.c [Ljava/lang/String;
      // 38: arraylength
      // 39: if_icmpge 66
      // 3c: aload 0
      // 3d: aload 1
      // 3e: aload 5
      // 40: getstatic android/support/v7/app/AppCompatViewInflater.c [Ljava/lang/String;
      // 43: iload 4
      // 45: aaload
      // 46: invokespecial android/support/v7/app/AppCompatViewInflater.a (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
      // 49: astore 2
      // 4a: aload 2
      // 4b: ifnull 60
      // 4e: aload 0
      // 4f: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 52: bipush 0
      // 53: aconst_null
      // 54: aastore
      // 55: aload 0
      // 56: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 59: bipush 1
      // 5a: aconst_null
      // 5b: aastore
      // 5c: aload 2
      // 5d: astore 1
      // 5e: aload 1
      // 5f: areturn
      // 60: iinc 4 1
      // 63: goto 33
      // 66: aload 0
      // 67: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 6a: bipush 0
      // 6b: aconst_null
      // 6c: aastore
      // 6d: aload 0
      // 6e: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 71: bipush 1
      // 72: aconst_null
      // 73: aastore
      // 74: aconst_null
      // 75: astore 1
      // 76: goto 5e
      // 79: aload 0
      // 7a: aload 1
      // 7b: aload 5
      // 7d: aconst_null
      // 7e: invokespecial android/support/v7/app/AppCompatViewInflater.a (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
      // 81: astore 1
      // 82: aload 0
      // 83: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 86: bipush 0
      // 87: aconst_null
      // 88: aastore
      // 89: aload 0
      // 8a: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 8d: bipush 1
      // 8e: aconst_null
      // 8f: aastore
      // 90: goto 5e
      // 93: astore 1
      // 94: aload 0
      // 95: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 98: bipush 0
      // 99: aconst_null
      // 9a: aastore
      // 9b: aload 0
      // 9c: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // 9f: bipush 1
      // a0: aconst_null
      // a1: aastore
      // a2: aconst_null
      // a3: astore 1
      // a4: goto 5e
      // a7: astore 1
      // a8: aload 0
      // a9: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // ac: bipush 0
      // ad: aconst_null
      // ae: aastore
      // af: aload 0
      // b0: getfield android/support/v7/app/AppCompatViewInflater.e [Ljava/lang/Object;
      // b3: bipush 1
      // b4: aconst_null
      // b5: aastore
      // b6: aload 1
      // b7: athrow
      // try (11 -> 26): 88 java/lang/Exception
      // try (11 -> 26): 102 null
      // try (28 -> 40): 88 java/lang/Exception
      // try (28 -> 40): 102 null
      // try (71 -> 77): 88 java/lang/Exception
      // try (71 -> 77): 102 null
   }

   protected AppCompatTextView a(Context var1, AttributeSet var2) {
      return new AppCompatTextView(var1, var2);
   }

   protected View a(Context var1, String var2, AttributeSet var3) {
      return null;
   }

   final View a(View var1, String var2, Context var3, AttributeSet var4, boolean var5, boolean var6, boolean var7, boolean var8) {
      Context var10;
      if (var5 && var1 != null) {
         var10 = var1.getContext();
      } else {
         var10 = var3;
      }

      label90: {
         if (!var6) {
            var11 = var10;
            if (!var7) {
               break label90;
            }
         }

         var11 = a(var10, var4, var6, var7);
      }

      var10 = var11;
      if (var8) {
         var10 = TintContextWrapper.a(var11);
      }

      switch (var2) {
         case "TextView":
            var1 = this.a(var10, var4);
            this.a(var1, var2);
            break;
         case "ImageView":
            var1 = this.b(var10, var4);
            this.a(var1, var2);
            break;
         case "Button":
            var1 = this.c(var10, var4);
            this.a(var1, var2);
            break;
         case "EditText":
            var1 = this.d(var10, var4);
            this.a(var1, var2);
            break;
         case "Spinner":
            var1 = this.e(var10, var4);
            this.a(var1, var2);
            break;
         case "ImageButton":
            var1 = this.f(var10, var4);
            this.a(var1, var2);
            break;
         case "CheckBox":
            var1 = this.g(var10, var4);
            this.a(var1, var2);
            break;
         case "RadioButton":
            var1 = this.h(var10, var4);
            this.a(var1, var2);
            break;
         case "CheckedTextView":
            var1 = this.i(var10, var4);
            this.a(var1, var2);
            break;
         case "AutoCompleteTextView":
            var1 = this.j(var10, var4);
            this.a(var1, var2);
            break;
         case "MultiAutoCompleteTextView":
            var1 = this.k(var10, var4);
            this.a(var1, var2);
            break;
         case "RatingBar":
            var1 = this.l(var10, var4);
            this.a(var1, var2);
            break;
         case "SeekBar":
            var1 = this.m(var10, var4);
            this.a(var1, var2);
            break;
         default:
            var1 = this.a(var10, var2, var4);
      }

      if (var1 == null && var3 != var10) {
         var1 = this.b(var10, var2, var4);
      }

      if (var1 != null) {
         this.a(var1, var4);
      }

      return var1;
   }

   protected AppCompatImageView b(Context var1, AttributeSet var2) {
      return new AppCompatImageView(var1, var2);
   }

   protected AppCompatButton c(Context var1, AttributeSet var2) {
      return new AppCompatButton(var1, var2);
   }

   protected AppCompatEditText d(Context var1, AttributeSet var2) {
      return new AppCompatEditText(var1, var2);
   }

   protected AppCompatSpinner e(Context var1, AttributeSet var2) {
      return new AppCompatSpinner(var1, var2);
   }

   protected AppCompatImageButton f(Context var1, AttributeSet var2) {
      return new AppCompatImageButton(var1, var2);
   }

   protected AppCompatCheckBox g(Context var1, AttributeSet var2) {
      return new AppCompatCheckBox(var1, var2);
   }

   protected AppCompatRadioButton h(Context var1, AttributeSet var2) {
      return new AppCompatRadioButton(var1, var2);
   }

   protected AppCompatCheckedTextView i(Context var1, AttributeSet var2) {
      return new AppCompatCheckedTextView(var1, var2);
   }

   protected AppCompatAutoCompleteTextView j(Context var1, AttributeSet var2) {
      return new AppCompatAutoCompleteTextView(var1, var2);
   }

   protected AppCompatMultiAutoCompleteTextView k(Context var1, AttributeSet var2) {
      return new AppCompatMultiAutoCompleteTextView(var1, var2);
   }

   protected AppCompatRatingBar l(Context var1, AttributeSet var2) {
      return new AppCompatRatingBar(var1, var2);
   }

   protected AppCompatSeekBar m(Context var1, AttributeSet var2) {
      return new AppCompatSeekBar(var1, var2);
   }

   private static class DeclaredOnClickListener implements OnClickListener {
      private final View a;
      private final String b;
      private Method c;
      private Context d;

      public DeclaredOnClickListener(View var1, String var2) {
         this.a = var1;
         this.b = var2;
      }

      // $VF: Duplicated exception handlers to handle obfuscated exceptions
      private void a(Context var1, String var2) {
         while (var1 != null) {
            label35: {
               try {
                  if (var1.isRestricted()) {
                     break label35;
                  }

                  var7 = var1.getClass().getMethod(this.b, View.class);
               } catch (NoSuchMethodException var5) {
                  break label35;
               }

               if (var7 != null) {
                  try {
                     this.c = var7;
                     this.d = var1;
                     return;
                  } catch (NoSuchMethodException var4) {
                  }
               }
            }

            if (var1 instanceof ContextWrapper) {
               var1 = ((ContextWrapper)var1).getBaseContext();
            } else {
               var1 = null;
            }
         }

         int var3 = this.a.getId();
         String var6;
         if (var3 == -1) {
            var6 = "";
         } else {
            var6 = " with id '" + this.a.getContext().getResources().getResourceEntryName(var3) + "'";
         }

         throw new IllegalStateException(
            "Could not find method "
               + this.b
               + "(View) in a parent or ancestor Context for android:onClick "
               + "attribute defined on view "
               + this.a.getClass()
               + var6
         );
      }

      public void onClick(View var1) {
         if (this.c == null) {
            this.a(this.a.getContext(), this.b);
         }

         try {
            this.c.invoke(this.d, var1);
         } catch (IllegalAccessException var2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", var2);
         } catch (InvocationTargetException var3) {
            throw new IllegalStateException("Could not execute method for android:onClick", var3);
         }
      }
   }
}
