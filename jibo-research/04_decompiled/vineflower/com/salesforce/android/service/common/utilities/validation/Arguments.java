package com.salesforce.android.service.common.utilities.validation;

import android.content.Context;
import com.salesforce.android.service.common.utilities.R;
import java.util.regex.Pattern;

public class Arguments {
   private static final Pattern a = Pattern.compile(".{15}");
   private static final Pattern b = Pattern.compile(
      "[-\\w+\\.]+salesforceliveagent\\.com$|[-\\w+\\.]+sfm\\.ops\\.sfdc\\.net$|[-\\w+\\.]+salesforce\\.com$|^localhost(:[0-9]+)?|^laemulator.herokuapp.com$"
   );

   public static <T> T a(T var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         return (T)var0;
      }
   }

   public static <T> T a(T var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException(var1);
      } else {
         return (T)var0;
      }
   }

   public static void a(Context var0) {
      String var1 = var0.getResources().getString(R.string.account_type);
      String var2 = var0.getResources().getString(R.string.default_account_type);
      if (var1 == null || var1.equals(var2)) {
         throw new IllegalStateException("account_type string not set. This string resource must be set to prevent conflicts with other apps.");
      }
   }

   public static void a(String var0) {
      a(
         b.matcher(var0).matches(),
         "Invalid LiveAgent Pod name. Please confirm that you are using the FQDN of the pod and not the entire HTTP URL. Example: mypod.salesforceliveagent.com"
      );
   }

   public static void a(boolean var0, String var1) {
      if (!var0) {
         throw new IllegalArgumentException(var1);
      }
   }
}
