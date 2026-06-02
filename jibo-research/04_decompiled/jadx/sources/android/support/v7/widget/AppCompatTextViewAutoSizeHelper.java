package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.appcompat.R;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class AppCompatTextViewAutoSizeHelper {

    /* JADX INFO: renamed from: a */
    private static final RectF f3744a = new RectF();

    /* JADX INFO: renamed from: b */
    private static ConcurrentHashMap<String, Method> f3745b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c */
    private int f3746c = 0;

    /* JADX INFO: renamed from: d */
    private boolean f3747d = false;

    /* JADX INFO: renamed from: e */
    private float f3748e = -1.0f;

    /* JADX INFO: renamed from: f */
    private float f3749f = -1.0f;

    /* JADX INFO: renamed from: g */
    private float f3750g = -1.0f;

    /* JADX INFO: renamed from: h */
    private int[] f3751h = new int[0];

    /* JADX INFO: renamed from: i */
    private boolean f3752i = false;

    /* JADX INFO: renamed from: j */
    private TextPaint f3753j;

    /* JADX INFO: renamed from: k */
    private final TextView f3754k;

    /* JADX INFO: renamed from: l */
    private final Context f3755l;

    AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.f3754k = textView;
        this.f3755l = this.f3754k.getContext();
    }

    /* JADX INFO: renamed from: a */
    void m3964a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f3755l.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f3746c = typedArrayObtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m3953a(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (m3959k()) {
            if (this.f3746c == 1) {
                if (!this.f3752i) {
                    DisplayMetrics displayMetrics = this.f3755l.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    m3952a(dimension2, dimension3, dimension);
                }
                m3957i();
                return;
            }
            return;
        }
        this.f3746c = 0;
    }

    /* JADX INFO: renamed from: a */
    void m3961a(int i) {
        if (m3959k()) {
            switch (i) {
                case 0:
                    m3958j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f3755l.getResources().getDisplayMetrics();
                    m3952a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m3957i()) {
                        m3970f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3963a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (m3959k()) {
            DisplayMetrics displayMetrics = this.f3755l.getResources().getDisplayMetrics();
            m3952a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m3957i()) {
                m3970f();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3965a(int[] iArr, int i) throws IllegalArgumentException {
        if (m3959k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f3755l.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f3751h = m3955a(iArrCopyOf);
                if (!m3956h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f3752i = false;
            }
            if (m3957i()) {
                m3970f();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m3960a() {
        return this.f3746c;
    }

    /* JADX INFO: renamed from: b */
    int m3966b() {
        return Math.round(this.f3748e);
    }

    /* JADX INFO: renamed from: c */
    int m3967c() {
        return Math.round(this.f3749f);
    }

    /* JADX INFO: renamed from: d */
    int m3968d() {
        return Math.round(this.f3750g);
    }

    /* JADX INFO: renamed from: e */
    int[] m3969e() {
        return this.f3751h;
    }

    /* JADX INFO: renamed from: a */
    private void m3953a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f3751h = m3955a(iArr);
            m3956h();
        }
    }

    /* JADX INFO: renamed from: h */
    private boolean m3956h() {
        this.f3752i = this.f3751h.length > 0;
        if (this.f3752i) {
            this.f3746c = 1;
            this.f3749f = this.f3751h[0];
            this.f3750g = this.f3751h[r3 - 1];
            this.f3748e = -1.0f;
        }
        return this.f3752i;
    }

    /* JADX INFO: renamed from: a */
    private int[] m3955a(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
            }
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    private void m3952a(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= CropImageView.DEFAULT_ASPECT_RATIO) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f3746c = 1;
        this.f3749f = f;
        this.f3750g = f2;
        this.f3748e = f3;
        this.f3752i = false;
    }

    /* JADX INFO: renamed from: i */
    private boolean m3957i() {
        if (m3959k() && this.f3746c == 1) {
            if (!this.f3752i || this.f3751h.length == 0) {
                float fRound = Math.round(this.f3749f);
                int i = 1;
                while (Math.round(this.f3748e + fRound) <= Math.round(this.f3750g)) {
                    i++;
                    fRound += this.f3748e;
                }
                int[] iArr = new int[i];
                float f = this.f3749f;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f3748e;
                }
                this.f3751h = m3955a(iArr);
            }
            this.f3747d = true;
        } else {
            this.f3747d = false;
        }
        return this.f3747d;
    }

    /* JADX INFO: renamed from: f */
    void m3970f() {
        if (m3971g()) {
            if (this.f3747d) {
                if (this.f3754k.getMeasuredHeight() > 0 && this.f3754k.getMeasuredWidth() > 0) {
                    int measuredWidth = ((Boolean) m3949a(this.f3754k, "getHorizontallyScrolling", false)).booleanValue() ? 1048576 : (this.f3754k.getMeasuredWidth() - this.f3754k.getTotalPaddingLeft()) - this.f3754k.getTotalPaddingRight();
                    int height = (this.f3754k.getHeight() - this.f3754k.getCompoundPaddingBottom()) - this.f3754k.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (f3744a) {
                            f3744a.setEmpty();
                            f3744a.right = measuredWidth;
                            f3744a.bottom = height;
                            float fM3946a = m3946a(f3744a);
                            if (fM3946a != this.f3754k.getTextSize()) {
                                m3962a(0, fM3946a);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f3747d = true;
        }
    }

    /* JADX INFO: renamed from: j */
    private void m3958j() {
        this.f3746c = 0;
        this.f3749f = -1.0f;
        this.f3750g = -1.0f;
        this.f3748e = -1.0f;
        this.f3751h = new int[0];
        this.f3747d = false;
    }

    /* JADX INFO: renamed from: a */
    void m3962a(int i, float f) {
        Resources resources;
        if (this.f3755l == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.f3755l.getResources();
        }
        m3951a(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    /* JADX INFO: renamed from: a */
    private void m3951a(float f) {
        if (f != this.f3754k.getPaint().getTextSize()) {
            this.f3754k.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f3754k.isInLayout() : false;
            if (this.f3754k.getLayout() != null) {
                this.f3747d = false;
                try {
                    Method methodM3950a = m3950a("nullLayouts");
                    if (methodM3950a != null) {
                        methodM3950a.invoke(this.f3754k, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!zIsInLayout) {
                    this.f3754k.requestLayout();
                } else {
                    this.f3754k.forceLayout();
                }
                this.f3754k.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m3946a(RectF rectF) {
        int length = this.f3751h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = 1;
        int i3 = length - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) / 2;
            if (m3954a(this.f3751h[i4], rectF)) {
                int i5 = i4 + 1;
                i = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.f3751h[i];
    }

    /* JADX INFO: renamed from: a */
    private boolean m3954a(int i, RectF rectF) {
        StaticLayout staticLayoutM3947a;
        CharSequence transformation;
        CharSequence text = this.f3754k.getText();
        TransformationMethod transformationMethod = this.f3754k.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f3754k)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f3754k.getMaxLines() : -1;
        if (this.f3753j == null) {
            this.f3753j = new TextPaint();
        } else {
            this.f3753j.reset();
        }
        this.f3753j.set(this.f3754k.getPaint());
        this.f3753j.setTextSize(i);
        Layout.Alignment alignment = (Layout.Alignment) m3949a(this.f3754k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayoutM3947a = m3948a(text, alignment, Math.round(rectF.right), maxLines);
        } else {
            staticLayoutM3947a = m3947a(text, alignment, Math.round(rectF.right));
        }
        if (maxLines == -1 || (staticLayoutM3947a.getLineCount() <= maxLines && staticLayoutM3947a.getLineEnd(staticLayoutM3947a.getLineCount() - 1) == text.length())) {
            return ((float) staticLayoutM3947a.getHeight()) <= rectF.bottom;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m3948a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m3949a(this.f3754k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f3753j, i).setAlignment(alignment).setLineSpacing(this.f3754k.getLineSpacingExtra(), this.f3754k.getLineSpacingMultiplier()).setIncludePad(this.f3754k.getIncludeFontPadding()).setBreakStrategy(this.f3754k.getBreakStrategy()).setHyphenationFrequency(this.f3754k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m3947a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        float fFloatValue;
        float fFloatValue2;
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            fFloatValue = this.f3754k.getLineSpacingMultiplier();
            fFloatValue2 = this.f3754k.getLineSpacingExtra();
            zBooleanValue = this.f3754k.getIncludeFontPadding();
        } else {
            fFloatValue = ((Float) m3949a(this.f3754k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            fFloatValue2 = ((Float) m3949a(this.f3754k, "getLineSpacingExtra", Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO))).floatValue();
            zBooleanValue = ((Boolean) m3949a(this.f3754k, "getIncludeFontPadding", true)).booleanValue();
        }
        return new StaticLayout(charSequence, this.f3753j, i, alignment, fFloatValue, fFloatValue2, zBooleanValue);
    }

    /* JADX INFO: renamed from: a */
    private <T> T m3949a(Object obj, String str, T t) {
        boolean z = false;
        try {
            try {
                T t2 = (T) m3950a(str).invoke(obj, new Object[0]);
                if (t2 == null) {
                }
                return t2;
            } catch (Exception e) {
                z = true;
                Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
                if (0 != 0) {
                    return null;
                }
                return t;
            }
        } catch (Throwable th) {
            if (0 != 0 || z) {
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private Method m3950a(String str) {
        try {
            Method method = f3745b.get(str);
            if (method == null) {
                Method declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    f3745b.put(str, declaredMethod);
                    return declaredMethod;
                }
                return declaredMethod;
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    boolean m3971g() {
        return m3959k() && this.f3746c != 0;
    }

    /* JADX INFO: renamed from: k */
    private boolean m3959k() {
        return !(this.f3754k instanceof AppCompatEditText);
    }
}
