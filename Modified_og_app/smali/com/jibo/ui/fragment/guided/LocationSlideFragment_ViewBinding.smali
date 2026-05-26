.class public Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;
.source "LocationSlideFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment;Landroid/view/View;)V

    .line 23
    iput-object p1, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    .line 26
    const v0, 0x7f0902d6

    const-string v1, "field \'topText\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->topText:Landroid/widget/TextView;

    .line 27
    const v0, 0x7f0902d7

    const-string v1, "field \'text2\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->text2:Landroid/widget/TextView;

    .line 28
    const v0, 0x7f09008f

    const-string v1, "method \'btnSetLocationClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 29
    iput-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->c:Landroid/view/View;

    .line 30
    new-instance v1, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;Lcom/jibo/ui/fragment/guided/LocationSlideFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    .line 41
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 42
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/guided/LocationSlideFragment;

    .line 44
    iput-object v1, v0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->topText:Landroid/widget/TextView;

    .line 45
    iput-object v1, v0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment;->text2:Landroid/widget/TextView;

    .line 47
    iget-object v0, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 48
    iput-object v1, p0, Lcom/jibo/ui/fragment/guided/LocationSlideFragment_ViewBinding;->c:Landroid/view/View;

    .line 50
    invoke-super {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->unbind()V

    .line 51
    return-void
.end method
