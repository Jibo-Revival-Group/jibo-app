package com.jibo.p019ui.fragment.guided;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class JiboAvatarSlideFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private JiboAvatarSlideFragment f10325b;

    public JiboAvatarSlideFragment_ViewBinding(JiboAvatarSlideFragment jiboAvatarSlideFragment, View view) {
        super(jiboAvatarSlideFragment, view);
        this.f10325b = jiboAvatarSlideFragment;
        jiboAvatarSlideFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
        jiboAvatarSlideFragment.txtInfo = (TextView) Utils.m5161b(view, com.jibo.R.id.txtInfo, "field 'txtInfo'", TextView.class);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding, com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        JiboAvatarSlideFragment jiboAvatarSlideFragment = this.f10325b;
        if (jiboAvatarSlideFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10325b = null;
        jiboAvatarSlideFragment.list = null;
        jiboAvatarSlideFragment.txtInfo = null;
        super.unbind();
    }
}
