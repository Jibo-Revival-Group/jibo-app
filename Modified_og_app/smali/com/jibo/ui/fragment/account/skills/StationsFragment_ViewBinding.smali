.class public Lcom/jibo/ui/fragment/account/skills/StationsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "StationsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/skills/StationsFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 24
    const v0, 0x7f0902cb

    const-string v1, "field \'swipeRefreshLayout\'"

    const-class v2, Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 25
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 26
    const v0, 0x1020004

    const-string v1, "field \'emptyView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyView:Landroid/view/View;

    .line 27
    const v0, 0x1020016

    const-string v1, "field \'emptyViewTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTitle:Landroid/widget/TextView;

    .line 28
    const v0, 0x1020006

    const-string v1, "field \'emptyViewIcon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewIcon:Landroid/widget/ImageView;

    .line 29
    const v0, 0x1020014

    const-string v1, "field \'emptyViewTextInfo\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTextInfo:Landroid/widget/TextView;

    .line 30
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 35
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 36
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 37
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/StationsFragment;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 41
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyView:Landroid/view/View;

    .line 42
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTitle:Landroid/widget/TextView;

    .line 43
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewIcon:Landroid/widget/ImageView;

    .line 44
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/StationsFragment;->emptyViewTextInfo:Landroid/widget/TextView;

    .line 45
    return-void
.end method
