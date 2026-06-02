package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
   private static final int[] e = new int[]{16842801};
   private static final CardViewImpl f;
   int a;
   int b;
   final Rect c = new Rect();
   final Rect d = new Rect();
   private boolean g;
   private boolean h;
   private final CardViewDelegate i = new CardViewDelegate(this) {
      final CardView a;
      private Drawable b;

      {
         this.a = var1;
      }

      @Override
      public void a(int var1, int var2) {
         if (var1 > this.a.a) {
            this.a.setMinimumWidth(var1);
         }

         if (var2 > this.a.b) {
            this.a.setMinimumHeight(var2);
         }
      }

      @Override
      public void a(int var1, int var2, int var3, int var4) {
         this.a.d.set(var1, var2, var3, var4);
         this.a.setPadding(this.a.c.left + var1, this.a.c.top + var2, this.a.c.right + var3, this.a.c.bottom + var4);
      }

      @Override
      public void a(Drawable var1) {
         this.b = var1;
         this.a.setBackgroundDrawable(var1);
      }

      @Override
      public boolean a() {
         return this.a.getUseCompatPadding();
      }

      @Override
      public boolean b() {
         return this.a.getPreventCornerOverlap();
      }

      @Override
      public Drawable c() {
         return this.b;
      }

      @Override
      public View d() {
         return this.a;
      }
   };

   static {
      if (VERSION.SDK_INT >= 21) {
         f = new CardViewApi21Impl();
      } else if (VERSION.SDK_INT >= 17) {
         f = new CardViewApi17Impl();
      } else {
         f = new CardViewBaseImpl();
      }

      f.a();
   }

   public CardView(Context var1) {
      this(var1, null);
   }

   public CardView(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.cardViewStyle);
   }

   public CardView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var8 = var1.obtainStyledAttributes(var2, R.styleable.CardView, var3, R.style.CardView);
      ColorStateList var9;
      if (var8.hasValue(R.styleable.CardView_cardBackgroundColor)) {
         var9 = var8.getColorStateList(R.styleable.CardView_cardBackgroundColor);
      } else {
         TypedArray var10 = this.getContext().obtainStyledAttributes(e);
         var3 = var10.getColor(0, 0);
         var10.recycle();
         float[] var11 = new float[3];
         Color.colorToHSV(var3, var11);
         if (var11[2] > 0.5F) {
            var3 = this.getResources().getColor(R.color.cardview_light_background);
         } else {
            var3 = this.getResources().getColor(R.color.cardview_dark_background);
         }

         var9 = ColorStateList.valueOf(var3);
      }

      float var7 = var8.getDimension(R.styleable.CardView_cardCornerRadius, 0.0F);
      float var5 = var8.getDimension(R.styleable.CardView_cardElevation, 0.0F);
      float var6 = var8.getDimension(R.styleable.CardView_cardMaxElevation, 0.0F);
      this.g = var8.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
      this.h = var8.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
      var3 = var8.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
      this.c.left = var8.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, var3);
      this.c.top = var8.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, var3);
      this.c.right = var8.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, var3);
      this.c.bottom = var8.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, var3);
      float var4 = var6;
      if (var5 > var6) {
         var4 = var5;
      }

      this.a = var8.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
      this.b = var8.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
      var8.recycle();
      f.a(this.i, var1, var9, var7, var5, var4);
   }

   public ColorStateList getCardBackgroundColor() {
      return f.i(this.i);
   }

   public float getCardElevation() {
      return f.e(this.i);
   }

   public int getContentPaddingBottom() {
      return this.c.bottom;
   }

   public int getContentPaddingLeft() {
      return this.c.left;
   }

   public int getContentPaddingRight() {
      return this.c.right;
   }

   public int getContentPaddingTop() {
      return this.c.top;
   }

   public float getMaxCardElevation() {
      return f.a(this.i);
   }

   public boolean getPreventCornerOverlap() {
      return this.h;
   }

   public float getRadius() {
      return f.d(this.i);
   }

   public boolean getUseCompatPadding() {
      return this.g;
   }

   protected void onMeasure(int var1, int var2) {
      if (!(f instanceof CardViewApi21Impl)) {
         int var3 = MeasureSpec.getMode(var1);
         switch (var3) {
            case Integer.MIN_VALUE:
            case 1073741824:
               var1 = MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.b(this.i)), MeasureSpec.getSize(var1)), var3);
            default:
               var3 = MeasureSpec.getMode(var2);
               switch (var3) {
                  case Integer.MIN_VALUE:
                  case 1073741824:
                     var2 = MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(f.c(this.i)), MeasureSpec.getSize(var2)), var3);
                  default:
                     super.onMeasure(var1, var2);
               }
         }
      } else {
         super.onMeasure(var1, var2);
      }
   }

   public void setCardBackgroundColor(int var1) {
      f.a(this.i, ColorStateList.valueOf(var1));
   }

   public void setCardBackgroundColor(ColorStateList var1) {
      f.a(this.i, var1);
   }

   public void setCardElevation(float var1) {
      f.c(this.i, var1);
   }

   public void setMaxCardElevation(float var1) {
      f.b(this.i, var1);
   }

   public void setMinimumHeight(int var1) {
      this.b = var1;
      super.setMinimumHeight(var1);
   }

   public void setMinimumWidth(int var1) {
      this.a = var1;
      super.setMinimumWidth(var1);
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
   }

   public void setPaddingRelative(int var1, int var2, int var3, int var4) {
   }

   public void setPreventCornerOverlap(boolean var1) {
      if (var1 != this.h) {
         this.h = var1;
         f.h(this.i);
      }
   }

   public void setRadius(float var1) {
      f.a(this.i, var1);
   }

   public void setUseCompatPadding(boolean var1) {
      if (this.g != var1) {
         this.g = var1;
         f.g(this.i);
      }
   }
}
