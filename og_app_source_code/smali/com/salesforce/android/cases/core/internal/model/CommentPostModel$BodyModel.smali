.class public Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;
.super Ljava/lang/Object;
.source "CommentPostModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Body;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BodyModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

.field private b:Z

.field private c:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;)V
    .locals 1

    .prologue
    .line 235
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;->a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 236
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->a()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;->b:Z

    .line 237
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;->c:Ljava/lang/String;

    .line 238
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V
    .locals 0

    .prologue
    .line 230
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;->c:Ljava/lang/String;

    return-object v0
.end method
