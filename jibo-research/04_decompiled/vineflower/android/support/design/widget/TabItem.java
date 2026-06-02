package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
   final CharSequence a;
   final Drawable b;
   final int c;

   public TabItem(Context var1, AttributeSet var2) {
      super(var1, var2);
      TintTypedArray var3 = TintTypedArray.a(var1, var2, R.styleable.TabItem);
      this.a = var3.c(R.styleable.TabItem_android_text);
      this.b = var3.a(R.styleable.TabItem_android_icon);
      this.c = var3.g(R.styleable.TabItem_android_layout, 0);
      var3.a();
   }
}
