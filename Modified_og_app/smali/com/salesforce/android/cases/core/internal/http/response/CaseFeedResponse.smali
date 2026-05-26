.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;
.super Ljava/lang/Object;
.source "CaseFeedResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;
    }
.end annotation


# instance fields
.field private currentPageUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "currentPageUrl"
    .end annotation
.end field

.field private elements:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "elements"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;",
            ">;"
        }
    .end annotation
.end field

.field private nextPageUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "nextPageUrl"
    .end annotation
.end field

.field private updatesUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "updatesUrl"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->currentPageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;",
            ">;"
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->elements:Ljava/util/List;

    if-nez v0, :cond_0

    .line 58
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 60
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->elements:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->nextPageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->updatesUrl:Ljava/lang/String;

    return-object v0
.end method
