.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;
.super Ljava/lang/Object;
.source "CaseDetailResponse.java"


# instance fields
.field private a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private assetId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "AssetId"
    .end annotation
.end field

.field private caseNumber:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CaseNumber"
    .end annotation
.end field

.field private closed:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "IsClosed"
    .end annotation
.end field

.field private closedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "ClosedDate"
    .end annotation
.end field

.field private communityId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CommunityId"
    .end annotation
.end field

.field private contactId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "ContactId"
    .end annotation
.end field

.field private createdById:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatedById"
    .end annotation
.end field

.field private createdDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatedDate"
    .end annotation
.end field

.field private creatorFullPhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatorFullPhotoUrl"
    .end annotation
.end field

.field private creatorName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatorName"
    .end annotation
.end field

.field private creatorSmallPhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatorSmallPhotoUrl"
    .end annotation
.end field

.field private deleted:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "IsDeleted"
    .end annotation
.end field

.field private description:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Description"
    .end annotation
.end field

.field private escalated:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "IsEscalated"
    .end annotation
.end field

.field private feedItemId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "FeedItemId"
    .end annotation
.end field

.field private hasCommentsUnreadByOwner:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "HasCommentsUnreadByOwner"
    .end annotation
.end field

.field private hasSelfServiceComments:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "HasSelfServiceComments"
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Id"
    .end annotation
.end field

.field private lastModifiedById:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastModifiedById"
    .end annotation
.end field

.field private lastModifiedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastModifiedDate"
    .end annotation
.end field

.field private lastReferencedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastReferencedDate"
    .end annotation
.end field

.field private lastViewedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastViewedDate"
    .end annotation
.end field

.field private ownerId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "OwnerId"
    .end annotation
.end field

.field private priority:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Priority"
    .end annotation
.end field

.field private reason:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Reason"
    .end annotation
.end field

.field private recordTypeId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "RecordTypeId"
    .end annotation
.end field

.field private sourceId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "SourceId"
    .end annotation
.end field

.field private status:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Status"
    .end annotation
.end field

.field private subject:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Subject"
    .end annotation
.end field

.field private suppliedEmail:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "SuppliedEmail"
    .end annotation
.end field

.field private suppliedName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "SuppliedName"
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Type"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public A()Ljava/lang/String;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->lastModifiedById:Ljava/lang/String;

    return-object v0
.end method

.method public B()Ljava/util/Date;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->lastViewedDate:Ljava/util/Date;

    return-object v0
.end method

.method public C()Ljava/util/Date;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->lastReferencedDate:Ljava/util/Date;

    return-object v0
.end method

.method public D()Ljava/lang/String;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->creatorFullPhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public E()Ljava/lang/String;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->creatorSmallPhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public F()Ljava/lang/String;
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->creatorName:Ljava/lang/String;

    return-object v0
.end method

.method public G()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 233
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->a:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 234
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    .line 236
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->a:Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    goto :goto_0
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->id:Ljava/lang/String;

    return-object v0
.end method

.method public a(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 240
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->a:Ljava/util/Map;

    .line 241
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->deleted:Z

    return v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->caseNumber:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->contactId:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->assetId:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->feedItemId:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->sourceId:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->communityId:Ljava/lang/String;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->suppliedName:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->suppliedEmail:Ljava/lang/String;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->type:Ljava/lang/String;

    return-object v0
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->recordTypeId:Ljava/lang/String;

    return-object v0
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->status:Ljava/lang/String;

    return-object v0
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->reason:Ljava/lang/String;

    return-object v0
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->subject:Ljava/lang/String;

    return-object v0
.end method

.method public p()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->priority:Ljava/lang/String;

    return-object v0
.end method

.method public q()Ljava/lang/String;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->description:Ljava/lang/String;

    return-object v0
.end method

.method public r()Z
    .locals 1

    .prologue
    .line 173
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->closed:Z

    return v0
.end method

.method public s()Ljava/util/Date;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->closedDate:Ljava/util/Date;

    return-object v0
.end method

.method public t()Z
    .locals 1

    .prologue
    .line 181
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->escalated:Z

    return v0
.end method

.method public u()Z
    .locals 1

    .prologue
    .line 185
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->hasCommentsUnreadByOwner:Z

    return v0
.end method

.method public v()Z
    .locals 1

    .prologue
    .line 189
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->hasSelfServiceComments:Z

    return v0
.end method

.method public w()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->ownerId:Ljava/lang/String;

    return-object v0
.end method

.method public x()Ljava/util/Date;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->createdDate:Ljava/util/Date;

    return-object v0
.end method

.method public y()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->createdById:Ljava/lang/String;

    return-object v0
.end method

.method public z()Ljava/util/Date;
    .locals 1

    .prologue
    .line 205
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;->lastModifiedDate:Ljava/util/Date;

    return-object v0
.end method
