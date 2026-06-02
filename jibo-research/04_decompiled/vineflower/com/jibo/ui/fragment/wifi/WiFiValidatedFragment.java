package com.jibo.ui.fragment.wifi;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

abstract class WiFiValidatedFragment extends WiFiBaseFragment {
   public static final String c = LogUtils.a(WiFiValidatedFragment.class);

   protected abstract void a();

   protected abstract void a(MenuItem var1);

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492867, var1);
      super.onCreateOptionsMenu(var1, var2);
      ImageUtils.a(this.getActivity(), var1);
      this.a(var1.findItem(2131296294));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296294 == var1.getItemId()) {
         this.a();
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }
}
