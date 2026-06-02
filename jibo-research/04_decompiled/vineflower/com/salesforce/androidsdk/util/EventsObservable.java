package com.salesforce.androidsdk.util;

import android.database.Observable;
import com.salesforce.androidsdk.util.test.EventsObserver;

public class EventsObservable extends Observable<EventsObserver> {
   private static final EventsObservable a = new EventsObservable();

   public static EventsObservable a() {
      return a;
   }

   private void a(EventsObservable.Event param1) {
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
      // 01: getfield com/salesforce/androidsdk/util/EventsObservable.mObservers Ljava/util/ArrayList;
      // 04: astore 2
      // 05: aload 2
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/salesforce/androidsdk/util/EventsObservable.mObservers Ljava/util/ArrayList;
      // 0b: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 0e: astore 3
      // 0f: aload 3
      // 10: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 15: ifeq 2f
      // 18: aload 3
      // 19: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1e: checkcast com/salesforce/androidsdk/util/test/EventsObserver
      // 21: aload 1
      // 22: invokeinterface com/salesforce/androidsdk/util/test/EventsObserver.a (Lcom/salesforce/androidsdk/util/EventsObservable$Event;)V 2
      // 27: goto 0f
      // 2a: astore 1
      // 2b: aload 2
      // 2c: monitorexit
      // 2d: aload 1
      // 2e: athrow
      // 2f: aload 2
      // 30: monitorexit
      // 31: return
      // try (5 -> 9): 18 null
      // try (9 -> 17): 18 null
      // try (19 -> 21): 18 null
      // try (23 -> 25): 18 null
   }

   public void a(EventsObservable.EventType var1) {
      this.a(var1, null);
   }

   public void a(EventsObservable.EventType var1, Object var2) {
      this.a(new EventsObservable.Event(var1, var2));
   }

   public static class Event {
      private EventsObservable.EventType a;
      private Object b;

      public Event(EventsObservable.EventType var1, Object var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public enum EventType {
      AppCreateComplete,
      AppLocked,
      AppUnlocked,
      AuthWebViewCreateComplete,
      AuthWebViewPageFinished,
      GapWebViewCreateComplete,
      GapWebViewPageFinished,
      LoginActivityCreateComplete,
      LogoutComplete,
      MainActivityCreateComplete,
      Other,
      RenditionComplete;

      private static final EventsObservable.EventType[] $VALUES = new EventsObservable.EventType[]{
         EventsObservable.EventType.AppCreateComplete,
         EventsObservable.EventType.AppLocked,
         EventsObservable.EventType.AppUnlocked,
         EventsObservable.EventType.LoginActivityCreateComplete,
         EventsObservable.EventType.MainActivityCreateComplete,
         EventsObservable.EventType.AuthWebViewCreateComplete,
         EventsObservable.EventType.AuthWebViewPageFinished,
         EventsObservable.EventType.GapWebViewCreateComplete,
         EventsObservable.EventType.GapWebViewPageFinished,
         EventsObservable.EventType.LogoutComplete,
         EventsObservable.EventType.RenditionComplete,
         EventsObservable.EventType.Other
      };
   }
}
