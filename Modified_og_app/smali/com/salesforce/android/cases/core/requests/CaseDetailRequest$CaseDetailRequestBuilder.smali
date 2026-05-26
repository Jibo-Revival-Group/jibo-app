.class public Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "CaseDetailRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CaseDetailRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->a:Ljava/lang/String;

    .line 61
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;
    .locals 0

    .prologue
    .line 64
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;
    .locals 1

    .prologue
    .line 68
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;

    move-result-object v0

    return-object v0
.end method
