.class public Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;
.super Ljava/lang/Object;
.source "CommentPostModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/Actor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ActorModel"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Ljava/lang/String;

.field private f:Z

.field private g:Z

.field private h:Ljava/lang/String;

.field private i:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;)V
    .locals 3

    .prologue
    .line 129
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->a:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 130
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->b:Ljava/lang/String;

    .line 131
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->c:Ljava/lang/String;

    .line 132
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->d:Ljava/lang/String;

    .line 133
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->e:Ljava/lang/String;

    .line 134
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->e()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->f:Z

    .line 135
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->f()Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->g:Z

    .line 136
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->h:Ljava/lang/String;

    .line 138
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->h()Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 139
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;

    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->h()Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->i:Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$PhotoModel;

    .line 142
    :cond_0
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->j:Ljava/lang/String;

    .line 143
    invoke-virtual {p2}, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->j()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->k:Ljava/lang/String;

    .line 144
    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$1;)V
    .locals 0

    .prologue
    .line 116
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;-><init>(Lcom/salesforce/android/cases/core/internal/model/CommentPostModel;Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CommentPostModel$ActorModel;->e:Ljava/lang/String;

    return-object v0
.end method
