package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class AvatarSelectionFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private AvatarSelectionFragment f10919b;

    public AvatarSelectionFragment_ViewBinding(AvatarSelectionFragment avatarSelectionFragment, View view) {
        super(avatarSelectionFragment, view);
        this.f10919b = avatarSelectionFragment;
        avatarSelectionFragment.jiboAvatar = (ImageView) Utils.m5161b(view, R.id.jiboAvatar, "field 'jiboAvatar'", ImageView.class);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding, com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        AvatarSelectionFragment avatarSelectionFragment = this.f10919b;
        if (avatarSelectionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10919b = null;
        avatarSelectionFragment.jiboAvatar = null;
        super.unbind();
    }
}
