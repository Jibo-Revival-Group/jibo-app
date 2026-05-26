.class public Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;
.super Ljava/lang/Object;
.source "CaseListViewModel.java"


# instance fields
.field private a:Ljava/util/List;
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
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a:Ljava/util/List;

    .line 36
    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 39
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListViewModel;->a:Ljava/util/List;

    return-object v0
.end method
