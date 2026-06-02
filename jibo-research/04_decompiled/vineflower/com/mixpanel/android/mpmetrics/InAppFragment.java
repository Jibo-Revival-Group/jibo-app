package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.R;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("ClickableViewAccessibility")
@TargetApi(16)
public class InAppFragment extends Fragment {
   private MixpanelAPI a;
   private Activity b;
   private GestureDetector c;
   private Handler d;
   private int e;
   private UpdateDisplayState.DisplayState.InAppNotificationState f;
   private Runnable g;
   private Runnable h;
   private View i;
   private boolean j;

   private void a() {
      if (!this.j) {
         this.d.removeCallbacks(this.g);
         this.d.removeCallbacks(this.h);
         UpdateDisplayState.a(this.e);
         this.b.getFragmentManager().beginTransaction().remove(this).commit();
      }

      this.j = true;
   }

   private void b() {
      boolean var1;
      if (VERSION.SDK_INT >= 17) {
         var1 = this.b.isDestroyed();
      } else {
         var1 = false;
      }

      if (this.b != null && !this.b.isFinishing() && !var1 && !this.j) {
         this.d.removeCallbacks(this.g);
         this.d.removeCallbacks(this.h);
         this.b.getFragmentManager().beginTransaction().setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(this).commit();
         UpdateDisplayState.a(this.e);
         this.j = true;
      }
   }

   public void a(MixpanelAPI var1, int var2, UpdateDisplayState.DisplayState.InAppNotificationState var3) {
      this.a = var1;
      this.e = var2;
      this.f = var3;
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.b = var1;
      if (this.f == null) {
         this.a();
      } else {
         this.d = new Handler();
         this.g = new Runnable(this) {
            final InAppFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.b();
            }
         };
         this.h = new Runnable(this) {
            final InAppFragment a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.i.setVisibility(0);
               this.a.i.setOnTouchListener(new OnTouchListener(this) {
                  final <unrepresentable> a;

                  {
                     this.a = var1;
                  }

                  public boolean onTouch(View var1, MotionEvent var2) {
                     return this.a.a.c.onTouchEvent(var2);
                  }
               });
               ImageView var2 = (ImageView)this.a.i.findViewById(R.id.com_mixpanel_android_notification_image);
               float var1 = TypedValue.applyDimension(1, 65.0F, this.a.b.getResources().getDisplayMetrics());
               TranslateAnimation var3 = new TranslateAnimation(0.0F, 0.0F, var1, 0.0F);
               var3.setInterpolator(new DecelerateInterpolator());
               var3.setDuration(200L);
               this.a.i.startAnimation(var3);
               ScaleAnimation var4 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, var1 / 2.0F, var1 / 2.0F);
               var4.setInterpolator(this.a.new SineBounceInterpolator(this.a));
               var4.setDuration(400L);
               var4.setStartOffset(200L);
               var2.startAnimation(var4);
            }
         };
         this.c = new GestureDetector(var1, new OnGestureListener(this) {
            final InAppFragment a;

            {
               this.a = var1;
            }

            public boolean onDown(MotionEvent var1) {
               return true;
            }

            public boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
               if (var4 > 0.0F) {
                  this.a.b();
               }

               return true;
            }

            public void onLongPress(MotionEvent var1) {
            }

            public boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
               return false;
            }

            public void onShowPress(MotionEvent var1) {
            }

            public boolean onSingleTapUp(MotionEvent var1) {
               MiniInAppNotification var2;
               var2 = (MiniInAppNotification)this.a.f.a();
               String var3 = var2.n();
               label37:
               if (var3 != null && var3.length() > 0) {
                  try {
                     var10 = Uri.parse(var3);
                  } catch (IllegalArgumentException var6) {
                     MPLog.c("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", var6);
                     return true;
                  }

                  try {
                     Intent var4 = new Intent("android.intent.action.VIEW", var10);
                     this.a.b.startActivity(var4);
                  } catch (ActivityNotFoundException var5) {
                     MPLog.c("MixpanelAPI.InAppFrag", "User doesn't have an activity for notification URI " + var10);
                  }

                  label33: {
                     try {
                        var9 = new JSONObject();
                     } catch (JSONException var8) {
                        var9 = null;
                        break label33;
                     }

                     try {
                        var9.put("url", var3);
                        break label37;
                     } catch (JSONException var7) {
                     }
                  }

                  MPLog.e("MixpanelAPI.InAppFrag", "Can't put url into json properties");
               } else {
                  var9 = null;
               }

               this.a.a.c().a("$campaign_open", var2, var9);
               this.a.b();
               return true;
            }
         });
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.j = false;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      super.onCreateView(var1, var2, var3);
      if (this.f == null) {
         this.a();
      } else {
         this.i = var1.inflate(R.layout.com_mixpanel_android_activity_notification_mini, var2, false);
         TextView var6 = (TextView)this.i.findViewById(R.id.com_mixpanel_android_notification_title);
         ImageView var4 = (ImageView)this.i.findViewById(R.id.com_mixpanel_android_notification_image);
         MiniInAppNotification var5 = (MiniInAppNotification)this.f.a();
         var6.setText(var5.g());
         var6.setTextColor(var5.h());
         var4.setImageBitmap(var5.l());
         this.d.postDelayed(this.g, 10000L);
         GradientDrawable var7 = new GradientDrawable();
         var7.setColor(var5.e());
         var7.setCornerRadius(ViewUtils.a(7.0F, this.getActivity()));
         var7.setStroke((int)ViewUtils.a(2.0F, this.getActivity()), var5.p());
         if (VERSION.SDK_INT < 16) {
            this.i.setBackgroundDrawable(var7);
         } else {
            this.i.setBackground(var7);
         }

         BitmapDrawable var8 = new BitmapDrawable(this.getResources(), this.f.a().l());
         var8.setColorFilter(var5.o(), Mode.SRC_ATOP);
         var4.setImageDrawable(var8);
      }

      return this.i;
   }

   public void onPause() {
      super.onPause();
      this.a();
   }

   public void onResume() {
      super.onResume();
      this.d.postDelayed(this.h, 500L);
   }

   public void onSaveInstanceState(Bundle var1) {
      this.a();
      super.onSaveInstanceState(var1);
   }

   public void onStart() {
      super.onStart();
      if (this.j) {
         this.b.getFragmentManager().beginTransaction().remove(this).commit();
      }
   }

   private class SineBounceInterpolator implements Interpolator {
      final InAppFragment a;

      public SineBounceInterpolator(InAppFragment var1) {
         this.a = var1;
      }

      public float getInterpolation(float var1) {
         return (float)(-(Math.pow(Math.E, -8.0F * var1) * Math.cos(12.0F * var1))) + 1.0F;
      }
   }
}
