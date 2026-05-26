.class public Lcom/salesforce/android/cases/core/requests/ListViewRequest;
.super Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;
.source "ListViewRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/requests/FetchSaveRequest;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;)V

    .line 41
    invoke-static {p1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->a(Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public static a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/requests/ListViewRequest;
    .locals 2

    .prologue
    .line 45
    new-instance v0, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->e()Lcom/salesforce/android/cases/core/requests/ListViewRequest;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewRequest;->a:Ljava/lang/String;

    return-object v0
.end method
