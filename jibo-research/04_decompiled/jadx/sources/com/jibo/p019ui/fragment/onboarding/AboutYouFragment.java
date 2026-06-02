package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.AvatarBaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.p019ui.view.proxima.CustomFontEditText;
import com.jibo.utils.ImageUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class AboutYouFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {

    /* JADX INFO: renamed from: n */
    public static final String f10646n = AboutYouFragment.class.getSimpleName();

    @BindView
    ImageView avatarEditButton;

    @BindView
    TextView first_name;

    @BindView
    TextView last_name;

    @BindView
    TextView mBirthday;

    @BindView
    TextView mGender;

    /* JADX INFO: renamed from: o */
    private MenuItem f10647o;

    /* JADX INFO: renamed from: p */
    private TextWatcher f10648p = new TextWatcher() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AboutYouFragment.this.getActivity().invalidateOptionsMenu();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_about_you, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    ((EditText) view2).setSelection(((EditText) view2).getText().length());
                }
            }
        };
        this.first_name.setOnFocusChangeListener(onFocusChangeListener);
        this.last_name.setOnFocusChangeListener(onFocusChangeListener);
        this.first_name.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(32)});
        this.last_name.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(32)});
        this.first_name.addTextChangedListener(this.f10648p);
        this.last_name.addTextChangedListener(this.f10648p);
        if (this.f9918e != null) {
            this.first_name.setText(this.f9918e.getFirstName());
            this.last_name.setText(this.f9918e.getLastName());
            if (this.f9918e.getGender() != null) {
                this.mGender.setText(getResources().getStringArray(R.array.gender_values)[this.f9918e.getGender().ordinal()]);
            }
            if (this.f9918e.getBirthday() != null) {
                this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.f9918e.getBirthday().longValue(), DateTimeUtils.FULL_DATE_FORMAT));
            }
            m10324a(this.f9918e);
        }
        this.avatarEditButton.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_save, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10647o = menu.findItem(R.id.action_save);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_save != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10822u();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_save).setEnabled(m10821t());
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 69) {
            ((OnBoardingActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10350l();
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_about_you);
    }

    @Override // com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment.OnDateChosenListener
    /* JADX INFO: renamed from: a */
    public void mo10374a(long j) {
        this.f9918e.setBirthday(Long.valueOf(j));
        Calendar.getInstance().setTimeInMillis(j);
        this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.f9918e.getBirthday().longValue(), DateTimeUtils.FULL_DATE_FORMAT));
        getActivity().invalidateOptionsMenu();
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 108) {
            if (i2 == 0) {
                this.f9918e.setGender(Account.Gender.male);
            } else if (i2 == 1) {
                this.f9918e.setGender(Account.Gender.female);
            } else if (i2 == 2) {
                this.f9918e.setGender(Account.Gender.other);
            } else if (i2 == 3) {
                this.f9918e.setGender(Account.Gender.they);
            }
            this.mGender.setText(getResources().getStringArray(R.array.gender_values)[this.f9918e.getGender().ordinal()]);
            getActivity().invalidateOptionsMenu();
        }
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment
    @OnClick
    public void onAvatarClick(View view) {
        if (!this.f9916c) {
            DialogUtils.m10511a(this, 107, getString(R.string.text_change_photo), this.f9917d ? R.array.picture_options_alt : R.array.picture_options);
        }
    }

    @OnClick
    public void genderClick() {
        DialogUtils.m10512a(this, 108, getString(R.string.label_gender), R.array.gender_titles, this.f9918e.getGender() != null ? this.f9918e.getGender().ordinal() : -1);
    }

    @OnClick
    public void birthdayClick() {
        MaterialDatePickerDialogFragment materialDatePickerDialogFragment = new MaterialDatePickerDialogFragment();
        Bundle bundle = new Bundle();
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -18);
        bundle.putLong("ARGS_DATE", (this.f9918e.getBirthday() == null || this.f9918e.getBirthday().longValue() == -1) ? calendar.getTimeInMillis() : this.f9918e.getBirthday().longValue());
        bundle.putString("ARGS_TITLE", getString(R.string.text_birthday));
        bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_must_be_atleast_13));
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar2.add(1, -13);
        calendar2.add(6, 1);
        bundle.putLong("ARGS_MAX_VALUE", calendar2.getTimeInMillis() - 86400000);
        materialDatePickerDialogFragment.setArguments(bundle);
        materialDatePickerDialogFragment.setTargetFragment(this, 0);
        materialDatePickerDialogFragment.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "datePicker");
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10326a(String str) {
        super.mo10326a(str);
        getActivity().invalidateOptionsMenu();
    }

    @OnClick
    public void changePicture(View view) {
        onAvatarClick(view);
    }

    /* JADX INFO: renamed from: t */
    private boolean m10821t() {
        return (TextUtils.isEmpty(this.first_name.getText().toString().trim()) || TextUtils.isEmpty(this.last_name.getText().toString().trim()) || this.f9918e.getGender() == null || this.f9918e.getBirthday() == null) ? false : true;
    }

    /* JADX INFO: renamed from: u */
    private void m10822u() {
        try {
            m10343e();
            m10339a(true);
            Account account = new Account();
            account.setId(this.f9918e.getId());
            account.setFirstName(this.first_name.getText().toString().trim());
            account.setLastName(this.last_name.getText().toString().trim());
            account.setGender(this.f9918e.getGender());
            account.setBirthday(this.f9918e.getBirthday());
            this.f10647o.setEnabled(false);
            m10328b(account);
        } catch (InvalidParameterException e) {
            getActivity().invalidateOptionsMenu();
        } catch (Exception e2) {
            ((OnBoardingActivity) getActivity()).m10202l();
            Crashlytics.m5597a((Throwable) e2);
            getActivity().invalidateOptionsMenu();
        }
    }
}
