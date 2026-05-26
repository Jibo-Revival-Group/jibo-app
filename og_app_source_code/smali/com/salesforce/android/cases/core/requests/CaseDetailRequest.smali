.class public Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CaseDetailRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 41
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;->a:Ljava/lang/String;

    .line 42
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;->a:Ljava/lang/String;

    return-object v0
.end method
