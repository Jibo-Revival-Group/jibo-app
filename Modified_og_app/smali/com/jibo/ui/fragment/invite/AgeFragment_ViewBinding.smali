.class public Lcom/jibo/ui/fragment/invite/AgeFragment_ViewBinding;
.super Ljava/lang/Object;
.source "AgeFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/invite/AgeFragment;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/invite/AgeFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/fragment/invite/AgeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/AgeFragment;

    .line 21
    const v0, 0x7f090233

    const-string v1, "field \'mTeenageOrAdult\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/AgeFragment;->mTeenageOrAdult:Landroid/widget/RadioButton;

    .line 22
    const v0, 0x7f090234

    const-string v1, "field \'mChild\'"

    const-class v2, Landroid/widget/RadioButton;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p1, Lcom/jibo/ui/fragment/invite/AgeFragment;->mChild:Landroid/widget/RadioButton;

    .line 23
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/invite/AgeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/AgeFragment;

    .line 29
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 30
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/invite/AgeFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/invite/AgeFragment;

    .line 32
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mTeenageOrAdult:Landroid/widget/RadioButton;

    .line 33
    iput-object v1, v0, Lcom/jibo/ui/fragment/invite/AgeFragment;->mChild:Landroid/widget/RadioButton;

    .line 34
    return-void
.end method
