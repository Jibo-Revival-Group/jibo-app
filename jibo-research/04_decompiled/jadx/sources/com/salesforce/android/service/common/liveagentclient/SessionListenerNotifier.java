package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SessionListenerNotifier implements MessagesListener, SessionListener {

    /* JADX INFO: renamed from: a */
    Set<SessionListener> f13512a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: b */
    Set<MessagesListener> f13513b = Collections.newSetFromMap(new ConcurrentHashMap());

    SessionListenerNotifier() {
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13819a(SessionInfo sessionInfo) {
        Iterator<SessionListener> it = this.f13512a.iterator();
        while (it.hasNext()) {
            it.next().mo13819a(sessionInfo);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        Iterator<SessionListener> it = this.f13512a.iterator();
        while (it.hasNext()) {
            it.next().mo13820a(liveAgentState, liveAgentState2);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13821a(Throwable th) {
        Iterator<SessionListener> it = this.f13512a.iterator();
        while (it.hasNext()) {
            it.next().mo13821a(th);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.MessagesListener
    /* JADX INFO: renamed from: a */
    public void mo13814a(MessagesResponse messagesResponse) {
        Iterator<MessagesListener> it = this.f13513b.iterator();
        while (it.hasNext()) {
            it.next().mo13814a(messagesResponse);
        }
    }

    /* JADX INFO: renamed from: a */
    public SessionListenerNotifier m13822a(SessionListener sessionListener) {
        this.f13512a.add(sessionListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public SessionListenerNotifier m13823b(SessionListener sessionListener) {
        this.f13512a.remove(sessionListener);
        return this;
    }
}
