package com.jibo.p019ui.fragment.guided;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.R;
import com.jibo.p019ui.activity.GuidedExperienceActivity;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class JiboAvatarSlideFragment extends AvatarsLocationBaseFragment {

    @BindView
    RecyclerView list;

    @BindView
    TextView txtInfo;

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10147b = ((GuidedExperienceActivity) getActivity()).m10213q();
        m10349k();
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_guided_experience_avatar_selection, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = getString(R.string.guided_experience_avatar_text2);
        String string2 = getString(R.string.guided_experience_avatar_text, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11652d), string2.indexOf(string), string.length() + string2.indexOf(string), 33);
        this.txtInfo.setText(spannableStringBuilder);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10487b(int i) {
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }
}
