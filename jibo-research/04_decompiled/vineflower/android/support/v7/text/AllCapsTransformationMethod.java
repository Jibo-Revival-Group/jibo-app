package android.support.v7.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod {
   private Locale a;

   public AllCapsTransformationMethod(Context var1) {
      this.a = var1.getResources().getConfiguration().locale;
   }

   public CharSequence getTransformation(CharSequence var1, View var2) {
      if (var1 != null) {
         var1 = var1.toString().toUpperCase(this.a);
      } else {
         var1 = null;
      }

      return var1;
   }

   public void onFocusChanged(View var1, CharSequence var2, boolean var3, int var4, Rect var5) {
   }
}
