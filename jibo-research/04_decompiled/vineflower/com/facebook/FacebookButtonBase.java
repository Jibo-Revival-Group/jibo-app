package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FragmentWrapper;

public abstract class FacebookButtonBase extends Button {
   private String analyticsButtonCreatedEventName;
   private String analyticsButtonTappedEventName;
   private OnClickListener externalOnClickListener;
   private OnClickListener internalOnClickListener;
   private boolean overrideCompoundPadding;
   private int overrideCompoundPaddingLeft;
   private int overrideCompoundPaddingRight;
   private FragmentWrapper parentFragment;

   protected FacebookButtonBase(Context var1, AttributeSet var2, int var3, int var4, String var5, String var6) {
      super(var1, var2, 0);
      if (var4 == 0) {
         var4 = this.getDefaultStyleResource();
      }

      int var7 = var4;
      if (var4 == 0) {
         var7 = R.style.com_facebook_button;
      }

      this.configureButton(var1, var2, var3, var7);
      this.analyticsButtonCreatedEventName = var5;
      this.analyticsButtonTappedEventName = var6;
      this.setClickable(true);
      this.setFocusable(true);
   }

   private void logButtonCreated(Context var1) {
      AppEventsLogger.newLogger(var1).logSdkEvent(this.analyticsButtonCreatedEventName, null, null);
   }

   private void logButtonTapped(Context var1) {
      AppEventsLogger.newLogger(var1).logSdkEvent(this.analyticsButtonTappedEventName, null, null);
   }

   private void parseBackgroundAttributes(Context param1, AttributeSet param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/facebook/FacebookButtonBase.isInEditMode ()Z
      // 04: ifeq 08
      // 07: return
      // 08: aload 1
      // 09: invokevirtual android/content/Context.getTheme ()Landroid/content/res/Resources$Theme;
      // 0c: aload 2
      // 0d: bipush 1
      // 0e: newarray 10
      // 10: dup
      // 11: bipush 0
      // 12: ldc 16842964
      // 14: iastore
      // 15: iload 3
      // 16: iload 4
      // 18: invokevirtual android/content/res/Resources$Theme.obtainStyledAttributes (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
      // 1b: astore 2
      // 1c: aload 2
      // 1d: bipush 0
      // 1e: invokevirtual android/content/res/TypedArray.hasValue (I)Z
      // 21: ifeq 4f
      // 24: aload 2
      // 25: bipush 0
      // 26: bipush 0
      // 27: invokevirtual android/content/res/TypedArray.getResourceId (II)I
      // 2a: istore 3
      // 2b: iload 3
      // 2c: ifeq 3b
      // 2f: aload 0
      // 30: iload 3
      // 31: invokevirtual com/facebook/FacebookButtonBase.setBackgroundResource (I)V
      // 34: aload 2
      // 35: invokevirtual android/content/res/TypedArray.recycle ()V
      // 38: goto 07
      // 3b: aload 0
      // 3c: aload 2
      // 3d: bipush 0
      // 3e: bipush 0
      // 3f: invokevirtual android/content/res/TypedArray.getColor (II)I
      // 42: invokevirtual com/facebook/FacebookButtonBase.setBackgroundColor (I)V
      // 45: goto 34
      // 48: astore 1
      // 49: aload 2
      // 4a: invokevirtual android/content/res/TypedArray.recycle ()V
      // 4d: aload 1
      // 4e: athrow
      // 4f: aload 0
      // 50: aload 1
      // 51: getstatic com/facebook/R$color.com_facebook_blue I
      // 54: invokestatic android/support/v4/content/ContextCompat.c (Landroid/content/Context;I)I
      // 57: invokevirtual com/facebook/FacebookButtonBase.setBackgroundColor (I)V
      // 5a: goto 34
      // try (17 -> 26): 41 null
      // try (28 -> 31): 41 null
      // try (34 -> 40): 41 null
      // try (46 -> 51): 41 null
   }

   @SuppressLint("ResourceType")
   private void parseCompoundDrawableAttributes(Context var1, AttributeSet var2, int var3, int var4) {
      TypedArray var7 = var1.getTheme().obtainStyledAttributes(var2, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, var3, var4);

      try {
         this.setCompoundDrawablesWithIntrinsicBounds(var7.getResourceId(0, 0), var7.getResourceId(1, 0), var7.getResourceId(2, 0), var7.getResourceId(3, 0));
         this.setCompoundDrawablePadding(var7.getDimensionPixelSize(4, 0));
      } finally {
         var7.recycle();
      }
   }

   private void parseContentAttributes(Context var1, AttributeSet var2, int var3, int var4) {
      TypedArray var7 = var1.getTheme().obtainStyledAttributes(var2, new int[]{16842966, 16842967, 16842968, 16842969}, var3, var4);

      try {
         this.setPadding(var7.getDimensionPixelSize(0, 0), var7.getDimensionPixelSize(1, 0), var7.getDimensionPixelSize(2, 0), var7.getDimensionPixelSize(3, 0));
      } finally {
         var7.recycle();
      }
   }

