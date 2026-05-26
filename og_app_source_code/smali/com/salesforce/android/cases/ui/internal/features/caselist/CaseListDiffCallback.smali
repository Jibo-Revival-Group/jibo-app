.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;
.super Landroid/support/v7/util/DiffUtil$Callback;
.source "CaseListDiffCallback.java"


# instance fields
.field private final a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

.field private final b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/support/v7/util/DiffUtil$Callback;-><init>()V

    .line 38
    const-class v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogging;->a(Ljava/lang/Class;)Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    .line 45
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->b:Ljava/util/List;

    .line 46
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->c:Ljava/util/List;

    .line 47
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public a(II)Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 58
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->a()Lcom/salesforce/android/cases/core/model/CaseListRecord;

    move-result-object v3

    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->c:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->a()Lcom/salesforce/android/cases/core/model/CaseListRecord;

    move-result-object v0

    .line 61
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3}, Lcom/salesforce/android/cases/core/model/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    .line 62
    :goto_0
    iget-object v3, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v4, "old {}, new {}, areItemsTheSame: {}"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v5, v1

    const/4 v1, 0x2

    .line 63
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v5, v1

    .line 62
    invoke-interface {v3, v4, v5}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 64
    return v0

    :cond_0
    move v0, v2

    .line 61
    goto :goto_0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public b(II)Z
    .locals 6

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    .line 69
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->c:Ljava/util/List;

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    .line 70
    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 71
    if-nez v0, :cond_0

    .line 72
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;->a:Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;

    const-string v2, "Case List Contents Differ: old {}, new {}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-interface {v1, v2, v3}, Lcom/salesforce/android/service/common/utilities/logging/ServiceLogger;->b(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 74
    :cond_0
    return v0
.end method
