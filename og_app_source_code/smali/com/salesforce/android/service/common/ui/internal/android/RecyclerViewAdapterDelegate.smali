.class public Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "RecyclerViewAdapterDelegate.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<VH:",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<TVH;>;",
        "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter",
        "<TVH;>;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter",
            "<TVH;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter",
            "<TVH;>;)V"
        }
    .end annotation

    .prologue
    .line 56
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    .line 57
    return-void
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->getItemCount()I

    move-result v0

    return v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->getItemId(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->getItemViewType(I)I

    move-result v0

    return v0
.end method

.method public onAttachedToRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->onAttachedToRecyclerView(Landroid/support/v7/widget/RecyclerView;)V

    .line 91
    return-void
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    .line 86
    return-void
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TVH;"
        }
    .end annotation

    .prologue
    .line 79
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1, p2}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public onDetachedFromRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-static {v0}, Lcom/salesforce/android/service/common/utilities/validation/Arguments;->a(Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;

    invoke-interface {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;->onDetachedFromRecyclerView(Landroid/support/v7/widget/RecyclerView;)V

    .line 96
    return-void
.end method
