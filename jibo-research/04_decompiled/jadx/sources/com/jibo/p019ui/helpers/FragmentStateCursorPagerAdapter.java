package com.jibo.p019ui.helpers;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentStateCursorPagerAdapter extends CursorPagerAdapter {

    /* JADX INFO: renamed from: a */
    private final FragmentManager f11441a;

    /* JADX INFO: renamed from: b */
    private FragmentTransaction f11442b;

    /* JADX INFO: renamed from: c */
    private ArrayList<Fragment.SavedState> f11443c;

    /* JADX INFO: renamed from: d */
    private ArrayList<Fragment> f11444d;

    /* JADX INFO: renamed from: e */
    private Fragment f11445e;

    /* JADX INFO: renamed from: a */
    public abstract Fragment mo10266a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo10267a(Fragment fragment, Cursor cursor, int i);

    public FragmentStateCursorPagerAdapter(FragmentManager fragmentManager, Cursor cursor) {
        super(cursor);
        this.f11442b = null;
        this.f11443c = new ArrayList<>();
        this.f11444d = new ArrayList<>();
        this.f11445e = null;
        this.f11441a = fragmentManager;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1619a(ViewGroup viewGroup) {
    }

    @Override // com.jibo.p019ui.helpers.CursorPagerAdapter
    /* JADX INFO: renamed from: a */
    public Object mo11191a(ViewGroup viewGroup, Cursor cursor, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f11444d.size() > i && (fragment = this.f11444d.get(i)) != null) {
            mo10267a(fragment, cursor, i);
            return fragment;
        }
        if (this.f11442b == null) {
            this.f11442b = this.f11441a.mo1471a();
        }
        Fragment fragmentMo10266a = mo10266a(i);
        mo10267a(fragmentMo10266a, cursor, i);
        if (this.f11443c.size() > i && (savedState = this.f11443c.get(i)) != null) {
            fragmentMo10266a.setInitialSavedState(savedState);
        }
        while (this.f11444d.size() <= i) {
            this.f11444d.add(null);
        }
        fragmentMo10266a.setMenuVisibility(false);
        fragmentMo10266a.setUserVisibleHint(false);
        this.f11444d.set(i, fragmentMo10266a);
        this.f11442b.mo1364a(viewGroup.getId(), fragmentMo10266a);
        return fragmentMo10266a;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1620a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f11442b == null) {
            this.f11442b = this.f11441a.mo1471a();
        }
        while (this.f11443c.size() <= i) {
            this.f11443c.add(null);
        }
        this.f11443c.set(i, fragment.isAdded() ? this.f11441a.mo1467a(fragment) : null);
        this.f11444d.set(i, null);
        this.f11442b.mo1366a(fragment);
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: b */
    public void mo1624b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f11445e) {
            if (this.f11445e != null) {
                this.f11445e.setMenuVisibility(false);
                this.f11445e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f11445e = fragment;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: b */
    public void mo1623b(ViewGroup viewGroup) {
        if (this.f11442b != null) {
            this.f11442b.mo1386e();
            this.f11442b = null;
            this.f11441a.mo1477b();
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
        Bundle bundle = null;
        if (this.f11443c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f11443c.size()];
            this.f11443c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f11444d.size(); i++) {
            Fragment fragment = this.f11444d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f11441a.mo1473a(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo1618a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f11443c.clear();
            this.f11444d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f11443c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentMo1469a = this.f11441a.mo1469a(bundle, str);
                    if (fragmentMo1469a != null) {
                        while (this.f11444d.size() <= i) {
                            this.f11444d.add(null);
                        }
                        fragmentMo1469a.setMenuVisibility(false);
                        this.f11444d.set(i, fragmentMo1469a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
