.class public Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;
.super Ljava/lang/Object;
.source "AvatarBaseFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/AvatarBaseFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/AvatarBaseFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f09004a

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    .line 26
    const-string v0, "field \'avatar\' and method \'onAvatarClick\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 27
    const-string v0, "field \'avatar\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    .line 28
    iput-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->c:Landroid/view/View;

    .line 29
    new-instance v0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;Lcom/jibo/ui/fragment/AvatarBaseFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    const v0, 0x7f09020f

    const-string v1, "field \'photoProgressBar\'"

    const-class v2, Landroid/widget/ProgressBar;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p1, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    .line 36
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 41
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    .line 42
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/AvatarBaseFragment;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->avatar:Landroid/widget/ImageView;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/fragment/AvatarBaseFragment;->photoProgressBar:Landroid/widget/ProgressBar;

    .line 48
    iget-object v0, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    iput-object v1, p0, Lcom/jibo/ui/fragment/AvatarBaseFragment_ViewBinding;->c:Landroid/view/View;

    .line 50
    return-void
.end method
