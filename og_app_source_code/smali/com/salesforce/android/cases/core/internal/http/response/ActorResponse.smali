.class public Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;
.super Ljava/lang/Object;
.source "ActorResponse.java"


# instance fields
.field private companyName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "companyName"
    .end annotation
.end field

.field private displayName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "displayName"
    .end annotation
.end field

.field private firstName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "firstName"
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "id"
    .end annotation
.end field

.field private isActive:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "isActive"
    .end annotation
.end field

.field private isInThisCommunity:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "isInThisCommunity"
    .end annotation
.end field

.field private lastName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "lastName"
    .end annotation
.end field

.field private photo:Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "photo"
    .end annotation
.end field

.field private title:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "title"
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "type"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->companyName:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->firstName:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->id:Ljava/lang/String;

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->isActive:Z

    return v0
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->isInThisCommunity:Z

    return v0
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->lastName:Ljava/lang/String;

    return-object v0
.end method

.method public h()Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->photo:Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;

    return-object v0
.end method

.method public i()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->title:Ljava/lang/String;

    return-object v0
.end method

.method public j()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/ActorResponse;->type:Ljava/lang/String;

    return-object v0
.end method
