.class public Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder_ViewBinding;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;
.source "ViewHolders$OauthViewHolder_ViewBinding.java"


# instance fields
.field private target:Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;-><init>(Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;Landroid/view/View;)V

    .line 18
    iput-object p1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;

    .line 20
    const v0, 0x1020006

    const-string v1, "field \'icon\'"

    const-class v2, Landroid/widget/ImageView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p1, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->icon:Landroid/widget/ImageView;

    .line 21
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 25
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;

    .line 26
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 27
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder_ViewBinding;->target:Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;

    .line 29
    iput-object v1, v0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->icon:Landroid/widget/ImageView;

    .line 31
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder_ViewBinding;->unbind()V

    .line 32
    return-void
.end method
