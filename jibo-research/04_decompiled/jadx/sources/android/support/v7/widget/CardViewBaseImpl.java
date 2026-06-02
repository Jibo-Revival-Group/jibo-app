package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RoundRectDrawableWithShadow;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {

    /* JADX INFO: renamed from: a */
    private final RectF f3771a = new RectF();

    CardViewBaseImpl() {
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3984a() {
        RoundRectDrawableWithShadow.f4169a = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: android.support.v7.widget.CardViewBaseImpl.1
            @Override // android.support.v7.widget.RoundRectDrawableWithShadow.RoundRectHelper
            /* JADX INFO: renamed from: a */
            public void mo3985a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float fWidth = (rectF.width() - f2) - 1.0f;
                float fHeight = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    CardViewBaseImpl.this.f3771a.set(-f3, -f3, f3, f3);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(CardViewBaseImpl.this.f3771a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3771a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3771a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3771a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3989a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        RoundRectDrawableWithShadow roundRectDrawableWithShadowM4002a = m4002a(context, colorStateList, f, f2, f3);
        roundRectDrawableWithShadowM4002a.m4700a(cardViewDelegate.mo3981b());
        cardViewDelegate.mo3979a(roundRectDrawableWithShadowM4002a);
        m4004f(cardViewDelegate);
    }

    /* JADX INFO: renamed from: a */
    private RoundRectDrawableWithShadow m4002a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    /* JADX INFO: renamed from: f */
    public void m4004f(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        m4003j(cardViewDelegate).m4699a(rect);
        cardViewDelegate.mo3977a((int) Math.ceil(mo3991b(cardViewDelegate)), (int) Math.ceil(mo3993c(cardViewDelegate)));
        cardViewDelegate.mo3978a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: g */
    public void mo3998g(CardViewDelegate cardViewDelegate) {
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: h */
    public void mo3999h(CardViewDelegate cardViewDelegate) {
        m4003j(cardViewDelegate).m4700a(cardViewDelegate.mo3981b());
        m4004f(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3990a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        m4003j(cardViewDelegate).m4698a(colorStateList);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: i */
    public ColorStateList mo4000i(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4707f();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3988a(CardViewDelegate cardViewDelegate, float f) {
        m4003j(cardViewDelegate).m4697a(f);
        m4004f(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: d */
    public float mo3995d(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4696a();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: c */
    public void mo3994c(CardViewDelegate cardViewDelegate, float f) {
        m4003j(cardViewDelegate).m4702b(f);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: e */
    public float mo3996e(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4701b();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: b */
    public void mo3992b(CardViewDelegate cardViewDelegate, float f) {
        m4003j(cardViewDelegate).m4704c(f);
        m4004f(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public float mo3987a(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4703c();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: b */
    public float mo3991b(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4705d();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: c */
    public float mo3993c(CardViewDelegate cardViewDelegate) {
        return m4003j(cardViewDelegate).m4706e();
    }

    /* JADX INFO: renamed from: j */
    private RoundRectDrawableWithShadow m4003j(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.mo3982c();
    }
}
