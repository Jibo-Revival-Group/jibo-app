package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
   private static final int[] a = new int[]{16843505};
   private final AppCompatBackgroundHelper b;
   private final Context c;
   private ForwardingListener d;
   private SpinnerAdapter e;
   private final boolean f;
   private AppCompatSpinner.DropdownPopup g;
   private int h;
   private final Rect i;

   public AppCompatSpinner(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.spinnerStyle);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, -1);
   }

   public AppCompatSpinner(Context var1, AttributeSet var2, int var3, int var4) {
      this(var1, var2, var3, var4, null);
   }

   public AppCompatSpinner(Context param1, AttributeSet param2, int param3, int param4, Theme param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 1
      // 002: aload 2
      // 003: iload 3
      // 004: invokespecial android/widget/Spinner.<init> (Landroid/content/Context;Landroid/util/AttributeSet;I)V
      // 007: aload 0
      // 008: new android/graphics/Rect
      // 00b: dup
      // 00c: invokespecial android/graphics/Rect.<init> ()V
      // 00f: putfield android/support/v7/widget/AppCompatSpinner.i Landroid/graphics/Rect;
      // 012: aload 1
      // 013: aload 2
      // 014: getstatic android/support/v7/appcompat/R$styleable.Spinner [I
      // 017: iload 3
      // 018: bipush 0
      // 019: invokestatic android/support/v7/widget/TintTypedArray.a (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
      // 01c: astore 10
      // 01e: aload 0
      // 01f: new android/support/v7/widget/AppCompatBackgroundHelper
      // 022: dup
      // 023: aload 0
      // 024: invokespecial android/support/v7/widget/AppCompatBackgroundHelper.<init> (Landroid/view/View;)V
      // 027: putfield android/support/v7/widget/AppCompatSpinner.b Landroid/support/v7/widget/AppCompatBackgroundHelper;
      // 02a: aload 5
      // 02c: ifnull 141
      // 02f: aload 0
      // 030: new android/support/v7/view/ContextThemeWrapper
      // 033: dup
      // 034: aload 1
      // 035: aload 5
      // 037: invokespecial android/support/v7/view/ContextThemeWrapper.<init> (Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
      // 03a: putfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 03d: aload 0
      // 03e: getfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 041: ifnull 0f1
      // 044: iload 4
      // 046: istore 7
      // 048: iload 4
      // 04a: bipush -1
      // 04b: if_icmpne 08a
      // 04e: aload 1
      // 04f: aload 2
      // 050: getstatic android/support/v7/widget/AppCompatSpinner.a [I
      // 053: iload 3
      // 054: bipush 0
      // 055: invokevirtual android/content/Context.obtainStyledAttributes (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
      // 058: astore 8
      // 05a: iload 4
      // 05c: istore 6
      // 05e: aload 8
      // 060: astore 5
      // 062: aload 8
      // 064: bipush 0
      // 065: invokevirtual android/content/res/TypedArray.hasValue (I)Z
      // 068: ifeq 078
      // 06b: aload 8
      // 06d: astore 5
      // 06f: aload 8
      // 071: bipush 0
      // 072: bipush 0
      // 073: invokevirtual android/content/res/TypedArray.getInt (II)I
      // 076: istore 6
      // 078: iload 6
      // 07a: istore 7
      // 07c: aload 8
      // 07e: ifnull 08a
      // 081: aload 8
      // 083: invokevirtual android/content/res/TypedArray.recycle ()V
      // 086: iload 6
      // 088: istore 7
      // 08a: iload 7
      // 08c: bipush 1
      // 08d: if_icmpne 0f1
      // 090: new android/support/v7/widget/AppCompatSpinner$DropdownPopup
      // 093: dup
      // 094: aload 0
      // 095: aload 0
      // 096: getfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 099: aload 2
      // 09a: iload 3
      // 09b: invokespecial android/support/v7/widget/AppCompatSpinner$DropdownPopup.<init> (Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
      // 09e: astore 8
      // 0a0: aload 0
      // 0a1: getfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 0a4: aload 2
      // 0a5: getstatic android/support/v7/appcompat/R$styleable.Spinner [I
      // 0a8: iload 3
      // 0a9: bipush 0
      // 0aa: invokestatic android/support/v7/widget/TintTypedArray.a (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/TintTypedArray;
      // 0ad: astore 5
      // 0af: aload 0
      // 0b0: aload 5
      // 0b2: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_dropDownWidth I
      // 0b5: bipush -2
      // 0b7: invokevirtual android/support/v7/widget/TintTypedArray.f (II)I
      // 0ba: putfield android/support/v7/widget/AppCompatSpinner.h I
      // 0bd: aload 8
      // 0bf: aload 5
      // 0c1: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_popupBackground I
      // 0c4: invokevirtual android/support/v7/widget/TintTypedArray.a (I)Landroid/graphics/drawable/Drawable;
      // 0c7: invokevirtual android/support/v7/widget/AppCompatSpinner$DropdownPopup.a (Landroid/graphics/drawable/Drawable;)V
      // 0ca: aload 8
      // 0cc: aload 10
      // 0ce: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_prompt I
      // 0d1: invokevirtual android/support/v7/widget/TintTypedArray.d (I)Ljava/lang/String;
      // 0d4: invokevirtual android/support/v7/widget/AppCompatSpinner$DropdownPopup.a (Ljava/lang/CharSequence;)V
      // 0d7: aload 5
      // 0d9: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 0dc: aload 0
      // 0dd: aload 8
      // 0df: putfield android/support/v7/widget/AppCompatSpinner.g Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;
      // 0e2: aload 0
      // 0e3: new android/support/v7/widget/AppCompatSpinner$1
      // 0e6: dup
      // 0e7: aload 0
      // 0e8: aload 0
      // 0e9: aload 8
      // 0eb: invokespecial android/support/v7/widget/AppCompatSpinner$1.<init> (Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/AppCompatSpinner$DropdownPopup;)V
      // 0ee: putfield android/support/v7/widget/AppCompatSpinner.d Landroid/support/v7/widget/ForwardingListener;
      // 0f1: aload 10
      // 0f3: getstatic android/support/v7/appcompat/R$styleable.Spinner_android_entries I
      // 0f6: invokevirtual android/support/v7/widget/TintTypedArray.f (I)[Ljava/lang/CharSequence;
      // 0f9: astore 5
      // 0fb: aload 5
      // 0fd: ifnull 119
      // 100: new android/widget/ArrayAdapter
      // 103: dup
      // 104: aload 1
      // 105: ldc 17367048
      // 107: aload 5
      // 109: invokespecial android/widget/ArrayAdapter.<init> (Landroid/content/Context;I[Ljava/lang/Object;)V
      // 10c: astore 1
      // 10d: aload 1
      // 10e: getstatic android/support/v7/appcompat/R$layout.support_simple_spinner_dropdown_item I
      // 111: invokevirtual android/widget/ArrayAdapter.setDropDownViewResource (I)V
      // 114: aload 0
      // 115: aload 1
      // 116: invokevirtual android/support/v7/widget/AppCompatSpinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 119: aload 10
      // 11b: invokevirtual android/support/v7/widget/TintTypedArray.a ()V
      // 11e: aload 0
      // 11f: bipush 1
      // 120: putfield android/support/v7/widget/AppCompatSpinner.f Z
      // 123: aload 0
      // 124: getfield android/support/v7/widget/AppCompatSpinner.e Landroid/widget/SpinnerAdapter;
      // 127: ifnull 137
      // 12a: aload 0
      // 12b: aload 0
      // 12c: getfield android/support/v7/widget/AppCompatSpinner.e Landroid/widget/SpinnerAdapter;
      // 12f: invokevirtual android/support/v7/widget/AppCompatSpinner.setAdapter (Landroid/widget/SpinnerAdapter;)V
      // 132: aload 0
      // 133: aconst_null
      // 134: putfield android/support/v7/widget/AppCompatSpinner.e Landroid/widget/SpinnerAdapter;
      // 137: aload 0
      // 138: getfield android/support/v7/widget/AppCompatSpinner.b Landroid/support/v7/widget/AppCompatBackgroundHelper;
      // 13b: aload 2
      // 13c: iload 3
      // 13d: invokevirtual android/support/v7/widget/AppCompatBackgroundHelper.a (Landroid/util/AttributeSet;I)V
      // 140: return
      // 141: aload 10
      // 143: getstatic android/support/v7/appcompat/R$styleable.Spinner_popupTheme I
      // 146: bipush 0
      // 147: invokevirtual android/support/v7/widget/TintTypedArray.g (II)I
      // 14a: istore 6
      // 14c: iload 6
      // 14e: ifeq 162
      // 151: aload 0
      // 152: new android/support/v7/view/ContextThemeWrapper
      // 155: dup
      // 156: aload 1
      // 157: iload 6
      // 159: invokespecial android/support/v7/view/ContextThemeWrapper.<init> (Landroid/content/Context;I)V
      // 15c: putfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 15f: goto 03d
      // 162: getstatic android/os/Build$VERSION.SDK_INT I
      // 165: bipush 23
      // 167: if_icmpge 176
      // 16a: aload 1
      // 16b: astore 5
      // 16d: aload 0
      // 16e: aload 5
      // 170: putfield android/support/v7/widget/AppCompatSpinner.c Landroid/content/Context;
      // 173: goto 03d
      // 176: aconst_null
      // 177: astore 5
      // 179: goto 16d
      // 17c: astore 9
      // 17e: aconst_null
      // 17f: astore 8
      // 181: aload 8
      // 183: astore 5
      // 185: ldc "AppCompatSpinner"
      // 187: ldc "Could not read android:spinnerMode"
      // 189: aload 9
      // 18b: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 18e: pop
      // 18f: iload 4
      // 191: istore 7
      // 193: aload 8
      // 195: ifnull 08a
      // 198: aload 8
      // 19a: invokevirtual android/content/res/TypedArray.recycle ()V
      // 19d: iload 4
      // 19f: istore 7
      // 1a1: goto 08a
      // 1a4: astore 1
      // 1a5: aconst_null
      // 1a6: astore 5
      // 1a8: aload 5
      // 1aa: ifnull 1b2
      // 1ad: aload 5
      // 1af: invokevirtual android/content/res/TypedArray.recycle ()V
      // 1b2: aload 1
      // 1b3: athrow
      // 1b4: astore 1
      // 1b5: goto 1a8
      // 1b8: astore 9
      // 1ba: goto 181
      // try (40 -> 47): 186 java/lang/Exception
      // try (40 -> 47): 205 null
      // try (51 -> 55): 216 java/lang/Exception
      // try (51 -> 55): 214 null
      // try (57 -> 62): 216 java/lang/Exception
      // try (57 -> 62): 214 null
      // try (191 -> 196): 214 null
   }

   int a(SpinnerAdapter var1, Drawable var2) {
      int var3 = 0;
      if (var1 != null) {
         int var7 = MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
         int var9 = MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
         var3 = Math.max(0, this.getSelectedItemPosition());
         int var8 = Math.min(var1.getCount(), var3 + 15);
         int var5 = Math.max(0, var3 - (15 - (var8 - var3)));
         View var10 = null;
         var3 = 0;
         int var4 = 0;

         while (var5 < var8) {
            int var6 = var1.getItemViewType(var5);
            if (var6 != var4) {
               var10 = null;
               var4 = var6;
            }

            var10 = var1.getView(var5, var10, this);
            if (var10.getLayoutParams() == null) {
               var10.setLayoutParams(new LayoutParams(-2, -2));
            }

            var10.measure(var7, var9);
            var3 = Math.max(var3, var10.getMeasuredWidth());
            var5++;
         }

         if (var2 != null) {
            var2.getPadding(this.i);
            var3 += this.i.left + this.i.right;
         }
      }

      return var3;
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.b != null) {
         this.b.c();
      }
   }

   public int getDropDownHorizontalOffset() {
      int var1;
      if (this.g != null) {
         var1 = this.g.j();
      } else if (VERSION.SDK_INT >= 16) {
         var1 = super.getDropDownHorizontalOffset();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getDropDownVerticalOffset() {
      int var1;
      if (this.g != null) {
         var1 = this.g.k();
      } else if (VERSION.SDK_INT >= 16) {
         var1 = super.getDropDownVerticalOffset();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int getDropDownWidth() {
      int var1;
      if (this.g != null) {
         var1 = this.h;
      } else if (VERSION.SDK_INT >= 16) {
         var1 = super.getDropDownWidth();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public Drawable getPopupBackground() {
      Drawable var1;
      if (this.g != null) {
         var1 = this.g.h();
      } else if (VERSION.SDK_INT >= 16) {
         var1 = super.getPopupBackground();
      } else {
         var1 = null;
      }

      return var1;
   }

   public Context getPopupContext() {
      Context var1;
      if (this.g != null) {
         var1 = this.c;
      } else if (VERSION.SDK_INT >= 23) {
         var1 = super.getPopupContext();
      } else {
         var1 = null;
      }

      return var1;
   }

   public CharSequence getPrompt() {
      CharSequence var1;
      if (this.g != null) {
         var1 = this.g.a();
      } else {
         var1 = super.getPrompt();
      }

      return var1;
   }

   @Override
   public ColorStateList getSupportBackgroundTintList() {
      ColorStateList var1;
      if (this.b != null) {
         var1 = this.b.a();
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public Mode getSupportBackgroundTintMode() {
      Mode var1;
      if (this.b != null) {
         var1 = this.b.b();
      } else {
         var1 = null;
      }

      return var1;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.g != null && this.g.f()) {
         this.g.e();
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (this.g != null && MeasureSpec.getMode(var1) == Integer.MIN_VALUE) {
         this.setMeasuredDimension(
            Math.min(Math.max(this.getMeasuredWidth(), this.a(this.getAdapter(), this.getBackground())), MeasureSpec.getSize(var1)), this.getMeasuredHeight()
         );
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var2;
      if (this.d != null && this.d.onTouch(this, var1)) {
         var2 = true;
      } else {
         var2 = super.onTouchEvent(var1);
      }

      return var2;
   }

   public boolean performClick() {
      boolean var1;
      if (this.g != null) {
         if (!this.g.f()) {
            this.g.d();
         }

         var1 = true;
      } else {
         var1 = super.performClick();
      }

      return var1;
   }

   public void setAdapter(SpinnerAdapter var1) {
      if (!this.f) {
         this.e = var1;
      } else {
         super.setAdapter(var1);
         if (this.g != null) {
            Context var2;
            if (this.c == null) {
               var2 = this.getContext();
            } else {
               var2 = this.c;
            }

            this.g.a(new AppCompatSpinner.DropDownAdapter(var1, var2.getTheme()));
         }
      }
   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if (this.b != null) {
         this.b.a(var1);
      }
   }

   public void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      if (this.b != null) {
         this.b.a(var1);
      }
   }

   public void setDropDownHorizontalOffset(int var1) {
      if (this.g != null) {
         this.g.c(var1);
      } else if (VERSION.SDK_INT >= 16) {
         super.setDropDownHorizontalOffset(var1);
      }
   }

   public void setDropDownVerticalOffset(int var1) {
      if (this.g != null) {
         this.g.d(var1);
      } else if (VERSION.SDK_INT >= 16) {
         super.setDropDownVerticalOffset(var1);
      }
   }

   public void setDropDownWidth(int var1) {
      if (this.g != null) {
         this.h = var1;
      } else if (VERSION.SDK_INT >= 16) {
         super.setDropDownWidth(var1);
      }
   }

   public void setPopupBackgroundDrawable(Drawable var1) {
      if (this.g != null) {
         this.g.a(var1);
      } else if (VERSION.SDK_INT >= 16) {
         super.setPopupBackgroundDrawable(var1);
      }
   }

   public void setPopupBackgroundResource(int var1) {
      this.setPopupBackgroundDrawable(AppCompatResources.b(this.getPopupContext(), var1));
   }

   public void setPrompt(CharSequence var1) {
      if (this.g != null) {
         this.g.a(var1);
      } else {
         super.setPrompt(var1);
      }
   }

   @Override
   public void setSupportBackgroundTintList(ColorStateList var1) {
      if (this.b != null) {
         this.b.a(var1);
      }
   }

   @Override
   public void setSupportBackgroundTintMode(Mode var1) {
      if (this.b != null) {
         this.b.a(var1);
      }
   }

   private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
      private SpinnerAdapter a;
      private ListAdapter b;

      public DropDownAdapter(SpinnerAdapter var1, Theme var2) {
         this.a = var1;
         if (var1 instanceof ListAdapter) {
            this.b = (ListAdapter)var1;
         }

         if (var2 != null) {
            if (VERSION.SDK_INT >= 23 && var1 instanceof android.widget.ThemedSpinnerAdapter) {
               android.widget.ThemedSpinnerAdapter var4 = (android.widget.ThemedSpinnerAdapter)var1;
               if (var4.getDropDownViewTheme() != var2) {
                  var4.setDropDownViewTheme(var2);
               }
            } else if (var1 instanceof ThemedSpinnerAdapter) {
               ThemedSpinnerAdapter var3 = (ThemedSpinnerAdapter)var1;
               if (var3.a() == null) {
                  var3.a(var2);
               }
            }
         }
      }

      public boolean areAllItemsEnabled() {
         ListAdapter var2 = this.b;
         boolean var1;
         if (var2 != null) {
            var1 = var2.areAllItemsEnabled();
         } else {
            var1 = true;
         }

         return var1;
      }

      public int getCount() {
         int var1;
         if (this.a == null) {
            var1 = 0;
         } else {
            var1 = this.a.getCount();
         }

         return var1;
      }

      public View getDropDownView(int var1, View var2, ViewGroup var3) {
         if (this.a == null) {
            var2 = null;
         } else {
            var2 = this.a.getDropDownView(var1, var2, var3);
         }

         return var2;
      }

      public Object getItem(int var1) {
         Object var2;
         if (this.a == null) {
            var2 = null;
         } else {
            var2 = this.a.getItem(var1);
         }

         return var2;
      }

      public long getItemId(int var1) {
         long var2;
         if (this.a == null) {
            var2 = -1L;
         } else {
            var2 = this.a.getItemId(var1);
         }

         return var2;
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         return this.getDropDownView(var1, var2, var3);
      }

      public int getViewTypeCount() {
         return 1;
      }

      public boolean hasStableIds() {
         boolean var1;
         if (this.a != null && this.a.hasStableIds()) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public boolean isEmpty() {
         boolean var1;
         if (this.getCount() == 0) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public boolean isEnabled(int var1) {
         ListAdapter var3 = this.b;
         boolean var2;
         if (var3 != null) {
            var2 = var3.isEnabled(var1);
         } else {
            var2 = true;
         }

         return var2;
      }

      public void registerDataSetObserver(DataSetObserver var1) {
         if (this.a != null) {
            this.a.registerDataSetObserver(var1);
         }
      }

      public void unregisterDataSetObserver(DataSetObserver var1) {
         if (this.a != null) {
            this.a.unregisterDataSetObserver(var1);
         }
      }
   }

   private class DropdownPopup extends ListPopupWindow {
      ListAdapter a;
      final AppCompatSpinner b;
      private CharSequence h;
      private final Rect i;

      public DropdownPopup(AppCompatSpinner var1, Context var2, AttributeSet var3, int var4) {
         super(var2, var3, var4);
         this.b = var1;
         this.i = new Rect();
         this.b(var1);
         this.a(true);
         this.a(0);
         this.a(new OnItemClickListener(this, var1) {
            final AppCompatSpinner a;
            final AppCompatSpinner.DropdownPopup b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onItemClick(AdapterView<?> var1, View var2x, int var3x, long var4x) {
               this.b.b.setSelection(var3x);
               if (this.b.b.getOnItemClickListener() != null) {
                  this.b.b.performItemClick(var2x, var3x, this.b.a.getItemId(var3x));
               }

               this.b.e();
            }
         });
      }

      public CharSequence a() {
         return this.h;
      }

      @Override
      public void a(ListAdapter var1) {
         super.a(var1);
         this.a = var1;
      }

      public void a(CharSequence var1) {
         this.h = var1;
      }

      boolean a(View var1) {
         boolean var2;
         if (ViewCompat.B(var1) && var1.getGlobalVisibleRect(this.i)) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      void b() {
         Drawable var7 = this.h();
         int var1;
         if (var7 != null) {
            var7.getPadding(this.b.i);
            if (ViewUtils.a(this.b)) {
               var1 = this.b.i.right;
            } else {
               var1 = -this.b.i.left;
            }
         } else {
            Rect var9 = this.b.i;
            this.b.i.right = 0;
            var9.left = 0;
            var1 = 0;
         }

         int var4 = this.b.getPaddingLeft();
         int var5 = this.b.getPaddingRight();
         int var6 = this.b.getWidth();
         if (this.b.h == -2) {
            int var3 = this.b.a((SpinnerAdapter)this.a, this.h());
            int var2 = this.b.getContext().getResources().getDisplayMetrics().widthPixels - this.b.i.left - this.b.i.right;
            if (var3 <= var2) {
               var2 = var3;
            }

            this.g(Math.max(var2, var6 - var4 - var5));
         } else if (this.b.h == -1) {
            this.g(var6 - var4 - var5);
         } else {
            this.g(this.b.h);
         }

         if (ViewUtils.a(this.b)) {
            var1 = var6 - var5 - this.l() + var1;
         } else {
            var1 += var4;
         }

         this.c(var1);
      }

      @Override
      public void d() {
         boolean var1 = this.f();
         this.b();
         this.h(2);
         super.d();
         this.g().setChoiceMode(1);
         this.i(this.b.getSelectedItemPosition());
         if (!var1) {
            ViewTreeObserver var2 = this.b.getViewTreeObserver();
            if (var2 != null) {
               OnGlobalLayoutListener var3 = new OnGlobalLayoutListener(this) {
                  final AppCompatSpinner.DropdownPopup a;

                  {
                     this.a = var1;
                  }

                  public void onGlobalLayout() {
                     if (!this.a.a(this.a.b)) {
                        this.a.e();
                     } else {
                        this.a.b();
                        this.a.d();
                     }
                  }
               };
               var2.addOnGlobalLayoutListener(var3);
               this.a(new OnDismissListener(this, var3) {
                  final OnGlobalLayoutListener a;
                  final AppCompatSpinner.DropdownPopup b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void onDismiss() {
                     ViewTreeObserver var1x = this.b.b.getViewTreeObserver();
                     if (var1x != null) {
                        var1x.removeGlobalOnLayoutListener(this.a);
                     }
                  }
               });
            }
         }
      }
   }
}
