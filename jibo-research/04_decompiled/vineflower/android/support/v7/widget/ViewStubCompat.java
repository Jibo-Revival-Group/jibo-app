package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
   private int a = 0;
   private int b;
   private WeakReference<View> c;
   private LayoutInflater d;
   private ViewStubCompat.OnInflateListener e;

   public ViewStubCompat(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ViewStubCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ViewStubCompat, var3, 0);
      this.b = var4.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
      this.a = var4.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
      this.setId(var4.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
      var4.recycle();
      this.setVisibility(8);
      this.setWillNotDraw(true);
   }

   public View a() {
      ViewParent var2 = this.getParent();
      if (var2 == null || !(var2 instanceof ViewGroup)) {
         throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
      }

      if (this.a != 0) {
         ViewGroup var3 = (ViewGroup)var2;
         LayoutInflater var5;
         if (this.d != null) {
            var5 = this.d;
         } else {
            var5 = LayoutInflater.from(this.getContext());
         }

         View var6 = var5.inflate(this.a, var3, false);
         if (this.b != -1) {
            var6.setId(this.b);
         }

         int var1 = var3.indexOfChild(this);
         var3.removeViewInLayout(this);
         LayoutParams var4 = this.getLayoutParams();
         if (var4 != null) {
            var3.addView(var6, var1, var4);
         } else {
            var3.addView(var6, var1);
         }

         this.c = new WeakReference<>(var6);
         if (this.e != null) {
            this.e.a(this, var6);
         }

         return var6;
      } else {
         throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
      }
   }

   protected void dispatchDraw(Canvas var1) {
   }

   @SuppressLint("MissingSuperCall")
   public void draw(Canvas var1) {
   }

   public int getInflatedId() {
      return this.b;
   }

   public LayoutInflater getLayoutInflater() {
      return this.d;
   }

   public int getLayoutResource() {
      return this.a;
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(0, 0);
   }

   public void setInflatedId(int var1) {
      this.b = var1;
   }

   public void setLayoutInflater(LayoutInflater var1) {
      this.d = var1;
   }

   public void setLayoutResource(int var1) {
      this.a = var1;
   }

   public void setOnInflateListener(ViewStubCompat.OnInflateListener var1) {
      this.e = var1;
   }

   public void setVisibility(int var1) {
      if (this.c != null) {
         View var2 = this.c.get();
         if (var2 == null) {
            throw new IllegalStateException("setVisibility called on un-referenced view");
         }

         var2.setVisibility(var1);
      } else {
         super.setVisibility(var1);
         if (var1 == 0 || var1 == 4) {
            this.a();
         }
      }
   }

   public interface OnInflateListener {
      void a(ViewStubCompat var1, View var2);
   }
}
