package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.request.InternalLiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.request.LiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class InternalLiveAgentLoggingSession implements LiveAgentLoggingSession, PodConnectionManager.Listener, HandlerManager.OnTimerElapsedListener {
   private static final ServiceLogger b = ServiceLogging.a(InternalLiveAgentLoggingSession.class);
   protected final LiveAgentQueue a;
   private final PodConnectionManager c;
   private final LiveAgentLoggingRequestFactory d;
   private final Timer e;
   private final LiveAgentLoggingConfiguration f;
   private final int g;
   private Set<LiveAgentLoggingSession.Listener> h = new HashSet<>();
   private List<BaseEvent> i = new ArrayList<>();
   private LiveAgentSession j;
   private SessionInfo k;

   protected InternalLiveAgentLoggingSession(InternalLiveAgentLoggingSession.Builder var1) {
      this.c = var1.c.a(this);
      this.d = var1.d;
      this.e = var1.e.a(this).a();
      this.f = var1.b;
      this.g = var1.b.c();
      this.a = var1.f.a(true).a();
   }

   @Override
   public LiveAgentLoggingSession a(LiveAgentLoggingSession.Listener var1) {
      this.h.add(var1);
      return this;
   }

   @Override
   public Async<BatchedEventsResponse> a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.c Lcom/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager;
      // 04: invokevirtual com/salesforce/android/service/common/liveagentlogging/internal/PodConnectionManager.a ()Z
      // 07: ifeq 18
      // 0a: aload 0
      // 0b: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.j Lcom/salesforce/android/service/common/liveagentclient/LiveAgentSession;
      // 0e: ifnull 18
      // 11: aload 0
      // 12: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.k Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;
      // 15: ifnonnull 28
      // 18: getstatic com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.b Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 1b: ldc "Unable to send logging events without an active LiveAgent session."
      // 1d: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.d (Ljava/lang/String;)V 2
      // 22: invokestatic com/salesforce/android/service/common/utilities/control/BasicAsync.h ()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
      // 25: astore 1
      // 26: aload 1
      // 27: areturn
      // 28: aload 0
      // 29: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.i Ljava/util/List;
      // 2c: invokeinterface java/util/List.isEmpty ()Z 1
      // 31: ifeq 45
      // 34: getstatic com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.b Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 37: ldc "There are no queued logging events to send."
      // 39: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.b (Ljava/lang/String;)V 2
      // 3e: invokestatic com/salesforce/android/service/common/utilities/control/BasicAsync.h ()Lcom/salesforce/android/service/common/utilities/control/BasicAsync;
      // 41: astore 1
      // 42: goto 26
      // 45: aload 0
      // 46: monitorenter
      // 47: new java/util/ArrayList
      // 4a: astore 1
      // 4b: aload 1
      // 4c: aload 0
      // 4d: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.i Ljava/util/List;
      // 50: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 53: aload 0
      // 54: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.i Ljava/util/List;
      // 57: invokeinterface java/util/List.clear ()V 1
      // 5c: aload 0
      // 5d: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.e Lcom/salesforce/android/service/common/utilities/threading/Timer;
      // 60: invokevirtual com/salesforce/android/service/common/utilities/threading/Timer.b ()V
      // 63: aload 0
      // 64: monitorexit
      // 65: getstatic com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.b Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;
      // 68: ldc "Sending {} queued events [LiveAgent Session ID - {}]"
      // 6a: bipush 2
      // 6b: anewarray 4
      // 6e: dup
      // 6f: bipush 0
      // 70: aload 1
      // 71: invokeinterface java/util/List.size ()I 1
      // 76: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 79: aastore
      // 7a: dup
      // 7b: bipush 1
      // 7c: aload 0
      // 7d: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.k Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;
      // 80: invokevirtual com/salesforce/android/service/common/liveagentclient/SessionInfo.a ()Ljava/lang/String;
      // 83: aastore
      // 84: invokeinterface com/salesforce/android/service/common/utilities/logging/ServiceLogger.a (Ljava/lang/String;[Ljava/lang/Object;)V 3
      // 89: aload 0
      // 8a: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.d Lcom/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory;
      // 8d: aload 0
      // 8e: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.k Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;
      // 91: aload 1
      // 92: invokeinterface com/salesforce/android/service/common/liveagentlogging/internal/request/LiveAgentLoggingRequestFactory.a (Lcom/salesforce/android/service/common/liveagentclient/SessionInfo;Ljava/util/List;)Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents; 3
      // 97: astore 2
      // 98: aload 0
      // 99: getfield com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.a Lcom/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue;
      // 9c: aload 2
      // 9d: ldc com/salesforce/android/service/common/liveagentlogging/internal/response/BatchedEventsResponse
      // 9f: invokevirtual com/salesforce/android/service/common/liveagentclient/integrity/LiveAgentQueue.a (Lcom/salesforce/android/service/common/liveagentclient/request/LiveAgentRequest;Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/control/Async;
      // a2: astore 1
      // a3: aload 1
      // a4: new com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1
      // a7: dup
      // a8: aload 0
      // a9: aload 2
      // aa: invokespecial com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession$1.<init> (Lcom/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession;Lcom/salesforce/android/service/common/liveagentlogging/internal/request/BatchedEvents;)V
      // ad: invokeinterface com/salesforce/android/service/common/utilities/control/Async.a (Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;)Lcom/salesforce/android/service/common/utilities/control/Async; 2
      // b2: pop
      // b3: aload 0
      // b4: aload 1
      // b5: invokevirtual com/salesforce/android/service/common/liveagentlogging/internal/InternalLiveAgentLoggingSession.a (Lcom/salesforce/android/service/common/utilities/control/Async;)V
      // b8: goto 26
      // bb: astore 1
      // bc: aload 0
      // bd: monitorexit
      // be: aload 1
      // bf: athrow
      // try (29 -> 43): 85 null
      // try (86 -> 88): 85 null
   }

   @Override
   public void a(LiveAgentSession var1, SessionInfo var2) {
      b.c("Connected to a new Live Agent session {}", var2.a());
      this.j = var1;
      this.k = var2;
      this.j.a(this.f.b());
      this.a.a(this.j);
      Iterator var3 = this.h.iterator();

      while (var3.hasNext()) {
         ((LiveAgentLoggingSession.Listener)var3.next()).c();
      }
   }

   @Override
   public void a(BaseEvent var1) {
      b.a("Queuing a Logging Event: {}", var1.getClass().getSimpleName());
      this.i.add(var1);
      if (this.i.size() == 1) {
         this.e.a();
      } else if (this.i.size() >= this.g) {
         this.a();
      }
   }

   void a(Async<BatchedEventsResponse> var1) {
      Iterator var2 = this.h.iterator();

      while (var2.hasNext()) {
         ((LiveAgentLoggingSession.Listener)var2.next()).a(var1);
      }
   }

   @Override
   public void a(Collection<? extends BaseEvent> var1) {
      b.a("Batch queueing {} events", var1.size());
      this.i.addAll(var1);
      if (this.i.size() == var1.size()) {
         this.e.a();
      } else if (this.i.size() >= this.g) {
         this.a(this.a());
      }
   }

   @Override
   public void b() {
      if (this.k != null) {
         this.a(this.a());
      } else {
         b.d("Unable to flush via timer. LiveAgent session is not active.");
      }
   }

   public void c() {
      b.c("Tearing down the Live Agent Logging session.");
      this.a.a();
      this.c.b(this);
      this.c.c();
      this.e.b();
      this.i.clear();
   }

   @Override
   public void d() {
      this.a.a();
      Iterator var1 = this.h.iterator();

      while (var1.hasNext()) {
         ((LiveAgentLoggingSession.Listener)var1.next()).d();
      }
   }

   public static class Builder {
      protected Context a;
      protected LiveAgentLoggingConfiguration b;
      protected PodConnectionManager c;
      protected LiveAgentLoggingRequestFactory d;
      protected Timer.Builder e;
      protected LiveAgentQueue.Builder f;

      public InternalLiveAgentLoggingSession.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public InternalLiveAgentLoggingSession.Builder a(LiveAgentLoggingConfiguration var1) {
         this.b = var1;
         return this;
      }

      public InternalLiveAgentLoggingSession.Builder a(PodConnectionManager var1) {
         this.c = var1;
         return this;
      }

      public InternalLiveAgentLoggingSession a() {
         Arguments.a((Context)this.a);
         Arguments.a(this.b);
         Arguments.a(this.c);
         if (this.d == null) {
            this.d = new InternalLiveAgentLoggingRequestFactory();
         }

         if (this.e == null) {
            this.e = new Timer.Builder();
         }

         if (this.f == null) {
            this.f = new LiveAgentQueue.Builder().a(this.a);
         }

         this.e.a(this.b.d());
         return new InternalLiveAgentLoggingSession(this);
      }
   }
}
