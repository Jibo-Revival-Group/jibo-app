package com.jibo.p019ui.fragment.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class ProfileFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private ProfileFragment f10911b;

    /* JADX INFO: renamed from: c */
    private View f10912c;

    public ProfileFragment_ViewBinding(final ProfileFragment profileFragment, View view) {
        super(profileFragment, view);
        this.f10911b = profileFragment;
        profileFragment.contactAdult = Utils.m5158a(view, R.id.contactAdult, "field 'contactAdult'");
        profileFragment.contactChild = Utils.m5158a(view, R.id.contactChild, "field 'contactChild'");
        profileFragment.mName = (TextView) Utils.m5161b(view, R.id.profileName, "field 'mName'", TextView.class);
        profileFragment.mNickName = (TextView) Utils.m5161b(view, R.id.profileNickName, "field 'mNickName'", TextView.class);
        profileFragment.mLegalGuardianName = (TextView) Utils.m5161b(view, R.id.legalGuardianName, "field 'mLegalGuardianName'", TextView.class);
        profileFragment.mBirthday = (TextView) Utils.m5161b(view, R.id.profileBirthday, "field 'mBirthday'", TextView.class);
        profileFragment.mTrained = (TextView) Utils.m5161b(view, R.id.profileTrained, "field 'mTrained'", TextView.class);
        profileFragment.mPersonalSettings = (TextView) Utils.m5161b(view, R.id.personalSettings, "field 'mPersonalSettings'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.personalSettingsRow, "field 'mPersonalSettingsRow' and method 'personalSettingsClick'");
        profileFragment.mPersonalSettingsRow = (LinearLayout) Utils.m5162c(viewM5158a, R.id.personalSettingsRow, "field 'mPersonalSettingsRow'", LinearLayout.class);
        this.f10912c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.profile.ProfileFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                profileFragment.personalSettingsClick(view2);
            }
        });
        profileFragment.personalSettingDivider = Utils.m5158a(view, R.id.personalSettingDivider, "field 'personalSettingDivider'");
        profileFragment.mEmail = (TextView) Utils.m5161b(view, R.id.profileEmail, "field 'mEmail'", TextView.class);
        profileFragment.daysLeftInfo = (TextView) Utils.m5161b(view, R.id.daysLeftInfo, "field 'daysLeftInfo'", TextView.class);
        profileFragment.bottomPanel = Utils.m5158a(view, R.id.bottomPanel, "field 'bottomPanel'");
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        ProfileFragment profileFragment = this.f10911b;
        if (profileFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10911b = null;
        profileFragment.contactAdult = null;
        profileFragment.contactChild = null;
        profileFragment.mName = null;
        profileFragment.mNickName = null;
        profileFragment.mLegalGuardianName = null;
        profileFragment.mBirthday = null;
        profileFragment.mTrained = null;
        profileFragment.mPersonalSettings = null;
        profileFragment.mPersonalSettingsRow = null;
        profileFragment.personalSettingDivider = null;
        profileFragment.mEmail = null;
        profileFragment.daysLeftInfo = null;
        profileFragment.bottomPanel = null;
        this.f10912c.setOnClickListener(null);
        this.f10912c = null;
        super.unbind();
    }
}
