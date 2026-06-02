package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class DefaultJobValidator implements JobValidator {
   private final Context a;

   public DefaultJobValidator(Context var1) {
      this.a = var1;
   }

   private static int a(Bundle var0) {
      Parcel var2 = Parcel.obtain();
      var0.writeToParcel(var2, 0);
      int var1 = var2.dataSize();
      var2.recycle();
      return var1;
   }

   private static String a(Bundle var0, String var1) {
      Object var2 = null;
      Locale var3 = null;
      Object var4 = var0.get(var1);
      String var5 = var3;
      if (var4 != null) {
         var5 = var3;
         if (!(var4 instanceof Integer)) {
            var5 = var3;
            if (!(var4 instanceof Long)) {
               var5 = var3;
               if (!(var4 instanceof Double)) {
                  var5 = var3;
                  if (!(var4 instanceof String)) {
                     if (var4 instanceof Boolean) {
                        var5 = var3;
                     } else {
                        var3 = Locale.US;
                        Class var6;
                        if (var4 == null) {
                           var6 = (Class)var2;
                        } else {
                           var6 = var4.getClass();
                        }

                        var5 = String.format(
                           var3,
                           "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean",
                           var6,
                           var1
                        );
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   private static List<String> a(List<String> var0, String var1) {
      if (var1 != null) {
         if (var0 == null) {
            var0 = c(var1);
         } else {
            Collections.addAll(var0, var1);
         }
      }

      return var0;
   }

   private static List<String> a(List<String> var0, List<String> var1) {
      List var2;
      if (var0 == null) {
         var2 = var1;
      } else {
         var2 = var0;
         if (var1 != null) {
            var0.addAll(var1);
            var2 = var0;
         }
      }

      return var2;
   }

   private static List<String> a(boolean var0, List<String> var1, String var2) {
      List var3 = var1;
      if (var0) {
         var3 = a(var1, var2);
      }

      return var3;
   }

   private static List<String> b(Bundle var0) {
      List var2;
      if (var0 != null) {
         Iterator var3 = var0.keySet().iterator();
         List var1 = null;

         while (true) {
            var2 = var1;
            if (!var3.hasNext()) {
               break;
            }

            var1 = a(var1, a(var0, (String)var3.next()));
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   private static List<String> b(String var0) {
      List var1;
      if (var0 == null) {
         var1 = c("Tag can't be null");
      } else if (var0.length() > 100) {
         var1 = c("Tag must be shorter than 100");
      } else {
         var1 = null;
      }

      return var1;
   }

   private static List<String> c(Bundle var0) {
      Object var2 = null;
      List var3;
      if (var0 == null) {
         var3 = (List)var2;
      } else {
         int var1 = a(var0);
         var3 = (List)var2;
         if (var1 > 10240) {
            var3 = c(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", var1, 10240));
         }
      }

      return var3;
   }

   private static List<String> c(String var0) {
      ArrayList var1 = new ArrayList();
      var1.add(var0);
      return var1;
   }

   @Override
   public List<String> a(JobParameters var1) {
      List var3 = a(a(null, this.a(var1.f())), this.a(var1.c()));
      List var2 = var3;
      if (var1.h()) {
         var2 = var3;
         if (var1.f() == Trigger.a) {
            var2 = a(var3, "ImmediateTriggers can't be used with recurring jobs");
         }
      }

      var3 = a(var2, c(var1.b()));
      var2 = var3;
      if (var1.g() > 1) {
         var2 = a(var3, b(var1.b()));
      }

      return a(a(var2, b(var1.e())), this.a(var1.i()));
   }

   public List<String> a(JobTrigger var1) {
      List var2;
      if (var1 != Trigger.a && !(var1 instanceof JobTrigger.ExecutionWindowTrigger) && !(var1 instanceof JobTrigger.ContentUriTrigger)) {
         var2 = c("Unknown trigger provided");
      } else {
         var2 = null;
      }

      return var2;
   }

   public List<String> a(RetryStrategy var1) {
      boolean var6 = true;
      int var3 = var1.a();
      int var2 = var1.b();
      int var4 = var1.c();
      boolean var5;
      if (var3 != 1 && var3 != 2) {
         var5 = true;
      } else {
         var5 = false;
      }

      List var7 = a(var5, null, "Unknown retry policy provided");
      if (var4 < var2) {
         var5 = true;
      } else {
         var5 = false;
      }

      List var8 = a(var5, var7, "Maximum backoff must be greater than or equal to initial backoff");
      if (300 > var4) {
         var5 = true;
      } else {
         var5 = false;
      }

      List var9 = a(var5, var8, "Maximum backoff must be greater than 300s (5 minutes)");
      if (var2 < 30) {
         var5 = var6;
      } else {
         var5 = false;
      }

      return a(var5, var9, "Initial backoff must be at least 30s");
   }

   List<String> a(String var1) {
      List var4;
      if (var1 == null || var1.isEmpty()) {
         var4 = c("Service can't be empty");
      } else if (this.a == null) {
         var4 = c("Context is null, can't query PackageManager");
      } else {
         PackageManager var3 = this.a.getPackageManager();
         if (var3 == null) {
            var4 = c("PackageManager is null, can't validate service");
         } else {
            Intent var2 = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
            var2.setClassName(this.a, var1);
            List var5 = var3.queryIntentServices(var2, 0);
            if (var5 != null && !var5.isEmpty()) {
               Iterator var7 = var5.iterator();

               while (true) {
                  if (!var7.hasNext()) {
                     var4 = c(var1 + " is disabled.");
                     break;
                  }

                  ResolveInfo var6 = (ResolveInfo)var7.next();
                  if (var6.serviceInfo != null && var6.serviceInfo.enabled) {
                     var4 = null;
                     break;
                  }
               }
            } else {
               Log.e(
                  "FJD.GooglePlayReceiver",
                  "Couldn't find a registered service with the name "
                     + var1
                     + ". Is it declared in the manifest with the right intent-filter? If not, the job won't be started."
               );
               var4 = null;
            }
         }
      }

      return var4;
   }
}
