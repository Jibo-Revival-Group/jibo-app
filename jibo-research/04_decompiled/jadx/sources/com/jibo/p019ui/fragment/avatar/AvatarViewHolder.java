package com.jibo.p019ui.fragment.avatar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jibo.R;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class AvatarViewHolder extends RecyclerView.ViewHolder {

    @BindView
    public ImageView avatar;

    public AvatarViewHolder(View view) {
        super(view);
        ButterKnife.m5154a(this, view);
    }

    /* JADX INFO: renamed from: a */
    public void m10474a(int i, boolean z) {
        this.avatar.setImageLevel(i);
        if (z) {
            this.itemView.setBackground(ImageUtils.m11392a(this.itemView.getContext(), R.drawable.ic_circle_filled, new int[]{R.color.jibo_blue, R.color.raspberry, R.color.yellow, R.color.grass_alt}[i % 4]));
        } else {
            this.itemView.setBackgroundResource(0);
        }
        this.itemView.setTag(Integer.valueOf(i));
    }
}
