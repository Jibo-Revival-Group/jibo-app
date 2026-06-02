package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CaseDetailResponse {

    /* JADX INFO: renamed from: a */
    private Map<String, String> f12317a;

    @SerializedName(m9428a = "AssetId")
    private String assetId;

    @SerializedName(m9428a = "CaseNumber")
    private String caseNumber;

    @SerializedName(m9428a = "IsClosed")
    private boolean closed;

    @SerializedName(m9428a = "ClosedDate")
    private Date closedDate;

    @SerializedName(m9428a = "CommunityId")
    private String communityId;

    @SerializedName(m9428a = "ContactId")
    private String contactId;

    @SerializedName(m9428a = "CreatedById")
    private String createdById;

    @SerializedName(m9428a = "CreatedDate")
    private Date createdDate;

    @SerializedName(m9428a = "CreatorFullPhotoUrl")
    private String creatorFullPhotoUrl;

    @SerializedName(m9428a = "CreatorName")
    private String creatorName;

    @SerializedName(m9428a = "CreatorSmallPhotoUrl")
    private String creatorSmallPhotoUrl;

    @SerializedName(m9428a = "IsDeleted")
    private boolean deleted;

    @SerializedName(m9428a = "Description")
    private String description;

    @SerializedName(m9428a = "IsEscalated")
    private boolean escalated;

    @SerializedName(m9428a = "FeedItemId")
    private String feedItemId;

    @SerializedName(m9428a = "HasCommentsUnreadByOwner")
    private boolean hasCommentsUnreadByOwner;

    @SerializedName(m9428a = "HasSelfServiceComments")
    private boolean hasSelfServiceComments;

    /* JADX INFO: renamed from: id */
    @SerializedName(m9428a = "Id")
    private String f12318id;

    @SerializedName(m9428a = "LastModifiedById")
    private String lastModifiedById;

    @SerializedName(m9428a = "LastModifiedDate")
    private Date lastModifiedDate;

    @SerializedName(m9428a = "LastReferencedDate")
    private Date lastReferencedDate;

    @SerializedName(m9428a = "LastViewedDate")
    private Date lastViewedDate;

    @SerializedName(m9428a = "OwnerId")
    private String ownerId;

    @SerializedName(m9428a = "Priority")
    private String priority;

    @SerializedName(m9428a = "Reason")
    private String reason;

    @SerializedName(m9428a = "RecordTypeId")
    private String recordTypeId;

    @SerializedName(m9428a = "SourceId")
    private String sourceId;

    @SerializedName(m9428a = "Status")
    private String status;

    @SerializedName(m9428a = "Subject")
    private String subject;

    @SerializedName(m9428a = "SuppliedEmail")
    private String suppliedEmail;

    @SerializedName(m9428a = "SuppliedName")
    private String suppliedName;

    @SerializedName(m9428a = "Type")
    private String type;

    /* JADX INFO: renamed from: a */
    public String m12263a() {
        return this.f12318id;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12265b() {
        return this.deleted;
    }

    /* JADX INFO: renamed from: c */
    public String m12266c() {
        return this.caseNumber;
    }

    /* JADX INFO: renamed from: d */
    public String m12267d() {
        return this.contactId;
    }

    /* JADX INFO: renamed from: e */
    public String m12268e() {
        return this.assetId;
    }

    /* JADX INFO: renamed from: f */
    public String m12269f() {
        return this.feedItemId;
    }

    /* JADX INFO: renamed from: g */
    public String m12270g() {
        return this.sourceId;
    }

    /* JADX INFO: renamed from: h */
    public String m12271h() {
        return this.communityId;
    }

    /* JADX INFO: renamed from: i */
    public String m12272i() {
        return this.suppliedName;
    }

    /* JADX INFO: renamed from: j */
    public String m12273j() {
        return this.suppliedEmail;
    }

    /* JADX INFO: renamed from: k */
    public String m12274k() {
        return this.type;
    }

    /* JADX INFO: renamed from: l */
    public String m12275l() {
        return this.recordTypeId;
    }

    /* JADX INFO: renamed from: m */
    public String m12276m() {
        return this.status;
    }

    /* JADX INFO: renamed from: n */
    public String m12277n() {
        return this.reason;
    }

    /* JADX INFO: renamed from: o */
    public String m12278o() {
        return this.subject;
    }

    /* JADX INFO: renamed from: p */
    public String m12279p() {
        return this.priority;
    }

    /* JADX INFO: renamed from: q */
    public String m12280q() {
        return this.description;
    }

    /* JADX INFO: renamed from: r */
    public boolean m12281r() {
        return this.closed;
    }

    /* JADX INFO: renamed from: s */
    public Date m12282s() {
        return this.closedDate;
    }

    /* JADX INFO: renamed from: t */
    public boolean m12283t() {
        return this.escalated;
    }

    /* JADX INFO: renamed from: u */
    public boolean m12284u() {
        return this.hasCommentsUnreadByOwner;
    }

    /* JADX INFO: renamed from: v */
    public boolean m12285v() {
        return this.hasSelfServiceComments;
    }

    /* JADX INFO: renamed from: w */
    public String m12286w() {
        return this.ownerId;
    }

    /* JADX INFO: renamed from: x */
    public Date m12287x() {
        return this.createdDate;
    }

    /* JADX INFO: renamed from: y */
    public String m12288y() {
        return this.createdById;
    }

    /* JADX INFO: renamed from: z */
    public Date m12289z() {
        return this.lastModifiedDate;
    }

    /* JADX INFO: renamed from: A */
    public String m12256A() {
        return this.lastModifiedById;
    }

    /* JADX INFO: renamed from: B */
    public Date m12257B() {
        return this.lastViewedDate;
    }

    /* JADX INFO: renamed from: C */
    public Date m12258C() {
        return this.lastReferencedDate;
    }

    /* JADX INFO: renamed from: D */
    public String m12259D() {
        return this.creatorFullPhotoUrl;
    }

    /* JADX INFO: renamed from: E */
    public String m12260E() {
        return this.creatorSmallPhotoUrl;
    }

    /* JADX INFO: renamed from: F */
    public String m12261F() {
        return this.creatorName;
    }

    /* JADX INFO: renamed from: G */
    public Map<String, String> m12262G() {
        return this.f12317a == null ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12317a);
    }

    /* JADX INFO: renamed from: a */
    public void m12264a(Map<String, String> map) {
        this.f12317a = map;
    }
}
