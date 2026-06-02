package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatorInflaterCompat {
    /* JADX INFO: renamed from: a */
    public static Animator m962a(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m963a(context, context.getResources(), context.getTheme(), i);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m963a(Context context, Resources resources, Resources.Theme theme, int i) throws Resources.NotFoundException {
        return m964a(context, resources, theme, i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m964a(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i);
                    return m965a(context, resources, theme, animation, f);
                } catch (IOException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (animation != null) {
                animation.close();
            }
        }
    }

    private static class PathDataEvaluator implements TypeEvaluator<PathParser.PathDataNode[]> {

        /* JADX INFO: renamed from: a */
        private PathParser.PathDataNode[] f1005a;

        private PathDataEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PathParser.PathDataNode[] evaluate(float f, PathParser.PathDataNode[] pathDataNodeArr, PathParser.PathDataNode[] pathDataNodeArr2) {
            if (!PathParser.m1941a(pathDataNodeArr, pathDataNodeArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.f1005a == null || !PathParser.m1941a(this.f1005a, pathDataNodeArr)) {
                this.f1005a = PathParser.m1943a(pathDataNodeArr);
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                this.f1005a[i].m1951a(pathDataNodeArr[i], pathDataNodeArr2[i], f);
            }
            return this.f1005a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m971a(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolderOfInt;
        int color;
        int color2;
        int color3;
        float dimension;
        float dimension2;
        float dimension3;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            if ((z && m977a(i4)) || (z2 && m977a(i5))) {
                i = 3;
            } else {
                i = 0;
            }
        }
        boolean z3 = i == 0;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] pathDataNodeArrM1945b = PathParser.m1945b(string);
            PathParser.PathDataNode[] pathDataNodeArrM1945b2 = PathParser.m1945b(string2);
            if (pathDataNodeArrM1945b != null || pathDataNodeArrM1945b2 != null) {
                if (pathDataNodeArrM1945b != null) {
                    PathDataEvaluator pathDataEvaluator = new PathDataEvaluator();
                    if (pathDataNodeArrM1945b2 == null) {
                        return PropertyValuesHolder.ofObject(str, pathDataEvaluator, pathDataNodeArrM1945b);
                    }
                    if (PathParser.m1941a(pathDataNodeArrM1945b, pathDataNodeArrM1945b2)) {
                        return PropertyValuesHolder.ofObject(str, pathDataEvaluator, pathDataNodeArrM1945b, pathDataNodeArrM1945b2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (pathDataNodeArrM1945b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new PathDataEvaluator(), pathDataNodeArrM1945b2);
                }
            }
            return null;
        }
        ArgbEvaluator argbEvaluatorM980a = null;
        if (i == 3) {
            argbEvaluatorM980a = ArgbEvaluator.m980a();
        }
        if (z3) {
            if (z) {
                if (i4 == 5) {
                    dimension2 = typedArray.getDimension(i2, CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    dimension2 = typedArray.getFloat(i2, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                if (z2) {
                    if (i5 == 5) {
                        dimension3 = typedArray.getDimension(i3, CropImageView.DEFAULT_ASPECT_RATIO);
                    } else {
                        dimension3 = typedArray.getFloat(i3, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, dimension2, dimension3);
                } else {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, dimension2);
                }
            } else {
                if (i5 == 5) {
                    dimension = typedArray.getDimension(i3, CropImageView.DEFAULT_ASPECT_RATIO);
                } else {
                    dimension = typedArray.getFloat(i3, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofFloat(str, dimension);
            }
        } else if (z) {
            if (i4 == 5) {
                color2 = (int) typedArray.getDimension(i2, CropImageView.DEFAULT_ASPECT_RATIO);
            } else if (m977a(i4)) {
                color2 = typedArray.getColor(i2, 0);
            } else {
                color2 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    color3 = (int) typedArray.getDimension(i3, CropImageView.DEFAULT_ASPECT_RATIO);
                } else if (m977a(i5)) {
                    color3 = typedArray.getColor(i3, 0);
                } else {
                    color3 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (!z2) {
            propertyValuesHolderOfInt = null;
        } else {
            if (i5 == 5) {
                color = (int) typedArray.getDimension(i3, CropImageView.DEFAULT_ASPECT_RATIO);
            } else if (m977a(i5)) {
                color = typedArray.getColor(i3, 0);
            } else {
                color = typedArray.getInt(i3, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt != null && argbEvaluatorM980a != null) {
            propertyValuesHolderOfInt.setEvaluator(argbEvaluatorM980a);
            return propertyValuesHolderOfInt;
        }
        return propertyValuesHolderOfInt;
    }

    /* JADX INFO: renamed from: a */
    private static void m974a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long jM1925a = TypedArrayUtils.m1925a(typedArray, xmlPullParser, "duration", 1, 300);
        long jM1925a2 = TypedArrayUtils.m1925a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iM1925a = TypedArrayUtils.m1925a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (TypedArrayUtils.m1929a(xmlPullParser, "valueFrom") && TypedArrayUtils.m1929a(xmlPullParser, "valueTo")) {
            if (iM1925a == 4) {
                iM1925a = m961a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderM971a = m971a(typedArray, iM1925a, 5, 6, "");
            if (propertyValuesHolderM971a != null) {
                valueAnimator.setValues(propertyValuesHolderM971a);
            }
        }
        valueAnimator.setDuration(jM1925a);
        valueAnimator.setStartDelay(jM1925a2);
        valueAnimator.setRepeatCount(TypedArrayUtils.m1925a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.m1925a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m973a(valueAnimator, typedArray2, iM1925a, f, xmlPullParser);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m973a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM1927a = TypedArrayUtils.m1927a(typedArray, xmlPullParser, "pathData", 1);
        if (strM1927a != null) {
            String strM1927a2 = TypedArrayUtils.m1927a(typedArray, xmlPullParser, "propertyXName", 2);
            String strM1927a3 = TypedArrayUtils.m1927a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i == 2 || i == 4) {
            }
            if (strM1927a2 == null && strM1927a3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            m975a(PathParser.m1938a(strM1927a), objectAnimator, 0.5f * f, strM1927a2, strM1927a3);
            return;
        }
        objectAnimator.setPropertyName(TypedArrayUtils.m1927a(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* JADX INFO: renamed from: a */
    private static void m975a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        int i;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = CropImageView.DEFAULT_ASPECT_RATIO;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO));
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        int i2 = 0;
        float f2 = length / (iMin - 1);
        int i3 = 0;
        float fFloatValue = 0.0f;
        while (i3 < iMin) {
            pathMeasure2.getPosTan(fFloatValue, fArr3, null);
            fArr[i3] = fArr3[0];
            fArr2[i3] = fArr3[1];
            float f3 = fFloatValue + f2;
            if (i2 + 1 >= arrayList.size() || f3 <= ((Float) arrayList.get(i2 + 1)).floatValue()) {
                fFloatValue = f3;
                i = i2;
            } else {
                fFloatValue = f3 - ((Float) arrayList.get(i2 + 1)).floatValue();
                i = i2 + 1;
                pathMeasure2.nextContour();
            }
            i3++;
            i2 = i;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = null;
        if (str != null) {
            propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Animator m965a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return m966a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e5, code lost:
    
        if (r22 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e7, code lost:
    
        if (r13 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e9, code lost:
    
        r8 = new android.animation.Animator[r13.size()];
        r9 = r13.iterator();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f9, code lost:
    
        if (r9.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fb, code lost:
    
        r8[r6] = (android.animation.Animator) r9.next();
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0107, code lost:
    
        if (r23 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0109, code lost:
    
        r22.playTogether(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010f, code lost:
    
        r22.playSequentially(r8);
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.animation.Animator m966a(android.content.Context r17, android.content.res.Resources r18, android.content.res.Resources.Theme r19, org.xmlpull.v1.XmlPullParser r20, android.util.AttributeSet r21, android.animation.AnimatorSet r22, int r23, float r24) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.graphics.drawable.AnimatorInflaterCompat.m966a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder[] m978a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f988i);
                    String strM1927a = TypedArrayUtils.m1927a(typedArrayM1926a, xmlPullParser, "propertyName", 3);
                    int iM1925a = TypedArrayUtils.m1925a(typedArrayM1926a, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderM970a = m970a(context, resources, theme, xmlPullParser, strM1927a, iM1925a);
                    PropertyValuesHolder propertyValuesHolderM971a = propertyValuesHolderM970a == null ? m971a(typedArrayM1926a, iM1925a, 0, 1, strM1927a) : propertyValuesHolderM970a;
                    if (propertyValuesHolderM971a != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(propertyValuesHolderM971a);
                    } else {
                        arrayList = arrayList2;
                    }
                    typedArrayM1926a.recycle();
                } else {
                    arrayList = arrayList2;
                }
                xmlPullParser.next();
                arrayList2 = arrayList;
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        int size = arrayList2.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList2.get(i);
        }
        return propertyValuesHolderArr;
    }

    /* JADX INFO: renamed from: a */
    private static int m960a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i = 0;
        TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f989j);
        TypedValue typedValueM1931b = TypedArrayUtils.m1931b(typedArrayM1926a, xmlPullParser, "value", 0);
        if ((typedValueM1931b != null) && m977a(typedValueM1931b.type)) {
            i = 3;
        }
        typedArrayM1926a.recycle();
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static int m961a(TypedArray typedArray, int i, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && m977a(i3)) || (z2 && m977a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m970a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        int iM960a = i;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iM960a == 4) {
                    iM960a = m960a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM968a = m968a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iM960a, xmlPullParser);
                if (keyframeM968a != null) {
                    arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList.add(keyframeM968a);
                } else {
                    arrayList = arrayList2;
                }
                xmlPullParser.next();
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 == null || (size = arrayList2.size()) <= 0) {
            return null;
        }
        Keyframe keyframe = (Keyframe) arrayList2.get(0);
        Keyframe keyframe2 = (Keyframe) arrayList2.get(size - 1);
        float fraction = keyframe2.getFraction();
        if (fraction >= 1.0f) {
            i2 = size;
        } else if (fraction < CropImageView.DEFAULT_ASPECT_RATIO) {
            keyframe2.setFraction(1.0f);
            i2 = size;
        } else {
            arrayList2.add(arrayList2.size(), m967a(keyframe2, 1.0f));
            i2 = size + 1;
        }
        float fraction2 = keyframe.getFraction();
        if (fraction2 != CropImageView.DEFAULT_ASPECT_RATIO) {
            if (fraction2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                keyframe.setFraction(CropImageView.DEFAULT_ASPECT_RATIO);
            } else {
                arrayList2.add(0, m967a(keyframe, CropImageView.DEFAULT_ASPECT_RATIO));
                i2++;
            }
        }
        Keyframe[] keyframeArr = new Keyframe[i2];
        arrayList2.toArray(keyframeArr);
        for (int i3 = 0; i3 < i2; i3++) {
            Keyframe keyframe3 = keyframeArr[i3];
            if (keyframe3.getFraction() < CropImageView.DEFAULT_ASPECT_RATIO) {
                if (i3 == 0) {
                    keyframe3.setFraction(CropImageView.DEFAULT_ASPECT_RATIO);
                } else if (i3 == i2 - 1) {
                    keyframe3.setFraction(1.0f);
                } else {
                    int i4 = i3;
                    for (int i5 = i3 + 1; i5 < i2 - 1 && keyframeArr[i5].getFraction() < CropImageView.DEFAULT_ASPECT_RATIO; i5++) {
                        i4 = i5;
                    }
                    m976a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i4);
                }
            }
        }
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
        if (iM960a == 3) {
            propertyValuesHolderOfKeyframe.setEvaluator(ArgbEvaluator.m980a());
            return propertyValuesHolderOfKeyframe;
        }
        return propertyValuesHolderOfKeyframe;
    }

    /* JADX INFO: renamed from: a */
    private static Keyframe m967a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    /* JADX INFO: renamed from: a */
    private static void m976a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Keyframe m968a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f989j);
        Keyframe keyframeOfFloat = null;
        float fM1924a = TypedArrayUtils.m1924a(typedArrayM1926a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueM1931b = TypedArrayUtils.m1931b(typedArrayM1926a, xmlPullParser, "value", 0);
        boolean z = typedValueM1931b != null;
        if (i == 4) {
            i = (z && m977a(typedValueM1931b.type)) ? 3 : 0;
        }
        if (z) {
            switch (i) {
                case 0:
                    keyframeOfFloat = Keyframe.ofFloat(fM1924a, TypedArrayUtils.m1924a(typedArrayM1926a, xmlPullParser, "value", 0, CropImageView.DEFAULT_ASPECT_RATIO));
                    break;
                case 1:
                case 3:
                    keyframeOfFloat = Keyframe.ofInt(fM1924a, TypedArrayUtils.m1925a(typedArrayM1926a, xmlPullParser, "value", 0, 0));
                    break;
            }
        } else {
            keyframeOfFloat = i == 0 ? Keyframe.ofFloat(fM1924a) : Keyframe.ofInt(fM1924a);
        }
        int iM1932c = TypedArrayUtils.m1932c(typedArrayM1926a, xmlPullParser, "interpolator", 1, 0);
        if (iM1932c > 0) {
            keyframeOfFloat.setInterpolator(AnimationUtilsCompat.m958a(context, iM1932c));
        }
        typedArrayM1926a.recycle();
        return keyframeOfFloat;
    }

    /* JADX INFO: renamed from: a */
    private static ObjectAnimator m969a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m972a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* JADX INFO: renamed from: a */
    private static ValueAnimator m972a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayM1926a = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f986g);
        TypedArray typedArrayM1926a2 = TypedArrayUtils.m1926a(resources, theme, attributeSet, AndroidResources.f990k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m974a(valueAnimator, typedArrayM1926a, typedArrayM1926a2, f, xmlPullParser);
        int iM1932c = TypedArrayUtils.m1932c(typedArrayM1926a, xmlPullParser, "interpolator", 0, 0);
        if (iM1932c > 0) {
            valueAnimator.setInterpolator(AnimationUtilsCompat.m958a(context, iM1932c));
        }
        typedArrayM1926a.recycle();
        if (typedArrayM1926a2 != null) {
            typedArrayM1926a2.recycle();
        }
        return valueAnimator;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m977a(int i) {
        return i >= 28 && i <= 31;
    }
}
