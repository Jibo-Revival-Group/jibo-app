package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

interface GhostViewImpl {
   void a(ViewGroup var1, View var2);

   void setVisibility(int var1);

   interface Creator {
      GhostViewImpl a(View var1, ViewGroup var2, Matrix var3);

      void a(View var1);
   }
}
