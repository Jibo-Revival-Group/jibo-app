package com.mixpanel.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public class HttpService implements RemoteService {

    /* JADX INFO: renamed from: a */
    private static boolean f12081a;

    @Override // com.mixpanel.android.util.RemoteService
    /* JADX INFO: renamed from: a */
    public void mo12006a() {
        new Thread(new Runnable() { // from class: com.mixpanel.android.util.HttpService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress byName = InetAddress.getByName("api.mixpanel.com");
                    InetAddress byName2 = InetAddress.getByName("decide.mixpanel.com");
                    boolean unused = HttpService.f12081a = byName.isLoopbackAddress() || byName.isAnyLocalAddress() || byName2.isLoopbackAddress() || byName2.isAnyLocalAddress();
                    if (HttpService.f12081a) {
                        MPLog.m12021a("MixpanelAPI.Message", "AdBlocker is enabled. Won't be able to use Mixpanel services.");
                    }
                } catch (Exception e) {
                }
            }
        }).start();
    }

    @Override // com.mixpanel.android.util.RemoteService
    /* JADX INFO: renamed from: a */
    public boolean mo12007a(Context context, OfflineMode offlineMode) {
        boolean zIsConnectedOrConnecting;
        if (f12081a || m12002a(offlineMode)) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                MPLog.m12021a("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
                zIsConnectedOrConnecting = true;
            } else {
                zIsConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
                MPLog.m12021a("MixpanelAPI.Message", "ConnectivityManager says we " + (zIsConnectedOrConnecting ? "are" : "are not") + " online");
            }
            return zIsConnectedOrConnecting;
        } catch (SecurityException e) {
            MPLog.m12021a("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m12002a(OfflineMode offlineMode) {
        if (offlineMode == null) {
            return false;
        }
        try {
            return offlineMode.m12034a();
        } catch (Exception e) {
            MPLog.m12022a("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107 A[Catch: all -> 0x011d, TryCatch #28 {all -> 0x011d, blocks: (B:7:0x0024, B:51:0x00ff, B:53:0x0107, B:55:0x010f, B:56:0x011c, B:67:0x0133), top: B:150:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    @Override // com.mixpanel.android.util.RemoteService
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] mo12008a(java.lang.String r14, java.util.Map<java.lang.String, java.lang.Object> r15, javax.net.ssl.SSLSocketFactory r16) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.mo12008a(java.lang.String, java.util.Map, javax.net.ssl.SSLSocketFactory):byte[]");
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m12004a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        while (true) {
            int i = inputStream.read(bArr, 0, bArr.length);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
