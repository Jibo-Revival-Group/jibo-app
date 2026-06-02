package com.salesforce.android.cases.core.internal.http.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.salesforce.android.cases.core.internal.http.response.CaseDetailResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CaseDetailResponseAdapter extends TypeAdapter<CaseDetailResponse> {

    /* JADX INFO: renamed from: a */
    private Gson f12331a = new GsonBuilder().m9379a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").m9376a();

    private CaseDetailResponseAdapter() {
    }

    /* JADX INFO: renamed from: a */
    public static CaseDetailResponseAdapter m12363a() {
        return new CaseDetailResponseAdapter();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, CaseDetailResponse caseDetailResponse) throws IOException {
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CaseDetailResponse read(JsonReader jsonReader) throws IOException {
        JsonObject jsonObjectM9395l = this.f12331a.m9343a(this.f12331a.m9352a(jsonReader, (Type) Object.class)).m9395l();
        CaseDetailResponse caseDetailResponse = (CaseDetailResponse) this.f12331a.m9350a((JsonElement) jsonObjectM9395l, CaseDetailResponse.class);
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObjectM9395l.m9401a()) {
            String key = entry.getKey();
            if (key.endsWith("__c")) {
                map.put(key, entry.getValue().mo9385c());
            }
        }
        caseDetailResponse.m12264a(map);
        return caseDetailResponse;
    }
}
