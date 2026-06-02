package com.salesforce.android.service.common.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class HttpJob<T> implements Job<T> {
   private static final ServiceLogger e = ServiceLogging.a(HttpJob.class);
   final HttpClient a;
   final HttpRequest b;
   final Class<T> c;
   final Gson d;

   protected HttpJob(HttpJob.Builder<T> var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
   }

   public static <T> HttpJob<T> a(HttpClient var0, HttpRequest var1, Class<T> var2, Gson var3) {
      return new HttpJob.Builder<T>().a(var0).a(var1).a(var2).a(var3).a();
   }

   @Override
   public void a(ResultReceiver<T> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 003: ldc "Submitting http request to {}"
      // 005: bipush 1
      // 006: anewarray 5
      // 009: dup
      // 00a: bipush 0
      // 00b: aload 0
      // 00c: getfield com/salesforce/android/service/common/http/HttpJob.b Lcom/salesforce/android/service/common/http/HttpRequest;
      // 00f: invokeinterface com/salesforce/android/service/common/http/HttpRequest.a ()Lcom/salesforce/android/service/common/http/HttpUrl; 1
      // 014: aastore
      // 015: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.a (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 01a: aconst_null
      // 01b: astore 3
      // 01c: aconst_null
      // 01d: astore 2
      // 01e: aload 0
      // 01f: getfield com/salesforce/android/service/common/http/HttpJob.a Lcom/salesforce/android/service/common/http/HttpClient;
      // 022: aload 0
      // 023: getfield com/salesforce/android/service/common/http/HttpJob.b Lcom/salesforce/android/service/common/http/HttpRequest;
      // 026: invokeinterface com/salesforce/android/service/common/http/HttpClient.a (Lcom/salesforce/android/service/common/http/HttpRequest;)Lcom/salesforce/android/service/common/http/HttpCall; 2
      // 02b: invokeinterface com/salesforce/android/service/common/http/HttpCall.a ()Lcom/salesforce/android/service/common/http/HttpResponse; 1
      // 030: astore 4
      // 032: aload 4
      // 034: astore 2
      // 035: aload 4
      // 037: astore 3
      // 038: aload 4
      // 03a: invokeinterface com/salesforce/android/service/common/http/HttpResponse.b ()Z 1
      // 03f: ifeq 080
      // 042: aload 4
      // 044: astore 2
      // 045: aload 4
      // 047: astore 3
      // 048: aload 1
      // 049: aload 0
      // 04a: getfield com/salesforce/android/service/common/http/HttpJob.d Lcom/google/gson/Gson;
      // 04d: aload 4
      // 04f: invokeinterface com/salesforce/android/service/common/http/HttpResponse.c ()Lcom/salesforce/android/service/common/http/HttpResponseBody; 1
      // 054: invokeinterface com/salesforce/android/service/common/http/HttpResponseBody.b ()Ljava/io/Reader; 1
      // 059: aload 0
      // 05a: getfield com/salesforce/android/service/common/http/HttpJob.c Ljava/lang/Class;
      // 05d: invokevirtual com/google/gson/Gson.a (Ljava/io/Reader;Ljava/lang/Class;)Ljava/lang/Object;
      // 060: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 065: pop
      // 066: aload 4
      // 068: astore 2
      // 069: aload 4
      // 06b: astore 3
      // 06c: aload 1
      // 06d: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b ()Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 1
      // 072: pop
      // 073: aload 4
      // 075: ifnull 07f
      // 078: aload 4
      // 07a: invokeinterface com/salesforce/android/service/common/http/HttpResponse.close ()V 1
      // 07f: return
      // 080: aload 4
      // 082: astore 2
      // 083: aload 4
      // 085: astore 3
      // 086: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 089: ldc "Unsuccessful HTTP request: {}"
      // 08b: bipush 1
      // 08c: anewarray 5
      // 08f: dup
      // 090: bipush 0
      // 091: aload 4
      // 093: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 096: aastore
      // 097: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 09c: aload 4
      // 09e: astore 2
      // 09f: aload 4
      // 0a1: astore 3
      // 0a2: new com/salesforce/android/service/common/http/ResponseException
      // 0a5: astore 5
      // 0a7: aload 4
      // 0a9: astore 2
      // 0aa: aload 4
      // 0ac: astore 3
      // 0ad: new java/lang/StringBuilder
      // 0b0: astore 6
      // 0b2: aload 4
      // 0b4: astore 2
      // 0b5: aload 4
      // 0b7: astore 3
      // 0b8: aload 6
      // 0ba: invokespecial java/lang/StringBuilder.<init> ()V
      // 0bd: aload 4
      // 0bf: astore 2
      // 0c0: aload 4
      // 0c2: astore 3
      // 0c3: aload 5
      // 0c5: aload 6
      // 0c7: ldc "Unsuccessful HTTP request: "
      // 0c9: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0cc: aload 4
      // 0ce: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 0d1: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0d4: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0d7: aload 4
      // 0d9: invokeinterface com/salesforce/android/service/common/http/HttpResponse.a ()I 1
      // 0de: aload 4
      // 0e0: invokeinterface com/salesforce/android/service/common/http/HttpResponse.c ()Lcom/salesforce/android/service/common/http/HttpResponseBody; 1
      // 0e5: invokeinterface com/salesforce/android/service/common/http/HttpResponseBody.c ()Ljava/lang/String; 1
      // 0ea: invokespecial com/salesforce/android/service/common/http/ResponseException.<init> (Ljava/lang/String;ILjava/lang/String;)V
      // 0ed: aload 4
      // 0ef: astore 2
      // 0f0: aload 4
      // 0f2: astore 3
      // 0f3: aload 1
      // 0f4: aload 5
      // 0f6: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 0fb: pop
      // 0fc: goto 073
      // 0ff: astore 4
      // 101: aload 2
      // 102: astore 3
      // 103: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 106: ldc "Encountered Exception during HTTP request {}\nResponse: {}"
      // 108: bipush 2
      // 109: anewarray 5
      // 10c: dup
      // 10d: bipush 0
      // 10e: aload 4
      // 110: aastore
      // 111: dup
      // 112: bipush 1
      // 113: aload 2
      // 114: aastore
      // 115: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 11a: aload 2
      // 11b: astore 3
      // 11c: aload 1
      // 11d: aload 4
      // 11f: invokeinterface com/salesforce/android/service/common/utilities/control/ResultReceiver.b (Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/ResultReceiver; 2
      // 124: pop
      // 125: aload 2
      // 126: ifnull 07f
      // 129: aload 2
      // 12a: invokeinterface com/salesforce/android/service/common/http/HttpResponse.close ()V 1
      // 12f: goto 07f
      // 132: astore 1
      // 133: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 136: ldc "Unable to close HTTP response stream.\n{}"
      // 138: bipush 1
      // 139: anewarray 5
      // 13c: dup
      // 13d: bipush 0
      // 13e: aload 1
      // 13f: aastore
      // 140: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 145: goto 07f
      // 148: astore 1
      // 149: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 14c: ldc "Unable to close HTTP response stream.\n{}"
      // 14e: bipush 1
      // 14f: anewarray 5
      // 152: dup
      // 153: bipush 0
      // 154: aload 1
      // 155: aastore
      // 156: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 15b: goto 07f
      // 15e: astore 1
      // 15f: aload 3
      // 160: ifnull 169
      // 163: aload 3
      // 164: invokeinterface com/salesforce/android/service/common/http/HttpResponse.close ()V 1
      // 169: aload 1
      // 16a: athrow
      // 16b: astore 2
      // 16c: getstatic com/salesforce/android/service/common/http/HttpJob.e Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 16f: ldc "Unable to close HTTP response stream.\n{}"
      // 171: bipush 1
      // 172: anewarray 5
      // 175: dup
      // 176: bipush 0
      // 177: aload 2
      // 178: aastore
      // 179: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 17e: goto 169
      // try (15 -> 22): 115 java/lang/Exception
      // try (15 -> 22): 164 null
      // try (26 -> 29): 115 java/lang/Exception
      // try (26 -> 29): 164 null
      // try (33 -> 44): 115 java/lang/Exception
      // try (33 -> 44): 164 null
      // try (48 -> 51): 115 java/lang/Exception
      // try (48 -> 51): 164 null
      // try (53 -> 55): 153 java/io/IOException
      // try (60 -> 70): 115 java/lang/Exception
      // try (60 -> 70): 164 null
      // try (74 -> 76): 115 java/lang/Exception
      // try (74 -> 76): 164 null
      // try (80 -> 82): 115 java/lang/Exception
      // try (80 -> 82): 164 null
      // try (86 -> 88): 115 java/lang/Exception
      // try (86 -> 88): 164 null
      // try (92 -> 106): 115 java/lang/Exception
      // try (92 -> 106): 164 null
      // try (110 -> 114): 115 java/lang/Exception
      // try (110 -> 114): 164 null
      // try (118 -> 131): 164 null
      // try (133 -> 137): 164 null
      // try (139 -> 141): 142 java/io/IOException
      // try (167 -> 169): 171 java/io/IOException
   }

   public static class Builder<T> {
      protected HttpClient a;
      protected HttpRequest b;
      protected Class<T> c;
      protected Gson d;

      public HttpJob.Builder<T> a(Gson var1) {
         this.d = var1;
         return this;
      }

      public HttpJob.Builder<T> a(HttpClient var1) {
         this.a = var1;
         return this;
      }

      public HttpJob.Builder<T> a(HttpRequest var1) {
         this.b = var1;
         return this;
      }

      public HttpJob.Builder<T> a(Class<T> var1) {
         this.c = var1;
         return this;
      }

      public HttpJob<T> a() {
         Arguments.a(this.a);
         Arguments.a(this.b);
         Arguments.a(this.c);
         if (this.d == null) {
            this.d = new GsonBuilder().a();
         }

         return new HttpJob<>(this);
      }
   }
}
