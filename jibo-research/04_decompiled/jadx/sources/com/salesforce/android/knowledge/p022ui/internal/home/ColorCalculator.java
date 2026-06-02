package com.salesforce.android.knowledge.p022ui.internal.home;

import android.graphics.Color;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.p022ui.internal.models.ColorSelector;

/* JADX INFO: loaded from: classes.dex */
class ColorCalculator implements ColorSelector {

    /* JADX INFO: renamed from: a */
    private final int f13249a;

    /* JADX INFO: renamed from: b */
    private final int f13250b;

    /* JADX INFO: renamed from: c */
    private final int f13251c;

    ColorCalculator(int i, int i2, int i3) {
        if (i3 > i2) {
            throw new IllegalArgumentException("Gradient range cannot be greater than gradient size");
        }
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Gradient range/size cannot be negative");
        }
        this.f13249a = i;
        this.f13250b = i2;
        this.f13251c = i3;
    }

    @Override // com.salesforce.android.knowledge.p022ui.internal.models.ColorSelector
    /* JADX INFO: renamed from: a */
    public int mo13555a(DataCategorySummary dataCategorySummary, int i) {
        if (this.f13251c == 0 || this.f13250b == 0) {
            return this.f13249a;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(this.f13249a, fArr);
        fArr[2] = fArr[2] - ((fArr[2] / this.f13250b) * Math.abs(((this.f13251c + i) % (this.f13251c * 2)) - this.f13251c));
        return Color.HSVToColor(fArr);
    }
}
