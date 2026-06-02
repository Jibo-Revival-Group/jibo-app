package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("ClickableViewAccessibility")
@TargetApi(16)
public class TakeoverInAppActivity extends Activity {
   private MixpanelAPI a;
   private UpdateDisplayState b;
   private int c = -1;

   private void a() {
      this.setContentView(R.layout.com_mixpanel_android_activity_notification_full);
      ImageView var11 = (ImageView)this.findViewById(R.id.com_mixpanel_android_notification_gradient);
      FadingImageView var2 = (FadingImageView)this.findViewById(R.id.com_mixpanel_android_notification_image);
      TextView var6 = (TextView)this.findViewById(R.id.com_mixpanel_android_notification_title);
      TextView var9 = (TextView)this.findViewById(R.id.com_mixpanel_android_notification_subtext);
      ArrayList var3 = new ArrayList();
      Button var4 = (Button)this.findViewById(R.id.com_mixpanel_android_notification_button);
      var3.add(var4);
      var3.add((Button)this.findViewById(R.id.com_mixpanel_android_notification_second_button));
      LinearLayout var7 = (LinearLayout)this.findViewById(R.id.com_mixpanel_android_button_exit_wrapper);
      ImageView var5 = (ImageView)this.findViewById(R.id.com_mixpanel_android_image_close);
      TakeoverInAppNotification var8 = (TakeoverInAppNotification)((UpdateDisplayState.DisplayState.InAppNotificationState)this.b.c()).a();
      Display var12 = this.getWindowManager().getDefaultDisplay();
      Point var10 = new Point();
      var12.getSize(var10);
      if (this.getResources().getConfiguration().orientation == 1) {
         LayoutParams var15 = (LayoutParams)var7.getLayoutParams();
         var15.setMargins(0, 0, 0, (int)(var10.y * 0.06F));
         var7.setLayoutParams(var15);
      }

      var2.a(var8.s());
      var11.setBackgroundColor(var8.e());
      if (var8.n()) {
         var6.setVisibility(0);
         var6.setText(var8.o());
         var6.setTextColor(var8.p());
      } else {
         var6.setVisibility(8);
      }

      if (var8.f()) {
         var9.setVisibility(0);
         var9.setText(var8.g());
         var9.setTextColor(var8.h());
      } else {
         var9.setVisibility(8);
      }

      var2.setImageBitmap(var8.l());

      for (int var1 = 0; var1 < var3.size(); var1++) {
         InAppButton var13 = var8.a(var1);
         this.a((Button)var3.get(var1), var13, var8, var1);
      }

      if (var8.r() == 1) {
         android.widget.LinearLayout.LayoutParams var14 = (android.widget.LinearLayout.LayoutParams)var4.getLayoutParams();
         var14.weight = 0.0F;
         var14.width = -2;
         var4.setLayoutParams(var14);
      }

      var5.setColorFilter(var8.q());
      var7.setOnClickListener(new OnClickListener(this) {
         final TakeoverInAppActivity a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.finish();
            UpdateDisplayState.a(this.a.c);
         }
      });
      this.a(var2, var6, var9, var3, var7);
   }

   private void a(Button var1, InAppButton var2, InAppNotification var3, int var4) {
      int var5 = 864454278;
      if (var2 != null) {
         var1.setVisibility(0);
         var1.setText(var2.a());
         var1.setTextColor(var2.b());
         var1.setTransformationMethod(null);
         GradientDrawable var6 = new GradientDrawable();
         if (var2.c() != 0) {
            var5 = ViewUtils.a(var2.c(), 864454278);
         }

         var1.setOnTouchListener(new OnTouchListener(this, var5, var6, var2) {
            final int a;
            final GradientDrawable b;
            final InAppButton c;
            final TakeoverInAppActivity d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public boolean onTouch(View var1, MotionEvent var2x) {
               if (var2x.getAction() == 0) {
                  int var3x = this.a;
                  this.b.setColor(var3x);
               } else {
                  this.b.setColor(this.c.c());
               }

               return false;
            }
         });
         var6.setColor(var2.c());
         var6.setStroke((int)ViewUtils.a(2.0F, this), var2.d());
         var6.setCornerRadius((int)ViewUtils.a(5.0F, this));
         if (VERSION.SDK_INT < 16) {
            var1.setBackgroundDrawable(var6);
         } else {
            var1.setBackground(var6);
         }

         var1.setOnClickListener(new OnClickListener(this, var2, var3, var4) {
            final InAppButton a;
            final InAppNotification b;
            final int c;
            final TakeoverInAppActivity d;

            {
               this.d = var1;
               this.a = var2x;
               this.b = var3x;
               this.c = var4x;
            }

            public void onClick(View var1) {
               Uri var2x = null;
               String var3x = this.a.e();
               JSONObject var10 = var2x;
               if (var3x != null) {
                  var10 = var2x;
                  label54:
                  if (var3x.length() > 0) {
                     try {
                        var2x = Uri.parse(var3x);
                     } catch (IllegalArgumentException var7) {
                        MPLog.c("MixpanelAPI.TakeoverInAppActivity", "Can't parse notification URI, will not take any action", var7);
                        return;
                     }

                     try {
                        Intent var11 = new Intent("android.intent.action.VIEW", var2x);
                        this.d.startActivity(var11);
                     } catch (ActivityNotFoundException var4x) {
                        MPLog.c("MixpanelAPI.TakeoverInAppActivity", "User doesn't have an activity for notification URI");
                     }

                     label63: {
                        try {
                           var10 = new JSONObject();
                        } catch (JSONException var9) {
                           var10 = null;
                           break label63;
                        }

                        try {
                           var10.put("url", var3x);
                           break label54;
                        } catch (JSONException var8) {
                        }
                     }

                     MPLog.e("MixpanelAPI.TakeoverInAppActivity", "Can't put url into json properties");
                  }
               }

               String var13 = "primary";
               if (((TakeoverInAppNotification)this.b).r() == 2) {
                  if (this.c == 0) {
                     var13 = "secondary";
                  } else {
                     var13 = "primary";
                  }
               }

               label47: {
                  label46: {
                     if (var10 == null) {
                        try {
                           var14 = new JSONObject();
                        } catch (JSONException var6x) {
                           break label46;
                        }

                        var10 = var14;
                     }

                     try {
                        var10.put("button", var13);
                        break label47;
                     } catch (JSONException var5x) {
                     }
                  }

                  MPLog.e("MixpanelAPI.TakeoverInAppActivity", "Can't put button type into json properties");
               }

               this.d.a.c().a("$campaign_open", this.b, var10);
               this.d.finish();
               UpdateDisplayState.a(this.d.c);
            }
         });
      } else {
         var1.setVisibility(8);
      }
   }

   private void a(ImageView var1, TextView var2, TextView var3, ArrayList<Button> var4, LinearLayout var5) {
      ScaleAnimation var6 = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 1.0F);
      var6.setDuration(200L);
      var1.startAnimation(var6);
      TranslateAnimation var7 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.5F, 1, 0.0F);
      var7.setInterpolator(new DecelerateInterpolator());
      var7.setDuration(200L);
      var2.startAnimation(var7);
      var3.startAnimation(var7);
      Iterator var8 = var4.iterator();

      while (var8.hasNext()) {
         ((Button)var8.next()).startAnimation(var7);
      }

      var5.startAnimation(AnimationUtils.loadAnimation(this, R.anim.com_mixpanel_android_fade_in));
   }

   public void onBackPressed() {
      UpdateDisplayState.a(this.c);
      super.onBackPressed();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.c = this.getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", Integer.MAX_VALUE);
      this.b = UpdateDisplayState.b(this.c);
      if (this.b == null) {
         MPLog.e("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
         this.finish();
      } else {
         this.a = MixpanelAPI.a(this, this.b.d());
         this.a();
      }
   }
}
