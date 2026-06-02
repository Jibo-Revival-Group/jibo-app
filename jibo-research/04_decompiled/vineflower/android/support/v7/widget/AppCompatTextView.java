package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView {
   private final AppCompatBackgroundHelper b = new AppCompatBackgroundHelper(this);
   private final AppCompatTextHelper c;

   public AppCompatTextView(Context var1) {
      this(var1, null);
   }

   public AppCompatTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16842884);
   }

   public AppCompatTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
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

   public int getAutoSizeMaxTextSize() {
      int var1;
      if (a) {
         var1 = super.getAutoSizeMaxTextSize();
      } else if (this.c != null) {
         var1 = this.c.g();
      } else {
         var1 = -1;
      }

      return var1;
   }

   public int getAutoSizeMinTextSize() {
      int var1;
      if (a) {
         var1 = super.getAutoSizeMinTextSize();
      } else if (this.c != null) {
         var1 = this.c.f();
      } else {
         var1 = -1;
      }

      return var1;
   }

   public int getAutoSizeStepGranularity() {
      int var1;
      if (a) {
         var1 = super.getAutoSizeStepGranularity();
      } else if (this.c != null) {
         var1 = this.c.e();
      } else {
         var1 = -1;
      }

      return var1;
   }

   public int[] getAutoSizeTextAvailableSizes() {
      int[] var1;
      if (a) {
         var1 = super.getAutoSizeTextAvailableSizes();
      } else if (this.c != null) {
         var1 = this.c.h();
      } else {
         var1 = new int[0];
      }

      return var1;
   }

   public int getAutoSizeTextType() {
      int var1 = 1;
      if (a) {
         if (super.getAutoSizeTextType() != 1) {
            var1 = 0;
         }
      } else if (this.c != null) {
         var1 = this.c.d();
      } else {
         var1 = 0;
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

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      return AppCompatHintHelper.a(super.onCreateInputConnection(var1), var1, this);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if (this.c != null) {
         this.c.a(var1, var2, var3, var4, var5);
      }
   }

   protected void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      super.onTextChanged(var1, var2, var3, var4);
      if (this.c != null && !a && this.c.c()) {
         this.c.b();
      }
   }

   public void setAutoSizeTextTypeUniformWithConfiguration(int var1, int var2, int var3, int var4) throws IllegalArgumentException {
      if (a) {
         super.setAutoSizeTextTypeUniformWithConfiguration(var1, var2, var3, var4);
      } else if (this.c != null) {
         this.c.a(var1, var2, var3, var4);
      }
   }

   public void setAutoSizeTextTypeUniformWithPresetSizes(int[] var1, int var2) throws IllegalArgumentException {
      if (a) {
         super.setAutoSizeTextTypeUniformWithPresetSizes(var1, var2);
      } else if (this.c != null) {
         this.c.a(var1, var2);
      }
   }

   public void setAutoSizeTextTypeWithDefaults(int var1) {
      if (a) {
         super.setAutoSizeTextTypeWithDefaults(var1);
      } else if (this.c != null) {
         this.c.a(var1);
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

   public void setTextSize(int var1, float var2) {
      if (a) {
         super.setTextSize(var1, var2);
      } else if (this.c != null) {
         this.c.a(var1, var2);
      }
   }
}
