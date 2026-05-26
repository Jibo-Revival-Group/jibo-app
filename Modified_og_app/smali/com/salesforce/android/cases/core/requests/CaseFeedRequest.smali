.class public Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "CaseFeedRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 42
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->a:Ljava/lang/String;

    .line 43
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->b(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->b:Ljava/lang/String;

    .line 44
    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;->b:Ljava/lang/String;

    return-object v0
.end method
