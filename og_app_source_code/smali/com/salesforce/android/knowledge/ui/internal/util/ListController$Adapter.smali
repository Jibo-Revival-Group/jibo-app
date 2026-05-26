.class public Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "ListController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Adapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">",
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/knowledge/ui/internal/util/ListController",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 93
    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/knowledge/ui/internal/util/ListController;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/ui/internal/util/ListController",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 96
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    .line 97
    return-void
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a()I

    move-result v0

    return v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->b(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a(I)I

    move-result v0

    return v0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;I)V"
        }
    .end annotation

    .prologue
    .line 104
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    .line 105
    return-void
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TT;"
        }
    .end annotation

    .prologue
    .line 100
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public onViewRecycled(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 116
    iget-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/util/ListController$Adapter;->a:Lcom/salesforce/android/knowledge/ui/internal/util/ListController;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/knowledge/ui/internal/util/ListController;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V

    .line 117
    return-void
.end method
