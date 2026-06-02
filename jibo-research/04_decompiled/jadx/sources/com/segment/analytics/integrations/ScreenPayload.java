package com.segment.analytics.integrations;

import com.segment.analytics.Properties;
import com.segment.analytics.integrations.BasePayload;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ScreenPayload extends BasePayload {
    static final String CATEGORY_KEY = "category";
    static final String NAME_KEY = "name";
    static final String PROPERTIES_KEY = "properties";

    ScreenPayload(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4, String str5, Map<String, Object> map3) {
        super(BasePayload.Type.screen, str, date, map, map2, str2, str3);
        if (!Utils.isNullOrEmpty(str4)) {
            put("name", (Object) str4);
        }
        if (!Utils.isNullOrEmpty(str5)) {
            put(CATEGORY_KEY, (Object) str5);
        }
        put(PROPERTIES_KEY, (Object) map3);
    }

    @Deprecated
    public String category() {
        return getString(CATEGORY_KEY);
    }

    public String name() {
        return getString("name");
    }

    public String event() {
        String strName = name();
        return !Utils.isNullOrEmpty(strName) ? strName : category();
    }

    public Properties properties() {
        return (Properties) getValueMap(PROPERTIES_KEY, Properties.class);
    }

    @Override // com.segment.analytics.ValueMap
    public String toString() {
        return "ScreenPayload{name=\"" + name() + ",category=\"" + category() + "\"}";
    }

    @Override // com.segment.analytics.integrations.BasePayload
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder extends BasePayload.Builder<ScreenPayload, Builder> {
        private String category;
        private String name;
        private Map<String, Object> properties;

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        protected /* bridge */ /* synthetic */ BasePayload realBuild(String str, Date date, Map map, Map map2, String str2, String str3) {
            return realBuild(str, date, (Map<String, Object>) map, (Map<String, Object>) map2, str2, str3);
        }

        public Builder() {
        }

        Builder(ScreenPayload screenPayload) {
            super(screenPayload);
            this.name = screenPayload.name();
            this.properties = screenPayload.properties();
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        @Deprecated
        public Builder category(String str) {
            this.category = str;
            return this;
        }

        public Builder properties(Map<String, ?> map) {
            Utils.assertNotNull(map, ScreenPayload.PROPERTIES_KEY);
            this.properties = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        protected ScreenPayload realBuild(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            if (Utils.isNullOrEmpty(this.name) && Utils.isNullOrEmpty(this.category)) {
                throw new NullPointerException("either name or category is required");
            }
            Map<String, Object> mapEmptyMap = this.properties;
            if (Utils.isNullOrEmpty(mapEmptyMap)) {
                mapEmptyMap = Collections.emptyMap();
            }
            return new ScreenPayload(str, date, map, map2, str2, str3, this.name, this.category, mapEmptyMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.segment.analytics.integrations.BasePayload.Builder
        public Builder self() {
            return this;
        }
    }
}
