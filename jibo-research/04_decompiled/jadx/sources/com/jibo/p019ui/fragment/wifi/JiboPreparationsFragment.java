package com.jibo.p019ui.fragment.wifi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.activity.WifiActivity;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class JiboPreparationsFragment extends WiFiBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f11208a = LogUtils.m11405a(JiboPreparationsFragment.class);

    /* JADX INFO: renamed from: b */
    public static final int[] f11209b = {R.id.wifi_prep_step0, R.id.wifi_prep_step1, R.id.wifi_prep_step2, R.id.wifi_prep_step3};

    /* JADX INFO: renamed from: c */
    public static final int[] f11210c = {R.id.btnImReady, R.id.btnCoverRemoved, R.id.btnPluggedIn, R.id.btnPoweredUp};

    @BindView
    ImageView checkmarkImage;

    @BindView
    ImageView closeButton;

    /* JADX INFO: renamed from: l */
    private int f11211l = 0;

    @BindView
    View progressView;

    public class JiboPreparationsStartFragment_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b */
        private JiboPreparationsStartFragment f11217b;

        public JiboPreparationsStartFragment_ViewBinding(JiboPreparationsStartFragment jiboPreparationsStartFragment, View view) {
            this.f11217b = jiboPreparationsStartFragment;
            jiboPreparationsStartFragment.title = (TextView) Utils.m5161b(view, android.R.id.title, "field 'title'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            JiboPreparationsStartFragment jiboPreparationsStartFragment = this.f11217b;
            if (jiboPreparationsStartFragment == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f11217b = null;
            jiboPreparationsStartFragment.title = null;
        }
    }

    /* JADX INFO: renamed from: b */
    static /* synthetic */ int m11121b(JiboPreparationsFragment jiboPreparationsFragment) {
        int i = jiboPreparationsFragment.f11211l;
        jiboPreparationsFragment.f11211l = i + 1;
        return i;
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11211l = bundle.getInt("ARG_STEP", 0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi_jibo_preparations, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.closeButton.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.jibo_blue));
        this.checkmarkImage.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.ic_success_check, R.color.white));
        getView().findViewById(f11209b[this.f11211l]).setAlpha(1.0f);
        getView().findViewById(f11209b[this.f11211l]).setVisibility(0);
        getView().findViewById(f11210c[this.f11211l]).setEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ARG_STEP", this.f11211l);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        getActivity().finish();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.wifi.WiFiBaseFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10349k();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @OnClick
    public void onCloseClick(View view) {
        mo10346h();
    }

    @OnClick
    public void btnNextScreenClick(View view) {
        view.setEnabled(false);
        this.checkmarkImage.setScaleX(0.5f);
        this.checkmarkImage.setScaleY(0.5f);
        this.checkmarkImage.setPivotX(this.checkmarkImage.getWidth() / 2);
        this.checkmarkImage.setPivotX(this.checkmarkImage.getHeight() / 2);
        getView().findViewById(f11209b[this.f11211l]).animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(500L).start();
        if (this.f11211l == 0) {
            m11119a(this.f11211l);
            this.f11211l++;
        } else {
            this.progressView.animate().alpha(1.0f).setDuration(700L).start();
            this.checkmarkImage.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new BounceInterpolator()).setDuration(800L).withEndAction(new Runnable() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    if (JiboPreparationsFragment.this.m10342d()) {
                        if (JiboPreparationsFragment.this.f11211l != 3) {
                            JiboPreparationsFragment.this.m11119a(JiboPreparationsFragment.this.f11211l);
                            JiboPreparationsFragment.this.progressView.animate().alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(600L).setStartDelay(200L).start();
                            JiboPreparationsFragment.m11121b(JiboPreparationsFragment.this);
                            return;
                        }
                        JiboPreparationsFragment.this.m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((WifiActivity) JiboPreparationsFragment.this.getActivity()).m10318q();
                            }
                        }, 600L);
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11119a(final int i) {
        getView().findViewById(f11209b[i]).setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        getView().findViewById(f11209b[i]).setVisibility(8);
        getView().findViewById(f11210c[i]).setEnabled(false);
        getView().findViewById(f11209b[i + 1]).setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        getView().findViewById(f11209b[i + 1]).setVisibility(0);
        this.checkmarkImage.animate().scaleX(0.7f).scaleY(0.7f).setStartDelay(200L).setInterpolator(new AnticipateInterpolator()).setDuration(500L).withEndAction(new Runnable() { // from class: com.jibo.ui.fragment.wifi.JiboPreparationsFragment.2
            @Override // java.lang.Runnable
            public void run() {
                JiboPreparationsFragment.this.getView().findViewById(JiboPreparationsFragment.f11210c[i + 1]).setEnabled(true);
            }
        }).start();
        getView().findViewById(f11209b[i + 1]).animate().setInterpolator(new AccelerateInterpolator()).setStartDelay(200L).alpha(1.0f).setDuration(600L).start();
    }

    public static class JiboPreparationsStartFragment extends Fragment {

        /* JADX INFO: renamed from: a */
        private final int[] f11216a = {R.id.cnt1, R.id.cnt2, R.id.cnt3};

        @BindView
        TextView title;

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(R.layout.layout_wifi_setup_start, viewGroup, false);
        }

        @Override // android.support.v4.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            ButterKnife.m5154a(this, view);
            float f = getResources().getConfiguration().fontScale;
            this.title.setTextSize(0, this.title.getTextSize() / f);
            for (int i : this.f11216a) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.findViewById(i).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, (int) (layoutParams.topMargin / (f * f)), layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        }
    }
}
