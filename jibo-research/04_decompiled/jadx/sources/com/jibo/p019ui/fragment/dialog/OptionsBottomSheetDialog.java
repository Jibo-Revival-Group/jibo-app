package com.jibo.p019ui.fragment.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jibo.R;
import com.jibo.p019ui.helpers.Items;
import com.jibo.p019ui.helpers.ViewHolders;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OptionsBottomSheetDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: b */
    private String f10271b;

    /* JADX INFO: renamed from: c */
    private int[] f10272c;

    /* JADX INFO: renamed from: d */
    private String[] f10273d;

    /* JADX INFO: renamed from: e */
    private DialogInterface.OnClickListener f10274e;

    public OptionsBottomSheetDialog(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10560a(DialogInterface dialogInterface, int i) {
        if (this.f10274e != null) {
            this.f10274e.onClick(dialogInterface, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10561a(View view) {
        if (!TextUtils.isEmpty(this.f10271b)) {
            ((TextView) view.findViewById(R.id.tvTitle)).setText(this.f10271b);
        } else {
            view.findViewById(R.id.tvTitle).setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10563b(View view) {
        ArrayList arrayList = new ArrayList();
        for (final int i = 0; i < this.f10272c.length; i++) {
            arrayList.add(new Items.IconTextItem(Items.ItemType.dialog_bottom_sheet_item, new View.OnClickListener() { // from class: com.jibo.ui.fragment.dialog.OptionsBottomSheetDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    OptionsBottomSheetDialog.this.m10560a(OptionsBottomSheetDialog.this, i);
                }
            }, this.f10272c[i], this.f10273d[i]));
        }
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter();
        bottomSheetAdapter.m10571a(arrayList);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(bottomSheetAdapter);
    }

    /* JADX INFO: renamed from: a */
    public void m10565a(String str) {
        this.f10271b = str;
    }

    /* JADX INFO: renamed from: a */
    public void m10566a(int[] iArr) {
        this.f10272c = iArr;
    }

    /* JADX INFO: renamed from: a */
    public void m10567a(String[] strArr) {
        this.f10273d = strArr;
    }

    /* JADX INFO: renamed from: a */
    public void m10564a(DialogInterface.OnClickListener onClickListener) {
        this.f10274e = onClickListener;
    }

    /* JADX INFO: renamed from: c */
    public void m10568c() {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(getContext()).inflate(R.layout.dialog_custom_holiday_bottom_options, (ViewGroup) null);
        m10561a(constraintLayout);
        m10563b(constraintLayout);
        setContentView(constraintLayout);
    }

    static class BottomSheetAdapter extends RecyclerView.Adapter<ViewHolders.AbstractViewHolder> {

        /* JADX INFO: renamed from: a */
        private List<Items.Item> f10277a = new ArrayList();

        BottomSheetAdapter() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f10277a.get(i).getItemType().ordinal();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f10277a == null) {
                return 0;
            }
            return this.f10277a.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewHolders.AbstractViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolders.OptionsBottomSheetDialogViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(Items.ItemType.values()[i].getLayoutId(), viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolders.AbstractViewHolder abstractViewHolder, int i) {
            abstractViewHolder.setData(this.f10277a.get(i));
        }

        /* JADX INFO: renamed from: a */
        public void m10571a(List<Items.Item> list) {
            this.f10277a.clear();
            this.f10277a.addAll(list);
            notifyDataSetChanged();
        }
    }
}
