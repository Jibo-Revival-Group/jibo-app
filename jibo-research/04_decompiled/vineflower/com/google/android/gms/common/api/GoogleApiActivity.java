package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zzbm;

public class GoogleApiActivity extends Activity implements OnCancelListener {
   private int a = 0;

   public static PendingIntent a(Context var0, PendingIntent var1, int var2) {
      return PendingIntent.getActivity(var0, 0, a(var0, var1, var2, true), 134217728);
   }

   public static Intent a(Context var0, PendingIntent var1, int var2, boolean var3) {
      Intent var4 = new Intent(var0, GoogleApiActivity.class);
      var4.putExtra("pending_intent", var1);
      var4.putExtra("failing_client_id", var2);
      var4.putExtra("notify_manager", var3);
      return var4;
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 1) {
         boolean var4 = this.getIntent().getBooleanExtra("notify_manager", true);
         this.a = 0;
         this.setResult(var2, var3);
         if (var4) {
            zzbm var5 = zzbm.a(this);
            switch (var2) {
               case -1:
                  var5.d();
                  break;
               case 0:
                  var5.b(new ConnectionResult(13, null), this.getIntent().getIntExtra("failing_client_id", -1));
            }
         }
      } else if (var1 == 2) {
         this.a = 0;
         this.setResult(var2, var3);
      }

      this.finish();
   }

   public void onCancel(DialogInterface var1) {
      this.a = 0;
      this.setResult(0);
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (var1 != null) {
         this.a = var1.getInt("resolution");
      }

      if (this.a != 1) {
         Bundle var2 = this.getIntent().getExtras();
         if (var2 == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            this.finish();
         } else {
            PendingIntent var4 = (PendingIntent)var2.get("pending_intent");
            Integer var5 = (Integer)var2.get("error_code");
            if (var4 == null && var5 == null) {
               Log.e("GoogleApiActivity", "Activity started without resolution");
               this.finish();
            } else if (var4 != null) {
               try {
                  this.startIntentSenderForResult(var4.getIntentSender(), 1, null, 0, 0, 0);
                  this.a = 1;
               } catch (SendIntentException var3) {
                  Log.e("GoogleApiActivity", "Failed to launch pendingIntent", var3);
                  this.finish();
               }
            } else {
               GoogleApiAvailability.a().b(this, var5, 2, this);
               this.a = 1;
            }
         }
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      var1.putInt("resolution", this.a);
      super.onSaveInstanceState(var1);
   }
}
