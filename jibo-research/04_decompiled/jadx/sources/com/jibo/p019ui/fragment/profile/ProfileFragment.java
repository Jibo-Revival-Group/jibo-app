package com.jibo.p019ui.fragment.profile;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.aws.services.skills.JiboSkillsAsyncClient;
import com.jibo.aws.integration.aws.services.skills.model.GetSettingsRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.AvatarBaseFragment;
import com.jibo.p019ui.fragment.account.AccountSettingsFragment;
import com.jibo.p019ui.fragment.account.skills.SkillSettingsFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.invite.PreferredNameFragment;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import com.jibo.service.SyncHelper;
import com.jibo.utils.ImageUtils;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class ProfileFragment extends AvatarBaseFragment {

    /* JADX INFO: renamed from: n */
    public static final String f10888n = ProfileFragment.class.getSimpleName();

    @BindView
    View bottomPanel;

    @BindView
    View contactAdult;

    @BindView
    View contactChild;

    @BindView
    TextView daysLeftInfo;

    @BindView
    TextView mBirthday;

    @BindView
    TextView mEmail;

    @BindView
    TextView mLegalGuardianName;

    @BindView
    TextView mName;

    @BindView
    TextView mNickName;

    @BindView
    TextView mPersonalSettings;

    @BindView
    LinearLayout mPersonalSettingsRow;

    @BindView
    TextView mTrained;

    /* JADX INFO: renamed from: o */
    private Member f10889o;

    /* JADX INFO: renamed from: p */
    private boolean f10890p;

    @BindView
    View personalSettingDivider;

    /* JADX INFO: renamed from: r */
    private JiboSkillsAsyncClient f10892r;

    /* JADX INFO: renamed from: q */
    private ArrayList<Loop> f10891q = null;

    /* JADX INFO: renamed from: s */
    private boolean f10893s = true;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        getActivity().setResult(0);
        this.f10890p = LoopHelper.isCurrentUser(this.f10889o, EntityData.m10089a(getActivity()).m10134i());
        if (getArguments() != null && getArguments().containsKey("ARG_LOOPS")) {
            this.f10891q = getArguments().getParcelableArrayList("ARG_LOOPS");
        }
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        JiboSkillsAsyncClient jiboSkillsAsyncClient = new JiboSkillsAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
        this.f10892r = jiboSkillsAsyncClient;
        m10336a(jiboSkillsAsyncClient);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10919w();
        m10918v();
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent != null && intent.getExtras() != null) {
                if (intent.getExtras().getBoolean("ARGS_REMOVED_FROM_LOOP", false)) {
                    getActivity().finish();
                    return;
                }
                if (intent.getExtras().containsKey(Account.class.getSimpleName()) && (intent.getExtras().getParcelable(Account.class.getSimpleName()) instanceof Account)) {
                    Account account = (Account) intent.getExtras().getParcelable(Account.class.getSimpleName());
                    if (account.getPhotoUrl() != null && !account.getPhotoUrl().equals(this.f10889o.getAccount().getPhotoUrl())) {
                        this.f10889o.getAccount().setPhotoUrl(account.getPhotoUrl());
                        mo10326a(this.f10889o.getAccount().getPhotoUrl());
                    }
                    this.f10889o.getAccount().setBirthday(account.getBirthday());
                    this.f10889o.getAccount().setGender(account.getGender());
                    this.f10889o.getAccount().setFirstName(account.getFirstName());
                    this.f10889o.getAccount().setLastName(account.getLastName());
                    SyncHelper.m10178b(getActivity());
                } else if (intent.getExtras().containsKey(Member.class.getSimpleName()) && (intent.getExtras().getParcelable(Member.class.getSimpleName()) instanceof Member)) {
                    Member member = (Member) intent.getExtras().getParcelable(Member.class.getSimpleName());
                    if (member.getAccount().getPhotoUrl() != null && !member.getAccount().getPhotoUrl().equals(this.f10889o.getAccount().getPhotoUrl())) {
                        this.f10889o.getAccount().setPhotoUrl(member.getAccount().getPhotoUrl());
                        mo10326a(this.f10889o.getAccount().getPhotoUrl());
                    }
                    this.f10889o.setPhoneticName(member.getPhoneticName());
                    this.f10889o.setNickname(member.getNickname());
                    this.f10889o.getAccount().setBirthday(member.getAccount().getBirthday());
                    this.f10889o.getAccount().setGender(member.getAccount().getGender());
                    this.f10889o.getAccount().setEmail(member.getAccount().getEmail());
                    this.f10889o.setStatus(member.getStatus());
                    SyncHelper.m10176a(getActivity(), this.f9934k.getId());
                } else if (intent.getExtras().containsKey("ARGS_CHOSEN_NICKNAME")) {
                    if (intent.getExtras().containsKey("ARGS_CHOSEN_PHONETIC_NAME")) {
                        this.f10889o.setPhoneticName(intent.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME"));
                    }
                    String stringExtra = intent.getStringExtra("ARGS_CHOSEN_NICKNAME");
                    if (stringExtra == null || stringExtra.isEmpty()) {
                        stringExtra = null;
                    }
                    m10912c(stringExtra);
                }
                m10918v();
                return;
            }
            return;
        }
        if (i2 == TabbedActivity.f9761c) {
            getActivity().setResult(TabbedActivity.f9761c);
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(final Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f10893s) {
            if (LoopHelper.isOwner(this.f9934k, this.f9918e.getId()) || this.f10890p) {
                menuInflater.inflate(R.menu.menu_action_edit, menu);
                m10341c().postDelayed(new Runnable() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (menu != null && ((MenuBuilder) menu).m3618k() != null && !((MenuBuilder) menu).m3618k().isEmpty()) {
                            final MenuItemImpl menuItemImpl = ((MenuBuilder) menu).m3618k().get(0);
                            if (menuItemImpl.getActionView() != null) {
                                menuItemImpl.getActionView().setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        ProfileFragment.this.onOptionsItemSelected(menuItemImpl);
                                    }
                                });
                            }
                        }
                    }
                }, 100L);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f10890p) {
            if (LoopHelper.isOwner(this.f9934k, this.f9918e.getId())) {
                m10908b(R.layout.popup_self_owner);
            } else {
                m10908b(R.layout.popup_self);
            }
        } else if (LoopHelper.isOwner(this.f9934k, this.f9918e.getId())) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, EditProfileFragment.class.getName());
            builder.m10272a(Member.class.getSimpleName(), (Parcelable) this.f10889o).m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
            builder.m10275a(1008);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Member.class.getSimpleName(), this.f10889o);
        bundle.putBoolean("ARGS_ALLOW_EDIT", this.f10893s);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10889o = (Member) bundle.getParcelable(Member.class.getSimpleName());
        this.f10893s = bundle.getBoolean("ARGS_ALLOW_EDIT", true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        m10351m();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 115 && i2 == -1) {
            m10917u();
        }
    }

    @OnClick
    public void personalSettingsClick(View view) {
        m10344f();
        this.f10892r.getSkillsJson(this.f9934k.getId(), new AsyncHandler<GetSettingsRequest, String>() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ProfileFragment.this.m10338a((Throwable) exc, "skills get skills json", false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v3, types: [int[], java.io.Serializable] */
            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(GetSettingsRequest getSettingsRequest, String str) {
                SkillsJsonParser.getInstance().clearSkills();
                SkillsJsonParser.getInstance().parseSkills(str);
                ProfileFragment.this.mo10345g();
                DataItems.DataItem dataItem = SkillsJsonParser.getInstance().getViews(null).get(0);
                if (!(dataItem instanceof DataItems.GroupDataItem) || (((DataItems.GroupDataItem) dataItem).getChildViews() != null && !((DataItems.GroupDataItem) dataItem).getChildViews().isEmpty())) {
                    SkillsJsonParser.getInstance().selectSkill(0);
                    new SingleFragmentActivity.Builder(ProfileFragment.this.getContext(), SkillSettingsFragment.class.getName()).m10273a("PARAM_PATH", (Serializable) new int[]{0}).m10273a("PARAM_TITLE", dataItem.getTitle()).m10275a(1001);
                }
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m10908b(int i) {
        final PopupWindow popupWindow = new PopupWindow(getActivity());
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        viewInflate.findViewById(R.id.editAccountSetting).setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                popupWindow.dismiss();
                SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(ProfileFragment.this.getActivity(), AccountSettingsFragment.class.getName());
                if (ProfileFragment.this.f10891q != null) {
                    builder.m10273a("ARG_LOOPS", ProfileFragment.this.f10891q);
                }
                builder.m10275a(1001);
            }
        });
        switch (i) {
            case R.layout.popup_self /* 2131427611 */:
                viewInflate.findViewById(R.id.leaveLoop).setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        ProfileFragment.this.m10916t();
                    }
                });
                break;
            case R.layout.popup_self_owner /* 2131427612 */:
                viewInflate.findViewById(R.id.editPreferredName).setOnClickListener(new View.OnClickListener() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        PreferredNameFragment.m10747a(ProfileFragment.this, ProfileFragment.this.f9934k, ProfileFragment.this.f10889o);
                    }
                });
                break;
        }
        popupWindow.setFocusable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(viewInflate);
        if (Build.VERSION.SDK_INT >= 21) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
            popupWindow.setElevation(10.0f);
        } else {
            popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.dialog_holo_light_frame));
        }
        popupWindow.showAtLocation(((BaseActivity) getActivity()).m10197g(), 53, getResources().getDimensionPixelSize(R.dimen.popup_horizontal), getResources().getDimensionPixelSize(R.dimen.popup_vertical));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10916t() {
        DialogUtils.m10520b(this, 115, getString(R.string.leave_loop_confirm), getString(R.string.leave));
    }

    /* JADX INFO: renamed from: u */
    private void m10917u() {
        EntityData.m10089a(getActivity()).m10122b().removeMember(this.f9934k.getId(), this.f10889o.getId(), new AsyncHandler<RemoveMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.6
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ProfileFragment.this.m10338a((Throwable) exc, "remove member", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RemoveMemberRequest removeMemberRequest, final Loop loop) {
                ProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        EntityData.m10089a(ProfileFragment.this.getActivity()).m10123b(loop.getId());
                        ProfileFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m10912c(final String str) {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().updateNickname(this.f9934k.getId(), this.f10889o.getId(), str, new AsyncHandler<UpdateNicknameRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.7
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ProfileFragment.this.m10338a((Throwable) exc, "update nickname", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateNicknameRequest updateNicknameRequest, CommandResponse commandResponse) {
                ProfileFragment.this.f10889o.setNickname(str);
                ProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.ProfileFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProfileFragment.this.mo10345g();
                        ProfileFragment.this.m10918v();
                        SyncHelper.m10176a(ProfileFragment.this.getActivity(), ProfileFragment.this.f9934k.getId());
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v */
    public void m10918v() {
        Member memberByIdOrEmail;
        if (this.f10889o != null && this.f9934k != null) {
            this.f9916c = true;
            if (this.f10889o.getAccount() != null) {
                m10325a(this.f10889o.getAccount());
            }
            this.mName.setText(this.f10889o.getAccount().getFullName());
            if (!TextUtils.isEmpty(this.f10889o.getNickname())) {
                this.mNickName.setText(TokenParser.DQUOTE + this.f10889o.getNickname() + TokenParser.DQUOTE);
            } else {
                this.mNickName.setText("");
            }
            if (DateTimeUtils.isAdult(this.f10889o.getAccount().getBirthday())) {
                this.contactChild.setVisibility(8);
            } else {
                this.contactAdult.setVisibility(8);
                String fullName = "";
                if (!TextUtils.isEmpty(this.f10889o.getLegalGuardianId()) && (memberByIdOrEmail = LoopHelper.getMemberByIdOrEmail(this.f9934k, this.f10889o.getLegalGuardianId())) != null) {
                    fullName = memberByIdOrEmail.getAccount().getFullName();
                }
                this.mLegalGuardianName.setText(fullName);
                if (this.daysLeftInfo.getVisibility() == 0 && this.f10889o.getCreated() != null && this.f10889o.getCreated().longValue() != -1) {
                    this.daysLeftInfo.setText(getString(R.string.text_profile_legal_guardian_days_left, Integer.valueOf(Math.max(0, (int) Math.ceil(((864000000 + this.f10889o.getCreated().longValue()) - System.currentTimeMillis()) / 8.64E7f))), !TextUtils.isEmpty(this.f10889o.getNickname()) ? this.f10889o.getNickname() : this.f10889o.getAccount().getFirstName()));
                }
            }
            if (!TextUtils.isEmpty(this.f10889o.getAccount().getEmail())) {
                this.mEmail.setText(this.f10889o.getAccount().getEmail());
            } else {
                this.mEmail.setText(R.string.not_provided);
            }
            if (this.f10889o.getAccount().getBirthday() != null && this.f10889o.getAccount().getBirthday().longValue() != -1) {
                this.mBirthday.setText(DateTimeUtils.getBirthdayString(this.f10889o.getAccount().getBirthday().longValue(), DateTimeUtils.isAdult(this.f10889o.getAccount().getBirthday()) ? DateTimeUtils.FULL_DATE_FORMAT : DateTimeUtils.CHILD_BIRTH_DATE_FORMAT));
            } else {
                this.mBirthday.setText("");
            }
            if (this.f10889o.getEnrolled().getVoice().booleanValue() && this.f10889o.getEnrolled().getFace().booleanValue()) {
                this.mTrained.setText(R.string.trained);
            } else if (this.f10889o.getEnrolled().getVoice().booleanValue()) {
                this.mTrained.setText(R.string.voice);
            } else if (this.f10889o.getEnrolled().getFace().booleanValue()) {
                this.mTrained.setText(R.string.face);
            } else {
                this.mTrained.setText(R.string.not_trained);
            }
            this.mPersonalSettings.setText(R.string.set_up);
            if (this.f10890p) {
                this.mPersonalSettingsRow.setVisibility(0);
                this.personalSettingDivider.setVisibility(0);
            } else {
                this.mPersonalSettingsRow.setVisibility(8);
                this.personalSettingDivider.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: w */
    private void m10919w() {
        if (this.f10889o != null && this.f9934k != null) {
            AppBarLayout appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar);
            int iM11399b = ImageUtils.m11399b(getActivity(), R.color.owner_profile_primary);
            int iM11399b2 = ImageUtils.m11399b(getActivity(), R.color.owner_profile_primary_dark);
            this.f9915b = R.drawable.avatar_profile_me;
            if (!this.f10890p) {
                if (DateTimeUtils.isAdult(this.f10889o.getAccount().getBirthday())) {
                    iM11399b = ImageUtils.m11399b(getActivity(), R.color.jibo_blue);
                    iM11399b2 = ImageUtils.m11399b(getActivity(), R.color.accent_blue);
                    this.f9915b = R.drawable.avatar_profile_other;
                } else if (LoopHelper.isMemberAccepted(this.f10889o)) {
                    iM11399b = ImageUtils.m11399b(getActivity(), R.color.child_accepted_profile_primary);
                    iM11399b2 = ImageUtils.m11399b(getActivity(), R.color.child_accepted_profile_primary_dark);
                    this.f9915b = R.drawable.avatar_profile_child_accepted;
                    this.bottomPanel.setVisibility(0);
                    this.daysLeftInfo.setVisibility(8);
                } else {
                    iM11399b = ImageUtils.m11399b(getActivity(), R.color.child_pending_profile_primary);
                    iM11399b2 = ImageUtils.m11399b(getActivity(), R.color.child_pending_profile_primary_dark);
                    this.f9915b = R.drawable.avatar_profile_child_pending;
                    this.bottomPanel.setVisibility(8);
                    this.daysLeftInfo.setVisibility(0);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getActivity().getWindow();
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(iM11399b2);
            }
            appBarLayout.setBackgroundColor(iM11399b);
            getView().setBackgroundColor(iM11399b);
        }
    }
}
