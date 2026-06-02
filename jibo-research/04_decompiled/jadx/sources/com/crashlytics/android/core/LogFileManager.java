package com.crashlytics.android.core;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class LogFileManager {

    /* JADX INFO: renamed from: a */
    private static final NoopLogStore f5267a = new NoopLogStore();

    /* JADX INFO: renamed from: b */
    private final Context f5268b;

    /* JADX INFO: renamed from: c */
    private final DirectoryProvider f5269c;

    /* JADX INFO: renamed from: d */
    private FileLogStore f5270d;

    public interface DirectoryProvider {
        /* JADX INFO: renamed from: a */
        File mo5857a();
    }

    LogFileManager(Context context, DirectoryProvider directoryProvider) {
        this(context, directoryProvider, null);
    }

    LogFileManager(Context context, DirectoryProvider directoryProvider, String str) {
        this.f5268b = context;
        this.f5269c = directoryProvider;
        this.f5270d = f5267a;
        m5924a(str);
    }

    /* JADX INFO: renamed from: a */
    final void m5924a(String str) {
        this.f5270d.mo5912b();
        this.f5270d = f5267a;
        if (str != null) {
            if (!CommonUtils.m15191a(this.f5268b, "com.crashlytics.CollectCustomLogs", true)) {
                Fabric.m15085h().mo15063a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            } else {
                m5923a(m5921b(str), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    ByteString m5922a() {
        return this.f5270d.mo5911a();
    }

    /* JADX INFO: renamed from: b */
    void m5926b() {
        this.f5270d.mo5913c();
    }

    /* JADX INFO: renamed from: a */
    void m5925a(Set<String> set) {
        File[] fileArrListFiles = this.f5269c.mo5857a().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!set.contains(m5920a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m5923a(File file, int i) {
        this.f5270d = new QueueFileLogStore(file, i);
    }

    /* JADX INFO: renamed from: b */
    private File m5921b(String str) {
        return new File(this.f5269c.mo5857a(), "crashlytics-userlog-" + str + ".temp");
    }

    /* JADX INFO: renamed from: a */
    private String m5920a(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".temp");
        return iLastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), iLastIndexOf);
    }

    private static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        /* JADX INFO: renamed from: a */
        public ByteString mo5911a() {
            return null;
        }

        @Override // com.crashlytics.android.core.FileLogStore
        /* JADX INFO: renamed from: b */
        public void mo5912b() {
        }

        @Override // com.crashlytics.android.core.FileLogStore
        /* JADX INFO: renamed from: c */
        public void mo5913c() {
        }
    }
}
