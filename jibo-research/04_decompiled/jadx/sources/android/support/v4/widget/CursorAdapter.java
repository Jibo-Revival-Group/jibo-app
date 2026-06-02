package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.CursorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* JADX INFO: loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements CursorFilter.CursorFilterClient, Filterable {

    /* JADX INFO: renamed from: a */
    protected boolean f2569a;

    /* JADX INFO: renamed from: b */
    protected boolean f2570b;

    /* JADX INFO: renamed from: c */
    protected Cursor f2571c;

    /* JADX INFO: renamed from: d */
    protected Context f2572d;

    /* JADX INFO: renamed from: e */
    protected int f2573e;

    /* JADX INFO: renamed from: f */
    protected ChangeObserver f2574f;

    /* JADX INFO: renamed from: g */
    protected DataSetObserver f2575g;

    /* JADX INFO: renamed from: h */
    protected CursorFilter f2576h;

    /* JADX INFO: renamed from: i */
    protected FilterQueryProvider f2577i;

    /* JADX INFO: renamed from: a */
    public abstract View mo2937a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* JADX INFO: renamed from: a */
    public abstract void mo2940a(View view, Context context, Cursor cursor);

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        m2938a(context, cursor, z ? 1 : 2);
    }

    /* JADX INFO: renamed from: a */
    void m2938a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f2570b = true;
        } else {
            this.f2570b = false;
        }
        boolean z = cursor != null;
        this.f2571c = cursor;
        this.f2569a = z;
        this.f2572d = context;
        this.f2573e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f2574f = new ChangeObserver();
            this.f2575g = new MyDataSetObserver();
        } else {
            this.f2574f = null;
            this.f2575g = null;
        }
        if (z) {
            if (this.f2574f != null) {
                cursor.registerContentObserver(this.f2574f);
            }
            if (this.f2575g != null) {
                cursor.registerDataSetObserver(this.f2575g);
            }
        }
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: a */
    public Cursor mo2935a() {
        return this.f2571c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f2569a || this.f2571c == null) {
            return 0;
        }
        return this.f2571c.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f2569a || this.f2571c == null) {
            return null;
        }
        this.f2571c.moveToPosition(i);
        return this.f2571c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f2569a && this.f2571c != null && this.f2571c.moveToPosition(i)) {
            return this.f2571c.getLong(this.f2573e);
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2569a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f2571c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = mo2937a(this.f2572d, this.f2571c, viewGroup);
        }
        mo2940a(view, this.f2572d, this.f2571c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f2569a) {
            return null;
        }
        this.f2571c.moveToPosition(i);
        if (view == null) {
            view = mo2942b(this.f2572d, this.f2571c, viewGroup);
        }
        mo2940a(view, this.f2572d, this.f2571c);
        return view;
    }

    /* JADX INFO: renamed from: b */
    public View mo2942b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo2937a(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: a */
    public void mo2939a(Cursor cursor) {
        Cursor cursorM2941b = m2941b(cursor);
        if (cursorM2941b != null) {
            cursorM2941b.close();
        }
    }

    /* JADX INFO: renamed from: b */
    public Cursor m2941b(Cursor cursor) {
        if (cursor == this.f2571c) {
            return null;
        }
        Cursor cursor2 = this.f2571c;
        if (cursor2 != null) {
            if (this.f2574f != null) {
                cursor2.unregisterContentObserver(this.f2574f);
            }
            if (this.f2575g != null) {
                cursor2.unregisterDataSetObserver(this.f2575g);
            }
        }
        this.f2571c = cursor;
        if (cursor != null) {
            if (this.f2574f != null) {
                cursor.registerContentObserver(this.f2574f);
            }
            if (this.f2575g != null) {
                cursor.registerDataSetObserver(this.f2575g);
            }
            this.f2573e = cursor.getColumnIndexOrThrow("_id");
            this.f2569a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f2573e = -1;
        this.f2569a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: c */
    public CharSequence mo2944c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.CursorFilter.CursorFilterClient
    /* JADX INFO: renamed from: a */
    public Cursor mo2936a(CharSequence charSequence) {
        return this.f2577i != null ? this.f2577i.runQuery(charSequence) : this.f2571c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f2576h == null) {
            this.f2576h = new CursorFilter(this);
        }
        return this.f2576h;
    }

    /* JADX INFO: renamed from: b */
    protected void m2943b() {
        if (this.f2570b && this.f2571c != null && !this.f2571c.isClosed()) {
            this.f2569a = this.f2571c.requery();
        }
    }

    private class ChangeObserver extends ContentObserver {
        ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.m2943b();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter.this.f2569a = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter.this.f2569a = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }
}
