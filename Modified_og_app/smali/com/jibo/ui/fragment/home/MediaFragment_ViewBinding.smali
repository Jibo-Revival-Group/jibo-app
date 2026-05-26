.class public Lcom/jibo/ui/fragment/home/MediaFragment_ViewBinding;
.super Ljava/lang/Object;
.source "MediaFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/home/MediaFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 22
    const v0, 0x7f0902cb

    const-string v1, "field \'swipeRefreshLayout\'"

    const-class v2, Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 23
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 24
    const v0, 0x1020004

    const-string v1, "field \'emptyView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment;->emptyView:Landroid/view/View;

    .line 25
    const v0, 0x7f090328

    const-string v1, "field \'viewNoKey\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment;->viewNoKey:Landroid/view/View;

    .line 26
    const v0, 0x102000d

    const-string v1, "field \'progressView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment;->progressView:Landroid/view/View;

    .line 27
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 32
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 33
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 34
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->emptyView:Landroid/view/View;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->viewNoKey:Landroid/view/View;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->progressView:Landroid/view/View;

    .line 41
    return-void
.end method
