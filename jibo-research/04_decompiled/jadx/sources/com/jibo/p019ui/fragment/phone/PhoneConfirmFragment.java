package com.jibo.p019ui.fragment.phone;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.VerifyPhoneByCodeRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class PhoneConfirmFragment extends PhoneBaseFragment {

    /* JADX INFO: renamed from: l */
    public static final String f10824l = PhoneConfirmFragment.class.getSimpleName();

    @BindView
    EditText code;

    @BindView
    TextView footer1;

    @BindView
    TextView footer_error;

    /* JADX INFO: renamed from: m */
    private String f10825m;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_phone_confirm, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.code.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PhoneConfirmFragment.this.mo10872a();
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_custom_action, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10817b = menu.findItem(R.id.action);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (this.f10817b != null && this.f10817b.getActionView() != null) {
            this.f10818c = (CustomFontTextView) this.f10817b.getActionView();
            ProximaHelper.m11358b(this.f10818c);
            mo10872a();
            this.f10818c.setTextSize(2, 15.0f);
            this.f10818c.setPadding(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin), getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin));
            if (Build.VERSION.SDK_INT >= 21) {
                this.f10818c.setLetterSpacing(0.12f);
            }
            this.f10818c.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!PhoneConfirmFragment.this.f10818c.getText().toString().equals(PhoneConfirmFragment.this.getString(R.string.action_skip))) {
                        PhoneConfirmFragment.this.m10878q();
                    } else {
                        DialogUtils.m10518a(PhoneConfirmFragment.this, PhoneConfirmFragment.this.getFragmentManager(), 104, PhoneConfirmFragment.this.getString(R.string.dialog_title_skip_phone), PhoneConfirmFragment.this.getString(R.string.dialog_msg_skip_phone), PhoneConfirmFragment.this.getString(R.string.action_skip), PhoneConfirmFragment.this.getString(R.string.button_add_phone));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m10878q() {
        m10344f();
        m10343e();
        EntityData.m10089a(getActivity()).m10110a().verifyPhoneByCode(this.code.getText().toString().trim(), new AsyncHandler<VerifyPhoneByCodeRequest, Account>() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(final Exception exc) {
                PhoneConfirmFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AmazonServiceException amazonServiceException = (AmazonServiceException) exc;
                        if ("TOKEN_NOT_FOUND".equals(amazonServiceException.getErrorCode())) {
                            PhoneConfirmFragment.this.footer_error.setVisibility(0);
                            PhoneConfirmFragment.this.footer1.setVisibility(8);
                            PhoneConfirmFragment.this.footer_error.setText(R.string.error_phone_code_incorrect);
                        } else if ("PHONE_TOKEN_EXPIRED".equals(amazonServiceException.getErrorCode())) {
                            PhoneConfirmFragment.this.footer_error.setVisibility(0);
                            PhoneConfirmFragment.this.footer1.setVisibility(8);
                            PhoneConfirmFragment.this.footer_error.setText(R.string.error_phone_code_expired);
                        } else {
                            PhoneConfirmFragment.this.footer_error.setVisibility(8);
                            PhoneConfirmFragment.this.footer1.setVisibility(0);
                        }
                        PhoneConfirmFragment.this.m10338a((Throwable) exc, "verify phone by code", false);
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(VerifyPhoneByCodeRequest verifyPhoneByCodeRequest, final Account account) {
                PhoneConfirmFragment.this.mo10345g();
                JiboAnalytics.m9845c(PhoneConfirmFragment.this.getActivity());
                PhoneConfirmFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.3.2
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        account.setAccessKeyId(EntityData.m10089a(PhoneConfirmFragment.this.getActivity()).m10134i().getAccessKeyId());
                        account.setSecretAccessKey(EntityData.m10089a(PhoneConfirmFragment.this.getActivity()).m10134i().getSecretAccessKey());
                        EntityData.m10089a(PhoneConfirmFragment.this.getActivity()).m10115a(account, true, null);
                        if (PhoneConfirmFragment.this.f10819d) {
                            if (PhoneConfirmFragment.this.getActivity() instanceof SingleFragmentActivity) {
                                ((SingleFragmentActivity) PhoneConfirmFragment.this.getActivity()).m10268q().putExtra(Account.class.getSimpleName(), (Parcelable) account);
                            }
                            PhoneConfirmFragment.this.getActivity().finish();
                            return;
                        }
                        ((OnBoardingActivity) PhoneConfirmFragment.this.getActivity()).m10245s();
                    }
                });
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("PARAM_PHONENUMBER", this.f10825m);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10825m = bundle.getString("PARAM_PHONENUMBER");
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        if (!this.f10819d) {
            return super.mo10346h();
        }
        DialogUtils.m10518a(this, getFragmentManager(), 104, getString(R.string.dialog_title_skip_phone), getString(R.string.dialog_msg_skip_phone1), getString(R.string.action_skip), getString(R.string.button_add_phone));
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_phone_confirm);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        if (i2 == -1) {
            if (this.f10819d) {
                getFragmentManager().mo1480d();
            } else {
                ((OnBoardingActivity) getActivity()).m10245s();
            }
        }
    }

    @OnClick
    public void onResendCode(View view) {
        m10874b(new Runnable() { // from class: com.jibo.ui.fragment.phone.PhoneConfirmFragment.4
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.phone.PhoneBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10872a() {
        if (this.f10818c != null) {
            if (this.f10819d) {
                this.f10818c.setText(getString(R.string.action_save).toUpperCase());
                this.f10818c.setEnabled(this.code.length() == 6);
                this.f10818c.setTextColor(this.f10818c.isEnabled() ? -1 : ImageUtils.m11399b(getActivity(), R.color.light_blue));
            } else if (this.code.length() > 0) {
                this.f10818c.setText(getString(R.string.action_next).toUpperCase());
                this.f10818c.setEnabled(this.code.length() == 6);
                this.f10818c.setTextColor(this.f10818c.isEnabled() ? -1 : ImageUtils.m11399b(getActivity(), R.color.light_blue));
            } else {
                this.f10818c.setText(getString(R.string.action_skip));
                this.f10818c.setTextColor(ImageUtils.m11399b(getActivity(), R.color.accent_blue));
                this.f10818c.setEnabled(true);
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.phone.PhoneBaseFragment
    /* JADX INFO: renamed from: b */
    protected String mo10873b() {
        return this.f10825m.trim();
    }
}
