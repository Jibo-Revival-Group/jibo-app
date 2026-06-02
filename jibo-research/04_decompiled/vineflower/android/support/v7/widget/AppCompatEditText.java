package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class AppCompatEditText extends EditText implements TintableBackgroundView {
   private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper(this);
   private final AppCompatTextHelper b;

   public AppCompatEditText(Context var1) {
      this(var1, null);
   }

   public AppCompatEditText(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.editTextStyle);
   }

   public AppCompatEditText(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
      this.a.a(var2, var3);
      this.b = AppCompatTextHelper.a(this);
      this.b.a(var2, var3);
      this.b.a();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.a != null) {
         this.a.c();
      }

      if (this.b != null) {
         this.b.a();
      }
   }

   @Override
   public ColorStateList getSupportBackgroundTintList() {
      ColorStateList var1;
      if (this.a != null) {
         var1 = this.a.a();
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public Mode getSupportBackgroundTintMode() {
      Mode var1;
      if (this.a != null) {
         var1 = this.a.b();
      } else {
         var1 = null;
      }

      return var1;
   }

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      return AppCompatHintHelper.a(super.onCreateInputConnection(var1), var1, this);
   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if (this.a != null) {
         this.a.a(var1);
      }
   }

   public void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      if (this.a != null) {
         this.a.a(var1);
      }
   }

   @Override
   public void setSupportBackgroundTintList(ColorStateList var1) {
      if (this.a != null) {
         this.a.a(var1);
      }
   }

   @Override
   public void setSupportBackgroundTintMode(Mode var1) {
      if (this.a != null) {
         this.a.a(var1);
      }
   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      if (this.b != null) {
         this.b.a(var1, var2);
      }
   }
}
