package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;
import com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public class AboutYouFragment_ViewBinding extends AvatarBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private AboutYouFragment f10651b;

    /* JADX INFO: renamed from: c */
    private View f10652c;

    /* JADX INFO: renamed from: d */
    private View f10653d;

    /* JADX INFO: renamed from: e */
    private View f10654e;

    /* JADX INFO: renamed from: f */
    private View f10655f;

    public AboutYouFragment_ViewBinding(final AboutYouFragment aboutYouFragment, View view) {
        super(aboutYouFragment, view);
        this.f10651b = aboutYouFragment;
        aboutYouFragment.first_name = (TextView) Utils.m5161b(view, R.id.first_name, "field 'first_name'", TextView.class);
        aboutYouFragment.last_name = (TextView) Utils.m5161b(view, R.id.last_name, "field 'last_name'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.settingGender, "field 'mGender' and method 'genderClick'");
        aboutYouFragment.mGender = (TextView) Utils.m5162c(viewM5158a, R.id.settingGender, "field 'mGender'", TextView.class);
        this.f10652c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                aboutYouFragment.genderClick();
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.settingBirthday, "field 'mBirthday' and method 'birthdayClick'");
        aboutYouFragment.mBirthday = (TextView) Utils.m5162c(viewM5158a2, R.id.settingBirthday, "field 'mBirthday'", TextView.class);
        this.f10653d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                aboutYouFragment.birthdayClick();
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.avatar_edit, "field 'avatarEditButton' and method 'changePicture'");
        aboutYouFragment.avatarEditButton = (ImageView) Utils.m5162c(viewM5158a3, R.id.avatar_edit, "field 'avatarEditButton'", ImageView.class);
        this.f10654e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                aboutYouFragment.changePicture(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.avatar, "method 'onAvatarClick'");
        this.f10655f = viewM5158a4;
        viewM5158a4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.AboutYouFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                aboutYouFragment.onAvatarClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.AvatarBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        AboutYouFragment aboutYouFragment = this.f10651b;
        if (aboutYouFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10651b = null;
        aboutYouFragment.first_name = null;
        aboutYouFragment.last_name = null;
        aboutYouFragment.mGender = null;
        aboutYouFragment.mBirthday = null;
        aboutYouFragment.avatarEditButton = null;
        this.f10652c.setOnClickListener(null);
        this.f10652c = null;
        this.f10653d.setOnClickListener(null);
        this.f10653d = null;
        this.f10654e.setOnClickListener(null);
        this.f10654e = null;
        this.f10655f.setOnClickListener(null);
        this.f10655f = null;
        super.unbind();
    }
}
