package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* JADX INFO: renamed from: a */
    static final PorterDuff.Mode f1010a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    private VectorDrawableCompatState f1011c;

    /* JADX INFO: renamed from: d */
    private PorterDuffColorFilter f1012d;

    /* JADX INFO: renamed from: e */
    private ColorFilter f1013e;

    /* JADX INFO: renamed from: f */
    private boolean f1014f;

    /* JADX INFO: renamed from: g */
    private boolean f1015g;

    /* JADX INFO: renamed from: h */
    private Drawable.ConstantState f1016h;

    /* JADX INFO: renamed from: i */
    private final float[] f1017i;

    /* JADX INFO: renamed from: j */
    private final Matrix f1018j;

    /* JADX INFO: renamed from: k */
    private final Rect f1019k;

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

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

    VectorDrawableCompat() {
        this.f1015g = true;
        this.f1017i = new float[9];
        this.f1018j = new Matrix();
        this.f1019k = new Rect();
        this.f1011c = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f1015g = true;
        this.f1017i = new float[9];
        this.f1018j = new Matrix();
        this.f1019k = new Rect();
        this.f1011c = vectorDrawableCompatState;
        this.f1012d = m992a(this.f1012d, vectorDrawableCompatState.f1067c, vectorDrawableCompatState.f1068d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f1009b != null) {
            this.f1009b.mutate();
        } else if (!this.f1014f && super.mutate() == this) {
            this.f1011c = new VectorDrawableCompatState(this.f1011c);
            this.f1014f = true;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    Object m993a(String str) {
        return this.f1011c.f1066b.f1057h.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1009b != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.f1009b.getConstantState());
        }
        this.f1011c.f1065a = getChangingConfigurations();
        return this.f1011c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1009b != null) {
            this.f1009b.draw(canvas);
            return;
        }
        copyBounds(this.f1019k);
        if (this.f1019k.width() > 0 && this.f1019k.height() > 0) {
            ColorFilter colorFilter = this.f1013e == null ? this.f1012d : this.f1013e;
            canvas.getMatrix(this.f1018j);
            this.f1018j.getValues(this.f1017i);
            float fAbs = Math.abs(this.f1017i[0]);
            float fAbs2 = Math.abs(this.f1017i[4]);
            float fAbs3 = Math.abs(this.f1017i[1]);
            float fAbs4 = Math.abs(this.f1017i[3]);
            if (fAbs3 != CropImageView.DEFAULT_ASPECT_RATIO || fAbs4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                fAbs2 = 1.0f;
                fAbs = 1.0f;
            }
            int iMin = Math.min(2048, (int) (fAbs * this.f1019k.width()));
            int iMin2 = Math.min(2048, (int) (fAbs2 * this.f1019k.height()));
            if (iMin > 0 && iMin2 > 0) {
                int iSave = canvas.save();
                canvas.translate(this.f1019k.left, this.f1019k.top);
                if (m990a()) {
                    canvas.translate(this.f1019k.width(), CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f1019k.offsetTo(0, 0);
                this.f1011c.m1021b(iMin, iMin2);
                if (!this.f1015g) {
                    this.f1011c.m1018a(iMin, iMin2);
                } else if (!this.f1011c.m1022b()) {
                    this.f1011c.m1018a(iMin, iMin2);
                    this.f1011c.m1023c();
                }
                this.f1011c.m1019a(canvas, colorFilter, this.f1019k);
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1009b != null ? DrawableCompat.m1996c(this.f1009b) : this.f1011c.f1066b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f1009b != null) {
            this.f1009b.setAlpha(i);
        } else if (this.f1011c.f1066b.getRootAlpha() != i) {
            this.f1011c.f1066b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f1009b != null) {
            this.f1009b.setColorFilter(colorFilter);
        } else {
            this.f1013e = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    PorterDuffColorFilter m992a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.f1009b != null) {
            DrawableCompat.m1987a(this.f1009b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f1009b != null) {
            DrawableCompat.m1989a(this.f1009b, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        if (vectorDrawableCompatState.f1067c != colorStateList) {
            vectorDrawableCompatState.f1067c = colorStateList;
            this.f1012d = m992a(this.f1012d, colorStateList, vectorDrawableCompatState.f1068d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f1009b != null) {
            DrawableCompat.m1992a(this.f1009b, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        if (vectorDrawableCompatState.f1068d != mode) {
            vectorDrawableCompatState.f1068d = mode;
            this.f1012d = m992a(this.f1012d, vectorDrawableCompatState.f1067c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f1009b != null) {
            return this.f1009b.isStateful();
        }
        return super.isStateful() || !(this.f1011c == null || this.f1011c.f1067c == null || !this.f1011c.f1067c.isStateful());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f1009b != null) {
            return this.f1009b.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        if (vectorDrawableCompatState.f1067c != null && vectorDrawableCompatState.f1068d != null) {
            this.f1012d = m992a(this.f1012d, vectorDrawableCompatState.f1067c, vectorDrawableCompatState.f1068d);
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f1009b != null) {
            return this.f1009b.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1009b != null ? this.f1009b.getIntrinsicWidth() : (int) this.f1011c.f1066b.f1051b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1009b != null ? this.f1009b.getIntrinsicHeight() : (int) this.f1011c.f1066b.f1052c;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f1009b != null) {
            DrawableCompat.m1997d(this.f1009b);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1009b != null ? DrawableCompat.m1994b(this.f1009b) : this.f1011c.f1069e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f1009b != null) {
            DrawableCompat.m1993a(this.f1009b, z);
        } else {
            this.f1011c.f1069e = z;
        }
    }

    /* JADX INFO: renamed from: a */
    public static VectorDrawableCompat m987a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1009b = ResourcesCompat.m1919a(resources, i, theme);
            vectorDrawableCompat.f1016h = new VectorDrawableDelegateState(vectorDrawableCompat.f1009b.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return m988a(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static VectorDrawableCompat m988a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    /* JADX INFO: renamed from: a */
    static int m985a(int i, float f) {
        return (((int) (Color.alpha(i) * f)) << 24) | (16777215 & i);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f1009b != null) {
            this.f1009b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f1009b != null) {
            DrawableCompat.m1991a(this.f1009b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        vectorDrawableCompatState.f1066b = new VPathRenderer();
        TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f980a);
        m989a(typedArrayM1926a, xmlPullParser);
        typedArrayM1926a.recycle();
        vectorDrawableCompatState.f1065a = getChangingConfigurations();
        vectorDrawableCompatState.f1075k = true;
        m991b(resources, xmlPullParser, attributeSet, theme);
        this.f1012d = m992a(this.f1012d, vectorDrawableCompatState.f1067c, vectorDrawableCompatState.f1068d);
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuff.Mode m986a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return mode;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m989a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f1066b;
        vectorDrawableCompatState.f1068d = m986a(TypedArrayUtils.m1925a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            vectorDrawableCompatState.f1067c = colorStateList;
        }
        vectorDrawableCompatState.f1069e = TypedArrayUtils.m1928a(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f1069e);
        vPathRenderer.f1053d = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f1053d);
        vPathRenderer.f1054e = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f1054e);
        if (vPathRenderer.f1053d <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (vPathRenderer.f1054e <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        vPathRenderer.f1051b = typedArray.getDimension(3, vPathRenderer.f1051b);
        vPathRenderer.f1052c = typedArray.getDimension(2, vPathRenderer.f1052c);
        if (vPathRenderer.f1051b <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (vPathRenderer.f1052c <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        vPathRenderer.setAlpha(TypedArrayUtils.m1924a(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            vPathRenderer.f1056g = string;
            vPathRenderer.f1057h.put(string, vPathRenderer);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m991b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        boolean z;
        VectorDrawableCompatState vectorDrawableCompatState = this.f1011c;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f1066b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f1050a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.m1001a(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f1033a.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f1057h.put(vFullPath.getPathName(), vFullPath);
                    }
                    z = false;
                    vectorDrawableCompatState.f1065a = vFullPath.f1048o | vectorDrawableCompatState.f1065a;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.m996a(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f1033a.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f1057h.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f1065a |= vClipPath.f1048o;
                    z = z2;
                } else {
                    if ("group".equals(name)) {
                        VGroup vGroup2 = new VGroup();
                        vGroup2.m1006a(resources, attributeSet, theme, xmlPullParser);
                        vGroup.f1033a.add(vGroup2);
                        arrayDeque.push(vGroup2);
                        if (vGroup2.getGroupName() != null) {
                            vPathRenderer.f1057h.put(vGroup2.getGroupName(), vGroup2);
                        }
                        vectorDrawableCompatState.f1065a |= vGroup2.f1035c;
                    }
                    z = z2;
                }
                z2 = z;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: renamed from: a */
    void m994a(boolean z) {
        this.f1015g = z;
    }

    /* JADX INFO: renamed from: a */
    private boolean m990a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return isAutoMirrored() && DrawableCompat.m2002i(this) == 1;
        }
        return false;
    }

    @Override // android.support.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f1009b != null) {
            this.f1009b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f1009b != null ? this.f1009b.getChangingConfigurations() : super.getChangingConfigurations() | this.f1011c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f1009b != null) {
            this.f1009b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f1009b != null) {
            this.f1009b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f1009b != null ? this.f1009b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f1009b != null) {
            this.f1009b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f1077a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f1077a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1009b = (VectorDrawable) this.f1077a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1009b = (VectorDrawable) this.f1077a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f1009b = (VectorDrawable) this.f1077a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1077a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1077a.getChangingConfigurations();
        }
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f1065a;

        /* JADX INFO: renamed from: b */
        VPathRenderer f1066b;

        /* JADX INFO: renamed from: c */
        ColorStateList f1067c;

        /* JADX INFO: renamed from: d */
        PorterDuff.Mode f1068d;

        /* JADX INFO: renamed from: e */
        boolean f1069e;

        /* JADX INFO: renamed from: f */
        Bitmap f1070f;

        /* JADX INFO: renamed from: g */
        ColorStateList f1071g;

        /* JADX INFO: renamed from: h */
        PorterDuff.Mode f1072h;

        /* JADX INFO: renamed from: i */
        int f1073i;

        /* JADX INFO: renamed from: j */
        boolean f1074j;

        /* JADX INFO: renamed from: k */
        boolean f1075k;

        /* JADX INFO: renamed from: l */
        Paint f1076l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f1067c = null;
            this.f1068d = VectorDrawableCompat.f1010a;
            if (vectorDrawableCompatState != null) {
                this.f1065a = vectorDrawableCompatState.f1065a;
                this.f1066b = new VPathRenderer(vectorDrawableCompatState.f1066b);
                if (vectorDrawableCompatState.f1066b.f1062n != null) {
                    this.f1066b.f1062n = new Paint(vectorDrawableCompatState.f1066b.f1062n);
                }
                if (vectorDrawableCompatState.f1066b.f1061m != null) {
                    this.f1066b.f1061m = new Paint(vectorDrawableCompatState.f1066b.f1061m);
                }
                this.f1067c = vectorDrawableCompatState.f1067c;
                this.f1068d = vectorDrawableCompatState.f1068d;
                this.f1069e = vectorDrawableCompatState.f1069e;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1019a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f1070f, (Rect) null, rect, m1017a(colorFilter));
        }

        /* JADX INFO: renamed from: a */
        public boolean m1020a() {
            return this.f1066b.getRootAlpha() < 255;
        }

        /* JADX INFO: renamed from: a */
        public Paint m1017a(ColorFilter colorFilter) {
            if (!m1020a() && colorFilter == null) {
                return null;
            }
            if (this.f1076l == null) {
                this.f1076l = new Paint();
                this.f1076l.setFilterBitmap(true);
            }
            this.f1076l.setAlpha(this.f1066b.getRootAlpha());
            this.f1076l.setColorFilter(colorFilter);
            return this.f1076l;
        }

        /* JADX INFO: renamed from: a */
        public void m1018a(int i, int i2) {
            this.f1070f.eraseColor(0);
            this.f1066b.m1016a(new Canvas(this.f1070f), i, i2, (ColorFilter) null);
        }

        /* JADX INFO: renamed from: b */
        public void m1021b(int i, int i2) {
            if (this.f1070f == null || !m1024c(i, i2)) {
                this.f1070f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f1075k = true;
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m1024c(int i, int i2) {
            return i == this.f1070f.getWidth() && i2 == this.f1070f.getHeight();
        }

        /* JADX INFO: renamed from: b */
        public boolean m1022b() {
            return !this.f1075k && this.f1071g == this.f1067c && this.f1072h == this.f1068d && this.f1074j == this.f1069e && this.f1073i == this.f1066b.getRootAlpha();
        }

        /* JADX INFO: renamed from: c */
        public void m1023c() {
            this.f1071g = this.f1067c;
            this.f1072h = this.f1068d;
            this.f1073i = this.f1066b.getRootAlpha();
            this.f1074j = this.f1069e;
            this.f1075k = false;
        }

        public VectorDrawableCompatState() {
            this.f1067c = null;
            this.f1068d = VectorDrawableCompat.f1010a;
            this.f1066b = new VPathRenderer();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1065a;
        }
    }

    private static class VPathRenderer {

        /* JADX INFO: renamed from: k */
        private static final Matrix f1049k = new Matrix();

        /* JADX INFO: renamed from: a */
        final VGroup f1050a;

        /* JADX INFO: renamed from: b */
        float f1051b;

        /* JADX INFO: renamed from: c */
        float f1052c;

        /* JADX INFO: renamed from: d */
        float f1053d;

        /* JADX INFO: renamed from: e */
        float f1054e;

        /* JADX INFO: renamed from: f */
        int f1055f;

        /* JADX INFO: renamed from: g */
        String f1056g;

        /* JADX INFO: renamed from: h */
        final ArrayMap<String, Object> f1057h;

        /* JADX INFO: renamed from: i */
        private final Path f1058i;

        /* JADX INFO: renamed from: j */
        private final Path f1059j;

        /* JADX INFO: renamed from: l */
        private final Matrix f1060l;

        /* JADX INFO: renamed from: m */
        private Paint f1061m;

        /* JADX INFO: renamed from: n */
        private Paint f1062n;

        /* JADX INFO: renamed from: o */
        private PathMeasure f1063o;

        /* JADX INFO: renamed from: p */
        private int f1064p;

        public VPathRenderer() {
            this.f1060l = new Matrix();
            this.f1051b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1052c = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1053d = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1054e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1055f = 255;
            this.f1056g = null;
            this.f1057h = new ArrayMap<>();
            this.f1050a = new VGroup();
            this.f1058i = new Path();
            this.f1059j = new Path();
        }

        public void setRootAlpha(int i) {
            this.f1055f = i;
        }

        public int getRootAlpha() {
            return this.f1055f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (255.0f * f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f1060l = new Matrix();
            this.f1051b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1052c = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1053d = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1054e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1055f = 255;
            this.f1056g = null;
            this.f1057h = new ArrayMap<>();
            this.f1050a = new VGroup(vPathRenderer.f1050a, this.f1057h);
            this.f1058i = new Path(vPathRenderer.f1058i);
            this.f1059j = new Path(vPathRenderer.f1059j);
            this.f1051b = vPathRenderer.f1051b;
            this.f1052c = vPathRenderer.f1052c;
            this.f1053d = vPathRenderer.f1053d;
            this.f1054e = vPathRenderer.f1054e;
            this.f1064p = vPathRenderer.f1064p;
            this.f1055f = vPathRenderer.f1055f;
            this.f1056g = vPathRenderer.f1056g;
            if (vPathRenderer.f1056g != null) {
                this.f1057h.put(vPathRenderer.f1056g, this);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m1012a(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            vGroup.f1036d.set(matrix);
            vGroup.f1036d.preConcat(vGroup.f1043k);
            canvas.save();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < vGroup.f1033a.size()) {
                    Object obj = vGroup.f1033a.get(i4);
                    if (!(obj instanceof VGroup)) {
                        if (obj instanceof VPath) {
                            m1013a(vGroup, (VPath) obj, canvas, i, i2, colorFilter);
                        }
                    } else {
                        m1012a((VGroup) obj, vGroup.f1036d, canvas, i, i2, colorFilter);
                    }
                    i3 = i4 + 1;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1016a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m1012a(this.f1050a, f1049k, canvas, i, i2, colorFilter);
        }

        /* JADX INFO: renamed from: a */
        private void m1013a(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f1053d;
            float f2 = i2 / this.f1054e;
            float fMin = Math.min(f, f2);
            Matrix matrix = vGroup.f1036d;
            this.f1060l.set(matrix);
            this.f1060l.postScale(f, f2);
            float fM1009a = m1009a(matrix);
            if (fM1009a != CropImageView.DEFAULT_ASPECT_RATIO) {
                vPath.m1007a(this.f1058i);
                Path path = this.f1058i;
                this.f1059j.reset();
                if (vPath.mo997a()) {
                    this.f1059j.addPath(path, this.f1060l);
                    canvas.clipPath(this.f1059j);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                if (vFullPath.f1026g != CropImageView.DEFAULT_ASPECT_RATIO || vFullPath.f1027h != 1.0f) {
                    float f3 = (vFullPath.f1026g + vFullPath.f1028i) % 1.0f;
                    float f4 = (vFullPath.f1027h + vFullPath.f1028i) % 1.0f;
                    if (this.f1063o == null) {
                        this.f1063o = new PathMeasure();
                    }
                    this.f1063o.setPath(this.f1058i, false);
                    float length = this.f1063o.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.f1063o.getSegment(f5, length, path, true);
                        this.f1063o.getSegment(CropImageView.DEFAULT_ASPECT_RATIO, f6, path, true);
                    } else {
                        this.f1063o.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                this.f1059j.addPath(path, this.f1060l);
                if (vFullPath.f1022c != 0) {
                    if (this.f1062n == null) {
                        this.f1062n = new Paint();
                        this.f1062n.setStyle(Paint.Style.FILL);
                        this.f1062n.setAntiAlias(true);
                    }
                    Paint paint = this.f1062n;
                    paint.setColor(VectorDrawableCompat.m985a(vFullPath.f1022c, vFullPath.f1025f));
                    paint.setColorFilter(colorFilter);
                    this.f1059j.setFillType(vFullPath.f1024e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f1059j, paint);
                }
                if (vFullPath.f1020a != 0) {
                    if (this.f1061m == null) {
                        this.f1061m = new Paint();
                        this.f1061m.setStyle(Paint.Style.STROKE);
                        this.f1061m.setAntiAlias(true);
                    }
                    Paint paint2 = this.f1061m;
                    if (vFullPath.f1030k != null) {
                        paint2.setStrokeJoin(vFullPath.f1030k);
                    }
                    if (vFullPath.f1029j != null) {
                        paint2.setStrokeCap(vFullPath.f1029j);
                    }
                    paint2.setStrokeMiter(vFullPath.f1031l);
                    paint2.setColor(VectorDrawableCompat.m985a(vFullPath.f1020a, vFullPath.f1023d));
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(fM1009a * fMin * vFullPath.f1021b);
                    canvas.drawPath(this.f1059j, paint2);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static float m1008a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* JADX INFO: renamed from: a */
        private float m1009a(Matrix matrix) {
            float[] fArr = {CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fM1008a = m1008a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            return fMax > CropImageView.DEFAULT_ASPECT_RATIO ? Math.abs(fM1008a) / fMax : CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    private static class VGroup {

        /* JADX INFO: renamed from: a */
        final ArrayList<Object> f1033a;

        /* JADX INFO: renamed from: b */
        float f1034b;

        /* JADX INFO: renamed from: c */
        int f1035c;

        /* JADX INFO: renamed from: d */
        private final Matrix f1036d;

        /* JADX INFO: renamed from: e */
        private float f1037e;

        /* JADX INFO: renamed from: f */
        private float f1038f;

        /* JADX INFO: renamed from: g */
        private float f1039g;

        /* JADX INFO: renamed from: h */
        private float f1040h;

        /* JADX INFO: renamed from: i */
        private float f1041i;

        /* JADX INFO: renamed from: j */
        private float f1042j;

        /* JADX INFO: renamed from: k */
        private final Matrix f1043k;

        /* JADX INFO: renamed from: l */
        private int[] f1044l;

        /* JADX INFO: renamed from: m */
        private String f1045m;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VPath vClipPath;
            this.f1036d = new Matrix();
            this.f1033a = new ArrayList<>();
            this.f1034b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1037e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1038f = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1039g = 1.0f;
            this.f1040h = 1.0f;
            this.f1041i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1042j = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1043k = new Matrix();
            this.f1045m = null;
            this.f1034b = vGroup.f1034b;
            this.f1037e = vGroup.f1037e;
            this.f1038f = vGroup.f1038f;
            this.f1039g = vGroup.f1039g;
            this.f1040h = vGroup.f1040h;
            this.f1041i = vGroup.f1041i;
            this.f1042j = vGroup.f1042j;
            this.f1044l = vGroup.f1044l;
            this.f1045m = vGroup.f1045m;
            this.f1035c = vGroup.f1035c;
            if (this.f1045m != null) {
                arrayMap.put(this.f1045m, this);
            }
            this.f1043k.set(vGroup.f1043k);
            ArrayList<Object> arrayList = vGroup.f1033a;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    Object obj = arrayList.get(i2);
                    if (obj instanceof VGroup) {
                        this.f1033a.add(new VGroup((VGroup) obj, arrayMap));
                    } else {
                        if (obj instanceof VFullPath) {
                            vClipPath = new VFullPath((VFullPath) obj);
                        } else if (obj instanceof VClipPath) {
                            vClipPath = new VClipPath((VClipPath) obj);
                        } else {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        this.f1033a.add(vClipPath);
                        if (vClipPath.f1047n != null) {
                            arrayMap.put(vClipPath.f1047n, vClipPath);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        public VGroup() {
            this.f1036d = new Matrix();
            this.f1033a = new ArrayList<>();
            this.f1034b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1037e = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1038f = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1039g = 1.0f;
            this.f1040h = 1.0f;
            this.f1041i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1042j = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1043k = new Matrix();
            this.f1045m = null;
        }

        public String getGroupName() {
            return this.f1045m;
        }

        public Matrix getLocalMatrix() {
            return this.f1043k;
        }

        /* JADX INFO: renamed from: a */
        public void m1006a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f981b);
            m1004a(typedArrayM1926a, xmlPullParser);
            typedArrayM1926a.recycle();
        }

        /* JADX INFO: renamed from: a */
        private void m1004a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f1044l = null;
            this.f1034b = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "rotation", 5, this.f1034b);
            this.f1037e = typedArray.getFloat(1, this.f1037e);
            this.f1038f = typedArray.getFloat(2, this.f1038f);
            this.f1039g = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "scaleX", 3, this.f1039g);
            this.f1040h = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "scaleY", 4, this.f1040h);
            this.f1041i = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "translateX", 6, this.f1041i);
            this.f1042j = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "translateY", 7, this.f1042j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1045m = string;
            }
            m1003a();
        }

        /* JADX INFO: renamed from: a */
        private void m1003a() {
            this.f1043k.reset();
            this.f1043k.postTranslate(-this.f1037e, -this.f1038f);
            this.f1043k.postScale(this.f1039g, this.f1040h);
            this.f1043k.postRotate(this.f1034b, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            this.f1043k.postTranslate(this.f1041i + this.f1037e, this.f1042j + this.f1038f);
        }

        public float getRotation() {
            return this.f1034b;
        }

        public void setRotation(float f) {
            if (f != this.f1034b) {
                this.f1034b = f;
                m1003a();
            }
        }

        public float getPivotX() {
            return this.f1037e;
        }

        public void setPivotX(float f) {
            if (f != this.f1037e) {
                this.f1037e = f;
                m1003a();
            }
        }

        public float getPivotY() {
            return this.f1038f;
        }

        public void setPivotY(float f) {
            if (f != this.f1038f) {
                this.f1038f = f;
                m1003a();
            }
        }

        public float getScaleX() {
            return this.f1039g;
        }

        public void setScaleX(float f) {
            if (f != this.f1039g) {
                this.f1039g = f;
                m1003a();
            }
        }

        public float getScaleY() {
            return this.f1040h;
        }

        public void setScaleY(float f) {
            if (f != this.f1040h) {
                this.f1040h = f;
                m1003a();
            }
        }

        public float getTranslateX() {
            return this.f1041i;
        }

        public void setTranslateX(float f) {
            if (f != this.f1041i) {
                this.f1041i = f;
                m1003a();
            }
        }

        public float getTranslateY() {
            return this.f1042j;
        }

        public void setTranslateY(float f) {
            if (f != this.f1042j) {
                this.f1042j = f;
                m1003a();
            }
        }
    }

    private static class VPath {

        /* JADX INFO: renamed from: m */
        protected PathParser.PathDataNode[] f1046m;

        /* JADX INFO: renamed from: n */
        String f1047n;

        /* JADX INFO: renamed from: o */
        int f1048o;

        public VPath() {
            this.f1046m = null;
        }

        public VPath(VPath vPath) {
            this.f1046m = null;
            this.f1047n = vPath.f1047n;
            this.f1048o = vPath.f1048o;
            this.f1046m = PathParser.m1943a(vPath.f1046m);
        }

        /* JADX INFO: renamed from: a */
        public void m1007a(Path path) {
            path.reset();
            if (this.f1046m != null) {
                PathParser.PathDataNode.m1950a(this.f1046m, path);
            }
        }

        public String getPathName() {
            return this.f1047n;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo997a() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f1046m;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.m1941a(this.f1046m, pathDataNodeArr)) {
                this.f1046m = PathParser.m1943a(pathDataNodeArr);
            } else {
                PathParser.m1944b(this.f1046m, pathDataNodeArr);
            }
        }
    }

    private static class VClipPath extends VPath {
        public VClipPath() {
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }

        /* JADX INFO: renamed from: a */
        public void m996a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.m1929a(xmlPullParser, "pathData")) {
                TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f983d);
                m995a(typedArrayM1926a);
                typedArrayM1926a.recycle();
            }
        }

        /* JADX INFO: renamed from: a */
        private void m995a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1047n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1046m = PathParser.m1945b(string2);
            }
        }

        @Override // android.support.graphics.drawable.VectorDrawableCompat.VPath
        /* JADX INFO: renamed from: a */
        public boolean mo997a() {
            return true;
        }
    }

    private static class VFullPath extends VPath {

        /* JADX INFO: renamed from: a */
        int f1020a;

        /* JADX INFO: renamed from: b */
        float f1021b;

        /* JADX INFO: renamed from: c */
        int f1022c;

        /* JADX INFO: renamed from: d */
        float f1023d;

        /* JADX INFO: renamed from: e */
        int f1024e;

        /* JADX INFO: renamed from: f */
        float f1025f;

        /* JADX INFO: renamed from: g */
        float f1026g;

        /* JADX INFO: renamed from: h */
        float f1027h;

        /* JADX INFO: renamed from: i */
        float f1028i;

        /* JADX INFO: renamed from: j */
        Paint.Cap f1029j;

        /* JADX INFO: renamed from: k */
        Paint.Join f1030k;

        /* JADX INFO: renamed from: l */
        float f1031l;

        /* JADX INFO: renamed from: p */
        private int[] f1032p;

        public VFullPath() {
            this.f1020a = 0;
            this.f1021b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1022c = 0;
            this.f1023d = 1.0f;
            this.f1024e = 0;
            this.f1025f = 1.0f;
            this.f1026g = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1027h = 1.0f;
            this.f1028i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1029j = Paint.Cap.BUTT;
            this.f1030k = Paint.Join.MITER;
            this.f1031l = 4.0f;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f1020a = 0;
            this.f1021b = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1022c = 0;
            this.f1023d = 1.0f;
            this.f1024e = 0;
            this.f1025f = 1.0f;
            this.f1026g = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1027h = 1.0f;
            this.f1028i = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f1029j = Paint.Cap.BUTT;
            this.f1030k = Paint.Join.MITER;
            this.f1031l = 4.0f;
            this.f1032p = vFullPath.f1032p;
            this.f1020a = vFullPath.f1020a;
            this.f1021b = vFullPath.f1021b;
            this.f1023d = vFullPath.f1023d;
            this.f1022c = vFullPath.f1022c;
            this.f1024e = vFullPath.f1024e;
            this.f1025f = vFullPath.f1025f;
            this.f1026g = vFullPath.f1026g;
            this.f1027h = vFullPath.f1027h;
            this.f1028i = vFullPath.f1028i;
            this.f1029j = vFullPath.f1029j;
            this.f1030k = vFullPath.f1030k;
            this.f1031l = vFullPath.f1031l;
        }

        /* JADX INFO: renamed from: a */
        private Paint.Cap m998a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* JADX INFO: renamed from: a */
        private Paint.Join m999a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1001a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f982c);
            m1000a(typedArrayM1926a, xmlPullParser);
            typedArrayM1926a.recycle();
        }

        /* JADX INFO: renamed from: a */
        private void m1000a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f1032p = null;
            if (TypedArrayUtils.m1929a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f1047n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f1046m = PathParser.m1945b(string2);
                }
                this.f1022c = TypedArrayUtils.m1930b(typedArray, xmlPullParser, "fillColor", 1, this.f1022c);
                this.f1025f = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "fillAlpha", 12, this.f1025f);
                this.f1029j = m998a(TypedArrayUtils.m1925a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f1029j);
                this.f1030k = m999a(TypedArrayUtils.m1925a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f1030k);
                this.f1031l = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f1031l);
                this.f1020a = TypedArrayUtils.m1930b(typedArray, xmlPullParser, "strokeColor", 3, this.f1020a);
                this.f1023d = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1023d);
                this.f1021b = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "strokeWidth", 4, this.f1021b);
                this.f1027h = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f1027h);
                this.f1028i = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f1028i);
                this.f1026g = TypedArrayUtils.m1924a(typedArray, xmlPullParser, "trimPathStart", 5, this.f1026g);
                this.f1024e = TypedArrayUtils.m1925a(typedArray, xmlPullParser, "fillType", 13, this.f1024e);
            }
        }

        int getStrokeColor() {
            return this.f1020a;
        }

        void setStrokeColor(int i) {
            this.f1020a = i;
        }

        float getStrokeWidth() {
            return this.f1021b;
        }

        void setStrokeWidth(float f) {
            this.f1021b = f;
        }

        float getStrokeAlpha() {
            return this.f1023d;
        }

        void setStrokeAlpha(float f) {
            this.f1023d = f;
        }

        int getFillColor() {
            return this.f1022c;
        }

        void setFillColor(int i) {
            this.f1022c = i;
        }

        float getFillAlpha() {
            return this.f1025f;
        }

        void setFillAlpha(float f) {
            this.f1025f = f;
        }

        float getTrimPathStart() {
            return this.f1026g;
        }

        void setTrimPathStart(float f) {
            this.f1026g = f;
        }

        float getTrimPathEnd() {
            return this.f1027h;
        }

        void setTrimPathEnd(float f) {
            this.f1027h = f;
        }

        float getTrimPathOffset() {
            return this.f1028i;
        }

        void setTrimPathOffset(float f) {
            this.f1028i = f;
        }
    }
}
