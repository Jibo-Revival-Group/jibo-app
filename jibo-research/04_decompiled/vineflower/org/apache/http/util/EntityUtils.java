package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;

public final class EntityUtils {
   private EntityUtils() {
   }

   public static void consume(HttpEntity var0) throws IOException {
      if (var0 != null && var0.isStreaming()) {
         InputStream var1 = var0.getContent();
         if (var1 != null) {
            var1.close();
         }
      }
   }

   public static void consumeQuietly(HttpEntity var0) {
      try {
         consume(var0);
      } catch (IOException var1) {
      }
   }

   @Deprecated
   public static String getContentCharSet(HttpEntity var0) throws ParseException {
      Args.notNull(var0, "Entity");
      Object var2 = null;
      String var1 = (String)var2;
      if (var0.getContentType() != null) {
         HeaderElement[] var3 = var0.getContentType().getElements();
         var1 = (String)var2;
         if (var3.length > 0) {
            NameValuePair var4 = var3[0].getParameterByName("charset");
            var1 = (String)var2;
            if (var4 != null) {
               var1 = var4.getValue();
            }
         }
      }

      return var1;
   }

   @Deprecated
   public static String getContentMimeType(HttpEntity var0) throws ParseException {
      Args.notNull(var0, "Entity");
      Object var2 = null;
      String var1 = (String)var2;
      if (var0.getContentType() != null) {
         HeaderElement[] var3 = var0.getContentType().getElements();
         var1 = (String)var2;
         if (var3.length > 0) {
            var1 = var3[0].getName();
         }
      }

      return var1;
   }

   public static byte[] toByteArray(HttpEntity param0) throws IOException {
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
      // 00: sipush 4096
      // 03: istore 2
      // 04: bipush 0
      // 05: istore 3
      // 06: aload 0
      // 07: ldc "Entity"
      // 09: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 0c: pop
      // 0d: aload 0
      // 0e: invokeinterface org/apache/http/HttpEntity.getContent ()Ljava/io/InputStream; 1
      // 13: astore 4
      // 15: aload 4
      // 17: ifnonnull 1e
      // 1a: aconst_null
      // 1b: astore 0
      // 1c: aload 0
      // 1d: areturn
      // 1e: aload 0
      // 1f: invokeinterface org/apache/http/HttpEntity.getContentLength ()J 1
      // 24: ldc2_w 2147483647
      // 27: lcmp
      // 28: ifgt 2d
      // 2b: bipush 1
      // 2c: istore 3
      // 2d: iload 3
      // 2e: ldc "HTTP entity too large to be buffered in memory"
      // 30: invokestatic org/apache/http/util/Args.check (ZLjava/lang/String;)V
      // 33: aload 0
      // 34: invokeinterface org/apache/http/HttpEntity.getContentLength ()J 1
      // 39: l2i
      // 3a: istore 1
      // 3b: iload 1
      // 3c: ifge 7f
      // 3f: iload 2
      // 40: istore 1
      // 41: new org/apache/http/util/ByteArrayBuffer
      // 44: astore 5
      // 46: aload 5
      // 48: iload 1
      // 49: invokespecial org/apache/http/util/ByteArrayBuffer.<init> (I)V
      // 4c: sipush 4096
      // 4f: newarray 8
      // 51: astore 0
      // 52: aload 4
      // 54: aload 0
      // 55: invokevirtual java/io/InputStream.read ([B)I
      // 58: istore 1
      // 59: iload 1
      // 5a: bipush -1
      // 5b: if_icmpeq 71
      // 5e: aload 5
      // 60: aload 0
      // 61: bipush 0
      // 62: iload 1
      // 63: invokevirtual org/apache/http/util/ByteArrayBuffer.append ([BII)V
      // 66: goto 52
      // 69: astore 0
      // 6a: aload 4
      // 6c: invokevirtual java/io/InputStream.close ()V
      // 6f: aload 0
      // 70: athrow
      // 71: aload 5
      // 73: invokevirtual org/apache/http/util/ByteArrayBuffer.toByteArray ()[B
      // 76: astore 0
      // 77: aload 4
      // 79: invokevirtual java/io/InputStream.close ()V
      // 7c: goto 1c
      // 7f: goto 41
      // try (17 -> 22): 56 null
      // try (24 -> 31): 56 null
      // try (35 -> 43): 56 null
      // try (43 -> 47): 56 null
      // try (50 -> 55): 56 null
      // try (61 -> 64): 56 null
   }

   public static String toString(HttpEntity var0) throws IOException, ParseException {
      return toString(var0, (Charset)null);
   }

   public static String toString(HttpEntity var0, String var1) throws IOException, ParseException {
      Charset var2;
      if (var1 != null) {
         var2 = Charset.forName(var1);
      } else {
         var2 = null;
      }

      return toString(var0, var2);
   }

