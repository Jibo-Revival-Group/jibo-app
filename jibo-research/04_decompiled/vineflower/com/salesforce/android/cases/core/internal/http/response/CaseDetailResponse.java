package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class CaseDetailResponse {
   private Map<String, String> a;
   @SerializedName(a = "AssetId")
   private String assetId;
   @SerializedName(a = "CaseNumber")
   private String caseNumber;
   @SerializedName(a = "IsClosed")
   private boolean closed;
   @SerializedName(a = "ClosedDate")
   private Date closedDate;
   @SerializedName(a = "CommunityId")
   private String communityId;
   @SerializedName(a = "ContactId")
   private String contactId;
   @SerializedName(a = "CreatedById")
   private String createdById;
   @SerializedName(a = "CreatedDate")
   private Date createdDate;
   @SerializedName(a = "CreatorFullPhotoUrl")
   private String creatorFullPhotoUrl;
   @SerializedName(a = "CreatorName")
   private String creatorName;
   @SerializedName(a = "CreatorSmallPhotoUrl")
   private String creatorSmallPhotoUrl;
   @SerializedName(a = "IsDeleted")
   private boolean deleted;
   @SerializedName(a = "Description")
   private String description;
   @SerializedName(a = "IsEscalated")
   private boolean escalated;
   @SerializedName(a = "FeedItemId")
   private String feedItemId;
   @SerializedName(a = "HasCommentsUnreadByOwner")
   private boolean hasCommentsUnreadByOwner;
   @SerializedName(a = "HasSelfServiceComments")
   private boolean hasSelfServiceComments;
   @SerializedName(a = "Id")
   private String id;
   @SerializedName(a = "LastModifiedById")
   private String lastModifiedById;
   @SerializedName(a = "LastModifiedDate")
   private Date lastModifiedDate;
   @SerializedName(a = "LastReferencedDate")
   private Date lastReferencedDate;
   @SerializedName(a = "LastViewedDate")
   private Date lastViewedDate;
   @SerializedName(a = "OwnerId")
   private String ownerId;
   @SerializedName(a = "Priority")
   private String priority;
   @SerializedName(a = "Reason")
   private String reason;
   @SerializedName(a = "RecordTypeId")
   private String recordTypeId;
   @SerializedName(a = "SourceId")
   private String sourceId;
   @SerializedName(a = "Status")
   private String status;
   @SerializedName(a = "Subject")
   private String subject;
   @SerializedName(a = "SuppliedEmail")
   private String suppliedEmail;
   @SerializedName(a = "SuppliedName")
   private String suppliedName;
   @SerializedName(a = "Type")
   private String type;

   public String A() {
      return this.lastModifiedById;
   }

   public Date B() {
      return this.lastViewedDate;
   }

   public Date C() {
      return this.lastReferencedDate;
   }

   public String D() {
      return this.creatorFullPhotoUrl;
   }

   public String E() {
      return this.creatorSmallPhotoUrl;
   }

   public String F() {
      return this.creatorName;
   }

   public Map<String, String> G() {
      Map var1;
      if (this.a == null) {
         var1 = Collections.emptyMap();
      } else {
         var1 = Collections.unmodifiableMap(this.a);
      }

      return var1;
   }

   public String a() {
      return this.id;
   }

   public void a(Map<String, String> var1) {
      this.a = var1;
   }

   public boolean b() {
      return this.deleted;
   }

   public String c() {
      return this.caseNumber;
   }

   public String d() {
      return this.contactId;
   }

   public String e() {
      return this.assetId;
   }

   public String f() {
      return this.feedItemId;
   }

   public String g() {
      return this.sourceId;
   }

   public String h() {
      return this.communityId;
   }

   public String i() {
      return this.suppliedName;
   }

   public String j() {
      return this.suppliedEmail;
   }

   public String k() {
      return this.type;
   }

   public String l() {
      return this.recordTypeId;
   }

   public String m() {
      return this.status;
   }

   public String n() {
      return this.reason;
   }

   public String o() {
      return this.subject;
   }

   public String p() {
      return this.priority;
   }

   public String q() {
      return this.description;
   }

   public boolean r() {
      return this.closed;
   }

   public Date s() {
      return this.closedDate;
   }

   public boolean t() {
      return this.escalated;
   }

   public boolean u() {
      return this.hasCommentsUnreadByOwner;
   }

   public boolean v() {
      return this.hasSelfServiceComments;
   }

   public String w() {
      return this.ownerId;
   }

   public Date x() {
      return this.createdDate;
   }

   public String y() {
      return this.createdById;
   }

   public Date z() {
      return this.lastModifiedDate;
   }
}
