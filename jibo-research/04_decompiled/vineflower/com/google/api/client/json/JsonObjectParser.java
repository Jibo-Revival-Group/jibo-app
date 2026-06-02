package com.google.api.client.json;

import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser implements ObjectParser {
   private final JsonFactory jsonFactory;
   private final Set<String> wrapperKeys;

   public JsonObjectParser(JsonFactory var1) {
      this(new JsonObjectParser.Builder(var1));
   }

   protected JsonObjectParser(JsonObjectParser.Builder var1) {
      this.jsonFactory = var1.jsonFactory;
      this.wrapperKeys = new HashSet<>(var1.wrapperKeys);
   }

   private void initializeParser(JsonParser param1) throws IOException {
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
      // 00: bipush 1
      // 01: istore 2
      // 02: aload 0
      // 03: getfield com/google/api/client/json/JsonObjectParser.wrapperKeys Ljava/util/Set;
      // 06: invokeinterface java/util/Set.isEmpty ()Z 1
      // 0b: ifeq 0f
      // 0e: return
      // 0f: aload 1
      // 10: aload 0
      // 11: getfield com/google/api/client/json/JsonObjectParser.wrapperKeys Ljava/util/Set;
      // 14: invokevirtual com/google/api/client/json/JsonParser.skipToKey (Ljava/util/Set;)Ljava/lang/String;
      // 17: ifnull 3f
      // 1a: aload 1
      // 1b: invokevirtual com/google/api/client/json/JsonParser.getCurrentToken ()Lcom/google/api/client/json/JsonToken;
      // 1e: getstatic com/google/api/client/json/JsonToken.END_OBJECT Lcom/google/api/client/json/JsonToken;
      // 21: if_acmpeq 3f
      // 24: iload 2
      // 25: ldc "wrapper key(s) not found: %s"
      // 27: bipush 1
      // 28: anewarray 4
      // 2b: dup
      // 2c: bipush 0
      // 2d: aload 0
      // 2e: getfield com/google/api/client/json/JsonObjectParser.wrapperKeys Ljava/util/Set;
      // 31: aastore
      // 32: invokestatic com/google/api/client/util/Preconditions.checkArgument (ZLjava/lang/String;[Ljava/lang/Object;)V
      // 35: goto 0e
      // 38: astore 3
      // 39: aload 1
      // 3a: invokevirtual com/google/api/client/json/JsonParser.close ()V
      // 3d: aload 3
      // 3e: athrow
      // 3f: bipush 0
      // 40: istore 2
      // 41: goto 24
      // try (7 -> 16): 27 null
      // try (16 -> 26): 27 null
   }

   public final JsonFactory getJsonFactory() {
      return this.jsonFactory;
   }

   public Set<String> getWrapperKeys() {
      return Collections.unmodifiableSet(this.wrapperKeys);
   }

   @Override
   public <T> T parseAndClose(InputStream var1, Charset var2, Class<T> var3) throws IOException {
      return (T)this.parseAndClose(var1, var2, (Type)var3);
   }

   @Override
   public Object parseAndClose(InputStream var1, Charset var2, Type var3) throws IOException {
      JsonParser var4 = this.jsonFactory.createJsonParser(var1, var2);
      this.initializeParser(var4);
      return var4.parse(var3, true);
   }

   @Override
   public <T> T parseAndClose(Reader var1, Class<T> var2) throws IOException {
      return (T)this.parseAndClose(var1, (Type)var2);
   }

   @Override
   public Object parseAndClose(Reader var1, Type var2) throws IOException {
      JsonParser var3 = this.jsonFactory.createJsonParser(var1);
      this.initializeParser(var3);
      return var3.parse(var2, true);
   }

   public static class Builder {
      final JsonFactory jsonFactory;
      Collection<String> wrapperKeys = Sets.newHashSet();

      public Builder(JsonFactory var1) {
         this.jsonFactory = Preconditions.checkNotNull(var1);
      }

      public JsonObjectParser build() {
         return new JsonObjectParser(this);
      }

      public final JsonFactory getJsonFactory() {
         return this.jsonFactory;
      }

      public final Collection<String> getWrapperKeys() {
         return this.wrapperKeys;
      }

      public JsonObjectParser.Builder setWrapperKeys(Collection<String> var1) {
         this.wrapperKeys = var1;
         return this;
      }
   }
}
