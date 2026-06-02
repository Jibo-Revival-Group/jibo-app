package com.segment.analytics.integrations;

import com.segment.analytics.AnalyticsContext;
import com.segment.analytics.ValueMap;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePayload extends ValueMap {
    static final String ANONYMOUS_ID_KEY = "anonymousId";
    static final String CHANNEL_KEY = "channel";
    static final String CONTEXT_KEY = "context";
    static final String INTEGRATIONS_KEY = "integrations";
    static final String MESSAGE_ID = "messageId";
    static final String TIMESTAMP_KEY = "timestamp";
    static final String TYPE_KEY = "type";
    static final String USER_ID_KEY = "userId";

    public enum Channel {
        browser,
        mobile,
        server
    }

    public enum Type {
        alias,
        group,
        identify,
        screen,
        track
    }

    public abstract Builder toBuilder();

    BasePayload(Type type, String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
        put(CHANNEL_KEY, (Object) Channel.mobile);
        put("type", (Object) type);
        put(MESSAGE_ID, (Object) str);
        put(TIMESTAMP_KEY, (Object) Utils.toISO8601String(date));
        put(CONTEXT_KEY, (Object) map);
        put(INTEGRATIONS_KEY, (Object) map2);
        if (!Utils.isNullOrEmpty(str2)) {
            put(USER_ID_KEY, (Object) str2);
        }
        put(ANONYMOUS_ID_KEY, (Object) str3);
    }

    public Type type() {
        return (Type) getEnum(Type.class, "type");
    }

    public String userId() {
        return getString(USER_ID_KEY);
    }

    public String anonymousId() {
        return getString(ANONYMOUS_ID_KEY);
    }

    public String messageId() {
        return getString(MESSAGE_ID);
    }

    public Date timestamp() {
        String string = getString(TIMESTAMP_KEY);
        if (Utils.isNullOrEmpty(string)) {
            return null;
        }
        return Utils.parseISO8601Date(string);
    }

    public ValueMap integrations() {
        return getValueMap(INTEGRATIONS_KEY);
    }

    public AnalyticsContext context() {
        return (AnalyticsContext) getValueMap(CONTEXT_KEY, AnalyticsContext.class);
    }

    @Override // com.segment.analytics.ValueMap
    public BasePayload putValue(String str, Object obj) {
        super.putValue(str, obj);
        return this;
    }

    public static abstract class Builder<P extends BasePayload, B extends Builder> {
        private String anonymousId;
        private Map<String, Object> context;
        private Map<String, Object> integrationsBuilder;
        private String messageId;
        private Date timestamp;
        private String userId;

        abstract P realBuild(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3);

        abstract B self();

        Builder() {
        }

        Builder(BasePayload basePayload) {
            this.messageId = basePayload.messageId();
            this.timestamp = basePayload.timestamp();
            this.context = basePayload.context();
            this.integrationsBuilder = new LinkedHashMap(basePayload.integrations());
            this.userId = basePayload.userId();
            this.anonymousId = basePayload.anonymousId();
        }

        public B messageId(String str) {
            Utils.assertNotNullOrEmpty(str, BasePayload.MESSAGE_ID);
            this.messageId = str;
            return (B) self();
        }

        public B timestamp(Date date) {
            Utils.assertNotNull(date, BasePayload.TIMESTAMP_KEY);
            this.timestamp = date;
            return (B) self();
        }

        public B context(Map<String, ?> map) {
            Utils.assertNotNull(map, BasePayload.CONTEXT_KEY);
            this.context = Collections.unmodifiableMap(new LinkedHashMap(map));
            return (B) self();
        }

        public B integration(String str, boolean z) {
            Utils.assertNotNullOrEmpty(str, "key");
            if (this.integrationsBuilder == null) {
                this.integrationsBuilder = new LinkedHashMap();
            }
            this.integrationsBuilder.put(str, Boolean.valueOf(z));
            return (B) self();
        }

        public B integration(String str, Map<String, Object> map) {
            Utils.assertNotNullOrEmpty(str, "key");
            Utils.assertNotNullOrEmpty(map, "options");
            if (this.integrationsBuilder == null) {
                this.integrationsBuilder = new LinkedHashMap();
            }
            this.integrationsBuilder.put(str, Utils.immutableCopyOf(map));
            return (B) self();
        }

        public B integrations(Map<String, ?> map) {
            if (Utils.isNullOrEmpty(map)) {
                return (B) self();
            }
            if (this.integrationsBuilder == null) {
                this.integrationsBuilder = new LinkedHashMap();
            }
            this.integrationsBuilder.putAll(map);
            return (B) self();
        }

        public B anonymousId(String str) {
            this.anonymousId = Utils.assertNotNullOrEmpty(str, BasePayload.ANONYMOUS_ID_KEY);
            return (B) self();
        }

        public B userId(String str) {
            this.userId = Utils.assertNotNullOrEmpty(str, BasePayload.USER_ID_KEY);
            return (B) self();
        }

        public P build() {
            Map<String, Object> mapImmutableCopyOf;
            if (Utils.isNullOrEmpty(this.userId) && Utils.isNullOrEmpty(this.anonymousId)) {
                throw new NullPointerException("either userId or anonymousId is required");
            }
            if (Utils.isNullOrEmpty(this.integrationsBuilder)) {
                mapImmutableCopyOf = Collections.emptyMap();
            } else {
                mapImmutableCopyOf = Utils.immutableCopyOf(this.integrationsBuilder);
            }
            if (Utils.isNullOrEmpty(this.messageId)) {
                this.messageId = UUID.randomUUID().toString();
            }
            if (this.timestamp == null) {
                this.timestamp = new Date();
            }
            if (Utils.isNullOrEmpty(this.context)) {
                this.context = Collections.emptyMap();
            }
            return (P) realBuild(this.messageId, this.timestamp, this.context, mapImmutableCopyOf, this.userId, this.anonymousId);
        }
    }
}
