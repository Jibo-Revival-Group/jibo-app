package com.jibo.ui.fragment.guided;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;

public class WelcomeSlideFragment extends BaseFragment {
   @BindView
   public ImageView avatar;

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.k();
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427440, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Account var3 = EntityData.a(this.getActivity()).i();
      Glide.a(this.getActivity()).a(var3.getPhotoUrl()).c(2131231084).a(DiskCacheStrategy.ALL).a(this.avatar);
   }
}
