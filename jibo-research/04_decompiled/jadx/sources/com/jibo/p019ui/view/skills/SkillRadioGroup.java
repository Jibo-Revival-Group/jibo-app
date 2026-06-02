package com.jibo.p019ui.view.skills;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.R;
import com.jibo.p019ui.helpers.skills.DataItems;
import com.jibo.p019ui.helpers.skills.SkillsJsonParser;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SkillRadioGroup extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private View.OnClickListener f11675a;

    public SkillRadioGroup(Context context) {
        super(context);
        m11375a();
    }

    public SkillRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11375a();
    }

    public SkillRadioGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11375a();
    }

    public SkillRadioGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m11375a();
    }

    /* JADX INFO: renamed from: a */
    private void m11375a() {
        setOrientation(1);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11675a = onClickListener;
    }

    /* JADX INFO: renamed from: a */
    public void m11376a(List<DataItems.ChoiceDataItem.ChoiceValueDataItem> list, int i) {
        if (list != null) {
            for (DataItems.ChoiceDataItem.ChoiceValueDataItem choiceValueDataItem : list) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_pseudo_radio_button, (ViewGroup) null, false);
                viewInflate.setTag(choiceValueDataItem);
                if (viewInflate.findViewById(android.R.id.icon) != null) {
                    if (TextUtils.isEmpty(choiceValueDataItem.getIcon())) {
                        ((View) viewInflate.findViewById(android.R.id.icon).getParent()).setVisibility(8);
                    } else {
                        ((View) viewInflate.findViewById(android.R.id.icon).getParent()).setVisibility(0);
                        if (SkillsJsonParser.ImageUrlMatcher.isExternal(choiceValueDataItem.getIcon())) {
                            Glide.m5254b(getContext()).m5279a(choiceValueDataItem.getIcon()).mo5223b(DiskCacheStrategy.ALL).mo5239j().mo5216a((ImageView) viewInflate.findViewById(android.R.id.icon));
                        } else if (SkillsJsonParser.ImageUrlMatcher.getImageForUrl(choiceValueDataItem.getIcon()) != -1) {
                            ((ImageView) viewInflate.findViewById(android.R.id.icon)).setImageResource(SkillsJsonParser.ImageUrlMatcher.getImageForUrl(choiceValueDataItem.getIcon()));
                        }
                    }
                }
                if (viewInflate.findViewById(android.R.id.text1) != null) {
                    ((TextView) viewInflate.findViewById(android.R.id.text1)).setText(choiceValueDataItem.getValue());
                }
                if (viewInflate.findViewById(R.id.compound_button) != null) {
                    CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(R.id.compound_button);
                    compoundButton.setChecked(choiceValueDataItem.getId() == i);
                    compoundButton.setClickable(false);
                }
                viewInflate.setOnClickListener(this.f11675a);
                addView(viewInflate);
            }
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.divider_thickness));
                childAt.setLayoutParams(layoutParams);
            }
        }
    }
}
