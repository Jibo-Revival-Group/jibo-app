.class public Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "CongratsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/invite/CongratsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/CongratsFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    .line 28
    const v0, 0x7f0902fb

    const-string v1, "field \'title\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/CongratsFragment;->title:Landroid/widget/TextView;

    .line 29
    const v0, 0x7f0902d6

    const-string v1, "field \'text\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/CongratsFragment;->text:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f090325

    const-string v1, "field \'video\'"

    const-class v2, Landroid/widget/VideoView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/VideoView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/CongratsFragment;->video:Landroid/widget/VideoView;

    .line 31
    const v0, 0x7f090097

    const-string v1, "method \'onViewMyLoop\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 32
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->c:Landroid/view/View;

    .line 33
    new-instance v1, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/CongratsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 39
    const v0, 0x7f090063

    const-string v1, "method \'onDontShowAgain\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 40
    iput-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->d:Landroid/view/View;

    .line 41
    new-instance v1, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;Lcom/jibo/ui/fragment/invite/CongratsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 52
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    .line 53
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/CongratsFragment;

    .line 56
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->title:Landroid/widget/TextView;

    .line 57
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->text:Landroid/widget/TextView;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/CongratsFragment;->video:Landroid/widget/VideoView;

    .line 60
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 61
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->c:Landroid/view/View;

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/CongratsFragment_ViewBinding;->d:Landroid/view/View;

    .line 64
    return-void
.end method
