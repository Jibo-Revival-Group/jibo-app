package com.jibo.ui.fragment.tips;

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
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.helpers.RobotHelper;
import com.jibo.ui.activity.TipsActivity;
import com.jibo.ui.fragment.avatar.AvatarsAdapter;
import com.jibo.ui.fragment.avatar.AvatarsLocationBaseFragment;
import com.jibo.ui.view.proxima.CustomFontButton;
import com.jibo.ui.view.proxima.CustomFontTextView;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.Util;

public class TipsGuidedExperienceFragment extends AvatarsLocationBaseFragment {
   private String c = "TAG_TIP0";
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

   private void b() {
      String var3 = this.getString(2131755344);
      String var4 = this.getString(2131755903, var3);
      SpannableStringBuilder var6 = new SpannableStringBuilder(var4);
      var6.setSpan(new ForegroundColorSpan(ImageUtils.b(this.getActivity(), 2131099771)), var4.indexOf(var3), var4.indexOf(var3) + var3.length(), 33);
      var6.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.c), var4.indexOf(var3), var4.indexOf(var3) + var3.length(), 33);
      ClickableSpan var5 = new ClickableSpan(this) {
         final TipsGuidedExperienceFragment a;

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
      int var1 = var4.indexOf(var3);
      int var2 = var4.indexOf(var3);
      var6.setSpan(var5, var1, var3.length() + var2, 33);
      this.mContent2.setText(Html.fromHtml(this.getString(2131755902)));
      this.mContent3.setText(var6);
      this.mContent3.setMovementMethod(LinkMovementMethod.getInstance());
      this.mContent5.setText(Html.fromHtml(this.getString(2131755905)));
      this.mContent6.setText(Html.fromHtml(this.getString(2131755906)));
      this.mBtnNext.setText(this.getString(2131756009, this.getString(2131756017)));
   }

   private void q() {
   }

   private void r() {
      if (this.k != null) {
         this.a.getRobot(this.k.getRobotFriendlyId(), new AsyncHandler<GetRobotRequest, Robot>(this) {
            final TipsGuidedExperienceFragment a;

            {
               this.a = var1;
            }

            public void a(GetRobotRequest var1, Robot var2) {
               this.a.b = var2;
               this.a.a(new Runnable(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public void run() {
                     ((AvatarsAdapter)this.a.a.list.getAdapter()).a(RobotHelper.getAvatar(this.a.a.b));
                     this.a.a.list.getAdapter().notifyDataSetChanged();
                  }
               });
            }

            @Override
            public void onError(Exception var1) {
            }
         });
      }
   }

   @Override
   public void b(int var1) {
   }

   @OnClick
   @Override
   public void btnSetLocationClick(View var1) {
      JiboAnalytics.l(this.getActivity());
      super.btnSetLocationClick(var1);
   }

   @OnClick
   public void nextButton(View var1) {
      Intent var2 = new Intent();
      var2.setClass(this.getContext(), TipsActivity.class);
      var2.putExtra("ARGS_TAG", "TAG_TIP1");
      this.startActivity(var2);
      this.getActivity().finish();
   }

   @Override
   protected String o() {
      return this.getString(2131756016);
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131492873, var1);
      super.onCreateOptionsMenu(var1, var2);
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(2131427474, var2, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (2131296309 == var1.getItemId()) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131755752))));
         var2 = true;
      } else {
         var2 = super.onOptionsItemSelected(var1);
      }

      return var2;
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.b == null) {
         this.r();
      }
   }

   @Override
   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      this.b();
      this.q();
   }
}
