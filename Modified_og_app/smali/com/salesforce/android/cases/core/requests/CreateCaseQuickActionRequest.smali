.class public Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CreateCaseQuickActionRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 41
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 51
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    .line 52
    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    .line 53
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;

    move-result-object v0

    .line 51
    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;->a:Ljava/lang/String;

    return-object v0
.end method
