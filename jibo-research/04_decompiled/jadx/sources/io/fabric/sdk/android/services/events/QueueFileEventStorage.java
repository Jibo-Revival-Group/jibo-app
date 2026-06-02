package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class QueueFileEventStorage implements EventsStorage {

    /* JADX INFO: renamed from: a */
    private final Context f14675a;

    /* JADX INFO: renamed from: b */
    private final File f14676b;

    /* JADX INFO: renamed from: c */
    private final String f14677c;

    /* JADX INFO: renamed from: d */
    private final File f14678d;

    /* JADX INFO: renamed from: e */
    private QueueFile f14679e;

    /* JADX INFO: renamed from: f */
    private File f14680f;

    public QueueFileEventStorage(Context context, File file, String str, String str2) throws IOException {
        this.f14675a = context;
        this.f14676b = file;
        this.f14677c = str2;
        this.f14678d = new File(this.f14676b, str);
        this.f14679e = new QueueFile(this.f14678d);
        m15338e();
    }

    /* JADX INFO: renamed from: e */
    private void m15338e() {
        this.f14680f = new File(this.f14676b, this.f14677c);
        if (!this.f14680f.exists()) {
            this.f14680f.mkdirs();
        }
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public void mo15331a(byte[] bArr) throws IOException {
        this.f14679e.m15262a(bArr);
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public int mo15327a() {
        return this.f14679e.m15260a();
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public void mo15329a(String str) throws Throwable {
        this.f14679e.close();
        m15337a(this.f14678d, new File(this.f14680f, str));
        this.f14679e = new QueueFile(this.f14678d);
    }

    /* JADX INFO: renamed from: a */
    private void m15337a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        OutputStream outputStreamMo15336a = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStreamMo15336a = mo15336a(file2);
                CommonUtils.m15190a(fileInputStream, outputStreamMo15336a, new byte[1024]);
                CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.m15188a((Closeable) outputStreamMo15336a, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                CommonUtils.m15188a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.m15188a((Closeable) outputStreamMo15336a, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public OutputStream mo15336a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public List<File> mo15328a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f14680f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public void mo15330a(List<File> list) {
        for (File file : list) {
            CommonUtils.m15185a(this.f14675a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: c */
    public List<File> mo15334c() {
        return Arrays.asList(this.f14680f.listFiles());
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: d */
    public void mo15335d() {
        try {
            this.f14679e.close();
        } catch (IOException e) {
        }
        this.f14678d.delete();
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: b */
    public boolean mo15333b() {
        return this.f14679e.m15265b();
    }

    @Override // io.fabric.sdk.android.services.events.EventsStorage
    /* JADX INFO: renamed from: a */
    public boolean mo15332a(int i, int i2) {
        return this.f14679e.m15264a(i, i2);
    }
}
