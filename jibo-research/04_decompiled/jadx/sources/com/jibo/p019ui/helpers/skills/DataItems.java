package com.jibo.p019ui.helpers.skills;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DataItems {

    @SerializedName(m9428a = "childViews")
    private final List<SkillDataItem> mSkills = new ArrayList();

    public static class DataValue {
    }

    public void addSkill(SkillDataItem skillDataItem) {
        this.mSkills.add(skillDataItem);
    }

    public void addSkills(List<SkillDataItem> list) {
        this.mSkills.addAll(list);
    }

    public List<SkillDataItem> getSkills() {
        return this.mSkills;
    }

    public static class DataItem {
        private int index;
        private boolean owner;
        private String subtitle;
        private String title;
        private String type;
        private ValueDefinition valueDefinition;

        public DataItem(String str) {
            this.type = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setSubtitle(String str) {
            this.subtitle = str;
        }

        public String getTitle() {
            return this.title;
        }

        public String getSubtitle() {
            return this.subtitle;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public int getIndex() {
            return this.index;
        }

        public boolean isOwner() {
            return this.owner;
        }

        public ValueDefinition getValueDefinition() {
            return this.valueDefinition;
        }

        public DataValue getDataValue() {
            if (this.valueDefinition != null) {
                return this.valueDefinition.getDataValue();
            }
            return null;
        }
    }

    public static class GroupDataItem extends DataItem {
        private List<DataItem> childViews;

        public GroupDataItem(String str) {
            super(str);
        }

        public List<DataItem> getChildViews() {
            return this.childViews;
        }
    }

    public static class ValueDefinition {
        private DataValue dataValue;
        private String key;
        private boolean required;
        private String target;

        public String getKey() {
            return this.key;
        }

        public void setDataValue(DataValue dataValue) {
            this.dataValue = dataValue;
        }

        public DataValue getDataValue() {
            return this.dataValue;
        }

        public String getTarget() {
            return this.target;
        }

        public boolean isRequired() {
            return this.required;
        }
    }

    public static class SkillDataItem {
        private JsonObject data;
        private String skillId;
        private SkillViewDataItem view;

        public String getSkillId() {
            return this.skillId;
        }

        public JsonObject getData() {
            return this.data;
        }

        public SkillViewDataItem getView() {
            return this.view;
        }
    }

    public static class SkillViewDataItem extends GroupDataItem {
        private String icon;

        public SkillViewDataItem(String str) {
            super(str);
        }

        public String getIcon() {
            return this.icon;
        }
    }

    public static class SubheaderDataItem extends DataItem {
        public SubheaderDataItem(String str) {
            super(str);
        }
    }

    public static class FooterDataItem extends DataItem {
        private List<Link> links;

        public FooterDataItem(String str) {
            super(str);
        }

        public List<Link> getLinks() {
            return this.links;
        }

        public static class Link {
            private String placeholder;
            private String text;
            private String url;

            public String getPlaceholder() {
                return this.placeholder;
            }

            public String getText() {
                return this.text;
            }

            public String getUrl() {
                return this.url;
            }
        }
    }

    public static class SwitchDataItem extends GroupDataItem {
        public SwitchDataItem(String str) {
            super(str);
        }
    }

    public static class LocationDataItem extends GroupDataItem {
        public LocationDataItem(String str) {
            super(str);
        }
    }

    public static class ChoiceDataItem extends DataItem {
        private List<ChoiceValueDataItem> choices;

        public ChoiceDataItem(String str) {
            super(str);
        }

        public List<ChoiceValueDataItem> getChoices() {
            return this.choices;
        }

        public static class ChoiceValueDataItem {
            private String icon;

            /* JADX INFO: renamed from: id */
            private int f11509id;
            private String value;

            public int getId() {
                return this.f11509id;
            }

            public String getValue() {
                return this.value;
            }

            public String getIcon() {
                return this.icon;
            }
        }
    }

    public static class ConnectableDataItem extends GroupDataItem {
        public ConnectableDataItem(String str) {
            super(str);
        }
    }

    public static class OauthDataItem extends DataItem {
        private String icon;
        private OauthDataValue.OauthValue oauthParams;

        public OauthDataItem(String str) {
            super(str);
        }

        public String getIcon() {
            return this.icon;
        }

        public OauthDataValue.OauthValue getOauthParams() {
            return this.oauthParams;
        }
    }

    public static class TimeDataItem extends DataItem {
        public TimeDataItem(String str) {
            super(str);
        }
    }

    public static class ToggleDataItem extends DataItem {
        public ToggleDataItem(String str) {
            super(str);
        }
    }

    public static class BooleanDataValue extends DataValue {
        private boolean value;

        public boolean getValue() {
            return this.value;
        }

        public void setValue(boolean z) {
            this.value = z;
        }
    }

    public static class IntegerDataValue extends DataValue {
        private int value;

        public int getValue() {
            return this.value;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    public static class StringDataValue extends DataValue {
        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class LocationDataValue extends DataValue {
        private String city;
        private String country;
        private Double lat;
        private Double lng;
        private String route;
        private String state;
        private String street_number;
        private String timezone;

        public LocationDataValue(Double d, Double d2, String str, String str2, String str3, String str4, String str5, String str6) {
            this.lat = d;
            this.lng = d2;
            this.city = str;
            this.state = str2;
            this.country = str3;
            this.timezone = str4;
            this.route = str5;
            this.street_number = str6;
        }

        public String getFriendlyLocation() {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.route)) {
                if (!TextUtils.isEmpty(this.street_number)) {
                    arrayList.add(this.street_number + " " + this.route);
                } else {
                    arrayList.add(this.route);
                }
            }
            if (!TextUtils.isEmpty(this.city)) {
                arrayList.add(this.city);
            }
            if (!TextUtils.isEmpty(this.state)) {
                arrayList.add(this.state);
            }
            if (!TextUtils.isEmpty(this.country)) {
                arrayList.add(this.country);
            }
            return TextUtils.join(", ", arrayList);
        }

        public String getFriendlyTimezone() {
            TimeZone timeZone = TextUtils.isEmpty(this.timezone) ? null : TimeZone.getTimeZone(this.timezone.replace("\\/", "/"));
            StringBuilder sb = new StringBuilder();
            if (timeZone != null) {
                sb.append(timeZone.getDisplayName()).append(" (GMT ").append(DateTimeUtils.getHourOffset(timeZone.getRawOffset())).append(")");
            }
            return sb.toString();
        }

        public Double getLat() {
            if (this.lat != null) {
                return this.lat;
            }
            return null;
        }

        public Double getLon() {
            if (this.lng != null) {
                return this.lng;
            }
            return null;
        }

        public String getCity() {
            return this.city != null ? this.city : "";
        }

        public String getState() {
            return this.state != null ? this.state : "";
        }

        public String getCountry() {
            return this.country != null ? this.country : "";
        }

        public String getTimezone() {
            return this.timezone != null ? this.timezone : "";
        }

        public String getRoute() {
            return this.route != null ? this.route : "";
        }

        public String getStreetNumber() {
            return this.street_number != null ? this.street_number : "";
        }
    }

    public static class TimeDataValue extends DataValue {
        private int hour;
        private int min;

        public TimeDataValue(int i, int i2) {
            this.hour = i;
            this.min = i2;
        }

        public void setTime(int i, int i2) {
            this.hour = i;
            this.min = i2;
        }

        public int getHour() {
            return this.hour;
        }

        public int getMin() {
            return this.min;
        }

        public void setHour(int i) {
            this.hour = i;
        }

        public void setMin(int i) {
            this.min = i;
        }
    }

    public static class ConnectableDataValue extends DataValue {
        private Boolean value;

        public boolean isConnected() {
            if (this.value != null) {
                return this.value.booleanValue();
            }
            return false;
        }

        public void setValue(Boolean bool) {
            this.value = bool;
        }

        public void setConnected(boolean z) {
            this.value = Boolean.valueOf(z);
        }
    }

    public static class OauthDataValue extends DataValue {
        private OauthValue value;

        public OauthDataValue(OauthValue oauthValue) {
            this.value = oauthValue;
        }

        public void setValue(OauthValue oauthValue) {
            this.value = oauthValue;
        }

        public String getIcon() {
            return this.value != null ? this.value.icon : "";
        }

        public String getTitle() {
            return this.value != null ? this.value.title : "";
        }

        public String getServiceName() {
            return this.value != null ? this.value.title : "";
        }

        public String getServiceAccountName() {
            return this.value != null ? this.value.title : "";
        }

        public String getAuthorizationUri() {
            return this.value != null ? this.value.authorizationUri : "";
        }

        public String getIosCallbackUri() {
            return this.value != null ? this.value.iosCallbackUri : "";
        }

        public String getIosClientId() {
            return this.value != null ? this.value.iosClientId : "";
        }

        public String[] getScopes() {
            return this.value != null ? this.value.scopes : new String[0];
        }

        public String getAuthCode() {
            return this.value != null ? this.value.getAuthCode() : "";
        }

        public String getServerClientId() {
            return this.value != null ? this.value.getServerClientId() : "";
        }

        public static class OauthValue extends DataValue {
            private String authCode;
            private String authorizationUri;
            private String clientId;
            private String icon;
            private String iosCallbackUri;
            private String iosClientId;
            private String[] scopes;
            private String serverClientId;
            private String serviceAccountName;
            private String serviceName;
            private String title;

            public OauthValue(String str, String str2, String str3, String str4, String[] strArr) {
                this.serviceAccountName = str;
                this.serviceName = str2;
                this.authCode = str3;
                this.scopes = strArr;
                this.clientId = str4;
            }

            public OauthValue(String str, String str2, String[] strArr) {
                this.serviceAccountName = str;
                this.serviceName = str2;
                this.scopes = strArr;
            }

            public String getIcon() {
                return this.icon;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public String getTitle() {
                return this.title;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public String getServiceName() {
                return this.serviceName;
            }

            public void setServiceName(String str) {
                this.serviceName = str;
            }

            public String getServiceAccountName() {
                return this.serviceAccountName;
            }

            public void setServiceAccountName(String str) {
                this.serviceAccountName = str;
            }

            public String getAuthorizationUri() {
                return this.authorizationUri;
            }

            public void setAuthorizationUri(String str) {
                this.authorizationUri = str;
            }

            public String getIosCallbackUri() {
                return this.iosCallbackUri;
            }

            public void setIosCallbackUri(String str) {
                this.iosCallbackUri = str;
            }

            public String getIosClientId() {
                return this.iosClientId;
            }

            public void setIosClientId(String str) {
                this.iosClientId = str;
            }

            public String[] getScopes() {
                return this.scopes;
            }

            public void setScopes(String[] strArr) {
                this.scopes = strArr;
            }

            public String getAuthCode() {
                return this.authCode;
            }

            public void setAuthCode(String str) {
                this.authCode = str;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String str) {
                this.clientId = str;
            }

            public String getServerClientId() {
                return this.serverClientId;
            }

            public void setServerClientId(String str) {
                this.serverClientId = str;
            }
        }
    }
}
