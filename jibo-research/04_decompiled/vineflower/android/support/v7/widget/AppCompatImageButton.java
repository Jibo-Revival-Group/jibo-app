package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {
   private final AppCompatBackgroundHelper a = new AppCompatBackgroundHelper(this);
   private final AppCompatImageHelper b;

   public AppCompatImageButton(Context var1) {
      this(var1, null);
   }

   public AppCompatImageButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.imageButtonStyle);
   }

   public AppCompatImageButton(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.a(var1), var2, var3);
      this.a.a(var2, var3);
      this.b = new AppCompatImageHelper(this);
      this.b.a(var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if (this.a != null) {
         this.a.c();
      }

      if (this.b != null) {
         this.b.d();
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

   @Override
   public ColorStateList getSupportImageTintList() {
      ColorStateList var1;
      if (this.b != null) {
         var1 = this.b.b();
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public Mode getSupportImageTintMode() {
      Mode var1;
      if (this.b != null) {
         var1 = this.b.c();
      } else {
         var1 = null;
      }

      return var1;
   }

   public boolean hasOverlappingRendering() {
      boolean var1;
      if (this.b.a() && super.hasOverlappingRendering()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
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

   public void setImageBitmap(Bitmap var1) {
      super.setImageBitmap(var1);
      if (this.b != null) {
         this.b.d();
      }
   }

   public void setImageDrawable(Drawable var1) {
      super.setImageDrawable(var1);
      if (this.b != null) {
         this.b.d();
      }
   }

   public void setImageResource(int var1) {
      this.b.a(var1);
   }

   public void setImageURI(Uri var1) {
      super.setImageURI(var1);
      if (this.b != null) {
         this.b.d();
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

   @Override
   public void setSupportImageTintList(ColorStateList var1) {
      if (this.b != null) {
         this.b.a(var1);
      }
   }

   @Override
   public void setSupportImageTintMode(Mode var1) {
      if (this.b != null) {
         this.b.a(var1);
      }
   }
}
