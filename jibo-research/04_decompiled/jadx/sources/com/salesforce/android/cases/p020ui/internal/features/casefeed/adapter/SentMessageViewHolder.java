package com.salesforce.android.cases.p020ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.SentMessageModel;
import com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView;

/* JADX INFO: loaded from: classes.dex */
class SentMessageViewHolder extends RecyclerView.ViewHolder implements GroupableView {

    /* JADX INFO: renamed from: a */
    private TextView f12681a;

    /* JADX INFO: renamed from: b */
    private TextView f12682b;

    SentMessageViewHolder(View view) {
        super(view);
        this.f12681a = (TextView) view.findViewById(R.id.salesforce_sent_message_text);
        this.f12682b = (TextView) view.findViewById(R.id.salesforce_sent_message_timestamp);
    }

    /* JADX INFO: renamed from: a */
    public void m12815a(SentMessageModel sentMessageModel) {
        this.f12681a.setText(sentMessageModel.m12831a());
        if (sentMessageModel.mo12829d() != null) {
            this.f12682b.setText(DateFormat.getTimeFormat(this.itemView.getContext()).format(sentMessageModel.mo12829d()));
        }
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView
    /* JADX INFO: renamed from: a */
    public void mo12812a() {
        this.f12682b.setVisibility(8);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.GroupableView
    /* JADX INFO: renamed from: b */
    public void mo12814b() {
        this.f12682b.setVisibility(0);
    }
}
