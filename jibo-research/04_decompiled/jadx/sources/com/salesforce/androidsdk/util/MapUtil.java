package com.salesforce.androidsdk.util;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MapUtil {
    /* JADX INFO: renamed from: a */
    public static Map<String, String> m15013a(Bundle bundle, List<String> list, Map<String, String> map) {
        if (bundle != null && list != null && !bundle.isEmpty() && !list.isEmpty()) {
            if (map == null) {
                map = new HashMap<>();
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    map.put(str, bundle.getString(str));
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    public static Bundle m15012a(Map<String, String> map, List<String> list, Bundle bundle) {
        if (map != null && list != null && !map.isEmpty() && !list.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString(str, map.get(str));
                }
            }
        }
        return bundle;
    }
}
