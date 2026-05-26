.class public Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
.super Ljava/lang/Object;
.source "CaseFeedModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseFeed;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;,
        Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;,
        Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;,
        Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;)V
    .locals 5

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    if-nez p1, :cond_0

    .line 57
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseFeedResponse cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->a:Ljava/lang/String;

    .line 61
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->c:Ljava/lang/String;

    .line 62
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->d:Ljava/lang/String;

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->b:Ljava/util/List;

    .line 65
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;->b()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;

    .line 66
    if-eqz v0, :cond_1

    .line 67
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->b:Ljava/util/List;

    new-instance v3, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v0, v4}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 70
    :cond_2
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;)Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
    .locals 1

    .prologue
    .line 52
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/salesforce/android/cases/core/model/Element;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->b:Ljava/util/List;

    if-nez v0, :cond_0

    .line 78
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    .line 80
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;->b:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method
