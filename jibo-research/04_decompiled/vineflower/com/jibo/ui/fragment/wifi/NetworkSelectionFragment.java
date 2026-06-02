package com.jibo.ui.fragment.wifi;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.ui.activity.BaseActivity;
import com.jibo.utils.LogUtils;
import com.jibo.utils.Util;

public class NetworkSelectionFragment extends WiFiBaseFragment {
   public static final String a = LogUtils.a(NetworkSelectionFragment.class);
   @BindView
   TextView btnSelectCurrentNetwork;
   @BindView
   ViewGroup cntNetworkOn;
   @BindView
   ViewGroup cntNoNetwork;
   @BindView
   TextView textStep2Message;

   private String a() {
      WifiManager var3 = (WifiManager)this.getActivity().getApplicationContext().getSystemService("wifi");
      WifiInfo var1 = var3.getConnectionInfo();
      ConnectivityManager var2 = (ConnectivityManager)this.getActivity().getSystemService("connectivity");
      String var4;
      if (var3.isWifiEnabled()
         && var1 != null
         && !TextUtils.isEmpty(var1.getSSID())
         && !var1.getSSID().equals("0x")
         && !"<unknown ssid>".equals(var1.getSSID())
         && var2.getActiveNetworkInfo() != null
         && var2.getActiveNetworkInfo().isConnected()
         && var2.getActiveNetworkInfo().isAvailable()) {
         var4 = Util.a(var1.getSSID());
      } else {
         var4 = "";
      }

      return var4;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void q() {
      byte var2 = 0;

      byte var1;
      String var3;
      ViewGroup var4;
      label35: {
         label34: {
            try {
               var3 = this.a();
               var4 = this.cntNoNetwork;
               if (TextUtils.isEmpty(var3)) {
                  break label34;
               }
            } catch (Exception var7) {
               return;
            }

            var1 = 8;
            break label35;
         }

         var1 = 0;
      }

      label27: {
         label26: {
            try {
               var4.setVisibility(var1);
               var4 = this.cntNetworkOn;
               if (!TextUtils.isEmpty(var3)) {
                  break label26;
               }
            } catch (Exception var6) {
               return;
            }

            var1 = 8;
            break label27;
         }

         var1 = var2;
      }

      try {
         var4.setVisibility(var1);
         this.textStep2Message.setText(Html.fromHtml(String.format(this.getString(2131755482), var3)));
         this.btnSelectCurrentNetwork.setText(Html.fromHtml(String.format(this.getString(2131756105), var3)));
      } catch (Exception var5) {
      }
   }

   @Override
   protected String o() {
      return this.getString(2131756079);
   }

   @Override
   public void onActivityResult(int var1, int var2, Intent var3) {
      switch (var1) {
         case 1000:
            this.q();
            break;
         default:
            super.onActivityResult(var1, var2, var3);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427487, var2, false);
   }

   @OnClick
   public void onEnterNetworkManually(View var1) {
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).c(NetworkNameFragment.class, var2);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
   }

   @OnClick
   public void onSelectCurrentNetwork(View var1) {
      e.putString("ARG_SSID", this.a());
      Bundle var2 = new Bundle();
      var2.putParcelable(Loop.class.getSimpleName(), this.k);
      ((BaseActivity)this.getActivity()).c(NetworkPwdFragment.class, var2);
   }

   @OnClick
   public void onSelectOtherNetwork(View var1) {
      this.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), 1000);
   }

   @OnClick
   public void onShowMacFilteringInfo(View var1) {
      ((BaseActivity)this.getActivity()).c(MacAddressFragment.class, null);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.q();
      e.clear();
   }
}
