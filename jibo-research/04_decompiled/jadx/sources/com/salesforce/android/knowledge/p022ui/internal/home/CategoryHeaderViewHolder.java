package com.salesforce.android.knowledge.p022ui.internal.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.salesforce.android.knowledge.p022ui.R;
import com.salesforce.android.knowledge.p022ui.internal.models.DataCategoryInfo;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class CategoryHeaderViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a */
    final HomePresenter f13233a;

    /* JADX INFO: renamed from: b */
    final TextView f13234b;

    /* JADX INFO: renamed from: c */
    final ImageView f13235c;

    /* JADX INFO: renamed from: d */
    final ImageView f13236d;

    /* JADX INFO: renamed from: a */
    public static CategoryHeaderViewHolder m13549a(View view, HomePresenter homePresenter) {
        return new CategoryHeaderViewHolder(view, homePresenter);
    }

    private CategoryHeaderViewHolder(View view, HomePresenter homePresenter) {
        super(view);
        this.f13233a = homePresenter;
        this.f13234b = (TextView) this.itemView.findViewById(R.id.knowledge_category_name);
        this.f13235c = (ImageView) this.itemView.findViewById(R.id.knowledge_category_image);
        this.f13236d = (ImageView) this.itemView.findViewById(R.id.knowledge_icon_dropdown);
        this.f13236d.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.CategoryHeaderViewHolder.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                CategoryHeaderViewHolder.this.f13236d.setPivotX((i3 - i) / 2);
                CategoryHeaderViewHolder.this.f13236d.setPivotX((i4 - i2) / 2);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m13551a(Context context, final DataCategoryInfo dataCategoryInfo) {
        this.f13234b.setText(dataCategoryInfo.mo13246b());
        this.f13235c.setImageDrawable(dataCategoryInfo.m13621a(context));
        this.f13236d.setRotation(this.f13233a.mo13567c(dataCategoryInfo) ? 180.0f : CropImageView.DEFAULT_ASPECT_RATIO);
        this.itemView.setBackgroundColor(dataCategoryInfo.m13622d());
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.salesforce.android.knowledge.ui.internal.home.CategoryHeaderViewHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CategoryHeaderViewHolder.this.f13233a.mo13564a(dataCategoryInfo);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m13552a(boolean z) {
        RotateAnimation.m13585a(this.f13236d, z ? 180.0f : CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: a */
    public Context m13550a() {
        return this.itemView.getContext();
    }
}
