.class Lcom/salesforce/android/cases/core/internal/http/HttpService$6;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/http/HttpService;->a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$6;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 252
    check-cast p1, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$6;->a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 254
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 256
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecordResponse;->a()Ljava/util/List;

    move-result-object v0

    .line 255
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;

    .line 257
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;)Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 259
    :cond_0
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
