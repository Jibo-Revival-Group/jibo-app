package com.jibo.p019ui.fragment.account;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.RemoveRequest;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeleteConfirmFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f9954a = AccountDeleteConfirmFragment.class.getSimpleName();

    @BindView
    ImageView closeButton;

    @BindView
    ImageView cross1;

    @BindView
    ImageView cross2;

    @BindView
    ImageView cross3;

    @BindView
    ImageView cross4;

    /* JADX INFO: renamed from: d */
    private CircleProgressFragment f9957d;

    @BindView
    View hideWarning;

    @BindView
    CustomFontTextView title;

    @BindView
    CustomFontTextView warning1;

    @BindView
    CustomFontTextView warning2;

    @BindView
    CustomFontTextView warning3;

    /* JADX INFO: renamed from: c */
    private final int[] f9956c = {R.id.cnt1, R.id.cnt2, R.id.cnt3, R.id.hideWarning};

    /* JADX INFO: renamed from: b */
    boolean f9955b = false;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m10349k();
        if (getArguments() != null && getArguments().containsKey("ARG_IS_OWNER_AND_SUSPENDED")) {
            this.f9955b = getArguments().getBoolean("ARG_IS_OWNER_AND_SUSPENDED");
        }
        return layoutInflater.inflate(R.layout.fragment_account_delete_confirm, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.closeButton.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.jibo_blue));
        this.cross1.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.firecracker));
        this.cross2.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.firecracker));
        this.cross3.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.firecracker));
        this.cross4.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.x_white, R.color.firecracker));
        if (this.f9955b) {
            this.hideWarning.setVisibility(0);
            this.title.setText(R.string.as_a_jibo_owner);
            this.warning1.setText(R.string.delete_one_text);
            this.warning2.setText(R.string.delete_two_text);
            this.warning3.setText(R.string.delete_three_text);
        } else {
            this.hideWarning.setVisibility(8);
            this.warning1.setText(R.string.text_you_will_be_removed_from_all_active_loops);
            this.warning2.setText(R.string.text_you_lose_access_to_all_content_and_info_from_your_loops);
            this.warning3.setText(R.string.text_you_will_no_longer_be_enrolled_in_voice_and_face_recognition_with_jibo);
        }
        float f = getResources().getConfiguration().fontScale;
        if (f > 1.0f) {
            for (int i : this.f9956c) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.findViewById(i).getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, (int) (layoutParams.topMargin / f), layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        onCloseButtonClick();
        return true;
    }

    @OnClick
    public void onCloseButtonClick() {
        getActivity().finish();
    }

    @OnClick
    public void onBtnDelete() {
        m10363a();
        EntityData.m10089a(getActivity()).m10110a().remove(new AsyncHandler<RemoveRequest, Account>() { // from class: com.jibo.ui.fragment.account.AccountDeleteConfirmFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                AccountDeleteConfirmFragment.this.m10338a((Throwable) exc, "account remove", false);
                AccountDeleteConfirmFragment.this.m10366a(AccountDeleteConfirmFragment.this.getString(R.string.message_status_deleting_account_failed), false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RemoveRequest removeRequest, Account account) {
                AccountDeleteConfirmFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.AccountDeleteConfirmFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KeyManager.getInstance(AccountDeleteConfirmFragment.this.getActivity(), EntityData.m10089a(AccountDeleteConfirmFragment.this.getActivity()).m10134i().getId()).deleteAccountData(AccountDeleteConfirmFragment.this.getActivity());
                        String string = AccountDeleteConfirmFragment.this.getArguments() != null ? AccountDeleteConfirmFragment.this.getArguments().getString(JiboAnalytics.f9227ak, "") : "";
                        JiboAnalytics.m9842b(AccountDeleteConfirmFragment.this.getActivity());
                        JiboAnalytics.m9849d(AccountDeleteConfirmFragment.this.getActivity(), string);
                        AccountDeleteConfirmFragment.this.m10366a(AccountDeleteConfirmFragment.this.getString(R.string.message_status_saving_ok), true);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10366a(String str, boolean z) {
        if (this.f9957d != null) {
            if (z) {
                this.f9957d.m10505a(str);
            } else {
                this.f9957d.m10507b(str);
            }
            this.f9957d = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10363a() {
        if (this.f9957d != null) {
            this.f9957d.m10502a();
            this.f9957d = null;
        }
        this.f9957d = new CircleProgressFragment();
        this.f9957d.m10509c(getString(R.string.message_status_deleting_account));
        this.f9957d.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.account.AccountDeleteConfirmFragment.2
            @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
            /* JADX INFO: renamed from: a */
            public void mo10227a(CircleProgressFragment.Status status) {
                if (status == CircleProgressFragment.Status.Success) {
                    String string = AccountDeleteConfirmFragment.this.getArguments() != null ? AccountDeleteConfirmFragment.this.getArguments().getString(JiboAnalytics.f9227ak, "") : "";
                    Bundle bundle = new Bundle();
                    bundle.putString(JiboAnalytics.f9227ak, string);
                    ((BaseActivity) AccountDeleteConfirmFragment.this.getActivity()).m10187a(AccountDeletedFragment.class, bundle);
                }
            }
        });
        this.f9957d.show(getActivity().getSupportFragmentManager(), CircleProgressFragment.class.getSimpleName());
    }
}
