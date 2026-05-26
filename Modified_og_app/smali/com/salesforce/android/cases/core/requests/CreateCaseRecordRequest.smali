.class public Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CreateCaseRecordRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 42
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->a:Ljava/lang/String;

    .line 43
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->b(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    .line 44
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Lcom/salesforce/android/cases/core/model/CreateCaseRecord;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;->b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    return-object v0
.end method
