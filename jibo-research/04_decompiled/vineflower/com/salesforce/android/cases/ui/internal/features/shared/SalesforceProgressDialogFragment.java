package com.salesforce.android.cases.ui.internal.features.shared;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.cases.R;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;

public class SalesforceProgressDialogFragment extends AppCompatDialogFragment {
   public static SalesforceProgressDialogFragment a(int var0, int var1) {
      Bundle var2 = new Bundle();
      var2.putInt("title", var0);
      var2.putInt("message", var1);
      SalesforceProgressDialogFragment var3 = new SalesforceProgressDialogFragment();
      var3.setArguments(var2);
      return var3;
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(1, R.style.Widget_ServiceCase_Dialog);
      this.setShowsDialog(true);
      this.setCancelable(false);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(R.layout.fragment_salesforce_progress_dialog, var2, false);
      Bundle var5 = this.getArguments();
      if (var5 != null) {
         ((SalesforceTextView)var4.findViewById(R.id.progress_title)).setText(var5.getInt("title"));
         ((SalesforceTextView)var4.findViewById(R.id.progress_message)).setText(var5.getInt("message"));
      }

      return var4;
   }
}
