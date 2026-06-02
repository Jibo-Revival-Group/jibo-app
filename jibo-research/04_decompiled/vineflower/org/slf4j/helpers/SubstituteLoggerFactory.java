package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLoggerFactory implements ILoggerFactory {
   boolean a = false;
   final Map<String, SubstituteLogger> b = new HashMap<>();
   final LinkedBlockingQueue<SubstituteLoggingEvent> c = new LinkedBlockingQueue<>();

   public List<SubstituteLogger> a() {
      return new ArrayList<>(this.b.values());
   }

   @Override
   public Logger a(String param1) {
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
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield org/slf4j/helpers/SubstituteLoggerFactory.b Ljava/util/Map;
      // 06: aload 1
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast org/slf4j/helpers/SubstituteLogger
      // 0f: astore 3
      // 10: aload 3
      // 11: astore 2
      // 12: aload 3
      // 13: ifnonnull 33
      // 16: new org/slf4j/helpers/SubstituteLogger
      // 19: astore 2
      // 1a: aload 2
      // 1b: aload 1
      // 1c: aload 0
      // 1d: getfield org/slf4j/helpers/SubstituteLoggerFactory.c Ljava/util/concurrent/LinkedBlockingQueue;
      // 20: aload 0
      // 21: getfield org/slf4j/helpers/SubstituteLoggerFactory.a Z
      // 24: invokespecial org/slf4j/helpers/SubstituteLogger.<init> (Ljava/lang/String;Ljava/util/Queue;Z)V
      // 27: aload 0
      // 28: getfield org/slf4j/helpers/SubstituteLoggerFactory.b Ljava/util/Map;
      // 2b: aload 1
      // 2c: aload 2
      // 2d: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 32: pop
      // 33: aload 0
      // 34: monitorexit
      // 35: aload 2
      // 36: areturn
      // 37: astore 1
      // 38: aload 0
      // 39: monitorexit
      // 3a: aload 1
      // 3b: athrow
      // try (2 -> 8): 31 null
      // try (12 -> 27): 31 null
   }

   public LinkedBlockingQueue<SubstituteLoggingEvent> b() {
      return this.c;
   }

   public void c() {
      this.a = true;
   }

   public void d() {
      this.b.clear();
      this.c.clear();
   }
}
