.class public Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "ListViewRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/ListViewRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ListViewRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 64
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->a:Ljava/lang/String;

    .line 65
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;
    .locals 0

    .prologue
    .line 68
    return-object p0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method public d()Z
    .locals 1

    .prologue
    .line 76
    const/4 v0, 0x1

    return v0
.end method

.method public e()Lcom/salesforce/android/cases/core/requests/ListViewRequest;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/salesforce/android/cases/core/requests/ListViewRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/ListViewRequest;-><init>(Lcom/salesforce/android/cases/core/requests/ListViewRequest$ListViewRequestBuilder;)V

    return-object v0
.end method

.method public f_()Z
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x1

    return v0
.end method
