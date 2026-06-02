package com.jibo.p019ui.fragment.invite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.InviteMemberRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.UpdateNicknameRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLoopInviteFragment extends BaseFragment {

    /* JADX INFO: renamed from: b */
    Boolean f10397b;

    /* JADX INFO: renamed from: c */
    Account f10398c;

    /* JADX INFO: renamed from: d */
    String f10399d;

    /* JADX INFO: renamed from: e */
    String f10400e;

    /* JADX INFO: renamed from: l */
    String f10401l;

    /* JADX INFO: renamed from: m */
    Member f10402m;

    /* JADX INFO: renamed from: n */
    MemberAccount f10403n;

    /* JADX INFO: renamed from: o */
    boolean f10404o;

    /* JADX INFO: renamed from: p */
    MenuItem f10405p;

    /* JADX INFO: renamed from: q */
    int f10406q;

    /* JADX INFO: renamed from: a */
    public abstract void mo10660a();

    /* JADX INFO: renamed from: b */
    public abstract void mo10661b();

    /* JADX INFO: renamed from: b */
    private void m10666b(Class cls, Bundle bundle) {
        if (this.f9934k != null) {
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        }
        if (this.f10398c != null) {
            bundle.putParcelable(Account.class.getSimpleName(), this.f10398c);
        }
        if (this.f10397b != null) {
            bundle.putBoolean("ARG_IS_CHILD", this.f10397b.booleanValue());
        }
        if (this.f10399d != null) {
            bundle.putString("ARG_NICKNAME", this.f10399d);
        }
        if (this.f10401l != null) {
            bundle.putString("ARG_NAME", this.f10399d);
        }
        if (this.f10400e != null) {
            bundle.putString("ARG_PHONETIC_NAME", this.f10400e);
        }
        if (this.f10402m != null) {
            bundle.putParcelable(Member.class.getSimpleName(), this.f10402m);
        }
        if (this.f10397b != null) {
            bundle.putBoolean("ARG_IS_PARENT", this.f10404o);
        }
        if (this.f10403n != null) {
            bundle.putParcelable(MemberAccount.class.getSimpleName(), this.f10403n);
        }
        ((BaseActivity) getActivity()).m10193c(cls, bundle);
    }

    /* JADX INFO: renamed from: a */
    public void m10674a(Class cls, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        m10666b(cls, bundle);
    }

    /* JADX INFO: renamed from: a */
    public void m10673a(Class cls) {
        m10666b(cls, new Bundle());
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10398c = this.f10398c == null ? new Account() : this.f10398c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f10406q = displayMetrics.widthPixels;
        setHasOptionsMenu(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        mo10660a();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle.containsKey(Account.class.getSimpleName())) {
            this.f10398c = (Account) bundle.getParcelable(Account.class.getSimpleName());
        }
        if (bundle.containsKey("ARG_IS_CHILD")) {
            this.f10397b = Boolean.valueOf(bundle.getBoolean("ARG_IS_CHILD", false));
        }
        if (bundle.containsKey("ARG_IS_PARENT")) {
            this.f10404o = bundle.getBoolean("ARG_IS_PARENT", false);
        }
        if (bundle.containsKey("ARG_NICKNAME")) {
            this.f10399d = bundle.getString("ARG_NICKNAME");
        }
        if (bundle.containsKey("ARG_PHONETIC_NAME")) {
            this.f10400e = bundle.getString("ARG_PHONETIC_NAME");
        }
        if (bundle.containsKey("ARG_NAME")) {
            this.f10401l = bundle.getString("ARG_NAME");
        }
        if (bundle.containsKey(Member.class.getSimpleName())) {
            this.f10402m = (Member) bundle.getParcelable(Member.class.getSimpleName());
        }
        if (bundle.containsKey(MemberAccount.class.getSimpleName())) {
            this.f10403n = (MemberAccount) bundle.getParcelable(MemberAccount.class.getSimpleName());
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        m10352n();
    }

    /* JADX INFO: renamed from: b */
    public void m10675b(boolean z) {
        if (this.f10405p != null) {
            this.f10405p.setEnabled(z);
            ImageUtils.m11394a(getActivity(), this.f10405p, this.f10405p.isEnabled() ? R.color.white : R.color.charlotte);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f10398c != null) {
            bundle.putParcelable(Account.class.getSimpleName(), this.f10398c);
        }
        if (this.f10397b != null) {
            bundle.putBoolean("ARG_IS_CHILD", this.f10397b.booleanValue());
        }
        if (this.f10399d != null) {
            bundle.putString("ARG_NICKNAME", this.f10399d);
        }
        if (this.f10400e != null) {
            bundle.putString("ARG_PHONETIC_NAME", this.f10400e);
        }
        if (this.f10401l != null) {
            bundle.putString("ARG_NAME", this.f10401l);
        }
        if (this.f10402m != null) {
            bundle.putParcelable(Member.class.getSimpleName(), this.f10402m);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_done, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        ImageUtils.m11393a(getActivity(), menu);
        this.f10405p = menu.findItem(R.id.action_done);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        mo10661b();
        return true;
    }

    /* JADX INFO: renamed from: q */
    protected void m10676q() {
        String string;
        if (this.f9933j == null) {
            JiboAnalytics.m9838a(getActivity(), this.f9934k.getRobot(), this.f10398c.getBirthday().longValue());
            this.f9933j = new CircleProgressFragment();
            if (this.f10398c.getEmail() != null && !this.f10398c.getEmail().isEmpty()) {
                string = getString(R.string.sending_gallery_invite);
            } else {
                string = getString(R.string.text_adding, this.f10398c.getFirstName());
            }
            this.f9933j.m10509c(string);
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.BaseLoopInviteFragment.1
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    Intent intent = new Intent();
                    if (status == CircleProgressFragment.Status.Success && BaseLoopInviteFragment.this.f10402m != null && BaseLoopInviteFragment.this.f10404o) {
                        intent.putExtra(Member.class.getSimpleName(), (Parcelable) BaseLoopInviteFragment.this.f10402m);
                    }
                    BaseLoopInviteFragment.this.getActivity().setResult(-1, intent);
                    BaseLoopInviteFragment.this.getActivity().finish();
                    if (SharedPreferencesUtil.m11451k(BaseLoopInviteFragment.this.getContext())) {
                        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(BaseLoopInviteFragment.this.getContext(), CongratsFragment.class.getName());
                        builder.m10272a(Account.class.getSimpleName(), (Parcelable) BaseLoopInviteFragment.this.f10398c);
                        builder.m10273a("ARG_NICKNAME", BaseLoopInviteFragment.this.f10399d);
                        builder.m10275a(1017);
                    }
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        }
        EntityData.m10089a(getActivity()).m10122b().inviteMember(this.f9934k.getId(), this.f10398c.getEmail(), this.f10398c.getFirstName(), this.f10398c.getLastName(), this.f10398c.getGender(), this.f10398c.getBirthday(), Boolean.valueOf(this.f10404o), false, new AsyncHandler<InviteMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.invite.BaseLoopInviteFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                BaseLoopInviteFragment.this.f9933j.m10507b(TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail()) ? "" : BaseLoopInviteFragment.this.getString(R.string.gallery_invite_failed));
                BaseLoopInviteFragment.this.m10338a((Throwable) exc, "invite member", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(InviteMemberRequest inviteMemberRequest, Loop loop) {
                boolean z;
                if (loop == null) {
                    z = false;
                } else {
                    for (Member member : loop.getMembers()) {
                        if (member.getAccount() != null && !LoopHelper.isMemberRemoved(member)) {
                            if (!TextUtils.isEmpty(member.getAccount().getEmail()) && !TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail())) {
                                if (BaseLoopInviteFragment.this.f10398c.getEmail().equalsIgnoreCase(member.getAccount().getEmail())) {
                                    m10677a(member);
                                    z = true;
                                    break;
                                }
                            } else if (TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail()) && BaseLoopInviteFragment.this.f10398c.getFirstName().equalsIgnoreCase(member.getAccount().getFirstName()) && BaseLoopInviteFragment.this.f10398c.getLastName().equalsIgnoreCase(member.getAccount().getLastName()) && member.getAccount().getBirthday() != null && member.getAccount().getBirthday().longValue() == BaseLoopInviteFragment.this.f10398c.getBirthday().longValue() && BaseLoopInviteFragment.this.f10398c.getGender().compareTo(member.getAccount().getGender()) == 0) {
                                m10677a(member);
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                }
                if (!z || loop == null) {
                    BaseLoopInviteFragment.this.f9933j.m10507b(TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail()) ? "" : BaseLoopInviteFragment.this.getString(R.string.gallery_invite_failed));
                }
            }

            /* JADX INFO: renamed from: a */
            private void m10677a(Member member) {
                try {
                    BaseLoopInviteFragment.this.mo10672a(member);
                } catch (Exception e) {
                    if (e instanceof AmazonServiceException) {
                        BaseLoopInviteFragment.this.m10338a((Throwable) e, ((AmazonServiceException) e).getServiceName(), false);
                    }
                    BaseLoopInviteFragment.this.f9933j.m10507b("");
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected void mo10672a(Member member) {
        if (m10342d() && this.f10404o && !TextUtils.isEmpty(this.f10398c.getEmail())) {
            this.f10402m = member;
            SharedPreferencesUtil.m11431a(getActivity(), member.getId());
        }
        EntityData.m10089a(getActivity()).m10122b().updateNickname(this.f9934k.getId(), member.getId(), this.f10399d, new AsyncHandler<UpdateNicknameRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.invite.BaseLoopInviteFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                BaseLoopInviteFragment.this.f9933j.m10507b(TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail()) ? "" : BaseLoopInviteFragment.this.getString(R.string.email_failed_to_send));
                BaseLoopInviteFragment.this.m10338a((Throwable) exc, "update nickname", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateNicknameRequest updateNicknameRequest, CommandResponse commandResponse) {
                if (TextUtils.isEmpty(BaseLoopInviteFragment.this.f10398c.getEmail())) {
                    BaseLoopInviteFragment.this.f9933j.m10505a(BaseLoopInviteFragment.this.getString(R.string.text_added));
                } else {
                    BaseLoopInviteFragment.this.f9933j.m10505a(BaseLoopInviteFragment.this.getString(R.string.gallery_invite_success));
                }
            }
        });
    }
}
