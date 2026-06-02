package com.jibo.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class PhotoViewerViewPager extends ViewPager {
   public PhotoViewerViewPager(Context var1) {
      super(var1);
   }

   public PhotoViewerViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   @Override
   protected boolean a(View var1, boolean var2, int var3, int var4, int var5) {
      if (var1 instanceof TouchImageView) {
         var2 = ((TouchImageView)var1).a(-var3);
      } else {
         var2 = super.a(var1, var2, var3, var4, var5);
      }

      return var2;
   }
}
