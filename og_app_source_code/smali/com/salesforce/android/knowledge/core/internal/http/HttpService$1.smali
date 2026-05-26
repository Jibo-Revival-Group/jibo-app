.class Lcom/salesforce/android/knowledge/core/internal/http/HttpService$1;
.super Ljava/lang/Object;
.source "HttpService.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;",
        "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$1;->a:Lcom/salesforce/android/knowledge/core/internal/http/HttpService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;)Lcom/salesforce/android/knowledge/core/model/ArticleDetails;
    .locals 1

    .prologue
    .line 183
    invoke-static {p1}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleDetailsModel;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 181
    check-cast p1, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService$1;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;)Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    move-result-object v0

    return-object v0
.end method
