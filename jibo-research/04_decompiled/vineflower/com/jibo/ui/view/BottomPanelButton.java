package com.jibo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.jibo.R;

public class BottomPanelButton extends FrameLayout {
   Unbinder a;
   private boolean b = true;
   @BindView
   TextView badge;
   @BindView
   ImageView icon;
   @BindView
   TextView text;

   public BottomPanelButton(Context var1) {
      super(var1);
      this.a();
   }

   public BottomPanelButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public BottomPanelButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   private void a() {
      ((LayoutInflater)this.getContext().getSystemService("layout_inflater")).inflate(2131427644, this);
      this.a = ButterKnife.a(this);
   }

   private void a(Context var1, AttributeSet var2) {
      this.a();
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.BottomPanelButton);
      String var5 = var3.getString(1);
      if (var5 != null) {
         this.text.setText(var5);
      }

      Drawable var4 = var3.getDrawable(0);
      if (var4 != null) {
         this.icon.setImageDrawable(var4);
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a.unbind();
   }

   public void setBadgeNumber(int var1) {
      if (var1 > 0) {
         this.badge.setText(String.valueOf(var1));
         this.badge.setVisibility(0);
      } else {
         this.badge.setVisibility(8);
      }
   }

   public void setIcon(Drawable var1) {
      this.icon.setImageDrawable(var1);
   }

   public void setSelected(boolean var1) {
      super.setSelected(var1);
      this.text.setSelected(var1);
      this.icon.setSelected(var1);
   }

   public void setText(int var1) {
      this.text.setText(var1);
   }

   public void setText(String var1) {
      this.text.setText(var1);
   }
}
