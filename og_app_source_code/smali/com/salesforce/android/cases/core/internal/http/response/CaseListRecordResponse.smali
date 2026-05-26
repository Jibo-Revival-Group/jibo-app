.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;
.super Ljava/lang/Object;
.source "CaseListRecordResponse.java"


# instance fields
.field private done:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "done"
    .end annotation
.end field

.field private records:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "records"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;",
            ">;"
        }
    .end annotation
.end field

.field private totalSize:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "totalSize"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;->records:Ljava/util/List;

    if-nez v0, :cond_0

    .line 51
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 53
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;->records:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method
