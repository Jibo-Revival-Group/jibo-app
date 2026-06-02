package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi21 {

    interface ConnectionCallback {
        /* JADX INFO: renamed from: a */
        void mo2037a();

        /* JADX INFO: renamed from: b */
        void mo2038b();

        /* JADX INFO: renamed from: c */
        void mo2039c();
    }

    interface SubscriptionCallback {
        /* JADX INFO: renamed from: a */
        void mo2080a(String str);

        /* JADX INFO: renamed from: a */
        void mo2081a(String str, List<?> list);
    }

    /* JADX INFO: renamed from: a */
    public static Object m2085a(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    /* JADX INFO: renamed from: a */
    public static Object m2084a(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    /* JADX INFO: renamed from: a */
    public static void m2087a(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    /* JADX INFO: renamed from: b */
    public static void m2088b(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    /* JADX INFO: renamed from: c */
    public static Bundle m2089c(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    /* JADX INFO: renamed from: d */
    public static Object m2090d(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    /* JADX INFO: renamed from: a */
    public static Object m2086a(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {

        /* JADX INFO: renamed from: a */
        protected final T f1955a;

        public ConnectionCallbackProxy(T t) {
            this.f1955a = t;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f1955a.mo2037a();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f1955a.mo2038b();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f1955a.mo2039c();
        }
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {

        /* JADX INFO: renamed from: a */
        protected final T f1956a;

        public SubscriptionCallbackProxy(T t) {
            this.f1956a = t;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.f1956a.mo2081a(str, list);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.f1956a.mo2080a(str);
        }
    }

    static class MediaItem {
        /* JADX INFO: renamed from: a */
        public static int m2091a(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        /* JADX INFO: renamed from: b */
        public static Object m2092b(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }
    }
}
