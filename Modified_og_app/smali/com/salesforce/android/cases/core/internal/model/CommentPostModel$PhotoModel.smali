.class public Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;
.super Ljava/lang/Object;
.source "CommentPostModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PhotoModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;)V
    .locals 1

    .prologue
    .line 196
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 197
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->b:Ljava/lang/String;

    .line 198
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->c:Ljava/lang/String;

    .line 199
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->d:Ljava/lang/String;

    .line 200
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->e:Ljava/lang/String;

    .line 201
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->f:Ljava/lang/String;

    .line 202
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;->g:Ljava/lang/String;

    .line 203
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V
    .locals 0

    .prologue
    .line 187
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;)V

    return-void
.end method
