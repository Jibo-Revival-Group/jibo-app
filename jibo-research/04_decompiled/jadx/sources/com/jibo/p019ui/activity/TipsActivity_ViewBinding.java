package com.jibo.p019ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class TipsActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* JADX INFO: renamed from: b */
    private TipsActivity f9909b;

    public TipsActivity_ViewBinding(TipsActivity tipsActivity) {
        this(tipsActivity, tipsActivity.getWindow().getDecorView());
    }

    public TipsActivity_ViewBinding(TipsActivity tipsActivity, View view) {
        super(tipsActivity, view);
        this.f9909b = tipsActivity;
        tipsActivity.collapsingToolbar = (CollapsingToolbarLayout) Utils.m5161b(view, R.id.collapsing_toolbar, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
        tipsActivity.appBarLayout = (AppBarLayout) Utils.m5161b(view, R.id.appbar, "field 'appBarLayout'", AppBarLayout.class);
        tipsActivity.toolbarContainer = Utils.m5158a(view, R.id.tip_toolbar_container, "field 'toolbarContainer'");
        tipsActivity.toolbar = (Toolbar) Utils.m5161b(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        tipsActivity.image = (ImageView) Utils.m5161b(view, R.id.image, "field 'image'", ImageView.class);
        tipsActivity.text = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'text'", TextView.class);
        tipsActivity.title = (TextView) Utils.m5161b(view, android.R.id.title, "field 'title'", TextView.class);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        TipsActivity tipsActivity = this.f9909b;
        if (tipsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9909b = null;
        tipsActivity.collapsingToolbar = null;
        tipsActivity.appBarLayout = null;
        tipsActivity.toolbarContainer = null;
        tipsActivity.toolbar = null;
        tipsActivity.image = null;
        tipsActivity.text = null;
        tipsActivity.title = null;
        super.unbind();
    }
}
