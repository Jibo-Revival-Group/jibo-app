package com.jibo.p019ui.fragment.guided;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.p019ui.fragment.dialog.LocationSetDialog;
import com.jibo.p019ui.fragment.settings.LocationFragment;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class LocationSlideFragment extends LocationFragment {

    @BindView
    TextView text2;

    @BindView
    TextView topText;

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10349k();
        setUserVisibleHint(false);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_guided_experience_location, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = getString(R.string.guided_experience_location_ifttt);
        String string2 = getString(R.string.guided_experience_location_text2, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ImageUtils.m11399b(getActivity(), R.color.jibo_blue)), string2.indexOf(string), string2.indexOf(string) + string.length(), 33);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), string2.indexOf(string), string2.indexOf(string) + string.length(), 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.guided.LocationSlideFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                LocationSlideFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(LocationSlideFragment.this.getString(R.string.ifttt_url))));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, string2.indexOf(string), string.length() + string2.indexOf(string), 33);
        this.text2.setText(spannableStringBuilder);
        this.text2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return "";
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment
    @OnClick
    public void btnSetLocationClick(View view) {
        JiboAnalytics.m9861l(getActivity());
        super.btnSetLocationClick(view);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment
    /* JADX INFO: renamed from: a */
    protected void mo10393a() {
        if (this.f11030l != null && getUserVisibleHint()) {
            LocationSetDialog locationSetDialog = new LocationSetDialog();
            Bundle bundle = new Bundle();
            bundle.putString("ARGS_LOCATION", this.f11030l);
            bundle.putString("ARGS_TIMEZONE", this.f11031m);
            locationSetDialog.setArguments(bundle);
            locationSetDialog.show(getActivity().getSupportFragmentManager(), LocationSetDialog.class.getSimpleName());
        }
    }
}
