package com.salesforce.android.cases.ui.internal.features.publisher;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.salesforce.android.cases.R;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;

public class SalesforceConfirmationDialogFragment extends AppCompatDialogFragment {
   private SalesforceConfirmationDialogFragment.SalesforceConfirmationDialogListener a;

   public static SalesforceConfirmationDialogFragment a(int var0, int var1) {
      Bundle var3 = new Bundle();
      var3.putInt("title", var0);
      var3.putInt("message", var1);
      SalesforceConfirmationDialogFragment var2 = new SalesforceConfirmationDialogFragment();
      var2.setArguments(var3);
      return var2;
   }

   public void a(SalesforceConfirmationDialogFragment.SalesforceConfirmationDialogListener var1) {
      this.a = var1;
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
      View var4 = var1.inflate(R.layout.fragment_salesforce_confirmation_dialog, var2, false);
      Bundle var5 = this.getArguments();
      if (var5 != null) {
         ((SalesforceTextView)var4.findViewById(R.id.progress_title)).setText(var5.getInt("title"));
         ((SalesforceTextView)var4.findViewById(R.id.progress_message)).setText(var5.getInt("message"));
      }

      var4.findViewById(R.id.continue_button).setOnClickListener(new OnClickListener(this) {
         final SalesforceConfirmationDialogFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            if (this.a.a != null) {
               this.a.a.o();
            }
         }
      });
      var4.findViewById(R.id.cancel_button).setOnClickListener(new OnClickListener(this) {
         final SalesforceConfirmationDialogFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.getDialog().dismiss();
         }
      });
      return var4;
   }

   public interface SalesforceConfirmationDialogListener {
      void o();
   }
}
