package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class LazyHeaders implements Headers {
   private volatile Map<String, String> combinedHeaders;
   private final Map<String, List<LazyHeaderFactory>> headers;

   LazyHeaders(Map<String, List<LazyHeaderFactory>> var1) {
      this.headers = Collections.unmodifiableMap(var1);
   }

   private Map<String, String> generateHeaders() {
      HashMap var6 = new HashMap();

      for (Entry var3 : this.headers.entrySet()) {
         StringBuilder var4 = new StringBuilder();
         List var5 = (List)var3.getValue();

         for (int var1 = 0; var1 < var5.size(); var1++) {
            var4.append(((LazyHeaderFactory)var5.get(var1)).buildHeader());
            if (var1 != var5.size() - 1) {
               var4.append(',');
            }
         }

         var6.put(var3.getKey(), var4.toString());
      }

      return var6;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof LazyHeaders) {
         var1 = var1;
         var2 = this.headers.equals(var1.headers);
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public Map<String, String> getHeaders() {
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
      // 00: aload 0
      // 01: getfield com/bumptech/glide/load/model/LazyHeaders.combinedHeaders Ljava/util/Map;
      // 04: ifnonnull 1d
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/bumptech/glide/load/model/LazyHeaders.combinedHeaders Ljava/util/Map;
      // 0d: ifnonnull 1b
      // 10: aload 0
      // 11: aload 0
      // 12: invokespecial com/bumptech/glide/load/model/LazyHeaders.generateHeaders ()Ljava/util/Map;
      // 15: invokestatic java/util/Collections.unmodifiableMap (Ljava/util/Map;)Ljava/util/Map;
      // 18: putfield com/bumptech/glide/load/model/LazyHeaders.combinedHeaders Ljava/util/Map;
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 0
      // 1e: getfield com/bumptech/glide/load/model/LazyHeaders.combinedHeaders Ljava/util/Map;
      // 21: areturn
      // 22: astore 1
      // 23: aload 0
      // 24: monitorexit
      // 25: aload 1
      // 26: athrow
      // try (5 -> 13): 18 null
      // try (13 -> 15): 18 null
      // try (19 -> 21): 18 null
   }

   @Override
   public int hashCode() {
      return this.headers.hashCode();
   }

   @Override
   public String toString() {
      return "LazyHeaders{headers=" + this.headers + '}';
   }

   public static final class Builder {
      private static final Map<String, List<LazyHeaderFactory>> DEFAULT_HEADERS;
      private static final String DEFAULT_USER_AGENT = System.getProperty("http.agent");
      private boolean copyOnModify = true;
      private Map<String, List<LazyHeaderFactory>> headers;
      private boolean isEncodingDefault;
      private boolean isUserAgentDefault;

      static {
         HashMap var0 = new HashMap(2);
         if (!TextUtils.isEmpty(DEFAULT_USER_AGENT)) {
            var0.put("User-Agent", Collections.singletonList(new LazyHeaders.StringHeaderFactory(DEFAULT_USER_AGENT)));
         }

         var0.put("Accept-Encoding", Collections.singletonList(new LazyHeaders.StringHeaderFactory("identity")));
         DEFAULT_HEADERS = Collections.unmodifiableMap(var0);
      }

      public Builder() {
         this.headers = DEFAULT_HEADERS;
         this.isEncodingDefault = true;
         this.isUserAgentDefault = true;
      }

      public LazyHeaders build() {
         this.copyOnModify = true;
         return new LazyHeaders(this.headers);
      }
   }

   static final class StringHeaderFactory implements LazyHeaderFactory {
      private final String value;

      StringHeaderFactory(String var1) {
         this.value = var1;
      }

      @Override
      public String buildHeader() {
         return this.value;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var2;
         if (var1 instanceof LazyHeaders.StringHeaderFactory) {
            var1 = var1;
            var2 = this.value.equals(var1.value);
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return this.value.hashCode();
      }

      @Override
      public String toString() {
         return "StringHeaderFactory{value='" + this.value + '\'' + '}';
      }
   }
}
