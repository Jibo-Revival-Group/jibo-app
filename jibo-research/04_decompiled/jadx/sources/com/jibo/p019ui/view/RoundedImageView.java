package com.jibo.p019ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends ImageView {
    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            RoundedBitmapDrawable roundedBitmapDrawableM2011a = RoundedBitmapDrawableFactory.m2011a(getResources(), ((BitmapDrawable) drawable).getBitmap());
            roundedBitmapDrawableM2011a.m2009a(true);
            super.setImageDrawable(roundedBitmapDrawableM2011a);
            return;
        }
        if (drawable instanceof GlideBitmapDrawable) {
            RoundedBitmapDrawable roundedBitmapDrawableM2011a2 = RoundedBitmapDrawableFactory.m2011a(getResources(), ((GlideBitmapDrawable) drawable).getBitmap());
            roundedBitmapDrawableM2011a2.m2009a(true);
            super.setImageDrawable(roundedBitmapDrawableM2011a2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (drawable instanceof VectorDrawable) {
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                drawable.setTintList(getImageTintList());
                drawable.draw(canvas);
                RoundedBitmapDrawable roundedBitmapDrawableM2011a3 = RoundedBitmapDrawableFactory.m2011a(getResources(), bitmapCreateBitmap);
                roundedBitmapDrawableM2011a3.m2009a(true);
                super.setImageDrawable(roundedBitmapDrawableM2011a3);
                return;
            }
            super.setImageDrawable(m11291a(drawable));
            return;
        }
        super.setImageDrawable(m11291a(drawable));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            setImageDrawable(getResources().getDrawable(i, getContext().getTheme()));
        } else {
            setImageDrawable(getResources().getDrawable(i));
        }
    }

    /* JADX INFO: renamed from: a */
    private Drawable m11291a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            RoundedBitmapDrawable roundedBitmapDrawableM2011a = RoundedBitmapDrawableFactory.m2011a(getResources(), ImageUtils.m11389a(bitmapCreateBitmap));
            roundedBitmapDrawableM2011a.m2009a(true);
            return roundedBitmapDrawableM2011a;
        }
        return drawable;
    }
}
