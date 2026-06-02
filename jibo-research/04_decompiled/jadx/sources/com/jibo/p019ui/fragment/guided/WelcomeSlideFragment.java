package com.jibo.p019ui.fragment.guided;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.R;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class WelcomeSlideFragment extends BaseFragment {

    @BindView
    public ImageView avatar;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10349k();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_guided_experience_welcome, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Glide.m5250a(getActivity()).m5279a(EntityData.m10089a(getActivity()).m10134i().getPhotoUrl()).mo5231d(R.drawable.image_couple).mo5223b(DiskCacheStrategy.ALL).mo5216a(this.avatar);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }
}
