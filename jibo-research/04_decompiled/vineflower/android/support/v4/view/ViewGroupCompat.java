package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.compat.R;
import android.view.ViewGroup;

public final class ViewGroupCompat {
   static final ViewGroupCompat.ViewGroupCompatBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 21) {
         a = new ViewGroupCompat.ViewGroupCompatApi21Impl();
      } else if (VERSION.SDK_INT >= 18) {
         a = new ViewGroupCompat.ViewGroupCompatApi18Impl();
      } else {
         a = new ViewGroupCompat.ViewGroupCompatBaseImpl();
      }
   }

   public static boolean a(ViewGroup var0) {
      return a.a(var0);
   }

   static class ViewGroupCompatApi18Impl extends ViewGroupCompat.ViewGroupCompatBaseImpl {
   }

   static class ViewGroupCompatApi21Impl extends ViewGroupCompat.ViewGroupCompatApi18Impl {
      @Override
      public boolean a(ViewGroup var1) {
         return var1.isTransitionGroup();
      }
   }

   static class ViewGroupCompatBaseImpl {
      public boolean a(ViewGroup var1) {
         Boolean var3 = (Boolean)var1.getTag(R.id.tag_transition_group);
         boolean var2;
         if ((var3 == null || !var3) && var1.getBackground() == null && ViewCompat.o(var1) == null) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }
   }
}
