.class public Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;
.super Ljava/lang/Object;
.source "CaseLayoutDataModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseLayoutData;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)V
    .locals 5

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    if-nez p1, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "QuickActionResponse cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->a:Ljava/lang/String;

    .line 47
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->b:Ljava/lang/String;

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->c:Ljava/util/List;

    .line 50
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;->b()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 51
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;

    .line 52
    if-eqz v0, :cond_2

    .line 53
    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->c:Ljava/util/List;

    new-instance v4, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;

    invoke-direct {v4, v0}, Lcom/salesforce/android/cases/core/internal/model/CaseFieldModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse$LayoutItem;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 57
    :cond_3
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;
    .locals 1

    .prologue
    .line 60
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/QuickActionResponse;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/salesforce/android/cases/core/model/CaseField;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseLayoutDataModel;->c:Ljava/util/List;

    return-object v0
.end method
