package com.segment.analytics.integrations;

import com.segment.analytics.integrations.BasePayload;
import com.segment.analytics.internal.Utils;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AliasPayload extends BasePayload {
    static final String PREVIOUS_ID_KEY = "previousId";

    AliasPayload(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4) {
        super(BasePayload.Type.alias, str, date, map, map2, str2, str3);
        put(PREVIOUS_ID_KEY, (Object) str4);
    }

    public String previousId() {
        return getString(PREVIOUS_ID_KEY);
    }

    @Override // com.segment.analytics.ValueMap
    public String toString() {
        return "AliasPayload{userId=\"" + userId() + ",previousId=\"" + previousId() + "\"}";
    }

    @Override // com.segment.analytics.integrations.BasePayload
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static final class Builder extends BasePayload.Builder<AliasPayload, Builder> {
        private String previousId;

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        protected /* bridge */ /* synthetic */ BasePayload realBuild(String str, Date date, Map map, Map map2, String str2, String str3) {
            return realBuild(str, date, (Map<String, Object>) map, (Map<String, Object>) map2, str2, str3);
        }

        public Builder() {
        }

        Builder(AliasPayload aliasPayload) {
            super(aliasPayload);
            this.previousId = aliasPayload.previousId();
        }

        public Builder previousId(String str) {
            this.previousId = Utils.assertNotNullOrEmpty(str, AliasPayload.PREVIOUS_ID_KEY);
            return this;
        }

        @Override // com.segment.analytics.integrations.BasePayload.Builder
        protected AliasPayload realBuild(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            Utils.assertNotNullOrEmpty(str2, "userId");
            Utils.assertNotNullOrEmpty(this.previousId, AliasPayload.PREVIOUS_ID_KEY);
            return new AliasPayload(str, date, map, map2, str2, str3, this.previousId);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.segment.analytics.integrations.BasePayload.Builder
        public Builder self() {
            return this;
        }
    }
}
