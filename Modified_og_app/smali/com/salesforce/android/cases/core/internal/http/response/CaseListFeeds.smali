.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;
.super Ljava/lang/Object;
.source "CaseListFeeds.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;
    }
.end annotation


# instance fields
.field private records:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "records"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;",
            ">;"
        }
    .end annotation
.end field


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;->records:Ljava/util/List;

    if-nez v0, :cond_0

    .line 47
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 49
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;->records:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method
