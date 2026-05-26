.class public Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "CaseFeedRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CaseFeedRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 70
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->a:Ljava/lang/String;

    .line 71
    iput-object p2, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->b:Ljava/lang/String;

    .line 72
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->b:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;
    .locals 0

    .prologue
    .line 75
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;
    .locals 1

    .prologue
    .line 79
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;

    move-result-object v0

    return-object v0
.end method
