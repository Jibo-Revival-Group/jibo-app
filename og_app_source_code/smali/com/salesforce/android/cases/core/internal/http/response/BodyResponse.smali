.class public Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;
.super Ljava/lang/Object;
.source "BodyResponse.java"


# instance fields
.field private isRichText:Z
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "isRichText"
    .end annotation
.end field

.field private text:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "text"
    .end annotation
.end field


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->isRichText:Z

    return v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/BodyResponse;->text:Ljava/lang/String;

    return-object v0
.end method
