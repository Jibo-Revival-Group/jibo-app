package com.facebook.appevents;

import java.util.HashMap;
import java.util.Set;

class AppEventCollection {
   private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

   public AppEventCollection() {
   }

   private SessionEventsState getSessionEventsState(AccessTokenAppIdPair param1) {
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
      // 03: getfield com/facebook/appevents/AppEventCollection.stateMap Ljava/util/HashMap;
      // 06: aload 1
      // 07: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0a: checkcast com/facebook/appevents/SessionEventsState
      // 0d: astore 3
      // 0e: aload 3
      // 0f: astore 2
      // 10: aload 3
      // 11: ifnonnull 28
      // 14: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 17: astore 3
      // 18: new com/facebook/appevents/SessionEventsState
      // 1b: astore 2
      // 1c: aload 2
      // 1d: aload 3
      // 1e: invokestatic com/facebook/internal/AttributionIdentifiers.getAttributionIdentifiers (Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
      // 21: aload 3
      // 22: invokestatic com/facebook/appevents/AppEventsLogger.getAnonymousAppDeviceGUID (Landroid/content/Context;)Ljava/lang/String;
      // 25: invokespecial com/facebook/appevents/SessionEventsState.<init> (Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V
      // 28: aload 0
      // 29: getfield com/facebook/appevents/AppEventCollection.stateMap Ljava/util/HashMap;
      // 2c: aload 1
      // 2d: aload 2
      // 2e: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 31: pop
      // 32: aload 0
      // 33: monitorexit
      // 34: aload 2
      // 35: areturn
      // 36: astore 1
      // 37: aload 0
      // 38: monitorexit
      // 39: aload 1
      // 3a: athrow
      // try (2 -> 8): 32 null
      // try (12 -> 22): 32 null
      // try (22 -> 28): 32 null
   }

   public void addEvent(AccessTokenAppIdPair var1, AppEvent var2) {
      synchronized (this) {
         this.getSessionEventsState(var1).addEvent(var2);
      }
   }

   public void addPersistedEvents(PersistedEvents param1) {
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
      // 03: ifnonnull 09
      // 06: aload 0
      // 07: monitorexit
      // 08: return
      // 09: aload 1
      // 0a: invokevirtual com/facebook/appevents/PersistedEvents.keySet ()Ljava/util/Set;
      // 0d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 12: astore 2
      // 13: aload 2
      // 14: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 19: ifeq 06
      // 1c: aload 2
      // 1d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 22: checkcast com/facebook/appevents/AccessTokenAppIdPair
      // 25: astore 4
      // 27: aload 0
      // 28: aload 4
      // 2a: invokespecial com/facebook/appevents/AppEventCollection.getSessionEventsState (Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/SessionEventsState;
      // 2d: astore 3
      // 2e: aload 1
      // 2f: aload 4
      // 31: invokevirtual com/facebook/appevents/PersistedEvents.get (Lcom/facebook/appevents/AccessTokenAppIdPair;)Ljava/util/List;
      // 34: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 39: astore 4
      // 3b: aload 4
      // 3d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 42: ifeq 13
      // 45: aload 3
      // 46: aload 4
      // 48: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4d: checkcast com/facebook/appevents/AppEvent
      // 50: invokevirtual com/facebook/appevents/SessionEventsState.addEvent (Lcom/facebook/appevents/AppEvent;)V
      // 53: goto 3b
      // 56: astore 1
      // 57: aload 0
      // 58: monitorexit
      // 59: aload 1
      // 5a: athrow
      // try (7 -> 11): 36 null
      // try (11 -> 27): 36 null
      // try (27 -> 35): 36 null
   }

   public SessionEventsState get(AccessTokenAppIdPair var1) {
      synchronized (this) {
         return this.stateMap.get(var1);
      }
   }

   public int getEventCount() {
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
      // 02: aload 0
      // 03: getfield com/facebook/appevents/AppEventCollection.stateMap Ljava/util/HashMap;
      // 06: invokevirtual java/util/HashMap.values ()Ljava/util/Collection;
      // 09: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0e: astore 3
      // 0f: bipush 0
      // 10: istore 1
      // 11: aload 3
      // 12: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17: ifeq 2e
      // 1a: aload 3
      // 1b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20: checkcast com/facebook/appevents/SessionEventsState
      // 23: invokevirtual com/facebook/appevents/SessionEventsState.getAccumulatedEventCount ()I
      // 26: istore 2
      // 27: iload 2
      // 28: iload 1
      // 29: iadd
      // 2a: istore 1
      // 2b: goto 11
      // 2e: aload 0
      // 2f: monitorexit
      // 30: iload 1
      // 31: ireturn
      // 32: astore 3
      // 33: aload 0
      // 34: monitorexit
      // 35: aload 3
      // 36: athrow
      // try (2 -> 7): 26 null
      // try (9 -> 17): 26 null
   }

   public Set<AccessTokenAppIdPair> keySet() {
      synchronized (this) {
         return this.stateMap.keySet();
      }
   }
}
