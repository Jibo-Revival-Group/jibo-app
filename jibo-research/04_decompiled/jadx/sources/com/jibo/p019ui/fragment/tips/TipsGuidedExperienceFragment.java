package com.jibo.p019ui.fragment.tips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.p019ui.activity.TipsActivity;
import com.jibo.p019ui.fragment.avatar.AvatarsAdapter;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.p019ui.view.proxima.CustomFontButton;
import com.jibo.p019ui.view.proxima.CustomFontTextView;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class TipsGuidedExperienceFragment extends AvatarsLocationBaseFragment {

    /* JADX INFO: renamed from: c */
    private String f11184c = "TAG_TIP0";

    @BindView
    RecyclerView list;

    @BindView
    CustomFontButton mBtnNext;

    @BindView
    CustomFontTextView mContent2;

    @BindView
    CustomFontTextView mContent3;

    @BindView
    CustomFontTextView mContent5;

    @BindView
    CustomFontTextView mContent6;

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tip_guided_experience, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m11114b();
        m11115q();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_support, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_support != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.support_url))));
        return true;
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10487b(int i) {
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f10147b == null) {
            m11116r();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m11114b() {
        String string = getString(R.string.guided_experience_location_ifttt);
        String string2 = getString(R.string.tips_content0_3, string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ImageUtils.m11399b(getActivity(), R.color.jibo_blue)), string2.indexOf(string), string2.indexOf(string) + string.length(), 33);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), string2.indexOf(string), string2.indexOf(string) + string.length(), 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TipsGuidedExperienceFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(TipsGuidedExperienceFragment.this.getString(R.string.ifttt_url))));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, string2.indexOf(string), string.length() + string2.indexOf(string), 33);
        this.mContent2.setText(Html.fromHtml(getString(R.string.tips_content0_2)));
        this.mContent3.setText(spannableStringBuilder);
        this.mContent3.setMovementMethod(LinkMovementMethod.getInstance());
        this.mContent5.setText(Html.fromHtml(getString(R.string.tips_content0_5)));
        this.mContent6.setText(Html.fromHtml(getString(R.string.tips_content0_6)));
        this.mBtnNext.setText(getString(R.string.tips_next_button, getString(R.string.tips_title1)));
    }

    /* JADX INFO: renamed from: q */
    private void m11115q() {
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment, com.jibo.p019ui.fragment.settings.LocationFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.tips_title0);
    }

    @Override // com.jibo.p019ui.fragment.settings.LocationFragment
    @OnClick
    public void btnSetLocationClick(View view) {
        JiboAnalytics.m9861l(getActivity());
        super.btnSetLocationClick(view);
    }

    @OnClick
    public void nextButton(View view) {
        Intent intent = new Intent();
        intent.setClass(getContext(), TipsActivity.class);
        intent.putExtra("ARGS_TAG", "TAG_TIP1");
        startActivity(intent);
        getActivity().finish();
    }

    /* JADX INFO: renamed from: r */
    private void m11116r() {
        if (this.f9934k != null) {
            this.f10146a.getRobot(this.f9934k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>() { // from class: com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(GetRobotRequest getRobotRequest, Robot robot) {
                    TipsGuidedExperienceFragment.this.f10147b = robot;
                    TipsGuidedExperienceFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((AvatarsAdapter) TipsGuidedExperienceFragment.this.list.getAdapter()).m10475a(RobotHelper.getAvatar(TipsGuidedExperienceFragment.this.f10147b));
                            TipsGuidedExperienceFragment.this.list.getAdapter().notifyDataSetChanged();
                        }
                    });
                }
            });
        }
    }
}
