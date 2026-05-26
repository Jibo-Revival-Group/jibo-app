.class public Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;
.super Lcom/salesforce/android/cases/core/requests/SaveRequest;
.source "SetCaseLastReadDateRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/util/Date;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/SaveRequest;-><init>(Lcom/salesforce/android/cases/core/SaveRequestBuilder;)V

    .line 38
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->a:Ljava/lang/String;

    .line 39
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->b(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->b:Ljava/util/Date;

    .line 40
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/util/Date;)Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;
    .locals 2

    .prologue
    .line 51
    new-instance v0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;

    invoke-direct {v0, p0, p1}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;-><init>(Ljava/lang/String;Ljava/util/Date;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->a(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;

    const/4 v1, 0x0

    .line 52
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->b(Z)Lcom/salesforce/android/cases/core/SaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;

    .line 53
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->e()Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;

    move-result-object v0

    .line 51
    return-object v0
.end method


# virtual methods
.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/Date;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;->b:Ljava/util/Date;

    return-object v0
.end method
