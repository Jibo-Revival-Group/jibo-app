package com.jibo.p019ui.helpers.skills;

import com.crashlytics.android.Crashlytics;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.jibo.R;
import com.jibo.p019ui.fragment.settings.RobotSettingsFragment;
import com.jibo.p019ui.helpers.skills.DataItems;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes.dex */
public class SkillsJsonParser {
    public static final String TYPE_CHOICE = "choice";
    public static final String TYPE_CONNECTABLE = "connectable";
    public static final String TYPE_FOOTER = "footer";
    public static final String TYPE_LOCATION = "location";
    public static final String TYPE_LOCATION_TEXTFIELD = "locationTextField";
    public static final String TYPE_OAUTH = "oauth";
    public static final String TYPE_SKILL = "skill";
    public static final String TYPE_SUBHEADER = "subheader";
    public static final String TYPE_SWITCH = "switch";
    public static final String TYPE_TIME = "time";
    public static final String TYPE_TOGGLE = "toggle";
    private static Gson gson;
    private static HashMap<String, Class> mDataValueClassesMap;
    private static HashMap<String, Class> mSimpleTypeClassesMap;
    private static HashMap<String, Class> sComplexTypesClassesMap = new HashMap<>();
    private static SkillsJsonParser sInstance;
    private int mCurrentSkillIndx = 0;
    private DataItems mDataItems;

    static {
        sComplexTypesClassesMap.put(TYPE_SWITCH, DataItems.SwitchDataItem.class);
        sComplexTypesClassesMap.put(TYPE_LOCATION_TEXTFIELD, DataItems.LocationDataItem.class);
        sComplexTypesClassesMap.put(TYPE_CONNECTABLE, DataItems.ConnectableDataItem.class);
        mSimpleTypeClassesMap = new HashMap<>();
        mSimpleTypeClassesMap.put(TYPE_SKILL, DataItems.SkillDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_SUBHEADER, DataItems.SubheaderDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_FOOTER, DataItems.FooterDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_LOCATION, DataItems.LocationDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_CHOICE, DataItems.ChoiceDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_OAUTH, DataItems.OauthDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_TOGGLE, DataItems.ToggleDataItem.class);
        mSimpleTypeClassesMap.put(TYPE_TIME, DataItems.TimeDataItem.class);
        mDataValueClassesMap = new HashMap<>();
        mDataValueClassesMap.put(TYPE_SWITCH, DataItems.BooleanDataValue.class);
        mDataValueClassesMap.put(TYPE_LOCATION_TEXTFIELD, DataItems.LocationDataValue.class);
        mDataValueClassesMap.put(TYPE_LOCATION, DataItems.LocationDataValue.class);
        mDataValueClassesMap.put(TYPE_CHOICE, DataItems.IntegerDataValue.class);
        mDataValueClassesMap.put(TYPE_CONNECTABLE, DataItems.ConnectableDataValue.class);
        mDataValueClassesMap.put(TYPE_OAUTH, DataItems.OauthDataValue.class);
        mDataValueClassesMap.put(TYPE_TOGGLE, DataItems.BooleanDataValue.class);
        mDataValueClassesMap.put(TYPE_TIME, DataItems.TimeDataValue.class);
        gson = new GsonBuilder().m9380a((Type) DataItems.DataItem.class, (Object) new DataDeserializer()).m9380a((Type) DataItems.BooleanDataValue.class, (Object) new BooleanDataValueDeserializer()).m9376a();
    }

    public static synchronized boolean isCreated() {
        return sInstance != null;
    }

    public static synchronized SkillsJsonParser getInstance() {
        SkillsJsonParser skillsJsonParser;
        skillsJsonParser = sInstance;
        if (skillsJsonParser == null) {
            synchronized (SkillsJsonParser.class) {
                skillsJsonParser = sInstance;
                if (skillsJsonParser == null) {
                    skillsJsonParser = new SkillsJsonParser();
                    sInstance = skillsJsonParser;
                }
            }
        }
        return skillsJsonParser;
    }

    private void setItemDataValue(DataItems.DataItem dataItem, Class cls) {
        if (cls != null) {
            dataItem.getValueDefinition().setDataValue((DataItems.DataValue) gson.m9350a((JsonElement) getSkills().get(this.mCurrentSkillIndx).getData().m9409e(dataItem.getValueDefinition().getKey()), cls));
        }
    }

