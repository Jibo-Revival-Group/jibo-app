.class public Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "NoLoopsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    .line 26
    const v0, 0x1020006

    const-string v1, "field \'icon\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;->icon:Landroid/view/View;

    .line 27
    const v0, 0x7f09005c

    const-string v1, "method \'onConnectWifi\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 28
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->c:Landroid/view/View;

    .line 29
    new-instance v1, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    const v0, 0x7f09006d

    const-string v1, "method \'onInviteInfo\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 36
    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->d:Landroid/view/View;

    .line 37
    new-instance v1, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    .line 49
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;

    .line 52
    iput-object v1, v0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment;->icon:Landroid/view/View;

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->c:Landroid/view/View;

    .line 56
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/NoLoopsFragment_ViewBinding;->d:Landroid/view/View;

    .line 58
    return-void
.end method
