package com.salesforce.android.cases.p020ui.internal.features.caselist;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.p020ui.internal.features.caselist.viewmodel.CaseListItemViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class CaseListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a */
    private LayoutInflater f12702a;

    /* JADX INFO: renamed from: b */
    private List<CaseListItemViewModel> f12703b = new ArrayList();

    /* JADX INFO: renamed from: a */
    abstract void mo12841a(CaseListItemViewModel caseListItemViewModel);

    CaseListAdapter(Context context) {
        this.f12702a = LayoutInflater.from(context);
    }

    /* JADX INFO: renamed from: a */
    void m12843a(List<CaseListItemViewModel> list) {
        DiffUtil.m3443a(new CaseListDiffCallback(this.f12703b, list)).m3461a(this);
        this.f12703b = new ArrayList(list);
    }

    /* JADX INFO: renamed from: b */
    void m12844b(CaseListItemViewModel caseListItemViewModel) {
        int iIndexOf = this.f12703b.indexOf(caseListItemViewModel);
        if (iIndexOf >= 0) {
            this.f12703b.set(iIndexOf, caseListItemViewModel);
            notifyItemChanged(iIndexOf);
        }
    }

    /* JADX INFO: renamed from: c */
    void m12845c(CaseListItemViewModel caseListItemViewModel) {
        int iIndexOf = this.f12703b.indexOf(caseListItemViewModel);
        if (iIndexOf >= 0) {
            this.f12703b.remove(iIndexOf);
            notifyItemRemoved(iIndexOf);
        }
    }

    /* JADX INFO: renamed from: a */
    void m12842a(CaseListItemViewModel caseListItemViewModel, int i) {
        this.f12703b.add(i, caseListItemViewModel);
        notifyItemInserted(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        final ViewHolder viewHolder = new ViewHolder(this.f12702a.inflate(R.layout.case_list_item, viewGroup, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.cases.ui.internal.features.caselist.CaseListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = viewHolder.getAdapterPosition();
                if (adapterPosition != -1) {
                    CaseListAdapter.this.mo12841a((CaseListItemViewModel) CaseListAdapter.this.f12703b.get(adapterPosition));
                }
            }
        });
        return viewHolder;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.m12846a(this.f12703b.get(i));
    }

    /* JADX INFO: renamed from: a */
    CaseListItemViewModel m12839a(int i) {
        if (i >= this.f12703b.size() || i < 0) {
            return null;
        }
        return this.f12703b.get(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12703b.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        TextView f12706a;

        /* JADX INFO: renamed from: b */
        TextView f12707b;

        /* JADX INFO: renamed from: c */
        TextView f12708c;

        /* JADX INFO: renamed from: d */
        ImageView f12709d;

        ViewHolder(View view) {
            super(view);
            this.f12706a = (TextView) view.findViewById(R.id.case_time);
            this.f12707b = (TextView) view.findViewById(R.id.case_subject);
            this.f12708c = (TextView) view.findViewById(R.id.case_message);
            this.f12709d = (ImageView) view.findViewById(R.id.unread_indicator);
        }

        /* JADX INFO: renamed from: a */
        void m12846a(CaseListItemViewModel caseListItemViewModel) {
            this.f12706a.setText(caseListItemViewModel.m12923d());
            this.f12707b.setText(caseListItemViewModel.m12924e());
            if (StringUtils.m12617b(caseListItemViewModel.m12925f())) {
                this.f12708c.setText(StringUtils.m12619d(caseListItemViewModel.m12925f()));
                this.f12708c.setVisibility(0);
            } else {
                this.f12708c.setVisibility(8);
            }
            this.f12709d.setVisibility(caseListItemViewModel.m12921b() ? 0 : 4);
        }
    }
}
