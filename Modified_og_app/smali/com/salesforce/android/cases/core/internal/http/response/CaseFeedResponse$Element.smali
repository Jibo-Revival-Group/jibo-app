.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;
.super Ljava/lang/Object;
.source "CaseFeedResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Element"
.end annotation


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


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->actor:Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->body:Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->createdDate:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->id:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->modifiedDate:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->photoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->type:Ljava/lang/String;

    return-object v0
.end method

.method public h()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->url:Ljava/lang/String;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseFeedResponse$Element;->visibility:Ljava/lang/String;

    return-object v0
.end method
