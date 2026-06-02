package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FileStoreImpl implements FileStore {

    /* JADX INFO: renamed from: a */
    private final Context f14715a;

    /* JADX INFO: renamed from: b */
    private final String f14716b;

    /* JADX INFO: renamed from: c */
    private final String f14717c;

    public FileStoreImpl(Kit kit) {
        if (kit.m15121r() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f14715a = kit.m15121r();
        this.f14716b = kit.m15123t();
        this.f14717c = "Android/" + this.f14715a.getPackageName();
    }

    @Override // io.fabric.sdk.android.services.persistence.FileStore
    /* JADX INFO: renamed from: a */
    public File mo15418a() {
        return m15419a(this.f14715a.getFilesDir());
    }

    /* JADX INFO: renamed from: a */
    File m15419a(File file) {
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                Fabric.m15085h().mo15070d("Fabric", "Couldn't create file");
            } else {
                return file;
            }
        } else {
            Fabric.m15085h().mo15063a("Fabric", "Null File");
        }
        return null;
    }
}
