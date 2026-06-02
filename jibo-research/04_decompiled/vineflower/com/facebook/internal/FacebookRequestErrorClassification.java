package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class FacebookRequestErrorClassification {
   public static final int EC_APP_TOO_MANY_CALLS = 4;
   public static final int EC_INVALID_SESSION = 102;
   public static final int EC_INVALID_TOKEN = 190;
   public static final int EC_RATE = 9;
   public static final int EC_SERVICE_UNAVAILABLE = 2;
   public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
   public static final int EC_USER_TOO_MANY_CALLS = 17;
   public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
   public static final String KEY_NAME = "name";
   public static final String KEY_OTHER = "other";
   public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
   public static final String KEY_TRANSIENT = "transient";
   private static FacebookRequestErrorClassification defaultInstance;
   private final Map<Integer, Set<Integer>> loginRecoverableErrors;
   private final String loginRecoverableRecoveryMessage;
   private final Map<Integer, Set<Integer>> otherErrors;
   private final String otherRecoveryMessage;
   private final Map<Integer, Set<Integer>> transientErrors;
   private final String transientRecoveryMessage;

   FacebookRequestErrorClassification(
      Map<Integer, Set<Integer>> var1, Map<Integer, Set<Integer>> var2, Map<Integer, Set<Integer>> var3, String var4, String var5, String var6
   ) {
      this.otherErrors = var1;
      this.transientErrors = var2;
      this.loginRecoverableErrors = var3;
      this.otherRecoveryMessage = var4;
      this.transientRecoveryMessage = var5;
      this.loginRecoverableRecoveryMessage = var6;
   }

   public static FacebookRequestErrorClassification createFromJSON(JSONArray var0) {
      String var2 = null;
      FacebookRequestErrorClassification var16;
      if (var0 == null) {
         var16 = var2;
      } else {
         int var1 = 0;
         var2 = null;
         String var3 = null;
         String var4 = null;
         Map var5 = null;
         Map var6 = null;
         Map var9 = null;

         while (var1 < var0.length()) {
            JSONObject var14 = var0.optJSONObject(var1);
            Map var7;
            Map var8;
            Map var10;
            String var11;
            String var12;
            String var13;
            if (var14 == null) {
               var13 = var2;
               var12 = var3;
               var11 = var4;
               var10 = var5;
               var8 = var6;
               var7 = var9;
            } else {
               String var15 = var14.optString("name");
               var7 = var9;
               var8 = var6;
               var10 = var5;
               var11 = var4;
               var12 = var3;
               var13 = var2;
               if (var15 != null) {
                  if (var15.equalsIgnoreCase("other")) {
                     var11 = var14.optString("recovery_message", null);
                     var7 = parseJSONDefinition(var14);
                     var8 = var6;
                     var10 = var5;
                     var12 = var3;
                     var13 = var2;
                  } else if (var15.equalsIgnoreCase("transient")) {
                     var12 = var14.optString("recovery_message", null);
                     var8 = parseJSONDefinition(var14);
                     var7 = var9;
                     var10 = var5;
                     var11 = var4;
                     var13 = var2;
                  } else {
                     var7 = var9;
                     var8 = var6;
                     var10 = var5;
                     var11 = var4;
                     var12 = var3;
                     var13 = var2;
                     if (var15.equalsIgnoreCase("login_recoverable")) {
                        var13 = var14.optString("recovery_message", null);
                        var10 = parseJSONDefinition(var14);
                        var7 = var9;
                        var8 = var6;
                        var11 = var4;
                        var12 = var3;
                     }
                  }
               }
            }

            var1++;
            var9 = var7;
            var6 = var8;
            var5 = var10;
            var4 = var11;
            var3 = var12;
            var2 = var13;
         }

         var16 = new FacebookRequestErrorClassification(var9, var6, var5, var4, var3, var2);
      }

      return var16;
   }

   public static FacebookRequestErrorClassification getDefaultErrorClassification() {
      synchronized (FacebookRequestErrorClassification.class) {
         if (defaultInstance == null) {
            defaultInstance = getDefaultErrorClassificationImpl();
         }

         return defaultInstance;
      }
   }

   private static FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
      return new FacebookRequestErrorClassification(null, new HashMap<Integer, Set<Integer>>() {
         {
            this.put(2, null);
            this.put(4, null);
            this.put(9, null);
            this.put(17, null);
            this.put(341, null);
         }
      }, new HashMap<Integer, Set<Integer>>() {
         {
            this.put(102, null);
            this.put(190, null);
         }
      }, null, null, null);
   }

   private static Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject var0) {
      HashMap var5 = null;
      JSONArray var6 = var0.optJSONArray("items");
      HashMap var8;
      if (var6.length() == 0) {
         var8 = var5;
      } else {
         var5 = new HashMap();

         for (int var1 = 0; var1 < var6.length(); var1++) {
            var0 = var6.optJSONObject(var1);
            if (var0 != null) {
               int var3 = var0.optInt("code");
               if (var3 != 0) {
                  JSONArray var7 = var0.optJSONArray("subcodes");
                  HashSet var10;
                  if (var7 != null && var7.length() > 0) {
                     var10 = new HashSet();

                     for (int var2 = 0; var2 < var7.length(); var2++) {
                        int var4 = var7.optInt(var2);
                        if (var4 != 0) {
                           var10.add(var4);
                        }
                     }
                  } else {
                     var10 = null;
                  }

                  var5.put(var3, var10);
               }
            }
         }

         var8 = var5;
      }

      return var8;
   }

   public FacebookRequestError.Category classify(int var1, int var2, boolean var3) {
      FacebookRequestError.Category var4;
      if (var3) {
         var4 = FacebookRequestError.Category.TRANSIENT;
      } else {
         if (this.otherErrors != null && this.otherErrors.containsKey(var1)) {
            Set var5 = this.otherErrors.get(var1);
            if (var5 == null || var5.contains(var2)) {
               var4 = FacebookRequestError.Category.OTHER;
               return var4;
            }
         }

         if (this.loginRecoverableErrors != null && this.loginRecoverableErrors.containsKey(var1)) {
            Set var6 = this.loginRecoverableErrors.get(var1);
            if (var6 == null || var6.contains(var2)) {
               var4 = FacebookRequestError.Category.LOGIN_RECOVERABLE;
               return var4;
            }
         }

         if (this.transientErrors != null && this.transientErrors.containsKey(var1)) {
            Set var7 = this.transientErrors.get(var1);
            if (var7 == null || var7.contains(var2)) {
               var4 = FacebookRequestError.Category.TRANSIENT;
               return var4;
            }
         }

         var4 = FacebookRequestError.Category.OTHER;
      }

      return var4;
   }

   public Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
      return this.loginRecoverableErrors;
   }

   public Map<Integer, Set<Integer>> getOtherErrors() {
      return this.otherErrors;
   }

   public String getRecoveryMessage(FacebookRequestError.Category var1) {
      String var2;
      switch (<unrepresentable>.$SwitchMap$com$facebook$FacebookRequestError$Category[var1.ordinal()]) {
         case 1:
            var2 = this.otherRecoveryMessage;
            break;
         case 2:
            var2 = this.loginRecoverableRecoveryMessage;
            break;
         case 3:
            var2 = this.transientRecoveryMessage;
            break;
         default:
            var2 = null;
      }

      return var2;
   }

   public Map<Integer, Set<Integer>> getTransientErrors() {
      return this.transientErrors;
   }
}
