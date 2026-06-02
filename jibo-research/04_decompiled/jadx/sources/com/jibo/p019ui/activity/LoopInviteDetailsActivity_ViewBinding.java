package com.jibo.p019ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoopInviteDetailsActivity_ViewBinding extends BaseActivity_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LoopInviteDetailsActivity f9812b;

    /* JADX INFO: renamed from: c */
    private View f9813c;

    /* JADX INFO: renamed from: d */
    private View f9814d;

    public LoopInviteDetailsActivity_ViewBinding(LoopInviteDetailsActivity loopInviteDetailsActivity) {
        this(loopInviteDetailsActivity, loopInviteDetailsActivity.getWindow().getDecorView());
    }

    public LoopInviteDetailsActivity_ViewBinding(final LoopInviteDetailsActivity loopInviteDetailsActivity, View view) {
        super(loopInviteDetailsActivity, view);
        this.f9812b = loopInviteDetailsActivity;
        View viewM5158a = Utils.m5158a(view, R.id.button_accept, "field 'buttonAccept' and method 'onJoinClick'");
        loopInviteDetailsActivity.buttonAccept = viewM5158a;
        this.f9813c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopInviteDetailsActivity.onJoinClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.button_decline, "field 'buttonDecline' and method 'onDeclineClick'");
        loopInviteDetailsActivity.buttonDecline = viewM5158a2;
        this.f9814d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.activity.LoopInviteDetailsActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loopInviteDetailsActivity.onDeclineClick(view2);
            }
        });
        loopInviteDetailsActivity.recyclerView = (RecyclerView) Utils.m5161b(view, R.id.recycler, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // com.jibo.p019ui.activity.BaseActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        LoopInviteDetailsActivity loopInviteDetailsActivity = this.f9812b;
        if (loopInviteDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9812b = null;
        loopInviteDetailsActivity.buttonAccept = null;
        loopInviteDetailsActivity.buttonDecline = null;
        loopInviteDetailsActivity.recyclerView = null;
        this.f9813c.setOnClickListener(null);
        this.f9813c = null;
        this.f9814d.setOnClickListener(null);
        this.f9814d = null;
        super.unbind();
    }
}
