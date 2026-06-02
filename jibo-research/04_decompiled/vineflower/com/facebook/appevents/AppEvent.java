package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class AppEvent implements Serializable {
   private static final long serialVersionUID = 1L;
   private static final HashSet<String> validatedIdentifiers = new HashSet<>();
   private final String checksum;
   private final boolean isImplicit;
   private final JSONObject jsonObject;
   private final String name;

   public AppEvent(String var1, String var2, Double var3, Bundle var4, boolean var5, UUID var6) throws JSONException, FacebookException {
      this.jsonObject = getJSONObjectForAppEvent(var1, var2, var3, var4, var5, var6);
      this.isImplicit = var5;
      this.name = var2;
      this.checksum = this.calculateChecksum();
   }

   private AppEvent(String var1, boolean var2, String var3) throws JSONException {
      this.jsonObject = new JSONObject(var1);
      this.isImplicit = var2;
      this.name = this.jsonObject.optString("_eventName");
      this.checksum = var3;
   }

   private static String bytesToHex(byte[] var0) {
      StringBuffer var3 = new StringBuffer();
      int var2 = var0.length;

      for (int var1 = 0; var1 < var2; var1++) {
         var3.append(String.format("%02x", var0[var1]));
      }

      return var3.toString();
   }

   private String calculateChecksum() {
      return md5Checksum(this.jsonObject.toString());
   }

   private static JSONObject getJSONObjectForAppEvent(String var0, String var1, Double var2, Bundle var3, boolean var4, UUID var5) throws FacebookException, JSONException {
      validateIdentifier(var1);
      JSONObject var6 = new JSONObject();
      var6.put("_eventName", var1);
      var6.put("_logTime", System.currentTimeMillis() / 1000L);
      var6.put("_ui", var0);
      if (var5 != null) {
         var6.put("_session_id", var5);
      }

      if (var2 != null) {
         var6.put("_valueToSum", var2);
      }

      if (var4) {
         var6.put("_implicitlyLogged", "1");
      }

      var0 = AppEventsLogger.getUserID();
      if (var0 != null) {
         var6.put("_app_user_id", var0);
      }

      if (var3 != null) {
         for (String var9 : var3.keySet()) {
            validateIdentifier(var9);
            Object var8 = var3.get(var9);
            if (!(var8 instanceof String) && !(var8 instanceof Number)) {
               throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", var8, var9));
            }

            var6.put(var9, var8.toString());
         }
      }

      if (!var4) {
         Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", var6.toString());
      }

      return var6;
   }

   private static String md5Checksum(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("MD5");
         byte[] var5 = var0.getBytes("UTF-8");
         var1.update(var5, 0, var5.length);
         var0 = bytesToHex(var1.digest());
      } catch (NoSuchAlgorithmException var2) {
         Utility.logd("Failed to generate checksum: ", var2);
         var0 = "0";
      } catch (UnsupportedEncodingException var3) {
         Utility.logd("Failed to generate checksum: ", var3);
         var0 = "1";
      }

      return var0;
   }

   private static void validateIdentifier(String param0) throws FacebookException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: ifnull 14
      // 04: aload 0
      // 05: invokevirtual java/lang/String.length ()I
      // 08: ifeq 14
      // 0b: aload 0
      // 0c: invokevirtual java/lang/String.length ()I
      // 0f: bipush 40
      // 11: if_icmple 3d
      // 14: aload 0
      // 15: astore 2
      // 16: aload 0
      // 17: ifnonnull 1d
      // 1a: ldc "<None Provided>"
      // 1c: astore 2
      // 1d: new com/facebook/FacebookException
      // 20: dup
      // 21: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 24: ldc "Identifier '%s' must be less than %d characters"
      // 26: bipush 2
      // 27: anewarray 4
      // 2a: dup
      // 2b: bipush 0
      // 2c: aload 2
      // 2d: aastore
      // 2e: dup
      // 2f: bipush 1
      // 30: bipush 40
      // 32: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 35: aastore
      // 36: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 39: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 3c: athrow
      // 3d: getstatic com/facebook/appevents/AppEvent.validatedIdentifiers Ljava/util/HashSet;
      // 40: astore 2
      // 41: aload 2
      // 42: monitorenter
      // 43: getstatic com/facebook/appevents/AppEvent.validatedIdentifiers Ljava/util/HashSet;
      // 46: aload 0
      // 47: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 4a: istore 1
      // 4b: aload 2
      // 4c: monitorexit
      // 4d: iload 1
      // 4e: ifne 6b
      // 51: aload 0
      // 52: ldc_w "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"
      // 55: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 58: ifeq 76
      // 5b: getstatic com/facebook/appevents/AppEvent.validatedIdentifiers Ljava/util/HashSet;
      // 5e: astore 2
      // 5f: aload 2
      // 60: monitorenter
      // 61: getstatic com/facebook/appevents/AppEvent.validatedIdentifiers Ljava/util/HashSet;
      // 64: aload 0
      // 65: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 68: pop
      // 69: aload 2
      // 6a: monitorexit
      // 6b: return
      // 6c: astore 0
      // 6d: aload 2
      // 6e: monitorexit
      // 6f: aload 0
      // 70: athrow
      // 71: astore 0
      // 72: aload 2
      // 73: monitorexit
      // 74: aload 0
      // 75: athrow
      // 76: new com/facebook/FacebookException
      // 79: dup
      // 7a: ldc_w "Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen."
      // 7d: bipush 1
      // 7e: anewarray 4
      // 81: dup
      // 82: bipush 0
      // 83: aload 0
      // 84: aastore
      // 85: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 88: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // 8b: athrow
      // try (37 -> 43): 60 null
      // try (53 -> 59): 65 null
      // try (61 -> 63): 60 null
      // try (66 -> 68): 65 null
   }

   private Object writeReplace() {
      return new AppEvent.SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
   }

   public boolean getIsImplicit() {
      return this.isImplicit;
   }

   public JSONObject getJSONObject() {
      return this.jsonObject;
   }

   public String getName() {
      return this.name;
   }

   public boolean isChecksumValid() {
      boolean var1;
      if (this.checksum == null) {
         var1 = true;
      } else {
         var1 = this.calculateChecksum().equals(this.checksum);
      }

      return var1;
   }

   @Override
   public String toString() {
      return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), this.isImplicit, this.jsonObject.toString());
   }

   static class SerializationProxyV1 implements Serializable {
      private static final long serialVersionUID = -2488473066578201069L;
      private final boolean isImplicit;
      private final String jsonString;

      private SerializationProxyV1(String var1, boolean var2) {
         this.jsonString = var1;
         this.isImplicit = var2;
      }

      private Object readResolve() throws JSONException {
         return new AppEvent(this.jsonString, this.isImplicit, null);
      }
   }

   static class SerializationProxyV2 implements Serializable {
      private static final long serialVersionUID = 20160803001L;
      private final String checksum;
      private final boolean isImplicit;
      private final String jsonString;

      private SerializationProxyV2(String var1, boolean var2, String var3) {
         this.jsonString = var1;
         this.isImplicit = var2;
         this.checksum = var3;
      }

      private Object readResolve() throws JSONException {
         return new AppEvent(this.jsonString, this.isImplicit, this.checksum);
      }
   }
}
