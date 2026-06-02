package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class QueueFileLogStore implements FileLogStore {

    /* JADX INFO: renamed from: a */
    private final File f5314a;

    /* JADX INFO: renamed from: b */
    private final int f5315b;

    /* JADX INFO: renamed from: c */
    private QueueFile f5316c;

    public QueueFileLogStore(File file, int i) {
        this.f5314a = file;
        this.f5315b = i;
    }

    @Override // com.crashlytics.android.core.FileLogStore
    /* JADX INFO: renamed from: a */
    public ByteString mo5911a() {
        if (!this.f5314a.exists()) {
            return null;
        }
        m5957d();
        if (this.f5316c == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[this.f5316c.m15260a()];
        try {
            this.f5316c.m15261a(new QueueFile.ElementReader() { // from class: com.crashlytics.android.core.QueueFileLogStore.1
                @Override // io.fabric.sdk.android.services.common.QueueFile.ElementReader
                /* JADX INFO: renamed from: a */
                public void mo5958a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return ByteString.m5712a(bArr, 0, iArr[0]);
    }

    @Override // com.crashlytics.android.core.FileLogStore
    /* JADX INFO: renamed from: b */
    public void mo5912b() {
        CommonUtils.m15188a(this.f5316c, "There was a problem closing the Crashlytics log file.");
        this.f5316c = null;
    }

    @Override // com.crashlytics.android.core.FileLogStore
    /* JADX INFO: renamed from: c */
    public void mo5913c() {
        mo5912b();
        this.f5314a.delete();
    }

    /* JADX INFO: renamed from: d */
    private void m5957d() {
        if (this.f5316c == null) {
            try {
                this.f5316c = new QueueFile(this.f5314a);
            } catch (IOException e) {
                Fabric.m15085h().mo15073e("CrashlyticsCore", "Could not open log file: " + this.f5314a, e);
            }
        }
    }
}
