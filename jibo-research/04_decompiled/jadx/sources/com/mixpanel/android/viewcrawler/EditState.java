package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class EditState extends UIThreadSet<Activity> {

    /* JADX INFO: renamed from: a */
    private final Handler f12114a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b */
    private final Map<String, List<ViewVisitor>> f12115b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Set<EditBinding> f12116c = new HashSet();

    @Override // com.mixpanel.android.viewcrawler.UIThreadSet
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo12064b(Activity activity) {
        super.mo12064b(activity);
        m12060b();
    }

    @Override // com.mixpanel.android.viewcrawler.UIThreadSet
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo12062a(Activity activity) {
        super.mo12062a(activity);
    }

    /* JADX INFO: renamed from: a */
    public void m12063a(Map<String, List<ViewVisitor>> map) {
        synchronized (this.f12116c) {
            Iterator<EditBinding> it = this.f12116c.iterator();
            while (it.hasNext()) {
                it.next().m12066a();
            }
            this.f12116c.clear();
        }
        synchronized (this.f12115b) {
            this.f12115b.clear();
            this.f12115b.putAll(map);
        }
        m12060b();
    }

    /* JADX INFO: renamed from: b */
    private void m12060b() {
        if (Thread.currentThread() == this.f12114a.getLooper().getThread()) {
            m12061c();
        } else {
            this.f12114a.post(new Runnable() { // from class: com.mixpanel.android.viewcrawler.EditState.1
                @Override // java.lang.Runnable
                public void run() {
                    EditState.this.m12061c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m12061c() {
        List<ViewVisitor> list;
        List<ViewVisitor> list2;
        for (Activity activity : m12099a()) {
            String canonicalName = activity.getClass().getCanonicalName();
            View rootView = activity.getWindow().getDecorView().getRootView();
            synchronized (this.f12115b) {
                list = this.f12115b.get(canonicalName);
                list2 = this.f12115b.get(null);
            }
            if (list != null) {
                m12058a(rootView, list);
            }
            if (list2 != null) {
                m12058a(rootView, list2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m12058a(View view, List<ViewVisitor> list) {
        synchronized (this.f12116c) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.f12116c.add(new EditBinding(view, list.get(i), this.f12114a));
            }
        }
    }

    private static class EditBinding implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {

        /* JADX INFO: renamed from: c */
        private final WeakReference<View> f12120c;

        /* JADX INFO: renamed from: d */
        private final ViewVisitor f12121d;

        /* JADX INFO: renamed from: e */
        private final Handler f12122e;

        /* JADX INFO: renamed from: b */
        private boolean f12119b = true;

        /* JADX INFO: renamed from: a */
        private volatile boolean f12118a = false;

        public EditBinding(View view, ViewVisitor viewVisitor, Handler handler) {
            this.f12121d = viewVisitor;
            this.f12120c = new WeakReference<>(view);
            this.f12122e = handler;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
            }
            run();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            run();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f12119b) {
                View view = this.f12120c.get();
                if (view == null || this.f12118a) {
                    m12065b();
                    return;
                }
                this.f12121d.mo12149b(view);
                this.f12122e.removeCallbacks(this);
                this.f12122e.postDelayed(this, 1000L);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m12066a() {
            this.f12118a = true;
            this.f12122e.post(this);
        }

        /* JADX INFO: renamed from: b */
        private void m12065b() {
            if (this.f12119b) {
                View view = this.f12120c.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
                this.f12121d.mo12147a();
            }
            this.f12119b = false;
        }
    }
}
