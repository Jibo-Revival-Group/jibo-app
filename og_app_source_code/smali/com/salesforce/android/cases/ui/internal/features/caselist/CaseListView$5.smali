.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;
.super Landroid/support/design/widget/Snackbar$Callback;
.source "CaseListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
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
    .line 218
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-direct {p0}, Landroid/support/design/widget/Snackbar$Callback;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/design/widget/Snackbar;)V
    .locals 2

    .prologue
    .line 222
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;I)I

    .line 223
    return-void
.end method

.method public a(Landroid/support/design/widget/Snackbar;I)V
    .locals 2

    .prologue
    .line 228
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;I)I

    .line 229
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o:Landroid/support/design/widget/Snackbar;

    .line 230
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 218
    check-cast p1, Landroid/support/design/widget/Snackbar;

    invoke-virtual {p0, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a(Landroid/support/design/widget/Snackbar;)V

    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;I)V
    .locals 0

    .prologue
    .line 218
    check-cast p1, Landroid/support/design/widget/Snackbar;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$5;->a(Landroid/support/design/widget/Snackbar;I)V

    return-void
.end method
