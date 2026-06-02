package com.jibo.p019ui.fragment.tips;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class TipsListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private TipsListFragment f11198b;

    public TipsListFragment_ViewBinding(TipsListFragment tipsListFragment, View view) {
        this.f11198b = tipsListFragment;
        tipsListFragment.tip0 = Utils.m5158a(view, R.id.tip0, "field 'tip0'");
        tipsListFragment.tip1 = Utils.m5158a(view, R.id.tip1, "field 'tip1'");
        tipsListFragment.tip2 = Utils.m5158a(view, R.id.tip2, "field 'tip2'");
        tipsListFragment.tip3 = Utils.m5158a(view, R.id.tip3, "field 'tip3'");
        tipsListFragment.tip4 = Utils.m5158a(view, R.id.tip4, "field 'tip4'");
        tipsListFragment.tip5 = Utils.m5158a(view, R.id.tip5, "field 'tip5'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TipsListFragment tipsListFragment = this.f11198b;
        if (tipsListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11198b = null;
        tipsListFragment.tip0 = null;
        tipsListFragment.tip1 = null;
        tipsListFragment.tip2 = null;
        tipsListFragment.tip3 = null;
        tipsListFragment.tip4 = null;
        tipsListFragment.tip5 = null;
    }
}
