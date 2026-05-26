.class public Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;
.super Lcom/salesforce/android/cases/core/SaveRequestBuilder;
.source "SetCaseLastReadDateRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCaseLastReadDateRequestBuilder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/SaveRequestBuilder",
        "<",
        "Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/util/Date;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Date;)V
    .locals 0

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/SaveRequestBuilder;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->a:Ljava/lang/String;

    .line 72
    iput-object p2, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->b:Ljava/util/Date;

    .line 73
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)Ljava/util/Date;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->b:Ljava/util/Date;

    return-object v0
.end method


# virtual methods
.method protected synthetic c()Lcom/salesforce/android/cases/core/SaveRequestBuilder;
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;->d()Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;

    move-result-object v0

    return-object v0
.end method

.method protected d()Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;
    .locals 0

    .prologue
    .line 76
    return-object p0
.end method

.method public e()Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;-><init>(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest$SetCaseLastReadDateRequestBuilder;)V

    return-object v0
.end method
