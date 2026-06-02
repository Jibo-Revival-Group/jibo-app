package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
   private TypedValue a;
   private TypedValue b;
   private TypedValue c;
   private TypedValue d;
   private TypedValue e;
   private TypedValue f;
   private final Rect g = new Rect();
   private ContentFrameLayout.OnAttachListener h;

   public ContentFrameLayout(Context var1) {
      this(var1, null);
   }

   public ContentFrameLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ContentFrameLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.g.set(var1, var2, var3, var4);
      if (ViewCompat.y(this)) {
         this.requestLayout();
      }
   }

   public void a(Rect var1) {
      this.fitSystemWindows(var1);
   }

   public TypedValue getFixedHeightMajor() {
      if (this.e == null) {
         this.e = new TypedValue();
      }

      return this.e;
   }

   public TypedValue getFixedHeightMinor() {
      if (this.f == null) {
         this.f = new TypedValue();
      }

      return this.f;
   }

   public TypedValue getFixedWidthMajor() {
      if (this.c == null) {
         this.c = new TypedValue();
      }

      return this.c;
   }

   public TypedValue getFixedWidthMinor() {
      if (this.d == null) {
         this.d = new TypedValue();
      }

      return this.d;
   }

   public TypedValue getMinWidthMajor() {
      if (this.a == null) {
         this.a = new TypedValue();
      }

      return this.a;
   }

   public TypedValue getMinWidthMinor() {
      if (this.b == null) {
         this.b = new TypedValue();
      }

      return this.b;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.h != null) {
         this.h.a();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.h != null) {
         this.h.b();
      }
   }

   protected void onMeasure(int var1, int var2) {
      boolean var7 = false;
      DisplayMetrics var11 = this.getContext().getResources().getDisplayMetrics();
      boolean var4;
      if (var11.widthPixels < var11.heightPixels) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      int var6;
      int var8;
      int var9;
      label92: {
         var8 = MeasureSpec.getMode(var1);
         var9 = MeasureSpec.getMode(var2);
         if (var8 == Integer.MIN_VALUE) {
            TypedValue var10;
            if (var4) {
               var10 = this.d;
            } else {
               var10 = this.c;
            }

            if (var10 != null && var10.type != 0) {
               int var3;
               if (var10.type == 5) {
                  var3 = (int)var10.getDimension(var11);
               } else if (var10.type == 6) {
                  var3 = (int)var10.getFraction(var11.widthPixels, var11.widthPixels);
               } else {
                  var3 = 0;
               }

               if (var3 > 0) {
                  var6 = MeasureSpec.makeMeasureSpec(Math.min(var3 - (this.g.left + this.g.right), MeasureSpec.getSize(var1)), 1073741824);
                  var5 = true;
                  break label92;
               }
            }
         }

         var5 = false;
         var6 = var1;
      }

      int var17 = var2;
      if (var9 == Integer.MIN_VALUE) {
         TypedValue var20;
         if (var4) {
            var20 = this.e;
         } else {
            var20 = this.f;
         }

         var17 = var2;
         if (var20 != null) {
            var17 = var2;
            if (var20.type != 0) {
               if (var20.type == 5) {
                  var1 = (int)var20.getDimension(var11);
               } else if (var20.type == 6) {
                  var1 = (int)var20.getFraction(var11.heightPixels, var11.heightPixels);
               } else {
                  var1 = 0;
               }

               var17 = var2;
               if (var1 > 0) {
                  var17 = MeasureSpec.makeMeasureSpec(Math.min(var1 - (this.g.top + this.g.bottom), MeasureSpec.getSize(var2)), 1073741824);
               }
            }
         }
      }

      label82: {
         super.onMeasure(var6, var17);
         var9 = this.getMeasuredWidth();
         var6 = MeasureSpec.makeMeasureSpec(var9, 1073741824);
         if (!var5 && var8 == Integer.MIN_VALUE) {
            TypedValue var21;
            if (var4) {
               var21 = this.b;
            } else {
               var21 = this.a;
            }

            if (var21 != null && var21.type != 0) {
               if (var21.type == 5) {
                  var1 = (int)var21.getDimension(var11);
               } else if (var21.type == 6) {
                  var1 = (int)var21.getFraction(var11.widthPixels, var11.widthPixels);
               } else {
                  var1 = 0;
               }

               var2 = var1;
               if (var1 > 0) {
                  var2 = var1 - (this.g.left + this.g.right);
               }

               if (var9 < var2) {
                  var1 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
                  var16 = true;
                  break label82;
               }
            }
         }

         var1 = var6;
         var16 = var7;
      }

      if (var16) {
         super.onMeasure(var1, var17);
      }
   }

   public void setAttachListener(ContentFrameLayout.OnAttachListener var1) {
      this.h = var1;
   }

   public interface OnAttachListener {
      void a();

      void b();
   }
}
