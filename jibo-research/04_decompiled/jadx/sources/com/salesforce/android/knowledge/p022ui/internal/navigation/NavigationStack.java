package com.salesforce.android.knowledge.p022ui.internal.navigation;

import android.os.Bundle;
import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.internal.presenter.Presenter;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
class NavigationStack extends LinkedBlockingDeque<Entry> {
    NavigationStack() {
    }

    /* JADX INFO: renamed from: a */
    void m13626a(KnowledgeScene knowledgeScene) {
        Iterator<Entry> itDescendingIterator = descendingIterator();
        while (itDescendingIterator.hasNext()) {
            Entry next = itDescendingIterator.next();
            if (next.m13631b() == knowledgeScene) {
                next.m13630a().mo13444c();
                itDescendingIterator.remove();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    KnowledgeScene m13625a() {
        return isEmpty() ? KnowledgeScene.SCENE_NONE : peek().m13631b();
    }

    /* JADX INFO: renamed from: b */
    Entry m13628b() {
        Iterator it = super.iterator();
        if (it.hasNext()) {
            it.next();
            if (it.hasNext()) {
                return (Entry) it.next();
            }
        }
        return null;
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.Deque
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void push(Entry entry) {
        super.push(entry);
        entry.m13630a().mo13441b();
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Deque
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Entry pop() {
        Entry entry = (Entry) super.pop();
        entry.m13630a().mo13444c();
        return entry;
    }

    static class Entry {

        /* JADX INFO: renamed from: a */
        private final KnowledgeScene f13370a;

        /* JADX INFO: renamed from: b */
        private final Presenter<?> f13371b;

        /* JADX INFO: renamed from: c */
        private final Bundle f13372c = new Bundle();

        Entry(KnowledgeScene knowledgeScene, Presenter<?> presenter) {
            this.f13370a = knowledgeScene;
            this.f13371b = presenter;
        }

        /* JADX INFO: renamed from: a */
        Presenter<?> m13630a() {
            return this.f13371b;
        }

        /* JADX INFO: renamed from: b */
        KnowledgeScene m13631b() {
            return this.f13370a;
        }

        /* JADX INFO: renamed from: c */
        Bundle m13632c() {
            return this.f13372c;
        }
    }
}
