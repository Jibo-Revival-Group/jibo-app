package com.jibo.ui.helpers.skills;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DataItems {
   @SerializedName(a = "childViews")
   private final List<DataItems.SkillDataItem> mSkills = new ArrayList<>();

   public void addSkill(DataItems.SkillDataItem var1) {
      this.mSkills.add(var1);
   }

   public void addSkills(List<DataItems.SkillDataItem> var1) {
      this.mSkills.addAll(var1);
   }

   public List<DataItems.SkillDataItem> getSkills() {
      return this.mSkills;
   }

   public static class BooleanDataValue extends DataItems.DataValue {
      private boolean value;

      public boolean getValue() {
         return this.value;
      }

      public void setValue(boolean var1) {
         this.value = var1;
      }
   }

   public static class ChoiceDataItem extends DataItems.DataItem {
      private List<DataItems.ChoiceDataItem.ChoiceValueDataItem> choices;

      public ChoiceDataItem(String var1) {
         super(var1);
      }

      public List<DataItems.ChoiceDataItem.ChoiceValueDataItem> getChoices() {
         return this.choices;
      }

      public static class ChoiceValueDataItem {
         private String icon;
         private int id;
         private String value;

         public String getIcon() {
            return this.icon;
         }

         public int getId() {
            return this.id;
         }

         public String getValue() {
            return this.value;
         }
      }
   }

   public static class ConnectableDataItem extends DataItems.GroupDataItem {
      public ConnectableDataItem(String var1) {
         super(var1);
      }
   }

   public static class ConnectableDataValue extends DataItems.DataValue {
      private Boolean value;

      public boolean isConnected() {
         boolean var1;
         if (this.value != null) {
            var1 = this.value;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void setConnected(boolean var1) {
         this.value = var1;
      }

      public void setValue(Boolean var1) {
         this.value = var1;
      }
   }

   public static class DataItem {
      private int index;
      private boolean owner;
      private String subtitle;
      private String title;
      private String type;
      private DataItems.ValueDefinition valueDefinition;

      public DataItem(String var1) {
         this.type = var1;
      }

      public DataItems.DataValue getDataValue() {
         DataItems.DataValue var1;
         if (this.valueDefinition != null) {
            var1 = this.valueDefinition.getDataValue();
         } else {
            var1 = null;
         }

         return var1;
      }

      public int getIndex() {
         return this.index;
      }

      public String getSubtitle() {
         return this.subtitle;
      }

      public String getTitle() {
         return this.title;
      }

      public String getType() {
         return this.type;
      }

      public DataItems.ValueDefinition getValueDefinition() {
         return this.valueDefinition;
      }

      public boolean isOwner() {
         return this.owner;
      }

      public void setSubtitle(String var1) {
         this.subtitle = var1;
      }

      public void setTitle(String var1) {
         this.title = var1;
      }

      public void setType(String var1) {
         this.type = var1;
      }
   }

   public static class DataValue {
   }

   public static class FooterDataItem extends DataItems.DataItem {
      private List<DataItems.FooterDataItem.Link> links;

      public FooterDataItem(String var1) {
         super(var1);
      }

      public List<DataItems.FooterDataItem.Link> getLinks() {
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

   public static class GroupDataItem extends DataItems.DataItem {
      private List<DataItems.DataItem> childViews;

      public GroupDataItem(String var1) {
         super(var1);
      }

      public List<DataItems.DataItem> getChildViews() {
         return this.childViews;
      }
   }

   public static class IntegerDataValue extends DataItems.DataValue {
      private int value;

      public int getValue() {
         return this.value;
      }

      public void setValue(int var1) {
         this.value = var1;
      }
   }

   public static class LocationDataItem extends DataItems.GroupDataItem {
      public LocationDataItem(String var1) {
         super(var1);
      }
   }

   public static class LocationDataValue extends DataItems.DataValue {
      private String city;
      private String country;
      private Double lat;
      private Double lng;
      private String route;
      private String state;
      private String street_number;
      private String timezone;

      public LocationDataValue(Double var1, Double var2, String var3, String var4, String var5, String var6, String var7, String var8) {
         this.lat = var1;
         this.lng = var2;
         this.city = var3;
         this.state = var4;
         this.country = var5;
         this.timezone = var6;
         this.route = var7;
         this.street_number = var8;
      }

      public String getCity() {
         String var1;
         if (this.city != null) {
            var1 = this.city;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getCountry() {
         String var1;
         if (this.country != null) {
            var1 = this.country;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getFriendlyLocation() {
         ArrayList var1 = new ArrayList();
         if (!TextUtils.isEmpty(this.route)) {
            if (!TextUtils.isEmpty(this.street_number)) {
               var1.add(this.street_number + " " + this.route);
            } else {
               var1.add(this.route);
            }
         }

         if (!TextUtils.isEmpty(this.city)) {
            var1.add(this.city);
         }

         if (!TextUtils.isEmpty(this.state)) {
            var1.add(this.state);
         }

         if (!TextUtils.isEmpty(this.country)) {
            var1.add(this.country);
         }

         return TextUtils.join(", ", var1);
      }

      public String getFriendlyTimezone() {
         TimeZone var1;
         if (TextUtils.isEmpty(this.timezone)) {
            var1 = null;
         } else {
            var1 = TimeZone.getTimeZone(this.timezone.replace("\\/", "/"));
         }

         StringBuilder var2 = new StringBuilder();
         if (var1 != null) {
            var2.append(var1.getDisplayName()).append(" (GMT ").append(DateTimeUtils.getHourOffset(var1.getRawOffset())).append(")");
         }

         return var2.toString();
      }

      public Double getLat() {
         Double var1;
         if (this.lat != null) {
            var1 = this.lat;
         } else {
            var1 = null;
         }

         return var1;
      }

      public Double getLon() {
         Double var1;
         if (this.lng != null) {
            var1 = this.lng;
         } else {
            var1 = null;
         }

         return var1;
      }

      public String getRoute() {
         String var1;
         if (this.route != null) {
            var1 = this.route;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getState() {
         String var1;
         if (this.state != null) {
            var1 = this.state;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getStreetNumber() {
         String var1;
         if (this.street_number != null) {
            var1 = this.street_number;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getTimezone() {
         String var1;
         if (this.timezone != null) {
            var1 = this.timezone;
         } else {
            var1 = "";
         }

         return var1;
      }
   }

   public static class OauthDataItem extends DataItems.DataItem {
      private String icon;
      private DataItems.OauthDataValue.OauthValue oauthParams;

      public OauthDataItem(String var1) {
         super(var1);
      }

      public String getIcon() {
         return this.icon;
      }

      public DataItems.OauthDataValue.OauthValue getOauthParams() {
         return this.oauthParams;
      }
   }

   public static class OauthDataValue extends DataItems.DataValue {
      private DataItems.OauthDataValue.OauthValue value;

      public OauthDataValue(DataItems.OauthDataValue.OauthValue var1) {
         this.value = var1;
      }

      public String getAuthCode() {
         String var1;
         if (this.value != null) {
            var1 = this.value.getAuthCode();
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getAuthorizationUri() {
         String var1;
         if (this.value != null) {
            var1 = this.value.authorizationUri;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getIcon() {
         String var1;
         if (this.value != null) {
            var1 = this.value.icon;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getIosCallbackUri() {
         String var1;
         if (this.value != null) {
            var1 = this.value.iosCallbackUri;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getIosClientId() {
         String var1;
         if (this.value != null) {
            var1 = this.value.iosClientId;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String[] getScopes() {
         String[] var1;
         if (this.value != null) {
            var1 = this.value.scopes;
         } else {
            var1 = new String[0];
         }

         return var1;
      }

      public String getServerClientId() {
         String var1;
         if (this.value != null) {
            var1 = this.value.getServerClientId();
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getServiceAccountName() {
         String var1;
         if (this.value != null) {
            var1 = this.value.title;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getServiceName() {
         String var1;
         if (this.value != null) {
            var1 = this.value.title;
         } else {
            var1 = "";
         }

         return var1;
      }

      public String getTitle() {
         String var1;
         if (this.value != null) {
            var1 = this.value.title;
         } else {
            var1 = "";
         }

         return var1;
      }

      public void setValue(DataItems.OauthDataValue.OauthValue var1) {
         this.value = var1;
      }

      public static class OauthValue extends DataItems.DataValue {
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

         public OauthValue(String var1, String var2, String var3, String var4, String[] var5) {
            this.serviceAccountName = var1;
            this.serviceName = var2;
            this.authCode = var3;
            this.scopes = var5;
            this.clientId = var4;
         }

         public OauthValue(String var1, String var2, String[] var3) {
            this.serviceAccountName = var1;
            this.serviceName = var2;
            this.scopes = var3;
         }

         public String getAuthCode() {
            return this.authCode;
         }

         public String getAuthorizationUri() {
            return this.authorizationUri;
         }

         public String getClientId() {
            return this.clientId;
         }

         public String getIcon() {
            return this.icon;
         }

         public String getIosCallbackUri() {
            return this.iosCallbackUri;
         }

         public String getIosClientId() {
            return this.iosClientId;
         }

         public String[] getScopes() {
            return this.scopes;
         }

         public String getServerClientId() {
            return this.serverClientId;
         }

         public String getServiceAccountName() {
            return this.serviceAccountName;
         }

         public String getServiceName() {
            return this.serviceName;
         }

         public String getTitle() {
            return this.title;
         }

         public void setAuthCode(String var1) {
            this.authCode = var1;
         }

         public void setAuthorizationUri(String var1) {
            this.authorizationUri = var1;
         }

         public void setClientId(String var1) {
            this.clientId = var1;
         }

         public void setIcon(String var1) {
            this.icon = var1;
         }

         public void setIosCallbackUri(String var1) {
            this.iosCallbackUri = var1;
         }

         public void setIosClientId(String var1) {
            this.iosClientId = var1;
         }

         public void setScopes(String[] var1) {
            this.scopes = var1;
         }

         public void setServerClientId(String var1) {
            this.serverClientId = var1;
         }

         public void setServiceAccountName(String var1) {
            this.serviceAccountName = var1;
         }

         public void setServiceName(String var1) {
            this.serviceName = var1;
         }

         public void setTitle(String var1) {
            this.title = var1;
         }
      }
   }

   public static class SkillDataItem {
      private JsonObject data;
      private String skillId;
      private DataItems.SkillViewDataItem view;

      public JsonObject getData() {
         return this.data;
      }

      public String getSkillId() {
         return this.skillId;
      }

      public DataItems.SkillViewDataItem getView() {
         return this.view;
      }
   }

   public static class SkillViewDataItem extends DataItems.GroupDataItem {
      private String icon;

      public SkillViewDataItem(String var1) {
         super(var1);
      }

      public String getIcon() {
         return this.icon;
      }
   }

   public static class StringDataValue extends DataItems.DataValue {
      private String value;

      public String getValue() {
         return this.value;
      }

      public void setValue(String var1) {
         this.value = var1;
      }
   }

   public static class SubheaderDataItem extends DataItems.DataItem {
      public SubheaderDataItem(String var1) {
         super(var1);
      }
   }

   public static class SwitchDataItem extends DataItems.GroupDataItem {
      public SwitchDataItem(String var1) {
         super(var1);
      }
   }

   public static class TimeDataItem extends DataItems.DataItem {
      public TimeDataItem(String var1) {
         super(var1);
      }
   }

   public static class TimeDataValue extends DataItems.DataValue {
      private int hour;
      private int min;

      public TimeDataValue(int var1, int var2) {
         this.hour = var1;
         this.min = var2;
      }

      public int getHour() {
         return this.hour;
      }

      public int getMin() {
         return this.min;
      }

      public void setHour(int var1) {
         this.hour = var1;
      }

      public void setMin(int var1) {
         this.min = var1;
      }

      public void setTime(int var1, int var2) {
         this.hour = var1;
         this.min = var2;
      }
   }

   public static class ToggleDataItem extends DataItems.DataItem {
      public ToggleDataItem(String var1) {
         super(var1);
      }
   }

   public static class ValueDefinition {
      private DataItems.DataValue dataValue;
      private String key;
      private boolean required;
      private String target;

      public DataItems.DataValue getDataValue() {
         return this.dataValue;
      }

      public String getKey() {
         return this.key;
      }

      public String getTarget() {
         return this.target;
      }

      public boolean isRequired() {
         return this.required;
      }

      public void setDataValue(DataItems.DataValue var1) {
         this.dataValue = var1;
      }
   }
}
