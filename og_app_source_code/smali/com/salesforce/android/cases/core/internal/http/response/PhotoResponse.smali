.class public Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;
.super Ljava/lang/Object;
.source "PhotoResponse.java"


# instance fields
.field private fullEmailPhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "fullEmailPhotoUrl"
    .end annotation
.end field

.field private largePhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "largePhotoUrl"
    .end annotation
.end field

.field private photoVersionId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "photoVersionId"
    .end annotation
.end field

.field private smallPhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "smallPhotoUrl"
    .end annotation
.end field

.field private standardEmailPhotoUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "standardEmailPhotoUrl"
    .end annotation
.end field

.field private url:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "url"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->fullEmailPhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->largePhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->photoVersionId:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->smallPhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->standardEmailPhotoUrl:Ljava/lang/String;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/PhotoResponse;->url:Ljava/lang/String;

    return-object v0
.end method
