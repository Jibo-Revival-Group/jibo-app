package com.mixpanel.android.viewcrawler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.mixpanel.android.util.MPLog;

/* JADX INFO: loaded from: classes.dex */
class FlipGesture implements SensorEventListener {

    /* JADX INFO: renamed from: a */
    private int f12130a = -1;

    /* JADX INFO: renamed from: b */
    private int f12131b = 0;

    /* JADX INFO: renamed from: c */
    private long f12132c = -1;

    /* JADX INFO: renamed from: d */
    private final float[] f12133d = new float[3];

    /* JADX INFO: renamed from: e */
    private final OnFlipGestureListener f12134e;

    public interface OnFlipGestureListener {
        /* JADX INFO: renamed from: a */
        void mo12082a();
    }

    public FlipGesture(OnFlipGestureListener onFlipGestureListener) {
        this.f12134e = onFlipGestureListener;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArrM12081a = m12081a(sensorEvent.values);
        int i = this.f12131b;
        float f = (fArrM12081a[0] * fArrM12081a[0]) + (fArrM12081a[1] * fArrM12081a[1]) + (fArrM12081a[2] * fArrM12081a[2]);
        this.f12131b = 0;
        if (fArrM12081a[2] > 7.8f && fArrM12081a[2] < 11.8f) {
            this.f12131b = -1;
        }
        if (fArrM12081a[2] < -7.8f && fArrM12081a[2] > -11.8f) {
            this.f12131b = 1;
        }
        if (f < 60.840004f || f > 139.24f) {
            this.f12131b = 0;
        }
        if (i != this.f12131b) {
            this.f12132c = sensorEvent.timestamp;
        }
        long j = sensorEvent.timestamp - this.f12132c;
        switch (this.f12131b) {
            case -1:
                if (j > 250000000 && this.f12130a == 1) {
                    MPLog.m12021a("MixpanelAPI.FlipGesture", "Flip gesture completed");
                    this.f12130a = 0;
                    this.f12134e.mo12082a();
                    break;
                }
                break;
            case 0:
                if (j > 1000000000 && this.f12130a != 0) {
                    MPLog.m12021a("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
                    this.f12130a = 0;
                    break;
                }
                break;
            case 1:
                if (j > 250000000 && this.f12130a == 0) {
                    MPLog.m12021a("MixpanelAPI.FlipGesture", "Flip gesture begun");
                    this.f12130a = 1;
                    break;
                }
                break;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX INFO: renamed from: a */
    private float[] m12081a(float[] fArr) {
        for (int i = 0; i < 3; i++) {
            float f = this.f12133d[i];
            this.f12133d[i] = f + (0.7f * (fArr[i] - f));
        }
        return this.f12133d;
    }
}
