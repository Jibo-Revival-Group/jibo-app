package com.jibo.p019ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class AvatarBaseFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private AvatarBaseFragment f9925b;

    /* JADX INFO: renamed from: c */
    private View f9926c;

    public AvatarBaseFragment_ViewBinding(final AvatarBaseFragment avatarBaseFragment, View view) {
        this.f9925b = avatarBaseFragment;
        View viewM5158a = Utils.m5158a(view, R.id.avatar, "field 'avatar' and method 'onAvatarClick'");
        avatarBaseFragment.avatar = (ImageView) Utils.m5162c(viewM5158a, R.id.avatar, "field 'avatar'", ImageView.class);
        this.f9926c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.AvatarBaseFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                avatarBaseFragment.onAvatarClick(view2);
            }
        });
        avatarBaseFragment.photoProgressBar = (ProgressBar) Utils.m5161b(view, R.id.photoProgressBar, "field 'photoProgressBar'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AvatarBaseFragment avatarBaseFragment = this.f9925b;
        if (avatarBaseFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f9925b = null;
        avatarBaseFragment.avatar = null;
        avatarBaseFragment.photoProgressBar = null;
        this.f9926c.setOnClickListener(null);
        this.f9926c = null;
    }
}
