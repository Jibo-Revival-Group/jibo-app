.class public Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder_ViewBinding;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;
.source "ViewHolders$ConnectableViewHolder_ViewBinding.java"


# instance fields
.field private target:Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;-><init>(Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;Landroid/view/View;)V

    .line 19
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;

    .line 21
    const v0, 0x1020010

    const-string v1, "field \'summary\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->summary:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 22
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 26
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;

    .line 27
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 28
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;

    .line 30
    iput-object v1, v0, Lcom/jibo/ui/helpers/skills/ViewHolders$ConnectableViewHolder;->summary:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 32
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;->unbind()V

    .line 33
    return-void
.end method
