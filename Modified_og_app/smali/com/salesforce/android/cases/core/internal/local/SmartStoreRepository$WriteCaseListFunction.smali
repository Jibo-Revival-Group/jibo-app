.class Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;
.super Ljava/lang/Object;
.source "SmartStoreRepository.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "WriteCaseListFunction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lorg/json/JSONArray;",
        "Lcom/salesforce/android/service/common/utilities/control/Async",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field private final a:Lcom/google/gson/Gson;


# direct methods
.method constructor <init>(Lcom/google/gson/Gson;)V
    .locals 0

    .prologue
    .line 600
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 601
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;->a:Lcom/google/gson/Gson;

    .line 602
    return-void
.end method


# virtual methods
.method public a(Lorg/json/JSONArray;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONArray;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 605
    new-instance v0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction$1;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction$1;-><init>(Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;)V

    .line 606
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v0

    .line 607
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;->a:Lcom/google/gson/Gson;

    invoke-virtual {p1}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 609
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 610
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot retrieve case list, List empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Throwable;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    .line 612
    :goto_0
    return-object v0

    :cond_1
    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/control/BasicAsync;->c(Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/BasicAsync;

    move-result-object v0

    goto :goto_0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 597
    check-cast p1, Lorg/json/JSONArray;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/core/internal/local/SmartStoreRepository$WriteCaseListFunction;->a(Lorg/json/JSONArray;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method
