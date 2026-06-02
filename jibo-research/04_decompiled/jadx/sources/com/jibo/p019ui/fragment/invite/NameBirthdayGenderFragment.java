package com.jibo.p019ui.fragment.invite;

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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.collision.JiboCollisionAsyncClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.p019ui.fragment.invite.BaseSuggestionFragment;
import com.jibo.p019ui.view.proxima.CustomFontEditText;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class NameBirthdayGenderFragment extends BaseSuggestionFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {

    /* JADX INFO: renamed from: r */
    public static final String f10460r = LogUtils.m11405a(NameBirthdayGenderFragment.class);

    @BindView
    TextView birthdayTitle;

    @BindView
    ImageView btnNext;

    @BindView
    ImageView btnPrev;

    @BindView
    TextView dateText;

    @BindView
    AutoCompleteTextView firstName;

    @BindView
    View formNavigationPanel;

    @BindView
    RadioGroup genderGroup;

    @BindView
    TextView genderTitle;

    @BindView
    AutoCompleteTextView lastName;

    @BindView
    RadioButton radioFemale;

    @BindView
    RadioButton radioMale;

    @BindView
    RadioButton radioOther;

    /* JADX INFO: renamed from: t */
    private JiboCollisionAsyncClient f10462t;

    @BindView
    TextView title;

    /* JADX INFO: renamed from: u */
    private RadioGroup.OnCheckedChangeListener f10463u = new RadioGroup.OnCheckedChangeListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.1
        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            NameBirthdayGenderFragment.this.f10398c.setGender(Account.Gender.valueOf((String) NameBirthdayGenderFragment.this.genderGroup.findViewById(i).getTag()));
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= radioGroup.getChildCount()) {
                    NameBirthdayGenderFragment.this.m10729s();
                    return;
                }
                if (radioGroup.getChildAt(i3) instanceof RadioButton) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i3);
                    if (radioButton.getId() == i) {
                        ProximaHelper.m11358b(radioButton);
                    } else {
                        ProximaHelper.m11356a(radioButton);
                    }
                }
                i2 = i3 + 1;
            }
        }
    };

    /* JADX INFO: renamed from: s */
    final TextWatcher f10461s = new TextWatcher() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            NameBirthdayGenderFragment.this.m10728r();
            NameBirthdayGenderFragment.this.m10729s();
            if (editable.length() > 0) {
                NameBirthdayGenderFragment.this.genderTitle.setText(NameBirthdayGenderFragment.this.getString(R.string.title_loop_invite_gender, NameBirthdayGenderFragment.this.firstName.getText().toString()));
                NameBirthdayGenderFragment.this.birthdayTitle.setText(NameBirthdayGenderFragment.this.getString(R.string.title_loop_invite_birthday, NameBirthdayGenderFragment.this.firstName.getText().toString()));
            } else {
                NameBirthdayGenderFragment.this.genderTitle.setText(NameBirthdayGenderFragment.this.getString(R.string.label_gender));
                NameBirthdayGenderFragment.this.birthdayTitle.setText(NameBirthdayGenderFragment.this.getString(R.string.text_birthday));
            }
        }
    };

    /* JADX INFO: renamed from: v */
    private AdapterView.OnItemClickListener f10464v = new AdapterView.OnItemClickListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BaseSuggestionFragment.EmailSuggestion emailSuggestionM10686a = ((BaseSuggestionFragment.EmailSuggestionsListAdapter) adapterView.getAdapter()).m10686a(i);
            String[] strArrSplit = emailSuggestionM10686a.m10682b().split(" ");
            NameBirthdayGenderFragment.this.f10398c.setFirstName(strArrSplit[0]);
            NameBirthdayGenderFragment.this.firstName.setText(strArrSplit[0]);
            if (strArrSplit.length > 1) {
                NameBirthdayGenderFragment.this.f10398c.setLastName(strArrSplit[strArrSplit.length - 1]);
                NameBirthdayGenderFragment.this.lastName.setText(strArrSplit[strArrSplit.length - 1]);
            }
            NameBirthdayGenderFragment.this.f10398c.setEmail(emailSuggestionM10686a.m10681a());
            if (emailSuggestionM10686a.m10684d() != null) {
                NameBirthdayGenderFragment.this.f10398c.setBirthday(Long.valueOf(emailSuggestionM10686a.m10685e()));
                NameBirthdayGenderFragment.this.dateText.setText(DateTimeUtils.getBirthdayString(emailSuggestionM10686a.m10685e(), DateTimeUtils.FULL_DATE_FORMAT));
            } else {
                NameBirthdayGenderFragment.this.f10398c.setBirthday(null);
                NameBirthdayGenderFragment.this.dateText.setText(R.string.loop_invite_hint_date);
            }
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_name_birthday_gender, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboCollisionAsyncClient jiboCollisionAsyncClient = new JiboCollisionAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10462t = jiboCollisionAsyncClient;
            m10336a(jiboCollisionAsyncClient);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.3

            /* JADX INFO: renamed from: b */
            private int f10468b;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (NameBirthdayGenderFragment.this.getView() != null && NameBirthdayGenderFragment.this.getView().getRootView() != null) {
                    int height = NameBirthdayGenderFragment.this.getView().getRootView().getHeight() - NameBirthdayGenderFragment.this.getView().getHeight();
                    if (this.f10468b != height) {
                        if (height > NameBirthdayGenderFragment.this.getResources().getDisplayMetrics().heightPixels / 2) {
                            NameBirthdayGenderFragment.this.formNavigationPanel.setVisibility(0);
                        } else {
                            NameBirthdayGenderFragment.this.formNavigationPanel.setVisibility(8);
                        }
                    }
                    this.f10468b = height;
                }
            }
        });
        this.btnNext.setImageDrawable(ImageUtils.m11400b(getActivity(), R.drawable.ic_chevron_up, R.color.button_states_color));
        this.btnPrev.setImageDrawable(ImageUtils.m11400b(getActivity(), R.drawable.ic_chevron_up, R.color.button_states_color));
        this.firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    NameBirthdayGenderFragment.this.btnPrev.setEnabled(false);
                    NameBirthdayGenderFragment.this.btnNext.setEnabled(true);
                }
            }
        });
        this.lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    NameBirthdayGenderFragment.this.btnNext.setEnabled(false);
                    NameBirthdayGenderFragment.this.btnPrev.setEnabled(true);
                }
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseSuggestionFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10410a.f10415a = false;
        this.firstName.setAdapter(this.f10410a);
        this.lastName.setAdapter(this.f10410a);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        m10729s();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        if (this.f10397b == null || !this.f10397b.booleanValue()) {
            return getString(R.string.invite_loop_member);
        }
        String string = getString(R.string.invite_loop_member);
        if (this.f10402m != null) {
            return LoopHelper.isOwner(this.f9934k, this.f10402m.getAccountId()) ? getString(R.string.title_your_child) : getString(R.string.title_parent_child, this.f10402m.getAccount().getFirstName());
        }
        return string;
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        this.firstName.setText(this.f10398c.getFirstName());
        this.firstName.setDropDownWidth(this.f10406q);
        this.lastName.setText(this.f10398c.getLastName());
        this.firstName.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(32)});
        this.lastName.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(32)});
        this.firstName.addTextChangedListener(this.f10461s);
        this.lastName.addTextChangedListener(this.f10461s);
        this.firstName.setOnItemClickListener(this.f10464v);
        this.lastName.setOnItemClickListener(this.f10464v);
        this.genderGroup.setOnCheckedChangeListener(this.f10463u);
        if (this.f10398c.getGender() == null) {
            this.f10398c.setGender(Account.Gender.other);
        }
        if (this.f10397b != null && this.f10397b.booleanValue()) {
            this.title.setText(R.string.text_childs_name);
        } else {
            this.title.setText(R.string.text_their_name);
        }
        if (!TextUtils.isEmpty(this.f10398c.getFirstName())) {
            this.birthdayTitle.setText(getString(R.string.title_loop_invite_birthday, this.f10398c.getFirstName()));
            this.genderTitle.setText(getString(R.string.title_loop_invite_gender, this.f10398c.getFirstName()));
        } else {
            this.birthdayTitle.setText(R.string.text_birthday);
            this.genderTitle.setText(R.string.text_gender);
        }
        m10726a(this.f10398c.getBirthday());
        m10730t();
        m10729s();
    }

    @Override // com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment.OnDateChosenListener
    /* JADX INFO: renamed from: a */
    public void mo10374a(long j) {
        this.f10398c.setBirthday(Long.valueOf(j));
        m10726a(this.f10398c.getBirthday());
        m10729s();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        UIUtils.m11474a(getActivity(), this.firstName);
        UIUtils.m11474a(getActivity(), this.lastName);
        m10339a(false);
        m10675b(false);
        this.f10462t.match(LoopHelper.getMembersNicknames(this.f9934k), this.f10398c.getFirstName(), new AsyncHandler<MatchRequest, CollisionCheckContainer>() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.6
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                NameBirthdayGenderFragment.this.m10338a((Throwable) exc, "collision match", false);
                NameBirthdayGenderFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NameBirthdayGenderFragment.this.m10675b(true);
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(MatchRequest matchRequest, final CollisionCheckContainer collisionCheckContainer) {
                NameBirthdayGenderFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.NameBirthdayGenderFragment.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NameBirthdayGenderFragment.this.mo10345g();
                        NameBirthdayGenderFragment.this.m10675b(true);
                        if (!collisionCheckContainer.getCollision().booleanValue()) {
                            Bundle bundle = new Bundle();
                            bundle.putString("ARG_NICKNAME", NameBirthdayGenderFragment.this.f10398c.getFirstName());
                            NameBirthdayGenderFragment.this.m10674a(PreferredNameFragment.class, bundle);
                            return;
                        }
                        NameBirthdayGenderFragment.this.m10673a(PreferredNameFragment.class);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m10728r() {
        this.f10398c.setFirstName(this.firstName.getText().toString().trim());
        this.f10398c.setLastName(this.lastName.getText().toString().trim());
    }

    @OnClick
    public void onBtnPrevClick(View view) {
        this.firstName.requestFocusFromTouch();
        this.btnNext.setEnabled(true);
        this.btnPrev.setEnabled(false);
    }

    @OnClick
    public void onBtnNextClick(View view) {
        this.lastName.requestFocusFromTouch();
        this.btnPrev.setEnabled(true);
        this.btnNext.setEnabled(false);
    }

    @OnClick
    public void onBtnDoneClick(View view) {
        ((View) this.lastName.getParent().getParent()).requestFocus();
        m10343e();
    }

    @OnClick
    public void selectBirthday(View view) {
        onBtnDoneClick(null);
        MaterialDatePickerDialogFragment materialDatePickerDialogFragment = new MaterialDatePickerDialogFragment();
        Bundle bundle = new Bundle();
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -18);
        bundle.putLong("ARGS_DATE", this.f10398c.getBirthday() != null ? this.f10398c.getBirthday().longValue() : calendar.getTimeInMillis());
        bundle.putString("ARGS_TITLE", getString(R.string.text_birthday));
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar2.add(1, -13);
        calendar2.add(6, 1);
        if (this.f10397b != null) {
            if (this.f10397b.booleanValue()) {
                bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_child_cant_be_older_13));
                bundle.putLong("ARGS_MIN_VALUE", calendar2.getTimeInMillis());
            } else {
                bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_adult_cant_be_younger_13));
                bundle.putLong("ARGS_MAX_VALUE", calendar2.getTimeInMillis() - 86400000);
            }
        }
        materialDatePickerDialogFragment.setArguments(bundle);
        materialDatePickerDialogFragment.setTargetFragment(this, 0);
        materialDatePickerDialogFragment.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "datePicker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10729s() {
        if (this.f10405p != null) {
            boolean z = this.firstName.getText().toString().trim().isEmpty() || this.lastName.getText().toString().trim().isEmpty();
            boolean z2 = (this.f10398c.getBirthday() == null || this.f10398c.getBirthday() == null) ? false : true;
            if (!z && z2) {
                m10675b(true);
            } else {
                m10675b(false);
            }
        }
    }

    /* JADX INFO: renamed from: t */
    private void m10730t() {
        this.genderGroup.setOnCheckedChangeListener(null);
        if (this.f10398c.getGender() == null) {
            this.radioOther.setChecked(true);
        } else {
            switch (this.f10398c.getGender()) {
                case male:
                    this.radioMale.setChecked(true);
                    break;
                case female:
                    this.radioFemale.setChecked(true);
                    break;
                case other:
                    this.radioOther.setChecked(true);
                    break;
            }
        }
        this.genderGroup.setOnCheckedChangeListener(this.f10463u);
    }

    /* JADX INFO: renamed from: a */
    private void m10726a(Long l) {
        if (l != null && this.dateText != null) {
            this.dateText.setText(DateTimeUtils.getBirthdayString(l.longValue(), DateTimeUtils.FULL_DATE_FORMAT));
        }
    }
}
