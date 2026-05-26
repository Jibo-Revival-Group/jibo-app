.class abstract Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "CaseListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Landroid/view/LayoutInflater;

.field private b:Ljava/util/List;
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
.method constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 48
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a:Landroid/view/LayoutInflater;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    .line 50
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;I)Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;
    .locals 4

    .prologue
    .line 89
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a:Landroid/view/LayoutInflater;

    sget v2, Lcom/salesforce/android/cases/R$layout;->case_list_item:I

    const/4 v3, 0x0

    .line 90
    invoke-virtual {v1, v2, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;Landroid/view/View;)V

    .line 91
    iget-object v1, v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->itemView:Landroid/view/View;

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;

    invoke-direct {v2, p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    return-object v0
.end method

.method a(I)Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;I)V
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;

    invoke-virtual {p1, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V

    .line 104
    return-void
.end method

.method abstract a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
.end method

.method a(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;I)V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p2, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 85
    invoke-virtual {p0, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->notifyItemInserted(I)V

    .line 86
    return-void
.end method

.method a(Ljava/util/List;)V
    .locals 2
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
    .line 57
    new-instance v0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;

    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-direct {v0, v1, p1}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListDiffCallback;-><init>(Ljava/util/List;Ljava/util/List;)V

    .line 58
    invoke-static {v0}, Landroid/support/v7/util/DiffUtil;->a(Landroid/support/v7/util/DiffUtil$Callback;)Landroid/support/v7/util/DiffUtil$DiffResult;

    move-result-object v0

    .line 61
    invoke-virtual {v0, p0}, Landroid/support/v7/util/DiffUtil$DiffResult;->a(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    .line 65
    return-void
.end method

.method b(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 69
    if-ltz v0, :cond_0

    .line 70
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v1, v0, p1}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 71
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->notifyItemChanged(I)V

    .line 73
    :cond_0
    return-void
.end method

.method c(Lcom/salesforce/android/cases/ui/internal/features/caselist/viewmodel/CaseListItemViewModel;)V
    .locals 2

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 77
    if-ltz v0, :cond_0

    .line 78
    iget-object v1, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 79
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->notifyItemRemoved(I)V

    .line 81
    :cond_0
    return-void
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 42
    check-cast p1, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;I)V

    return-void
.end method

.method public synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 42
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter;->a(Landroid/view/ViewGroup;I)Lcom/salesforce/android/cases/ui/internal/features/caselist/CaseListAdapter$ViewHolder;

    move-result-object v0

    return-object v0
.end method
