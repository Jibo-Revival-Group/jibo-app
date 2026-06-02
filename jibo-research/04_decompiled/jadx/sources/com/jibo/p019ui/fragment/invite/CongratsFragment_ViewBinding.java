package com.jibo.p019ui.fragment.invite;

import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CongratsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private CongratsFragment f10421b;

    /* JADX INFO: renamed from: c */
    private View f10422c;

    /* JADX INFO: renamed from: d */
    private View f10423d;

    public CongratsFragment_ViewBinding(final CongratsFragment congratsFragment, View view) {
        this.f10421b = congratsFragment;
        congratsFragment.title = (TextView) Utils.m5161b(view, R.id.title, "field 'title'", TextView.class);
        congratsFragment.text = (TextView) Utils.m5161b(view, R.id.text, "field 'text'", TextView.class);
        congratsFragment.video = (VideoView) Utils.m5161b(view, R.id.video, "field 'video'", VideoView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnViewMyLoop, "method 'onViewMyLoop'");
        this.f10422c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.CongratsFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                congratsFragment.onViewMyLoop(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnDontShowAgain, "method 'onDontShowAgain'");
        this.f10423d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.invite.CongratsFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                congratsFragment.onDontShowAgain(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CongratsFragment congratsFragment = this.f10421b;
        if (congratsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10421b = null;
        congratsFragment.title = null;
        congratsFragment.text = null;
        congratsFragment.video = null;
        this.f10422c.setOnClickListener(null);
        this.f10422c = null;
        this.f10423d.setOnClickListener(null);
        this.f10423d = null;
    }
}
