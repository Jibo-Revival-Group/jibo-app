package com.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestUserManager {
   static final boolean $assertionsDisabled;
   private static final String LOG_TAG = "TestUserManager";
   private Map<String, JSONObject> appTestAccounts;
   private String testApplicationId;
   private String testApplicationSecret;

   static {
      boolean var0;
      if (!TestUserManager.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public TestUserManager(String var1, String var2) {
      if (!Utility.isNullOrEmpty(var2) && !Utility.isNullOrEmpty(var1)) {
         this.testApplicationSecret = var1;
         this.testApplicationId = var2;
      } else {
         throw new FacebookException("Must provide app ID and secret");
      }
   }

   private JSONObject createTestAccount(List<String> var1, TestUserManager.Mode var2, String var3) {
      Object var4 = null;
      Bundle var5 = new Bundle();
      var5.putString("installed", "true");
      var5.putString("permissions", this.getPermissionsString(var1));
      var5.putString("access_token", this.getAppAccessToken());
      if (var2 == TestUserManager.Mode.SHARED) {
         var5.putString("name", String.format("Shared %s Testuser", this.getSharedTestAccountIdentifier(var1, var3)));
      }

      GraphResponse var7 = new GraphRequest(null, String.format("%s/accounts/test-users", this.testApplicationId), var5, HttpMethod.POST).executeAndWait();
      FacebookRequestError var9 = var7.getError();
      JSONObject var8 = var7.getJSONObject();
      if (var9 != null) {
         var8 = (JSONObject)var4;
      } else {
         if (!$assertionsDisabled && var8 == null) {
            throw new AssertionError();
         }

         if (var2 == TestUserManager.Mode.SHARED) {
            try {
               var8.put("name", var5.getString("name"));
            } catch (JSONException var6) {
               Log.e("TestUserManager", "Could not set name", var6);
            }

            this.storeTestAccount(var8);
         }
      }

      return var8;
   }

   private JSONObject findOrCreateSharedTestAccount(List<String> var1, TestUserManager.Mode var2, String var3) {
      JSONObject var4 = this.findTestAccountMatchingIdentifier(this.getSharedTestAccountIdentifier(var1, var3));
      JSONObject var5;
      if (var4 != null) {
         var5 = var4;
      } else {
         var5 = this.createTestAccount(var1, var2, var3);
      }

      return var5;
   }

   private JSONObject findTestAccountMatchingIdentifier(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/facebook/TestUserManager.appTestAccounts Ljava/util/Map;
      // 06: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0b: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 10: astore 4
      // 12: aload 4
      // 14: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 19: ifeq 3c
      // 1c: aload 4
      // 1e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 23: checkcast org/json/JSONObject
      // 26: astore 3
      // 27: aload 3
      // 28: ldc "name"
      // 2a: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 2d: aload 1
      // 2e: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 31: istore 2
      // 32: iload 2
      // 33: ifeq 12
      // 36: aload 3
      // 37: astore 1
      // 38: aload 0
      // 39: monitorexit
      // 3a: aload 1
      // 3b: areturn
      // 3c: aconst_null
      // 3d: astore 1
      // 3e: goto 38
      // 41: astore 1
      // 42: aload 0
      // 43: monitorexit
      // 44: aload 1
      // 45: athrow
      // try (2 -> 7): 31 null
      // try (7 -> 20): 31 null
   }

   private AccessToken getAccessTokenForUser(List<String> var1, TestUserManager.Mode var2, String var3) {
      this.retrieveTestAccountsForAppIfNeeded();
      if (Utility.isNullOrEmpty(var1)) {
         var1 = Arrays.asList("email", "publish_actions");
      }

      JSONObject var4;
      if (var2 == TestUserManager.Mode.PRIVATE) {
         var4 = this.createTestAccount(var1, var2, var3);
      } else {
         var4 = this.findOrCreateSharedTestAccount(var1, var2, var3);
      }

      return new AccessToken(var4.optString("access_token"), this.testApplicationId, var4.optString("id"), var1, null, AccessTokenSource.TEST_USER, null, null);
   }

   private String getPermissionsString(List<String> var1) {
      return TextUtils.join(",", var1);
   }

   private String getSharedTestAccountIdentifier(List<String> var1, String var2) {
      long var5 = this.getPermissionsString(var1).hashCode();
      long var3;
      if (var2 != null) {
         var3 = var2.hashCode() & 4294967295L;
      } else {
         var3 = 0L;
      }

      return this.validNameStringFromInteger(var3 ^ var5 & 4294967295L);
   }

   private void populateTestAccounts(JSONArray param1, JSONObject param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: bipush 0
      // 03: istore 3
      // 04: iload 3
      // 05: aload 1
      // 06: invokevirtual org/json/JSONArray.length ()I
      // 09: if_icmpge 4f
      // 0c: aload 1
      // 0d: iload 3
      // 0e: invokevirtual org/json/JSONArray.optJSONObject (I)Lorg/json/JSONObject;
      // 11: astore 4
      // 13: aload 2
      // 14: aload 4
      // 16: ldc "id"
      // 18: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 1b: invokevirtual org/json/JSONObject.optJSONObject (Ljava/lang/String;)Lorg/json/JSONObject;
      // 1e: astore 5
      // 20: aload 4
      // 22: ldc "name"
      // 24: aload 5
      // 26: ldc "name"
      // 28: invokevirtual org/json/JSONObject.optString (Ljava/lang/String;)Ljava/lang/String;
      // 2b: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 2e: pop
      // 2f: aload 0
      // 30: aload 4
      // 32: invokespecial com/facebook/TestUserManager.storeTestAccount (Lorg/json/JSONObject;)V
      // 35: iinc 3 1
      // 38: goto 04
      // 3b: astore 5
      // 3d: ldc "TestUserManager"
      // 3f: ldc "Could not set name"
      // 41: aload 5
      // 43: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 46: pop
      // 47: goto 2f
      // 4a: astore 1
      // 4b: aload 0
      // 4c: monitorexit
      // 4d: aload 1
      // 4e: athrow
      // 4f: aload 0
      // 50: monitorexit
      // 51: return
      // try (4 -> 18): 37 null
      // try (18 -> 25): 30 org/json/JSONException
      // try (18 -> 25): 37 null
      // try (25 -> 28): 37 null
      // try (31 -> 36): 37 null
   }

   private void retrieveTestAccountsForAppIfNeeded() {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield com/facebook/TestUserManager.appTestAccounts Ljava/util/Map;
      // 06: astore 1
      // 07: aload 1
      // 08: ifnull 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: new java/util/HashMap
      // 11: astore 1
      // 12: aload 1
      // 13: invokespecial java/util/HashMap.<init> ()V
      // 16: aload 0
      // 17: aload 1
      // 18: putfield com/facebook/TestUserManager.appTestAccounts Ljava/util/Map;
      // 1b: aload 0
      // 1c: getfield com/facebook/TestUserManager.testApplicationId Ljava/lang/String;
      // 1f: invokestatic com/facebook/GraphRequest.setDefaultBatchApplicationId (Ljava/lang/String;)V
      // 22: new android/os/Bundle
      // 25: astore 2
      // 26: aload 2
      // 27: invokespecial android/os/Bundle.<init> ()V
      // 2a: aload 2
      // 2b: ldc "access_token"
      // 2d: aload 0
      // 2e: invokevirtual com/facebook/TestUserManager.getAppAccessToken ()Ljava/lang/String;
      // 31: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 34: new com/facebook/GraphRequest
      // 37: astore 1
      // 38: aload 1
      // 39: aconst_null
      // 3a: ldc_w "app/accounts/test-users"
      // 3d: aload 2
      // 3e: aconst_null
      // 3f: invokespecial com/facebook/GraphRequest.<init> (Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;)V
      // 42: aload 1
      // 43: ldc_w "testUsers"
      // 46: invokevirtual com/facebook/GraphRequest.setBatchEntryName (Ljava/lang/String;)V
      // 49: aload 1
      // 4a: bipush 0
      // 4b: invokevirtual com/facebook/GraphRequest.setBatchEntryOmitResultOnSuccess (Z)V
      // 4e: new android/os/Bundle
      // 51: astore 3
      // 52: aload 3
      // 53: invokespecial android/os/Bundle.<init> ()V
      // 56: aload 3
      // 57: ldc "access_token"
      // 59: aload 0
      // 5a: invokevirtual com/facebook/TestUserManager.getAppAccessToken ()Ljava/lang/String;
      // 5d: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 60: aload 3
      // 61: ldc_w "ids"
      // 64: ldc_w "{result=testUsers:$.data.*.id}"
      // 67: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 6a: aload 3
      // 6b: ldc_w "fields"
      // 6e: ldc "name"
      // 70: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // 73: new com/facebook/GraphRequest
      // 76: astore 2
      // 77: aload 2
      // 78: aconst_null
      // 79: ldc_w ""
      // 7c: aload 3
      // 7d: aconst_null
      // 7e: invokespecial com/facebook/GraphRequest.<init> (Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;)V
      // 81: aload 2
      // 82: ldc_w "testUsers"
      // 85: invokevirtual com/facebook/GraphRequest.setBatchEntryDependsOn (Ljava/lang/String;)V
      // 88: bipush 2
      // 89: anewarray 97
      // 8c: dup
      // 8d: bipush 0
      // 8e: aload 1
      // 8f: aastore
      // 90: dup
      // 91: bipush 1
      // 92: aload 2
      // 93: aastore
      // 94: invokestatic com/facebook/GraphRequest.executeBatchAndWait ([Lcom/facebook/GraphRequest;)Ljava/util/List;
      // 97: astore 1
      // 98: aload 1
      // 99: ifnull a6
      // 9c: aload 1
      // 9d: invokeinterface java/util/List.size ()I 1
      // a2: bipush 2
      // a3: if_icmpeq b8
      // a6: new com/facebook/FacebookException
      // a9: astore 1
      // aa: aload 1
      // ab: ldc_w "Unexpected number of results from TestUsers batch query"
      // ae: invokespecial com/facebook/FacebookException.<init> (Ljava/lang/String;)V
      // b1: aload 1
      // b2: athrow
      // b3: astore 1
      // b4: aload 0
      // b5: monitorexit
      // b6: aload 1
      // b7: athrow
      // b8: aload 0
      // b9: aload 1
      // ba: bipush 0
      // bb: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // c0: checkcast com/facebook/GraphResponse
      // c3: invokevirtual com/facebook/GraphResponse.getJSONObject ()Lorg/json/JSONObject;
      // c6: ldc_w "data"
      // c9: invokevirtual org/json/JSONObject.optJSONArray (Ljava/lang/String;)Lorg/json/JSONArray;
      // cc: aload 1
      // cd: bipush 1
      // ce: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // d3: checkcast com/facebook/GraphResponse
      // d6: invokevirtual com/facebook/GraphResponse.getJSONObject ()Lorg/json/JSONObject;
      // d9: invokespecial com/facebook/TestUserManager.populateTestAccounts (Lorg/json/JSONArray;Lorg/json/JSONObject;)V
      // dc: goto 0b
      // try (2 -> 5): 96 null
      // try (10 -> 83): 96 null
      // try (85 -> 89): 96 null
      // try (89 -> 96): 96 null
      // try (101 -> 115): 96 null
   }

   private void storeTestAccount(JSONObject var1) {
      synchronized (this) {
         this.appTestAccounts.put(var1.optString("id"), var1);
      }
   }

   private String validNameStringFromInteger(long var1) {
      String var9 = Long.toString(var1);
      StringBuilder var8 = new StringBuilder("Perm");
      char[] var10 = var9.toCharArray();
      int var7 = var10.length;
      int var4 = 0;
      char var5 = 0;

      while (var4 < var7) {
         char var6 = var10[var4];
         char var3 = var6;
         if (var6 == var5) {
            var3 = (char)(var6 + '\n');
         }

         var8.append((char)(var3 + 'a' - 48));
         var4++;
         var5 = var3;
      }

      return var8.toString();
   }

   public AccessToken getAccessTokenForPrivateUser(List<String> var1) {
      return this.getAccessTokenForUser(var1, TestUserManager.Mode.PRIVATE, null);
   }

   public AccessToken getAccessTokenForSharedUser(List<String> var1) {
      return this.getAccessTokenForSharedUser(var1, null);
   }

   public AccessToken getAccessTokenForSharedUser(List<String> var1, String var2) {
      return this.getAccessTokenForUser(var1, TestUserManager.Mode.SHARED, var2);
   }

   final String getAppAccessToken() {
      return this.testApplicationId + "|" + this.testApplicationSecret;
   }

   public String getTestApplicationId() {
      synchronized (this) {
         return this.testApplicationId;
      }
   }

   public String getTestApplicationSecret() {
      synchronized (this) {
         return this.testApplicationSecret;
      }
   }

   private enum Mode {
      PRIVATE,
      SHARED;

      private static final TestUserManager.Mode[] $VALUES = new TestUserManager.Mode[]{TestUserManager.Mode.PRIVATE, TestUserManager.Mode.SHARED};
   }
}
