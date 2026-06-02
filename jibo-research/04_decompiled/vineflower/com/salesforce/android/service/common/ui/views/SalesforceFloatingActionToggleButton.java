package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SalesforceFloatingActionToggleButton extends ToggleButton implements OnCheckedChangeListener {
   List<OnCheckedChangeListener> a;
   private final int b;
   private final int c;
   private final int d;
   private final int e;
   private final Drawable f;
   private final Drawable g;
   private final SalesforceFloatingActionButtonImpl h;
   private Coordinate i = Coordinate.a(0, 0);

   public SalesforceFloatingActionToggleButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setOnCheckedChangeListener(this);
      this.a = new ArrayList<>();
      TypedArray var5 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SalesforceFloatingActionToggleButton, 0, 0);

      try {
         this.b = this.a(var5, R.styleable.SalesforceFloatingActionToggleButton_salesforce_background_unchecked, R.color.salesforce_contrast_primary);
         this.c = this.a(var5, R.styleable.SalesforceFloatingActionToggleButton_salesforce_background_checked, R.color.salesforce_feedback_secondary);
         this.d = this.a(var5, R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_color_unchecked, R.color.salesforce_contrast_inverted);
         this.e = this.a(var5, R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_color_checked, R.color.salesforce_brand_primary_inverted);
         this.f = var5.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_unchecked);
         this.g = var5.getDrawable(R.styleable.SalesforceFloatingActionToggleButton_salesforce_src_checked);
      } finally {
         var5.recycle();
      }

      this.h = SalesforceFloatingActionButtonImpl.a(this).a(this.b).b(this.c).a(this.f).c(this.d).b(this.g).d(this.e).a();
   }

   private int a(TypedArray var1, int var2, int var3) {
      return var1.getColor(var2, ContextCompat.c(this.getContext(), var3));
   }

   public void onCheckedChanged(CompoundButton var1, boolean var2) {
      if (var2) {
         this.h.a(this.i).start();
      } else {
         this.h.b(this.i).start();
      }

      Iterator var3 = this.a.iterator();

      while (var3.hasNext()) {
         ((OnCheckedChangeListener)var3.next()).onCheckedChanged(var1, var2);
      }
   }

   protected void onDraw(Canvas var1) {
      this.h.a(var1);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.h.a(var1, var2);
      this.invalidate();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.i = Coordinate.a((int)var1.getX(), (int)var1.getY());
      return super.onTouchEvent(var1);
   }

   public void setOnCheckedChangeListener(OnCheckedChangeListener var1) {
      if (var1 instanceof SalesforceFloatingActionToggleButton) {
         super.setOnCheckedChangeListener(var1);
      } else {
         this.a.add(var1);
      }
   }
}
