package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: a */
    static final boolean f1957a = Log.isLoggable("MBServiceCompat", 3);

    /* JADX INFO: renamed from: c */
    ConnectionRecord f1959c;

    /* JADX INFO: renamed from: e */
    MediaSessionCompat.Token f1961e;

    /* JADX INFO: renamed from: b */
    final ArrayMap<IBinder, ConnectionRecord> f1958b = new ArrayMap<>();

    /* JADX INFO: renamed from: d */
    final ServiceHandler f1960d = new ServiceHandler();

    private interface ServiceCallbacks {
        /* JADX INFO: renamed from: a */
        IBinder mo2127a();

        /* JADX INFO: renamed from: a */
        void mo2128a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        /* JADX INFO: renamed from: a */
        void mo2129a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException;

        /* JADX INFO: renamed from: b */
        void mo2130b() throws RemoteException;
    }

    /* JADX INFO: renamed from: a */
    public abstract BrowserRoot m2095a(String str, int i, Bundle bundle);

    /* JADX INFO: renamed from: a */
    public abstract void m2102a(String str, Result<List<MediaBrowserCompat.MediaItem>> result);

    private final class ServiceHandler extends Handler {

        /* JADX INFO: renamed from: b */
        private final ServiceBinderImpl f2024b;

        ServiceHandler() {
            this.f2024b = MediaBrowserServiceCompat.this.new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.f2024b.m2120a(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.f2024b.m2118a(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    this.f2024b.m2122a(data.getString("data_media_item_id"), BundleCompat.m1396a(data, "data_callback_token"), data.getBundle("data_options"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.f2024b.m2123a(data.getString("data_media_item_id"), BundleCompat.m1396a(data, "data_callback_token"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.f2024b.m2124a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    this.f2024b.m2119a(new ServiceCallbacksCompat(message.replyTo), data.getBundle("data_root_hints"));
                    break;
                case 7:
                    this.f2024b.m2125b(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    this.f2024b.m2121a(data.getString("data_search_query"), data.getBundle("data_search_extras"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    this.f2024b.m2126b(data.getString("data_custom_action"), data.getBundle("data_custom_action_extras"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        /* JADX INFO: renamed from: a */
        public void m2132a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a */
        String f1974a;

        /* JADX INFO: renamed from: b */
        Bundle f1975b;

        /* JADX INFO: renamed from: c */
        ServiceCallbacks f1976c;

        /* JADX INFO: renamed from: d */
        BrowserRoot f1977d;

        /* JADX INFO: renamed from: e */
        HashMap<String, List<Pair<IBinder, Bundle>>> f1978e = new HashMap<>();

        ConnectionRecord() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f1960d.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceCompat.this.f1958b.remove(ConnectionRecord.this.f1976c.mo2127a());
                }
            });
        }
    }

    public static class Result<T> {

        /* JADX INFO: renamed from: a */
        private final Object f1981a;

        /* JADX INFO: renamed from: b */
        private boolean f1982b;

        /* JADX INFO: renamed from: c */
        private boolean f1983c;

        /* JADX INFO: renamed from: d */
        private boolean f1984d;

        /* JADX INFO: renamed from: e */
        private int f1985e;

        Result(Object obj) {
            this.f1981a = obj;
        }

        /* JADX INFO: renamed from: b */
        public void m2116b(T t) {
            if (this.f1983c || this.f1984d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f1981a);
            }
            this.f1983c = true;
            mo2109a(t);
        }

        /* JADX INFO: renamed from: c */
        public void m2117c(Bundle bundle) {
            if (this.f1983c || this.f1984d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f1981a);
            }
            this.f1984d = true;
            mo2110b(bundle);
        }

        /* JADX INFO: renamed from: a */
        boolean m2114a() {
            return this.f1982b || this.f1983c || this.f1984d;
        }

        /* JADX INFO: renamed from: a */
        void m2113a(int i) {
            this.f1985e = i;
        }

        /* JADX INFO: renamed from: b */
        int m2115b() {
            return this.f1985e;
        }

        /* JADX INFO: renamed from: a */
        void mo2109a(T t) {
        }

        /* JADX INFO: renamed from: b */
        void mo2110b(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f1981a);
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void m2120a(final String str, final int i, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            if (!MediaBrowserServiceCompat.this.m2104a(str, i)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
            }
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderMo2127a = serviceCallbacks.mo2127a();
                    MediaBrowserServiceCompat.this.f1958b.remove(iBinderMo2127a);
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord();
                    connectionRecord.f1974a = str;
                    connectionRecord.f1975b = bundle;
                    connectionRecord.f1976c = serviceCallbacks;
                    connectionRecord.f1977d = MediaBrowserServiceCompat.this.m2095a(str, i, bundle);
                    if (connectionRecord.f1977d == null) {
                        Log.i("MBServiceCompat", "No root for client " + str + " from service " + getClass().getName());
                        try {
                            serviceCallbacks.mo2130b();
                            return;
                        } catch (RemoteException e) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                            return;
                        }
                    }
                    try {
                        MediaBrowserServiceCompat.this.f1958b.put(iBinderMo2127a, connectionRecord);
                        iBinderMo2127a.linkToDeath(connectionRecord, 0);
                        if (MediaBrowserServiceCompat.this.f1961e != null) {
                            serviceCallbacks.mo2128a(connectionRecord.f1977d.m2111a(), MediaBrowserServiceCompat.this.f1961e, connectionRecord.f1977d.m2112b());
                        }
                    } catch (RemoteException e2) {
                        Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                        MediaBrowserServiceCompat.this.f1958b.remove(iBinderMo2127a);
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m2118a(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.f1958b.remove(serviceCallbacks.mo2127a());
                    if (connectionRecordRemove != null) {
                        connectionRecordRemove.f1976c.mo2127a().unlinkToDeath(connectionRecordRemove, 0);
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m2122a(final String str, final IBinder iBinder, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f1958b.get(serviceCallbacks.mo2127a());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    } else {
                        MediaBrowserServiceCompat.this.m2100a(str, connectionRecord, iBinder, bundle);
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m2123a(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f1958b.get(serviceCallbacks.mo2127a());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.m2105a(str, connectionRecord, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m2124a(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f1958b.get(serviceCallbacks.mo2127a());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                        } else {
                            MediaBrowserServiceCompat.this.m2101a(str, connectionRecord, resultReceiver);
                        }
                    }
                });
            }
        }

        /* JADX INFO: renamed from: a */
        public void m2119a(final ServiceCallbacks serviceCallbacks, final Bundle bundle) {
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderMo2127a = serviceCallbacks.mo2127a();
                    MediaBrowserServiceCompat.this.f1958b.remove(iBinderMo2127a);
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord();
                    connectionRecord.f1976c = serviceCallbacks;
                    connectionRecord.f1975b = bundle;
                    MediaBrowserServiceCompat.this.f1958b.put(iBinderMo2127a, connectionRecord);
                    try {
                        iBinderMo2127a.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException e) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        /* JADX INFO: renamed from: b */
        public void m2125b(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderMo2127a = serviceCallbacks.mo2127a();
                    ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.f1958b.remove(iBinderMo2127a);
                    if (connectionRecordRemove != null) {
                        iBinderMo2127a.unlinkToDeath(connectionRecordRemove, 0);
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m2121a(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f1958b.get(serviceCallbacks.mo2127a());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                        } else {
                            MediaBrowserServiceCompat.this.m2097a(str, bundle, connectionRecord, resultReceiver);
                        }
                    }
                });
            }
        }

        /* JADX INFO: renamed from: b */
        public void m2126b(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f1960d.m2132a(new Runnable() { // from class: android.support.v4.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f1958b.get(serviceCallbacks.mo2127a());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                        } else {
                            MediaBrowserServiceCompat.this.m2106b(str, bundle, connectionRecord, resultReceiver);
                        }
                    }
                });
            }
        }
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* JADX INFO: renamed from: a */
        final Messenger f2022a;

        ServiceCallbacksCompat(Messenger messenger) {
            this.f2022a = messenger;
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        /* JADX INFO: renamed from: a */
        public IBinder mo2127a() {
            return this.f2022a.getBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        /* JADX INFO: renamed from: a */
        public void mo2128a(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            m2131a(1, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        /* JADX INFO: renamed from: b */
        public void mo2130b() throws RemoteException {
            m2131a(2, null);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompat.ServiceCallbacks
        /* JADX INFO: renamed from: a */
        public void mo2129a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            m2131a(3, bundle2);
        }

        /* JADX INFO: renamed from: a */
        private void m2131a(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f2022a.send(messageObtain);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2103a(String str, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.m2113a(1);
        m2102a(str, result);
    }

    /* JADX INFO: renamed from: b */
    public void m2108b(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.m2113a(2);
        result.m2116b((MediaBrowserCompat.MediaItem) null);
    }

    /* JADX INFO: renamed from: a */
    public void m2098a(String str, Bundle bundle, Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.m2113a(4);
        result.m2116b((List<MediaBrowserCompat.MediaItem>) null);
    }

    /* JADX INFO: renamed from: b */
    public void m2107b(String str, Bundle bundle, Result<Bundle> result) {
        result.m2117c(null);
    }

    /* JADX INFO: renamed from: a */
    boolean m2104a(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    void m2100a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = connectionRecord.f1978e.get(str);
        List<Pair<IBinder, Bundle>> arrayList = list == null ? new ArrayList() : list;
        for (Pair<IBinder, Bundle> pair : arrayList) {
            if (iBinder == pair.f2228a && MediaBrowserCompatUtils.m2094a(bundle, pair.f2229b)) {
                return;
            }
        }
        arrayList.add(new Pair<>(iBinder, bundle));
        connectionRecord.f1978e.put(str, arrayList);
        m2099a(str, connectionRecord, bundle);
    }

    /* JADX INFO: renamed from: a */
    boolean m2105a(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z;
        if (iBinder == null) {
            return connectionRecord.f1978e.remove(str) != null;
        }
        List<Pair<IBinder, Bundle>> list = connectionRecord.f1978e.get(str);
        if (list != null) {
            Iterator<Pair<IBinder, Bundle>> it = list.iterator();
            z = false;
            while (it.hasNext()) {
                if (iBinder == it.next().f2228a) {
                    it.remove();
                    z = true;
                }
            }
            if (list.size() == 0) {
                connectionRecord.f1978e.remove(str);
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    void m2099a(final String str, final ConnectionRecord connectionRecord, final Bundle bundle) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2109a(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.f1958b.get(connectionRecord.f1976c.mo2127a()) != connectionRecord) {
                    if (MediaBrowserServiceCompat.f1957a) {
                        Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.f1974a + " id=" + str);
                    }
                } else {
                    if ((m2115b() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.m2096a(list, bundle);
                    }
                    try {
                        connectionRecord.f1976c.mo2129a(str, list, bundle);
                    } catch (RemoteException e) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.f1974a);
                    }
                }
            }
        };
        this.f1959c = connectionRecord;
        if (bundle == null) {
            m2102a(str, result);
        } else {
            m2103a(str, result, bundle);
        }
        this.f1959c = null;
        if (!result.m2114a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f1974a + " id=" + str);
        }
    }

    /* JADX INFO: renamed from: a */
    List<MediaBrowserCompat.MediaItem> m2096a(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    /* JADX INFO: renamed from: a */
    void m2101a(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2109a(MediaBrowserCompat.MediaItem mediaItem) {
                if ((m2115b() & 2) != 0) {
                    resultReceiver.m2321b(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.m2321b(0, bundle);
            }
        };
        this.f1959c = connectionRecord;
        m2108b(str, result);
        this.f1959c = null;
        if (!result.m2114a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* JADX INFO: renamed from: a */
    void m2097a(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2109a(List<MediaBrowserCompat.MediaItem> list) {
                if ((m2115b() & 4) != 0 || list == null) {
                    resultReceiver.m2321b(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.m2321b(0, bundle2);
            }
        };
        this.f1959c = connectionRecord;
        m2098a(str, bundle, result);
        this.f1959c = null;
        if (!result.m2114a()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    /* JADX INFO: renamed from: b */
    void m2106b(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<Bundle> result = new Result<Bundle>(str) { // from class: android.support.v4.media.MediaBrowserServiceCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo2109a(Bundle bundle2) {
                resultReceiver.m2321b(0, bundle2);
            }

            @Override // android.support.v4.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: b */
            void mo2110b(Bundle bundle2) {
                resultReceiver.m2321b(-1, bundle2);
            }
        };
        this.f1959c = connectionRecord;
        m2107b(str, bundle, result);
        this.f1959c = null;
        if (!result.m2114a()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public static final class BrowserRoot {

        /* JADX INFO: renamed from: a */
        private final String f1972a;

        /* JADX INFO: renamed from: b */
        private final Bundle f1973b;

        /* JADX INFO: renamed from: a */
        public String m2111a() {
            return this.f1972a;
        }

        /* JADX INFO: renamed from: b */
        public Bundle m2112b() {
            return this.f1973b;
        }
    }
}
