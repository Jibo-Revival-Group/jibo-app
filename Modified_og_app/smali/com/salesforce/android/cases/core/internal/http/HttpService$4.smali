.class Lcom/salesforce/android/cases/core/internal/http/HttpService$4;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/core/internal/http/HttpService;->b()Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/ListView;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/HttpService;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/http/HttpService$4;->a:Lcom/salesforce/android/cases/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 222
    check-cast p1, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/http/HttpService$4;->a(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListView;",
            ">;"
        }
    .end annotation

    .prologue
    .line 224
    new-instance v1, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;->b()I

    move-result v0

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 225
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;

    .line 226
    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/model/ListViewModel;->a(Lcom/salesforce/android/cases/core/internal/http/response/ListViewsResponse$ListView;)Lcom/salesforce/android/cases/core/internal/model/ListViewModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 228
    :cond_0
    return-object v1
.end method
