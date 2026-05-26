.class public Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "ListViewDescribeRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ListViewDescribeRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 69
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->a:Ljava/lang/String;

    .line 70
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;
    .locals 0

    .prologue
    .line 73
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;-><init>(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 63
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest$ListViewDescribeRequestBuilder;

    move-result-object v0

    return-object v0
.end method
