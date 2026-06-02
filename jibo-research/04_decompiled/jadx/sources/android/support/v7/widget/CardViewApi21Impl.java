package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3989a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.mo3979a(new RoundRectDrawable(colorStateList, f));
        View viewMo3983d = cardViewDelegate.mo3983d();
        viewMo3983d.setClipToOutline(true);
        viewMo3983d.setElevation(f2);
        mo3992b(cardViewDelegate, f3);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3988a(CardViewDelegate cardViewDelegate, float f) {
        m3986j(cardViewDelegate).m4683a(f);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3984a() {
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: b */
    public void mo3992b(CardViewDelegate cardViewDelegate, float f) {
        m3986j(cardViewDelegate).m4684a(f, cardViewDelegate.mo3980a(), cardViewDelegate.mo3981b());
        m3997f(cardViewDelegate);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public float mo3987a(CardViewDelegate cardViewDelegate) {
        return m3986j(cardViewDelegate).m4682a();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: b */
    public float mo3991b(CardViewDelegate cardViewDelegate) {
        return mo3995d(cardViewDelegate) * 2.0f;
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: c */
    public float mo3993c(CardViewDelegate cardViewDelegate) {
        return mo3995d(cardViewDelegate) * 2.0f;
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: d */
    public float mo3995d(CardViewDelegate cardViewDelegate) {
        return m3986j(cardViewDelegate).m4686b();
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: c */
    public void mo3994c(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.mo3983d().setElevation(f);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: e */
    public float mo3996e(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.mo3983d().getElevation();
    }

    /* JADX INFO: renamed from: f */
    public void m3997f(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.mo3980a()) {
            cardViewDelegate.mo3978a(0, 0, 0, 0);
            return;
        }
        float fMo3987a = mo3987a(cardViewDelegate);
        float fMo3995d = mo3995d(cardViewDelegate);
        int iCeil = (int) Math.ceil(RoundRectDrawableWithShadow.m4691b(fMo3987a, fMo3995d, cardViewDelegate.mo3981b()));
        int iCeil2 = (int) Math.ceil(RoundRectDrawableWithShadow.m4688a(fMo3987a, fMo3995d, cardViewDelegate.mo3981b()));
        cardViewDelegate.mo3978a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: g */
    public void mo3998g(CardViewDelegate cardViewDelegate) {
        mo3992b(cardViewDelegate, mo3987a(cardViewDelegate));
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: h */
    public void mo3999h(CardViewDelegate cardViewDelegate) {
        mo3992b(cardViewDelegate, mo3987a(cardViewDelegate));
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: a */
    public void mo3990a(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        m3986j(cardViewDelegate).m4685a(colorStateList);
    }

    @Override // android.support.v7.widget.CardViewImpl
    /* JADX INFO: renamed from: i */
    public ColorStateList mo4000i(CardViewDelegate cardViewDelegate) {
        return m3986j(cardViewDelegate).m4687c();
    }

    /* JADX INFO: renamed from: j */
    private RoundRectDrawable m3986j(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.mo3982c();
    }
}
