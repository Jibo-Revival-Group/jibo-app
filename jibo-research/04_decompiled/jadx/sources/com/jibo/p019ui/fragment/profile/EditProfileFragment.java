package com.jibo.p019ui.fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.RemoveMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberPhotoRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.AvatarBaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.MaterialDatePickerDialogFragment;
import com.jibo.p019ui.fragment.invite.EmailFragment;
import com.jibo.p019ui.fragment.invite.NewEmailFragment;
import com.jibo.p019ui.fragment.invite.PreferredNameFragment;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class EditProfileFragment extends AvatarBaseFragment implements MaterialDatePickerDialogFragment.OnDateChosenListener {

    /* JADX INFO: renamed from: n */
    public static final String f10849n = EditProfileFragment.class.getSimpleName();

    @BindView
    View avatarEdit;

    @BindView
    TextView birthday;

    @BindView
    View btnResendInvite;

    @BindView
    TextView email;

    @BindView
    TextView gender;

    @BindView
    TextView legalGuardianEmail;

    @BindView
    TextView legalGuardianName;

    @BindView
    TextView memberName;

    /* JADX INFO: renamed from: o */
    private Member f10850o;

    @BindView
    TextView preferredName;

    @BindView
    TextView setEmailInfo;

    @BindView
    View settingAddPrefName;

    @BindView
    View settingBirthday;

    @BindView
    View settingEmail;

    @BindView
    View settingGender;

    @BindView
    View settingLegalGuardianEmail;

    @BindView
    View settingLegalGuardianName;

    @BindView
    View settingPrefferedName;

    @BindView
    View settingSetEmail;

    @BindView
    View settingSetPhone;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        getActivity().setResult(0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_edit_profile, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10896t();
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.PhotoBaseFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                mo10327b();
                return;
            }
            if (i == 1011) {
                if (intent != null) {
                    if (intent.hasExtra("ARGS_CHOSEN_PHONETIC_NAME")) {
                        String stringExtra = intent.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME");
                        this.f10850o.setPhoneticName(stringExtra);
                        Intent intent2 = new Intent();
                        intent2.putExtra("ARGS_CHOSEN_PHONETIC_NAME", stringExtra);
                        getActivity().setResult(-1, intent2);
                    }
                    String stringExtra2 = intent.getStringExtra("ARGS_CHOSEN_NICKNAME");
                    if (stringExtra2 == null || stringExtra2.isEmpty()) {
                        stringExtra2 = null;
                    }
                    m10890c(stringExtra2);
                    return;
                }
                return;
            }
            if (i == 1012 && intent != null) {
                m10893d(intent.getStringExtra("ARGS_CHOSEN_EMAIL"));
            } else {
                if (i == 1020) {
                    this.f10850o.getAccount().setEmail(intent.getStringExtra("ARGS_CHOSEN_EMAIL"));
                    this.f10850o.setStatus(Member.InvitationStatus.invited);
                    m10896t();
                    return;
                }
                if (i == 1021) {
                }
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(Member.class.getSimpleName(), this.f10850o);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10850o = (Member) bundle.getParcelable(Member.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        m10352n();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_edit_profile);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment, com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 116) {
            m10898v();
        } else if (i == 108) {
            this.f10850o.getAccount().setGender(Account.Gender.values()[i2]);
            m10883a(this.f10850o);
        }
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment
    /* JADX INFO: renamed from: b */
    protected void mo10329b(String str) {
        super.mo10329b(str);
        if (getActivity() instanceof SingleFragmentActivity) {
            ((SingleFragmentActivity) getActivity()).m10268q().putExtra(Member.class.getSimpleName(), (Parcelable) this.f10850o);
        }
        getActivity().setResult(-1);
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment
    /* JADX INFO: renamed from: b */
    protected void mo10327b() {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().updateMemberPhoto(this.f9934k.getId(), this.f10850o.getId(), new File(this.f9943l), new AsyncHandler<UpdateMemberPhotoRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "update photo", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateMemberPhotoRequest updateMemberPhotoRequest, Loop loop) throws Throwable {
                EditProfileFragment.this.mo10345g();
                if (EditProfileFragment.this.m10342d()) {
                    EntityData.m10089a(EditProfileFragment.this.getActivity()).m10118a(loop, true);
                }
                EditProfileFragment.this.f10850o = LoopHelper.getMemberByIdOrEmail(loop, EditProfileFragment.this.f10850o.getId());
                EditProfileFragment.this.f9943l = EditProfileFragment.this.f10850o.getAccount().getPhotoUrl();
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditProfileFragment.this.mo10329b(EditProfileFragment.this.f9943l);
                        EditProfileFragment.this.mo10326a(EditProfileFragment.this.f9943l);
                    }
                });
            }
        });
    }

    @Override // com.jibo.ui.fragment.dialog.MaterialDatePickerDialogFragment.OnDateChosenListener
    /* JADX INFO: renamed from: a */
    public void mo10374a(long j) {
        this.f10850o.getAccount().setBirthday(Long.valueOf(j));
        m10883a(this.f10850o);
    }

    @OnClick
    public void nicknameClick() {
        PreferredNameFragment.m10747a(this, this.f9934k, this.f10850o);
    }

    @OnClick
    public void nicknameClickEdit() {
        PreferredNameFragment.m10747a(this, this.f9934k, this.f10850o);
    }

    @OnClick
    public void genderClick() {
        DialogUtils.m10512a(this, 108, getString(R.string.label_gender), R.array.gender_titles, this.f10850o.getAccount().getGender().ordinal());
    }

    @OnClick
    public void birthdayClick() {
        long jCurrentTimeMillis;
        MaterialDatePickerDialogFragment materialDatePickerDialogFragment = new MaterialDatePickerDialogFragment();
        Bundle bundle = new Bundle();
        if (this.f10850o.getAccount().getBirthday() != null) {
            if (this.f10850o.getAccount().getBirthday() != null && this.f10850o.getAccount().getBirthday().longValue() != -1) {
                jCurrentTimeMillis = this.f10850o.getAccount().getBirthday().longValue();
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            bundle.putLong("ARGS_DATE", jCurrentTimeMillis);
        }
        bundle.putString("ARGS_TITLE", getString(R.string.text_birthday));
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.add(1, -13);
        calendar.add(6, 1);
        if (!DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday())) {
            bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_child_cant_be_older_13));
            bundle.putLong("ARGS_MIN_VALUE", calendar.getTimeInMillis());
        } else {
            bundle.putString("ARGS_ERROR_TEXT", getString(R.string.error_adult_cant_be_younger_13));
            bundle.putLong("ARGS_MAX_VALUE", calendar.getTimeInMillis() - 86400000);
        }
        materialDatePickerDialogFragment.setArguments(bundle);
        materialDatePickerDialogFragment.setTargetFragment(this, 0);
        materialDatePickerDialogFragment.show(((AppCompatActivity) getContext()).getSupportFragmentManager(), "datePicker");
    }

    @OnClick
    public void setEmailClick() {
        if (TextUtils.isEmpty(this.f10850o.getAccount().getEmail())) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, NewEmailFragment.class.getName());
            builder.m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
            builder.m10272a(Member.class.getSimpleName(), (Parcelable) this.f10850o);
            builder.m10272a(MemberAccount.class.getSimpleName(), (Parcelable) this.f10850o.getAccount());
            builder.m10271a("ARG_MODE", EmailFragment.LaunchMode.add_email.ordinal());
            builder.m10275a(1020);
            return;
        }
        m10897u();
    }

    @OnClick
    public void resendInviteClick() {
        if (TextUtils.isEmpty(this.f10850o.getAccount().getEmail())) {
            SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, EmailFragment.class.getName());
            builder.m10272a(Loop.class.getSimpleName(), (Parcelable) this.f9934k);
            builder.m10272a(MemberAccount.class.getSimpleName(), (Parcelable) this.f10850o.getAccount());
            builder.m10271a("ARG_MODE", EmailFragment.LaunchMode.return_email.ordinal());
            builder.m10275a(1012);
            return;
        }
        m10897u();
    }

    @OnClick
    public void removeFromLoopClick() {
        DialogUtils.m10514a(this, 116, getString(R.string.dialog_title_remove_from_loop, this.f10850o.getAccount().getFirstName()), getString(R.string.dialog_msg_remove_from_loop, this.f10850o.getAccount().getFirstName(), this.f10850o.getAccount().getFirstName()), getString(R.string.remove));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10896t() {
        Member memberByIdOrEmail;
        if (DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday()) && (LoopHelper.isMemberAccepted(this.f10850o) || LoopHelper.isMemberInvited(this.f10850o))) {
            this.settingGender.setClickable(false);
            this.settingBirthday.setClickable(false);
            this.settingSetEmail.setClickable(false);
            this.settingSetPhone.setClickable(false);
            this.f9916c = true;
            this.avatarEdit.setVisibility(8);
        } else {
            this.f9916c = false;
            this.avatarEdit.setVisibility(0);
        }
        this.memberName.setText(this.f10850o.getAccount().getFullName());
        if (!TextUtils.isEmpty(this.f10850o.getNickname())) {
            this.preferredName.setText(TokenParser.DQUOTE + this.f10850o.getNickname() + TokenParser.DQUOTE);
            this.settingAddPrefName.setVisibility(8);
            this.settingPrefferedName.setVisibility(0);
        } else {
            this.settingPrefferedName.setVisibility(8);
            this.settingAddPrefName.setVisibility(0);
        }
        this.gender.setText(getResources().getStringArray(R.array.gender_values)[this.f10850o.getAccount().getGender().ordinal()]);
        if (this.f10850o.getAccount().getBirthday() != null) {
            this.birthday.setText(DateTimeUtils.getBirthdayString(this.f10850o.getAccount().getBirthday().longValue(), DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday()) ? DateTimeUtils.FULL_DATE_FORMAT : DateTimeUtils.CHILD_BIRTH_DATE_FORMAT));
        }
        if (DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday())) {
            this.settingLegalGuardianName.setVisibility(8);
            this.settingLegalGuardianEmail.setVisibility(8);
            if (!TextUtils.isEmpty(this.f10850o.getAccount().getEmail())) {
                this.email.setText(this.f10850o.getAccount().getEmail());
                this.settingEmail.setVisibility(0);
                this.settingSetEmail.setVisibility(8);
                this.btnResendInvite.setVisibility(LoopHelper.isMemberAccepted(this.f10850o) ? 8 : 0);
            } else {
                this.settingEmail.setVisibility(8);
                this.settingSetEmail.setVisibility(0);
                this.setEmailInfo.setText(getString(R.string.text_send_email_info, this.f10850o.getAccount().getFirstName()));
            }
            this.f9915b = R.drawable.avatar_profile_other;
        } else {
            this.settingSetEmail.setVisibility(8);
            this.settingEmail.setVisibility(8);
            this.settingSetPhone.setVisibility(8);
            this.settingLegalGuardianName.setVisibility(0);
            this.settingLegalGuardianEmail.setVisibility(0);
            String fullName = "";
            String email = "";
            if (!TextUtils.isEmpty(this.f10850o.getLegalGuardianId()) && (memberByIdOrEmail = LoopHelper.getMemberByIdOrEmail(this.f9934k, this.f10850o.getLegalGuardianId())) != null) {
                fullName = memberByIdOrEmail.getAccount().getFullName();
                email = memberByIdOrEmail.getAccount().getEmail();
            }
            this.legalGuardianName.setText(fullName);
            this.legalGuardianEmail.setText(email);
            this.f9915b = LoopHelper.isMemberAccepted(this.f10850o) ? R.drawable.avatar_profile_child_accepted : R.drawable.avatar_profile_child_pending;
        }
        if (this.f10850o.getAccount() != null) {
            m10325a(this.f10850o.getAccount());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10883a(Member member) {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().updateMember(this.f9934k.getId(), this.f10850o.getId(), this.f10850o.getAccount().getEmail(), this.f10850o.getAccount().getFirstName(), this.f10850o.getAccount().getLastName(), this.f10850o.getAccount().getGender(), this.f10850o.getAccount().getBirthday(), Boolean.valueOf(DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday())), new AsyncHandler<UpdateMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "update member", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateMemberRequest updateMemberRequest, Loop loop) throws Throwable {
                if (EditProfileFragment.this.m10342d()) {
                    EntityData.m10089a(EditProfileFragment.this.getActivity()).m10118a(loop, true);
                }
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditProfileFragment.this.mo10345g();
                        EditProfileFragment.this.m10896t();
                        if (EditProfileFragment.this.getActivity() instanceof SingleFragmentActivity) {
                            ((SingleFragmentActivity) EditProfileFragment.this.getActivity()).m10268q().putExtra(Member.class.getSimpleName(), (Parcelable) EditProfileFragment.this.f10850o);
                        }
                        EditProfileFragment.this.getActivity().setResult(-1);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m10890c(final String str) {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().updateNickname(this.f9934k.getId(), this.f10850o.getId(), str, new AsyncHandler<UpdateNicknameRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "update nickname", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateNicknameRequest updateNicknameRequest, CommandResponse commandResponse) {
                EditProfileFragment.this.mo10345g();
                EditProfileFragment.this.f10850o.setNickname(str);
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditProfileFragment.this.m10896t();
                        ((SingleFragmentActivity) EditProfileFragment.this.getActivity()).m10268q().putExtra(Member.class.getSimpleName(), (Parcelable) EditProfileFragment.this.f10850o);
                        EditProfileFragment.this.getActivity().setResult(-1);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private void m10893d(final String str) {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().updateMember(this.f10850o.getLoopId(), this.f10850o.getId(), str, null, null, null, null, Boolean.valueOf(DateTimeUtils.isAdult(this.f10850o.getAccount().getBirthday())), new AsyncHandler<UpdateMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "update member account", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateMemberRequest updateMemberRequest, Loop loop) {
                EditProfileFragment.this.mo10345g();
                EditProfileFragment.this.f10850o.getAccount().setEmail(str);
                EditProfileFragment.this.f10850o.setStatus(Member.InvitationStatus.invited);
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EditProfileFragment.this.m10896t();
                        if (EditProfileFragment.this.getActivity() instanceof SingleFragmentActivity) {
                            ((SingleFragmentActivity) EditProfileFragment.this.getActivity()).m10268q().putExtra(Member.class.getSimpleName(), (Parcelable) EditProfileFragment.this.f10850o);
                        }
                        EditProfileFragment.this.getActivity().setResult(-1);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: u */
    private void m10897u() {
        EntityData.m10089a(getActivity()).m10122b().inviteMember(this.f10850o.getLoopId(), this.f10850o.getAccount().getEmail(), null, null, null, null, false, false, new AsyncHandler<InviteMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.5
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "invite member", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(InviteMemberRequest inviteMemberRequest, Loop loop) {
                EditProfileFragment.this.f10850o.setStatus(Member.InvitationStatus.invited);
                EditProfileFragment.this.mo10345g();
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Snackbar.m803a(EditProfileFragment.this.avatar, R.string.email_sent, 0).m490c();
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: v */
    private void m10898v() {
        m10344f();
        EntityData.m10089a(getActivity()).m10122b().removeMember(this.f10850o.getLoopId(), this.f10850o.getId(), new AsyncHandler<RemoveMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.6
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EditProfileFragment.this.m10338a((Throwable) exc, "remove member", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RemoveMemberRequest removeMemberRequest, final Loop loop) {
                EditProfileFragment.this.mo10345g();
                EditProfileFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.profile.EditProfileFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() throws Throwable {
                        EntityData.m10089a(EditProfileFragment.this.getActivity()).m10118a(loop, true);
                        Intent intent = new Intent();
                        intent.putExtra("ARGS_REMOVED_FROM_LOOP", true);
                        EditProfileFragment.this.getActivity().setResult(-1, intent);
                        EditProfileFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }
}
