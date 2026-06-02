package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class TypedArrayUtils {
    /* JADX INFO: renamed from: a */
    public static boolean m1929a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* JADX INFO: renamed from: a */
    public static float m1924a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m1929a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1928a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m1929a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* JADX INFO: renamed from: a */
    public static int m1925a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1929a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public static int m1930b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1929a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* JADX INFO: renamed from: c */
    public static int m1932c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1929a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static String m1927a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m1929a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static TypedValue m1931b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m1929a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static TypedArray m1926a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
