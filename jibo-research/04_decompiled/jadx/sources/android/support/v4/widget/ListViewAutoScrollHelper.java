package android.support.v4.widget;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {

    /* JADX INFO: renamed from: f */
    private final ListView f2643f;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f2643f = listView;
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    /* JADX INFO: renamed from: a */
    public void mo2853a(int i, int i2) {
        ListViewCompat.m3022a(this.f2643f, i2);
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    /* JADX INFO: renamed from: e */
    public boolean mo2863e(int i) {
        return false;
    }

    @Override // android.support.v4.widget.AutoScrollHelper
    /* JADX INFO: renamed from: f */
    public boolean mo2864f(int i) {
        ListView listView = this.f2643f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
