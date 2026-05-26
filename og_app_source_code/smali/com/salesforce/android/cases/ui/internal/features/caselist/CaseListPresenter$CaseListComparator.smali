.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;
.super Ljava/lang/Object;
.source "CaseListPresenter.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CaseListComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 311
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$1;)V
    .locals 0

    .prologue
    .line 311
    invoke-direct {p0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)I
    .locals 2

    .prologue
    .line 313
    invoke-virtual {p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g()Ljava/util/Date;

    move-result-object v0

    .line 314
    invoke-virtual {p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;->g()Ljava/util/Date;

    move-result-object v1

    .line 315
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 316
    :cond_0
    const/4 v0, -0x1

    .line 318
    :goto_0
    return v0

    :cond_1
    invoke-virtual {v1, v0}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v0

    goto :goto_0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 311
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    check-cast p2, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListPresenter$CaseListComparator;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)I

    move-result v0

    return v0
.end method
