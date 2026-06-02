package com.jibo.p019ui.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.PermissionUtil;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public abstract class PhotoBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    private String f9942a;

    /* JADX INFO: renamed from: l */
    protected String f9943l;

    /* JADX INFO: renamed from: m */
    public Uri f9944m;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9942a = getActivity().getExternalCacheDir() + "/";
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1009:
                    Uri uri = this.f9944m;
                    this.f9944m = null;
                    if (this instanceof AvatarBaseFragment) {
                        m10357a(uri);
                    }
                    break;
                case 1010:
                    Uri data = intent.getData();
                    if (this instanceof AvatarBaseFragment) {
                        m10357a(data);
                    }
                    break;
            }
        }
        switch (i) {
            case 1009:
                if (this.f9944m != null) {
                    try {
                        getActivity().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.valueOf(Long.parseLong(this.f9944m.getLastPathSegment().replace("image:", ""))).toString()});
                    } catch (Exception e) {
                        LogUtils.m11408a(f9929f, "onActivityResult", e);
                        Crashlytics.m5597a((Throwable) e);
                    }
                }
                this.f9944m = null;
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10357a(Uri uri) {
        try {
            this.f9943l = this.f9942a + Long.valueOf(System.currentTimeMillis() / 1000) + "_tmp_photo.jpg";
            ImageUtils.m11397a(this.f9943l, getActivity().getContentResolver().openInputStream(uri));
            UCrop.Options options = new UCrop.Options();
            options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
            options.setCompressionQuality(95);
            options.setStatusBarColor(getResources().getColor(R.color.accent_blue));
            options.setToolbarColor(getResources().getColor(R.color.jibo_blue));
            options.setHideBottomControls(true);
            options.setFreeStyleCropEnabled(false);
            options.setOvalDimmedLayer(true);
            options.setShowCropGrid(false);
            options.setShowCropFrame(false);
            options.setCropPadding(getResources().getDimensionPixelSize(R.dimen.avatar_crop_padding_size));
            options.withAspectRatio(1.0f, 1.0f);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.avatar_size);
            options.withMaxResultSize(dimensionPixelSize, dimensionPixelSize);
            m10355a(options);
        } catch (FileNotFoundException e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10355a(UCrop.Options options) {
        UCrop uCropM15054of = UCrop.m15054of(Uri.fromFile(new File(this.f9943l)), Uri.fromFile(new File(this.f9943l)));
        uCropM15054of.withOptions(options);
        uCropM15054of.start(getActivity(), this);
    }

    /* JADX INFO: renamed from: q */
    public void m10358q() {
        if (PermissionUtil.m11420a(getActivity())) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("mime_type", "image/jpg");
            this.f9944m = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            ImageUtils.m11395a(this, 1009, this.f9944m);
            return;
        }
        m10356a(1);
    }

    /* JADX INFO: renamed from: r */
    public void m10359r() {
        if (PermissionUtil.m11420a(getActivity())) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("mime_type", "image/jpg");
            this.f9944m = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            ImageUtils.m11401b(this, 1009, this.f9944m);
            return;
        }
        m10356a(2);
    }

    /* JADX INFO: renamed from: s */
    public void m10360s() {
        if (PermissionUtil.m11420a(getActivity())) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(FileUtils.MIME_TYPE_IMAGE);
            startActivityForResult(intent, 1010);
            return;
        }
        m10356a(3);
    }

    /* JADX INFO: renamed from: a */
    public void m10356a(int i) {
        requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, i);
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0) {
            int i2 = 0;
            for (int i3 : iArr) {
                i2 += i3;
            }
            if (i2 == 0) {
                switch (i) {
                    case 1:
                        m10358q();
                        break;
                    case 2:
                        m10359r();
                        break;
                    case 3:
                        m10360s();
                        break;
                }
            }
        }
    }
}
