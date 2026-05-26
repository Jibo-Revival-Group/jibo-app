.class Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;
.super Ljava/lang/Object;
.source "CasePublisherPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;->a(Lcom/salesforce/android/cases/core/model/DefaultValues;)Lcom/salesforce/android/service/common/utilities/control/Async;
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
        "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
        "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/core/model/DefaultValues;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;Lcom/salesforce/android/cases/core/model/DefaultValues;)V
    .locals 0

    .prologue
    .line 451
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;->b:Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;->a:Lcom/salesforce/android/cases/core/model/DefaultValues;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)Lcom/salesforce/android/cases/core/model/CaseLayoutData;
    .locals 4

    .prologue
    .line 453
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;->a:Lcom/salesforce/android/cases/core/model/DefaultValues;

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/DefaultValues;->a()Ljava/util/Map;

    move-result-object v2

    .line 455
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CaseLayoutData;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/CaseField;

    .line 456
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 457
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseField;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 461
    :cond_1
    return-object p1
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 451
    check-cast p1, Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/CasePublisherPresenter$CaseLayoutDataHandler$1$1;->a(Lcom/salesforce/android/cases/core/model/CaseLayoutData;)Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    move-result-object v0

    return-object v0
.end method
