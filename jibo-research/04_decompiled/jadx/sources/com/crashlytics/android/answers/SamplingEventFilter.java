package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class SamplingEventFilter implements EventFilter {

    /* JADX INFO: renamed from: b */
    static final Set<SessionEvent.Type> f5066b = new HashSet<SessionEvent.Type>() { // from class: com.crashlytics.android.answers.SamplingEventFilter.1
        {
            add(SessionEvent.Type.START);
            add(SessionEvent.Type.RESUME);
            add(SessionEvent.Type.PAUSE);
            add(SessionEvent.Type.STOP);
        }
    };

    /* JADX INFO: renamed from: a */
    final int f5067a;

    public SamplingEventFilter(int i) {
        this.f5067a = i;
    }

    @Override // com.crashlytics.android.answers.EventFilter
    /* JADX INFO: renamed from: a */
    public boolean mo5654a(SessionEvent sessionEvent) {
        return (f5066b.contains(sessionEvent.f5077c) && sessionEvent.f5075a.f5097g == null) && (Math.abs(sessionEvent.f5075a.f5093c.hashCode() % this.f5067a) != 0);
    }
}
