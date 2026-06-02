package com.jibo.p019ui.fragment.phone;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.p019ui.view.proxima.ProximaHelper;

/* JADX INFO: loaded from: classes.dex */
public class PhoneEditFragment extends PhoneBaseFragment {

    /* JADX INFO: renamed from: l */
    public static final String f10838l = PhoneEditFragment.class.getSimpleName();

    @BindView
    EditText phone;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_phone_edit, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher() { // from class: com.jibo.ui.fragment.phone.PhoneEditFragment.1
            @Override // android.telephony.PhoneNumberFormattingTextWatcher, android.text.TextWatcher
            public synchronized void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                PhoneEditFragment.this.mo10872a();
            }
        });
        if (getArguments() != null && bundle == null) {
            this.phone.setText(getArguments().getString("PARAM_PHONENUMBER").replace("+1", ""));
        }
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
            this.f10818c.setTextColor(-1);
            this.f10818c.setText(getString(R.string.action_next).toUpperCase());
            this.f10818c.setTextSize(2, 15.0f);
            this.f10818c.setPadding(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin), getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin), getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin));
            if (Build.VERSION.SDK_INT >= 21) {
                this.f10818c.setLetterSpacing(0.12f);
            }
            this.f10818c.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.phone.PhoneEditFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PhoneEditFragment.this.m10874b(PhoneEditFragment.this.f10820e);
                }
            });
        }
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
        return getString(R.string.title_phone_edit);
    }

    @Override // com.jibo.p019ui.fragment.phone.PhoneBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10872a() {
        if (this.f10817b != null && this.f10818c != null) {
            this.f10818c.setEnabled(m10871a(mo10873b()).length() == 10);
        }
    }

    @Override // com.jibo.p019ui.fragment.phone.PhoneBaseFragment
    /* JADX INFO: renamed from: b */
    protected String mo10873b() {
        return this.phone.getText().toString().trim();
    }
}
