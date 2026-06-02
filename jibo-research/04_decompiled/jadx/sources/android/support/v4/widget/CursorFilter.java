package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
class CursorFilter extends Filter {

    /* JADX INFO: renamed from: a */
    CursorFilterClient f2580a;

    interface CursorFilterClient {
        /* JADX INFO: renamed from: a */
        Cursor mo2935a();

        /* JADX INFO: renamed from: a */
        Cursor mo2936a(CharSequence charSequence);

        /* JADX INFO: renamed from: a */
        void mo2939a(Cursor cursor);

        /* JADX INFO: renamed from: c */
        CharSequence mo2944c(Cursor cursor);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f2580a = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f2580a.mo2944c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo2936a = this.f2580a.mo2936a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo2936a != null) {
            filterResults.count = cursorMo2936a.getCount();
            filterResults.values = cursorMo2936a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo2935a = this.f2580a.mo2935a();
        if (filterResults.values != null && filterResults.values != cursorMo2935a) {
            this.f2580a.mo2939a((Cursor) filterResults.values);
        }
    }
}
