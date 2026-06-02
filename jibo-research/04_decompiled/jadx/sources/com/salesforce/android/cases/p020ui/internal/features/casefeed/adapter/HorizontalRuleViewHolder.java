package com.salesforce.android.cases.p020ui.internal.features.casefeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel.HorizontalRuleModel;

/* JADX INFO: loaded from: classes.dex */
class HorizontalRuleViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a */
    private TextView f12672a;

    HorizontalRuleViewHolder(View view) {
        super(view);
        this.f12672a = (TextView) view.findViewById(R.id.salesforce_horizontal_rule_text);
    }

    /* JADX INFO: renamed from: a */
    public void m12808a(HorizontalRuleModel horizontalRuleModel) {
        this.f12672a.setText(horizontalRuleModel.m12825a());
    }
}
