package com.salesforce.androidsdk.util;

import android.database.Observable;
import com.salesforce.androidsdk.util.test.EventsObserver;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class EventsObservable extends Observable<EventsObserver> {

    /* JADX INFO: renamed from: a */
    private static final EventsObservable f14460a = new EventsObservable();

    public enum EventType {
        AppCreateComplete,
        AppLocked,
        AppUnlocked,
        LoginActivityCreateComplete,
        MainActivityCreateComplete,
        AuthWebViewCreateComplete,
        AuthWebViewPageFinished,
        GapWebViewCreateComplete,
        GapWebViewPageFinished,
        LogoutComplete,
        RenditionComplete,
        Other
    }

    public static class Event {

        /* JADX INFO: renamed from: a */
        private EventType f14461a;

        /* JADX INFO: renamed from: b */
        private Object f14462b;

        public Event(EventType eventType, Object obj) {
            this.f14461a = eventType;
            this.f14462b = obj;
        }
    }

    /* JADX INFO: renamed from: a */
    public static EventsObservable m15006a() {
        return f14460a;
    }

    /* JADX INFO: renamed from: a */
    public void m15008a(EventType eventType) {
        m15009a(eventType, null);
    }

    /* JADX INFO: renamed from: a */
    public void m15009a(EventType eventType, Object obj) {
        m15007a(new Event(eventType, obj));
    }

    /* JADX INFO: renamed from: a */
    private void m15007a(Event event) {
        synchronized (this.mObservers) {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                ((EventsObserver) it.next()).m15023a(event);
            }
        }
    }
}
