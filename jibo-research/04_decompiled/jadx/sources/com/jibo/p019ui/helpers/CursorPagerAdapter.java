package com.jibo.p019ui.helpers;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class CursorPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a */
    private boolean f11434a;

    /* JADX INFO: renamed from: b */
    private Cursor f11435b;

    /* JADX INFO: renamed from: c */
    private int f11436c;

    /* JADX INFO: renamed from: d */
    private ChangeObserver f11437d;

    /* JADX INFO: renamed from: e */
    private DataSetObserver f11438e;

    /* JADX INFO: renamed from: a */
    public abstract Object mo11191a(ViewGroup viewGroup, Cursor cursor, int i);

    public CursorPagerAdapter(Cursor cursor) {
        m11189b(cursor);
    }

    /* JADX INFO: renamed from: b */
    private void m11189b(Cursor cursor) {
        boolean z = cursor != null;
        this.f11435b = cursor;
        this.f11434a = z;
        this.f11436c = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.f11437d = new ChangeObserver();
        this.f11438e = new MyDataSetObserver();
        if (z) {
            if (this.f11437d != null) {
                cursor.registerContentObserver(this.f11437d);
            }
            if (this.f11438e != null) {
                cursor.registerDataSetObserver(this.f11438e);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public Cursor m11193d() {
        return this.f11435b;
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: b */
    public int mo2555b() {
        if (!this.f11434a || this.f11435b == null) {
            return 0;
        }
        return this.f11435b.getCount();
    }

    /* JADX INFO: renamed from: b */
    protected void m11192b(int i) {
        if (!this.f11434a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f11435b.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public Object mo2551a(View view, int i) {
        m11192b(i);
        return mo11191a((ViewGroup) view, this.f11435b, i);
    }

    @Override // android.support.v4.view.PagerAdapter
    /* JADX INFO: renamed from: a */
    public void mo2554a(View view, int i, Object obj) {
    }

    /* JADX INFO: renamed from: a */
    public Cursor m11190a(Cursor cursor) {
        if (cursor == this.f11435b) {
            return null;
        }
        Cursor cursor2 = this.f11435b;
        if (cursor2 != null) {
            if (this.f11437d != null) {
                cursor2.unregisterContentObserver(this.f11437d);
            }
            if (this.f11438e != null) {
                cursor2.unregisterDataSetObserver(this.f11438e);
            }
        }
        this.f11435b = cursor;
        if (cursor != null && !cursor.isClosed()) {
            if (this.f11437d != null) {
                cursor.registerContentObserver(this.f11437d);
            }
            if (this.f11438e != null) {
                cursor.registerDataSetObserver(this.f11438e);
            }
            this.f11436c = cursor.getColumnIndexOrThrow("_id");
            this.f11434a = true;
            m2560c();
            return cursor2;
        }
        this.f11436c = -1;
        this.f11434a = false;
        m2560c();
        return cursor2;
    }

    /* JADX INFO: renamed from: e */
    protected void m11194e() {
        if (this.f11435b != null && !this.f11435b.isClosed()) {
            this.f11434a = this.f11435b.requery();
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m11195f() {
        return this.f11434a;
    }

    private class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorPagerAdapter.this.m11194e();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        private MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorPagerAdapter.this.f11434a = true;
            CursorPagerAdapter.this.m2560c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorPagerAdapter.this.f11434a = false;
            CursorPagerAdapter.this.m2560c();
        }
    }
}
