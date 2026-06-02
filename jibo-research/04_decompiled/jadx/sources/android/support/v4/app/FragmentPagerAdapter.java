package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a */
    private final FragmentManager f1551a;

    /* JADX INFO: renamed from: b */
    private FragmentTransaction f1552b = null;

    /* JADX INFO: renamed from: c */
    private Fragment f1553c = null;

    /* JADX INFO: renamed from: a */
    public abstract Fragment mo1616a(int i);

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f1551a = fragmentManager;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1619a(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public Object mo1617a(ViewGroup viewGroup, int i) {
        if (this.f1552b == null) {
            this.f1552b = this.f1551a.mo1471a();
        }
        long jM1622b = m1622b(i);
        Fragment fragmentMo1470a = this.f1551a.mo1470a(m1614a(viewGroup.getId(), jM1622b));
        if (fragmentMo1470a != null) {
            this.f1552b.mo1383c(fragmentMo1470a);
        } else {
            fragmentMo1470a = mo1616a(i);
            this.f1552b.mo1365a(viewGroup.getId(), fragmentMo1470a, m1614a(viewGroup.getId(), jM1622b));
        }
        if (fragmentMo1470a != this.f1553c) {
            fragmentMo1470a.setMenuVisibility(false);
            fragmentMo1470a.setUserVisibleHint(false);
        }
        return fragmentMo1470a;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1620a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f1552b == null) {
            this.f1552b = this.f1551a.mo1471a();
        }
        this.f1552b.mo1380b((Fragment) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: b */
    public void mo1624b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f1553c) {
            if (this.f1553c != null) {
                this.f1553c.setMenuVisibility(false);
                this.f1553c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f1553c = fragment;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: b */
    public void mo1623b(ViewGroup viewGroup) {
        if (this.f1552b != null) {
            this.f1552b.mo1388g();
            this.f1552b = null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public boolean mo1621a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public Parcelable mo1615a() {
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1618a(Parcelable parcelable, ClassLoader classLoader) {
    }

    /* JADX INFO: renamed from: b */
    public long m1622b(int i) {
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static String m1614a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
