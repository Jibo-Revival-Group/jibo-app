package com.jibo.p019ui.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.robotProperties.JiboRobotPropertiesAsyncClient;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.guided.JiboAvatarSlideFragment;
import com.jibo.p019ui.fragment.guided.JiboRobotSlideFragment;
import com.jibo.p019ui.fragment.guided.LocationSlideFragment;
import com.jibo.p019ui.fragment.guided.WelcomeSlideFragment;
import com.jibo.p019ui.fragment.jibos.JiboDetailsFragment;
import com.jibo.p019ui.fragment.wifi.WiFiSuccessFragment;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes.dex */
public class GuidedExperienceActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView
    ImageView arrowLeft;

    @BindView
    ImageView arrowRight;

    @BindView
    TextView cheersButton;

    @BindView
    View dimmer;

    /* JADX INFO: renamed from: h */
    private List<SlideInfo> f9780h;

    /* JADX INFO: renamed from: i */
    private MyPagerAdapter f9781i;

    @BindView
    CircleIndicator indicator;

    /* JADX INFO: renamed from: j */
    private JiboRobotPropertiesAsyncClient f9782j;

    /* JADX INFO: renamed from: k */
    private Loop f9783k;

    /* JADX INFO: renamed from: l */
    private Robot f9784l;

    @BindView
    ViewGroup overlay;

    @BindView
    ViewGroup overlayContainer;

    @BindView
    ViewPager viewPager;

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppStartTrace.setLauncherActivityOnResumeTime("com.jibo.ui.activity.GuidedExperienceActivity");
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        AppStartTrace.setLauncherActivityOnStartTime("com.jibo.ui.activity.GuidedExperienceActivity");
        super.onStart();
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AppStartTrace.setLauncherActivityOnCreateTime("com.jibo.ui.activity.GuidedExperienceActivity");
        getIntent().putExtra(f9760b, R.layout.activity_guided_experience);
        super.onCreate(bundle);
        this.arrowRight.setImageDrawable(ImageUtils.m11392a(this, R.drawable.ic_chevron_up, R.color.jibo_blue));
        this.arrowLeft.setImageDrawable(ImageUtils.m11392a(this, R.drawable.ic_chevron_up, R.color.jibo_blue));
        if (bundle != null) {
            this.f9783k = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
        } else {
            this.f9783k = (Loop) getIntent().getParcelableExtra(Loop.class.getSimpleName());
        }
        m10211r();
        this.f9781i = new MyPagerAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.f9781i);
        this.indicator.setViewPager(this.viewPager);
        this.viewPager.m2715a(this);
        this.f9782j = EntityData.m10089a(this).m10132g();
        m10212s();
    }

    /* JADX INFO: renamed from: r */
    private void m10211r() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARGS_IS_IN_TUTORIAL_MODE", true);
        JiboDetailsFragment jiboDetailsFragment = new JiboDetailsFragment();
        JiboDetailsFragment jiboDetailsFragment2 = new JiboDetailsFragment();
        LocationSlideFragment locationSlideFragment = new LocationSlideFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(Loop.class.getSimpleName(), this.f9783k);
        locationSlideFragment.setArguments(bundle2);
        jiboDetailsFragment.setArguments(bundle);
        jiboDetailsFragment2.setArguments(bundle);
        this.f9780h = new ArrayList();
        this.f9780h.add(new SlideInfo(new WelcomeSlideFragment()));
        this.f9780h.add(new SlideInfo(new JiboRobotSlideFragment()));
        this.f9780h.add(new SlideInfo(locationSlideFragment));
        this.f9780h.add(new SlideInfo(new JiboAvatarSlideFragment()));
        this.f9780h.add(new SlideInfo(jiboDetailsFragment, false, R.layout.layout_guided_experience_jibos_loop));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9783k);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity
    /* JADX INFO: renamed from: i */
    public void mo10199i() {
        if (this.dimmer != null) {
            this.dimmer.setVisibility(0);
        }
    }

    @Override // com.jibo.p019ui.activity.BaseActivity
    /* JADX INFO: renamed from: j */
    public void mo10200j() {
        if (this.dimmer != null) {
            this.dimmer.setVisibility(8);
        }
    }

    @OnClick
    public void nextSlide(View view) {
        this.viewPager.m2711a(Math.min(this.viewPager.getCurrentItem() + 1, this.f9781i.mo2555b() - 1), true);
    }

    @OnClick
    public void previousSlide(View view) {
        if (this.viewPager.getCurrentItem() == 0) {
            onBackPressed();
        } else {
            this.viewPager.m2711a(Math.max(this.viewPager.getCurrentItem() - 1, 0), true);
        }
    }

    @OnClick
    public void cheersButtonClicked(View view) {
        finish();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    /* JADX INFO: renamed from: a */
    public void mo907a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    /* JADX INFO: renamed from: b */
    public void mo908b(int i) {
        if (i == this.f9780h.size() - 1) {
            this.arrowRight.setVisibility(4);
            this.cheersButton.setVisibility(0);
            this.arrowLeft.setVisibility(0);
        } else if (i == 0) {
            this.arrowLeft.setVisibility(0);
        } else {
            this.arrowRight.setVisibility(0);
            this.cheersButton.setVisibility(8);
            this.arrowLeft.setVisibility(0);
        }
        m10210c(i);
        if (this.f9780h.get(i).m10215a() instanceof JiboDetailsFragment) {
            ((JiboDetailsFragment) this.f9780h.get(i).m10215a()).mo3115n_();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    /* JADX INFO: renamed from: a */
    public void mo906a(int i) {
    }

    /* JADX INFO: renamed from: c */
    private void m10210c(int i) {
        SlideInfo slideInfo = this.f9780h.get(i);
        if (slideInfo.m10216b()) {
            mo10199i();
        } else {
            mo10200j();
        }
        if (slideInfo.m10217c() != -1) {
            View viewInflate = LayoutInflater.from(this).inflate(slideInfo.m10217c(), (ViewGroup) null);
            this.overlayContainer.removeAllViews();
            this.overlayContainer.addView(viewInflate);
            this.overlay.setVisibility(0);
            return;
        }
        this.overlay.setVisibility(8);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        /* JADX INFO: renamed from: b */
        public int mo2555b() {
            return GuidedExperienceActivity.this.f9780h.size();
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        /* JADX INFO: renamed from: a */
        public Fragment mo1616a(int i) {
            return ((SlideInfo) GuidedExperienceActivity.this.f9780h.get(i)).m10215a();
        }
    }

    private class SlideInfo {

        /* JADX INFO: renamed from: b */
        private Fragment f9788b;

        /* JADX INFO: renamed from: c */
        private boolean f9789c;

        /* JADX INFO: renamed from: d */
        private int f9790d;

        public SlideInfo(Fragment fragment) {
            this.f9790d = -1;
            this.f9788b = fragment;
        }

        public SlideInfo(Fragment fragment, boolean z, int i) {
            this.f9790d = -1;
            this.f9788b = fragment;
            this.f9789c = z;
            this.f9790d = i;
        }

        /* JADX INFO: renamed from: a */
        public Fragment m10215a() {
            return this.f9788b;
        }

        /* JADX INFO: renamed from: b */
        public boolean m10216b() {
            return this.f9789c;
        }

        /* JADX INFO: renamed from: c */
        public int m10217c() {
            return this.f9790d;
        }
    }

    /* JADX INFO: renamed from: s */
    private void m10212s() {
        if (this.f9783k != null) {
            this.f9782j.getRobot(this.f9783k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.activity.GuidedExperienceActivity.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    GuidedExperienceActivity.this.m10188a(exc, "get robot");
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
                    GuidedExperienceActivity.this.f9784l = robot;
                }
            });
        }
    }

    /* JADX INFO: renamed from: q */
    public Robot m10213q() {
        return this.f9784l;
    }

    @Override // com.jibo.p019ui.activity.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.viewPager.getCurrentItem() == 0) {
            JiboAnalytics.m9860k(this);
            new SingleFragmentActivity.Builder(this, WiFiSuccessFragment.class.getName()).m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9783k).m10275a(1000);
            finish();
            return;
        }
        this.viewPager.m2711a(this.viewPager.getCurrentItem() - 1, true);
    }
}
