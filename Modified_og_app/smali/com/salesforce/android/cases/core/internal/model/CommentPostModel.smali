.class public Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;
.super Ljava/lang/Object;
.source "CommentPostModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CommentPost;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;,
        Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;,
        Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;

.field private b:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;

.field private c:Ljava/util/Date;

.field private d:Ljava/lang/String;

.field private e:Ljava/util/Date;

.field private f:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CommentPostResponse cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 64
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    move-result-object v1

    invoke-direct {v0, p0, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;

    .line 67
    :cond_1
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 68
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    move-result-object v1

    invoke-direct {v0, p0, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->b:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;

    .line 71
    :cond_2
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->c()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->c:Ljava/util/Date;

    .line 72
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->d:Ljava/lang/String;

    .line 73
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->e()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/util/DateUtils;->a(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->e:Ljava/util/Date;

    .line 74
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->f:Ljava/lang/String;

    .line 75
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->g:Ljava/lang/String;

    .line 76
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->h()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->h:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->i:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;)Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/model/Body;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->b:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$BodyModel;

    return-object v0
.end method

.method public b()Ljava/util/Date;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;->c:Ljava/util/Date;

    return-object v0
.end method
