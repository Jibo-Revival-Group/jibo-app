package com.jibo.p019ui.fragment.invite;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.UpdateMemberRequest;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.AlreadyInTheLoopDialog;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.LogUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.UIUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EmailFragment extends BaseSuggestionFragment {

    /* JADX INFO: renamed from: r */
    public static final String f10428r = LogUtils.m11405a(EmailFragment.class);

    @BindView
    AutoCompleteTextView email;

    @BindView
    TextView footer;

    /* JADX INFO: renamed from: s */
    private Member f10429s;

    /* JADX INFO: renamed from: t */
    private LaunchMode f10430t = LaunchMode.send_invite;

    @BindView
    TextView title;

    public enum LaunchMode {
        send_invite,
        return_email,
        set_email,
        add_email
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_email_new, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10350l();
        m10343e();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseSuggestionFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10410a.f10415a = true;
        this.email.setAdapter(this.f10410a);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ARG_MODE", this.f10430t.ordinal());
        bundle.putParcelable(Member.class.getSimpleName(), this.f10429s);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle.containsKey("ARG_MODE")) {
            this.f10430t = LaunchMode.values()[bundle.getInt("ARG_MODE")];
        }
        this.f10429s = (Member) bundle.getParcelable(Member.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.arrow_white);
        m10351m();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return this.f10404o ? getString(R.string.title_app_access) : getString(R.string.invite_to_gallery);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        String firstName = this.f10399d;
        if (TextUtils.isEmpty(firstName) && this.f10403n != null) {
            firstName = this.f10403n.getFirstName();
        }
        if (TextUtils.isEmpty(firstName) && this.f10429s != null && this.f10429s.getAccount() != null) {
            firstName = this.f10429s.getAccount().getFirstName();
        }
        if (TextUtils.isEmpty(firstName) && this.f10398c != null) {
            firstName = this.f10398c.getFirstName();
        }
        this.title.setText(getString(R.string.someones_email, firstName));
        this.email.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.invite.EmailFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                EmailFragment.this.m10702v();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.email.setText(this.f10398c.getEmail());
        this.email.requestFocus();
        UIUtils.m11480b(getActivity(), this.email);
        if (this.f10404o) {
            this.footer.setVisibility(0);
            this.footer.setText(getString(R.string.email_parent_footer, firstName));
        } else if (this.f10430t == LaunchMode.add_email) {
            this.footer.setVisibility(0);
            this.footer.setText(getString(R.string.email_add_email_footer, firstName));
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        this.f10398c.setEmail(this.email.getText().toString());
        if (this.f10430t == LaunchMode.add_email) {
            this.f10429s.getAccount().setEmail(this.email.getText().toString());
            m10699s();
        } else {
            m10703r();
        }
        this.email.setText("");
    }

    /* JADX INFO: renamed from: r */
    public void m10703r() {
        m10343e();
        this.f10398c.setEmail(this.email.getText().toString());
        if (m10701u()) {
            AlreadyInTheLoopDialog alreadyInTheLoopDialog = new AlreadyInTheLoopDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
            bundle.putParcelable(Account.class.getSimpleName(), this.f10398c);
            alreadyInTheLoopDialog.setArguments(bundle);
            alreadyInTheLoopDialog.show(getActivity().getSupportFragmentManager(), AlreadyInTheLoopDialog.class.getSimpleName());
            return;
        }
        if (this.f10430t == LaunchMode.return_email) {
            Intent intent = new Intent();
            intent.putExtra("ARGS_CHOSEN_EMAIL", this.email.getText().toString());
            getActivity().setResult(-1, intent);
            getActivity().finish();
            return;
        }
        if (this.f10430t == LaunchMode.send_invite) {
            m10676q();
        } else {
            m10700t();
        }
    }

    /* JADX INFO: renamed from: s */
    private void m10699s() {
        if (m10701u()) {
            AlreadyInTheLoopDialog alreadyInTheLoopDialog = new AlreadyInTheLoopDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
            bundle.putParcelable(Account.class.getSimpleName(), this.f10398c);
            alreadyInTheLoopDialog.setArguments(bundle);
            alreadyInTheLoopDialog.show(getActivity().getSupportFragmentManager(), AlreadyInTheLoopDialog.class.getSimpleName());
            return;
        }
        if (this.f9933j == null) {
            this.f9933j = new CircleProgressFragment();
            this.f9933j.m10509c(getString(R.string.sending_gallery_invite));
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.EmailFragment.2
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    EmailFragment.this.getActivity().setResult(-1, new Intent());
                    EmailFragment.this.getActivity().finish();
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        }
        EntityData.m10089a(getActivity()).m10122b().updateMember(this.f9934k.getId(), this.f10429s.getId(), this.f10429s.getAccount().getEmail(), null, null, null, null, Boolean.valueOf(!DateTimeUtils.isAdult(this.f10429s.getAccount().getBirthday())), new AsyncHandler<UpdateMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.invite.EmailFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EmailFragment.this.m10338a((Throwable) exc, "sending gallery invite", true);
                EmailFragment.this.f9933j.m10507b(EmailFragment.this.getString(R.string.gallery_invite_failed));
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(final UpdateMemberRequest updateMemberRequest, Loop loop) {
                EmailFragment.this.f9933j.m10505a(EmailFragment.this.getString(R.string.gallery_invite_success));
                EmailFragment.this.f10429s.setStatus(Member.InvitationStatus.invited);
                EmailFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.EmailFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra("ARGS_CHOSEN_EMAIL", updateMemberRequest.getEmail());
                        EmailFragment.this.getActivity().setResult(-1, intent);
                        EmailFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10405p.setTitle(R.string.btnSend);
        this.f10405p.setIcon((Drawable) null);
        m10702v();
    }

    /* JADX INFO: renamed from: t */
    private void m10700t() {
        if (this.f9933j == null) {
            this.f9933j = new CircleProgressFragment();
            this.f9933j.m10509c(getString(R.string.text_sending_invite_to, this.f10402m.getAccount().getFirstName()));
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.EmailFragment.4
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    Intent intent = new Intent();
                    intent.putExtra(Member.class.getSimpleName(), (Parcelable) EmailFragment.this.f10402m);
                    EmailFragment.this.getActivity().setResult(-1, intent);
                    EmailFragment.this.getActivity().finish();
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        }
        EntityData.m10089a(getActivity()).m10122b().updateMember(this.f9934k.getId(), this.f10402m.getId(), this.f10398c.getEmail(), null, null, null, null, false, new AsyncHandler<UpdateMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.invite.EmailFragment.5
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                EmailFragment.this.f9933j.m10507b(EmailFragment.this.getString(R.string.email_failed_to_send));
                EmailFragment.this.m10338a((Throwable) exc, "update member account", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateMemberRequest updateMemberRequest, Loop loop) {
                if (EmailFragment.this.m10342d()) {
                    SharedPreferencesUtil.m11431a(EmailFragment.this.getActivity(), EmailFragment.this.f10402m.getId());
                }
                EmailFragment.this.f9933j.m10505a(EmailFragment.this.getString(R.string.email_sent));
            }
        });
    }

    /* JADX INFO: renamed from: u */
    private boolean m10701u() {
        List<Member> members = this.f9934k.getMembers();
        if (members == null || members.isEmpty() || members.size() <= 2) {
            return false;
        }
        for (Member member : members) {
            if (member.getAccount() != null && this.f10398c.getEmail().equals(member.getAccount().getEmail()) && !LoopHelper.isMemberDeclined(member) && !LoopHelper.isMemberRemoved(member)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v */
    public void m10702v() {
        boolean z = !this.email.getText().toString().trim().isEmpty() && Commons.f11676a.matcher(this.email.getText().toString().trim()).matches();
        if (this.f10405p != null) {
            this.f10405p.setEnabled(z);
        }
    }
}
