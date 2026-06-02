package com.jibo.p019ui.fragment.guided;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WelcomeSlideFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private WelcomeSlideFragment f10331b;

    public WelcomeSlideFragment_ViewBinding(WelcomeSlideFragment welcomeSlideFragment, View view) {
        this.f10331b = welcomeSlideFragment;
        welcomeSlideFragment.avatar = (ImageView) Utils.m5161b(view, R.id.avatar, "field 'avatar'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WelcomeSlideFragment welcomeSlideFragment = this.f10331b;
        if (welcomeSlideFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10331b = null;
        welcomeSlideFragment.avatar = null;
    }
}
