package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SessionListenerNotifier implements MessagesListener, SessionListener {
   Set<SessionListener> a = Collections.newSetFromMap(new ConcurrentHashMap<>());
   Set<MessagesListener> b = Collections.newSetFromMap(new ConcurrentHashMap<>());

   SessionListenerNotifier() {
   }

   public SessionListenerNotifier a(SessionListener var1) {
      this.a.add(var1);
      return this;
   }

   @Override
   public void a(SessionInfo var1) {
      Iterator var2 = this.a.iterator();

      while (var2.hasNext()) {
         ((SessionListener)var2.next()).a(var1);
      }
   }

   @Override
   public void a(LiveAgentState var1, LiveAgentState var2) {
      Iterator var3 = this.a.iterator();

      while (var3.hasNext()) {
         ((SessionListener)var3.next()).a(var1, var2);
      }
   }

   @Override
   public void a(MessagesResponse var1) {
      Iterator var2 = this.b.iterator();

      while (var2.hasNext()) {
         ((MessagesListener)var2.next()).a(var1);
      }
   }

   @Override
   public void a(Throwable var1) {
      Iterator var2 = this.a.iterator();

      while (var2.hasNext()) {
         ((SessionListener)var2.next()).a(var1);
      }
   }

   public SessionListenerNotifier b(SessionListener var1) {
      this.a.remove(var1);
      return this;
   }
}
