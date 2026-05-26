.class Lcom/jibo/ui/fragment/home/MediaFragment$4;
.super Landroid/support/v7/widget/RecyclerView$OnScrollListener;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$OnScrollListener;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/widget/RecyclerView;II)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 459
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v2, v2, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v2}, Landroid/support/v7/widget/RecyclerView;->getChildCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v0

    .line 462
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->i(Lcom/jibo/ui/fragment/home/MediaFragment;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 463
    invoke-static {v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->g(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemCount()I

    move-result v1

    add-int/lit8 v0, v0, 0x2

    if-gt v1, v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 464
    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->j(Lcom/jibo/ui/fragment/home/MediaFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    if-lez p3, :cond_1

    .line 465
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0, v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;Z)Z

    .line 467
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->k(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 468
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->k(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->cancel(Z)Z

    .line 470
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    new-instance v1, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-direct {v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;)V

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment;->a(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    .line 471
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$4;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/home/MediaFragment;->k(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$PaginationAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 474
    :cond_1
    return-void
.end method
