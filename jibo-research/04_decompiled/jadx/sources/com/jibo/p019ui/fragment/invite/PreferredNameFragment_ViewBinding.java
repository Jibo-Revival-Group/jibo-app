package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class PreferredNameFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private PreferredNameFragment f10519b;

    /* JADX INFO: renamed from: c */
    private View f10520c;

    /* JADX INFO: renamed from: d */
    private View f10521d;

    /* JADX INFO: renamed from: e */
    private View f10522e;

    public PreferredNameFragment_ViewBinding(final PreferredNameFragment preferredNameFragment, View view) {
        this.f10519b = preferredNameFragment;
        preferredNameFragment.nickname = (EditText) Utils.m5161b(view, R.id.nickname, "field 'nickname'", EditText.class);
        View viewM5158a = Utils.m5158a(view, R.id.nickname_skip, "field 'nicknameSkip' and method 'nicknameSkip'");
        preferredNameFragment.nicknameSkip = (TextView) Utils.m5162c(viewM5158a, R.id.nickname_skip, "field 'nicknameSkip'", TextView.class);
        this.f10520c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                preferredNameFragment.nicknameSkip(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.viewLoopMembers, "field 'mViewLoopMembers' and method 'viewLoopMembers'");
        preferredNameFragment.mViewLoopMembers = viewM5158a2;
        this.f10521d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                preferredNameFragment.viewLoopMembers(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.changePronunciationName, "field 'mChangePronunciationName' and method 'changePronunciationName'");
        preferredNameFragment.mChangePronunciationName = viewM5158a3;
        this.f10522e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.PreferredNameFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                preferredNameFragment.changePronunciationName(view2);
            }
        });
        preferredNameFragment.mPreferredNameTip = (TextView) Utils.m5161b(view, R.id.preferredNameTip, "field 'mPreferredNameTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PreferredNameFragment preferredNameFragment = this.f10519b;
        if (preferredNameFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10519b = null;
        preferredNameFragment.nickname = null;
        preferredNameFragment.nicknameSkip = null;
        preferredNameFragment.mViewLoopMembers = null;
        preferredNameFragment.mChangePronunciationName = null;
        preferredNameFragment.mPreferredNameTip = null;
        this.f10520c.setOnClickListener(null);
        this.f10520c = null;
        this.f10521d.setOnClickListener(null);
        this.f10521d = null;
        this.f10522e.setOnClickListener(null);
        this.f10522e = null;
    }
}
