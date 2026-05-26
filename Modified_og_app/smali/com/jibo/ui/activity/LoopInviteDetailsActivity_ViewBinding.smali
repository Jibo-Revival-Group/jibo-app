.class public Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;
.super Lcom/jibo/ui/activity/BaseActivity_ViewBinding;
.source "LoopInviteDetailsActivity_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V
    .locals 1

    .prologue
    .line 22
    invoke-virtual {p1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Landroid/view/View;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;-><init>(Lcom/jibo/ui/activity/BaseActivity;Landroid/view/View;)V

    .line 30
    iput-object p1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    .line 33
    const v0, 0x7f0900a2

    const-string v1, "field \'buttonAccept\' and method \'onJoinClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 34
    iput-object v0, p1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    .line 35
    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->c:Landroid/view/View;

    .line 36
    new-instance v1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$1;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const v0, 0x7f0900a4

    const-string v1, "field \'buttonDecline\' and method \'onDeclineClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 43
    iput-object v0, p1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    .line 44
    iput-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->d:Landroid/view/View;

    .line 45
    new-instance v1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding$2;-><init>(Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;Lcom/jibo/ui/activity/LoopInviteDetailsActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 51
    const v0, 0x7f090239

    const-string v1, "field \'recyclerView\'"

    const-class v2, Landroid/support/v7/widget/RecyclerView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/RecyclerView;

    iput-object v0, p1, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    .line 52
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    .line 57
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->b:Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    .line 60
    iput-object v1, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonAccept:Landroid/view/View;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->buttonDecline:Landroid/view/View;

    .line 62
    iput-object v1, v0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;->recyclerView:Landroid/support/v7/widget/RecyclerView;

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iput-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->c:Landroid/view/View;

    .line 66
    iget-object v0, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 67
    iput-object v1, p0, Lcom/jibo/ui/activity/LoopInviteDetailsActivity_ViewBinding;->d:Landroid/view/View;

    .line 69
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity_ViewBinding;->unbind()V

    .line 70
    return-void
.end method
