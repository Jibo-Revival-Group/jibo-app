.class public Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;
.super Ljava/lang/Object;
.source "CaseFeedModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PhotoModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;)V
    .locals 1

    .prologue
    .line 238
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 239
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->b:Ljava/lang/String;

    .line 240
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->c:Ljava/lang/String;

    .line 241
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->d:Ljava/lang/String;

    .line 242
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->e:Ljava/lang/String;

    .line 243
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->f:Ljava/lang/String;

    .line 244
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;->g:Ljava/lang/String;

    .line 245
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V
    .locals 0

    .prologue
    .line 229
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$PhotoModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;)V

    return-void
.end method
