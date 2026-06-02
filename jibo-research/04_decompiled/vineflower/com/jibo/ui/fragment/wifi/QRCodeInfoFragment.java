package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import butterknife.OnClick;
import java.util.ArrayList;

public class QRCodeInfoFragment extends WiFiBaseFragment {
   private final ArrayList<View> a;

   private void b(ActionBar var1) {
      var1.setBackgroundDrawable(new ColorDrawable(-1));
      var1.setHomeAsUpIndicator(2131230811);
   }

   @Override
   protected void a(ActionBar var1) {
      super.a(var1);
      this.b(var1);
   }

   @Override
   protected String o() {
      return this.getString(2131756082);
   }

   @OnClick
   public void onContinue(View var1) {
      this.getActivity().finish();
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492869, var1);
      super.onCreateOptionsMenu(var1, var2);
      TextView var3;
      if (!this.a.isEmpty()) {
         var3 = (TextView)this.a.get(0);
      } else {
         var3 = null;
      }

      if (var3 != null) {
         var3.setTextColor(this.getResources().getColor(2131099771));
      } else {
         View var4 = this.getActivity().getWindow().getDecorView();
         var4.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this, var4) {
            final View a;
            final QRCodeInfoFragment b;

            {
               this.b = var1;
               this.a = var2x;
            }

            public void onGlobalLayout() {
               this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
               this.a.findViewsWithText(this.b.a, this.b.getString(2131755049), 2);
               this.b.getActivity().invalidateOptionsMenu();
            }
         });
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427490, var2, false);
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
