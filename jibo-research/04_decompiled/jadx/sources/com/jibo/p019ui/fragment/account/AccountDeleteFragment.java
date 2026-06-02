package com.jibo.p019ui.fragment.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class AccountDeleteFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f9968a = AccountDeleteFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    boolean f9969b = false;

    @BindView
    View btnDelete;

    @BindView
    TextView footer;

    @BindView
    RadioGroup mLeaveReasonGroup;

    @BindView
    RadioButton reason1;

    @BindView
    RadioButton reason2;

    @BindView
    RadioButton reason3;

    @BindView
    RadioButton reason4;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        m10350l();
        return layoutInflater.inflate(R.layout.fragment_account_delete, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("ARG_IS_OWNER_AND_SUSPENDED")) {
            this.f9969b = getArguments().getBoolean("ARG_IS_OWNER_AND_SUSPENDED");
        }
        m10368a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_action_skip, menu);
        menu.getItem(0).setVisible(this.mLeaveReasonGroup.getCheckedRadioButtonId() == -1);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_skip) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBtnDelete();
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
        return getString(R.string.title_delete_account);
    }

    @OnClick
    public void onBtnDelete() {
        Bundle bundle = new Bundle();
        if (this.mLeaveReasonGroup.getCheckedRadioButtonId() != -1) {
            bundle.putString(JiboAnalytics.f9227ak, (String) getView().findViewById(this.mLeaveReasonGroup.getCheckedRadioButtonId()).getTag());
        }
        bundle.putBoolean("ARG_IS_OWNER_AND_SUSPENDED", this.f9969b);
        ((BaseActivity) getActivity()).m10187a(AccountDeleteConfirmFragment.class, bundle);
    }

    /* JADX INFO: renamed from: a */
    private void m10368a() {
        String string = getString(R.string.delete_account_footer, getString(R.string.customer_care));
        int iIndexOf = string.indexOf(getString(R.string.customer_care));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int length = getString(R.string.customer_care).length();
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), iIndexOf, iIndexOf + length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ImageUtils.m11399b(getActivity(), R.color.jibo_blue)), iIndexOf, iIndexOf + length, 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.account.AccountDeleteFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                AccountDeleteFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(AccountDeleteFragment.this.getString(R.string.support_url))));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, iIndexOf, length + iIndexOf, 33);
        this.footer.setText(spannableStringBuilder);
        this.footer.setMovementMethod(LinkMovementMethod.getInstance());
        this.mLeaveReasonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.jibo.ui.fragment.account.AccountDeleteFragment.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                AccountDeleteFragment.this.getActivity().invalidateOptionsMenu();
                AccountDeleteFragment.this.btnDelete.setVisibility(0);
            }
        });
        this.btnDelete.setVisibility(this.mLeaveReasonGroup.getCheckedRadioButtonId() == -1 ? 4 : 0);
        this.reason1.setTag(JiboAnalytics.f9203aD);
        this.reason2.setTag(JiboAnalytics.f9204aE);
        this.reason3.setTag(JiboAnalytics.f9205aF);
        this.reason4.setTag(JiboAnalytics.f9206aG);
    }
}
