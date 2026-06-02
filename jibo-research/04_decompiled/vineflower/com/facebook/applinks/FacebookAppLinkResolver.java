package com.facebook.applinks;

import android.net.Uri;
import bolts.AppLink;
import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver {
   private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
   private static final String APP_LINK_KEY = "app_links";
   private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
   private static final String APP_LINK_TARGET_CLASS_KEY = "class";
   private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
   private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
   private static final String APP_LINK_TARGET_URL_KEY = "url";
   private static final String APP_LINK_WEB_TARGET_KEY = "web";
   private final HashMap<Uri, AppLink> cachedAppLinks = new HashMap<>();

   private static AppLink.Target getAndroidTargetFromJson(JSONObject var0) {
      Object var1 = null;
      String var2 = null;
      String var3 = tryGetStringFromJson(var0, "package", null);
      AppLink.Target var6;
      if (var3 == null) {
         var6 = var2;
      } else {
         var2 = tryGetStringFromJson(var0, "class", null);
         String var4 = tryGetStringFromJson(var0, "app_name", null);
         String var5 = tryGetStringFromJson(var0, "url", null);
         Uri var7 = (Uri)var1;
         if (var5 != null) {
            var7 = Uri.parse(var5);
         }

         var6 = new AppLink.Target(var3, var2, var7, var4);
      }

      return var6;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Uri getWebFallbackUriFromJson(Uri var0, JSONObject var1) {
      Object var2 = null;

      try {
         var1 = var1.getJSONObject("web");
         if (!tryGetBooleanFromJson(var1, "should_fallback", true)) {
            return null;
         }
      } catch (JSONException var6) {
         return var0;
      }

      String var3;
      try {
         var3 = tryGetStringFromJson(var1, "url", null);
      } catch (JSONException var5) {
         return var0;
      }

      Uri var8 = (Uri)var2;
      if (var3 != null) {
         try {
            var8 = Uri.parse(var3);
         } catch (JSONException var4) {
            return var0;
         }
      }

      if (var8 != null) {
         var0 = var8;
      }

      return var0;
   }

   private static boolean tryGetBooleanFromJson(JSONObject var0, String var1, boolean var2) {
      boolean var3;
      try {
         var3 = var0.getBoolean(var1);
      } catch (JSONException var4) {
         return var2;
      }

      return var3;
   }

   private static String tryGetStringFromJson(JSONObject var0, String var1, String var2) {
      try {
         var4 = var0.getString(var1);
      } catch (JSONException var3) {
         var4 = var2;
      }

      return var4;
   }

   public Task<AppLink> getAppLinkFromUrlInBackground(Uri var1) {
      ArrayList var2 = new ArrayList();
      var2.add(var1);
      return this.getAppLinkFromUrlsInBackground(var2).b(new Continuation<Map<Uri, AppLink>, AppLink>(this, var1) {
         final FacebookAppLinkResolver this$0;
         final Uri val$uri;

         {
            this.this$0 = var1;
            this.val$uri = var2x;
         }

         public AppLink then(Task<Map<Uri, AppLink>> var1) throws Exception {
            return (AppLink)((Map)var1.f()).get(this.val$uri);
         }
      });
   }

   public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> param1) {
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
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: new java/util/HashMap
      // 03: dup
      // 04: invokespecial java/util/HashMap.<init> ()V
      // 07: astore 2
      // 08: new java/util/HashSet
      // 0b: dup
      // 0c: invokespecial java/util/HashSet.<init> ()V
      // 0f: astore 4
      // 11: new java/lang/StringBuilder
      // 14: dup
      // 15: invokespecial java/lang/StringBuilder.<init> ()V
      // 18: astore 3
      // 19: aload 1
      // 1a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1f: astore 6
      // 21: aload 6
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 8a
      // 2b: aload 6
      // 2d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 32: checkcast android/net/Uri
      // 35: astore 5
      // 37: aload 0
      // 38: getfield com/facebook/applinks/FacebookAppLinkResolver.cachedAppLinks Ljava/util/HashMap;
      // 3b: astore 1
      // 3c: aload 1
      // 3d: monitorenter
      // 3e: aload 0
      // 3f: getfield com/facebook/applinks/FacebookAppLinkResolver.cachedAppLinks Ljava/util/HashMap;
      // 42: aload 5
      // 44: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 47: checkcast bolts/AppLink
      // 4a: astore 7
      // 4c: aload 1
      // 4d: monitorexit
      // 4e: aload 7
      // 50: ifnull 66
      // 53: aload 2
      // 54: aload 5
      // 56: aload 7
      // 58: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 5d: pop
      // 5e: goto 21
      // 61: astore 2
      // 62: aload 1
      // 63: monitorexit
      // 64: aload 2
      // 65: athrow
      // 66: aload 4
      // 68: invokevirtual java/util/HashSet.isEmpty ()Z
      // 6b: ifne 75
      // 6e: aload 3
      // 6f: bipush 44
      // 71: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 74: pop
      // 75: aload 3
      // 76: aload 5
      // 78: invokevirtual android/net/Uri.toString ()Ljava/lang/String;
      // 7b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 7e: pop
      // 7f: aload 4
      // 81: aload 5
      // 83: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 86: pop
      // 87: goto 21
      // 8a: aload 4
      // 8c: invokevirtual java/util/HashSet.isEmpty ()Z
      // 8f: ifeq 99
      // 92: aload 2
      // 93: invokestatic bolts/Task.a (Ljava/lang/Object;)Lbolts/Task;
      // 96: astore 1
      // 97: aload 1
      // 98: areturn
      // 99: invokestatic bolts/Task.b ()Lbolts/Task$TaskCompletionSource;
      // 9c: astore 5
      // 9e: new android/os/Bundle
      // a1: dup
      // a2: invokespecial android/os/Bundle.<init> ()V
      // a5: astore 1
      // a6: aload 1
      // a7: ldc "ids"
      // a9: aload 3
      // aa: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // ad: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // b0: aload 1
      // b1: ldc "fields"
      // b3: ldc "%s.fields(%s,%s)"
      // b5: bipush 3
      // b6: anewarray 4
      // b9: dup
      // ba: bipush 0
      // bb: ldc "app_links"
      // bd: aastore
      // be: dup
      // bf: bipush 1
      // c0: ldc "android"
      // c2: aastore
      // c3: dup
      // c4: bipush 2
      // c5: ldc "web"
      // c7: aastore
      // c8: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // cb: invokevirtual android/os/Bundle.putString (Ljava/lang/String;Ljava/lang/String;)V
      // ce: new com/facebook/GraphRequest
      // d1: dup
      // d2: invokestatic com/facebook/AccessToken.getCurrentAccessToken ()Lcom/facebook/AccessToken;
      // d5: ldc ""
      // d7: aload 1
      // d8: aconst_null
      // d9: new com/facebook/applinks/FacebookAppLinkResolver$2
      // dc: dup
      // dd: aload 0
      // de: aload 5
      // e0: aload 2
      // e1: aload 4
      // e3: invokespecial com/facebook/applinks/FacebookAppLinkResolver$2.<init> (Lcom/facebook/applinks/FacebookAppLinkResolver;Lbolts/Task$TaskCompletionSource;Ljava/util/Map;Ljava/util/HashSet;)V
      // e6: invokespecial com/facebook/GraphRequest.<init> (Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;)V
      // e9: invokevirtual com/facebook/GraphRequest.executeAsync ()Lcom/facebook/GraphRequestAsyncTask;
      // ec: pop
      // ed: aload 5
      // ef: invokevirtual bolts/Task$TaskCompletionSource.a ()Lbolts/Task;
      // f2: astore 1
      // f3: goto 97
      // try (27 -> 35): 43 null
      // try (44 -> 46): 43 null
   }
}
