package com.jibo.ui.fragment.guided;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.jibo.ui.activity.GuidedExperienceActivity;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.Util;

public class JiboAvatarSlideFragment extends AvatarsLocationBaseFragment {
   @BindView
   RecyclerView list;
   @BindView
   TextView txtInfo;

   @Override
   public void b(int var1) {
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.b = ((GuidedExperienceActivity)this.getActivity()).q();
      this.k();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427437, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      String var8 = this.getString(2131755337);
      String var7 = this.getString(2131755336, var8);
      SpannableStringBuilder var6 = new SpannableStringBuilder(var7);
      Util.CustomTypefaceSpan var5 = new Util.CustomTypefaceSpan("", ProximaHelper.d);
      int var3 = var7.indexOf(var8);
      int var4 = var7.indexOf(var8);
      var6.setSpan(var5, var3, var8.length() + var4, 33);
      this.txtInfo.setText(var6);
   }
}
