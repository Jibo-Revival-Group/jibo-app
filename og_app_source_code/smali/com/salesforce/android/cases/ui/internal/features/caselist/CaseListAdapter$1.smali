.class Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;
.super Ljava/lang/Object;
.source "CaseListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Landroid/view/ViewGroup;I)Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

.field final synthetic b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 93
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;->a:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->getAdapterPosition()I

    move-result v0

    .line 94
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 95
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    iget-object v2, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;->b:Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;

    invoke-static {v2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 97
    :cond_0
    return-void
.end method
