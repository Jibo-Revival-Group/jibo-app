package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbx;
import com.google.android.gms.common.internal.zzby;

public final class SignInButton extends FrameLayout implements OnClickListener {
   private int a;
   private int b;
   private View c;
   private OnClickListener d = null;

   public SignInButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SignInButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var6 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SignInButton, 0, 0);

      try {
         this.a = var6.getInt(R.styleable.SignInButton_buttonSize, 0);
         this.b = var6.getInt(R.styleable.SignInButton_colorScheme, 2);
      } finally {
         var6.recycle();
      }

      this.a(this.a, this.b);
   }

   public final void a(int var1, int var2) {
      this.a = var1;
      this.b = var2;
      Context var3 = this.getContext();
      if (this.c != null) {
         this.removeView(this.c);
      }

      try {
         this.c = zzbx.a(var3, this.a, this.b);
      } catch (com.google.android.gms.dynamic.zzq var5) {
         Log.w("SignInButton", "Sign in button not found, using placeholder instead");
         var1 = this.a;
         var2 = this.b;
         zzby var4 = new zzby(var3);
         var4.a(var3.getResources(), var1, var2);
         this.c = var4;
      }

      this.addView(this.c);
      this.c.setEnabled(this.isEnabled());
      this.c.setOnClickListener(this);
   }

   public final void onClick(View var1) {
      if (this.d != null && var1 == this.c) {
         this.d.onClick(this);
      }
   }

   public final void setColorScheme(int var1) {
      this.a(this.a, var1);
   }

   public final void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.c.setEnabled(var1);
   }

   public final void setOnClickListener(OnClickListener var1) {
      this.d = var1;
      if (this.c != null) {
         this.c.setOnClickListener(this);
      }
   }

   @Deprecated
   public final void setScopes(Scope[] var1) {
      this.a(this.a, this.b);
   }

   public final void setSize(int var1) {
      this.a(var1, this.b);
   }
}