   public static String toString(HttpEntity param0, Charset param1) throws IOException, ParseException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 7
      // 03: aconst_null
      // 04: astore 8
      // 06: bipush 0
      // 07: istore 4
      // 09: aload 0
      // 0a: ldc "Entity"
      // 0c: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 0f: pop
      // 10: aload 0
      // 11: invokeinterface org/apache/http/HttpEntity.getContent ()Ljava/io/InputStream; 1
      // 16: astore 9
      // 18: aload 9
      // 1a: ifnonnull 22
      // 1d: aload 8
      // 1f: astore 0
      // 20: aload 0
      // 21: areturn
      // 22: aload 0
      // 23: invokeinterface org/apache/http/HttpEntity.getContentLength ()J 1
      // 28: ldc2_w 2147483647
      // 2b: lcmp
      // 2c: ifgt 32
      // 2f: bipush 1
      // 30: istore 4
      // 32: iload 4
      // 34: ldc "HTTP entity too large to be buffered in memory"
      // 36: invokestatic org/apache/http/util/Args.check (ZLjava/lang/String;)V
      // 39: aload 0
      // 3a: invokeinterface org/apache/http/HttpEntity.getContentLength ()J 1
      // 3f: lstore 5
      // 41: lload 5
      // 43: l2i
      // 44: istore 3
      // 45: iload 3
      // 46: istore 2
      // 47: iload 3
      // 48: ifge 4f
      // 4b: sipush 4096
      // 4e: istore 2
      // 4f: aload 0
      // 50: invokestatic org/apache/http/entity/ContentType.get (Lorg/apache/http/HttpEntity;)Lorg/apache/http/entity/ContentType;
      // 53: astore 8
      // 55: aload 7
      // 57: astore 0
      // 58: aload 8
      // 5a: ifnull 63
      // 5d: aload 8
      // 5f: invokevirtual org/apache/http/entity/ContentType.getCharset ()Ljava/nio/charset/Charset;
      // 62: astore 0
      // 63: aload 0
      // 64: astore 7
      // 66: aload 0
      // 67: ifnonnull 6d
      // 6a: aload 1
      // 6b: astore 7
      // 6d: aload 7
      // 6f: astore 0
      // 70: aload 7
      // 72: ifnonnull 79
      // 75: getstatic org/apache/http/protocol/HTTP.DEF_CONTENT_CHARSET Ljava/nio/charset/Charset;
      // 78: astore 0
      // 79: new java/io/InputStreamReader
      // 7c: astore 1
      // 7d: aload 1
      // 7e: aload 9
      // 80: aload 0
      // 81: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
      // 84: new org/apache/http/util/CharArrayBuffer
      // 87: astore 7
      // 89: aload 7
      // 8b: iload 2
      // 8c: invokespecial org/apache/http/util/CharArrayBuffer.<init> (I)V
      // 8f: sipush 1024
      // 92: newarray 5
      // 94: astore 0
      // 95: aload 1
      // 96: aload 0
      // 97: invokevirtual java/io/Reader.read ([C)I
      // 9a: istore 2
      // 9b: iload 2
      // 9c: bipush -1
      // 9d: if_icmpeq cb
      // a0: aload 7
      // a2: aload 0
      // a3: bipush 0
      // a4: iload 2
      // a5: invokevirtual org/apache/http/util/CharArrayBuffer.append ([CII)V
      // a8: goto 95
      // ab: astore 0
      // ac: aload 9
      // ae: invokevirtual java/io/InputStream.close ()V
      // b1: aload 0
      // b2: athrow
      // b3: astore 8
      // b5: aload 7
      // b7: astore 0
      // b8: aload 1
      // b9: ifnonnull 63
      // bc: new java/io/UnsupportedEncodingException
      // bf: astore 0
      // c0: aload 0
      // c1: aload 8
      // c3: invokevirtual java/nio/charset/UnsupportedCharsetException.getMessage ()Ljava/lang/String;
      // c6: invokespecial java/io/UnsupportedEncodingException.<init> (Ljava/lang/String;)V
      // c9: aload 0
      // ca: athrow
      // cb: aload 7
      // cd: invokevirtual org/apache/http/util/CharArrayBuffer.toString ()Ljava/lang/String;
      // d0: astore 0
      // d1: aload 9
      // d3: invokevirtual java/io/InputStream.close ()V
      // d6: goto 20
      // try (19 -> 24): 90 null
      // try (26 -> 32): 90 null
      // try (41 -> 44): 95 java/nio/charset/UnsupportedCharsetException
      // try (41 -> 44): 90 null
      // try (48 -> 51): 95 java/nio/charset/UnsupportedCharsetException
      // try (48 -> 51): 90 null
      // try (61 -> 63): 90 null
      // try (63 -> 77): 90 null
      // try (77 -> 81): 90 null
      // try (84 -> 89): 90 null
      // try (100 -> 108): 90 null
      // try (108 -> 111): 90 null
   }

   public static void updateEntity(HttpResponse var0, HttpEntity var1) throws IOException {
      Args.notNull(var0, "Response");
      consume(var0.getEntity());
      var0.setEntity(var1);
   }
}
