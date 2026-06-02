package com.salesforce.androidsdk.ui;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.LoginServerManager;

public class CustomServerUrlEditor extends DialogFragment {
   boolean a;
   private SalesforceR b;
   private LoginServerManager c;
   private Context d = SalesforceSDKManager.a().k();
   private View e;

   public CustomServerUrlEditor() {
      this.b = SalesforceSDKManager.a().e();
      this.c = SalesforceSDKManager.a().l();
   }

   private String a(int var1) {
      EditText var3 = (EditText)this.e.findViewById(var1);
      Editable var4 = var3.getText();
      boolean var2;
      if (!var4.toString().equals(this.b(var1)) && !var4.toString().equals("")) {
         var2 = false;
      } else {
         var2 = true;
      }

      if (var1 == this.b.N()) {
         boolean var5;
         if (!URLUtil.isHttpsUrl(var4.toString())) {
            var5 = true;
         } else {
            var5 = false;
         }

         var2 = var5;
         if (var5) {
            Toast.makeText(this.d, this.getString(this.b.V()), 0).show();
            var2 = var5;
         }
      }

      String var6;
      if (var2) {
         var3.selectAll();
         var3.requestFocus();
         var6 = null;
      } else {
         var6 = var4.toString();
      }

      return var6;
   }

   private void a(int var1, String var2) {
      if (var2 == null) {
         throw new RuntimeException("Value cannot be null");
      }

      EditText var3 = (EditText)this.e.findViewById(var1);
      SpannableString var4 = new SpannableString(var2);
      if (var3 != null) {
         var3.setText(var4);
         if (var3.getOnFocusChangeListener() == null) {
            var3.setOnFocusChangeListener(new OnFocusChangeListener(this) {
               final CustomServerUrlEditor a;

               {
                  this.a = var1;
               }

               public void onFocusChange(View var1, boolean var2x) {
                  EditText var4x = (EditText)var1;
                  boolean var3x = var4x.getText().toString().equals(this.a.b(var4x.getId()));
                  if (var2x && var3x) {
                     var4x.getText().clear();
                  } else if (!var2x && var4x.getText().toString().equals("")) {
                     if (var4x.getId() == this.a.b.M()) {
                        this.a.a(this.a.b.M(), this.a.b(var4x.getId()));
                     } else {
                        this.a.a(this.a.b.N(), this.a.b(var4x.getId()));
                     }
                  }
               }
            });
         }
      }
   }

   private String b(int var1) {
      String var2;
      if (var1 == this.b.M()) {
         var2 = this.getString(this.b.O());
      } else {
         var2 = this.getString(this.b.P());
      }

      return var2;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.e = var1.inflate(this.b.S(), var2);
      String var4 = this.b(this.b.M());
      String var5 = this.b(this.b.N());
      this.a = var5.equals(this.getString(this.b.P()));
      if (this.a) {
         this.getDialog().setTitle(this.b.Q());
      } else {
         this.getDialog().setTitle(this.b.R());
      }

      this.a(this.b.M(), var4);
      this.a(this.b.N(), var5);
      ((Button)this.e.findViewById(this.b.T())).setOnClickListener(new OnClickListener(this) {
         final CustomServerUrlEditor a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            String var3x = this.a.a(this.a.b.M());
            if (var3x != null) {
               String var2x = this.a.a(this.a.b.N());
               if (var2x != null) {
                  this.a.c.a(var3x, var2x);
                  this.a.dismiss();
               }
            }
         }
      });
      ((Button)this.e.findViewById(this.b.U())).setOnClickListener(new OnClickListener(this) {
         final CustomServerUrlEditor a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.dismiss();
         }
      });
      return this.e;
   }

   public void onDismiss(DialogInterface var1) {
      ServerPickerActivity var2 = (ServerPickerActivity)this.getActivity();
      if (var2 != null) {
         var2.c();
      }
   }
}
