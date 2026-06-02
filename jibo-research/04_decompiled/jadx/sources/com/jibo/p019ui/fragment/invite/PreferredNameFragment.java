package com.jibo.p019ui.fragment.invite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.helpers.LoopHelper;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.view.proxima.CustomFontEditText;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PreferredNameFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10510a = LogUtils.m11405a(PreferredNameFragment.class);

    @BindView
    View mChangePronunciationName;

    @BindView
    TextView mPreferredNameTip;

    @BindView
    View mViewLoopMembers;

    @BindView
    EditText nickname;

    @BindView
    TextView nicknameSkip;

    /* JADX INFO: renamed from: r */
    private MemberAccount f10511r;

    /* JADX INFO: renamed from: s */
    private boolean f10512s = false;

    /* JADX INFO: renamed from: t */
    private JiboCollisionAsyncClient f10513t;

    /* JADX INFO: renamed from: u */
    private String f10514u;

    /* JADX INFO: renamed from: a */
    public static void m10747a(BaseFragment baseFragment, Loop loop, Member member) {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(baseFragment, PreferredNameFragment.class.getName());
        builder.m10274a("ARGS_SHOULD_RETURN_VALUE", true);
        builder.m10272a(Loop.class.getSimpleName(), (Parcelable) loop);
        builder.m10272a(Member.class.getSimpleName(), (Parcelable) member);
        builder.m10272a(MemberAccount.class.getSimpleName(), (Parcelable) member.getAccount());
        if (member.getNickname() != null) {
            builder.m10273a("ARG_NICKNAME", member.getNickname());
        }
        builder.m10275a(1011);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_preferred_name, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10350l();
        Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
        if (accountM10134i != null) {
            JiboCollisionAsyncClient jiboCollisionAsyncClient = new JiboCollisionAsyncClient(new BasicAWSCredentials(accountM10134i.getAccessKeyId(), accountM10134i.getSecretAccessKey()));
            this.f10513t = jiboCollisionAsyncClient;
            m10336a(jiboCollisionAsyncClient);
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        mo10661b();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10405p.setIcon(R.drawable.ic_check);
        ImageUtils.m11394a(getActivity(), this.f10405p, R.color.white);
        m10752r();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.p019ui.fragment.IBaseFragment
    /* JADX INFO: renamed from: h */
    public boolean mo10346h() {
        ((SingleFragmentActivity) getActivity()).m10268q().putExtra("ARGS_CHOSEN_NICKNAME", this.f10514u);
        return false;
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10512s = bundle.getBoolean("ARGS_SHOULD_RETURN_VALUE");
        this.f10511r = (MemberAccount) bundle.getParcelable(MemberAccount.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.x_white);
        m10352n();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_preferred_name);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        this.f10514u = this.f10399d;
        this.nickname.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter(), new InputFilter.LengthFilter(20)});
        this.nicknameSkip.setVisibility(this.f10512s ? 8 : 0);
        this.nickname.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (PreferredNameFragment.this.nickname != null) {
                    PreferredNameFragment.this.nicknameSkip.setEnabled(PreferredNameFragment.this.nickname.getText().toString().trim().isEmpty());
                    PreferredNameFragment.this.m10752r();
                }
            }
        });
        this.nickname.setText(this.f10399d);
        this.mPreferredNameTip.setTextColor(ImageUtils.m11399b(getActivity(), R.color.black));
        if (!TextUtils.isEmpty(this.f10401l)) {
            this.mPreferredNameTip.setText(getString(R.string.preferred_name_tip, this.f10401l));
        } else {
            TextView textView = this.mPreferredNameTip;
            Object[] objArr = new Object[1];
            objArr[0] = this.f10511r != null ? this.f10511r.getFirstName() : this.f10398c.getFirstName();
            textView.setText(getString(R.string.preferred_name_tip, objArr));
        }
        if (this.f10511r == null) {
            this.mChangePronunciationName.setVisibility(8);
        }
        m10752r();
        if (LoopHelper.getActiveMembersCount(this.f9934k) == 1) {
            this.mViewLoopMembers.setVisibility(8);
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        String firstName;
        m10343e();
        m10339a(false);
        m10675b(false);
        this.f10399d = this.nickname.getText().toString().trim();
        if (this.f10399d.isEmpty()) {
            this.f10399d = null;
        }
        List<String> membersNicknames = LoopHelper.getMembersNicknames(this.f9934k);
        if (this.f10511r != null) {
            membersNicknames.remove(this.f10511r.getFirstName());
            membersNicknames.remove(this.f10514u);
        }
        if (TextUtils.isEmpty(this.f10399d)) {
            firstName = this.f10511r != null ? this.f10511r.getFirstName() : this.f10398c.getFirstName();
        } else {
            firstName = this.f10399d;
        }
        if (membersNicknames.isEmpty() && this.f10512s) {
            ((SingleFragmentActivity) getActivity()).m10268q().putExtra("ARGS_CHOSEN_NICKNAME", this.f10399d);
            ((SingleFragmentActivity) getActivity()).m10268q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", this.f10400e);
            getActivity().finish();
            return;
        }
        this.f10513t.match(membersNicknames, firstName, new AsyncHandler<MatchRequest, CollisionCheckContainer>() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                PreferredNameFragment.this.m10338a((Throwable) exc, "collision match", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(MatchRequest matchRequest, final CollisionCheckContainer collisionCheckContainer) {
                PreferredNameFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PreferredNameFragment.this.mo10345g();
                        PreferredNameFragment.this.m10675b(true);
                        if (!collisionCheckContainer.getCollision().booleanValue()) {
                            if (PreferredNameFragment.this.f10512s) {
                                ((SingleFragmentActivity) PreferredNameFragment.this.getActivity()).m10268q().putExtra("ARGS_CHOSEN_NICKNAME", PreferredNameFragment.this.f10399d);
                                ((SingleFragmentActivity) PreferredNameFragment.this.getActivity()).m10268q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", PreferredNameFragment.this.f10400e);
                                PreferredNameFragment.this.getActivity().finish();
                                return;
                            }
                            UIUtils.m11474a(PreferredNameFragment.this.getActivity(), PreferredNameFragment.this.nickname);
                            if (!DateTimeUtils.isAdult(PreferredNameFragment.this.f10398c.getBirthday())) {
                                if (PreferredNameFragment.this.f10402m == null) {
                                    PreferredNameFragment.this.m10673a(SelectGuardianFragment.class);
                                    return;
                                } else {
                                    PreferredNameFragment.this.m10673a(LegalGuardianFragment.class);
                                    return;
                                }
                            }
                            if (PreferredNameFragment.this.f10404o) {
                                PreferredNameFragment.this.m10673a(EmailFragment.class);
                                return;
                            } else {
                                PreferredNameFragment.this.m10673a(EmailInviteInfoFragment.class);
                                return;
                            }
                        }
                        PreferredNameFragment.this.mPreferredNameTip.setTextColor(ImageUtils.m11399b(PreferredNameFragment.this.getActivity(), R.color.firecracker));
                        if (TextUtils.isEmpty(PreferredNameFragment.this.nickname.getText().toString().trim())) {
                            TextView textView = PreferredNameFragment.this.mPreferredNameTip;
                            PreferredNameFragment preferredNameFragment = PreferredNameFragment.this;
                            Object[] objArr = new Object[1];
                            objArr[0] = PreferredNameFragment.this.f10511r != null ? PreferredNameFragment.this.f10511r.getFirstName() : PreferredNameFragment.this.f10398c.getFirstName();
                            textView.setText(preferredNameFragment.getString(R.string.preferred_name_tip_2, objArr));
                            return;
                        }
                        PreferredNameFragment.this.mPreferredNameTip.setText(PreferredNameFragment.this.getString(R.string.preferred_name_tip_3, Util.m11497c(collisionCheckContainer.getClosestPair())));
                    }
                });
            }
        });
    }

    @OnClick
    public void nicknameSkip(View view) {
        mo10661b();
    }

    @OnClick
    void viewLoopMembers(View view) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Loop.class.getSimpleName(), this.f9934k);
        ((BaseActivity) getActivity()).m10193c(LoopMembersFragment.class, bundle);
    }

    @OnClick
    void changePronunciationName(View view) {
        new Bundle().putParcelable(Member.class.getSimpleName(), this.f10402m);
        NamePronunciationFragment.m10734a(this, this.f9934k, this.f10402m);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1021:
                    String stringExtra = intent.getStringExtra("ARGS_CHOSEN_PHONETIC_NAME");
                    this.f10400e = stringExtra;
                    this.f10402m.setPhoneticName(stringExtra);
                    ((SingleFragmentActivity) getActivity()).m10268q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", stringExtra);
                    break;
            }
            return;
        }
        if (i == 1021) {
            this.f10400e = this.f10402m.getPhoneticName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m10752r() {
        if (!this.f10512s && this.f10405p != null) {
            m10675b(!this.nickname.getText().toString().trim().isEmpty());
        }
    }
}
