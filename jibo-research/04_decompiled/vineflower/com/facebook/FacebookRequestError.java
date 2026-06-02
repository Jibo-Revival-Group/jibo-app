package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
   private static final String BODY_KEY = "body";
   private static final String CODE_KEY = "code";
   public static final Creator<FacebookRequestError> CREATOR = new Creator<FacebookRequestError>() {
      public FacebookRequestError createFromParcel(Parcel var1) {
         return new FacebookRequestError(var1);
      }

      public FacebookRequestError[] newArray(int var1) {
         return new FacebookRequestError[var1];
      }
   };
   private static final String ERROR_CODE_FIELD_KEY = "code";
   private static final String ERROR_CODE_KEY = "error_code";
   private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
   private static final String ERROR_KEY = "error";
   private static final String ERROR_MESSAGE_FIELD_KEY = "message";
   private static final String ERROR_MSG_KEY = "error_msg";
   private static final String ERROR_REASON_KEY = "error_reason";
   private static final String ERROR_SUB_CODE_KEY = "error_subcode";
   private static final String ERROR_TYPE_FIELD_KEY = "type";
   private static final String ERROR_USER_MSG_KEY = "error_user_msg";
   private static final String ERROR_USER_TITLE_KEY = "error_user_title";
   static final FacebookRequestError.Range HTTP_RANGE_SUCCESS = new FacebookRequestError.Range(200, 299);
   public static final int INVALID_ERROR_CODE = -1;
   public static final int INVALID_HTTP_STATUS_CODE = -1;
   private final Object batchRequestResult;
   private final FacebookRequestError.Category category;
   private final HttpURLConnection connection;
   private final int errorCode;
   private final String errorMessage;
   private final String errorRecoveryMessage;
   private final String errorType;
   private final String errorUserMessage;
   private final String errorUserTitle;
   private final FacebookException exception;
   private final JSONObject requestResult;
   private final JSONObject requestResultBody;
   private final int requestStatusCode;
   private final int subErrorCode;

   private FacebookRequestError(
      int var1,
      int var2,
      int var3,
      String var4,
      String var5,
      String var6,
      String var7,
      boolean var8,
      JSONObject var9,
      JSONObject var10,
      Object var11,
      HttpURLConnection var12,
      FacebookException var13
   ) {
      this.requestStatusCode = var1;
      this.errorCode = var2;
      this.subErrorCode = var3;
      this.errorType = var4;
      this.errorMessage = var5;
      this.requestResultBody = var9;
      this.requestResult = var10;
      this.batchRequestResult = var11;
      this.connection = var12;
      this.errorUserTitle = var6;
      this.errorUserMessage = var7;
      boolean var14 = false;
      if (var13 != null) {
         this.exception = var13;
         var14 = true;
      } else {
         this.exception = new FacebookServiceException(this, var5);
      }

      FacebookRequestErrorClassification var16 = getErrorClassification();
      FacebookRequestError.Category var15;
      if (var14) {
         var15 = FacebookRequestError.Category.OTHER;
      } else {
         var15 = var16.classify(var2, var3, var8);
      }

      this.category = var15;
      this.errorRecoveryMessage = var16.getRecoveryMessage(this.category);
   }

   public FacebookRequestError(int var1, String var2, String var3) {
      this(-1, var1, -1, var2, var3, null, null, false, null, null, null, null, null);
   }

   private FacebookRequestError(Parcel var1) {
      this(
         var1.readInt(),
         var1.readInt(),
         var1.readInt(),
         var1.readString(),
         var1.readString(),
         var1.readString(),
         var1.readString(),
         false,
         null,
         null,
         null,
         null,
         null
      );
   }

   FacebookRequestError(HttpURLConnection var1, Exception var2) {
      if (var2 instanceof FacebookException) {
         var2 = var2;
      } else {
         var2 = new FacebookException(var2);
      }

      this(-1, -1, -1, null, null, null, null, false, null, null, null, var1, var2);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static FacebookRequestError checkResponseAndCreateError(JSONObject var0, Object var1, HttpURLConnection var2) {
      int var6;
      Object var9;
      try {
         if (!var0.has("code")) {
            return null;
         }

         var6 = var0.getInt("code");
         var9 = (JSONObject)Utility.getStringPropertyAsJSON(var0, "body", "FACEBOOK_NON_JSON_RESULT");
      } catch (JSONException var24) {
         return null;
      }

      label94:
      if (var9 != null) {
         JSONObject var15;
         try {
            if (!(var9 instanceof JSONObject)) {
               break label94;
            }

            var15 = var9;
         } catch (JSONException var23) {
            return null;
         }

         String var26 = null;
         String var10 = null;
         JSONObject var13 = null;
         Object var14 = null;
         boolean var8 = false;
         int var4 = -1;
         int var5 = -1;
         boolean var3 = false;

         boolean var7;
         String var11;
         String var12;
         label86: {
            label105: {
               try {
                  if (var15.has("error")) {
                     var13 = (JSONObject)Utility.getStringPropertyAsJSON(var15, "error", null);
                     var26 = var13.optString("type", null);
                     var10 = var13.optString("message", null);
                     var4 = var13.optInt("code", -1);
                     var5 = var13.optInt("error_subcode", -1);
                     var11 = var13.optString("error_user_msg", null);
                     var12 = var13.optString("error_user_title", null);
                     var7 = var13.optBoolean("is_transient", false);
                     break label105;
                  }
               } catch (JSONException var22) {
                  return null;
               }

               label106: {
                  try {
                     if (var15.has("error_code") || var15.has("error_msg")) {
                        break label106;
                     }
                  } catch (JSONException var21) {
                     return null;
                  }

                  var12 = (String)var14;
                  var11 = var13;
                  var7 = var8;

                  try {
                     if (!var15.has("error_reason")) {
                        break label86;
                     }
                  } catch (JSONException var20) {
                     return null;
                  }
               }

               try {
                  var26 = var15.optString("error_reason", null);
                  var10 = var15.optString("error_msg", null);
                  var4 = var15.optInt("error_code", -1);
                  var5 = var15.optInt("error_subcode", -1);
               } catch (JSONException var19) {
                  return null;
               }

               var3 = true;
               var12 = (String)var14;
               var11 = var13;
               var7 = var8;
               break label86;
            }

            var3 = true;
         }

         if (var3) {
            try {
               var29 = new FacebookRequestError(var6, var4, var5, var26, var10, var12, var11, var7, var15, var0, var1, var2, null);
            } catch (JSONException var17) {
               return null;
            }

            return var29;
         }
      }

      label63: {
         try {
            if (HTTP_RANGE_SUCCESS.contains(var6)) {
               return null;
            }

            if (var0.has("body")) {
               var9 = (JSONObject)Utility.getStringPropertyAsJSON(var0, "body", "FACEBOOK_NON_JSON_RESULT");
               break label63;
            }
         } catch (JSONException var18) {
            return null;
         }

         var9 = null;
      }

      try {
         return new FacebookRequestError(var6, -1, -1, null, null, null, null, false, var9, var0, var1, var2, null);
      } catch (JSONException var16) {
         return null;
      }
   }

   static FacebookRequestErrorClassification getErrorClassification() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/facebook/FacebookRequestError
      // 02: monitorenter
      // 03: invokestatic com/facebook/FacebookSdk.getApplicationId ()Ljava/lang/String;
      // 06: invokestatic com/facebook/internal/FetchedAppSettingsManager.getAppSettingsWithoutQuery (Ljava/lang/String;)Lcom/facebook/internal/FetchedAppSettings;
      // 09: astore 0
      // 0a: aload 0
      // 0b: ifnonnull 17
      // 0e: invokestatic com/facebook/internal/FacebookRequestErrorClassification.getDefaultErrorClassification ()Lcom/facebook/internal/FacebookRequestErrorClassification;
      // 11: astore 0
      // 12: ldc com/facebook/FacebookRequestError
      // 14: monitorexit
      // 15: aload 0
      // 16: areturn
      // 17: aload 0
      // 18: invokevirtual com/facebook/internal/FetchedAppSettings.getErrorClassification ()Lcom/facebook/internal/FacebookRequestErrorClassification;
      // 1b: astore 0
      // 1c: goto 12
      // 1f: astore 0
      // 20: ldc com/facebook/FacebookRequestError
      // 22: monitorexit
      // 23: aload 0
      // 24: athrow
      // try (2 -> 5): 17 null
      // try (7 -> 9): 17 null
      // try (13 -> 16): 17 null
   }

   public int describeContents() {
      return 0;
   }

   public Object getBatchRequestResult() {
      return this.batchRequestResult;
   }

   public FacebookRequestError.Category getCategory() {
      return this.category;
   }

   public HttpURLConnection getConnection() {
      return this.connection;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getErrorMessage() {
      String var1;
      if (this.errorMessage != null) {
         var1 = this.errorMessage;
      } else {
         var1 = this.exception.getLocalizedMessage();
      }

      return var1;
   }

   public String getErrorRecoveryMessage() {
      return this.errorRecoveryMessage;
   }

   public String getErrorType() {
      return this.errorType;
   }

   public String getErrorUserMessage() {
      return this.errorUserMessage;
   }

   public String getErrorUserTitle() {
      return this.errorUserTitle;
   }

   public FacebookException getException() {
      return this.exception;
   }

   public JSONObject getRequestResult() {
      return this.requestResult;
   }

   public JSONObject getRequestResultBody() {
      return this.requestResultBody;
   }

   public int getRequestStatusCode() {
      return this.requestStatusCode;
   }

   public int getSubErrorCode() {
      return this.subErrorCode;
   }

   @Override
   public String toString() {
      return "{HttpStatus: "
         + this.requestStatusCode
         + ", errorCode: "
         + this.errorCode
         + ", errorType: "
         + this.errorType
         + ", errorMessage: "
         + this.getErrorMessage()
         + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.requestStatusCode);
      var1.writeInt(this.errorCode);
      var1.writeInt(this.subErrorCode);
      var1.writeString(this.errorType);
      var1.writeString(this.errorMessage);
      var1.writeString(this.errorUserTitle);
      var1.writeString(this.errorUserMessage);
   }

   public enum Category {
      LOGIN_RECOVERABLE,
      OTHER,
      TRANSIENT;

      private static final FacebookRequestError.Category[] $VALUES = new FacebookRequestError.Category[]{
         FacebookRequestError.Category.LOGIN_RECOVERABLE, FacebookRequestError.Category.OTHER, FacebookRequestError.Category.TRANSIENT
      };
   }

   private static class Range {
      private final int end;
      private final int start;

      private Range(int var1, int var2) {
         this.start = var1;
         this.end = var2;
      }

      boolean contains(int var1) {
         boolean var2;
         if (this.start <= var1 && var1 <= this.end) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
