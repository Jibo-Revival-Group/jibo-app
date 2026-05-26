.class public Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;
.super Ljava/lang/Object;
.source "CommentPostResponse.java"


# instance fields
.field private actor:Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "actor"
    .end annotation
.end field

.field private body:Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "body"
    .end annotation
.end field

.field private createdDate:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "createdDate"
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "id"
    .end annotation
.end field

.field private modifiedDate:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "modifiedDate"
    .end annotation
.end field

.field private photoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "photoUrl"
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "type"
    .end annotation
.end field

.field private url:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "url"
    .end annotation
.end field

.field private visibility:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "visibility"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->actor:Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->body:Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->createdDate:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->id:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->modifiedDate:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->photoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->type:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->url:Ljava/lang/String;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CommentPostResponse;->visibility:Ljava/lang/String;

    return-object v0
.end method
