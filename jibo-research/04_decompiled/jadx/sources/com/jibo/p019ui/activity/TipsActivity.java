package com.jibo.p019ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.R;
import com.jibo.p019ui.fragment.tips.TipsFragment;
import com.jibo.p019ui.fragment.tips.TipsGuidedExperienceFragment;
import com.jibo.p019ui.view.NoBounceBehavior;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class TipsActivity extends BaseActivity {

    @BindView
    AppBarLayout appBarLayout;

    @BindView
    CollapsingToolbarLayout collapsingToolbar;

    /* JADX INFO: renamed from: h */
    int f9904h;

    /* JADX INFO: renamed from: i */
    String f9905i;

    @BindView
    ImageView image;

    @BindView
    TextView text;

    @BindView
    TextView title;

    @BindView
    Toolbar toolbar;

    @BindView
    View toolbarContainer;

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.TipsActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.TipsActivity");
        super.onStart();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.TipsActivity");
        getIntent().putExtra(BaseActivity.f9760b, R.layout.activity_tips);
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            this.f9904h = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        this.f9905i = getIntent().getExtras().getString("ARGS_TAG");
        if (this.f9905i.equalsIgnoreCase("TAG_TIP5")) {
            this.appBarLayout.m420a(false, false);
            ((NoBounceBehavior) ((CoordinatorLayout.LayoutParams) this.appBarLayout.getLayoutParams()).m699b()).m11279a(false);
        }
        if (bundle == null) {
            FragmentTransaction fragmentTransactionMo1471a = getSupportFragmentManager().mo1471a();
            if (this.f9905i.equalsIgnoreCase("TAG_TIP0")) {
                this.text.setText(Html.fromHtml(getString(R.string.tips_content0_1)));
                Glide.m5250a((FragmentActivity) this).m5278a(Integer.valueOf(R.drawable.tip0_title_image)).m5217b().mo5216a(this.image);
                this.title.setText(R.string.tips_title0);
                fragmentTransactionMo1471a.mo1379b(R.id.fragment_container, Fragment.instantiate(this, TipsGuidedExperienceFragment.class.getName(), getIntent().getExtras()), TipsFragment.f9929f).mo1368a(TipsFragment.f9929f).mo1385d();
            } else {
                fragmentTransactionMo1471a.mo1379b(R.id.fragment_container, Fragment.instantiate(this, TipsFragment.class.getName(), getIntent().getExtras()), TipsFragment.f9929f).mo1368a(TipsFragment.f9929f).mo1385d();
            }
        }
        this.appBarLayout.m419a(new AppBarLayout.OnOffsetChangedListener() { // from class: com.jibo.ui.activity.TipsActivity.1

            /* JADX INFO: renamed from: a */
            boolean f9906a = false;

            /* JADX INFO: renamed from: b */
            int f9907b = -1;

            @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
            /* JADX INFO: renamed from: a */
            public void mo472a(AppBarLayout appBarLayout, int i) {
                if (this.f9907b == -1) {
                    this.f9907b = appBarLayout.getTotalScrollRange();
                }
                if (this.f9907b + i <= TipsActivity.this.f9904h) {
                    TipsActivity.this.toolbar.setBackground(null);
                    this.f9906a = true;
                } else if (this.f9906a && this.f9907b + i > TipsActivity.this.f9904h) {
                    TipsActivity.this.toolbar.setBackground(ImageUtils.m11391a(TipsActivity.this, R.drawable.gradient_tip_toolbar));
                    this.f9906a = false;
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10313a(TipsFragment.Tip tip) {
        if (!this.f9905i.equalsIgnoreCase("TAG_TIP5")) {
            this.text.setText(Html.fromHtml(getString(tip.m11099c())));
            Glide.m5250a((FragmentActivity) this).m5278a(Integer.valueOf(tip.m11100d())).m5217b().mo5216a(this.image);
            this.title.setText(tip.m11101e());
        }
    }

    public void collapseToolbar(View view) {
        this.appBarLayout.setExpanded(false);
    }
}
