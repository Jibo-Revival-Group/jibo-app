package com.segment.analytics.android.integrations.mixpanel;

import android.app.Activity;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.ValueMap;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MixpanelIntegration extends Integration<MixpanelAPI> {
    public static final Integration.Factory FACTORY = new Integration.Factory() { // from class: com.segment.analytics.android.integrations.mixpanel.MixpanelIntegration.1
        @Override // com.segment.analytics.integrations.Integration.Factory
        public Integration<?> create(ValueMap valueMap, Analytics analytics) {
            MixpanelAPI.People peopleM11842c;
            boolean z = valueMap.getBoolean("consolidatedPageCalls", true);
            boolean z2 = valueMap.getBoolean("trackAllPages", false);
            boolean z3 = valueMap.getBoolean("trackCategorizedPages", false);
            boolean z4 = valueMap.getBoolean("trackNamedPages", false);
            boolean z5 = valueMap.getBoolean("people", false);
            String string = valueMap.getString("token");
            Set stringSet = MixpanelIntegration.getStringSet(valueMap, "increments");
            boolean z6 = valueMap.getBoolean("setAllTraitsByDefault", true);
            Set stringSet2 = MixpanelIntegration.getStringSet(valueMap, "peopleProperties");
            Set stringSet3 = MixpanelIntegration.getStringSet(valueMap, "superProperties");
            Logger logger = analytics.logger(MixpanelIntegration.MIXPANEL_KEY);
            MixpanelAPI mixpanelAPIM11814a = MixpanelAPI.m11814a(analytics.getApplication(), string);
            logger.verbose("MixpanelAPI.getInstance(context, %s);", string);
            if (z5) {
                peopleM11842c = mixpanelAPIM11814a.m11842c();
            } else {
                peopleM11842c = null;
            }
            return new MixpanelIntegration(mixpanelAPIM11814a, peopleM11842c, z5, z, z2, z3, z4, string, logger, stringSet, z6, stringSet2, stringSet3);
        }

        @Override // com.segment.analytics.integrations.Integration.Factory
        public String key() {
            return MixpanelIntegration.MIXPANEL_KEY;
        }
    };
    private static final Map<String, String> MAPPER;
    private static final String MIXPANEL_KEY = "Mixpanel";
    private static final String VIEWED_EVENT_FORMAT = "Viewed %s Screen";
    private final boolean consolidatedPageCalls;
    final Set<String> increments;
    final boolean isPeopleEnabled;
    private final Logger logger;
    private final MixpanelAPI mixpanel;
    final MixpanelAPI.People mixpanelPeople;
    private final Set<String> peopleProperties;
    final boolean setAllTraitsByDefault;
    private final Set<String> superProperties;
    final String token;
    final boolean trackAllPages;
    final boolean trackCategorizedPages;
    final boolean trackNamedPages;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", "$email");
        linkedHashMap.put("phone", "$phone");
        linkedHashMap.put("firstName", "$first_name");
        linkedHashMap.put("lastName", "$last_name");
        linkedHashMap.put("name", "$name");
        linkedHashMap.put("username", "$username");
        linkedHashMap.put("createdAt", "$created");
        MAPPER = Collections.unmodifiableMap(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> getStringSet(ValueMap valueMap, String str) {
        try {
            List list = (List) valueMap.get(str);
            if (list == null || list.size() == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return hashSet;
                }
                hashSet.add((String) list.get(i2));
                i = i2 + 1;
            }
        } catch (ClassCastException e) {
            return Collections.emptySet();
        }
    }

    public MixpanelIntegration(MixpanelAPI mixpanelAPI, MixpanelAPI.People people, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, Logger logger, Set<String> set, boolean z6, Set<String> set2, Set<String> set3) {
        this.mixpanel = mixpanelAPI;
        this.mixpanelPeople = people;
        this.isPeopleEnabled = z;
        this.consolidatedPageCalls = z2;
        this.trackAllPages = z3;
        this.trackCategorizedPages = z4;
        this.trackNamedPages = z5;
        this.token = str;
        this.logger = logger;
        this.increments = set;
        this.setAllTraitsByDefault = z6;
        this.peopleProperties = set2;
        this.superProperties = set3;
    }

    @Override // com.segment.analytics.integrations.Integration
    public void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
        MixpanelAPI.m11814a(activity, this.token);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.segment.analytics.integrations.Integration
    public MixpanelAPI getUnderlyingInstance() {
        return this.mixpanel;
    }

    private void registerSuperProperties(Map<String, Object> map) {
        if (!Utils.isNullOrEmpty(map)) {
            JSONObject jsonObject = new ValueMap((Map<String, Object>) Utils.transform(map, MAPPER)).toJsonObject();
            this.mixpanel.m11838a(jsonObject);
            this.logger.verbose("mixpanel.registerSuperProperties(%s)", jsonObject);
        }
    }

    private void setPeopleProperties(Map<String, Object> map) {
        if (!Utils.isNullOrEmpty(map) && this.isPeopleEnabled) {
            JSONObject jsonObject = new ValueMap((Map<String, Object>) Utils.transform(map, MAPPER)).toJsonObject();
            this.mixpanelPeople.mo11867a(jsonObject);
            this.logger.verbose("mixpanel.getPeople().set(%s)", jsonObject);
        }
    }

    static <T> Map<String, T> filter(Map<String, T> map, Iterable<String> iterable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : iterable) {
            if (map.containsKey(str)) {
                linkedHashMap.put(str, map.get(str));
            }
        }
        return linkedHashMap;
    }

    @Override // com.segment.analytics.integrations.Integration
    public void identify(IdentifyPayload identifyPayload) {
        super.identify(identifyPayload);
        String strUserId = identifyPayload.userId();
        if (strUserId != null) {
            this.mixpanel.m11834a(strUserId);
            this.logger.verbose("mixpanel.identify(%s)", strUserId);
            if (this.isPeopleEnabled) {
                this.mixpanelPeople.mo11862a(strUserId);
                this.logger.verbose("mixpanel.getPeople().identify(%s)", strUserId);
            }
        }
        Traits traits = identifyPayload.traits();
        if (this.setAllTraitsByDefault) {
            registerSuperProperties(traits);
            setPeopleProperties(traits);
        } else {
            registerSuperProperties(filter(traits, this.superProperties));
            setPeopleProperties(filter(traits, this.peopleProperties));
        }
    }

    @Override // com.segment.analytics.integrations.Integration
    public void flush() {
        super.flush();
        this.mixpanel.m11832a();
        this.logger.verbose("mixpanel.flush()", new Object[0]);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void reset() {
        super.reset();
        this.mixpanel.m11843d();
        this.logger.verbose("mixpanel.reset()", new Object[0]);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void alias(AliasPayload aliasPayload) {
        super.alias(aliasPayload);
        String strPreviousId = aliasPayload.previousId();
        if (strPreviousId.equals(aliasPayload.anonymousId())) {
            strPreviousId = this.mixpanel.m11840b();
        }
        String strUserId = aliasPayload.userId();
        if (strUserId != null) {
            this.mixpanel.m11835a(strUserId, strPreviousId);
            this.logger.verbose("mixpanel.alias(%s, %s)", strUserId, strPreviousId);
        }
    }

    @Override // com.segment.analytics.integrations.Integration
    public void screen(ScreenPayload screenPayload) {
        if (this.consolidatedPageCalls) {
            Properties properties = new Properties();
            properties.putAll(screenPayload.properties());
            properties.put("name", (Object) screenPayload.name());
            event("Loaded a Screen", properties);
            return;
        }
        if (this.trackAllPages) {
            event(String.format(VIEWED_EVENT_FORMAT, screenPayload.event()), screenPayload.properties());
            return;
        }
        if (this.trackCategorizedPages && !Utils.isNullOrEmpty(screenPayload.category())) {
            event(String.format(VIEWED_EVENT_FORMAT, screenPayload.category()), screenPayload.properties());
        } else if (this.trackNamedPages && !Utils.isNullOrEmpty(screenPayload.name())) {
            event(String.format(VIEWED_EVENT_FORMAT, screenPayload.name()), screenPayload.properties());
        }
    }

    @Override // com.segment.analytics.integrations.Integration
    public void track(TrackPayload trackPayload) {
        String strEvent = trackPayload.event();
        event(strEvent, trackPayload.properties());
        if (this.increments.contains(strEvent) && this.isPeopleEnabled) {
            this.mixpanelPeople.mo11863a(strEvent, 1.0d);
            this.mixpanelPeople.mo11865a("Last " + strEvent, new Date());
        }
    }

    void event(String str, Properties properties) {
        JSONObject jsonObject = properties.toJsonObject();
        this.mixpanel.m11836a(str, jsonObject);
        this.logger.verbose("mixpanel.track(%s, %s)", str, jsonObject);
        if (this.isPeopleEnabled) {
            double dRevenue = properties.revenue();
            if (dRevenue != 0.0d) {
                this.mixpanelPeople.mo11860a(dRevenue, jsonObject);
                this.logger.verbose("mixpanelPeople.trackCharge(%s, %s)", Double.valueOf(dRevenue), jsonObject);
            }
        }
    }
}
