package com.jibo.p019ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class PhotoViewerActivity_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private PhotoViewerActivity f9861b;

    public PhotoViewerActivity_ViewBinding(PhotoViewerActivity photoViewerActivity) {
        this(photoViewerActivity, photoViewerActivity.getWindow().getDecorView());
    }

    public PhotoViewerActivity_ViewBinding(PhotoViewerActivity photoViewerActivity, View view) {
        this.f9861b = photoViewerActivity;
        photoViewerActivity.toolbar = (Toolbar) Utils.m5161b(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        photoViewerActivity.pager = (ViewPager) Utils.m5161b(view, R.id.pager, "field 'pager'", ViewPager.class);
        photoViewerActivity.footer = Utils.m5158a(view, R.id.footer, "field 'footer'");
        photoViewerActivity.photoDateText = (TextView) Utils.m5161b(view, android.R.id.text1, "field 'photoDateText'", TextView.class);
        photoViewerActivity.transitionImage = (ImageView) Utils.m5161b(view, R.id.transitionImage, "field 'transitionImage'", ImageView.class);
        photoViewerActivity.viewNetworkDown = Utils.m5158a(view, R.id.viewNetworkDown, "field 'viewNetworkDown'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoViewerActivity photoViewerActivity = this.f9861b;
        if (photoViewerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9861b = null;
        photoViewerActivity.toolbar = null;
        photoViewerActivity.pager = null;
        photoViewerActivity.footer = null;
        photoViewerActivity.photoDateText = null;
        photoViewerActivity.transitionImage = null;
        photoViewerActivity.viewNetworkDown = null;
    }
}
