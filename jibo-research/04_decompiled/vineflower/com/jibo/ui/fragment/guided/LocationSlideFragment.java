package com.jibo.ui.fragment.guided;

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
import com.jibo.ui.fragment.dialog.LocationSetDialog;
import com.jibo.ui.fragment.settings.LocationFragment;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

public class LocationSlideFragment extends LocationFragment {
   @BindView
   TextView text2;
   @BindView
   TextView topText;

   @Override
   protected void a() {
      if (this.l != null && this.getUserVisibleHint()) {
         LocationSetDialog var2 = new LocationSetDialog();
         Bundle var1 = new Bundle();
         var1.putString("ARGS_LOCATION", this.l);
         var1.putString("ARGS_TIMEZONE", this.m);
         var2.setArguments(var1);
         var2.show(this.getActivity().getSupportFragmentManager(), LocationSetDialog.class.getSimpleName());
      }
   }

   @OnClick
   @Override
   public void btnSetLocationClick(View var1) {
      JiboAnalytics.l(this.getActivity());
      super.btnSetLocationClick(var1);
   }

   @Override
   protected String o() {
      return "";
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.k();
      this.setUserVisibleHint(false);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427439, var2, false);
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      String var5 = this.getString(2131755344);
      String var7 = this.getString(2131755347, var5);
      SpannableStringBuilder var8 = new SpannableStringBuilder(var7);
      var8.setSpan(new ForegroundColorSpan(ImageUtils.b(this.getActivity(), 2131099771)), var7.indexOf(var5), var7.indexOf(var5) + var5.length(), 33);
      var8.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), var7.indexOf(var5), var7.indexOf(var5) + var5.length(), 33);
      ClickableSpan var6 = new ClickableSpan(this) {
         final LocationSlideFragment a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a.getString(2131755373))));
         }

         public void updateDrawState(TextPaint var1) {
            var1.setUnderlineText(false);
         }
      };
      int var4 = var7.indexOf(var5);
      int var3 = var7.indexOf(var5);
      var8.setSpan(var6, var4, var5.length() + var3, 33);
      this.text2.setText(var8);
      this.text2.setMovementMethod(LinkMovementMethod.getInstance());
   }
}
