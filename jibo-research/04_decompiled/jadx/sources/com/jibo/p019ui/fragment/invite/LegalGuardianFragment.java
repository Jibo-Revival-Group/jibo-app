package com.jibo.p019ui.fragment.invite;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.SetLegalGuardianRequest;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class LegalGuardianFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10448a = LogUtils.m11405a(LegalGuardianFragment.class);

    @BindView
    ImageView avatar;

    @BindView
    TextView email;

    @BindView
    TextView legalGuardianInfo;

    @BindView
    TextView legalGuardianTitle;

    @BindView
    TextView name;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_legal_guardian, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_permission);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        Util.m11492a(this.name, this.f10402m.getAccount() != null ? this.f10402m.getAccount().getFirstName() : "", this.f10402m.getAccount() != null ? this.f10402m.getAccount().getLastName() : "");
        this.email.setText(this.f10402m.getAccount().getEmail());
        this.email.setVisibility(TextUtils.isEmpty(this.f10402m.getAccount().getEmail()) ? 8 : 0);
        Util.m11490a(getActivity(), this.avatar, this.f10402m);
        if (LoopHelper.isOwner(this.f9934k, this.f10402m.getAccountId())) {
            this.legalGuardianTitle.setText(getString(R.string.permission_your_contact_info));
            this.legalGuardianInfo.setText(String.format(getString(R.string.guardian_consent_owner), this.f10398c.getFirstName()));
        } else {
            this.legalGuardianTitle.setText(getString(R.string.permission));
            this.legalGuardianInfo.setText(String.format(getString(R.string.guardian_consent), this.f10398c.getFirstName()));
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        m10720r();
    }

    /* JADX INFO: renamed from: r */
    private void m10720r() {
        SpannableStringBuilder spannableStringBuilderM11487a;
        if (this.f9933j != null) {
            this.f9933j.dismiss();
            this.f9933j = null;
        }
        if (this.f9933j == null) {
            this.f9933j = new CircleProgressFragment();
            if (this.f10402m.getAccountId().equals(EntityData.m10089a(getActivity()).m10134i().getId())) {
                spannableStringBuilderM11487a = new SpannableStringBuilder(getString(R.string.text_sending_email_to_you));
            } else {
                spannableStringBuilderM11487a = Util.m11487a(getString(R.string.text_sending_email_to, this.f10402m.getAccount().getFirstName()), this.f10402m.getAccount().getFirstName());
            }
            this.f9933j.m10508c(spannableStringBuilderM11487a);
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.LegalGuardianFragment.1
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    if (status == CircleProgressFragment.Status.Success) {
                        LegalGuardianFragment.this.getActivity().setResult(-1);
                        LegalGuardianFragment.this.getActivity().finish();
                    }
                    if (SharedPreferencesUtil.m11451k(LegalGuardianFragment.this.getContext())) {
                        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(LegalGuardianFragment.this.getContext(), CongratsFragment.class.getName());
                        builder.m10272a(Account.class.getSimpleName(), (Parcelable) LegalGuardianFragment.this.f10398c);
                        builder.m10273a("ARG_NICKNAME", LegalGuardianFragment.this.f10399d);
                        builder.m10275a(1017);
                    }
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        }
        EntityData.m10089a(getActivity()).m10122b().inviteMember(this.f9934k.getId(), this.f10398c.getEmail(), this.f10398c.getFirstName(), this.f10398c.getLastName(), this.f10398c.getGender(), this.f10398c.getBirthday(), false, true, new AsyncHandler<InviteMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.invite.LegalGuardianFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                LegalGuardianFragment.this.f9933j.m10507b(LegalGuardianFragment.this.getString(R.string.email_failed_to_send));
                LegalGuardianFragment.this.m10338a((Throwable) exc, "invite member", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(InviteMemberRequest inviteMemberRequest, final Loop loop) {
                LegalGuardianFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.LegalGuardianFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (loop != null) {
                            for (Member member : loop.getMembers()) {
                                if (member.getAccount() != null && LegalGuardianFragment.this.f10398c.getFirstName().equals(member.getAccount().getFirstName()) && LegalGuardianFragment.this.f10398c.getLastName().equals(member.getAccount().getLastName()) && member.getAccount().getBirthday() != null && member.getAccount().getBirthday().longValue() == LegalGuardianFragment.this.f10398c.getBirthday().longValue() && member.getAccount().getGender() != null && member.getAccount().getGender().ordinal() == LegalGuardianFragment.this.f10398c.getGender().ordinal() && member.getStatus() != Member.InvitationStatus.removed) {
                                    LegalGuardianFragment.this.m10710b(member);
                                    return;
                                }
                            }
                        }
                        LegalGuardianFragment.this.f9933j.m10507b("");
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10710b(final Member member) {
        EntityData.m10089a(getActivity()).m10122b().setLegalGuardian(this.f9934k.getId(), member.getId(), this.f10402m.getId(), new AsyncHandler<SetLegalGuardianRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.invite.LegalGuardianFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                LegalGuardianFragment.this.f9933j.m10507b(LegalGuardianFragment.this.getString(R.string.email_failed_to_send));
                LegalGuardianFragment.this.m10338a((Throwable) exc, "set legal guardian", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(SetLegalGuardianRequest setLegalGuardianRequest, CommandResponse commandResponse) {
                JiboAnalytics.m9838a(LegalGuardianFragment.this.getActivity(), LegalGuardianFragment.this.f9934k.getRobot(), LegalGuardianFragment.this.f10398c.getBirthday().longValue());
                if (TextUtils.isEmpty(LegalGuardianFragment.this.f10399d)) {
                    if (LegalGuardianFragment.this.f10402m.getAccountId().equals(EntityData.m10089a(LegalGuardianFragment.this.getActivity()).m10134i().getId())) {
                        LegalGuardianFragment.this.f9933j.m10505a(LegalGuardianFragment.this.getString(R.string.legal_guardian_you));
                        return;
                    } else {
                        LegalGuardianFragment.this.f9933j.m10505a(LegalGuardianFragment.this.getString(R.string.legal_guardian_other));
                        return;
                    }
                }
                LegalGuardianFragment.this.mo10672a(member);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    protected void mo10672a(Member member) {
        EntityData.m10089a(getActivity()).m10122b().updateNickname(this.f9934k.getId(), member.getId(), this.f10399d, new AsyncHandler<UpdateNicknameRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.invite.LegalGuardianFragment.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                LegalGuardianFragment.this.f9933j.m10507b("");
                LegalGuardianFragment.this.m10338a((Throwable) exc, "update nickname", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateNicknameRequest updateNicknameRequest, CommandResponse commandResponse) {
                if (LegalGuardianFragment.this.f10402m.getAccountId().equals(EntityData.m10089a(LegalGuardianFragment.this.getActivity()).m10134i().getId())) {
                    LegalGuardianFragment.this.f9933j.m10505a(LegalGuardianFragment.this.getString(R.string.legal_guardian_you));
                } else {
                    LegalGuardianFragment.this.f9933j.m10505a(LegalGuardianFragment.this.getString(R.string.legal_guardian_other));
                }
            }
        });
    }
}
