package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements TintableBackgroundView {
   private static final int[] a = new int[]{16843126};
   private final AppCompatBackgroundHelper b;
   private final AppCompatTextHelper c;

   public AppCompatAutoCompleteTextView(Context var1) {
      this(var1, null);
   }

   public AppCompatAutoCompleteTextView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.autoCompleteTextViewStyle);
   }

   public AppCompatAutoCompleteTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
      TintTypedArray var4 = TintTypedArray.a(this.getContext(), var2, a, var3, 0);
      if (var4.g(0)) {
         this.setDropDownBackgroundDrawable(var4.a(0));
      }

      var4.a();
      this.b = new AppCompatBackgroundHelper(this);
      this.b.a(var2, var3);
      this.c = AppCompatTextHelper.a(this);
      this.c.a(var2, var3);
      this.c.a();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.b != null) {
         this.b.c();
      }

      if (this.c != null) {
         this.c.a();
      }
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

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      return AppCompatHintHelper.a(super.onCreateInputConnection(var1), var1, this);
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

   public void setDropDownBackgroundResource(int var1) {
      this.setDropDownBackgroundDrawable(AppCompatResources.b(this.getContext(), var1));
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

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      if (this.c != null) {
         this.c.a(var1, var2);
      }
   }
}
