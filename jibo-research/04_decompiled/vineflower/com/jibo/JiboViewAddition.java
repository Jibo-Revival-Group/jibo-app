package com.jibo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.salesforce.android.knowledge.ui.KnowledgeScene;
import com.salesforce.android.knowledge.ui.KnowledgeViewAddition;

public class JiboViewAddition implements KnowledgeViewAddition {
   @Override
   public Animator a(View var1) {
      AnimatorSet var2 = new AnimatorSet();
      var2.playTogether(
         new Animator[]{ObjectAnimator.ofFloat(var1, View.SCALE_X, new float[]{1.0F}), ObjectAnimator.ofFloat(var1, View.SCALE_Y, new float[]{1.0F})}
      );
      return var2;
   }

   @Override
   public View a(ViewGroup var1, Context var2) {
      return LayoutInflater.from(var2).inflate(2131427553, var1, false);
   }

   @Override
   public void a(View var1, boolean var2) {
      var1.setOnClickListener(new OnClickListener(this) {
         final JiboViewAddition a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            JiboSupport.b(var1.getContext());
         }
      });
      if (!var2) {
         var1.setScaleX(0.0F);
         var1.setScaleY(0.0F);
      }
   }

   @Override
   public boolean a(KnowledgeScene var1) {
      boolean var2;
      if (var1 != KnowledgeScene.SCENE_HOME && var1 != KnowledgeScene.SCENE_CATEGORY_DETAIL) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public Animator b(View var1) {
      AnimatorSet var2 = new AnimatorSet();
      var2.playTogether(
         new Animator[]{ObjectAnimator.ofFloat(var1, View.SCALE_X, new float[]{0.0F}), ObjectAnimator.ofFloat(var1, View.SCALE_Y, new float[]{0.0F})}
      );
      return var2;
   }
}
