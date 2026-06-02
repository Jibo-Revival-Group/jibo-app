package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
class SharedPreferencesLoader {

    /* JADX INFO: renamed from: a */
    private final Executor f12016a = Executors.newSingleThreadExecutor();

    interface OnPrefsLoadedListener {
        /* JADX INFO: renamed from: a */
        void mo11853a(SharedPreferences sharedPreferences);
    }

    /* JADX INFO: renamed from: a */
    public Future<SharedPreferences> m11930a(Context context, String str, OnPrefsLoadedListener onPrefsLoadedListener) {
        FutureTask futureTask = new FutureTask(new LoadSharedPreferences(context, str, onPrefsLoadedListener));
        this.f12016a.execute(futureTask);
        return futureTask;
    }

    private static class LoadSharedPreferences implements Callable<SharedPreferences> {

        /* JADX INFO: renamed from: a */
        private final Context f12017a;

        /* JADX INFO: renamed from: b */
        private final String f12018b;

        /* JADX INFO: renamed from: c */
        private final OnPrefsLoadedListener f12019c;

        public LoadSharedPreferences(Context context, String str, OnPrefsLoadedListener onPrefsLoadedListener) {
            this.f12017a = context;
            this.f12018b = str;
            this.f12019c = onPrefsLoadedListener;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f12017a.getSharedPreferences(this.f12018b, 0);
            if (this.f12019c != null) {
                this.f12019c.mo11853a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }
}