   private void parseTextAttributes(Context var1, AttributeSet var2, int var3, int var4) {
      TypedArray var5 = var1.getTheme().obtainStyledAttributes(var2, new int[]{16842904}, var3, var4);

      try {
         this.setTextColor(var5.getColorStateList(0));
      } finally {
         var5.recycle();
      }

      var5 = var1.getTheme().obtainStyledAttributes(var2, new int[]{16842927}, var3, var4);

      try {
         this.setGravity(var5.getInt(0, 17));
      } finally {
         var5.recycle();
      }

      TypedArray var18 = var1.getTheme().obtainStyledAttributes(var2, new int[]{16842901, 16842903, 16843087}, var3, var4);

      try {
         this.setTextSize(0, var18.getDimensionPixelSize(0, 0));
         this.setTypeface(Typeface.defaultFromStyle(var18.getInt(1, 1)));
         this.setText(var18.getString(2));
      } finally {
         var18.recycle();
      }
   }

   private void setupOnClickListener() {
      super.setOnClickListener(new OnClickListener(this) {
         final FacebookButtonBase this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.logButtonTapped(this.this$0.getContext());
            if (this.this$0.internalOnClickListener != null) {
               this.this$0.internalOnClickListener.onClick(var1);
            } else if (this.this$0.externalOnClickListener != null) {
               this.this$0.externalOnClickListener.onClick(var1);
            }
         }
      });
   }

   protected void callExternalOnClickListener(View var1) {
      if (this.externalOnClickListener != null) {
         this.externalOnClickListener.onClick(var1);
      }
   }

   protected void configureButton(Context var1, AttributeSet var2, int var3, int var4) {
      this.parseBackgroundAttributes(var1, var2, var3, var4);
      this.parseCompoundDrawableAttributes(var1, var2, var3, var4);
      this.parseContentAttributes(var1, var2, var3, var4);
      this.parseTextAttributes(var1, var2, var3, var4);
      this.setupOnClickListener();
   }

   protected Activity getActivity() {
      Context var1 = this.getContext();

      while (!(var1 instanceof Activity) && var1 instanceof ContextWrapper) {
         var1 = ((ContextWrapper)var1).getBaseContext();
      }

      if (var1 instanceof Activity) {
         return (Activity)var1;
      } else {
         throw new FacebookException("Unable to get Activity.");
      }
   }

   public int getCompoundPaddingLeft() {
      int var1;
      if (this.overrideCompoundPadding) {
         var1 = this.overrideCompoundPaddingLeft;
      } else {
         var1 = super.getCompoundPaddingLeft();
      }

      return var1;
   }

   public int getCompoundPaddingRight() {
      int var1;
      if (this.overrideCompoundPadding) {
         var1 = this.overrideCompoundPaddingRight;
      } else {
         var1 = super.getCompoundPaddingRight();
      }

      return var1;
   }

   protected abstract int getDefaultRequestCode();

   protected int getDefaultStyleResource() {
      return 0;
   }

   public Fragment getFragment() {
      Fragment var1;
      if (this.parentFragment != null) {
         var1 = this.parentFragment.getSupportFragment();
      } else {
         var1 = null;
      }

      return var1;
   }

   public android.app.Fragment getNativeFragment() {
      android.app.Fragment var1;
      if (this.parentFragment != null) {
         var1 = this.parentFragment.getNativeFragment();
      } else {
         var1 = null;
      }

      return var1;
   }

   public int getRequestCode() {
      return this.getDefaultRequestCode();
   }

   protected int measureTextWidth(String var1) {
      return (int)Math.ceil(this.getPaint().measureText(var1));
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (!this.isInEditMode()) {
         this.logButtonCreated(this.getContext());
      }
   }

   protected void onDraw(Canvas var1) {
      boolean var2;
      if ((this.getGravity() & 1) != 0) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      if (var2) {
         var2 = this.getCompoundPaddingLeft();
         int var3 = this.getCompoundPaddingRight();
         int var4 = this.getCompoundDrawablePadding();
         var4 = Math.min((this.getWidth() - (var4 + var2) - var3 - this.measureTextWidth(this.getText().toString())) / 2, (var2 - this.getPaddingLeft()) / 2);
         this.overrideCompoundPaddingLeft = var2 - var4;
         this.overrideCompoundPaddingRight = var3 + var4;
         this.overrideCompoundPadding = true;
      }

      super.onDraw(var1);
      this.overrideCompoundPadding = false;
   }

   public void setFragment(android.app.Fragment var1) {
      this.parentFragment = new FragmentWrapper(var1);
   }

   public void setFragment(Fragment var1) {
      this.parentFragment = new FragmentWrapper(var1);
   }

   protected void setInternalOnClickListener(OnClickListener var1) {
      this.internalOnClickListener = var1;
   }

   public void setOnClickListener(OnClickListener var1) {
      this.externalOnClickListener = var1;
   }
}
