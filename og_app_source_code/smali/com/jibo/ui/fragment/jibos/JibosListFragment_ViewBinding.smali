.class public Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;
.super Ljava/lang/Object;
.source "JibosListFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    .line 30
    const v0, 0x7f0902cb

    const-string v1, "field \'swipeRefreshLayout\'"

    const-class v2, Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 31
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 32
    const v0, 0x1020004

    const-string v1, "field \'emptyView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->emptyView:Landroid/view/View;

    .line 33
    const v0, 0x7f0901ee

    const-string v1, "field \'fab\' and method \'setUpNewJibo\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 34
    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->fab:Landroid/view/View;

    .line 35
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->c:Landroid/view/View;

    .line 36
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const v0, 0x7f09005c

    const-string v1, "method \'onConnectWifi\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 43
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->d:Landroid/view/View;

    .line 44
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 50
    const v0, 0x7f09006d

    const-string v1, "method \'onInviteInfo\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 51
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->e:Landroid/view/View;

    .line 52
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    .line 64
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JibosListFragment;

    .line 67
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 68
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 69
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->emptyView:Landroid/view/View;

    .line 70
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->fab:Landroid/view/View;

    .line 72
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->c:Landroid/view/View;

    .line 74
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->d:Landroid/view/View;

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment_ViewBinding;->e:Landroid/view/View;

    .line 78
    return-void
.end method
