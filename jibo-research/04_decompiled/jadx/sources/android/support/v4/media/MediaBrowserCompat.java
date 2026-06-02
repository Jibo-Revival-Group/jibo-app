package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi26;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: a */
    static final boolean f1899a = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: b */
    private final MediaBrowserImpl f1900b;

    interface MediaBrowserImpl {
        /* JADX INFO: renamed from: d */
        void mo2046d();

        /* JADX INFO: renamed from: e */
        void mo2047e();

        /* JADX INFO: renamed from: f */
        MediaSessionCompat.Token mo2048f();
    }

    interface MediaBrowserServiceCallbackImpl {
        /* JADX INFO: renamed from: a */
        void mo2049a(Messenger messenger);

        /* JADX INFO: renamed from: a */
        void mo2050a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        /* JADX INFO: renamed from: a */
        void mo2051a(Messenger messenger, String str, List list, Bundle bundle);
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1900b = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1900b = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f1900b = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.f1900b = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2026a() {
        this.f1900b.mo2046d();
    }

    /* JADX INFO: renamed from: b */
    public void m2027b() {
        this.f1900b.mo2047e();
    }

    /* JADX INFO: renamed from: c */
    public MediaSessionCompat.Token m2028c() {
        return this.f1900b.mo2048f();
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* JADX INFO: renamed from: a */
        private final int f1941a;

        /* JADX INFO: renamed from: b */
        private final MediaDescriptionCompat f1942b;

        /* JADX INFO: renamed from: a */
        public static MediaItem m2059a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.m2133a(MediaBrowserCompatApi21.MediaItem.m2092b(obj)), MediaBrowserCompatApi21.MediaItem.m2091a(obj));
        }

        /* JADX INFO: renamed from: a */
        public static List<MediaItem> m2060a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m2059a(it.next()));
            }
            return arrayList;
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.m2134a())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f1941a = i;
            this.f1942b = mediaDescriptionCompat;
        }

        MediaItem(Parcel parcel) {
            this.f1941a = parcel.readInt();
            this.f1942b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1941a);
            this.f1942b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.f1941a);
            sb.append(", mDescription=").append(this.f1942b);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class ConnectionCallback {

        /* JADX INFO: renamed from: a */
        final Object f1903a;

        /* JADX INFO: renamed from: b */
        ConnectionCallbackInternal f1904b;

        interface ConnectionCallbackInternal {
            /* JADX INFO: renamed from: a */
            void mo2034a();

            /* JADX INFO: renamed from: b */
            void mo2035b();

            /* JADX INFO: renamed from: c */
            void mo2036c();
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1903a = MediaBrowserCompatApi21.m2085a((MediaBrowserCompatApi21.ConnectionCallback) new StubApi21());
            } else {
                this.f1903a = null;
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo2030a() {
        }

        /* JADX INFO: renamed from: b */
        public void mo2032b() {
        }

        /* JADX INFO: renamed from: c */
        public void mo2033c() {
        }

        /* JADX INFO: renamed from: a */
        void m2031a(ConnectionCallbackInternal connectionCallbackInternal) {
            this.f1904b = connectionCallbackInternal;
        }

        private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            /* JADX INFO: renamed from: a */
            public void mo2037a() {
                if (ConnectionCallback.this.f1904b != null) {
                    ConnectionCallback.this.f1904b.mo2034a();
                }
                ConnectionCallback.this.mo2030a();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            /* JADX INFO: renamed from: b */
            public void mo2038b() {
                if (ConnectionCallback.this.f1904b != null) {
                    ConnectionCallback.this.f1904b.mo2035b();
                }
                ConnectionCallback.this.mo2032b();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            /* JADX INFO: renamed from: c */
            public void mo2039c() {
                if (ConnectionCallback.this.f1904b != null) {
                    ConnectionCallback.this.f1904b.mo2036c();
                }
                ConnectionCallback.this.mo2033c();
            }
        }
    }

    public static abstract class SubscriptionCallback {

        /* JADX INFO: renamed from: a */
        WeakReference<Subscription> f1950a;

        /* JADX INFO: renamed from: b */
        private final Object f1951b;

        /* JADX INFO: renamed from: c */
        private final IBinder f1952c = new Binder();

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f1951b = MediaBrowserCompatApi26.m2093a(new StubApi26());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f1951b = MediaBrowserCompatApi21.m2086a((MediaBrowserCompatApi21.SubscriptionCallback) new StubApi21());
            } else {
                this.f1951b = null;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m2077a(String str, List<MediaItem> list) {
        }

        /* JADX INFO: renamed from: a */
        public void m2078a(String str, List<MediaItem> list, Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void m2075a(String str) {
        }

        /* JADX INFO: renamed from: a */
        public void m2076a(String str, Bundle bundle) {
        }

        private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            /* JADX INFO: renamed from: a */
            public void mo2081a(String str, List<?> list) {
                Subscription subscription = SubscriptionCallback.this.f1950a == null ? null : SubscriptionCallback.this.f1950a.get();
                if (subscription == null) {
                    SubscriptionCallback.this.m2077a(str, MediaItem.m2060a(list));
                    return;
                }
                List<MediaItem> listM2060a = MediaItem.m2060a(list);
                List<SubscriptionCallback> listM2073b = subscription.m2073b();
                List<Bundle> listM2072a = subscription.m2072a();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < listM2073b.size()) {
                        Bundle bundle = listM2072a.get(i2);
                        if (bundle == null) {
                            SubscriptionCallback.this.m2077a(str, listM2060a);
                        } else {
                            SubscriptionCallback.this.m2078a(str, m2079a(listM2060a, bundle), bundle);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            /* JADX INFO: renamed from: a */
            public void mo2080a(String str) {
                SubscriptionCallback.this.m2075a(str);
            }

            /* JADX INFO: renamed from: a */
            List<MediaItem> m2079a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i != -1 || i2 != -1) {
                    int i3 = i2 * i;
                    int size = i3 + i2;
                    if (i < 0 || i2 < 1 || i3 >= list.size()) {
                        return Collections.EMPTY_LIST;
                    }
                    if (size > list.size()) {
                        size = list.size();
                    }
                    return list.subList(i3, size);
                }
                return list;
            }
        }

        private class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            StubApi26() {
                super();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            /* JADX INFO: renamed from: a */
            public void mo2083a(String str, List<?> list, Bundle bundle) {
                SubscriptionCallback.this.m2078a(str, MediaItem.m2060a(list), bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            /* JADX INFO: renamed from: a */
            public void mo2082a(String str, Bundle bundle) {
                SubscriptionCallback.this.m2076a(str, bundle);
            }
        }
    }

    public static abstract class ItemCallback {
        /* JADX INFO: renamed from: a */
        public void m2044a(MediaItem mediaItem) {
        }

        /* JADX INFO: renamed from: a */
        public void m2045a(String str) {
        }
    }

    public static abstract class SearchCallback {
        /* JADX INFO: renamed from: a */
        public void m2064a(String str, Bundle bundle, List<MediaItem> list) {
        }

        /* JADX INFO: renamed from: a */
        public void m2063a(String str, Bundle bundle) {
        }
    }

    public static abstract class CustomActionCallback {
        /* JADX INFO: renamed from: a */
        public void m2040a(String str, Bundle bundle, Bundle bundle2) {
        }

        /* JADX INFO: renamed from: b */
        public void m2041b(String str, Bundle bundle, Bundle bundle2) {
        }

        /* JADX INFO: renamed from: c */
        public void m2042c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* JADX INFO: renamed from: a */
        final Context f1920a;

        /* JADX INFO: renamed from: b */
        final ComponentName f1921b;

        /* JADX INFO: renamed from: c */
        final ConnectionCallback f1922c;

        /* JADX INFO: renamed from: d */
        final Bundle f1923d;

        /* JADX INFO: renamed from: g */
        MediaServiceConnection f1926g;

        /* JADX INFO: renamed from: h */
        ServiceBinderWrapper f1927h;

        /* JADX INFO: renamed from: i */
        Messenger f1928i;

        /* JADX INFO: renamed from: k */
        private String f1930k;

        /* JADX INFO: renamed from: l */
        private MediaSessionCompat.Token f1931l;

        /* JADX INFO: renamed from: m */
        private Bundle f1932m;

        /* JADX INFO: renamed from: e */
        final CallbackHandler f1924e = new CallbackHandler(this);

        /* JADX INFO: renamed from: j */
        private final ArrayMap<String, Subscription> f1929j = new ArrayMap<>();

        /* JADX INFO: renamed from: f */
        int f1925f = 1;

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.f1920a = context;
            this.f1921b = componentName;
            this.f1922c = connectionCallback;
            this.f1923d = bundle == null ? null : new Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: d */
        public void mo2046d() {
            if (this.f1925f != 0 && this.f1925f != 1) {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + m2052a(this.f1925f) + ")");
            }
            this.f1925f = 2;
            this.f1924e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.f1925f != 0) {
                        MediaBrowserImplBase.this.f1925f = 2;
                        if (MediaBrowserCompat.f1899a && MediaBrowserImplBase.this.f1926g != null) {
                            throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.f1926g);
                        }
                        if (MediaBrowserImplBase.this.f1927h != null) {
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.f1927h);
                        }
                        if (MediaBrowserImplBase.this.f1928i != null) {
                            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.f1928i);
                        }
                        Intent intent = new Intent("android.media.browse.MediaBrowserService");
                        intent.setComponent(MediaBrowserImplBase.this.f1921b);
                        MediaBrowserImplBase.this.f1926g = MediaBrowserImplBase.this.new MediaServiceConnection();
                        boolean zBindService = false;
                        try {
                            zBindService = MediaBrowserImplBase.this.f1920a.bindService(intent, MediaBrowserImplBase.this.f1926g, 1);
                        } catch (Exception e) {
                            Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserImplBase.this.f1921b);
                        }
                        if (!zBindService) {
                            MediaBrowserImplBase.this.m2054a();
                            MediaBrowserImplBase.this.f1922c.mo2033c();
                        }
                        if (MediaBrowserCompat.f1899a) {
                            Log.d("MediaBrowserCompat", "connect...");
                            MediaBrowserImplBase.this.m2056c();
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: e */
        public void mo2047e() {
            this.f1925f = 0;
            this.f1924e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.f1928i != null) {
                        try {
                            MediaBrowserImplBase.this.f1927h.m2067a(MediaBrowserImplBase.this.f1928i);
                        } catch (RemoteException e) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f1921b);
                        }
                    }
                    int i = MediaBrowserImplBase.this.f1925f;
                    MediaBrowserImplBase.this.m2054a();
                    if (i != 0) {
                        MediaBrowserImplBase.this.f1925f = i;
                    }
                    if (MediaBrowserCompat.f1899a) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.m2056c();
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        void m2054a() {
            if (this.f1926g != null) {
                this.f1920a.unbindService(this.f1926g);
            }
            this.f1925f = 1;
            this.f1926g = null;
            this.f1927h = null;
            this.f1928i = null;
            this.f1924e.m2029a(null);
            this.f1930k = null;
            this.f1931l = null;
        }

        /* JADX INFO: renamed from: b */
        public boolean m2055b() {
            return this.f1925f == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: f */
        public MediaSessionCompat.Token mo2048f() {
            if (!m2055b()) {
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f1925f + ")");
            }
            return this.f1931l;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2050a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (m2053a(messenger, "onConnect")) {
                if (this.f1925f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + m2052a(this.f1925f) + "... ignoring");
                    return;
                }
                this.f1930k = str;
                this.f1931l = token;
                this.f1932m = bundle;
                this.f1925f = 3;
                if (MediaBrowserCompat.f1899a) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    m2056c();
                }
                this.f1922c.mo2030a();
                try {
                    for (Map.Entry<String, Subscription> entry : this.f1929j.entrySet()) {
                        String key = entry.getKey();
                        Subscription value = entry.getValue();
                        List<SubscriptionCallback> listM2073b = value.m2073b();
                        List<Bundle> listM2072a = value.m2072a();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < listM2073b.size()) {
                                this.f1927h.m2068a(key, listM2073b.get(i2).f1952c, listM2072a.get(i2), this.f1928i);
                                i = i2 + 1;
                            }
                        }
                    }
                } catch (RemoteException e) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2049a(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f1921b);
            if (m2053a(messenger, "onConnectFailed")) {
                if (this.f1925f != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + m2052a(this.f1925f) + "... ignoring");
                } else {
                    m2054a();
                    this.f1922c.mo2033c();
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2051a(Messenger messenger, String str, List list, Bundle bundle) {
            if (m2053a(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.f1899a) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f1921b + " id=" + str);
                }
                Subscription subscription = this.f1929j.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.f1899a) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback subscriptionCallbackM2071a = subscription.m2071a(this.f1920a, bundle);
                if (subscriptionCallbackM2071a != null) {
                    if (bundle == null) {
                        if (list == null) {
                            subscriptionCallbackM2071a.m2075a(str);
                            return;
                        } else {
                            subscriptionCallbackM2071a.m2077a(str, (List<MediaItem>) list);
                            return;
                        }
                    }
                    if (list == null) {
                        subscriptionCallbackM2071a.m2076a(str, bundle);
                    } else {
                        subscriptionCallbackM2071a.m2078a(str, list, bundle);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static String m2052a(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + i;
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m2053a(Messenger messenger, String str) {
            if (this.f1928i == messenger && this.f1925f != 0 && this.f1925f != 1) {
                return true;
            }
            if (this.f1925f != 0 && this.f1925f != 1) {
                Log.i("MediaBrowserCompat", str + " for " + this.f1921b + " with mCallbacksMessenger=" + this.f1928i + " this=" + this);
            }
            return false;
        }

        /* JADX INFO: renamed from: c */
        void m2056c() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f1921b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f1922c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f1923d);
            Log.d("MediaBrowserCompat", "  mState=" + m2052a(this.f1925f));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f1926g);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f1927h);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f1928i);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f1930k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f1931l);
        }

        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                m2057a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f1899a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            MediaBrowserImplBase.this.m2056c();
                        }
                        if (MediaServiceConnection.this.m2058a("onServiceConnected")) {
                            MediaBrowserImplBase.this.f1927h = new ServiceBinderWrapper(iBinder, MediaBrowserImplBase.this.f1923d);
                            MediaBrowserImplBase.this.f1928i = new Messenger(MediaBrowserImplBase.this.f1924e);
                            MediaBrowserImplBase.this.f1924e.m2029a(MediaBrowserImplBase.this.f1928i);
                            MediaBrowserImplBase.this.f1925f = 2;
                            try {
                                if (MediaBrowserCompat.f1899a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.m2056c();
                                }
                                MediaBrowserImplBase.this.f1927h.m2066a(MediaBrowserImplBase.this.f1920a, MediaBrowserImplBase.this.f1928i);
                            } catch (RemoteException e) {
                                Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f1921b);
                                if (MediaBrowserCompat.f1899a) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.m2056c();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                m2057a(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f1899a) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.f1926g);
                            MediaBrowserImplBase.this.m2056c();
                        }
                        if (MediaServiceConnection.this.m2058a("onServiceDisconnected")) {
                            MediaBrowserImplBase.this.f1927h = null;
                            MediaBrowserImplBase.this.f1928i = null;
                            MediaBrowserImplBase.this.f1924e.m2029a(null);
                            MediaBrowserImplBase.this.f1925f = 4;
                            MediaBrowserImplBase.this.f1922c.mo2032b();
                        }
                    }
                });
            }

            /* JADX INFO: renamed from: a */
            private void m2057a(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.f1924e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.f1924e.post(runnable);
                }
            }

            /* JADX INFO: renamed from: a */
            boolean m2058a(String str) {
                if (MediaBrowserImplBase.this.f1926g == this && MediaBrowserImplBase.this.f1925f != 0 && MediaBrowserImplBase.this.f1925f != 1) {
                    return true;
                }
                if (MediaBrowserImplBase.this.f1925f != 0 && MediaBrowserImplBase.this.f1925f != 1) {
                    Log.i("MediaBrowserCompat", str + " for " + MediaBrowserImplBase.this.f1921b + " with mServiceConnection=" + MediaBrowserImplBase.this.f1926g + " this=" + this);
                }
                return false;
            }
        }
    }

    static class MediaBrowserImplApi21 implements ConnectionCallback.ConnectionCallbackInternal, MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* JADX INFO: renamed from: a */
        final Context f1911a;

        /* JADX INFO: renamed from: b */
        protected final Object f1912b;

        /* JADX INFO: renamed from: c */
        protected final Bundle f1913c;

        /* JADX INFO: renamed from: e */
        protected int f1915e;

        /* JADX INFO: renamed from: f */
        protected ServiceBinderWrapper f1916f;

        /* JADX INFO: renamed from: g */
        protected Messenger f1917g;

        /* JADX INFO: renamed from: i */
        private MediaSessionCompat.Token f1919i;

        /* JADX INFO: renamed from: d */
        protected final CallbackHandler f1914d = new CallbackHandler(this);

        /* JADX INFO: renamed from: h */
        private final ArrayMap<String, Subscription> f1918h = new ArrayMap<>();

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.f1911a = context;
            bundle = bundle == null ? new Bundle() : bundle;
            bundle.putInt("extra_client_version", 1);
            this.f1913c = new Bundle(bundle);
            connectionCallback.m2031a(this);
            this.f1912b = MediaBrowserCompatApi21.m2084a(context, componentName, connectionCallback.f1903a, this.f1913c);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: d */
        public void mo2046d() {
            MediaBrowserCompatApi21.m2087a(this.f1912b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: e */
        public void mo2047e() {
            if (this.f1916f != null && this.f1917g != null) {
                try {
                    this.f1916f.m2070c(this.f1917g);
                } catch (RemoteException e) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            MediaBrowserCompatApi21.m2088b(this.f1912b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        /* JADX INFO: renamed from: f */
        public MediaSessionCompat.Token mo2048f() {
            if (this.f1919i == null) {
                this.f1919i = MediaSessionCompat.Token.m2282a(MediaBrowserCompatApi21.m2090d(this.f1912b));
            }
            return this.f1919i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        /* JADX INFO: renamed from: a */
        public void mo2034a() {
            Bundle bundleM2089c = MediaBrowserCompatApi21.m2089c(this.f1912b);
            if (bundleM2089c != null) {
                this.f1915e = bundleM2089c.getInt("extra_service_version", 0);
                IBinder iBinderM1396a = BundleCompat.m1396a(bundleM2089c, "extra_messenger");
                if (iBinderM1396a != null) {
                    this.f1916f = new ServiceBinderWrapper(iBinderM1396a, this.f1913c);
                    this.f1917g = new Messenger(this.f1914d);
                    this.f1914d.m2029a(this.f1917g);
                    try {
                        this.f1916f.m2069b(this.f1917g);
                    } catch (RemoteException e) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IMediaSession iMediaSessionM2236a = IMediaSession.Stub.m2236a(BundleCompat.m1396a(bundleM2089c, "extra_session_binder"));
                if (iMediaSessionM2236a != null) {
                    this.f1919i = MediaSessionCompat.Token.m2283a(MediaBrowserCompatApi21.m2090d(this.f1912b), iMediaSessionM2236a);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        /* JADX INFO: renamed from: b */
        public void mo2035b() {
            this.f1916f = null;
            this.f1917g = null;
            this.f1919i = null;
            this.f1914d.m2029a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        /* JADX INFO: renamed from: c */
        public void mo2036c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2050a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2049a(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        /* JADX INFO: renamed from: a */
        public void mo2051a(Messenger messenger, String str, List list, Bundle bundle) {
            if (this.f1917g == messenger) {
                Subscription subscription = this.f1918h.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.f1899a) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback subscriptionCallbackM2071a = subscription.m2071a(this.f1911a, bundle);
                if (subscriptionCallbackM2071a != null) {
                    if (bundle == null) {
                        if (list == null) {
                            subscriptionCallbackM2071a.m2075a(str);
                            return;
                        } else {
                            subscriptionCallbackM2071a.m2077a(str, (List<MediaItem>) list);
                            return;
                        }
                    }
                    if (list == null) {
                        subscriptionCallbackM2071a.m2076a(str, bundle);
                    } else {
                        subscriptionCallbackM2071a.m2078a(str, list, bundle);
                    }
                }
            }
        }
    }

    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    private static class Subscription {

        /* JADX INFO: renamed from: a */
        private final List<SubscriptionCallback> f1948a = new ArrayList();

        /* JADX INFO: renamed from: b */
        private final List<Bundle> f1949b = new ArrayList();

        /* JADX INFO: renamed from: a */
        public List<Bundle> m2072a() {
            return this.f1949b;
        }

        /* JADX INFO: renamed from: b */
        public List<SubscriptionCallback> m2073b() {
            return this.f1948a;
        }

        /* JADX INFO: renamed from: a */
        public SubscriptionCallback m2071a(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1949b.size()) {
                    if (!MediaBrowserCompatUtils.m2094a(this.f1949b.get(i2), bundle)) {
                        i = i2 + 1;
                    } else {
                        return this.f1948a.get(i2);
                    }
                } else {
                    return null;
                }
            }
        }
    }

    private static class CallbackHandler extends Handler {

        /* JADX INFO: renamed from: a */
        private final WeakReference<MediaBrowserServiceCallbackImpl> f1901a;

        /* JADX INFO: renamed from: b */
        private WeakReference<Messenger> f1902b;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.f1901a = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f1902b != null && this.f1902b.get() != null && this.f1901a.get() != null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaSessionCompat.class.getClassLoader());
                MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.f1901a.get();
                Messenger messenger = this.f1902b.get();
                try {
                    switch (message.what) {
                        case 1:
                            mediaBrowserServiceCallbackImpl.mo2050a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), data.getBundle("data_root_hints"));
                            break;
                        case 2:
                            mediaBrowserServiceCallbackImpl.mo2049a(messenger);
                            break;
                        case 3:
                            mediaBrowserServiceCallbackImpl.mo2051a(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), data.getBundle("data_options"));
                            break;
                        default:
                            Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            break;
                    }
                } catch (BadParcelableException e) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        mediaBrowserServiceCallbackImpl.mo2049a(messenger);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m2029a(Messenger messenger) {
            this.f1902b = new WeakReference<>(messenger);
        }
    }

    private static class ServiceBinderWrapper {

        /* JADX INFO: renamed from: a */
        private Messenger f1946a;

        /* JADX INFO: renamed from: b */
        private Bundle f1947b;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.f1946a = new Messenger(iBinder);
            this.f1947b = bundle;
        }

        /* JADX INFO: renamed from: a */
        void m2066a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f1947b);
            m2065a(1, bundle, messenger);
        }

        /* JADX INFO: renamed from: a */
        void m2067a(Messenger messenger) throws RemoteException {
            m2065a(2, null, messenger);
        }

        /* JADX INFO: renamed from: a */
        void m2068a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            BundleCompat.m1397a(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            m2065a(3, bundle2, messenger);
        }

        /* JADX INFO: renamed from: b */
        void m2069b(Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putBundle("data_root_hints", this.f1947b);
            m2065a(6, bundle, messenger);
        }

        /* JADX INFO: renamed from: c */
        void m2070c(Messenger messenger) throws RemoteException {
            m2065a(7, null, messenger);
        }

        /* JADX INFO: renamed from: a */
        private void m2065a(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f1946a.send(messageObtain);
        }
    }

    private static class ItemReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d */
        private final String f1909d;

        /* JADX INFO: renamed from: e */
        private final ItemCallback f1910e;

        @Override // android.support.v4.os.ResultReceiver
        /* JADX INFO: renamed from: a */
        protected void mo2043a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f1910e.m2045a(this.f1909d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f1910e.m2044a((MediaItem) parcelable);
            } else {
                this.f1910e.m2045a(this.f1909d);
            }
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d */
        private final String f1943d;

        /* JADX INFO: renamed from: e */
        private final Bundle f1944e;

        /* JADX INFO: renamed from: f */
        private final SearchCallback f1945f;

        @Override // android.support.v4.os.ResultReceiver
        /* JADX INFO: renamed from: a */
        protected void mo2043a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f1945f.m2063a(this.f1943d, this.f1944e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList2.add((MediaItem) parcelable);
                }
                arrayList = arrayList2;
            }
            this.f1945f.m2064a(this.f1943d, this.f1944e, arrayList);
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d */
        private final String f1906d;

        /* JADX INFO: renamed from: e */
        private final Bundle f1907e;

        /* JADX INFO: renamed from: f */
        private final CustomActionCallback f1908f;

        @Override // android.support.v4.os.ResultReceiver
        /* JADX INFO: renamed from: a */
        protected void mo2043a(int i, Bundle bundle) {
            if (this.f1908f != null) {
                switch (i) {
                    case -1:
                        this.f1908f.m2042c(this.f1906d, this.f1907e, bundle);
                        break;
                    case 0:
                        this.f1908f.m2041b(this.f1906d, this.f1907e, bundle);
                        break;
                    case 1:
                        this.f1908f.m2040a(this.f1906d, this.f1907e, bundle);
                        break;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f1907e + ", resultData=" + bundle + ")");
                        break;
                }
            }
        }
    }
}
