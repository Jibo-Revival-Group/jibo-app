package com.jibo.ui.fragment.wifi;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.utils.Commons;
import com.jibo.utils.SubnetUtils;
import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class StaticOptionsDialogFragment extends DialogFragment {
   Unbinder a;
   @BindView
   EditText editDns1;
   @BindView
   EditText editDns2;
   @BindView
   EditText editIpAddress;
   @BindView
   EditText editRouter;
   @BindView
   EditText editSubnetMask;

   private String a() {
      String var1 = "";

      String var2;
      try {
         var2 = this.editIpAddress.getText().toString().trim();
      } catch (Exception var3) {
         return var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean a(EditText var1, EditText var2, EditText var3) {
      String var6 = "";
      String var8 = "";
      String var5 = var8;

      label54: {
         String var7;
         try {
            var7 = var1.getText().toString().trim();
         } catch (Exception var13) {
            var15 = "";
            var14 = var5;
            var5 = var6;
            break label54;
         }

         var5 = var8;
         var6 = var7;

         try {
            var14 = var2.getText().toString().trim();
         } catch (Exception var12) {
            var15 = "";
            var14 = var5;
            var5 = var6;
            break label54;
         }

         var5 = var14;
         var6 = var7;

         try {
            var15 = var3.getText().toString().trim();
         } catch (Exception var11) {
            var15 = "";
            var14 = var5;
            var5 = var6;
            break label54;
         }

         var5 = var7;
      }

      try {
         SubnetUtils var22 = new SubnetUtils(var5, var15);
         SubnetUtils var19 = new SubnetUtils(var14, var15);
         if (!var22.a().a().equals(var19.a().a())) {
            ((TextInputLayout)var3.getParent()).setError(this.getString(2131756095));
            var3.requestFocus();
            return false;
         }
      } catch (IllegalArgumentException var10) {
         var3.requestFocus();
         ((TextInputLayout)var3.getParent()).setError(this.getString(2131756095));
         return false;
      }

      try {
         ((TextInputLayout)var3.getParent()).setError(null);
         ((TextInputLayout)var3.getParent()).setErrorEnabled(false);
      } catch (IllegalArgumentException var9) {
         var3.requestFocus();
         ((TextInputLayout)var3.getParent()).setError(this.getString(2131756095));
         return false;
      }

      return true;
   }

   private boolean a(EditText var1, Pattern var2) {
      String var4 = "";

      label22: {
         String var5;
         try {
            var5 = var1.getText().toString().trim();
         } catch (Exception var6) {
            break label22;
         }

         var4 = var5;
      }

      boolean var3;
      if (!var4.isEmpty() && !var2.matcher(var4).matches()) {
         ((TextInputLayout)var1.getParent()).setError(this.getString(2131756094));
         var1.requestFocus();
         var3 = false;
      } else {
         ((TextInputLayout)var1.getParent()).setError(null);
         ((TextInputLayout)var1.getParent()).setErrorEnabled(false);
         var3 = true;
      }

      return var3;
   }

   private String b() {
      String var1 = "";

      String var2;
      try {
         var2 = this.editSubnetMask.getText().toString().trim();
      } catch (Exception var3) {
         return var1;
      }

      return var2;
   }

   private String c() {
      String var1 = "";

      String var2;
      try {
         var2 = this.editRouter.getText().toString().trim();
      } catch (Exception var3) {
         return var1;
      }

      return var2;
   }

   private String d() {
      String var1 = "";

      String var2;
      try {
         var2 = this.editDns1.getText().toString().trim();
      } catch (Exception var3) {
         return var1;
      }

      return var2;
   }

   private String e() {
      String var1 = "";

      String var2;
      try {
         var2 = this.editDns2.getText().toString().trim();
      } catch (Exception var3) {
         return var1;
      }

      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private boolean f() {
      boolean var1 = true;

      boolean var2;
      try {
         var2 = this.a(this.editIpAddress, Patterns.IP_ADDRESS);
      } catch (InvalidParameterException var15) {
         var1 = false;
         return var1;
      } catch (Exception var16) {
         return var1;
      }

      var1 = var2;

      try {
         var2 &= this.a(this.editSubnetMask, Patterns.IP_ADDRESS);
      } catch (InvalidParameterException var13) {
         var1 = false;
         return var1;
      } catch (Exception var14) {
         return var1;
      }

      var1 = var2;

      boolean var3;
      try {
         var3 = var2 & this.a(this.editRouter, Patterns.IP_ADDRESS);
      } catch (InvalidParameterException var11) {
         var1 = false;
         return var1;
      } catch (Exception var12) {
         return var1;
      }

      var2 = var3;
      if (var3) {
         var1 = var3;

         try {
            var2 = var3 & this.a(this.editIpAddress, this.editRouter, this.editSubnetMask);
         } catch (InvalidParameterException var9) {
            var1 = false;
            return var1;
         } catch (Exception var10) {
            return var1;
         }
      }

      var1 = var2;

      try {
         var2 &= this.a(this.editDns1, Commons.f);
      } catch (InvalidParameterException var7) {
         var1 = false;
         return var1;
      } catch (Exception var8) {
         return var1;
      }

      var1 = var2;

      try {
         var3 = this.a(this.editDns2, Commons.f);
      } catch (InvalidParameterException var5) {
         var1 = false;
         return var1;
      } catch (Exception var6) {
         return var1;
      }

      return var2 & var3;
   }

   @OnClick
   public void onCancelClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      TextView var3 = (TextView)LayoutInflater.from(this.getActivity()).inflate(2131427417, null);
      var3.setText(2131755275);
      View var2 = LayoutInflater.from(this.getActivity()).inflate(2131427416, null);
      AlertDialog.Builder var4 = new AlertDialog.Builder(this.getActivity()).a(var3).b(var2).a(true);
      this.a = ButterKnife.a(this, var2);
      if (var1 == null) {
         this.editIpAddress.setText(this.getArguments().getString("ARG_IPADDRESS", this.getString(2131755782)));
         this.editSubnetMask.setText(this.getArguments().getString("ARG_SUBNETMASK", this.getString(2131755782)));
         this.editRouter.setText(this.getArguments().getString("ARG_ROUTER", this.getString(2131755782)));
         this.editDns1.setText(this.getArguments().getString("ARG_DNS1", this.getString(2131755780)));
         this.editDns2.setText(this.getArguments().getString("ARG_DNS2", this.getString(2131755781)));
      }

      return var4.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }

   @OnClick
   public void onSetClicked(View var1) {
      if (this.f()) {
         if (this.getTargetFragment() != null && this.getTargetFragment() instanceof StaticOptionsDialogFragment.OnStaticOptionsChangeListener) {
            ((StaticOptionsDialogFragment.OnStaticOptionsChangeListener)this.getTargetFragment()).a(this.a(), this.b(), this.c(), this.d(), this.e());
         }

         this.dismiss();
      }
   }

   public interface OnStaticOptionsChangeListener {
      void a(String var1, String var2, String var3, String var4, String var5);
   }
}
