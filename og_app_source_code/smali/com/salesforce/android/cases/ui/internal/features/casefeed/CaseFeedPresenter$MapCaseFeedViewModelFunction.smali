.class Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;
.super Ljava/lang/Object;
.source "CaseFeedPresenter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/utilities/functional/Function;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MapCaseFeedViewModelFunction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/utilities/functional/Function",
        "<",
        "Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;",
        "Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 231
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 232
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;->a:Landroid/content/Context;

    .line 233
    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;)Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;
    .locals 6

    .prologue
    .line 236
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->g()Lcom/salesforce/android/cases/core/model/DefaultValues;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/DefaultValues;->a()Ljava/util/Map;

    move-result-object v2

    .line 238
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->f()Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseLayoutData;->a()Ljava/util/List;

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

    .line 239
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 240
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseField;->a()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/salesforce/android/cases/core/model/CaseField;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 244
    :cond_1
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;->a:Landroid/content/Context;

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->e()Lcom/salesforce/android/cases/core/model/CaseDetailRecord;

    move-result-object v2

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->f()Lcom/salesforce/android/cases/core/model/CaseLayoutData;

    move-result-object v3

    .line 245
    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->d()Lcom/salesforce/android/cases/core/model/CaseFeed;

    move-result-object v4

    invoke-interface {p1}, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;->c()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;-><init>(Landroid/content/Context;Lcom/salesforce/android/cases/core/model/CaseDetailRecord;Lcom/salesforce/android/cases/core/model/CaseLayoutData;Lcom/salesforce/android/cases/core/model/CaseFeed;Ljava/lang/String;)V

    .line 244
    return-object v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 226
    check-cast p1, Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/casefeed/CaseFeedPresenter$MapCaseFeedViewModelFunction;->a(Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;)Lcom/salesforce/android/cases/ui/internal/features/casefeed/viewmodel/CaseFeedViewModel;

    move-result-object v0

    return-object v0
.end method
