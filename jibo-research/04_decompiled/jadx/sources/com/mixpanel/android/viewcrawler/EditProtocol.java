package com.mixpanel.android.viewcrawler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.Pathfinder;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class EditProtocol {

    /* JADX INFO: renamed from: e */
    private static final Class<?>[] f12106e = new Class[0];

    /* JADX INFO: renamed from: f */
    private static final List<Pathfinder.PathElement> f12107f = Collections.emptyList();

    /* JADX INFO: renamed from: a */
    private final Context f12108a;

    /* JADX INFO: renamed from: b */
    private final ResourceIds f12109b;

    /* JADX INFO: renamed from: c */
    private final ImageStore f12110c;

    /* JADX INFO: renamed from: d */
    private final ViewVisitor.OnLayoutErrorListener f12111d;

    public static class BadInstructionsException extends Exception {
        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class InapplicableInstructionsException extends BadInstructionsException {
        public InapplicableInstructionsException(String str) {
            super(str);
        }
    }

    public static class CantGetEditAssetsException extends Exception {
        public CantGetEditAssetsException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static class Edit {

        /* JADX INFO: renamed from: a */
        public final ViewVisitor f12112a;

        /* JADX INFO: renamed from: b */
        public final List<String> f12113b;

        private Edit(ViewVisitor viewVisitor, List<String> list) {
            this.f12112a = viewVisitor;
            this.f12113b = list;
        }
    }

    public EditProtocol(Context context, ResourceIds resourceIds, ImageStore imageStore, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
        this.f12108a = context;
        this.f12109b = resourceIds;
        this.f12110c = imageStore;
        this.f12111d = onLayoutErrorListener;
    }

    /* JADX INFO: renamed from: a */
    public ViewVisitor m12054a(JSONObject jSONObject, ViewVisitor.OnEventListener onEventListener) throws BadInstructionsException {
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            List<Pathfinder.PathElement> listM12055a = m12055a(jSONObject.getJSONArray("path"), this.f12109b);
            if (listM12055a.size() == 0) {
                throw new InapplicableInstructionsException("event '" + string + "' will not be bound to any element in the UI.");
            }
            if ("click".equals(string2)) {
                return new ViewVisitor.AddAccessibilityEventVisitor(listM12055a, 1, string, onEventListener);
            }
            if ("selected".equals(string2)) {
                return new ViewVisitor.AddAccessibilityEventVisitor(listM12055a, 4, string, onEventListener);
            }
            if ("text_changed".equals(string2)) {
                return new ViewVisitor.AddTextChangeListener(listM12055a, string, onEventListener);
            }
            if ("detected".equals(string2)) {
                return new ViewVisitor.ViewDetectorVisitor(listM12055a, string, onEventListener);
            }
            throw new BadInstructionsException("Mixpanel can't track event type \"" + string2 + "\"");
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public Edit m12053a(JSONObject jSONObject) throws BadInstructionsException, CantGetEditAssetsException {
        ViewVisitor layoutUpdateVisitor;
        Integer numM12051a;
        ArrayList arrayList = new ArrayList();
        try {
            List<Pathfinder.PathElement> listM12055a = m12055a(jSONObject.getJSONArray("path"), this.f12109b);
            if (listM12055a.size() == 0) {
                throw new InapplicableInstructionsException("Edit will not be bound to any element in the UI.");
            }
            if (jSONObject.getString("change_type").equals("property")) {
                String string = jSONObject.getJSONObject("property").getString("classname");
                if (string == null) {
                    throw new BadInstructionsException("Can't bind an edit property without a target class");
                }
                try {
                    PropertyDescription propertyDescriptionM12050a = m12050a(Class.forName(string), jSONObject.getJSONObject("property"));
                    JSONArray jSONArray = jSONObject.getJSONArray("args");
                    Object[] objArr = new Object[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        objArr[i] = m12052a(jSONArray2.get(0), jSONArray2.getString(1), arrayList);
                    }
                    Caller callerM12097a = propertyDescriptionM12050a.m12097a(objArr);
                    if (callerM12097a == null) {
                        throw new BadInstructionsException("Can't update a read-only property " + propertyDescriptionM12050a.f12154a + " (add a mutator to make this work)");
                    }
                    layoutUpdateVisitor = new ViewVisitor.PropertySetVisitor(listM12055a, callerM12097a, propertyDescriptionM12050a.f12156c);
                } catch (ClassNotFoundException e) {
                    throw new BadInstructionsException("Can't find class for visit path: " + string, e);
                }
            } else if (jSONObject.getString("change_type").equals("layout")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("args");
                ArrayList arrayList2 = new ArrayList();
                int length = jSONArray3.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray3.optJSONObject(i2);
                    String string2 = jSONObjectOptJSONObject.getString("view_id_name");
                    String string3 = jSONObjectOptJSONObject.getString("anchor_id_name");
                    Integer numM12051a2 = m12051a(-1, string2, this.f12109b);
                    if (string3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        numM12051a = 0;
                    } else if (string3.equals("-1")) {
                        numM12051a = -1;
                    } else {
                        numM12051a = m12051a(-1, string3, this.f12109b);
                    }
                    if (numM12051a2 == null || numM12051a == null) {
                        MPLog.m12028d("MixpanelAPI.EProtocol", "View (" + string2 + ") or anchor (" + string3 + ") not found.");
                    } else {
                        arrayList2.add(new ViewVisitor.LayoutRule(numM12051a2.intValue(), jSONObjectOptJSONObject.getInt("verb"), numM12051a.intValue()));
                    }
                }
                layoutUpdateVisitor = new ViewVisitor.LayoutUpdateVisitor(listM12055a, arrayList2, jSONObject.getString("name"), this.f12111d);
            } else {
                throw new BadInstructionsException("Can't figure out the edit type");
            }
            return new Edit(layoutUpdateVisitor, arrayList);
        } catch (NoSuchMethodException e2) {
            throw new BadInstructionsException("Can't create property mutator", e2);
        } catch (JSONException e3) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e3);
        }
    }

    /* JADX INFO: renamed from: b */
    public ViewSnapshot m12056b(JSONObject jSONObject) throws BadInstructionsException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(m12050a(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new ViewSnapshot(this.f12108a, arrayList, this.f12109b);
        } catch (ClassNotFoundException e) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e);
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't read snapshot configuration", e2);
        }
    }

    /* JADX INFO: renamed from: c */
    public Pair<String, Object> m12057c(JSONObject jSONObject) throws BadInstructionsException {
        Object string;
        try {
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString(ShareConstants.MEDIA_TYPE);
            if ("number".equals(string3)) {
                String string4 = jSONObject.getString("encoding");
                if ("d".equals(string4)) {
                    string = Double.valueOf(jSONObject.getDouble("value"));
                } else if ("l".equals(string4)) {
                    string = Long.valueOf(jSONObject.getLong("value"));
                } else {
                    throw new BadInstructionsException("number must have encoding of type \"l\" for long or \"d\" for double in: " + jSONObject);
                }
            } else if ("boolean".equals(string3)) {
                string = Boolean.valueOf(jSONObject.getBoolean("value"));
            } else if ("string".equals(string3)) {
                string = jSONObject.getString("value");
            } else {
                throw new BadInstructionsException("Unrecognized tweak type " + string3 + " in: " + jSONObject);
            }
            return new Pair<>(string2, string);
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't read tweak update", e);
        }
    }

    /* JADX INFO: renamed from: a */
    List<Pathfinder.PathElement> m12055a(JSONArray jSONArray, ResourceIds resourceIds) throws JSONException {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String strM12019a = JSONUtils.m12019a(jSONObject, "prefix");
            String strM12019a2 = JSONUtils.m12019a(jSONObject, "view_class");
            int iOptInt = jSONObject.optInt("index", -1);
            String strM12019a3 = JSONUtils.m12019a(jSONObject, "contentDescription");
            int iOptInt2 = jSONObject.optInt(ShareConstants.WEB_DIALOG_PARAM_ID, -1);
            String strM12019a4 = JSONUtils.m12019a(jSONObject, "mp_id_name");
            String strM12019a5 = JSONUtils.m12019a(jSONObject, "tag");
            if ("shortest".equals(strM12019a)) {
                i = 1;
            } else {
                if (strM12019a != null) {
                    MPLog.m12028d("MixpanelAPI.EProtocol", "Unrecognized prefix type \"" + strM12019a + "\". No views will be matched");
                    return f12107f;
                }
                i = 0;
            }
            Integer numM12051a = m12051a(iOptInt2, strM12019a4, resourceIds);
            if (numM12051a == null) {
                return f12107f;
            }
            arrayList.add(new Pathfinder.PathElement(i, strM12019a2, iOptInt, numM12051a.intValue(), strM12019a3, strM12019a5));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private Integer m12051a(int i, String str, ResourceIds resourceIds) {
        int iMo11925b;
        if (str == null) {
            iMo11925b = -1;
        } else if (resourceIds.mo11924a(str)) {
            iMo11925b = resourceIds.mo11925b(str);
        } else {
            MPLog.m12028d("MixpanelAPI.EProtocol", "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"" + str + "\"");
            return null;
        }
        if (-1 != iMo11925b && -1 != i && iMo11925b != i) {
            MPLog.m12030e("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        }
        if (-1 != iMo11925b) {
            return Integer.valueOf(iMo11925b);
        }
        return Integer.valueOf(i);
    }

    /* JADX INFO: renamed from: a */
    private PropertyDescription m12050a(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), f12106e, Class.forName(jSONObject2.getJSONObject("result").getString(ShareConstants.MEDIA_TYPE)));
            } else {
                caller = null;
            }
            return new PropertyDescription(string, cls, caller, jSONObject.has("set") ? jSONObject.getJSONObject("set").getString("selector") : null);
        } catch (ClassNotFoundException e) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e);
        } catch (NoSuchMethodException e2) {
            throw new BadInstructionsException("Can't create property reader", e2);
        } catch (JSONException e3) {
            throw new BadInstructionsException("Can't read property JSON", e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private Object m12052a(Object obj, String str, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        try {
            if (!"java.lang.CharSequence".equals(str) && !"boolean".equals(str) && !"java.lang.Boolean".equals(str)) {
                if ("int".equals(str) || "java.lang.Integer".equals(str)) {
                    return Integer.valueOf(((Number) obj).intValue());
                }
                if ("float".equals(str) || "java.lang.Float".equals(str)) {
                    return Float.valueOf(((Number) obj).floatValue());
                }
                if ("android.graphics.drawable.Drawable".equals(str)) {
                    return m12049a((JSONObject) obj, list);
                }
                if ("android.graphics.drawable.BitmapDrawable".equals(str)) {
                    return m12049a((JSONObject) obj, list);
                }
                if ("android.graphics.drawable.ColorDrawable".equals(str)) {
                    return new ColorDrawable(((Number) obj).intValue());
                }
                throw new BadInstructionsException("Don't know how to interpret type " + str + " (arg was " + obj + ")");
            }
            return obj;
        } catch (ClassCastException e) {
            throw new BadInstructionsException("Couldn't interpret <" + obj + "> as " + str);
        }
    }

    /* JADX INFO: renamed from: a */
    private Drawable m12049a(JSONObject jSONObject, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = false;
        try {
            if (jSONObject.isNull("url")) {
                throw new BadInstructionsException("Can't construct a BitmapDrawable with a null url");
            }
            String string = jSONObject.getString("url");
            if (jSONObject.isNull("dimensions")) {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                i = jSONObject2.getInt("left");
                i2 = jSONObject2.getInt("right");
                i3 = jSONObject2.getInt("top");
                i4 = jSONObject2.getInt("bottom");
                z = true;
            }
            try {
                Bitmap bitmapM12016b = this.f12110c.m12016b(string);
                list.add(string);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), bitmapM12016b);
                if (z) {
                    bitmapDrawable.setBounds(i, i3, i2, i4);
                }
                return bitmapDrawable;
            } catch (ImageStore.CantGetImageException e) {
                throw new CantGetEditAssetsException(e.getMessage(), e.getCause());
            }
        } catch (JSONException e2) {
            throw new BadInstructionsException("Couldn't read drawable description", e2);
        }
    }
}
