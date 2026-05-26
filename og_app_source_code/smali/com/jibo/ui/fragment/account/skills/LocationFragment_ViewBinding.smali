.class public Lcom/jibo/ui/fragment/account/skills/LocationFragment_ViewBinding;
.super Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;
.source "LocationFragment_ViewBinding.java"


# instance fields
.field private b:Lcom/jibo/ui/fragment/account/skills/LocationFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment;Landroid/view/View;)V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    .line 21
    const v0, 0x7f090312

    const-string v1, "field \'txtLocation\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtLocation:Landroid/widget/TextView;

    .line 22
    const v0, 0x7f090316

    const-string v1, "field \'txtTimezone\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    .line 23
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    .line 28
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 29
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    .line 31
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtLocation:Landroid/widget/TextView;

    .line 32
    iput-object v1, v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    .line 34
    invoke-super {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment_ViewBinding;->unbind()V

    .line 35
    return-void
.end method
