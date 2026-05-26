.class public Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;
.super Ljava/lang/Object;
.source "CaseFeedModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Body;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BodyModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

.field private b:Z

.field private c:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;)V
    .locals 1

    .prologue
    .line 277
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;->a:Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 278
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->a()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;->b:Z

    .line 279
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;->c:Ljava/lang/String;

    .line 280
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$1;)V
    .locals 0

    .prologue
    .line 272
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 287
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseFeedModel$BodyModel;->c:Ljava/lang/String;

    return-object v0
.end method
