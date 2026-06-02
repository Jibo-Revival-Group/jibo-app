package com.mixpanel.android.util;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public interface RemoteService {
    /* JADX INFO: renamed from: a */
    void mo12006a();

    /* JADX INFO: renamed from: a */
    boolean mo12007a(Context context, OfflineMode offlineMode);

    /* JADX INFO: renamed from: a */
    byte[] mo12008a(String str, Map<String, Object> map, SSLSocketFactory sSLSocketFactory) throws ServiceUnavailableException, IOException;

    public static class ServiceUnavailableException extends Exception {

        /* JADX INFO: renamed from: a */
        private final int f12090a;

        public ServiceUnavailableException(String str, String str2) {
            int i;
            super(str);
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException e) {
                i = 0;
            }
            this.f12090a = i;
        }

        /* JADX INFO: renamed from: a */
        public int m12035a() {
            return this.f12090a;
        }
    }
}
