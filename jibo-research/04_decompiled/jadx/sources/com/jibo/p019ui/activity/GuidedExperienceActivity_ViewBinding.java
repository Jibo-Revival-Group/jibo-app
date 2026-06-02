package com.jibo.p019ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes.dex */
public class GuidedExperienceActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* JADX INFO: renamed from: b */
    private GuidedExperienceActivity f9791b;

    /* JADX INFO: renamed from: c */
    private View f9792c;

    /* JADX INFO: renamed from: d */
    private View f9793d;

    /* JADX INFO: renamed from: e */
    private View f9794e;

    public GuidedExperienceActivity_ViewBinding(GuidedExperienceActivity guidedExperienceActivity) {
        this(guidedExperienceActivity, guidedExperienceActivity.getWindow().getDecorView());
    }

    public GuidedExperienceActivity_ViewBinding(final GuidedExperienceActivity guidedExperienceActivity, View view) {
        super(guidedExperienceActivity, view);
        this.f9791b = guidedExperienceActivity;
        guidedExperienceActivity.viewPager = (ViewPager) Utils.m5161b(view, R.id.viewPager, "field 'viewPager'", ViewPager.class);
        guidedExperienceActivity.indicator = (CircleIndicator) Utils.m5161b(view, R.id.indicator, "field 'indicator'", CircleIndicator.class);
        View viewM5158a = Utils.m5158a(view, R.id.cheers, "field 'cheersButton' and method 'cheersButtonClicked'");
        guidedExperienceActivity.cheersButton = (TextView) Utils.m5162c(viewM5158a, R.id.cheers, "field 'cheersButton'", TextView.class);
        this.f9792c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.GuidedExperienceActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                guidedExperienceActivity.cheersButtonClicked(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.arrow_right, "field 'arrowRight' and method 'nextSlide'");
        guidedExperienceActivity.arrowRight = (ImageView) Utils.m5162c(viewM5158a2, R.id.arrow_right, "field 'arrowRight'", ImageView.class);
        this.f9793d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.GuidedExperienceActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                guidedExperienceActivity.nextSlide(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.arrow_left, "field 'arrowLeft' and method 'previousSlide'");
        guidedExperienceActivity.arrowLeft = (ImageView) Utils.m5162c(viewM5158a3, R.id.arrow_left, "field 'arrowLeft'", ImageView.class);
        this.f9794e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.GuidedExperienceActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                guidedExperienceActivity.previousSlide(view2);
            }
        });
        guidedExperienceActivity.dimmer = Utils.m5158a(view, R.id.dimmer, "field 'dimmer'");
        guidedExperienceActivity.overlayContainer = (ViewGroup) Utils.m5161b(view, R.id.overlay_container, "field 'overlayContainer'", ViewGroup.class);
        guidedExperienceActivity.overlay = (ViewGroup) Utils.m5161b(view, R.id.overlay, "field 'overlay'", ViewGroup.class);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        GuidedExperienceActivity guidedExperienceActivity = this.f9791b;
        if (guidedExperienceActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9791b = null;
        guidedExperienceActivity.viewPager = null;
        guidedExperienceActivity.indicator = null;
        guidedExperienceActivity.cheersButton = null;
        guidedExperienceActivity.arrowRight = null;
        guidedExperienceActivity.arrowLeft = null;
        guidedExperienceActivity.dimmer = null;
        guidedExperienceActivity.overlayContainer = null;
        guidedExperienceActivity.overlay = null;
        this.f9792c.setOnClickListener(null);
        this.f9792c = null;
        this.f9793d.setOnClickListener(null);
        this.f9793d = null;
        this.f9794e.setOnClickListener(null);
        this.f9794e = null;
        super.unbind();
    }
}
