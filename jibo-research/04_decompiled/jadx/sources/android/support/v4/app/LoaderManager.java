package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        /* JADX INFO: renamed from: a */
        Loader<D> mo1689a(int i, Bundle bundle);

        /* JADX INFO: renamed from: a */
        void mo1690a(Loader<D> loader);

        /* JADX INFO: renamed from: a */
        void mo1691a(Loader<D> loader, D d);
    }

    /* JADX INFO: renamed from: a */
    public abstract <D> Loader<D> mo1683a(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    /* JADX INFO: renamed from: a */
    public abstract void mo1684a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo1685a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: renamed from: b */
    public abstract <D> Loader<D> mo1687b(int i);

    /* JADX INFO: renamed from: b */
    public abstract <D> Loader<D> mo1688b(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks);

    /* JADX INFO: renamed from: a */
    public boolean mo1686a() {
        return false;
    }
}
