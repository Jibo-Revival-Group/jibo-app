package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName componentNameM2237a = m2237a(context, "android.intent.action.MEDIA_BUTTON");
        if (componentNameM2237a != null) {
            intent.setComponent(componentNameM2237a);
            m2238a(context, intent);
            return;
        }
        ComponentName componentNameM2237a2 = m2237a(context, "android.media.browse.MediaBrowserService");
        if (componentNameM2237a2 != null) {
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            MediaButtonConnectionCallback mediaButtonConnectionCallback = new MediaButtonConnectionCallback(applicationContext, intent, pendingResultGoAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, componentNameM2237a2, mediaButtonConnectionCallback, null);
            mediaButtonConnectionCallback.m2240a(mediaBrowserCompat);
            mediaBrowserCompat.m2026a();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {

        /* JADX INFO: renamed from: c */
        private final Context f2052c;

        /* JADX INFO: renamed from: d */
        private final Intent f2053d;

        /* JADX INFO: renamed from: e */
        private final BroadcastReceiver.PendingResult f2054e;

        /* JADX INFO: renamed from: f */
        private MediaBrowserCompat f2055f;

        MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f2052c = context;
            this.f2053d = intent;
            this.f2054e = pendingResult;
        }

        /* JADX INFO: renamed from: a */
        void m2240a(MediaBrowserCompat mediaBrowserCompat) {
            this.f2055f = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        /* JADX INFO: renamed from: a */
        public void mo2030a() {
            try {
                new MediaControllerCompat(this.f2052c, this.f2055f.m2028c()).m2241a((KeyEvent) this.f2053d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e);
            }
            m2239d();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        /* JADX INFO: renamed from: b */
        public void mo2032b() {
            m2239d();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        /* JADX INFO: renamed from: c */
        public void mo2033c() {
            m2239d();
        }

        /* JADX INFO: renamed from: d */
        private void m2239d() {
            this.f2055f.m2027b();
            this.f2054e.finish();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2238a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX INFO: renamed from: a */
    private static ComponentName m2237a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        }
        if (listQueryIntentServices.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + listQueryIntentServices.size());
    }
}
