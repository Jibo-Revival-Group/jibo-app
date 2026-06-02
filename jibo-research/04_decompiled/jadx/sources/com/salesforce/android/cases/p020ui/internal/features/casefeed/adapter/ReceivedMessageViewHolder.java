package com.salesforce.android.cases.p020ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.ReceivedMessageModel;
import com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView;

/* JADX INFO: loaded from: classes.dex */
class ReceivedMessageViewHolder extends RecyclerView.ViewHolder implements GroupableView {

    /* JADX INFO: renamed from: a */
    private TextView f12676a;

    /* JADX INFO: renamed from: b */
    private TextView f12677b;

    /* JADX INFO: renamed from: c */
    private TextView f12678c;

    /* JADX INFO: renamed from: d */
    private View f12679d;

    /* JADX INFO: renamed from: e */
    private View f12680e;

    ReceivedMessageViewHolder(View view) {
        super(view);
        this.f12676a = (TextView) view.findViewById(R.id.salesforce_received_message_text);
        this.f12677b = (TextView) view.findViewById(R.id.salesforce_received_message_agent_name);
        this.f12678c = (TextView) view.findViewById(R.id.salesforce_received_message_timestamp);
        this.f12679d = view.findViewById(R.id.salesforce_agent_avatar_container);
        this.f12680e = view.findViewById(R.id.salesforce_received_message_footer);
    }

    /* JADX INFO: renamed from: a */
    public void m12813a(ReceivedMessageModel receivedMessageModel) {
        this.f12676a.setText(receivedMessageModel.m12826a());
        this.f12677b.setText(receivedMessageModel.m12827b());
        if (receivedMessageModel.mo12829d() != null) {
            this.f12678c.setText(DateFormat.getTimeFormat(this.itemView.getContext()).format(receivedMessageModel.mo12829d()));
        }
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView
    /* JADX INFO: renamed from: a */
    public void mo12812a() {
        this.f12680e.setVisibility(8);
        this.f12679d.setVisibility(4);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView
    /* JADX INFO: renamed from: b */
    public void mo12814b() {
        this.f12680e.setVisibility(0);
        this.f12679d.setVisibility(0);
    }
}
