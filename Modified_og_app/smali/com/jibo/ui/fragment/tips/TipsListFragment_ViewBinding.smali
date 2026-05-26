.class public Lcom/jibo/ui/fragment/tips/TipsListFragment_ViewBinding;
.super Ljava/lang/Object;
.source "TipsListFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/tips/TipsListFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsListFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    .line 20
    const v0, 0x7f0902ee

    const-string v1, "field \'tip0\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip0:Landroid/view/View;

    .line 21
    const v0, 0x7f0902ef

    const-string v1, "field \'tip1\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip1:Landroid/view/View;

    .line 22
    const v0, 0x7f0902f0

    const-string v1, "field \'tip2\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip2:Landroid/view/View;

    .line 23
    const v0, 0x7f0902f1

    const-string v1, "field \'tip3\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip3:Landroid/view/View;

    .line 24
    const v0, 0x7f0902f2

    const-string v1, "field \'tip4\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip4:Landroid/view/View;

    .line 25
    const v0, 0x7f0902f3

    const-string v1, "field \'tip5\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p1, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip5:Landroid/view/View;

    .line 26
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 31
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    .line 32
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 33
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsListFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/tips/TipsListFragment;

    .line 35
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip0:Landroid/view/View;

    .line 36
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip1:Landroid/view/View;

    .line 37
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip2:Landroid/view/View;

    .line 38
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip3:Landroid/view/View;

    .line 39
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip4:Landroid/view/View;

    .line 40
    iput-object v1, v0, Lcom/jibo/ui/fragment/tips/TipsListFragment;->tip5:Landroid/view/View;

    .line 41
    return-void
.end method
