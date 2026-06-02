package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {

    /* JADX INFO: renamed from: a */
    final Drawable.Callback f992a;

    /* JADX INFO: renamed from: c */
    private AnimatedVectorDrawableCompatState f993c;

    /* JADX INFO: renamed from: d */
    private Context f994d;

    /* JADX INFO: renamed from: e */
    private android.animation.ArgbEvaluator f995e;

    /* JADX INFO: renamed from: f */
    private Animator.AnimatorListener f996f;

    /* JADX INFO: renamed from: g */
    private ArrayList<Object> f997g;

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.f995e = null;
        this.f996f = null;
        this.f997g = null;
        this.f992a = new Drawable.Callback() { // from class: android.support.graphics.drawable.AnimatedVectorDrawableCompat.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f994d = context;
        if (animatedVectorDrawableCompatState != null) {
            this.f993c = animatedVectorDrawableCompatState;
        } else {
            this.f993c = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, this.f992a, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f1009b != null) {
            this.f1009b.mutate();
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static AnimatedVectorDrawableCompat m952a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1009b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.f1009b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f1009b != null ? this.f1009b.getChangingConfigurations() : super.getChangingConfigurations() | this.f993c.f999a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1009b != null) {
            this.f1009b.draw(canvas);
            return;
        }
        this.f993c.f1000b.draw(canvas);
        if (this.f993c.f1001c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f1009b != null) {
            this.f1009b.setBounds(rect);
        } else {
            this.f993c.f1000b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.f1009b != null ? this.f1009b.setState(iArr) : this.f993c.f1000b.setState(iArr);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f1009b != null ? this.f1009b.setLevel(i) : this.f993c.f1000b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1009b != null ? DrawableCompat.m1996c(this.f1009b) : this.f993c.f1000b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f1009b != null) {
            this.f1009b.setAlpha(i);
        } else {
            this.f993c.f1000b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f1009b != null) {
            this.f1009b.setColorFilter(colorFilter);
        } else {
            this.f993c.f1000b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.f1009b != null) {
            DrawableCompat.m1987a(this.f1009b, i);
        } else {
            this.f993c.f1000b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f1009b != null) {
            DrawableCompat.m1989a(this.f1009b, colorStateList);
        } else {
            this.f993c.f1000b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f1009b != null) {
            DrawableCompat.m1992a(this.f1009b, mode);
        } else {
            this.f993c.f1000b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f1009b != null) {
            return this.f1009b.setVisible(z, z2);
        }
        this.f993c.f1000b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1009b != null ? this.f1009b.isStateful() : this.f993c.f1000b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1009b != null ? this.f1009b.getOpacity() : this.f993c.f1000b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1009b != null ? this.f1009b.getIntrinsicWidth() : this.f993c.f1000b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1009b != null ? this.f1009b.getIntrinsicHeight() : this.f993c.f1000b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1009b != null ? DrawableCompat.m1994b(this.f1009b) : this.f993c.f1000b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f1009b != null) {
            DrawableCompat.m1993a(this.f1009b, z);
        } else {
            this.f993c.f1000b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f1009b != null) {
            DrawableCompat.m1991a(this.f1009b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f984e);
                    int resourceId = typedArrayM1926a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat vectorDrawableCompatM987a = VectorDrawableCompat.m987a(resources, resourceId, theme);
                        vectorDrawableCompatM987a.m994a(false);
                        vectorDrawableCompatM987a.setCallback(this.f992a);
                        if (this.f993c.f1000b != null) {
                            this.f993c.f1000b.setCallback(null);
                        }
                        this.f993c.f1000b = vectorDrawableCompatM987a;
                    }
                    typedArrayM1926a.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AndroidResources.f985f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f994d != null) {
                            m954a(string, AnimatorInflaterCompat.m962a(this.f994d, resourceId2));
                        } else {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f993c.m957a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f1009b != null) {
            DrawableCompat.m1990a(this.f1009b, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f1009b != null) {
            return DrawableCompat.m1997d(this.f1009b);
        }
        return false;
    }

    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f1004a;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f1004a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f1009b = this.f1004a.newDrawable();
            animatedVectorDrawableCompat.f1009b.setCallback(animatedVectorDrawableCompat.f992a);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f1009b = this.f1004a.newDrawable(resources);
            animatedVectorDrawableCompat.f1009b.setCallback(animatedVectorDrawableCompat.f992a);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f1009b = this.f1004a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f1009b.setCallback(animatedVectorDrawableCompat.f992a);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1004a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1004a.getChangingConfigurations();
        }
    }

    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f999a;

        /* JADX INFO: renamed from: b */
        VectorDrawableCompat f1000b;

        /* JADX INFO: renamed from: c */
        AnimatorSet f1001c;

        /* JADX INFO: renamed from: d */
        ArrayMap<Animator, String> f1002d;

        /* JADX INFO: renamed from: e */
        private ArrayList<Animator> f1003e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f999a = animatedVectorDrawableCompatState.f999a;
                if (animatedVectorDrawableCompatState.f1000b != null) {
                    Drawable.ConstantState constantState = animatedVectorDrawableCompatState.f1000b.getConstantState();
                    if (resources != null) {
                        this.f1000b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f1000b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    this.f1000b = (VectorDrawableCompat) this.f1000b.mutate();
                    this.f1000b.setCallback(callback);
                    this.f1000b.setBounds(animatedVectorDrawableCompatState.f1000b.getBounds());
                    this.f1000b.m994a(false);
                }
                if (animatedVectorDrawableCompatState.f1003e != null) {
                    int size = animatedVectorDrawableCompatState.f1003e.size();
                    this.f1003e = new ArrayList<>(size);
                    this.f1002d = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = animatedVectorDrawableCompatState.f1003e.get(i);
                        Animator animatorClone = animator.clone();
                        String str = animatedVectorDrawableCompatState.f1002d.get(animator);
                        animatorClone.setTarget(this.f1000b.m993a(str));
                        this.f1003e.add(animatorClone);
                        this.f1002d.put(animatorClone, str);
                    }
                    m957a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f999a;
        }

        /* JADX INFO: renamed from: a */
        public void m957a() {
            if (this.f1001c == null) {
                this.f1001c = new AnimatorSet();
            }
            this.f1001c.playTogether(this.f1003e);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m953a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childAnimations.size()) {
                    break;
                }
                m953a(childAnimations.get(i2));
                i = i2 + 1;
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f995e == null) {
                    this.f995e = new android.animation.ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f995e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m954a(String str, Animator animator) {
        animator.setTarget(this.f993c.f1000b.m993a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m953a(animator);
        }
        if (this.f993c.f1003e == null) {
            this.f993c.f1003e = new ArrayList();
            this.f993c.f1002d = new ArrayMap<>();
        }
        this.f993c.f1003e.add(animator);
        this.f993c.f1002d.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f1009b != null ? ((AnimatedVectorDrawable) this.f1009b).isRunning() : this.f993c.f1001c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f1009b != null) {
            ((AnimatedVectorDrawable) this.f1009b).start();
        } else if (!this.f993c.f1001c.isStarted()) {
            this.f993c.f1001c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f1009b != null) {
            ((AnimatedVectorDrawable) this.f1009b).stop();
        } else {
            this.f993c.f1001c.end();
        }
    }
}
