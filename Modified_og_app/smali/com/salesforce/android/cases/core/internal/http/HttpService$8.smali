.class Lcom/salesforce/android/cases/core/internal/http/HttpService$8;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;",
        "Lcom/salesforce/android/cases/core/model/CaseDetailRecord;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V
    .locals 0

    .prologue
    .line 283
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$8;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)Lcom/salesforce/android/cases/core/model/CaseDetailRecord;
    .locals 1

    .prologue
    .line 285
    invoke-static {p1}, Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;->a(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)Lcom/salesforce/android/cases/core/internal/model/CaseDetailRecordModel;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 283
    check-cast p1, Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$8;->a(Lcom/salesforce/android/cases/core/internal/http/response/CaseDetailResponse;)Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    move-result-object v0

    return-object v0
.end method
