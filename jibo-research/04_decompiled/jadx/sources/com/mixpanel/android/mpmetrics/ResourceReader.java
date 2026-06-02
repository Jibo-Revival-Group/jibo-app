package com.mixpanel.android.mpmetrics;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceReader implements ResourceIds {

    /* JADX INFO: renamed from: a */
    private final Context f12011a;

    /* JADX INFO: renamed from: b */
    private final Map<String, Integer> f12012b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final SparseArray<String> f12013c = new SparseArray<>();

    /* JADX INFO: renamed from: a */
    protected abstract Class<?> mo11927a();

    /* JADX INFO: renamed from: a */
    protected abstract String mo11928a(Context context);

    public static class Ids extends ResourceReader {

        /* JADX INFO: renamed from: a */
        private final String f12015a;

        public Ids(String str, Context context) {
            super(context);
            this.f12015a = str;
            m11929b();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        /* JADX INFO: renamed from: a */
        protected Class<?> mo11927a() {
            return R.id.class;
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        /* JADX INFO: renamed from: a */
        protected String mo11928a(Context context) {
            return this.f12015a + ".R$id";
        }
    }

    public static class Drawables extends ResourceReader {

        /* JADX INFO: renamed from: a */
        private final String f12014a;

        protected Drawables(String str, Context context) {
            super(context);
            this.f12014a = str;
            m11929b();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        /* JADX INFO: renamed from: a */
        protected Class<?> mo11927a() {
            return R.drawable.class;
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        /* JADX INFO: renamed from: a */
        protected String mo11928a(Context context) {
            return this.f12014a + ".R$drawable";
        }
    }

    protected ResourceReader(Context context) {
        this.f12011a = context;
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    /* JADX INFO: renamed from: a */
    public boolean mo11924a(String str) {
        return this.f12012b.containsKey(str);
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    /* JADX INFO: renamed from: b */
    public int mo11925b(String str) {
        return this.f12012b.get(str).intValue();
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    /* JADX INFO: renamed from: a */
    public String mo11923a(int i) {
        return this.f12013c.get(i);
    }

    /* JADX INFO: renamed from: a */
    private static void m11926a(Class<?> cls, String str, Map<String, Integer> map) {
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    String name = field.getName();
                    int i = field.getInt(null);
                    if (str != null) {
                        name = str + ":" + name;
                    }
                    map.put(name, Integer.valueOf(i));
                }
            }
        } catch (IllegalAccessException e) {
            MPLog.m12031e("MixpanelAPI.RsrcReader", "Can't read built-in id names from " + cls.getName(), e);
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m11929b() {
        this.f12012b.clear();
        this.f12013c.clear();
        m11926a(mo11927a(), "android", this.f12012b);
        String strMo11928a = mo11928a(this.f12011a);
        try {
            m11926a(Class.forName(strMo11928a), null, this.f12012b);
        } catch (ClassNotFoundException e) {
            MPLog.m12028d("MixpanelAPI.RsrcReader", "Can't load names for Android view ids from '" + strMo11928a + "', ids by name will not be available in the events editor.");
            MPLog.m12026c("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Map.Entry<String, Integer> entry : this.f12012b.entrySet()) {
            this.f12013c.put(entry.getValue().intValue(), entry.getKey());
        }
    }
}
