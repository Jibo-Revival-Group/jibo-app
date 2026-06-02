package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerAdapter {

    /* JADX INFO: renamed from: a */
    private final DataSetObservable f2297a = new DataSetObservable();

    /* JADX INFO: renamed from: b */
    private DataSetObserver f2298b;

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1621a(View view, Object obj);

    /* JADX INFO: renamed from: b */
    public abstract int mo2555b();

    /* JADX INFO: renamed from: a */
    public void mo1619a(ViewGroup viewGroup) {
        m2553a((View) viewGroup);
    }

    /* JADX INFO: renamed from: a */
    public Object mo1617a(ViewGroup viewGroup, int i) {
        return mo2551a((View) viewGroup, i);
    }

    /* JADX INFO: renamed from: a */
    public void mo1620a(ViewGroup viewGroup, int i, Object obj) {
        mo2554a((View) viewGroup, i, obj);
    }

    /* JADX INFO: renamed from: b */
    public void mo1624b(ViewGroup viewGroup, int i, Object obj) {
        m2558b((View) viewGroup, i, obj);
    }

    /* JADX INFO: renamed from: b */
    public void mo1623b(ViewGroup viewGroup) {
        m2557b((View) viewGroup);
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public void m2553a(View view) {
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public Object mo2551a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public void mo2554a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public void m2558b(View view, int i, Object obj) {
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public void m2557b(View view) {
    }

    /* JADX INFO: renamed from: a */
    public Parcelable mo1615a() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo1618a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* JADX INFO: renamed from: a */
    public int m2550a(Object obj) {
        return -1;
    }

    /* JADX INFO: renamed from: c */
    public void m2560c() {
        synchronized (this) {
            if (this.f2298b != null) {
                this.f2298b.onChanged();
            }
        }
        this.f2297a.notifyChanged();
    }

    /* JADX INFO: renamed from: a */
    public void m2552a(DataSetObserver dataSetObserver) {
        this.f2297a.registerObserver(dataSetObserver);
    }

    /* JADX INFO: renamed from: b */
    public void m2556b(DataSetObserver dataSetObserver) {
        this.f2297a.unregisterObserver(dataSetObserver);
    }

    /* JADX INFO: renamed from: c */
    void m2561c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f2298b = dataSetObserver;
        }
    }

    /* JADX INFO: renamed from: c */
    public CharSequence m2559c(int i) {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public float m2562d(int i) {
        return 1.0f;
    }
}
