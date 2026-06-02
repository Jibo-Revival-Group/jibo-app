package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

/* JADX INFO: loaded from: classes.dex */
public class GestureTracker {
    public GestureTracker(MixpanelAPI mixpanelAPI, Activity activity) {
        m12084a(mixpanelAPI, activity);
    }

    /* JADX INFO: renamed from: a */
    private void m12084a(MixpanelAPI mixpanelAPI, Activity activity) {
        activity.getWindow().getDecorView().setOnTouchListener(m12083a(mixpanelAPI));
    }

    /* JADX INFO: renamed from: a */
    private View.OnTouchListener m12083a(final MixpanelAPI mixpanelAPI) {
        return new View.OnTouchListener() { // from class: com.mixpanel.android.viewcrawler.GestureTracker.1

            /* JADX INFO: renamed from: c */
            private long f12137c = -1;

            /* JADX INFO: renamed from: d */
            private long f12138d = -1;

            /* JADX INFO: renamed from: e */
            private int f12139e = 0;

            /* JADX INFO: renamed from: f */
            private long f12140f = -1;

            /* JADX INFO: renamed from: g */
            private boolean f12141g = false;

            /* JADX INFO: renamed from: h */
            private final int f12142h = 100;

            /* JADX INFO: renamed from: i */
            private final int f12143i = 1000;

            /* JADX INFO: renamed from: j */
            private final int f12144j = 2500;

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() > 2) {
                    m12085a();
                } else {
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            this.f12138d = System.currentTimeMillis();
                            break;
                        case 1:
                            if (System.currentTimeMillis() - this.f12138d < 100) {
                                if (System.currentTimeMillis() - this.f12137c >= 2500) {
                                    if (this.f12139e == 3) {
                                        mixpanelAPI.m11841b("$ab_gesture1");
                                        m12085a();
                                    }
                                    this.f12139e = 0;
                                } else {
                                    this.f12140f = System.currentTimeMillis();
                                    if (this.f12139e < 4) {
                                        this.f12139e++;
                                    } else if (this.f12139e == 4) {
                                        mixpanelAPI.m11841b("$ab_gesture2");
                                        m12085a();
                                    } else {
                                        m12085a();
                                    }
                                }
                            }
                            break;
                        case 5:
                            if (System.currentTimeMillis() - this.f12138d < 100) {
                                if (System.currentTimeMillis() - this.f12140f > 1000) {
                                    m12085a();
                                }
                                this.f12137c = System.currentTimeMillis();
                                this.f12141g = true;
                            } else {
                                m12085a();
                            }
                            break;
                        case 6:
                            if (this.f12141g) {
                                this.f12138d = System.currentTimeMillis();
                            } else {
                                m12085a();
                            }
                            break;
                    }
                }
                return false;
            }

            /* JADX INFO: renamed from: a */
            private void m12085a() {
                this.f12138d = -1L;
                this.f12137c = -1L;
                this.f12139e = 0;
                this.f12140f = -1L;
                this.f12141g = false;
            }
        };
    }
}
