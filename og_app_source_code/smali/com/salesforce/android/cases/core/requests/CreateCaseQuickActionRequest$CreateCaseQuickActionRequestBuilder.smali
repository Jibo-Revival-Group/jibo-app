.class public Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "CreateCaseQuickActionRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateCaseQuickActionRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 72
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->a:Ljava/lang/String;

    .line 73
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;
    .locals 0

    .prologue
    .line 76
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    move-result-object v0

    return-object v0
.end method
