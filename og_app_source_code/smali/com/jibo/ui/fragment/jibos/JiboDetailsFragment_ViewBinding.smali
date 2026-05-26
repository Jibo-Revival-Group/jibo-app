.class public Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "JiboDetailsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 29
    const v0, 0x7f0902cb

    const-string v1, "field \'swipeRefreshLayout\'"

    const-class v2, Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/SwipeRefreshLayout;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 30
    const v0, 0x102000a

    const-string v1, "field \'list\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 31
    const v0, 0x7f0901cc

    const-string v1, "field \'loopSuspendedView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->loopSuspendedView:Landroid/view/View;

    .line 32
    const v0, 0x7f090082

    const-string v1, "field \'btnReconnectToJibo\' and method \'reconnectToJiboClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 33
    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->btnReconnectToJibo:Landroid/view/View;

    .line 34
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->c:Landroid/view/View;

    .line 35
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    const v0, 0x7f09030b

    const-string v1, "field \'tutorialTitleContainer\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitleContainer:Landroid/view/View;

    .line 42
    const v0, 0x7f09030a

    const-string v1, "field \'tutorialTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitle:Landroid/widget/TextView;

    .line 43
    const v0, 0x7f0900ff

    const-string v1, "method \'onCustomerCareClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 44
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->d:Landroid/view/View;

    .line 45
    new-instance v1, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 57
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    .line 60
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    .line 62
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->loopSuspendedView:Landroid/view/View;

    .line 63
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->btnReconnectToJibo:Landroid/view/View;

    .line 64
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitleContainer:Landroid/view/View;

    .line 65
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;->tutorialTitle:Landroid/widget/TextView;

    .line 67
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->c:Landroid/view/View;

    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment_ViewBinding;->d:Landroid/view/View;

    .line 71
    return-void
.end method
