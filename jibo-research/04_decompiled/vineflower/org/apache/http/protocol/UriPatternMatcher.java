package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public class UriPatternMatcher<T> {
   @GuardedBy("this")
   private final Map<String, T> map = new HashMap<>();

   @Deprecated
   public Map<String, T> getObjects() {
      synchronized (this) {
         return this.map;
      }
   }

   public T lookup(String param1) {
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
      // 02: aload 1
      // 03: ldc "Request path"
      // 05: invokestatic org/apache/http/util/Args.notNull (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      // 08: pop
      // 09: aload 0
      // 0a: getfield org/apache/http/protocol/UriPatternMatcher.map Ljava/util/Map;
      // 0d: aload 1
      // 0e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13: astore 2
      // 14: aload 2
      // 15: astore 4
      // 17: aload 2
      // 18: ifnonnull 90
      // 1b: aconst_null
      // 1c: astore 3
      // 1d: aload 0
      // 1e: getfield org/apache/http/protocol/UriPatternMatcher.map Ljava/util/Map;
      // 21: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 26: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2b: astore 5
      // 2d: aload 2
      // 2e: astore 4
      // 30: aload 5
      // 32: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 37: ifeq 90
      // 3a: aload 5
      // 3c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 41: checkcast java/lang/String
      // 44: astore 4
      // 46: aload 0
      // 47: aload 4
      // 49: aload 1
      // 4a: invokevirtual org/apache/http/protocol/UriPatternMatcher.matchUriRequestPattern (Ljava/lang/String;Ljava/lang/String;)Z
      // 4d: ifeq 9a
      // 50: aload 3
      // 51: ifnull 76
      // 54: aload 3
      // 55: invokevirtual java/lang/String.length ()I
      // 58: aload 4
      // 5a: invokevirtual java/lang/String.length ()I
      // 5d: if_icmplt 76
      // 60: aload 3
      // 61: invokevirtual java/lang/String.length ()I
      // 64: aload 4
      // 66: invokevirtual java/lang/String.length ()I
      // 69: if_icmpne 9a
      // 6c: aload 4
      // 6e: ldc "*"
      // 70: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 73: ifeq 9a
      // 76: aload 0
      // 77: getfield org/apache/http/protocol/UriPatternMatcher.map Ljava/util/Map;
      // 7a: aload 4
      // 7c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 81: astore 3
      // 82: aload 4
      // 84: astore 2
      // 85: aload 3
      // 86: astore 4
      // 88: aload 2
      // 89: astore 3
      // 8a: aload 4
      // 8c: astore 2
      // 8d: goto 2d
      // 90: aload 0
      // 91: monitorexit
      // 92: aload 4
      // 94: areturn
      // 95: astore 1
      // 96: aload 0
      // 97: monitorexit
      // 98: aload 1
      // 99: athrow
      // 9a: aload 2
      // 9b: astore 4
      // 9d: aload 3
      // 9e: astore 2
      // 9f: aload 4
      // a1: astore 3
      // a2: goto 85
      // try (2 -> 11): 70 null
      // try (17 -> 22): 70 null
      // try (24 -> 36): 70 null
      // try (38 -> 52): 70 null
      // try (52 -> 57): 70 null
   }

   protected boolean matchUriRequestPattern(String var1, String var2) {
      boolean var4 = false;
      boolean var3 = true;
      if (!var1.equals("*")) {
         if (!var1.endsWith("*") || !var2.startsWith(var1.substring(0, var1.length() - 1))) {
            var3 = var4;
            if (!var1.startsWith("*")) {
               return var3;
            }

            var3 = var4;
            if (!var2.endsWith(var1.substring(1, var1.length()))) {
               return var3;
            }
         }

         var3 = true;
      }

      return var3;
   }

   public void register(String var1, T var2) {
      synchronized (this) {
         Args.notNull(var1, "URI request pattern");
         this.map.put(var1, (T)var2);
      }
   }

   @Deprecated
   public void setHandlers(Map<String, T> var1) {
      synchronized (this) {
         Args.notNull(var1, "Map of handlers");
         this.map.clear();
         this.map.putAll(var1);
      }
   }

   @Deprecated
   public void setObjects(Map<String, T> var1) {
      synchronized (this) {
         Args.notNull(var1, "Map of handlers");
         this.map.clear();
         this.map.putAll(var1);
      }
   }

   @Override
   public String toString() {
      return this.map.toString();
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void unregister(String var1) {
      synchronized (this){} // $VF: monitorenter 
      if (var1 != null) {
         try {
            this.map.remove(var1);
         } finally {
            // $VF: monitorexit
         }
      }
   }
}
