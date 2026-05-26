.class public Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;
.source "JiboPreparationsFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x1020027

    .line 28
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;Landroid/view/View;)V

    .line 30
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    .line 33
    const-string v0, "field \'closeButton\' and method \'onCloseClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 34
    const-string v0, "field \'closeButton\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->closeButton:Landroid/widget/ImageView;

    .line 35
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->c:Landroid/view/View;

    .line 36
    new-instance v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const v0, 0x102000d

    const-string v1, "field \'progressView\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->progressView:Landroid/view/View;

    .line 43
    const v0, 0x1020006

    const-string v1, "field \'checkmarkImage\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    .line 44
    const v0, 0x7f09005e

    const-string v1, "method \'btnNextScreenClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 45
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->d:Landroid/view/View;

    .line 46
    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    const v0, 0x7f09007e

    const-string v1, "method \'btnNextScreenClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 53
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->e:Landroid/view/View;

    .line 54
    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$3;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 60
    const v0, 0x7f09007f

    const-string v1, "method \'btnNextScreenClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 61
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->f:Landroid/view/View;

    .line 62
    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$4;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$4;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    const v0, 0x7f09006c

    const-string v1, "method \'btnNextScreenClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 69
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->g:Landroid/view/View;

    .line 70
    new-instance v1, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$5;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding$5;-><init>(Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    .line 81
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 82
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    .line 84
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->closeButton:Landroid/widget/ImageView;

    .line 85
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->progressView:Landroid/view/View;

    .line 86
    iput-object v1, v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;->checkmarkImage:Landroid/widget/ImageView;

    .line 88
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->c:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 91
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->d:Landroid/view/View;

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->e:Landroid/view/View;

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->f:Landroid/view/View;

    .line 96
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment_ViewBinding;->g:Landroid/view/View;

    .line 99
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment_ViewBinding;->unbind()V

    .line 100
    return-void
.end method
