package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* JADX INFO: renamed from: j */
    private int f2677j;

    /* JADX INFO: renamed from: k */
    private int f2678k;

    /* JADX INFO: renamed from: l */
    private LayoutInflater f2679l;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2678k = i;
        this.f2677j = i;
        this.f2679l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.CursorAdapter
    /* JADX INFO: renamed from: a */
    public View mo2937a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2679l.inflate(this.f2677j, viewGroup, false);
    }

    @Override // android.support.v4.widget.CursorAdapter
    /* JADX INFO: renamed from: b */
    public View mo2942b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2679l.inflate(this.f2678k, viewGroup, false);
    }
}
