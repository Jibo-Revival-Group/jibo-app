package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class CircleImageView extends ImageView {

    /* JADX INFO: renamed from: a */
    int f2519a;

    /* JADX INFO: renamed from: b */
    private Animation.AnimationListener f2520b;

    CircleImageView(Context context, int i) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (CropImageView.DEFAULT_ASPECT_RATIO * f);
        this.f2519a = (int) (3.5f * f);
        if (m2878a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.m2574a(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this.f2519a));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer(this.f2519a, i3, i2, 503316480);
            int i4 = this.f2519a;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.m2582a(this, shapeDrawable);
    }

    /* JADX INFO: renamed from: a */
    private boolean m2878a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m2878a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f2519a * 2), getMeasuredHeight() + (this.f2519a * 2));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2879a(Animation.AnimationListener animationListener) {
        this.f2520b = animationListener;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f2520b != null) {
            this.f2520b.onAnimationStart(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f2520b != null) {
            this.f2520b.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    private class OvalShadow extends OvalShape {

        /* JADX INFO: renamed from: b */
        private RadialGradient f2522b;

        /* JADX INFO: renamed from: c */
        private Paint f2523c = new Paint();

        OvalShadow(int i) {
            CircleImageView.this.f2519a = i;
            m2880a((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            m2880a((int) f);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth();
            int height = CircleImageView.this.getHeight();
            canvas.drawCircle(width / 2, height / 2, width / 2, this.f2523c);
            canvas.drawCircle(width / 2, height / 2, (width / 2) - CircleImageView.this.f2519a, paint);
        }

        /* JADX INFO: renamed from: a */
        private void m2880a(int i) {
            this.f2522b = new RadialGradient(i / 2, i / 2, CircleImageView.this.f2519a, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f2523c.setShader(this.f2522b);
        }
    }
}
