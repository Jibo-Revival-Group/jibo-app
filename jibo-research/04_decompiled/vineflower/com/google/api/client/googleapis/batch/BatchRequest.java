package com.google.api.client.googleapis.batch;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BatchRequest {
   private GenericUrl batchUrl = new GenericUrl("https://www.googleapis.com/batch");
   private final HttpRequestFactory requestFactory;
   List<BatchRequest.RequestInfo<?, ?>> requestInfos = new ArrayList<>();
   private Sleeper sleeper = Sleeper.DEFAULT;

   public BatchRequest(HttpTransport var1, HttpRequestInitializer var2) {
      HttpRequestFactory var3;
      if (var2 == null) {
         var3 = var1.createRequestFactory();
      } else {
         var3 = var1.createRequestFactory(var2);
      }

      this.requestFactory = var3;
   }

   public void execute() throws IOException {
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
      // 000: aload 0
      // 001: getfield com/google/api/client/googleapis/batch/BatchRequest.requestInfos Ljava/util/List;
      // 004: invokeinterface java/util/List.isEmpty ()Z 1
      // 009: ifne 0c3
      // 00c: bipush 1
      // 00d: istore 5
      // 00f: iload 5
      // 011: invokestatic com/google/api/client/util/Preconditions.checkState (Z)V
      // 014: aload 0
      // 015: getfield com/google/api/client/googleapis/batch/BatchRequest.requestFactory Lcom/google/api/client/http/HttpRequestFactory;
      // 018: aload 0
      // 019: getfield com/google/api/client/googleapis/batch/BatchRequest.batchUrl Lcom/google/api/client/http/GenericUrl;
      // 01c: aconst_null
      // 01d: invokevirtual com/google/api/client/http/HttpRequestFactory.buildPostRequest (Lcom/google/api/client/http/GenericUrl;Lcom/google/api/client/http/HttpContent;)Lcom/google/api/client/http/HttpRequest;
      // 020: astore 7
      // 022: aload 7
      // 024: new com/google/api/client/googleapis/batch/BatchRequest$BatchInterceptor
      // 027: dup
      // 028: aload 0
      // 029: aload 7
      // 02b: invokevirtual com/google/api/client/http/HttpRequest.getInterceptor ()Lcom/google/api/client/http/HttpExecuteInterceptor;
      // 02e: invokespecial com/google/api/client/googleapis/batch/BatchRequest$BatchInterceptor.<init> (Lcom/google/api/client/googleapis/batch/BatchRequest;Lcom/google/api/client/http/HttpExecuteInterceptor;)V
      // 031: invokevirtual com/google/api/client/http/HttpRequest.setInterceptor (Lcom/google/api/client/http/HttpExecuteInterceptor;)Lcom/google/api/client/http/HttpRequest;
      // 034: pop
      // 035: aload 7
      // 037: invokevirtual com/google/api/client/http/HttpRequest.getNumberOfRetries ()I
      // 03a: istore 2
      // 03b: aload 7
      // 03d: invokevirtual com/google/api/client/http/HttpRequest.getBackOffPolicy ()Lcom/google/api/client/http/BackOffPolicy;
      // 040: astore 8
      // 042: iload 2
      // 043: istore 1
      // 044: aload 8
      // 046: ifnull 052
      // 049: aload 8
      // 04b: invokeinterface com/google/api/client/http/BackOffPolicy.reset ()V 1
      // 050: iload 2
      // 051: istore 1
      // 052: iload 1
      // 053: ifle 0c9
      // 056: bipush 1
      // 057: istore 5
      // 059: new com/google/api/client/http/MultipartContent
      // 05c: dup
      // 05d: invokespecial com/google/api/client/http/MultipartContent.<init> ()V
      // 060: astore 9
      // 062: aload 9
      // 064: invokevirtual com/google/api/client/http/MultipartContent.getMediaType ()Lcom/google/api/client/http/HttpMediaType;
      // 067: ldc "mixed"
      // 069: invokevirtual com/google/api/client/http/HttpMediaType.setSubType (Ljava/lang/String;)Lcom/google/api/client/http/HttpMediaType;
      // 06c: pop
      // 06d: aload 0
      // 06e: getfield com/google/api/client/googleapis/batch/BatchRequest.requestInfos Ljava/util/List;
      // 071: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 076: astore 10
      // 078: bipush 1
      // 079: istore 2
      // 07a: aload 10
      // 07c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 081: ifeq 0cf
      // 084: aload 10
      // 086: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08b: checkcast com/google/api/client/googleapis/batch/BatchRequest$RequestInfo
      // 08e: astore 6
      // 090: aload 9
      // 092: new com/google/api/client/http/MultipartContent$Part
      // 095: dup
      // 096: new com/google/api/client/http/HttpHeaders
      // 099: dup
      // 09a: invokespecial com/google/api/client/http/HttpHeaders.<init> ()V
      // 09d: aconst_null
      // 09e: invokevirtual com/google/api/client/http/HttpHeaders.setAcceptEncoding (Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
      // 0a1: ldc "Content-ID"
      // 0a3: iload 2
      // 0a4: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0a7: invokevirtual com/google/api/client/http/HttpHeaders.set (Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/http/HttpHeaders;
      // 0aa: new com/google/api/client/googleapis/batch/HttpRequestContent
      // 0ad: dup
      // 0ae: aload 6
      // 0b0: getfield com/google/api/client/googleapis/batch/BatchRequest$RequestInfo.request Lcom/google/api/client/http/HttpRequest;
      // 0b3: invokespecial com/google/api/client/googleapis/batch/HttpRequestContent.<init> (Lcom/google/api/client/http/HttpRequest;)V
      // 0b6: invokespecial com/google/api/client/http/MultipartContent$Part.<init> (Lcom/google/api/client/http/HttpHeaders;Lcom/google/api/client/http/HttpContent;)V
      // 0b9: invokevirtual com/google/api/client/http/MultipartContent.addPart (Lcom/google/api/client/http/MultipartContent$Part;)Lcom/google/api/client/http/MultipartContent;
      // 0bc: pop
      // 0bd: iinc 2 1
      // 0c0: goto 07a
      // 0c3: bipush 0
      // 0c4: istore 5
      // 0c6: goto 00f
      // 0c9: bipush 0
      // 0ca: istore 5
      // 0cc: goto 059
      // 0cf: aload 7
      // 0d1: aload 9
      // 0d3: invokevirtual com/google/api/client/http/HttpRequest.setContent (Lcom/google/api/client/http/HttpContent;)Lcom/google/api/client/http/HttpRequest;
      // 0d6: pop
      // 0d7: aload 7
      // 0d9: invokevirtual com/google/api/client/http/HttpRequest.execute ()Lcom/google/api/client/http/HttpResponse;
      // 0dc: astore 9
      // 0de: aload 9
      // 0e0: invokevirtual com/google/api/client/http/HttpResponse.getMediaType ()Lcom/google/api/client/http/HttpMediaType;
      // 0e3: ldc "boundary"
      // 0e5: invokevirtual com/google/api/client/http/HttpMediaType.getParameter (Ljava/lang/String;)Ljava/lang/String;
      // 0e8: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0eb: astore 6
      // 0ed: aload 6
      // 0ef: invokevirtual java/lang/String.length ()I
      // 0f2: ifeq 133
      // 0f5: ldc "--"
      // 0f7: aload 6
      // 0f9: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 0fc: astore 6
      // 0fe: aload 9
      // 100: invokevirtual com/google/api/client/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 103: astore 11
      // 105: new com/google/api/client/googleapis/batch/BatchUnparsedResponse
      // 108: astore 10
      // 10a: aload 10
      // 10c: aload 11
      // 10e: aload 6
      // 110: aload 0
      // 111: getfield com/google/api/client/googleapis/batch/BatchRequest.requestInfos Ljava/util/List;
      // 114: iload 5
      // 116: invokespecial com/google/api/client/googleapis/batch/BatchUnparsedResponse.<init> (Ljava/io/InputStream;Ljava/lang/String;Ljava/util/List;Z)V
      // 119: aload 10
      // 11b: getfield com/google/api/client/googleapis/batch/BatchUnparsedResponse.hasNext Z
      // 11e: ifeq 141
      // 121: aload 10
      // 123: invokevirtual com/google/api/client/googleapis/batch/BatchUnparsedResponse.parseNextResponse ()V
      // 126: goto 119
      // 129: astore 6
      // 12b: aload 9
      // 12d: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 130: aload 6
      // 132: athrow
      // 133: new java/lang/String
      // 136: dup
      // 137: ldc "--"
      // 139: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 13c: astore 6
      // 13e: goto 0fe
      // 141: aload 9
      // 143: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 146: aload 10
      // 148: getfield com/google/api/client/googleapis/batch/BatchUnparsedResponse.unsuccessfulRequestInfos Ljava/util/List;
      // 14b: astore 6
      // 14d: aload 6
      // 14f: invokeinterface java/util/List.isEmpty ()Z 1
      // 154: ifne 18c
      // 157: aload 0
      // 158: aload 6
      // 15a: putfield com/google/api/client/googleapis/batch/BatchRequest.requestInfos Ljava/util/List;
      // 15d: aload 10
      // 15f: getfield com/google/api/client/googleapis/batch/BatchUnparsedResponse.backOffRequired Z
      // 162: ifeq 184
      // 165: aload 8
      // 167: ifnull 184
      // 16a: aload 8
      // 16c: invokeinterface com/google/api/client/http/BackOffPolicy.getNextBackOffMillis ()J 1
      // 171: lstore 3
      // 172: lload 3
      // 173: ldc2_w -1
      // 176: lcmp
      // 177: ifeq 184
      // 17a: aload 0
      // 17b: getfield com/google/api/client/googleapis/batch/BatchRequest.sleeper Lcom/google/api/client/util/Sleeper;
      // 17e: lload 3
      // 17f: invokeinterface com/google/api/client/util/Sleeper.sleep (J)V 3
      // 184: iinc 1 -1
      // 187: iload 5
      // 189: ifne 052
      // 18c: aload 0
      // 18d: getfield com/google/api/client/googleapis/batch/BatchRequest.requestInfos Ljava/util/List;
      // 190: invokeinterface java/util/List.clear ()V 1
      // 195: return
      // 196: astore 6
      // 198: goto 184
      // try (99 -> 112): 130 null
      // try (112 -> 124): 130 null
      // try (124 -> 129): 130 null
      // try (135 -> 140): 130 null
      // try (164 -> 168): 175 java/lang/InterruptedException
   }

   public GenericUrl getBatchUrl() {
      return this.batchUrl;
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public <T, E> BatchRequest queue(HttpRequest var1, Class<T> var2, Class<E> var3, BatchCallback<T, E> var4) throws IOException {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var4);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.requestInfos.add(new BatchRequest.RequestInfo(var4, var2, var3, var1));
      return this;
   }

   public BatchRequest setBatchUrl(GenericUrl var1) {
      this.batchUrl = var1;
      return this;
   }

   public BatchRequest setSleeper(Sleeper var1) {
      this.sleeper = Preconditions.checkNotNull(var1);
      return this;
   }

   public int size() {
      return this.requestInfos.size();
   }

   class BatchInterceptor implements HttpExecuteInterceptor {
      private HttpExecuteInterceptor originalInterceptor;
      final BatchRequest this$0;

      BatchInterceptor(BatchRequest var1, HttpExecuteInterceptor var2) {
         this.this$0 = var1;
         this.originalInterceptor = var2;
      }

      @Override
      public void intercept(HttpRequest var1) throws IOException {
         if (this.originalInterceptor != null) {
            this.originalInterceptor.intercept(var1);
         }

         for (BatchRequest.RequestInfo var2 : this.this$0.requestInfos) {
            HttpExecuteInterceptor var4 = var2.request.getInterceptor();
            if (var4 != null) {
               var4.intercept(var2.request);
            }
         }
      }
   }

   static class RequestInfo<T, E> {
      final BatchCallback<T, E> callback;
      final Class<T> dataClass;
      final Class<E> errorClass;
      final HttpRequest request;

      RequestInfo(BatchCallback<T, E> var1, Class<T> var2, Class<E> var3, HttpRequest var4) {
         this.callback = var1;
         this.dataClass = var2;
         this.errorClass = var3;
         this.request = var4;
      }
   }
}