    public SkillsJsonParser parseSkills(String str) {
        try {
            this.mDataItems = new DataItems();
            if (new JsonParser().m9413a(str).m9391h()) {
                List<DataItems.SkillDataItem> list = (List) gson.m9356a(str, new TypeToken<List<DataItems.SkillDataItem>>() { // from class: com.jibo.ui.helpers.skills.SkillsJsonParser.1
                }.getType());
                Collections.sort(list, new Comparator<DataItems.SkillDataItem>() { // from class: com.jibo.ui.helpers.skills.SkillsJsonParser.2
                    @Override // java.util.Comparator
                    public int compare(DataItems.SkillDataItem skillDataItem, DataItems.SkillDataItem skillDataItem2) {
                        return skillDataItem.getView().getIndex() - skillDataItem2.getView().getIndex();
                    }
                });
                this.mDataItems.addSkills(list);
            } else {
                this.mDataItems.addSkill((DataItems.SkillDataItem) gson.m9355a(str, DataItems.SkillDataItem.class));
            }
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
        return this;
    }

    public void clearSkills() {
        this.mDataItems = null;
        this.mDataItems = new DataItems();
    }

    public List<DataItems.SkillDataItem> getSkills() {
        if (this.mDataItems != null) {
            return this.mDataItems.getSkills();
        }
        return null;
    }

    public List<DataItems.DataItem> getViews(int[] iArr) {
        List<DataItems.DataItem> arrayList = null;
        if (this.mDataItems != null && this.mDataItems.getSkills() != null && !this.mDataItems.getSkills().isEmpty()) {
            if (iArr == null || iArr.length == 0) {
                arrayList = new ArrayList<>();
                Iterator<DataItems.SkillDataItem> it = this.mDataItems.getSkills().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getView());
                }
            } else if (this.mDataItems.getSkills().size() > iArr[0]) {
                this.mDataItems.getSkills().get(iArr[0]);
                DataItems.DataItem view = this.mDataItems.getSkills().get(iArr[0]).getView();
                if (((DataItems.SkillViewDataItem) view).getChildViews() != null) {
                    int i = 1;
                    while (i < iArr.length && (view instanceof DataItems.GroupDataItem) && ((DataItems.GroupDataItem) view).getChildViews() != null && ((DataItems.GroupDataItem) view).getChildViews().size() > iArr[i]) {
                        DataItems.DataItem dataItem = ((DataItems.GroupDataItem) view).getChildViews().get(iArr[i]);
                        i++;
                        view = dataItem;
                    }
                    arrayList = view instanceof DataItems.GroupDataItem ? ((DataItems.GroupDataItem) view).getChildViews() : null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    Collections.sort(arrayList, new Comparator<DataItems.DataItem>() { // from class: com.jibo.ui.helpers.skills.SkillsJsonParser.3
                        @Override // java.util.Comparator
                        public int compare(DataItems.DataItem dataItem2, DataItems.DataItem dataItem3) {
                            return dataItem2.getIndex() - dataItem3.getIndex();
                        }
                    });
                    for (DataItems.DataItem dataItem2 : arrayList) {
                        setItemDataValue(dataItem2, mDataValueClassesMap.get(dataItem2.getType()));
                    }
                }
            }
        }
        return arrayList;
    }

    public void setItemDataValue(DataItems.DataItem dataItem) {
        setItemDataValue(dataItem, mDataValueClassesMap.get(dataItem.getType()));
    }

    public DataItems.DataItem getView(int[] iArr) {
        if (this.mDataItems == null || this.mDataItems.getSkills() == null || this.mDataItems.getSkills().isEmpty()) {
            return null;
        }
        if (iArr == null || iArr.length == 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<DataItems.SkillDataItem> it = this.mDataItems.getSkills().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getView());
            }
            return null;
        }
        if (this.mDataItems.getSkills().size() <= iArr[0]) {
            return null;
        }
        DataItems.DataItem view = this.mDataItems.getSkills().get(iArr[0]).getView();
        if (((DataItems.SkillViewDataItem) view).getChildViews() == null) {
            view = null;
        } else {
            int i = 1;
            while (i < iArr.length && (view instanceof DataItems.GroupDataItem) && ((DataItems.GroupDataItem) view).getChildViews() != null && ((DataItems.GroupDataItem) view).getChildViews().size() > iArr[i]) {
                DataItems.DataItem dataItem = ((DataItems.GroupDataItem) view).getChildViews().get(iArr[i]);
                i++;
                view = dataItem;
            }
        }
        return view;
    }

    public void selectSkill(int i) {
        this.mCurrentSkillIndx = i;
    }

    public void updateData(String str, DataItems.DataValue dataValue) {
        getSkills().get(this.mCurrentSkillIndx).getData().m9402a(str, gson.m9343a(dataValue));
    }

    public void updateData(String str, JsonElement jsonElement) {
        getSkills().get(this.mCurrentSkillIndx).getData().m9402a(str, jsonElement);
    }

    public DataItems.SkillDataItem getCurrentSkill() {
        return getSkills().get(this.mCurrentSkillIndx);
    }

    public boolean isConfigured() {
        try {
            JsonObject data = getSkills().get(0).getData();
            Set<Map.Entry<String, JsonElement>> setM9401a = data.m9401a();
            if (data.m9410p() <= 7) {
                if (!isConfigured(setM9401a)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private boolean isConfigured(Set<Map.Entry<String, JsonElement>> set) {
        boolean zIsConfigured = false;
        Iterator<Map.Entry<String, JsonElement>> it = set.iterator();
        while (true) {
            boolean z = zIsConfigured;
            if (it.hasNext()) {
                Map.Entry<String, JsonElement> next = it.next();
                zIsConfigured = !next.getKey().equals("offerProactively") ? isConfigured(next.getValue()) | z : z;
            } else {
                return z;
            }
        }
    }

    private boolean isConfigured(JsonElement jsonElement) {
        if (jsonElement.m9392i()) {
            return isConfigured(jsonElement.m9395l().m9401a());
        }
        if (jsonElement.m9393j() && ((JsonPrimitive) jsonElement).m9417a()) {
            return jsonElement.mo9389g();
        }
        return true;
    }

    static class DataDeserializer<T> implements JsonDeserializer<T> {
        DataDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonElement jsonElementM9407c = jsonElement.m9395l().m9407c("childViews");
            if (jsonElementM9407c != null && !jsonElementM9407c.m9391h()) {
                jsonElement.m9395l().m9400a("childViews");
                JsonArray jsonArray = new JsonArray();
                jsonArray.m9383a(jsonElementM9407c);
                jsonElement.m9395l().m9402a("childViews", jsonArray);
            }
            Type type2 = SkillsJsonParser.mSimpleTypeClassesMap.containsKey(jsonElement.m9395l().m9407c(ShareConstants.MEDIA_TYPE).mo9385c()) ? (Type) SkillsJsonParser.mSimpleTypeClassesMap.get(jsonElement.m9395l().m9407c(ShareConstants.MEDIA_TYPE).mo9385c()) : type;
            if (SkillsJsonParser.sComplexTypesClassesMap.containsKey(jsonElement.m9395l().m9407c(ShareConstants.MEDIA_TYPE).mo9385c())) {
                return (T) SkillsJsonParser.gson.m9350a((JsonElement) jsonElement.m9395l(), (Class) SkillsJsonParser.sComplexTypesClassesMap.get(jsonElement.m9395l().m9407c(ShareConstants.MEDIA_TYPE).mo9385c()));
            }
            return (T) new Gson().m9351a((JsonElement) jsonElement.m9395l(), type2);
        }
    }

    static class BooleanDataValueDeserializer implements JsonDeserializer<DataItems.BooleanDataValue> {
        BooleanDataValueDeserializer() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public DataItems.BooleanDataValue deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            Boolean boolValueOf;
            DataItems.BooleanDataValue booleanDataValue = new DataItems.BooleanDataValue();
            JsonElement jsonElementM9407c = jsonElement.m9395l().m9407c("value");
            JsonPrimitive jsonPrimitiveM9397n = jsonElementM9407c.m9397n();
            if (jsonPrimitiveM9397n.m9417a()) {
                boolValueOf = Boolean.valueOf(jsonElementM9407c.mo9389g());
            } else if (jsonPrimitiveM9397n.m9418p()) {
                boolValueOf = Boolean.valueOf(jsonElementM9407c.mo9388f() != 0);
            } else {
                boolValueOf = false;
            }
            booleanDataValue.setValue(boolValueOf.booleanValue());
            return booleanDataValue;
        }
    }

    public static class ImageUrlMatcher {
        private static HashMap<String, Integer> sIconsHashMap = new HashMap<>();

        static {
            sIconsHashMap.put("ic_bike", Integer.valueOf(R.drawable.ic_bike));
            sIconsHashMap.put("ic_drive", Integer.valueOf(R.drawable.ic_drive));
            sIconsHashMap.put("ic_transport", Integer.valueOf(R.drawable.ic_transport));
            sIconsHashMap.put("ic_walk", Integer.valueOf(R.drawable.ic_walk));
            sIconsHashMap.put("personal_report_icon", Integer.valueOf(R.drawable.ic_account_pr));
        }

        public static int getImageForUrl(String str) {
            if (sIconsHashMap.containsKey(str)) {
                return sIconsHashMap.get(str).intValue();
            }
            return -1;
        }

        public static boolean isExternal(String str) {
            return str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
        }
    }

    public static class TextLinksMatcher {
        private static HashMap<String, Class> sFragmentHashMap = new HashMap<>();

        static {
            sFragmentHashMap.put("JIBO_SETTINGS", RobotSettingsFragment.class);
        }

        public static Class getClassForPlaceholder(String str) {
            if (sFragmentHashMap.containsKey(str)) {
                return sFragmentHashMap.get(str);
            }
            return null;
        }
    }
}
