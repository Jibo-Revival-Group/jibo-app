.class public Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;
.super Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;
.source "CreateCaseRecordRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NewCaseRecordRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/salesforce/android/cases/core/model/CreateCaseRecord;)V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/requests/NoCacheRequestBuilder;-><init>()V

    .line 78
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->a:Ljava/lang/String;

    .line 79
    iput-object p2, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    .line 80
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)Lcom/salesforce/android/cases/core/model/CreateCaseRecord;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->b:Lcom/salesforce/android/cases/core/model/CreateCaseRecord;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;
    .locals 0

    .prologue
    .line 83
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest$NewCaseRecordRequestBuilder;

    move-result-object v0

    return-object v0
.end method
