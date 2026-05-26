.class public Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;
.super Ljava/lang/Object;
.source "CaseFeedModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Actor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ActorModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Z

.field private g:Z

.field private h:Ljava/lang/String;

.field private i:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;)V
    .locals 3

    .prologue
    .line 171
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 172
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->b:Ljava/lang/String;

    .line 173
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->c:Ljava/lang/String;

    .line 174
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->d:Ljava/lang/String;

    .line 175
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->e:Ljava/lang/String;

    .line 176
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->e()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->f:Z

    .line 177
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->f()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->g:Z

    .line 178
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->h:Ljava/lang/String;

    .line 180
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->h()Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 181
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->h()Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->i:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;

    .line 184
    :cond_0
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->j:Ljava/lang/String;

    .line 185
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->j()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->k:Ljava/lang/String;

    .line 186
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V
    .locals 0

    .prologue
    .line 158
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 193
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$ActorModel;->e:Ljava/lang/String;

    return-object v0
.end method
