.class public Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;
.super Lcom/salesforce/android/cases/core/SaveRequestBuilder;
.source "SetCaseHiddenRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCaseHiddenRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/SaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Z


# direct methods
.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;-><init>()V

    .line 76
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->a:Ljava/lang/String;

    .line 77
    iput-boolean p2, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->b:Z

    .line 78
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)Z
    .locals 1

    .prologue
    .line 69
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->b:Z

    return v0
.end method


# virtual methods
.method protected synthetic c()Lcom/salesforce/android/cases/core/SaveRequestBuilder;
    .locals 1

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;->d()Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method protected d()Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;
    .locals 0

    .prologue
    .line 81
    return-object p0
.end method

.method public e()Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;
    .locals 1

    .prologue
    .line 85
    new-instance v0, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;-><init>(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest$SetCaseHiddenRequestBuilder;)V

    return-object v0
.end method
