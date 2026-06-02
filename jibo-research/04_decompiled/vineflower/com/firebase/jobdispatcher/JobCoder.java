package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class JobCoder {
   private final String a;

   JobCoder(String var1) {
      this.a = var1;
   }

   private static String a(List<ObservedUri> var0) {
      JSONObject var2 = new JSONObject();
      JSONArray var3 = new JSONArray();
      JSONArray var1 = new JSONArray();

      for (ObservedUri var4 : var0) {
         var3.put(var4.b());
         var1.put(var4.a());
      }

      try {
         var2.put("uri_flags", var3);
         var2.put("uris", var1);
      } catch (JSONException var5) {
         throw new RuntimeException(var5);
      }

      return var2.toString();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static List<ObservedUri> a(String var0) {
      ArrayList var4 = new ArrayList();

      int var2;
      JSONArray var11;
      try {
         JSONObject var5 = new JSONObject(var0);
         var10 = var5.getJSONArray("uri_flags");
         var11 = var5.getJSONArray("uris");
         var2 = var10.length();
      } catch (JSONException var9) {
         throw new RuntimeException(var9);
      }

      for (int var1 = 0; var1 < var2; var1++) {
         try {
            int var3 = var10.getInt(var1);
            String var6 = var11.getString(var1);
            ObservedUri var7 = new ObservedUri(Uri.parse(var6), var3);
            var4.add(var7);
         } catch (JSONException var8) {
            throw new RuntimeException(var8);
         }
      }

      return var4;
   }

   private void a(JobTrigger var1, Bundle var2) {
      if (var1 == Trigger.a) {
         var2.putInt(this.a + "trigger_type", 2);
      } else if (var1 instanceof JobTrigger.ExecutionWindowTrigger) {
         JobTrigger.ExecutionWindowTrigger var3 = (JobTrigger.ExecutionWindowTrigger)var1;
         var2.putInt(this.a + "trigger_type", 1);
         var2.putInt(this.a + "window_start", var3.a());
         var2.putInt(this.a + "window_end", var3.b());
      } else {
         if (!(var1 instanceof JobTrigger.ContentUriTrigger)) {
            throw new IllegalArgumentException("Unsupported trigger.");
         }

         var2.putInt(this.a + "trigger_type", 3);
         String var4 = a(((JobTrigger.ContentUriTrigger)var1).a());
         var2.putString(this.a + "observed_uris", var4);
      }
   }

   private void a(RetryStrategy var1, Bundle var2) {
      RetryStrategy var3 = var1;
      if (var1 == null) {
         var3 = RetryStrategy.a;
      }

      var2.putInt(this.a + "retry_policy", var3.a());
      var2.putInt(this.a + "initial_backoff_seconds", var3.b());
      var2.putInt(this.a + "maximum_backoff_seconds", var3.c());
   }

   private JobTrigger c(Bundle var1) {
      JobTrigger var2;
      switch (var1.getInt(this.a + "trigger_type")) {
         case 1:
            var2 = Trigger.a(var1.getInt(this.a + "window_start"), var1.getInt(this.a + "window_end"));
            break;
         case 2:
            var2 = Trigger.a;
            break;
         case 3:
            var2 = Trigger.a(Collections.unmodifiableList(a(var1.getString(this.a + "observed_uris"))));
            break;
         default:
            if (Log.isLoggable("FJD.ExternalReceiver", 3)) {
               Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
            }

            var2 = null;
      }

      return var2;
   }

   private RetryStrategy d(Bundle var1) {
      int var2 = var1.getInt(this.a + "retry_policy");
      RetryStrategy var3;
      if (var2 != 1 && var2 != 2) {
         var3 = RetryStrategy.a;
      } else {
         var3 = new RetryStrategy(var2, var1.getInt(this.a + "initial_backoff_seconds"), var1.getInt(this.a + "maximum_backoff_seconds"));
      }

      return var3;
   }

   Bundle a(JobParameters var1, Bundle var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("Unexpected null Bundle provided");
      }

      Bundle var3 = var1.b();
      if (var3 != null) {
         var2.putAll(var3);
      }

      var2.putInt(this.a + "persistent", var1.g());
      var2.putBoolean(this.a + "recurring", var1.h());
      var2.putBoolean(this.a + "replace_current", var1.d());
      var2.putString(this.a + "tag", var1.e());
      var2.putString(this.a + "service", var1.i());
      var2.putInt(this.a + "constraints", Constraint.a(var1.a()));
      this.a(var1.f(), var2);
      this.a(var1.c(), var2);
      return var2;
   }

   JobInvocation a(Bundle var1) {
      JobInvocation var2 = null;
      if (var1 == null) {
         Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
      } else {
         Bundle var3 = var1.getBundle("extras");
         if (var3 != null) {
            JobInvocation.Builder var5 = this.b(var3);
            ArrayList var4 = var1.getParcelableArrayList("triggered_uris");
            if (var4 != null) {
               var5.a(new TriggerReason(var4));
            }

            var2 = var5.a();
         }
      }

      return var2;
   }

   public JobInvocation.Builder b(Bundle var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Unexpected null Bundle provided");
      }

      Bundle var5 = new Bundle(var1);
      boolean var3 = var5.getBoolean(this.a + "recurring");
      boolean var4 = var5.getBoolean(this.a + "replace_current");
      int var2 = var5.getInt(this.a + "persistent");
      int[] var6 = Constraint.a(var5.getInt(this.a + "constraints"));
      JobTrigger var8 = this.c(var5);
      RetryStrategy var7 = this.d(var5);
      String var10 = var5.getString(this.a + "tag");
      String var9 = var5.getString(this.a + "service");
      JobInvocation.Builder var11;
      if (var10 != null && var9 != null && var8 != null && var7 != null) {
         var11 = new JobInvocation.Builder();
         var11.a(var10);
         var11.b(var9);
         var11.a(var8);
         var11.a(var7);
         var11.a(var3);
         var11.a(var2);
         var11.a(var6);
         var11.b(var4);
         if (!TextUtils.isEmpty(this.a)) {
            Iterator var12 = var5.keySet().iterator();

            while (var12.hasNext()) {
               if (((String)var12.next()).startsWith(this.a)) {
                  var12.remove();
               }
            }
         }

         var11.a(var5);
      } else {
         var11 = null;
      }

      return var11;
   }
}
