package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.compat.R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FontResourcesParserCompat {

    public interface FamilyResourceEntry {
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a */
        private final FontRequest f1843a;

        /* JADX INFO: renamed from: b */
        private final int f1844b;

        /* JADX INFO: renamed from: c */
        private final int f1845c;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2) {
            this.f1843a = fontRequest;
            this.f1845c = i;
            this.f1844b = i2;
        }

        /* JADX INFO: renamed from: a */
        public FontRequest m1913a() {
            return this.f1843a;
        }

        /* JADX INFO: renamed from: b */
        public int m1914b() {
            return this.f1845c;
        }

        /* JADX INFO: renamed from: c */
        public int m1915c() {
            return this.f1844b;
        }
    }

    public static final class FontFileResourceEntry {

        /* JADX INFO: renamed from: a */
        private final String f1839a;

        /* JADX INFO: renamed from: b */
        private int f1840b;

        /* JADX INFO: renamed from: c */
        private boolean f1841c;

        /* JADX INFO: renamed from: d */
        private int f1842d;

        public FontFileResourceEntry(String str, int i, boolean z, int i2) {
            this.f1839a = str;
            this.f1840b = i;
            this.f1841c = z;
            this.f1842d = i2;
        }

        /* JADX INFO: renamed from: a */
        public String m1909a() {
            return this.f1839a;
        }

        /* JADX INFO: renamed from: b */
        public int m1910b() {
            return this.f1840b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m1911c() {
            return this.f1841c;
        }

        /* JADX INFO: renamed from: d */
        public int m1912d() {
            return this.f1842d;
        }
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        /* JADX INFO: renamed from: a */
        private final FontFileResourceEntry[] f1838a;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.f1838a = fontFileResourceEntryArr;
        }

        /* JADX INFO: renamed from: a */
        public FontFileResourceEntry[] m1908a() {
            return this.f1838a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static FamilyResourceEntry m1901a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return m1905b(xmlPullParser, resources);
    }

    /* JADX INFO: renamed from: b */
    private static FamilyResourceEntry m1905b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m1906c(xmlPullParser, resources);
        }
        m1904a(xmlPullParser);
        return null;
    }

    /* JADX INFO: renamed from: c */
    private static FamilyResourceEntry m1906c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m1904a(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, m1902a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m1907d(xmlPullParser, resources));
                } else {
                    m1904a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
    }

    /* JADX INFO: renamed from: a */
    public static List<List<byte[]>> m1902a(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
            if (typedArrayObtainTypedArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                if (typedArrayObtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                        arrayList2.add(m1903a(resources.getStringArray(typedArrayObtainTypedArray.getResourceId(i2, 0))));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList2.add(m1903a(resources.getStringArray(i)));
                    arrayList = arrayList2;
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    /* JADX INFO: renamed from: a */
    private static List<byte[]> m1903a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    private static FontFileResourceEntry m1907d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight) ? R.styleable.FontFamilyFont_fontWeight : R.styleable.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle) ? R.styleable.FontFamilyFont_fontStyle : R.styleable.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(R.styleable.FontFamilyFont_font) ? R.styleable.FontFamilyFont_font : R.styleable.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i2, 0);
        String string = typedArrayObtainAttributes.getString(i2);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m1904a(xmlPullParser);
        }
        return new FontFileResourceEntry(string, i, z, resourceId);
    }

    /* JADX INFO: renamed from: a */
    private static void m1904a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
