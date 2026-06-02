package com.jibo.p019ui.fragment.settings;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.JiboPersonAsyncClient;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.utils.CustomHolidaysUtils;
import com.jibo.utils.ImageUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class CustomHolidaySettingsFragment extends BaseFragment implements DatePickerDialog.OnDateSetListener {

    /* JADX INFO: renamed from: b */
    private static final String f10955b = CustomHolidaySettingsFragment.class.getSimpleName();

    /* JADX INFO: renamed from: c */
    private MenuItem f10957c;

    /* JADX INFO: renamed from: d */
    private List<Holiday> f10958d;

    @BindView
    CustomFontTextView date;

    /* JADX INFO: renamed from: e */
    private int f10959e;

    @BindView
    CustomFontAutoCompleteTextView holidayName;

    /* JADX INFO: renamed from: l */
    private String f10960l;

    /* JADX INFO: renamed from: m */
    private Long f10961m;

    /* JADX INFO: renamed from: n */
    private Account f10962n;

    /* JADX INFO: renamed from: o */
    private JiboPersonAsyncClient f10963o;

    /* JADX INFO: renamed from: p */
    private Boolean f10964p = false;

    /* JADX INFO: renamed from: a */
    final TextWatcher f10956a = new TextWatcher() { // from class: com.jibo.ui.fragment.settings.CustomHolidaySettingsFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CustomHolidaySettingsFragment.this.m10968s();
        }
    };

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_custom_holiday_settings, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10961a();
        if (this.f10958d == null) {
            this.f10958d = new ArrayList();
        }
        m10966q();
        m10967r();
        m10968s();
        this.holidayName.addTextChangedListener(this.f10956a);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle.containsKey("args_custom_holidays")) {
            this.f10958d = (List) bundle.getSerializable("args_custom_holidays");
        }
        this.f10959e = bundle.getInt("args_custom_holidays_pos", -1);
        if (this.f10959e < 0 || this.f10959e >= this.f10958d.size()) {
            this.f10959e = -1;
        }
        if (this.f10959e != -1) {
            this.f10960l = this.f10958d.get(this.f10959e).getName();
        }
        if (bundle.containsKey("args_millis")) {
            this.f10961m = Long.valueOf(bundle.getLong("args_millis"));
        } else if (this.f10959e != -1) {
            this.f10961m = Long.valueOf(CustomHolidaysUtils.m11377a(this.f10958d.get(this.f10959e).getDate()));
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10961m != null) {
            bundle.putLong("args_millis", this.f10961m.longValue());
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.text_custom_holiday_add);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10964p.booleanValue()) {
            mo10345g();
            getActivity().getSupportFragmentManager().mo1479c();
        }
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        this.f10961m = Long.valueOf(calendar.getTimeInMillis());
        m10967r();
        m10968s();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        m10352n();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_done, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        ImageUtils.m11393a(getActivity(), menu);
        this.f10957c = menu.findItem(R.id.action_done);
        m10968s();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10969t();
        return true;
    }

    @OnClick
    public void selectDate(View view) {
        m10964b();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        if (this.f10961m != null) {
            calendar.setTimeInMillis(this.f10961m.longValue());
        }
        new DatePickerDialog(getContext(), this, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    /* JADX INFO: renamed from: a */
    private void m10961a() {
        this.f10962n = EntityData.m10089a(getActivity()).m10134i();
        this.f10963o = new JiboPersonAsyncClient(new BasicAWSCredentials(this.f10962n.getAccessKeyId(), this.f10962n.getSecretAccessKey()));
        m10336a(this.f10963o);
    }

    /* JADX INFO: renamed from: b */
    private void m10964b() {
        ((View) this.holidayName.getParent()).requestFocus();
        m10343e();
    }

    /* JADX INFO: renamed from: q */
    private void m10966q() {
        if (this.f10960l != null) {
            this.holidayName.setText(this.f10960l);
        }
    }

    /* JADX INFO: renamed from: r */
    private void m10967r() {
        if (this.f10961m != null) {
            this.date.setText(DateTimeUtils.getBirthdayString(this.f10961m.longValue(), "MMMM, d, yyyy"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10968s() {
        m10965b((TextUtils.isEmpty(this.holidayName.getText().toString()) || (this.f10961m == null)) ? false : true);
    }

    /* JADX INFO: renamed from: b */
    private void m10965b(boolean z) {
        if (this.f10957c != null) {
            this.f10957c.setEnabled(z);
            ImageUtils.m11394a(getActivity(), this.f10957c, this.f10957c.isEnabled() ? R.color.white : R.color.charlotte);
        }
    }

    /* JADX INFO: renamed from: t */
    private void m10969t() {
        m10964b();
        m10344f();
        m10970u();
    }

    /* JADX INFO: renamed from: u */
    private void m10970u() {
        if (this.f10959e == -1) {
            this.f10958d.add(CustomHolidaysUtils.m11379a(this.holidayName.getText().toString(), this.f9934k.getId(), this.f10962n.getId(), this.f10961m));
        } else {
            Holiday holiday = this.f10958d.get(this.f10959e);
            holiday.setName(this.holidayName.getText().toString());
            holiday.setDate(DateTimeUtils.getBirthdayString(this.f10961m.longValue(), "yyyy-MM-dd"));
        }
        m10971v();
    }

    /* JADX INFO: renamed from: v */
    private void m10971v() {
        if (this.f10963o != null && this.f9934k != null) {
            this.f10963o.setLoopProperty(this.f9934k.getId(), "customHolidays", CustomHolidaysUtils.m11378a(this.f10958d), new AsyncHandler<SetLoopPropertyRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.settings.CustomHolidaySettingsFragment.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    CustomHolidaySettingsFragment.this.m10338a((Throwable) exc, "create custom holidays", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SetLoopPropertyRequest setLoopPropertyRequest, CommandResponse commandResponse) {
                    if (!CustomHolidaySettingsFragment.this.m10342d()) {
                        CustomHolidaySettingsFragment.this.f10964p = true;
                    } else {
                        CustomHolidaySettingsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.CustomHolidaySettingsFragment.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CustomHolidaySettingsFragment.this.mo10345g();
                                CustomHolidaySettingsFragment.this.getActivity().getSupportFragmentManager().mo1479c();
                            }
                        });
                    }
                }
            });
        }
    }
}
