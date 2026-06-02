package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RoundRectDrawableWithShadow;

/* JADX INFO: loaded from: classes.dex */
class CardViewApi17Impl extends CardViewBaseImpl {
    CardViewApi17Impl() {
    }

    @Override // android.support.v7.widget.CardViewBaseImpl, android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3984a() {
        RoundRectDrawableWithShadow.f4169a = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: android.support.v7.widget.CardViewApi17Impl.1
            @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
            /* JADX INFO: renamed from: a */
            public void mo3985a(Canvas canvas, RectF rectF, float f, Paint paint) {
                canvas.drawRoundRect(rectF, f, f, paint);
            }
        };
    }
}
