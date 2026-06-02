package com.salesforce.android.cases.p020ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.HorizontalRuleModel;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.ReceivedMessageModel;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.SentMessageModel;
import com.salesforce.android.service.common.p023ui.internal.messaging.ViewHolderFactory;

/* JADX INFO: loaded from: classes.dex */
public class MessageViewFactory implements ViewHolderFactory {

    /* JADX INFO: renamed from: a */
    private final int f12673a = 1;

    /* JADX INFO: renamed from: b */
    private final int f12674b = 2;

    /* JADX INFO: renamed from: c */
    private final int f12675c = 3;

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.ViewHolderFactory
    /* JADX INFO: renamed from: a */
    public int mo12809a(Object obj) {
        if (obj instanceof ReceivedMessageModel) {
            return 1;
        }
        if (obj instanceof SentMessageModel) {
            return 2;
        }
        if (obj instanceof HorizontalRuleModel) {
            return 3;
        }
        throw new IllegalStateException("Unknown message item type: " + obj.getClass().getCanonicalName());
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.ViewHolderFactory
    /* JADX INFO: renamed from: a */
    public RecyclerView.ViewHolder mo12810a(ViewGroup viewGroup, int i, LayoutInflater layoutInflater) {
        if (i == 1) {
            return new ReceivedMessageViewHolder(layoutInflater.inflate(R.layout.salesforce_message_received, viewGroup, false));
        }
        if (i == 2) {
            return new SentMessageViewHolder(layoutInflater.inflate(R.layout.salesforce_message_sent, viewGroup, false));
        }
        if (i == 3) {
            return new HorizontalRuleViewHolder(layoutInflater.inflate(R.layout.salesforce_message_horizontal_rule, viewGroup, false));
        }
        throw new IllegalArgumentException("Unknown viewType: " + i);
    }

    @Override // com.salesforce.android.service.common.p023ui.internal.messaging.ViewHolderFactory
    /* JADX INFO: renamed from: a */
    public void mo12811a(RecyclerView.ViewHolder viewHolder, int i, Object obj) {
        if (i == 1) {
            ((ReceivedMessageViewHolder) viewHolder).m12813a((ReceivedMessageModel) obj);
        } else if (i == 2) {
            ((SentMessageViewHolder) viewHolder).m12815a((SentMessageModel) obj);
        } else if (i == 3) {
            ((HorizontalRuleViewHolder) viewHolder).m12808a((HorizontalRuleModel) obj);
        }
    }
}
