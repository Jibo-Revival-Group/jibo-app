package com.jibo.p019ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.UpdatePhotoRequest;
import com.jibo.aws.integration.aws.services.account.model.UpdateRequest;
import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.onboarding.AboutYouFragment;
import com.jibo.service.SyncHelper;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class AvatarBaseFragment extends PhotoBaseFragment {

    /* JADX INFO: renamed from: a */
    public static String f9914a = "NEW_USER";

    @BindView
    public ImageView avatar;

    /* JADX INFO: renamed from: b */
    protected int f9915b = R.drawable.avatar_profile_other;

    /* JADX INFO: renamed from: c */
    public boolean f9916c = false;

    /* JADX INFO: renamed from: d */
    public boolean f9917d = false;

    /* JADX INFO: renamed from: e */
    public Account f9918e;

    @BindView
    public ProgressBar photoProgressBar;

    @Override // com.jibo.p019ui.fragment.PhotoBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9918e = EntityData.m10089a(getActivity()).m10134i();
    }

    /* JADX INFO: renamed from: a */
    protected void m10324a(Account account) {
        if (account != null) {
            if (TextUtils.isEmpty(account.getPhotoUrl())) {
                this.avatar.setImageResource(this.f9915b);
            } else {
                this.photoProgressBar.setVisibility(0);
                mo10326a(account.getPhotoUrl());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m10325a(MemberAccount memberAccount) {
        if (TextUtils.isEmpty(memberAccount.getPhotoUrl())) {
            this.avatar.setImageResource(this.f9915b);
        } else {
            mo10326a(memberAccount.getPhotoUrl());
        }
    }

    @OnClick
    public void onAvatarClick(View view) {
        if (!this.f9916c) {
            DialogUtils.m10511a(this, 107, getString(R.string.text_change_photo), R.array.picture_options);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i == 107) {
            switch (i2) {
                case 0:
                    try {
                        m10359r();
                    } catch (Exception e) {
                        LogUtils.m11408a(f9929f, "onButtonClick:MakePhoto", e);
                        UIUtils.m11475a(getView(), getString(R.string.error_camera_is_not_availble));
                        return;
                    }
                    break;
                case 1:
                    m10360s();
                    break;
                case 2:
                    this.avatar.setImageBitmap(null);
                    this.photoProgressBar.setVisibility(8);
                    this.f9917d = false;
                    m10322c(this.f9943l);
                    m10324a(this.f9918e);
                    break;
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.PhotoBaseFragment, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 69) {
            m10323a();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo10326a(String str) {
        this.photoProgressBar.setVisibility(0);
        Glide.m5250a(getActivity()).m5279a(str).mo5235f(this.f9915b).mo5231d(this.f9915b).mo5224b(new RequestListener<String, GlideDrawable>() { // from class: com.jibo.ui.fragment.AvatarBaseFragment.1
            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo5532a(Exception exc, String str2, Target<GlideDrawable> target, boolean z) {
                if (AvatarBaseFragment.this.getActivity() != null && !AvatarBaseFragment.this.getActivity().isFinishing() && !AvatarBaseFragment.this.isRemoving()) {
                    AvatarBaseFragment.this.photoProgressBar.setVisibility(8);
                    return false;
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo5533a(GlideDrawable glideDrawable, String str2, Target<GlideDrawable> target, boolean z, boolean z2) {
                if (AvatarBaseFragment.this.getActivity() != null && !AvatarBaseFragment.this.getActivity().isFinishing() && !AvatarBaseFragment.this.isRemoving()) {
                    AvatarBaseFragment.this.photoProgressBar.setVisibility(8);
                    return false;
                }
                return false;
            }
        }).mo5223b(DiskCacheStrategy.ALL).mo5239j().mo5216a(this.avatar);
    }

    /* JADX INFO: renamed from: a */
    public void m10323a() {
        this.f9917d = true;
        try {
            if (!TextUtils.isEmpty(this.f9943l)) {
                mo10326a(this.f9943l);
            }
        } catch (Exception e) {
            if (m10342d()) {
                this.avatar.setImageBitmap(null);
                UIUtils.m11475a(this.avatar, getString(R.string.error_could_not_load_photo));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    protected void mo10329b(String str) {
    }

    /* JADX INFO: renamed from: b */
    protected void mo10327b() {
        m10344f();
        EntityData.m10089a(getActivity()).m10110a().updatePhoto(new File(this.f9943l), null, new AsyncHandler<UpdatePhotoRequest, Account>() { // from class: com.jibo.ui.fragment.AvatarBaseFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                AvatarBaseFragment.this.m10338a((Throwable) exc, "update photo", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdatePhotoRequest updatePhotoRequest, final Account account) throws Throwable {
                AvatarBaseFragment.this.f9943l = account.getPhotoUrl();
                if (EntityData.m10089a(AvatarBaseFragment.this.getActivity()).m10134i().getId().equals(account.getId())) {
                    AvatarBaseFragment.this.f9918e = account;
                    if (AvatarBaseFragment.this.m10342d()) {
                        EntityData.m10089a(AvatarBaseFragment.this.getActivity()).m10115a(account, true, null);
                    }
                } else if (AvatarBaseFragment.this.m10342d()) {
                    EntityData.m10089a(AvatarBaseFragment.this.getActivity()).m10114a(account, true);
                }
                AvatarBaseFragment.this.mo10345g();
                AvatarBaseFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.AvatarBaseFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SyncHelper.m10178b(AvatarBaseFragment.this.getActivity());
                        if (AvatarBaseFragment.this.getActivity() instanceof OnBoardingActivity) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean(AvatarBaseFragment.f9914a, true);
                            TabbedActivity.m10284a(AvatarBaseFragment.this.getActivity(), bundle);
                        } else {
                            AvatarBaseFragment.this.mo10329b(account.getPhotoUrl());
                            AvatarBaseFragment.this.mo10326a(account.getPhotoUrl());
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m10322c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m10328b(Account account) throws Throwable {
        m10344f();
        EntityData.m10089a(getActivity()).m10115a(account, false, new AsyncHandler<UpdateRequest, Account>() { // from class: com.jibo.ui.fragment.AvatarBaseFragment.4
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                AvatarBaseFragment.this.m10338a((Throwable) exc, "save account", true);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(UpdateRequest updateRequest, Account account2) {
                File file = null;
                if (AvatarBaseFragment.this.f9943l != null) {
                    file = new File(AvatarBaseFragment.this.f9943l);
                }
                if (file != null && file.exists() && AvatarBaseFragment.this.f9917d && AvatarBaseFragment.this.m10342d()) {
                    AvatarBaseFragment.this.mo10327b();
                } else {
                    AvatarBaseFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.AvatarBaseFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AvatarBaseFragment.this.mo10345g();
                            if (AvatarBaseFragment.this instanceof AboutYouFragment) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(AvatarBaseFragment.f9914a, true);
                                TabbedActivity.m10284a(AvatarBaseFragment.this.getActivity(), bundle);
                            }
                            SyncHelper.m10180c(AvatarBaseFragment.this.getActivity());
                        }
                    });
                }
            }
        });
    }
}
