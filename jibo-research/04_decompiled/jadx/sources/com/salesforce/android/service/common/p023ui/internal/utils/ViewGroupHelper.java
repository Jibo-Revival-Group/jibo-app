package com.salesforce.android.service.common.p023ui.internal.utils;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ViewGroupHelper {
    /* JADX INFO: renamed from: a */
    public static void m14014a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m14014a((ViewGroup) childAt, z);
            }
        }
    }
}
