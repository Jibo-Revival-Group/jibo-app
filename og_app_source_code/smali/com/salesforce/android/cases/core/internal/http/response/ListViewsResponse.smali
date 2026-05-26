.class public Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;
.super Ljava/lang/Object;
.source "ListViewsResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;
    }
.end annotation


# instance fields
.field private listviews:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "listviews"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;",
            ">;"
        }
    .end annotation
.end field

.field private size:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "size"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
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
            "Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;->listviews:Ljava/util/List;

    if-nez v0, :cond_0

    .line 45
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 47
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;->listviews:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;->size:I

    return v0
.end method
