package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements TintableCompoundButton {
   private final AppCompatCompoundButtonHelper a = new AppCompatCompoundButtonHelper(this);
   private final AppCompatTextHelper b;

   public AppCompatRadioButton(Context var1) {
      this(var1, null);
   }

   public AppCompatRadioButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.radioButtonStyle);
   }

   public AppCompatRadioButton(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
      this.a.a(var2, var3);
      this.b = new AppCompatTextHelper(this);
      this.b.a(var2, var3);
   }

   public int getCompoundPaddingLeft() {
      int var2 = super.getCompoundPaddingLeft();
      int var1 = var2;
      if (this.a != null) {
         var1 = this.a.a(var2);
      }

      return var1;
   }

   public ColorStateList getSupportButtonTintList() {
      ColorStateList var1;
      if (this.a != null) {
         var1 = this.a.a();
      } else {
         var1 = null;
      }

      return var1;
   }

   public Mode getSupportButtonTintMode() {
      Mode var1;
      if (this.a != null) {
         var1 = this.a.b();
      } else {
         var1 = null;
      }

      return var1;
   }

   public void setButtonDrawable(int var1) {
      this.setButtonDrawable(AppCompatResources.b(this.getContext(), var1));
   }

   public void setButtonDrawable(Drawable var1) {
      super.setButtonDrawable(var1);
      if (this.a != null) {
         this.a.c();
      }
   }

   @Override
   public void setSupportButtonTintList(ColorStateList var1) {
      if (this.a != null) {
         this.a.a(var1);
      }
   }

   @Override
   public void setSupportButtonTintMode(Mode var1) {
      if (this.a != null) {
         this.a.a(var1);
      }
   }
}
