package com.jibo.p019ui.fragment.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.login.widget.LoginButton;
import com.jibo.R;
import com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class AccountSettingsDetailsFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private AccountSettingsDetailsFragment f9992b;

    /* JADX INFO: renamed from: c */
    private View f9993c;

    /* JADX INFO: renamed from: d */
    private View f9994d;

    /* JADX INFO: renamed from: e */
    private View f9995e;

    /* JADX INFO: renamed from: f */
    private View f9996f;

    /* JADX INFO: renamed from: g */
    private View f9997g;

    /* JADX INFO: renamed from: h */
    private View f9998h;

    /* JADX INFO: renamed from: i */
    private View f9999i;

    /* JADX INFO: renamed from: j */
    private View f10000j;

    /* JADX INFO: renamed from: k */
    private View f10001k;

    /* JADX INFO: renamed from: l */
    private View f10002l;

    public AccountSettingsDetailsFragment_ViewBinding(final AccountSettingsDetailsFragment accountSettingsDetailsFragment, View view) {
        super(accountSettingsDetailsFragment, view);
        this.f9992b = accountSettingsDetailsFragment;
        accountSettingsDetailsFragment.mName = (TextView) Utils.m5161b(view, R.id.settingNameTextView, "field 'mName'", TextView.class);
        accountSettingsDetailsFragment.mGender = (TextView) Utils.m5161b(view, R.id.settingGenderTextView, "field 'mGender'", TextView.class);
        accountSettingsDetailsFragment.mEmail = (TextView) Utils.m5161b(view, R.id.settingEmailTextView, "field 'mEmail'", TextView.class);
        accountSettingsDetailsFragment.mBirthday = (TextView) Utils.m5161b(view, R.id.settingBirthdayTextView, "field 'mBirthday'", TextView.class);
        accountSettingsDetailsFragment.mSettingPhoneNumberTitle = (TextView) Utils.m5161b(view, R.id.settingPhoneNumberTitle, "field 'mSettingPhoneNumberTitle'", TextView.class);
        accountSettingsDetailsFragment.mPhoneNumber = (TextView) Utils.m5161b(view, R.id.settingPhoneNumberTextView, "field 'mPhoneNumber'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.settingReceiveMessagesSwitch, "field 'receiveMessagesSwitch' and method 'onReceiveMessagesClick'");
        accountSettingsDetailsFragment.receiveMessagesSwitch = (Switch) Utils.m5162c(viewM5158a, R.id.settingReceiveMessagesSwitch, "field 'receiveMessagesSwitch'", Switch.class);
        this.f9993c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) throws Throwable {
                accountSettingsDetailsFragment.onReceiveMessagesClick(view2);
            }
        });
        accountSettingsDetailsFragment.avatarEditButton = (ImageView) Utils.m5161b(view, R.id.avatar_edit, "field 'avatarEditButton'", ImageView.class);
        accountSettingsDetailsFragment.mFacebook = (TextView) Utils.m5161b(view, R.id.settingFacebookTextView, "field 'mFacebook'", TextView.class);
        accountSettingsDetailsFragment.facebookLoginButton = (LoginButton) Utils.m5161b(view, R.id.login_button, "field 'facebookLoginButton'", LoginButton.class);
        accountSettingsDetailsFragment.mFacebookLoggedInIcon = (ImageView) Utils.m5161b(view, R.id.facebookLoggedInIcon, "field 'mFacebookLoggedInIcon'", ImageView.class);
        View viewM5158a2 = Utils.m5158a(view, R.id.settingName, "method 'nameClick'");
        this.f9994d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.nameClick();
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.settingGender, "method 'genderClick'");
        this.f9995e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.genderClick();
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.settingBirthday, "method 'birthdayClick'");
        this.f9996f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.birthdayClick();
            }
        });
        View viewM5158a5 = Utils.m5158a(view, R.id.settingPhoneNumber, "method 'onPhoneNumberClick'");
        this.f9997g = viewM5158a5;
        viewM5158a5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.onPhoneNumberClick();
            }
        });
        View viewM5158a6 = Utils.m5158a(view, R.id.settingReceiveMessages, "method 'onReceiveMessagesClick'");
        this.f9998h = viewM5158a6;
        viewM5158a6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) throws Throwable {
                accountSettingsDetailsFragment.onReceiveMessagesClick(view2);
            }
        });
        View viewM5158a7 = Utils.m5158a(view, R.id.settingFacebook, "method 'facebookClick'");
        this.f9999i = viewM5158a7;
        viewM5158a7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.facebookClick();
            }
        });
        View viewM5158a8 = Utils.m5158a(view, R.id.change_password, "method 'changePasswordClick'");
        this.f10000j = viewM5158a8;
        viewM5158a8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.changePasswordClick();
            }
        });
        View viewM5158a9 = Utils.m5158a(view, R.id.settings_email, "method 'changeEmailClick'");
        this.f10001k = viewM5158a9;
        viewM5158a9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                accountSettingsDetailsFragment.changeEmailClick();
            }
        });
        View viewM5158a10 = Utils.m5158a(view, R.id.btnDevSettings, "method 'onDevSettings'");
        this.f10002l = viewM5158a10;
        viewM5158a10.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.account.AccountSettingsDetailsFragment_ViewBinding.10
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return accountSettingsDetailsFragment.onDevSettings(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        AccountSettingsDetailsFragment accountSettingsDetailsFragment = this.f9992b;
        if (accountSettingsDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9992b = null;
        accountSettingsDetailsFragment.mName = null;
        accountSettingsDetailsFragment.mGender = null;
        accountSettingsDetailsFragment.mEmail = null;
        accountSettingsDetailsFragment.mBirthday = null;
        accountSettingsDetailsFragment.mSettingPhoneNumberTitle = null;
        accountSettingsDetailsFragment.mPhoneNumber = null;
        accountSettingsDetailsFragment.receiveMessagesSwitch = null;
        accountSettingsDetailsFragment.avatarEditButton = null;
        accountSettingsDetailsFragment.mFacebook = null;
        accountSettingsDetailsFragment.facebookLoginButton = null;
        accountSettingsDetailsFragment.mFacebookLoggedInIcon = null;
        this.f9993c.setOnClickListener(null);
        this.f9993c = null;
        this.f9994d.setOnClickListener(null);
        this.f9994d = null;
        this.f9995e.setOnClickListener(null);
        this.f9995e = null;
        this.f9996f.setOnClickListener(null);
        this.f9996f = null;
        this.f9997g.setOnClickListener(null);
        this.f9997g = null;
        this.f9998h.setOnClickListener(null);
        this.f9998h = null;
        this.f9999i.setOnClickListener(null);
        this.f9999i = null;
        this.f10000j.setOnClickListener(null);
        this.f10000j = null;
        this.f10001k.setOnClickListener(null);
        this.f10001k = null;
        this.f10002l.setOnLongClickListener(null);
        this.f10002l = null;
        super.unbind();
    }
}
