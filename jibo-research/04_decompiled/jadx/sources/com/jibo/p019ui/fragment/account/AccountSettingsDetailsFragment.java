package com.jibo.p019ui.fragment.account;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.amazonaws.handlers.AsyncHandler;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.FacebookMobileConnectRequest;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.AvatarBaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.p019ui.fragment.phone.PhoneEditFragment;
import com.jibo.p019ui.fragment.phone.PhoneFillFragment;
import com.jibo.p019ui.fragment.settings.ChangeEmailConfirmPasswordFragment;
import com.jibo.p019ui.fragment.settings.ConfirmPasswordFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AccountSettingsDetailsFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {

    /* JADX INFO: renamed from: n */
    public static final String f9981n = AccountSettingsDetailsFragment.class.getSimpleName();

    @BindView
    ImageView avatarEditButton;

    @BindView
    LoginButton facebookLoginButton;

    @BindView
    TextView mBirthday;

    @BindView
    TextView mEmail;

    @BindView
    TextView mFacebook;

    @BindView
    ImageView mFacebookLoggedInIcon;

    @BindView
    TextView mGender;

    @BindView
    TextView mName;

    @BindView
    TextView mPhoneNumber;

    @BindView
    TextView mSettingPhoneNumberTitle;

    /* JADX INFO: renamed from: o */
    CallbackManager f9982o;

    /* JADX INFO: renamed from: p */
    String f9983p;

    /* JADX INFO: renamed from: q */
    AsyncHandler f9984q = new AsyncHandler<FacebookMobileConnectRequest, TokenContainer>() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.1
        @Override // com.amazonaws.handlers.AsyncHandler
        public void onError(Exception exc) {
            AccountSettingsDetailsFragment.this.m10338a((Throwable) exc, "facebook mobile connect", true);
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(FacebookMobileConnectRequest facebookMobileConnectRequest, TokenContainer tokenContainer) {
        }
    };

    @BindView
    Switch receiveMessagesSwitch;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_account_settings_details, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.facebookLoginButton.setFragment(this);
        this.facebookLoginButton.setPublishPermissions("publish_actions", "rsvp_event");
        this.f9982o = CallbackManager.Factory.create();
        this.facebookLoginButton.registerCallback(this.f9982o, new FacebookCallback<LoginResult>() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.2
            @Override // com.facebook.FacebookCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(LoginResult loginResult) {
                if (loginResult.getRecentlyGrantedPermissions().size() > 0) {
                    AccessToken accessToken = loginResult.getAccessToken();
                    AccountSettingsDetailsFragment.this.f9983p = accessToken.getToken();
                    AccountSettingsDetailsFragment.this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(AccountSettingsDetailsFragment.this.getActivity(), R.drawable.ic_check, R.color.black));
                    EntityData.m10089a(AccountSettingsDetailsFragment.this.getActivity()).m10110a().facebookMobileConnect(AccountSettingsDetailsFragment.this.f9983p, AccountSettingsDetailsFragment.this.f9984q);
                    AccountSettingsDetailsFragment.this.m10369a(loginResult.getAccessToken());
                }
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                AccountSettingsDetailsFragment.this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(AccountSettingsDetailsFragment.this.getActivity(), R.drawable.plus_white, R.color.jibo_blue));
                AccountSettingsDetailsFragment.this.mFacebook.setText(R.string.common_signin_button_text);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                UIUtils.m11476a(AccountSettingsDetailsFragment.this.facebookLoginButton, facebookException);
                AccountSettingsDetailsFragment.this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(AccountSettingsDetailsFragment.this.getActivity(), R.drawable.plus_white, R.color.jibo_blue));
                AccountSettingsDetailsFragment.this.mFacebook.setText(R.string.common_signin_button_text);
            }
        });
        m10375t();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ((BaseActivity) getActivity()).m10198h().getIndeterminateDrawable().setColorFilter(ImageUtils.m11399b(getActivity(), R.color.grass), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                mo10327b();
            } else if (i == 1016 && intent != null && intent.getExtras() != null && intent.getExtras().containsKey(Account.class.getSimpleName()) && (intent.getExtras().getParcelable(Account.class.getSimpleName()) instanceof Account)) {
                this.f9918e = (Account) intent.getExtras().getParcelable(Account.class.getSimpleName());
                m10375t();
            }
        }
        if (i2 == TabbedActivity.f9761c) {
            getActivity().setResult(TabbedActivity.f9761c);
            getActivity().finish();
        } else {
            this.f9982o.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment
    /* JADX INFO: renamed from: b */
    protected void mo10329b(String str) {
        super.mo10329b(str);
        if (getActivity() instanceof SingleFragmentActivity) {
            ((SingleFragmentActivity) getActivity()).m10268q().putExtra(Account.class.getSimpleName(), (Parcelable) this.f9918e);
        }
        getActivity().setResult(-1);
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
        return getString(R.string.title_about_you);
    }

    @Override // com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment.OnDateChosenListener
    /* JADX INFO: renamed from: a */
    public void mo10374a(long j) throws Throwable {
        this.f9918e.setBirthday(Long.valueOf(j));
        Calendar.getInstance().setTimeInMillis(j);
        this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.f9918e.getBirthday().longValue(), DateTimeUtils.FULL_DATE_FORMAT));
        m10373u();
    }

    @OnClick
    public void nameClick() {
    }

    @OnClick
    public void genderClick() {
        DialogUtils.m10512a(this, 108, getString(R.string.label_gender), R.array.gender_titles, this.f9918e.getGender().ordinal());
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) throws Throwable {
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
            m10373u();
            return;
        }
        if (i == 114) {
            if (obj instanceof Account) {
                this.f9918e.setFirstName(((Account) obj).getFirstName());
                this.f9918e.setLastName(((Account) obj).getLastName());
            }
            this.mName.setText(this.f9918e.getFullName());
            m10373u();
            return;
        }
        if (i == 109) {
            LoginManager.getInstance().logOut();
            this.mFacebook.setText(R.string.common_signin_button_text);
            this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.plus_white, R.color.jibo_blue));
        }
    }

    @OnClick
    public void birthdayClick() {
        long jCurrentTimeMillis;
        MaterialDatePickerDialogFragment materialDatePickerDialogFragment = new MaterialDatePickerDialogFragment();
        Bundle bundle = new Bundle();
        if (this.f9918e.getBirthday() != null) {
            if (this.f9918e.getBirthday() != null && this.f9918e.getBirthday().longValue() != -1) {
                jCurrentTimeMillis = this.f9918e.getBirthday().longValue();
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            bundle.putLong("ARGS_DATE", jCurrentTimeMillis);
        }
        bundle.putString("ARGS_TITLE", getString(R.string.text_birthday));
        bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_must_be_atleast_13));
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.add(1, -13);
        bundle.putLong("ARGS_MAX_VALUE", calendar.getTimeInMillis() - 86400000);
        materialDatePickerDialogFragment.setArguments(bundle);
        materialDatePickerDialogFragment.setTargetFragment(this, 0);
        materialDatePickerDialogFragment.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "datePicker");
    }

    @OnClick
    public void onPhoneNumberClick() {
        if (TextUtils.isEmpty(this.f9918e.getPhoneNumber())) {
            new SingleFragmentActivity.Builder(this, PhoneFillFragment.class.getName()).m10275a(1016);
        } else {
            new SingleFragmentActivity.Builder(this, PhoneEditFragment.class.getName()).m10273a("PARAM_PHONENUMBER", this.f9918e.getPhoneNumber()).m10275a(1016);
        }
    }

    @OnClick
    public void onReceiveMessagesClick(View view) throws Throwable {
        boolean zIsChecked;
        if (!TextUtils.isEmpty(this.f9918e.getPhoneNumber())) {
            Account account = this.f9918e;
            if (view instanceof CompoundButton) {
                zIsChecked = this.receiveMessagesSwitch.isChecked();
            } else {
                zIsChecked = !this.receiveMessagesSwitch.isChecked();
            }
            account.setMessagingAllowed(Boolean.valueOf(zIsChecked));
            m10373u();
        }
    }

    @OnClick
    public void facebookClick() {
        if (AccessToken.getCurrentAccessToken() != null) {
            DialogUtils.m10520b(this, 109, getString(R.string.unlink_facebook), getString(R.string.unlink));
        } else {
            this.facebookLoginButton.performClick();
        }
    }

    @OnClick
    public void changePasswordClick() {
        new SingleFragmentActivity.Builder(getActivity(), ConfirmPasswordFragment.class.getName()).m10275a(999);
    }

    @OnClick
    public void changeEmailClick() {
        new SingleFragmentActivity.Builder(getActivity(), ChangeEmailConfirmPasswordFragment.class.getName()).m10275a(999);
    }

    @OnLongClick
    public boolean onDevSettings(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10369a(AccessToken accessToken) {
        GraphRequest graphRequestNewMeRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.3
            @Override // com.facebook.GraphRequest.GraphJSONObjectCallback
            public void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
                Log.v("LoginActivity", graphResponse.toString());
                try {
                    if (AccountSettingsDetailsFragment.this.mFacebook != null) {
                        AccountSettingsDetailsFragment.this.mFacebook.setText(jSONObject.getString("name"));
                    }
                } catch (JSONException e) {
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,email,gender,birthday");
        graphRequestNewMeRequest.setParameters(bundle);
        graphRequestNewMeRequest.executeAsync();
    }

    /* JADX INFO: renamed from: u */
    private void m10373u() throws Throwable {
        m10344f();
        EntityData.m10089a(getActivity()).m10115a(this.f9918e, false, new AsyncHandler<UpdateRequest, Account>() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.5
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                AccountSettingsDetailsFragment.this.m10338a((Throwable) exc, "update account", true);
                AccountSettingsDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountSettingsDetailsFragment.this.f9918e = EntityData.m10089a(AccountSettingsDetailsFragment.this.getActivity()).m10134i();
                        AccountSettingsDetailsFragment.this.m10375t();
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateRequest updateRequest, final Account account) {
                AccountSettingsDetailsFragment.this.mo10345g();
                AccountSettingsDetailsFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AccountSettingsDetailsFragment.this.f9918e = EntityData.m10089a(AccountSettingsDetailsFragment.this.getActivity()).m10134i();
                        AccountSettingsDetailsFragment.this.m10375t();
                        if (AccountSettingsDetailsFragment.this.getActivity() instanceof SingleFragmentActivity) {
                            ((SingleFragmentActivity) AccountSettingsDetailsFragment.this.getActivity()).m10268q().putExtra(Account.class.getSimpleName(), (Parcelable) account);
                        }
                        AccountSettingsDetailsFragment.this.getActivity().setResult(-1);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: t */
    protected void m10375t() {
        this.mName.setText(this.f9918e.getFullName());
        this.mGender.setText(getResources().getStringArray(R.array.gender_titles)[this.f9918e.getGender().ordinal()]);
        if (this.f9918e.getBirthday() != null) {
            this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.f9918e.getBirthday().longValue(), DateTimeUtils.FULL_DATE_FORMAT));
        }
        this.mEmail.setText(this.f9918e.getEmail());
        if (TextUtils.isEmpty(this.f9918e.getPhoneNumber())) {
            this.mSettingPhoneNumberTitle.setText(R.string.add_phone_number);
            this.mSettingPhoneNumberTitle.setTextColor(ImageUtils.m11399b(getActivity(), R.color.jibo_blue));
            this.mPhoneNumber.setVisibility(8);
            this.receiveMessagesSwitch.setEnabled(false);
        } else {
            this.mSettingPhoneNumberTitle.setText(R.string.phone_number);
            this.mSettingPhoneNumberTitle.setTextColor(-16777216);
            this.mPhoneNumber.setVisibility(0);
            this.mPhoneNumber.setText(this.f9918e.getPhoneNumber());
            this.receiveMessagesSwitch.setEnabled(true);
        }
        m10324a(this.f9918e);
        this.avatarEditButton.setVisibility(0);
        this.receiveMessagesSwitch.setChecked(this.f9918e.isMessagingAllowed().booleanValue());
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null) {
            m10369a(currentAccessToken);
            this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.ic_check, R.color.black));
        } else {
            this.mFacebookLoggedInIcon.setImageDrawable(ImageUtils.m11392a(getActivity(), R.drawable.plus_white, R.color.jibo_blue));
        }
    }
}
