.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;
.super Ljava/lang/Object;
.source "CaseListView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->k()V
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
    .line 151
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 153
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->o()V

    .line 154
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListView;->m:Landroid/support/design/widget/Snackbar;

    .line 155
    return-void
.end method
