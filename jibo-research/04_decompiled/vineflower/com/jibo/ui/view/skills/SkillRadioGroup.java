package com.jibo.ui.view.skills;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.ui.helpers.skills.DataItems;
import com.jibo.ui.helpers.skills.SkillsJsonParser;
import java.util.List;

public class SkillRadioGroup extends LinearLayout {
   private OnClickListener a;

   public SkillRadioGroup(Context var1) {
      super(var1);
      this.a();
   }

   public SkillRadioGroup(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public SkillRadioGroup(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   public SkillRadioGroup(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.a();
   }

   private void a() {
      this.setOrientation(1);
   }

   public void a(List<DataItems.ChoiceDataItem.ChoiceValueDataItem> var1, int var2) {
      if (var1 != null) {
         for (DataItems.ChoiceDataItem.ChoiceValueDataItem var7 : var1) {
            View var6 = LayoutInflater.from(this.getContext()).inflate(2131427528, null, false);
            var6.setTag(var7);
            if (var6.findViewById(16908294) != null) {
               if (TextUtils.isEmpty(var7.getIcon())) {
                  ((View)var6.findViewById(16908294).getParent()).setVisibility(8);
               } else {
                  ((View)var6.findViewById(16908294).getParent()).setVisibility(0);
                  if (SkillsJsonParser.ImageUrlMatcher.isExternal(var7.getIcon())) {
                     Glide.b(this.getContext()).a(var7.getIcon()).a(DiskCacheStrategy.ALL).d().a((ImageView)var6.findViewById(16908294));
                  } else if (SkillsJsonParser.ImageUrlMatcher.getImageForUrl(var7.getIcon()) != -1) {
                     ((ImageView)var6.findViewById(16908294)).setImageResource(SkillsJsonParser.ImageUrlMatcher.getImageForUrl(var7.getIcon()));
                  }
               }
            }

            if (var6.findViewById(16908308) != null) {
               ((TextView)var6.findViewById(16908308)).setText(var7.getValue());
            }

            if (var6.findViewById(2131296486) != null) {
               CompoundButton var4 = (CompoundButton)var6.findViewById(2131296486);
               boolean var3;
               if (var7.getId() == var2) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4.setChecked(var3);
               var4.setClickable(false);
            }

            var6.setOnClickListener(this.a);
            this.addView(var6);
         }

         for (int var9 = 0; var9 < this.getChildCount(); var9++) {
            View var10 = this.getChildAt(var9);
            LayoutParams var8 = (LayoutParams)var10.getLayoutParams();
            var8.setMargins(0, 0, 0, this.getContext().getResources().getDimensionPixelOffset(2131165366));
            var10.setLayoutParams(var8);
         }
      }
   }

   public void setOnClickListener(OnClickListener var1) {
      this.a = var1;
   }
}
