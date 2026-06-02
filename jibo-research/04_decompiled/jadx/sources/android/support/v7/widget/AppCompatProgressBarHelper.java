package android.support.v7.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.WrappedDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
class AppCompatProgressBarHelper {

    /* JADX INFO: renamed from: a */
    private static final int[] f3694a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: b */
    private final ProgressBar f3695b;

    /* JADX INFO: renamed from: c */
    private Bitmap f3696c;

    AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f3695b = progressBar;
    }

    /* JADX INFO: renamed from: a */
    void mo3907a(AttributeSet attributeSet, int i) {
        TintTypedArray tintTypedArrayM4955a = TintTypedArray.m4955a(this.f3695b.getContext(), attributeSet, f3694a, i, 0);
        Drawable drawableM4963b = tintTypedArrayM4955a.m4963b(0);
        if (drawableM4963b != null) {
            this.f3695b.setIndeterminateDrawable(m3903a(drawableM4963b));
        }
        Drawable drawableM4963b2 = tintTypedArrayM4955a.m4963b(1);
        if (drawableM4963b2 != null) {
            this.f3695b.setProgressDrawable(m3904a(drawableM4963b2, false));
        }
        tintTypedArrayM4955a.m4960a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private Drawable m3904a(Drawable drawable, boolean z) {
        if (drawable instanceof WrappedDrawable) {
            Drawable drawableMo2012a = ((WrappedDrawable) drawable).mo2012a();
            if (drawableMo2012a != null) {
                ((WrappedDrawable) drawable).mo2013a(m3904a(drawableMo2012a, z));
            }
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = m3904a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.f3696c == null) {
                    this.f3696c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(m3905b());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m3903a(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable drawableM3904a = m3904a(animationDrawable.getFrame(i), true);
                drawableM3904a.setLevel(10000);
                animationDrawable2.addFrame(drawableM3904a, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* JADX INFO: renamed from: b */
    private Shape m3905b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX INFO: renamed from: a */
    Bitmap m3906a() {
        return this.f3696c;
    }
}
