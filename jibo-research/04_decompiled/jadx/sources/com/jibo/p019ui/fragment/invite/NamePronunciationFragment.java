package com.jibo.p019ui.fragment.invite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.aws.integration.aws.services.loop.model.UpdatePhoneticNameRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class NamePronunciationFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10490a = LogUtils.m11405a(NamePronunciationFragment.class);

    @BindView
    TextView mPhoneticNameTip;

    @BindView
    EditText mPhoneticNameView;

    @BindView
    TextView mTitleView;

    /* JADX INFO: renamed from: r */
    Member f10491r;

    /* JADX INFO: renamed from: t */
    private CircleProgressFragment f10493t;

    /* JADX INFO: renamed from: v */
    private String f10495v;

    /* JADX INFO: renamed from: u */
    private boolean f10494u = false;

    /* JADX INFO: renamed from: s */
    int f10492s = 0;

    /* JADX INFO: renamed from: a */
    public static void m10734a(BaseFragment baseFragment, Loop loop, Member member) {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(baseFragment, NamePronunciationFragment.class.getName());
        builder.m10274a("ARGS_SHOULD_RETURN_VALUE", true);
        builder.m10272a(Loop.class.getSimpleName(), (Parcelable) loop);
        builder.m10272a(Member.class.getSimpleName(), (Parcelable) member);
        builder.m10272a(MemberAccount.class.getSimpleName(), (Parcelable) member.getAccount());
        if (member.getPhoneticName() != null) {
            builder.m10273a("ARG_PHONETIC_NAME", member.getPhoneticName());
        }
        builder.m10275a(1021);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10492s = 0;
        return layoutInflater.inflate(R.layout.fragment_name_pronunciation, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m10350l();
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
        m10736r();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10494u = bundle.getBoolean("ARGS_SHOULD_RETURN_VALUE");
        this.f10403n = (MemberAccount) bundle.getParcelable(MemberAccount.class.getSimpleName());
        this.f10491r = (Member) bundle.getParcelable(Member.class.getSimpleName());
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
        return getString(R.string.title_name_pronunciation);
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: a */
    public void mo10660a() {
        new InputFilter() { // from class: com.jibo.ui.fragment.invite.NamePronunciationFragment.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    if (Character.isLetter(charSequence.charAt(i))) {
                        i++;
                    } else {
                        return "";
                    }
                }
                return null;
            }
        };
        this.f10495v = this.f10400e;
        this.mPhoneticNameView.setText(this.f10400e);
        if (this.f10491r.getAccountId() != null && !this.f10491r.getAccountId().equalsIgnoreCase(EntityData.m10089a(getActivity()).m10134i().getId())) {
            this.mTitleView.setText(R.string.help_jibo_learn_their_name);
            TextView textView = this.mPhoneticNameTip;
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(this.f10491r.getNickname()) ? this.f10403n.getFirstName() : this.f10491r.getNickname();
            textView.setText(getString(R.string.pronunciation_description, objArr));
        } else {
            this.mTitleView.setText(R.string.help_jibo_learn_your_name);
            this.mPhoneticNameTip.setText(R.string.pronunciation_description_you);
        }
        m10736r();
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment
    /* JADX INFO: renamed from: b */
    public void mo10661b() {
        m10343e();
        if (this.f10493t == null) {
            this.f10493t = new CircleProgressFragment();
            this.f10493t.m10509c(getString(R.string.pronunciation_progress));
            this.f10493t.show(getFragmentManager(), "CircleFragment");
            this.f10493t.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.invite.NamePronunciationFragment.2
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    if (status == CircleProgressFragment.Status.Success && NamePronunciationFragment.this.f10492s == 0) {
                        NamePronunciationFragment.this.f10492s++;
                        new AlertDialog.Builder(NamePronunciationFragment.this.getActivity()).m3220a(R.string.pronunciation_dialog_title).m3231b(R.string.pronunciation_dialog_text).m3221a(android.R.string.ok, (DialogInterface.OnClickListener) null).m3236b().show();
                    }
                }
            });
        }
        this.f10400e = this.mPhoneticNameView.getText().toString().trim();
        EntityData.m10089a(getActivity()).m10122b().updatePhoneticName(this.f9934k.getId(), this.f10402m.getId(), this.f10400e, new AsyncHandler<UpdatePhoneticNameRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.invite.NamePronunciationFragment.3
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                NamePronunciationFragment.this.m10338a((Throwable) exc, "update phonetic name", true);
                NamePronunciationFragment.this.f10493t.m10507b(NamePronunciationFragment.this.getString(R.string.pronunciation_error));
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdatePhoneticNameRequest updatePhoneticNameRequest, CommandResponse commandResponse) {
                NamePronunciationFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.invite.NamePronunciationFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NamePronunciationFragment.this.f10493t.m10505a(NamePronunciationFragment.this.getString(R.string.pronunciation_success));
                        NamePronunciationFragment.this.f10493t = null;
                    }
                });
                ((SingleFragmentActivity) NamePronunciationFragment.this.getActivity()).m10268q().putExtra("ARGS_CHOSEN_PHONETIC_NAME", NamePronunciationFragment.this.f10400e);
                NamePronunciationFragment.this.getActivity().setResult(-1);
            }
        });
    }

    /* JADX INFO: renamed from: r */
    private void m10736r() {
        if (!this.f10494u && this.f10405p != null) {
            m10675b(!this.mPhoneticNameView.getText().toString().trim().isEmpty());
        }
    }
}
