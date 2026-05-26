.class public Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "CompleteCaseFeedRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CompleteCaseFeedRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->a:Ljava/lang/String;

    .line 85
    iput-object p2, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->b:Ljava/lang/String;

    .line 86
    iput-object p3, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->c:Ljava/lang/String;

    .line 87
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->b:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->c:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;
    .locals 0

    .prologue
    .line 90
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;
    .locals 1

    .prologue
    .line 94
    new-instance v0, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;-><init>(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest$CompleteCaseFeedRequestBuilder;

    move-result-object v0

    return-object v0
.end method
