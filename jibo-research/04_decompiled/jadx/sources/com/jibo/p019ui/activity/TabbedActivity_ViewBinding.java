package com.jibo.p019ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class TabbedActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* JADX INFO: renamed from: b */
    private TabbedActivity f9901b;

    public TabbedActivity_ViewBinding(TabbedActivity tabbedActivity) {
        this(tabbedActivity, tabbedActivity.getWindow().getDecorView());
    }

    public TabbedActivity_ViewBinding(TabbedActivity tabbedActivity, View view) {
        super(tabbedActivity, view);
        this.f9901b = tabbedActivity;
        tabbedActivity.jiboListContainer = Utils.m5158a(view, R.id.jiboListContainer, "field 'jiboListContainer'");
        tabbedActivity.jiboList = (RecyclerView) Utils.m5161b(view, R.id.jiboList, "field 'jiboList'", RecyclerView.class);
        tabbedActivity.tabs = (LinearLayout) Utils.m5161b(view, android.R.id.tabs, "field 'tabs'", LinearLayout.class);
        tabbedActivity.mSelectorDimmer = Utils.m5158a(view, R.id.selectorDimmer, "field 'mSelectorDimmer'");
    }

    @Override // com.jibo.p019ui.activity.BaseActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        TabbedActivity tabbedActivity = this.f9901b;
        if (tabbedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9901b = null;
        tabbedActivity.jiboListContainer = null;
        tabbedActivity.jiboList = null;
        tabbedActivity.tabs = null;
        tabbedActivity.mSelectorDimmer = null;
        super.unbind();
    }
}
