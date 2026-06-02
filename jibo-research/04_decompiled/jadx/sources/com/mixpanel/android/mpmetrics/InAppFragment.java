package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import com.yalantis.ucrop.view.CropImageView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class InAppFragment extends Fragment {

    /* JADX INFO: renamed from: a */
    private MixpanelAPI f11883a;

    /* JADX INFO: renamed from: b */
    private Activity f11884b;

    /* JADX INFO: renamed from: c */
    private GestureDetector f11885c;

    /* JADX INFO: renamed from: d */
    private Handler f11886d;

    /* JADX INFO: renamed from: e */
    private int f11887e;

    /* JADX INFO: renamed from: f */
    private UpdateDisplayState.DisplayState.InAppNotificationState f11888f;

    /* JADX INFO: renamed from: g */
    private Runnable f11889g;

    /* JADX INFO: renamed from: h */
    private Runnable f11890h;

    /* JADX INFO: renamed from: i */
    private View f11891i;

    /* JADX INFO: renamed from: j */
    private boolean f11892j;

    /* JADX INFO: renamed from: a */
    public void m11745a(MixpanelAPI mixpanelAPI, int i, UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState) {
        this.f11883a = mixpanelAPI;
        this.f11887e = i;
        this.f11888f = inAppNotificationState;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11884b = activity;
        if (this.f11888f == null) {
            m11737a();
            return;
        }
        this.f11886d = new Handler();
        this.f11889g = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.1
            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.this.m11740b();
            }
        };
        this.f11890h = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2
            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.this.f11891i.setVisibility(0);
                InAppFragment.this.f11891i.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return InAppFragment.this.f11885c.onTouchEvent(motionEvent);
                    }
                });
                ImageView imageView = (ImageView) InAppFragment.this.f11891i.findViewById(R.id.com_mixpanel_android_notification_image);
                float fApplyDimension = TypedValue.applyDimension(1, 65.0f, InAppFragment.this.f11884b.getResources().getDisplayMetrics());
                TranslateAnimation translateAnimation = new TranslateAnimation(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, fApplyDimension, CropImageView.DEFAULT_ASPECT_RATIO);
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                translateAnimation.setDuration(200L);
                InAppFragment.this.f11891i.startAnimation(translateAnimation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, fApplyDimension / 2.0f, fApplyDimension / 2.0f);
                scaleAnimation.setInterpolator(InAppFragment.this.new SineBounceInterpolator());
                scaleAnimation.setDuration(400L);
                scaleAnimation.setStartOffset(200L);
                imageView.startAnimation(scaleAnimation);
            }
        };
        this.f11885c = new GestureDetector(activity, new GestureDetector.OnGestureListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.3
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (f2 > CropImageView.DEFAULT_ASPECT_RATIO) {
                    InAppFragment.this.m11740b();
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                JSONObject jSONObject;
                MiniInAppNotification miniInAppNotification = (MiniInAppNotification) InAppFragment.this.f11888f.m11985a();
                String strM11809n = miniInAppNotification.m11809n();
                if (strM11809n == null || strM11809n.length() <= 0) {
                    jSONObject = null;
                } else {
                    try {
                        Uri uri = Uri.parse(strM11809n);
                        try {
                            InAppFragment.this.f11884b.startActivity(new Intent("android.intent.action.VIEW", uri));
                        } catch (ActivityNotFoundException e) {
                            MPLog.m12026c("MixpanelAPI.InAppFrag", "User doesn't have an activity for notification URI " + uri);
                        }
                        try {
                            jSONObject = new JSONObject();
                            try {
                                jSONObject.put("url", strM11809n);
                            } catch (JSONException e2) {
                                MPLog.m12030e("MixpanelAPI.InAppFrag", "Can't put url into json properties");
                            }
                        } catch (JSONException e3) {
                            jSONObject = null;
                        }
                    } catch (IllegalArgumentException e4) {
                        MPLog.m12027c("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", e4);
                    }
                }
                InAppFragment.this.f11883a.m11842c().mo11864a("$campaign_open", miniInAppNotification, jSONObject);
                InAppFragment.this.m11740b();
                return true;
            }
        });
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11892j = false;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f11888f == null) {
            m11737a();
        } else {
            this.f11891i = layoutInflater.inflate(R.layout.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            TextView textView = (TextView) this.f11891i.findViewById(R.id.com_mixpanel_android_notification_title);
            ImageView imageView = (ImageView) this.f11891i.findViewById(R.id.com_mixpanel_android_notification_image);
            MiniInAppNotification miniInAppNotification = (MiniInAppNotification) this.f11888f.m11985a();
            textView.setText(miniInAppNotification.m11754g());
            textView.setTextColor(miniInAppNotification.m11755h());
            imageView.setImageBitmap(miniInAppNotification.m11759l());
            this.f11886d.postDelayed(this.f11889g, 10000L);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(miniInAppNotification.m11752e());
            gradientDrawable.setCornerRadius(ViewUtils.m12036a(7.0f, getActivity()));
            gradientDrawable.setStroke((int) ViewUtils.m12036a(2.0f, getActivity()), miniInAppNotification.m11811p());
            if (Build.VERSION.SDK_INT < 16) {
                this.f11891i.setBackgroundDrawable(gradientDrawable);
            } else {
                this.f11891i.setBackground(gradientDrawable);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.f11888f.m11985a().m11759l());
            bitmapDrawable.setColorFilter(miniInAppNotification.m11810o(), PorterDuff.Mode.SRC_ATOP);
            imageView.setImageDrawable(bitmapDrawable);
        }
        return this.f11891i;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f11892j) {
            this.f11884b.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f11886d.postDelayed(this.f11890h, 500L);
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        m11737a();
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m11737a();
    }

    /* JADX INFO: renamed from: a */
    private void m11737a() {
        if (!this.f11892j) {
            this.f11886d.removeCallbacks(this.f11889g);
            this.f11886d.removeCallbacks(this.f11890h);
            UpdateDisplayState.m11973a(this.f11887e);
            this.f11884b.getFragmentManager().beginTransaction().remove(this).commit();
        }
        this.f11892j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m11740b() {
        boolean zIsDestroyed = Build.VERSION.SDK_INT >= 17 ? this.f11884b.isDestroyed() : false;
        if (this.f11884b != null && !this.f11884b.isFinishing() && !zIsDestroyed && !this.f11892j) {
            this.f11886d.removeCallbacks(this.f11889g);
            this.f11886d.removeCallbacks(this.f11890h);
            this.f11884b.getFragmentManager().beginTransaction().setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down).remove(this).commit();
            UpdateDisplayState.m11973a(this.f11887e);
            this.f11892j = true;
        }
    }

    private class SineBounceInterpolator implements Interpolator {
        public SineBounceInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) (-(Math.pow(2.718281828459045d, (-8.0f) * f) * Math.cos(12.0f * f)))) + 1.0f;
        }
    }
}
