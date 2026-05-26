.class public Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;
.super Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
.source "DefaultValuesRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DefaultValuesRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;-><init>()V

    .line 75
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->a:Ljava/lang/String;

    .line 76
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected a()Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;
    .locals 0

    .prologue
    .line 79
    return-object p0
.end method

.method public b()Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;
    .locals 1

    .prologue
    .line 83
    new-instance v0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;-><init>(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;)V

    return-object v0
.end method

.method protected synthetic c()Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;
    .locals 1

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->a()Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;

    move-result-object v0

    return-object v0
.end method
