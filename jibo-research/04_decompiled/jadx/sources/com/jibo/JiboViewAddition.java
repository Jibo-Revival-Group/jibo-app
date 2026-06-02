package com.jibo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class JiboViewAddition implements KnowledgeViewAddition {
    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition
    /* JADX INFO: renamed from: a */
    public View mo9878a(ViewGroup viewGroup, Context context) {
        return LayoutInflater.from(context).inflate(R.layout.jibo_view_addition, viewGroup, false);
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition
    /* JADX INFO: renamed from: a */
    public void mo9879a(View view, boolean z) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.jibo.JiboViewAddition.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                JiboSupport.m9870b(view2.getContext());
            }
        });
        if (!z) {
            view.setScaleX(CropImageView.DEFAULT_ASPECT_RATIO);
            view.setScaleY(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition
    /* JADX INFO: renamed from: a */
    public Animator mo9877a(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        return animatorSet;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition
    /* JADX INFO: renamed from: b */
    public Animator mo9881b(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, CropImageView.DEFAULT_ASPECT_RATIO), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, CropImageView.DEFAULT_ASPECT_RATIO));
        return animatorSet;
    }

    @Override // com.salesforce.android.knowledge.p022ui.KnowledgeViewAddition
    /* JADX INFO: renamed from: a */
    public boolean mo9880a(KnowledgeScene knowledgeScene) {
        return knowledgeScene == KnowledgeScene.SCENE_HOME || knowledgeScene == KnowledgeScene.SCENE_CATEGORY_DETAIL;
    }
}
