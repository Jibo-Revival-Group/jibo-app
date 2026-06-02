package com.jibo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ErrorImageView extends ImageView {
   private boolean a = false;

   public ErrorImageView(Context var1) {
      super(var1);
   }

   public ErrorImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public ErrorImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public boolean getError() {
      return this.a;
   }

   public void setError(boolean var1) {
      this.a = var1;
   }
}
