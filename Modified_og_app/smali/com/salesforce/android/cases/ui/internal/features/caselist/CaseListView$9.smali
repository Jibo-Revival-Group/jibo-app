.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;
.super Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;
.source "CaseListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->u()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V
    .locals 0

    .prologue
    .line 385
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public a(II)V
    .locals 1

    .prologue
    .line 387
    if-nez p1, :cond_0

    .line 388
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 390
    :cond_0
    return-void
.end method

.method public b(II)V
    .locals 1

    .prologue
    .line 393
    if-nez p1, :cond_0

    .line 394
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$9;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-static {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->b(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;)V

    .line 396
    :cond_0
    return-void
.end method
