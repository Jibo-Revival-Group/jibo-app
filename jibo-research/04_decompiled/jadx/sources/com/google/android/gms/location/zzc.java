package com.google.android.gms.location;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Comparator<DetectedActivity> {
    zzc() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        DetectedActivity detectedActivity3 = detectedActivity;
        DetectedActivity detectedActivity4 = detectedActivity2;
        int iCompareTo = Integer.valueOf(detectedActivity4.m8737b()).compareTo(Integer.valueOf(detectedActivity3.m8737b()));
        return iCompareTo == 0 ? Integer.valueOf(detectedActivity3.m8736a()).compareTo(Integer.valueOf(detectedActivity4.m8736a())) : iCompareTo;
    }
}
