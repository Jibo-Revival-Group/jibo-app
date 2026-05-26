.class public Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "CaseListRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CaseListRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CaseListRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;->a:Ljava/lang/String;

    .line 71
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;
    .locals 0

    .prologue
    .line 74
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CaseListRequest;
    .locals 1

    .prologue
    .line 78
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CaseListRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CaseListRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CaseListRequest$CaseListRequestBuilder;

    move-result-object v0

    return-object v0
.end method
