package com.jibo.ui.fragment.tips;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment_ViewBinding;
import com.jibo.ui.view.proxima.CustomFontButton;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class TipsGuidedExperienceFragment_ViewBinding extends AvatarsLocationBaseFragment_ViewBinding {
   private TipsGuidedExperienceFragment b;
   private View c;
   private View d;

   public TipsGuidedExperienceFragment_ViewBinding(TipsGuidedExperienceFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      View var3 = Utils.a(var2, 2131296376, "field 'mBtnNext' and method 'nextButton'");
      var1.mBtnNext = Utils.c(var3, 2131296376, "field 'mBtnNext'", CustomFontButton.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final TipsGuidedExperienceFragment b;
         final TipsGuidedExperienceFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.nextButton(var1);
         }
      });
      var1.mContent2 = Utils.b(var2, 2131296493, "field 'mContent2'", CustomFontTextView.class);
      var1.mContent3 = Utils.b(var2, 2131296494, "field 'mContent3'", CustomFontTextView.class);
      var1.mContent5 = Utils.b(var2, 2131296496, "field 'mContent5'", CustomFontTextView.class);
      var1.mContent6 = Utils.b(var2, 2131296497, "field 'mContent6'", CustomFontTextView.class);
      var2 = Utils.a(var2, 2131296495, "method 'btnSetLocationClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final TipsGuidedExperienceFragment b;
         final TipsGuidedExperienceFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnSetLocationClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      TipsGuidedExperienceFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
      var1.mBtnNext = null;
      var1.mContent2 = null;
      var1.mContent3 = null;
      var1.mContent5 = null;
      var1.mContent6 = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
