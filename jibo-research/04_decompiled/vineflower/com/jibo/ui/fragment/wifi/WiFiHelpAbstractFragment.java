package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.jibo.utils.LogUtils;

abstract class WiFiHelpAbstractFragment extends WiFiBaseFragment {
   public static final String l = LogUtils.a(WiFiHelpAbstractFragment.class);

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      var1.setHomeAsUpIndicator(2131230814);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492869, var1);
      super.onCreateOptionsMenu(var1, var2);
      var1.findItem(2131296296).setTitle(this.getString(2131755530));
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296296 == var1.getItemId()) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755752))));
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }
}
