package com.jibo.p019ui.fragment.avatar;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;
import com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class AvatarsLocationBaseFragment_ViewBinding extends LocationFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private AvatarsLocationBaseFragment f10152b;

    public AvatarsLocationBaseFragment_ViewBinding(AvatarsLocationBaseFragment avatarsLocationBaseFragment, View view) {
        super(avatarsLocationBaseFragment, view);
        this.f10152b = avatarsLocationBaseFragment;
        avatarsLocationBaseFragment.list = (RecyclerView) Utils.m5159a(view, R.id.list, "field 'list'", RecyclerView.class);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        AvatarsLocationBaseFragment avatarsLocationBaseFragment = this.f10152b;
        if (avatarsLocationBaseFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10152b = null;
        avatarsLocationBaseFragment.list = null;
        super.unbind();
    }
}
