package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

@Beta
final class AuthKeyValueParser implements ObjectParser {
   public static final AuthKeyValueParser INSTANCE = new AuthKeyValueParser();

   private AuthKeyValueParser() {
   }

   public String getContentType() {
      return "text/plain";
   }

   public <T> T parse(HttpResponse var1, Class<T> var2) throws IOException {
      var1.setContentLoggingLimit(0);
      InputStream var5 = var1.getContent();

      try {
         return this.parse(var5, var2);
      } finally {
         var5.close();
      }
   }

   public <T> T parse(InputStream var1, Class<T> var2) throws IOException {
      ClassInfo var4 = ClassInfo.of(var2);
      Object var5 = Types.newInstance(var2);
      BufferedReader var6 = new BufferedReader(new InputStreamReader(var1));

      while (true) {
         String var9 = var6.readLine();
         if (var9 == null) {
            return (T)var5;
         }

         int var3 = var9.indexOf(61);
         String var8 = var9.substring(0, var3);
         Serializable var10 = var9.substring(var3 + 1);
         Field var7 = var4.getField(var8);
         if (var7 != null) {
            Class var11 = var7.getType();
            if (var11 == boolean.class || var11 == Boolean.class) {
               var10 = Boolean.valueOf(var10);
            }

            FieldInfo.setFieldValue(var7, var5, var10);
         } else if (GenericData.class.isAssignableFrom(var2)) {
            ((GenericData)var5).set(var8, var10);
         } else if (Map.class.isAssignableFrom(var2)) {
            ((Map)var5).put(var8, var10);
         }
      }
   }

   @Override
   public <T> T parseAndClose(InputStream var1, Charset var2, Class<T> var3) throws IOException {
      return this.parseAndClose(new InputStreamReader(var1, var2), var3);
   }

   @Override
   public Object parseAndClose(InputStream var1, Charset var2, Type var3) {
      throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
   }

   @Override
   public <T> T parseAndClose(Reader param1, Class<T> param2) throws IOException {
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
      // 00: aload 2
      // 01: invokestatic com/google/api/client/util/ClassInfo.of (Ljava/lang/Class;)Lcom/google/api/client/util/ClassInfo;
      // 04: astore 6
      // 06: aload 2
      // 07: invokestatic com/google/api/client/util/Types.newInstance (Ljava/lang/Class;)Ljava/lang/Object;
      // 0a: astore 7
      // 0c: new java/io/BufferedReader
      // 0f: astore 5
      // 11: aload 5
      // 13: aload 1
      // 14: invokespecial java/io/BufferedReader.<init> (Ljava/io/Reader;)V
      // 17: aload 5
      // 19: invokevirtual java/io/BufferedReader.readLine ()Ljava/lang/String;
      // 1c: astore 4
      // 1e: aload 4
      // 20: ifnonnull 2a
      // 23: aload 1
      // 24: invokevirtual java/io/Reader.close ()V
      // 27: aload 7
      // 29: areturn
      // 2a: aload 4
      // 2c: bipush 61
      // 2e: invokevirtual java/lang/String.indexOf (I)I
      // 31: istore 3
      // 32: aload 4
      // 34: bipush 0
      // 35: iload 3
      // 36: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 39: astore 9
      // 3b: aload 4
      // 3d: iload 3
      // 3e: bipush 1
      // 3f: iadd
      // 40: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 43: astore 4
      // 45: aload 6
      // 47: aload 9
      // 49: invokevirtual com/google/api/client/util/ClassInfo.getField (Ljava/lang/String;)Ljava/lang/reflect/Field;
      // 4c: astore 8
      // 4e: aload 8
      // 50: ifnull 86
      // 53: aload 8
      // 55: invokevirtual java/lang/reflect/Field.getType ()Ljava/lang/Class;
      // 58: astore 9
      // 5a: aload 9
      // 5c: getstatic java/lang/Boolean.TYPE Ljava/lang/Class;
      // 5f: if_acmpeq 69
      // 62: aload 9
      // 64: ldc java/lang/Boolean
      // 66: if_acmpne 83
      // 69: aload 4
      // 6b: invokestatic java/lang/Boolean.valueOf (Ljava/lang/String;)Ljava/lang/Boolean;
      // 6e: astore 4
      // 70: aload 8
      // 72: aload 7
      // 74: aload 4
      // 76: invokestatic com/google/api/client/util/FieldInfo.setFieldValue (Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
      // 79: goto 17
      // 7c: astore 2
      // 7d: aload 1
      // 7e: invokevirtual java/io/Reader.close ()V
      // 81: aload 2
      // 82: athrow
      // 83: goto 70
      // 86: ldc com/google/api/client/util/GenericData
      // 88: aload 2
      // 89: invokevirtual java/lang/Class.isAssignableFrom (Ljava/lang/Class;)Z
      // 8c: ifeq 9f
      // 8f: aload 7
      // 91: checkcast com/google/api/client/util/GenericData
      // 94: aload 9
      // 96: aload 4
      // 98: invokevirtual com/google/api/client/util/GenericData.set (Ljava/lang/String;Ljava/lang/Object;)Lcom/google/api/client/util/GenericData;
      // 9b: pop
      // 9c: goto 17
      // 9f: ldc java/util/Map
      // a1: aload 2
      // a2: invokevirtual java/lang/Class.isAssignableFrom (Ljava/lang/Class;)Z
      // a5: ifeq 17
      // a8: aload 7
      // aa: checkcast java/util/Map
      // ad: aload 9
      // af: aload 4
      // b1: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // b6: pop
      // b7: goto 17
      // try (0 -> 11): 58 null
      // try (11 -> 14): 58 null
      // try (20 -> 39): 58 null
      // try (41 -> 47): 58 null
      // try (50 -> 53): 58 null
      // try (53 -> 57): 58 null
      // try (64 -> 74): 58 null
      // try (75 -> 85): 58 null
   }

   @Override
   public Object parseAndClose(Reader var1, Type var2) {
      throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
   }
}
