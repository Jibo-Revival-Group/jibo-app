package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/* JADX INFO: loaded from: classes.dex */
public class CircleProgressFragment extends DialogFragment {

    /* JADX INFO: renamed from: a */
    private SpannableStringBuilder f10180a;

    /* JADX INFO: renamed from: c */
    private AnimationDrawable f10182c;

    /* JADX INFO: renamed from: d */
    private AnimationDrawable f10183d;

    /* JADX INFO: renamed from: e */
    private AnimationDrawable f10184e;

    /* JADX INFO: renamed from: f */
    private OnDismissListener f10185f;

    /* JADX INFO: renamed from: i */
    private View f10188i;

    @BindView
    ImageView mProgressCircle;

    @BindView
    ImageView mProgressFailure;

    @BindView
    TextView mProgressStatusText;

    @BindView
    ImageView mProgressSuccess;

    /* JADX INFO: renamed from: b */
    private Status f10181b = Status.InProgress;

    /* JADX INFO: renamed from: g */
    private Handler f10186g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h */
    private final Runnable f10187h = new Runnable() { // from class: com.jibo.ui.fragment.dialog.CircleProgressFragment.1
        @Override // java.lang.Runnable
        public void run() {
            CircleProgressFragment.this.dismiss();
        }
    };

    /* JADX INFO: renamed from: j */
    private boolean f10189j = false;

    public interface OnDismissListener {
        /* JADX INFO: renamed from: a */
        void mo10227a(Status status);
    }

    public enum Status {
        InProgress,
        Success,
        Failure
    }

    /* JADX INFO: renamed from: a */
    public void m10504a(OnDismissListener onDismissListener) {
        this.f10185f = onDismissListener;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme.Black.NoTitleBar);
        this.f10188i = getActivity().getLayoutInflater().inflate(com.jibo.R.layout.dialog_progress_circle_new, (ViewGroup) null);
        ButterKnife.m5154a(this, this.f10188i);
        this.f10182c = (AnimationDrawable) this.mProgressCircle.getDrawable();
        this.f10183d = (AnimationDrawable) this.mProgressSuccess.getDrawable();
        this.f10184e = (AnimationDrawable) this.mProgressFailure.getDrawable();
        this.mProgressCircle.post(new Runnable() { // from class: com.jibo.ui.fragment.dialog.CircleProgressFragment.2
            @Override // java.lang.Runnable
            public void run() {
                CircleProgressFragment.this.f10182c.start();
            }
        });
        this.mProgressStatusText.setVisibility(TextUtils.isEmpty(this.f10180a) ? 8 : 0);
        this.mProgressStatusText.setText(this.f10180a);
        setCancelable(false);
        appCompatDialog.setContentView(this.f10188i);
        appCompatDialog.setCancelable(false);
        return appCompatDialog;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10181b != Status.InProgress) {
            this.f10189j = false;
            if (this.f10181b == Status.Success) {
                m10495b();
            } else if (this.f10181b == Status.Failure) {
                m10497c();
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10188i.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.jibo.ui.fragment.dialog.CircleProgressFragment.3
                @Override // android.view.View.OnLayoutChangeListener
                @TargetApi(21)
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    if (CircleProgressFragment.this.f10181b == Status.Success) {
                        CircleProgressFragment.this.m10503a(CircleProgressFragment.this.f10180a);
                    } else if (CircleProgressFragment.this.f10181b == Status.Failure) {
                        CircleProgressFragment.this.m10506b(CircleProgressFragment.this.f10180a);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f10186g.removeCallbacksAndMessages(null);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        if (this.f10185f != null) {
            this.f10185f.mo10227a(this.f10181b);
        }
        m10502a();
    }

    /* JADX INFO: renamed from: a */
    public void m10502a() {
        try {
            if (getActivity() != null && isResumed() && !isDetached() && !getActivity().isFinishing()) {
                super.dismiss();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10495b() {
        if (getActivity() == null || !isResumed() || getActivity().isFinishing()) {
            m10502a();
        } else {
            getActivity().runOnUiThread(new Runnable() { // from class: com.jibo.ui.fragment.dialog.CircleProgressFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    CircleProgressFragment.this.mProgressStatusText.setVisibility(TextUtils.isEmpty(CircleProgressFragment.this.f10180a) ? 8 : 0);
                    CircleProgressFragment.this.mProgressStatusText.setText(CircleProgressFragment.this.f10180a);
                    CircleProgressFragment.this.mProgressStatusText.setTextColor(CircleProgressFragment.this.getResources().getColor(com.jibo.R.color.black));
                    CircleProgressFragment.this.f10182c.stop();
                    CircleProgressFragment.this.mProgressCircle.setVisibility(8);
                    CircleProgressFragment.this.mProgressSuccess.setVisibility(0);
                    CircleProgressFragment.this.f10183d.start();
                    CircleProgressFragment.this.f10186g.postDelayed(CircleProgressFragment.this.f10187h, 1500L);
                }
            });
        }
    }

    /* JADX INFO: renamed from: c */
    private void m10497c() {
        if (getActivity() == null || !isResumed() || getActivity().isFinishing()) {
            m10502a();
        } else {
            getActivity().runOnUiThread(new Runnable() { // from class: com.jibo.ui.fragment.dialog.CircleProgressFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    CircleProgressFragment.this.mProgressStatusText.setVisibility(TextUtils.isEmpty(CircleProgressFragment.this.f10180a) ? 8 : 0);
                    CircleProgressFragment.this.mProgressStatusText.setText(CircleProgressFragment.this.f10180a);
                    CircleProgressFragment.this.mProgressStatusText.setTextColor(CircleProgressFragment.this.getResources().getColor(com.jibo.R.color.firecracker));
                    CircleProgressFragment.this.f10182c.stop();
                    CircleProgressFragment.this.mProgressFailure.setVisibility(0);
                    CircleProgressFragment.this.mProgressCircle.setVisibility(8);
                    CircleProgressFragment.this.f10184e.start();
                    CircleProgressFragment.this.f10186g.postDelayed(CircleProgressFragment.this.f10187h, 2000L);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10503a(SpannableStringBuilder spannableStringBuilder) {
        this.f10181b = Status.Success;
        m10508c(spannableStringBuilder);
        this.f10189j = true;
        m10495b();
    }

    /* JADX INFO: renamed from: a */
    public void m10505a(String str) {
        m10503a(new SpannableStringBuilder(str));
    }

    /* JADX INFO: renamed from: b */
    public void m10506b(SpannableStringBuilder spannableStringBuilder) {
        this.f10181b = Status.Failure;
        m10508c(spannableStringBuilder);
        this.f10189j = true;
        m10497c();
    }

    /* JADX INFO: renamed from: b */
    public void m10507b(String str) {
        m10506b(new SpannableStringBuilder(str));
    }

    /* JADX INFO: renamed from: c */
    public void m10508c(SpannableStringBuilder spannableStringBuilder) {
        this.f10180a = spannableStringBuilder;
    }

    /* JADX INFO: renamed from: c */
    public void m10509c(String str) {
        this.f10180a = new SpannableStringBuilder(str);
    }
}
