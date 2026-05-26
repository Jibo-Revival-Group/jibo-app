.class public Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;
.super Lcom/salesforce/android/cases/core/requests/SaveRequest;
.source "SetCaseHiddenRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Z


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/SaveRequest;-><init>(Lcom/salesforce/android/cases/core/SaveRequestBuilder;)V

    .line 37
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->a:Ljava/lang/String;

    .line 38
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->b(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->b:Z

    .line 39
    return-void
.end method

.method public static a(Ljava/lang/String;Z)Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;
    .locals 2

    .prologue
    .line 49
    new-instance v0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;-><init>(Ljava/lang/String;Z)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->a(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->b(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->e()Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;->b:Z

    return v0
.end method
