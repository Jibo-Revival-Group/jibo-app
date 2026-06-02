package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidJsonUnmarshaller;
import com.jibo.aws.integration.util.a;

public class JsonResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {
   public static final String TAG = a.a(JsonResponseHandler.class);
   public boolean needsConnectionLeftOpen = false;
   private Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller;

   public JsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> var1) {
      this.responseUnmarshaller = var1;
      if (this.responseUnmarshaller == null) {
         this.responseUnmarshaller = new VoidJsonUnmarshaller<>();
      }
   }

   public AmazonWebServiceResponse<T> handle(HttpResponse param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: getstatic com/amazonaws/http/JsonResponseHandler.TAG Ljava/lang/String;
      // 003: ldc "Parsing service response JSON"
      // 005: invokestatic com/jibo/aws/integration/util/a.b (Ljava/lang/String;Ljava/lang/String;)V
      // 008: aload 1
      // 009: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 00c: ldc "x-amz-crc32"
      // 00e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 013: checkcast java/lang/String
      // 016: astore 7
      // 018: aload 1
      // 019: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 01c: astore 5
      // 01e: aload 5
      // 020: astore 4
      // 022: aload 5
      // 024: ifnonnull 038
      // 027: new java/io/ByteArrayInputStream
      // 02a: dup
      // 02b: ldc "{}"
      // 02d: getstatic com/amazonaws/util/StringUtils.UTF8 Ljava/nio/charset/Charset;
      // 030: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 033: invokespecial java/io/ByteArrayInputStream.<init> ([B)V
      // 036: astore 4
      // 038: aload 7
      // 03a: ifnull 179
      // 03d: new com/amazonaws/util/CRC32ChecksumCalculatingInputStream
      // 040: dup
      // 041: aload 4
      // 043: invokespecial com/amazonaws/util/CRC32ChecksumCalculatingInputStream.<init> (Ljava/io/InputStream;)V
      // 046: astore 5
      // 048: aload 5
      // 04a: astore 4
      // 04c: ldc "gzip"
      // 04e: aload 1
      // 04f: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 052: ldc "Content-Encoding"
      // 054: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 059: checkcast java/lang/String
      // 05c: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 05f: ifne 07c
      // 062: aload 4
      // 064: astore 6
      // 066: ldc "gzip"
      // 068: aload 1
      // 069: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 06c: ldc "content-encoding"
      // 06e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 073: checkcast java/lang/String
      // 076: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 079: ifeq 087
      // 07c: new java/util/zip/GZIPInputStream
      // 07f: dup
      // 080: aload 4
      // 082: invokespecial java/util/zip/GZIPInputStream.<init> (Ljava/io/InputStream;)V
      // 085: astore 6
      // 087: new java/io/InputStreamReader
      // 08a: dup
      // 08b: aload 6
      // 08d: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;)V
      // 090: invokestatic com/amazonaws/util/json/JsonUtils.getJsonReader (Ljava/io/Reader;)Lcom/amazonaws/util/json/AwsJsonReader;
      // 093: astore 4
      // 095: new com/amazonaws/AmazonWebServiceResponse
      // 098: astore 6
      // 09a: aload 6
      // 09c: invokespecial com/amazonaws/AmazonWebServiceResponse.<init> ()V
      // 09f: new com/amazonaws/transform/JsonUnmarshallerContext
      // 0a2: astore 8
      // 0a4: aload 8
      // 0a6: aload 4
      // 0a8: aload 1
      // 0a9: invokespecial com/amazonaws/transform/JsonUnmarshallerContext.<init> (Lcom/amazonaws/util/json/AwsJsonReader;Lcom/amazonaws/http/HttpResponse;)V
      // 0ac: aload 0
      // 0ad: getfield com/amazonaws/http/JsonResponseHandler.responseUnmarshaller Lcom/amazonaws/transform/Unmarshaller;
      // 0b0: aload 8
      // 0b2: invokeinterface com/amazonaws/transform/Unmarshaller.unmarshall (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0b7: astore 8
      // 0b9: aload 7
      // 0bb: ifnull 0eb
      // 0be: aload 7
      // 0c0: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
      // 0c3: lstore 2
      // 0c4: aload 5
      // 0c6: invokevirtual com/amazonaws/util/CRC32ChecksumCalculatingInputStream.getCRC32Checksum ()J
      // 0c9: lload 2
      // 0ca: lcmp
      // 0cb: ifeq 0eb
      // 0ce: new com/amazonaws/internal/CRC32MismatchException
      // 0d1: astore 1
      // 0d2: aload 1
      // 0d3: ldc "Client calculated crc32 checksum didn't match that calculated by server side"
      // 0d5: invokespecial com/amazonaws/internal/CRC32MismatchException.<init> (Ljava/lang/String;)V
      // 0d8: aload 1
      // 0d9: athrow
      // 0da: astore 1
      // 0db: aload 0
      // 0dc: getfield com/amazonaws/http/JsonResponseHandler.needsConnectionLeftOpen Z
      // 0df: ifne 0e9
      // 0e2: aload 4
      // 0e4: invokeinterface com/amazonaws/util/json/AwsJsonReader.close ()V 1
      // 0e9: aload 1
      // 0ea: athrow
      // 0eb: aload 6
      // 0ed: aload 8
      // 0ef: invokevirtual com/amazonaws/AmazonWebServiceResponse.setResult (Ljava/lang/Object;)V
      // 0f2: new java/util/HashMap
      // 0f5: astore 5
      // 0f7: aload 5
      // 0f9: invokespecial java/util/HashMap.<init> ()V
      // 0fc: aload 5
      // 0fe: ldc "AWS_REQUEST_ID"
      // 100: aload 1
      // 101: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 104: ldc "x-amzn-RequestId"
      // 106: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 10b: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 110: pop
      // 111: new com/amazonaws/ResponseMetadata
      // 114: astore 1
      // 115: aload 1
      // 116: aload 5
      // 118: invokespecial com/amazonaws/ResponseMetadata.<init> (Ljava/util/Map;)V
      // 11b: aload 6
      // 11d: aload 1
      // 11e: invokevirtual com/amazonaws/AmazonWebServiceResponse.setResponseMetadata (Lcom/amazonaws/ResponseMetadata;)V
      // 121: getstatic com/amazonaws/http/JsonResponseHandler.TAG Ljava/lang/String;
      // 124: ldc "Done parsing service response"
      // 126: invokestatic com/jibo/aws/integration/util/a.b (Ljava/lang/String;Ljava/lang/String;)V
      // 129: getstatic com/amazonaws/http/JsonResponseHandler.TAG Ljava/lang/String;
      // 12c: astore 7
      // 12e: new java/lang/StringBuilder
      // 131: astore 1
      // 132: aload 1
      // 133: invokespecial java/lang/StringBuilder.<init> ()V
      // 136: aload 7
      // 138: aload 1
      // 139: ldc "Metadata: "
      // 13b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 13e: aload 5
      // 140: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 143: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 146: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 149: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 14c: aload 0
      // 14d: getfield com/amazonaws/http/JsonResponseHandler.needsConnectionLeftOpen Z
      // 150: ifne 15a
      // 153: aload 4
      // 155: invokeinterface com/amazonaws/util/json/AwsJsonReader.close ()V 1
      // 15a: aload 6
      // 15c: areturn
      // 15d: astore 1
      // 15e: getstatic com/amazonaws/http/JsonResponseHandler.TAG Ljava/lang/String;
      // 161: ldc "Error closing json parser"
      // 163: aload 1
      // 164: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 167: goto 15a
      // 16a: astore 4
      // 16c: getstatic com/amazonaws/http/JsonResponseHandler.TAG Ljava/lang/String;
      // 16f: ldc "Error closing json parser"
      // 171: aload 4
      // 173: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 176: goto 0e9
      // 179: aconst_null
      // 17a: astore 5
      // 17c: goto 04c
      // try (61 -> 76): 93 null
      // try (78 -> 93): 93 null
      // try (97 -> 99): 155 java/io/IOException
      // try (101 -> 142): 93 null
      // try (145 -> 147): 149 java/io/IOException
   }

   @Override
   public boolean needsConnectionLeftOpen() {
      return this.needsConnectionLeftOpen;
   }
}
