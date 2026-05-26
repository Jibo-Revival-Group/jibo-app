.class public Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "ListViewDescribeRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;)V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 43
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;->a:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 53
    new-instance v0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;->a:Ljava/lang/String;

    return-object v0
.end method
