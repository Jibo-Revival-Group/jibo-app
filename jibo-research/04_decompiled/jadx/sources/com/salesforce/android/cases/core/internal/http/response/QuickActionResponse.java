package com.salesforce.android.cases.core.internal.http.response;

import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QuickActionResponse {

    @SerializedName(m9428a = "label")
    private String label;

    @SerializedName(m9428a = "layoutItems")
    private List<List<LayoutItem>> layoutItems;

    @SerializedName(m9428a = "name")
    private String name;

    @SerializedName(m9428a = "targetParentField")
    private String targetParentField;

    @SerializedName(m9428a = "targetRecordTypeId")
    private String targetRecordTypeId;

    @SerializedName(m9428a = "targetSobjectType")
    private String targetSobjectType;

    @SerializedName(m9428a = ShareConstants.MEDIA_TYPE)
    private String type;

    /* JADX INFO: renamed from: a */
    public String m12346a() {
        return this.label;
    }

    /* JADX INFO: renamed from: b */
    public List<List<LayoutItem>> m12347b() {
        return this.layoutItems == null ? Collections.emptyList() : Collections.unmodifiableList(this.layoutItems);
    }

    /* JADX INFO: renamed from: c */
    public String m12348c() {
        return this.name;
    }

    public class LayoutItem {

        @SerializedName(m9428a = GraphRequest.FIELDS_PARAM)
        private List<Field> fields;

        @SerializedName(m9428a = "label")
        private String label;

        @SerializedName(m9428a = "readOnly")
        private boolean readOnly;

        @SerializedName(m9428a = "required")
        private boolean required;

        /* JADX INFO: renamed from: a */
        public List<Field> m12355a() {
            return this.fields == null ? Collections.emptyList() : Collections.unmodifiableList(this.fields);
        }

        /* JADX INFO: renamed from: b */
        public boolean m12356b() {
            return this.readOnly;
        }

        /* JADX INFO: renamed from: c */
        public boolean m12357c() {
            return this.required;
        }
    }

    public class Field {

        @SerializedName(m9428a = "extraTypeInfo")
        private String extraTypeInfo;

        @SerializedName(m9428a = "label")
        private String label;

        @SerializedName(m9428a = "length")
        private int length;

        @SerializedName(m9428a = "name")
        private String name;

        @SerializedName(m9428a = "pickListOption")
        private List<PickListOption> pickListOption;

        @SerializedName(m9428a = ShareConstants.MEDIA_TYPE)
        private String type;

        @SerializedName(m9428a = "value")
        private String value;

        /* JADX INFO: renamed from: a */
        public String m12349a() {
            return this.label;
        }

        /* JADX INFO: renamed from: b */
        public int m12350b() {
            return this.length;
        }

        /* JADX INFO: renamed from: c */
        public String m12351c() {
            return this.name;
        }

        /* JADX INFO: renamed from: d */
        public List<PickListOption> m12352d() {
            return this.pickListOption == null ? Collections.emptyList() : Collections.unmodifiableList(this.pickListOption);
        }

        /* JADX INFO: renamed from: e */
        public String m12353e() {
            return this.type;
        }

        /* JADX INFO: renamed from: f */
        public String m12354f() {
            return this.value;
        }
    }

    public class PickListOption {

        @SerializedName(m9428a = "label")
        private String label;

        @SerializedName(m9428a = "value")
        private String value;

        /* JADX INFO: renamed from: a */
        public String m12358a() {
            return this.label;
        }

        /* JADX INFO: renamed from: b */
        public String m12359b() {
            return this.value;
        }
    }
}
