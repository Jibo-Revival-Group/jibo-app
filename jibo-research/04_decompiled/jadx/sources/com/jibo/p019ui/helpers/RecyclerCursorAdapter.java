package com.jibo.p019ui.helpers;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerCursorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: a */
    private boolean f11468a;

    /* JADX INFO: renamed from: b */
    boolean f11469b = false;

    /* JADX INFO: renamed from: c */
    boolean f11470c = false;

    /* JADX INFO: renamed from: d */
    private int f11471d;

    /* JADX INFO: renamed from: e */
    private Cursor f11472e;

    /* JADX INFO: renamed from: f */
    private RecyclerCursorAdapter<VH>.ChangeObserver f11473f;

    /* JADX INFO: renamed from: g */
    private DataSetObserver f11474g;

    /* JADX INFO: renamed from: a */
    public abstract void mo10646a(VH vh, Cursor cursor);

    public RecyclerCursorAdapter(Cursor cursor) {
        m11227a(cursor);
    }

    /* JADX INFO: renamed from: a */
    void m11227a(Cursor cursor) {
        boolean z = cursor != null;
        this.f11472e = cursor;
        this.f11468a = z;
        this.f11471d = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        this.f11473f = new ChangeObserver();
        this.f11474g = new MyDataSetObserver();
        if (z) {
            if (this.f11473f != null) {
                cursor.registerContentObserver(this.f11473f);
            }
            if (this.f11474g != null) {
                cursor.registerDataSetObserver(this.f11474g);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH vh, int i) {
        if (!this.f11472e.isClosed()) {
            if (this.f11469b) {
                if (i == 0) {
                    mo10646a(vh, this.f11472e);
                    return;
                }
                i--;
            }
            if (this.f11468a || getItemCount() == 0) {
            }
            if (this.f11472e == null || getItemCount() <= 0 || this.f11472e.moveToPosition(i) || this.f11469b || this.f11470c) {
                mo10646a(vh, this.f11472e);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i = this.f11469b ? 1 : 0;
        if (this.f11470c) {
            i++;
        }
        if (!this.f11468a || this.f11472e == null) {
            return 0;
        }
        return this.f11472e.getCount() + i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.f11469b) {
            i--;
        }
        if (this.f11468a && this.f11472e != null && this.f11472e.moveToPosition(i)) {
            return this.f11472e.getLong(this.f11471d);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    public Cursor m11226a() {
        return this.f11472e;
    }

    /* JADX INFO: renamed from: b */
    public Cursor m11228b(Cursor cursor) {
        if (cursor == this.f11472e) {
            return null;
        }
        Cursor cursor2 = this.f11472e;
        if (cursor2 != null) {
            if (this.f11473f != null) {
                cursor2.unregisterContentObserver(this.f11473f);
            }
            if (this.f11474g != null) {
                cursor2.unregisterDataSetObserver(this.f11474g);
            }
        }
        this.f11472e = cursor;
        if (cursor != null) {
            if (this.f11473f != null) {
                cursor.registerContentObserver(this.f11473f);
            }
            if (this.f11474g != null) {
                cursor.registerDataSetObserver(this.f11474g);
            }
            this.f11471d = cursor.getColumnIndexOrThrow("_id");
            this.f11468a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f11471d = -1;
        this.f11468a = false;
        notifyItemRangeRemoved(0, getItemCount());
        return cursor2;
    }

    /* JADX INFO: renamed from: b */
    protected void m11229b() {
    }

    /* JADX INFO: renamed from: c */
    public boolean m11230c() {
        return this.f11468a;
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
            RecyclerCursorAdapter.this.m11229b();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        private MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            RecyclerCursorAdapter.this.f11468a = true;
            RecyclerCursorAdapter.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            RecyclerCursorAdapter.this.f11468a = false;
            RecyclerCursorAdapter.this.notifyItemRangeRemoved(0, RecyclerCursorAdapter.this.getItemCount());
        }
    }
}
