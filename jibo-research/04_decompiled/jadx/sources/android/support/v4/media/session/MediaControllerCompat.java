package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a */
    private final MediaControllerImpl f2056a;

    /* JADX INFO: renamed from: b */
    private final MediaSessionCompat.Token f2057b;

    /* JADX INFO: renamed from: c */
    private final HashSet<Callback> f2058c = new HashSet<>();

    interface MediaControllerImpl {
        /* JADX INFO: renamed from: a */
        boolean mo2263a(KeyEvent keyEvent);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f2057b = token;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2056a = new MediaControllerImplApi24(context, token);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f2056a = new MediaControllerImplApi23(context, token);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f2056a = new MediaControllerImplApi21(context, token);
        } else {
            this.f2056a = new MediaControllerImplBase(this.f2057b);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2241a(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.f2056a.mo2263a(keyEvent);
    }

    public static abstract class Callback implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a */
        MessageHandler f2059a;

        /* JADX INFO: renamed from: b */
        boolean f2060b;

        /* JADX INFO: renamed from: c */
        private final Object f2061c;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f2061c = MediaControllerCompatApi21.m2270a(new StubApi21(this));
            } else {
                this.f2061c = new StubCompat(this);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m2242a() {
        }

        /* JADX INFO: renamed from: b */
        public void m2253b() {
        }

        /* JADX INFO: renamed from: a */
        public void m2250a(String str, Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void m2248a(PlaybackStateCompat playbackStateCompat) {
        }

        /* JADX INFO: renamed from: a */
        public void m2246a(MediaMetadataCompat mediaMetadataCompat) {
        }

        /* JADX INFO: renamed from: a */
        public void m2251a(List<MediaSessionCompat.QueueItem> list) {
        }

        /* JADX INFO: renamed from: a */
        public void m2249a(CharSequence charSequence) {
        }

        /* JADX INFO: renamed from: a */
        public void m2245a(Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void m2247a(PlaybackInfo playbackInfo) {
        }

        /* JADX INFO: renamed from: a */
        public void m2252a(boolean z) {
        }

        /* JADX INFO: renamed from: a */
        public void m2243a(int i) {
        }

        /* JADX INFO: renamed from: b */
        public void m2254b(int i) {
        }

        /* JADX INFO: renamed from: a */
        void m2244a(int i, Object obj, Bundle bundle) {
            if (this.f2059a != null) {
                Message messageObtainMessage = this.f2059a.obtainMessage(i, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        private static class StubApi21 implements MediaControllerCompatApi21.Callback {

            /* JADX INFO: renamed from: a */
            private final WeakReference<Callback> f2064a;

            StubApi21(Callback callback) {
                this.f2064a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2255a() {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2253b();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2260a(String str, Bundle bundle) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    if (!callback.f2060b || Build.VERSION.SDK_INT >= 23) {
                        callback.m2250a(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2259a(Object obj) {
                Callback callback = this.f2064a.get();
                if (callback != null && !callback.f2060b) {
                    callback.m2248a(PlaybackStateCompat.m2293a(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: b */
            public void mo2262b(Object obj) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2246a(MediaMetadataCompat.m2167a(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2261a(List<?> list) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2251a(MediaSessionCompat.QueueItem.m2277a(list));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2258a(CharSequence charSequence) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2249a(charSequence);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2257a(Bundle bundle) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2245a(bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            /* JADX INFO: renamed from: a */
            public void mo2256a(int i, int i2, int i3, int i4, int i5) {
                Callback callback = this.f2064a.get();
                if (callback != null) {
                    callback.m2247a(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }
        }

        private static class StubCompat extends IMediaControllerCallback.Stub {

            /* JADX INFO: renamed from: a */
            private final WeakReference<Callback> f2065a;

            StubCompat(Callback callback) {
                this.f2065a = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2180a(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2173a() throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2178a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2176a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2181a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2179a(CharSequence charSequence) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: b */
            public void mo2185b(boolean z) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2174a(int i) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2182a(boolean z) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: b */
            public void mo2184b(int i) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2175a(Bundle bundle) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2177a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.f2084a, parcelableVolumeInfo.f2085b, parcelableVolumeInfo.f2086c, parcelableVolumeInfo.f2087d, parcelableVolumeInfo.f2088e) : null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: b */
            public void mo2183b() throws RemoteException {
                Callback callback = this.f2065a.get();
                if (callback != null) {
                    callback.m2244a(13, null, null);
                }
            }
        }

        private class MessageHandler extends Handler {

            /* JADX INFO: renamed from: a */
            boolean f2062a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Callback f2063b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f2062a) {
                    switch (message.what) {
                        case 1:
                            this.f2063b.m2250a((String) message.obj, message.getData());
                            break;
                        case 2:
                            this.f2063b.m2248a((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            this.f2063b.m2246a((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            this.f2063b.m2247a((PlaybackInfo) message.obj);
                            break;
                        case 5:
                            this.f2063b.m2251a((List<MediaSessionCompat.QueueItem>) message.obj);
                            break;
                        case 6:
                            this.f2063b.m2249a((CharSequence) message.obj);
                            break;
                        case 7:
                            this.f2063b.m2245a((Bundle) message.obj);
                            break;
                        case 8:
                            this.f2063b.m2253b();
                            break;
                        case 9:
                            this.f2063b.m2243a(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            this.f2063b.m2252a(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            this.f2063b.m2254b(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            this.f2063b.m2242a();
                            break;
                    }
                }
            }
        }
    }

    public static final class PlaybackInfo {

        /* JADX INFO: renamed from: a */
        private final int f2072a;

        /* JADX INFO: renamed from: b */
        private final int f2073b;

        /* JADX INFO: renamed from: c */
        private final int f2074c;

        /* JADX INFO: renamed from: d */
        private final int f2075d;

        /* JADX INFO: renamed from: e */
        private final int f2076e;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.f2072a = i;
            this.f2073b = i2;
            this.f2074c = i3;
            this.f2075d = i4;
            this.f2076e = i5;
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {

        /* JADX INFO: renamed from: a */
        private IMediaSession f2071a;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.f2071a = IMediaSession.Stub.m2236a((IBinder) token.m2284a());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2263a(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f2071a.mo2200a(keyEvent);
                return false;
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
                return false;
            }
        }
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* JADX INFO: renamed from: a */
        protected final Object f2066a;

        /* JADX INFO: renamed from: c */
        private IMediaSession f2068c;

        /* JADX INFO: renamed from: b */
        private final List<Callback> f2067b = new ArrayList();

        /* JADX INFO: renamed from: d */
        private HashMap<Callback, ExtraCallback> f2069d = new HashMap<>();

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f2066a = MediaControllerCompatApi21.m2269a(context, token.m2284a());
            if (this.f2066a == null) {
                throw new RemoteException();
            }
            this.f2068c = token.m2285b();
            if (this.f2068c == null) {
                m2265a();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2263a(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.m2272a(this.f2066a, keyEvent);
        }

        /* JADX INFO: renamed from: a */
        public void m2268a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.m2271a(this.f2066a, str, bundle, resultReceiver);
        }

        /* JADX INFO: renamed from: a */
        private void m2265a() {
            m2268a("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: b */
        public void m2267b() {
            if (this.f2068c != null) {
                synchronized (this.f2067b) {
                    for (Callback callback : this.f2067b) {
                        ExtraCallback extraCallback = new ExtraCallback(callback);
                        this.f2069d.put(callback, extraCallback);
                        callback.f2060b = true;
                        try {
                            this.f2068c.mo2195a(extraCallback);
                            callback.m2242a();
                        } catch (RemoteException e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                            this.f2067b.clear();
                        }
                    }
                    this.f2067b.clear();
                }
            }
        }

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: a */
            private WeakReference<MediaControllerImplApi21> f2070a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.f2070a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f2070a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.f2068c = IMediaSession.Stub.m2236a(BundleCompat.m1396a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.m2267b();
                }
            }
        }

        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2173a() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2176a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2181a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2179a(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2175a(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            /* JADX INFO: renamed from: a */
            public void mo2177a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }
}
