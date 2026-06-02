package com.segment.analytics.integrations;

import com.segment.analytics.Traits;
import com.segment.analytics.integrations.BasePayload;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class IdentifyPayload extends BasePayload {
    static final String TRAITS_KEY = "traits";

    IdentifyPayload(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, Map<String, Object> map3) {
        super(BasePayload.Type.identify, str, date, map, map2, str2, str3);
        put(TRAITS_KEY, (Object) map3);
    }

    public Traits traits() {
        return (Traits) getValueMap(TRAITS_KEY, Traits.class);
    }

    @Override // com.segment.analytics.ValueMap
    public String toString() {
        return "IdentifyPayload{\"userId=\"" + userId() + "\"}";
    }

    @Override // com.segment.analytics.integrations.BasePayload
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder extends BasePayload.Builder<IdentifyPayload, Builder> {
        private Map<String, Object> traits;

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        /* bridge */ /* synthetic */ BasePayload realBuild(String str, Date date, Map map, Map map2, String str2, String str3) {
            return realBuild(str, date, (Map<String, Object>) map, (Map<String, Object>) map2, str2, str3);
        }

        public Builder() {
        }

        Builder(IdentifyPayload identifyPayload) {
            super(identifyPayload);
            this.traits = identifyPayload.traits();
        }

        public Builder traits(Map<String, ?> map) {
            Utils.assertNotNull(map, IdentifyPayload.TRAITS_KEY);
            this.traits = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        IdentifyPayload realBuild(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            if (Utils.isNullOrEmpty(str2) && Utils.isNullOrEmpty(this.traits)) {
                throw new NullPointerException("either userId or traits are required");
            }
            return new IdentifyPayload(str, date, map, map2, str2, str3, this.traits);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.segment.analytics.integrations.BasePayload.Builder
        public Builder self() {
            return this;
        }
    }
}
