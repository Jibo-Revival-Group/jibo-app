package com.jibo.api.iheart;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.jibo.R;
import com.jibo.api.iheart.model.Genre;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class IHeartFileHelper {

    /* JADX INFO: renamed from: a */
    private static final HashMap<String, String> f9284a = new HashMap<>();

    static {
        f9284a.put("CA", "NPR");
    }

    /* JADX INFO: renamed from: a */
    private static String m9886a(Context context) throws IOException {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(R.raw.genres);
        byte[] bArr = new byte[inputStreamOpenRawResource.available()];
        inputStreamOpenRawResource.read(bArr);
        inputStreamOpenRawResource.close();
        return new String(bArr, HTTP.UTF_8);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m9888a(JSONObject jSONObject, String str) throws JSONException {
        String str2 = f9284a.get(str);
        return str2 != null && str2.toLowerCase().contains(jSONObject.getString("name").toLowerCase());
    }

    /* JADX INFO: renamed from: a */
    public static List<Genre> m9887a(Context context, String str) throws JSONException, IOException {
        ArrayList arrayList = new ArrayList();
        String strM9886a = m9886a(context);
        if (strM9886a != null) {
            JSONArray jSONArray = new JSONArray(strM9886a);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!m9888a(jSONObject, str)) {
                    arrayList.add(new Genre(jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject.getString("name")));
                }
            }
        }
        return arrayList;
    }
}
