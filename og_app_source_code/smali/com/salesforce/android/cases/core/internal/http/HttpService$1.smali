.class Lcom/salesforce/android/cases/core/internal/http/HttpService$1;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;",
        "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$1;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)Lcom/salesforce/android/cases/core/model/CaseLayoutData;
    .locals 1

    .prologue
    .line 182
    invoke-static {p1}, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->a(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 180
    check-cast p1, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$1;->a(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    move-result-object v0

    return-object v0
.end method
