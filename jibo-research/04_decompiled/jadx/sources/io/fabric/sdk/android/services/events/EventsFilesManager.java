package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EventsFilesManager<T> {

    /* JADX INFO: renamed from: a */
    protected final Context f14665a;

    /* JADX INFO: renamed from: b */
    protected final EventTransform<T> f14666b;

    /* JADX INFO: renamed from: c */
    protected final CurrentTimeProvider f14667c;

    /* JADX INFO: renamed from: d */
    protected final EventsStorage f14668d;

    /* JADX INFO: renamed from: e */
    protected volatile long f14669e;

    /* JADX INFO: renamed from: f */
    protected final List<EventsStorageListener> f14670f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g */
    private final int f14671g;

    /* JADX INFO: renamed from: a */
    protected abstract String mo5660a();

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) throws IOException {
        this.f14665a = context.getApplicationContext();
        this.f14666b = eventTransform;
        this.f14668d = eventsStorage;
        this.f14667c = currentTimeProvider;
        this.f14669e = this.f14667c.mo15215a();
        this.f14671g = i;
    }

    /* JADX INFO: renamed from: a */
    public void m15320a(T t) throws IOException {
        byte[] bArrMo5680a = this.f14666b.mo5680a(t);
        m15316a(bArrMo5680a.length);
        this.f14668d.mo15331a(bArrMo5680a);
    }

    /* JADX INFO: renamed from: a */
    public void m15319a(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.f14670f.add(eventsStorageListener);
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m15322d() throws IOException {
        boolean z = true;
        String strMo5660a = null;
        if (this.f14668d.mo15333b()) {
            z = false;
        } else {
            strMo5660a = mo5660a();
            this.f14668d.mo15329a(strMo5660a);
            CommonUtils.m15184a(this.f14665a, 4, "Fabric", String.format(Locale.US, "generated new file %s", strMo5660a));
            this.f14669e = this.f14667c.mo15215a();
        }
        m15317b(strMo5660a);
        return z;
    }

    /* JADX INFO: renamed from: a */
    private void m15316a(int i) throws IOException {
        if (!this.f14668d.mo15332a(i, mo5663c())) {
            CommonUtils.m15184a(this.f14665a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.f14668d.mo15327a()), Integer.valueOf(i), Integer.valueOf(mo5663c())));
            m15322d();
        }
    }

    /* JADX INFO: renamed from: b */
    protected int mo5662b() {
        return this.f14671g;
    }

    /* JADX INFO: renamed from: c */
    protected int mo5663c() {
        return 8000;
    }

    /* JADX INFO: renamed from: b */
    private void m15317b(String str) {
        Iterator<EventsStorageListener> it = this.f14670f.iterator();
        while (it.hasNext()) {
            try {
                it.next().mo5621a(str);
            } catch (Exception e) {
                CommonUtils.m15186a(this.f14665a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public List<File> m15323e() {
        return this.f14668d.mo15328a(1);
    }

    /* JADX INFO: renamed from: a */
    public void m15321a(List<File> list) {
        this.f14668d.mo15330a(list);
    }

    /* JADX INFO: renamed from: f */
    public void m15324f() {
        this.f14668d.mo15330a(this.f14668d.mo15334c());
        this.f14668d.mo15335d();
    }

    /* JADX INFO: renamed from: g */
    public void m15325g() {
        List<File> listMo15334c = this.f14668d.mo15334c();
        int iMo5662b = mo5662b();
        if (listMo15334c.size() > iMo5662b) {
            int size = listMo15334c.size() - iMo5662b;
            CommonUtils.m15185a(this.f14665a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(listMo15334c.size()), Integer.valueOf(iMo5662b), Integer.valueOf(size)));
            TreeSet treeSet = new TreeSet(new Comparator<FileWithTimestamp>() { // from class: io.fabric.sdk.android.services.events.EventsFilesManager.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(FileWithTimestamp fileWithTimestamp, FileWithTimestamp fileWithTimestamp2) {
                    return (int) (fileWithTimestamp.f14674b - fileWithTimestamp2.f14674b);
                }
            });
            for (File file : listMo15334c) {
                treeSet.add(new FileWithTimestamp(file, m15318a(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((FileWithTimestamp) it.next()).f14673a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f14668d.mo15330a(arrayList);
        }
    }

    /* JADX INFO: renamed from: a */
    public long m15318a(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(strArrSplit[2]).longValue();
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    static class FileWithTimestamp {

        /* JADX INFO: renamed from: a */
        final File f14673a;

        /* JADX INFO: renamed from: b */
        final long f14674b;

        public FileWithTimestamp(File file, long j) {
            this.f14673a = file;
            this.f14674b = j;
        }
    }
}
