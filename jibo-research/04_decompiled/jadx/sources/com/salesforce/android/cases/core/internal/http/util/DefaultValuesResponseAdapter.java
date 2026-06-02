package com.salesforce.android.cases.core.internal.http.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.salesforce.android.cases.core.internal.http.response.DefaultValuesResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValuesResponseAdapter extends TypeAdapter<DefaultValuesResponse> {

    /* JADX INFO: renamed from: a */
    private Gson f12332a = new GsonBuilder().m9379a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").m9376a();

    private DefaultValuesResponseAdapter() {
    }

    /* JADX INFO: renamed from: a */
    public static DefaultValuesResponseAdapter m12366a() {
        return new DefaultValuesResponseAdapter();
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, DefaultValuesResponse defaultValuesResponse) throws IOException {
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultValuesResponse read(JsonReader jsonReader) throws IOException {
        JsonObject jsonObjectM9395l = this.f12332a.m9343a(this.f12332a.m9352a(jsonReader, (Type) Object.class)).m9395l();
        DefaultValuesResponse defaultValuesResponse = (DefaultValuesResponse) this.f12332a.m9350a((JsonElement) jsonObjectM9395l, DefaultValuesResponse.class);
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObjectM9395l.m9401a()) {
            String key = entry.getKey();
            if (!"attributes".equals(key)) {
                map.put(key, entry.getValue().mo9385c());
            }
        }
        defaultValuesResponse.m12332a(map);
        return defaultValuesResponse;
    }
}
