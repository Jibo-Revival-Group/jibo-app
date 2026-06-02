package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class TakeoverInAppActivity extends Activity {

    /* JADX INFO: renamed from: a */
    private MixpanelAPI f12067a;

    /* JADX INFO: renamed from: b */
    private UpdateDisplayState f12068b;

    /* JADX INFO: renamed from: c */
    private int f12069c = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12069c = getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", Integer.MAX_VALUE);
        this.f12068b = UpdateDisplayState.m11974b(this.f12069c);
        if (this.f12068b == null) {
            MPLog.m12030e("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
            finish();
        } else {
            this.f12067a = MixpanelAPI.m11814a(this, this.f12068b.m11977d());
            m11992a();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11992a() {
        setContentView(R.layout.com_mixpanel_android_activity_notification_full);
        ImageView imageView = (ImageView) findViewById(R.id.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView) findViewById(R.id.com_mixpanel_android_notification_image);
        TextView textView = (TextView) findViewById(R.id.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView) findViewById(R.id.com_mixpanel_android_notification_subtext);
        ArrayList<Button> arrayList = new ArrayList<>();
        Button button = (Button) findViewById(R.id.com_mixpanel_android_notification_button);
        arrayList.add(button);
        arrayList.add((Button) findViewById(R.id.com_mixpanel_android_notification_second_button));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.com_mixpanel_android_button_exit_wrapper);
        ImageView imageView2 = (ImageView) findViewById(R.id.com_mixpanel_android_image_close);
        TakeoverInAppNotification takeoverInAppNotification = (TakeoverInAppNotification) ((UpdateDisplayState.DisplayState.InAppNotificationState) this.f12068b.m11976c()).m11985a();
        getWindowManager().getDefaultDisplay().getSize(new Point());
        if (getResources().getConfiguration().orientation == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (r11.y * 0.06f));
            linearLayout.setLayoutParams(layoutParams);
        }
        fadingImageView.m11989a(takeoverInAppNotification.m11950s());
        imageView.setBackgroundColor(takeoverInAppNotification.m11752e());
        if (takeoverInAppNotification.m11945n()) {
            textView.setVisibility(0);
            textView.setText(takeoverInAppNotification.m11946o());
            textView.setTextColor(takeoverInAppNotification.m11947p());
        } else {
            textView.setVisibility(8);
        }
        if (takeoverInAppNotification.m11753f()) {
            textView2.setVisibility(0);
            textView2.setText(takeoverInAppNotification.m11754g());
            textView2.setTextColor(takeoverInAppNotification.m11755h());
        } else {
            textView2.setVisibility(8);
        }
        fadingImageView.setImageBitmap(takeoverInAppNotification.m11759l());
        for (int i = 0; i < arrayList.size(); i++) {
            m11993a(arrayList.get(i), takeoverInAppNotification.m11944a(i), takeoverInAppNotification, i);
        }
        if (takeoverInAppNotification.m11949r() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams2.weight = CropImageView.DEFAULT_ASPECT_RATIO;
            layoutParams2.width = -2;
            button.setLayoutParams(layoutParams2);
        }
        imageView2.setColorFilter(takeoverInAppNotification.m11948q());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TakeoverInAppActivity.this.finish();
                UpdateDisplayState.m11973a(TakeoverInAppActivity.this.f12069c);
            }
        });
        m11994a(fadingImageView, textView, textView2, arrayList, linearLayout);
    }

    /* JADX INFO: renamed from: a */
    private void m11993a(Button button, final InAppButton inAppButton, final InAppNotification inAppNotification, final int i) {
        if (inAppButton != null) {
            button.setVisibility(0);
            button.setText(inAppButton.m11730a());
            button.setTextColor(inAppButton.m11731b());
            button.setTransformationMethod(null);
            final GradientDrawable gradientDrawable = new GradientDrawable();
            final int iM12037a = inAppButton.m11732c() != 0 ? ViewUtils.m12037a(inAppButton.m11732c(), 864454278) : 864454278;
            button.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        gradientDrawable.setColor(iM12037a);
                        return false;
                    }
                    gradientDrawable.setColor(inAppButton.m11732c());
                    return false;
                }
            });
            gradientDrawable.setColor(inAppButton.m11732c());
            gradientDrawable.setStroke((int) ViewUtils.m12036a(2.0f, this), inAppButton.m11733d());
            gradientDrawable.setCornerRadius((int) ViewUtils.m12036a(5.0f, this));
            if (Build.VERSION.SDK_INT < 16) {
                button.setBackgroundDrawable(gradientDrawable);
            } else {
                button.setBackground(gradientDrawable);
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObject;
                    JSONObject jSONObject2;
                    JSONObject jSONObject3 = null;
                    String strM11734e = inAppButton.m11734e();
                    if (strM11734e != null && strM11734e.length() > 0) {
                        try {
                            try {
                                TakeoverInAppActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strM11734e)));
                            } catch (ActivityNotFoundException e) {
                                MPLog.m12026c("MixpanelAPI.TakeoverInAppActivity", "User doesn't have an activity for notification URI");
                            }
                            try {
                                jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("url", strM11734e);
                                    jSONObject3 = jSONObject2;
                                } catch (JSONException e2) {
                                    MPLog.m12030e("MixpanelAPI.TakeoverInAppActivity", "Can't put url into json properties");
                                    jSONObject3 = jSONObject2;
                                }
                            } catch (JSONException e3) {
                                jSONObject2 = null;
                            }
                        } catch (IllegalArgumentException e4) {
                            MPLog.m12027c("MixpanelAPI.TakeoverInAppActivity", "Can't parse notification URI, will not take any action", e4);
                            return;
                        }
                    }
                    String str = "primary";
                    if (((TakeoverInAppNotification) inAppNotification).m11949r() == 2) {
                        str = i == 0 ? "secondary" : "primary";
                    }
                    if (jSONObject3 == null) {
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException e5) {
                            jSONObject = jSONObject3;
                            MPLog.m12030e("MixpanelAPI.TakeoverInAppActivity", "Can't put button type into json properties");
                            TakeoverInAppActivity.this.f12067a.m11842c().mo11864a("$campaign_open", inAppNotification, jSONObject);
                            TakeoverInAppActivity.this.finish();
                            UpdateDisplayState.m11973a(TakeoverInAppActivity.this.f12069c);
                        }
                    } else {
                        jSONObject = jSONObject3;
                    }
                    try {
                        jSONObject.put("button", str);
                    } catch (JSONException e6) {
                        MPLog.m12030e("MixpanelAPI.TakeoverInAppActivity", "Can't put button type into json properties");
                    }
                    TakeoverInAppActivity.this.f12067a.m11842c().mo11864a("$campaign_open", inAppNotification, jSONObject);
                    TakeoverInAppActivity.this.finish();
                    UpdateDisplayState.m11973a(TakeoverInAppActivity.this.f12069c);
                }
            });
            return;
        }
        button.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    private void m11994a(ImageView imageView, TextView textView, TextView textView2, ArrayList<Button> arrayList, LinearLayout linearLayout) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200L);
        imageView.startAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, CropImageView.DEFAULT_ASPECT_RATIO, 1, CropImageView.DEFAULT_ASPECT_RATIO, 1, 0.5f, 1, CropImageView.DEFAULT_ASPECT_RATIO);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200L);
        textView.startAnimation(translateAnimation);
        textView2.startAnimation(translateAnimation);
        Iterator<Button> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().startAnimation(translateAnimation);
        }
        linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.com_mixpanel_android_fade_in));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        UpdateDisplayState.m11973a(this.f12069c);
        super.onBackPressed();
    }
}
