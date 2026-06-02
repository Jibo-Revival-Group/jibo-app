package com.jibo.p019ui.fragment.avatar;

import android.R;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class AvatarViewHolder_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AvatarViewHolder f10142b;

    public AvatarViewHolder_ViewBinding(AvatarViewHolder avatarViewHolder, View view) {
        this.f10142b = avatarViewHolder;
        avatarViewHolder.avatar = (ImageView) Utils.m5161b(view, R.id.icon, "field 'avatar'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AvatarViewHolder avatarViewHolder = this.f10142b;
        if (avatarViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10142b = null;
        avatarViewHolder.avatar = null;
    }
}
