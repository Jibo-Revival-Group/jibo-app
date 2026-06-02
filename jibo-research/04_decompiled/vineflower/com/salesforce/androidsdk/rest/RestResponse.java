package com.salesforce.androidsdk.rest;

import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class RestResponse {
   private final Response a;
   private boolean b;
   private byte[] c;
   private Charset d;
   private String e;
   private JSONObject f;

   public RestResponse(Response var1) {
      this.a = var1;
   }

   public int a() {
      return this.a.c();
   }

   public boolean b() {
      return this.a.d();
   }

   public void c() throws IOException {
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
      // 01: getfield com/salesforce/androidsdk/rest/RestResponse.b Z
      // 04: ifne 6b
      // 07: aload 0
      // 08: getfield com/salesforce/androidsdk/rest/RestResponse.a Lokhttp3/Response;
      // 0b: ifnull 6b
      // 0e: aload 0
      // 0f: getfield com/salesforce/androidsdk/rest/RestResponse.a Lokhttp3/Response;
      // 12: invokevirtual okhttp3/Response.h ()Lokhttp3/ResponseBody;
      // 15: astore 2
      // 16: aload 2
      // 17: ifnull 74
      // 1a: aload 2
      // 1b: invokevirtual okhttp3/ResponseBody.a ()Lokhttp3/MediaType;
      // 1e: astore 1
      // 1f: aload 0
      // 20: aload 2
      // 21: invokevirtual okhttp3/ResponseBody.d ()[B
      // 24: putfield com/salesforce/androidsdk/rest/RestResponse.c [B
      // 27: aload 1
      // 28: ifnull 32
      // 2b: aload 1
      // 2c: invokevirtual okhttp3/MediaType.b ()Ljava/nio/charset/Charset;
      // 2f: ifnonnull 6c
      // 32: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 35: astore 1
      // 36: aload 0
      // 37: aload 1
      // 38: putfield com/salesforce/androidsdk/rest/RestResponse.d Ljava/nio/charset/Charset;
      // 3b: aload 0
      // 3c: getfield com/salesforce/androidsdk/rest/RestResponse.c [B
      // 3f: ifnull 5f
      // 42: aload 0
      // 43: getfield com/salesforce/androidsdk/rest/RestResponse.c [B
      // 46: arraylength
      // 47: ifle 5f
      // 4a: new java/lang/String
      // 4d: astore 1
      // 4e: aload 1
      // 4f: aload 0
      // 50: getfield com/salesforce/androidsdk/rest/RestResponse.c [B
      // 53: aload 0
      // 54: getfield com/salesforce/androidsdk/rest/RestResponse.d Ljava/nio/charset/Charset;
      // 57: invokespecial java/lang/String.<init> ([BLjava/nio/charset/Charset;)V
      // 5a: aload 0
      // 5b: aload 1
      // 5c: putfield com/salesforce/androidsdk/rest/RestResponse.e Ljava/lang/String;
      // 5f: aload 0
      // 60: bipush 1
      // 61: putfield com/salesforce/androidsdk/rest/RestResponse.b Z
      // 64: aload 0
      // 65: getfield com/salesforce/androidsdk/rest/RestResponse.a Lokhttp3/Response;
      // 68: invokevirtual okhttp3/Response.close ()V
      // 6b: return
      // 6c: aload 1
      // 6d: invokevirtual okhttp3/MediaType.b ()Ljava/nio/charset/Charset;
      // 70: astore 1
      // 71: goto 36
      // 74: aload 0
      // 75: bipush 0
      // 76: newarray 8
      // 78: putfield com/salesforce/androidsdk/rest/RestResponse.c [B
      // 7b: aload 0
      // 7c: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 7f: putfield com/salesforce/androidsdk/rest/RestResponse.d Ljava/nio/charset/Charset;
      // 82: goto 5f
      // 85: astore 1
      // 86: aload 0
      // 87: getfield com/salesforce/androidsdk/rest/RestResponse.a Lokhttp3/Response;
      // 8a: invokevirtual okhttp3/Response.close ()V
      // 8d: aload 1
      // 8e: athrow
      // try (6 -> 10): 66 null
      // try (12 -> 19): 66 null
      // try (21 -> 24): 66 null
      // try (24 -> 26): 66 null
      // try (26 -> 47): 66 null
      // try (47 -> 50): 66 null
      // try (54 -> 57): 66 null
      // try (58 -> 65): 66 null
   }

   public byte[] d() throws IOException {
      if (this.c == null) {
         this.c();
      }

      return this.c;
   }

   public String e() throws IOException {
      if (this.e == null) {
         this.e = new String(this.d(), this.d);
      }

      return this.e;
   }

   public JSONObject f() throws JSONException, IOException {
      if (this.f == null) {
         this.f = new JSONObject(this.e());
      }

      return this.f;
   }

   @Override
   public String toString() {
      String var1;
      try {
         var1 = this.e();
      } catch (Exception var2) {
         SalesforceSDKLogger.a("RestResponse", "Exception thrown while converting to string", var2);
         if (this.a == null) {
            var1 = "";
         } else {
            var1 = this.a.toString();
         }
      }

      return var1;
   }
}
