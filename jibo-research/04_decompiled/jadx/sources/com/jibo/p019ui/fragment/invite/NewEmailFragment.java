package com.jibo.p019ui.fragment.invite;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.jibo.p019ui.fragment.invite.EmailFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewEmailFragment extends BaseSuggestionFragment {

    /* JADX INFO: renamed from: r */
    public static final String f10501r = LogUtils.m11405a(NewEmailFragment.class);

    @BindView
    AutoCompleteTextView email;

    @BindView
    TextView footer;

    /* JADX INFO: renamed from: s */
    private Member f10502s;

    /* JADX INFO: renamed from: t */
    private EmailFragment.LaunchMode f10503t = EmailFragment.LaunchMode.send_invite;

    @BindView
    TextView title;

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
        bundle.putInt("ARG_MODE", this.f10503t.ordinal());
        bundle.putParcelable(Member.class.getSimpleName(), this.f10502s);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        if (bundle.containsKey("ARG_MODE")) {
            this.f10503t = EmailFragment.LaunchMode.values()[bundle.getInt("ARG_MODE")];
        }
        this.f10502s = (Member) bundle.getParcelable(Member.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowCustomEnabled(true);
        m10351m();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.invite_to_gallery);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        String firstName = this.f10399d;
        if (TextUtils.isEmpty(firstName) && this.f10403n != null) {
            firstName = this.f10403n.getFirstName();
        }
        if (TextUtils.isEmpty(firstName) && this.f10502s != null && this.f10502s.getAccount() != null) {
            firstName = this.f10502s.getAccount().getFirstName();
        }
        if (TextUtils.isEmpty(firstName) && this.f10398c != null) {
            firstName = this.f10398c.getFirstName();
        }
        this.title.setText(getString(R.string.someones_email, firstName));
        this.email.requestFocus();
        UIUtils.m11480b(getActivity(), this.email);
        this.email.setText(this.f10403n.getEmail());
        this.email.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.invite.NewEmailFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                NewEmailFragment.this.m10745t();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        if (this.f10503t == EmailFragment.LaunchMode.add_email) {
            this.footer.setVisibility(0);
            this.footer.setText(getString(R.string.email_add_email_footer, firstName));
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        this.f10502s.getAccount().setEmail(this.email.getText().toString());
        this.email.setText("");
        m10743r();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10405p.setTitle(R.string.btnSend);
        this.f10405p.setIcon((Drawable) null);
        m10745t();
    }

    /* JADX INFO: renamed from: r */
    private void m10743r() {
        if (m10744s()) {
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
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.NewEmailFragment.2
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    NewEmailFragment.this.getActivity().setResult(-1, new Intent());
                    NewEmailFragment.this.getActivity().finish();
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
        }
        EntityData.m10089a(getActivity()).m10122b().updateMember(this.f9934k.getId(), this.f10502s.getId(), this.f10502s.getAccount().getEmail(), null, null, null, null, Boolean.valueOf(!DateTimeUtils.isAdult(this.f10502s.getAccount().getBirthday())), new AsyncHandler<UpdateMemberRequest, Loop>() { // from class: com.jibo.ui.fragment.invite.NewEmailFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                NewEmailFragment.this.m10338a((Throwable) exc, "sending gallery invite", true);
                NewEmailFragment.this.f9933j.m10507b(NewEmailFragment.this.getString(R.string.gallery_invite_failed));
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(final UpdateMemberRequest updateMemberRequest, Loop loop) {
                NewEmailFragment.this.f9933j.m10505a(NewEmailFragment.this.getString(R.string.gallery_invite_success));
                NewEmailFragment.this.f10502s.setStatus(Member.InvitationStatus.invited);
                NewEmailFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.NewEmailFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra("ARGS_CHOSEN_EMAIL", updateMemberRequest.getEmail());
                        NewEmailFragment.this.getActivity().setResult(-1, intent);
                        NewEmailFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: s */
    private boolean m10744s() {
        List<Member> members = this.f9934k.getMembers();
        if (members == null || members.isEmpty() || members.size() <= 2) {
            return false;
        }
        for (Member member : members) {
            if (member.getAccount() != null && this.f10502s.getAccount().getEmail().equals(member.getAccount().getEmail()) && !LoopHelper.isMemberDeclined(member) && !LoopHelper.isMemberRemoved(member)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10745t() {
        this.f10405p.setEnabled(!this.email.getText().toString().trim().isEmpty() && Commons.f11676a.matcher(this.email.getText().toString().trim()).matches());
    }
}
