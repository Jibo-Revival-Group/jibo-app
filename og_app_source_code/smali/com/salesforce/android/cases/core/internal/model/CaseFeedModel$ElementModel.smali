.class public Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;
.super Ljava/lang/Object;
.source "CaseFeedModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Element;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ElementModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

.field private b:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;

.field private c:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;

.field private d:Ljava/util/Date;

.field private e:Ljava/lang/String;

.field private f:Ljava/util/Date;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 103
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 105
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    move-result-object v1

    invoke-direct {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->b:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;

    .line 108
    :cond_0
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 109
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    move-result-object v1

    invoke-direct {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->c:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;

    .line 112
    :cond_1
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->c()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->d:Ljava/util/Date;

    .line 113
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->e:Ljava/lang/String;

    .line 114
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->e()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->f:Ljava/util/Date;

    .line 115
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->g:Ljava/lang/String;

    .line 116
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->h:Ljava/lang/String;

    .line 117
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->h()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->i:Ljava/lang/String;

    .line 118
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->j:Ljava/lang/String;

    .line 119
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->b:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->c:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;

    return-object v0
.end method

.method public c()Ljava/util/Date;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->d:Ljava/util/Date;

    return-object v0
.end method

.method public synthetic d()Lcom/salesforce/android/cases/core/model/Body;
    .locals 1

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->b()Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;

    move-result-object v0

    return-object v0
.end method

.method public synthetic e()Lcom/salesforce/android/cases/core/model/Actor;
    .locals 1

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ElementModel;->a()Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;

    move-result-object v0

    return-object v0
.end method
