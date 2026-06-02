package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
interface GhostViewImpl {

    public interface Creator {
        /* JADX INFO: renamed from: a */
        GhostViewImpl mo1159a(View view, ViewGroup viewGroup, Matrix matrix);

        /* JADX INFO: renamed from: a */
        void mo1160a(View view);
    }

    /* JADX INFO: renamed from: a */
    void mo1157a(ViewGroup viewGroup, View view);

    void setVisibility(int i);
}
