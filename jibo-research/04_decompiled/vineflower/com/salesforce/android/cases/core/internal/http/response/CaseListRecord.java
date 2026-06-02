package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class CaseListRecord {
   @SerializedName(a = "CaseNumber")
   private String caseNumber;
   @SerializedName(a = "CreatedDate")
   private Date createdDate;
   @SerializedName(a = "Feeds")
   private CaseListFeeds feeds;
   @SerializedName(a = "Id")
   private String id;
   @SerializedName(a = "LastModifiedDate")
   private Date lastModifiedDate;
   @SerializedName(a = "Subject")
   private String subject;

   public String a() {
      return this.id;
   }

   public String b() {
      return this.caseNumber;
   }

   public String c() {
      return this.subject;
   }

   public Date d() {
      return this.createdDate;
   }

   public Date e() {
      return this.lastModifiedDate;
   }

   public CaseListFeeds f() {
      return this.feeds;
   }
}
