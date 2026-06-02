package com.jibo.p019ui.fragment.tips;

import android.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;
import com.jibo.p019ui.view.proxima.CustomFontButton;
import com.jibo.p019ui.view.proxima.CustomFontTextView;

/* JADX INFO: loaded from: classes.dex */
public class TipsGuidedExperienceFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private TipsGuidedExperienceFragment f11188b;

    /* JADX INFO: renamed from: c */
    private View f11189c;

    /* JADX INFO: renamed from: d */
    private View f11190d;

    public TipsGuidedExperienceFragment_ViewBinding(final TipsGuidedExperienceFragment tipsGuidedExperienceFragment, View view) {
        super(tipsGuidedExperienceFragment, view);
        this.f11188b = tipsGuidedExperienceFragment;
        tipsGuidedExperienceFragment.list = (RecyclerView) Utils.m5161b(view, R.id.list, "field 'list'", RecyclerView.class);
        View viewM5158a = Utils.m5158a(view, com.jibo.R.id.btnNext, "field 'mBtnNext' and method 'nextButton'");
        tipsGuidedExperienceFragment.mBtnNext = (CustomFontButton) Utils.m5162c(viewM5158a, com.jibo.R.id.btnNext, "field 'mBtnNext'", CustomFontButton.class);
        this.f11189c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                tipsGuidedExperienceFragment.nextButton(view2);
            }
        });
        tipsGuidedExperienceFragment.mContent2 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.content_2, "field 'mContent2'", CustomFontTextView.class);
        tipsGuidedExperienceFragment.mContent3 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.content_3, "field 'mContent3'", CustomFontTextView.class);
        tipsGuidedExperienceFragment.mContent5 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.content_5, "field 'mContent5'", CustomFontTextView.class);
        tipsGuidedExperienceFragment.mContent6 = (CustomFontTextView) Utils.m5161b(view, com.jibo.R.id.content_6, "field 'mContent6'", CustomFontTextView.class);
        View viewM5158a2 = Utils.m5158a(view, com.jibo.R.id.content_4, "method 'btnSetLocationClick'");
        this.f11190d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.tips.TipsGuidedExperienceFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                tipsGuidedExperienceFragment.btnSetLocationClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding, com.jibo.p019ui.fragment.settings.LocationFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        TipsGuidedExperienceFragment tipsGuidedExperienceFragment = this.f11188b;
        if (tipsGuidedExperienceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f11188b = null;
        tipsGuidedExperienceFragment.list = null;
        tipsGuidedExperienceFragment.mBtnNext = null;
        tipsGuidedExperienceFragment.mContent2 = null;
        tipsGuidedExperienceFragment.mContent3 = null;
        tipsGuidedExperienceFragment.mContent5 = null;
        tipsGuidedExperienceFragment.mContent6 = null;
        this.f11189c.setOnClickListener(null);
        this.f11189c = null;
        this.f11190d.setOnClickListener(null);
        this.f11190d = null;
        super.unbind();
    }
}
