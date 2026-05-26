.class public Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OauthViewHolder"
.end annotation


# instance fields
.field public icon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 287
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 288
    return-void
.end method


# virtual methods
.method protected bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 281
    invoke-virtual {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$OauthItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public invalidateView()V
    .locals 2

    .prologue
    .line 292
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->invalidateView()V

    .line 294
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$OauthItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    const-string v1, "google"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 295
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->icon:Landroid/widget/ImageView;

    const v1, 0x7f080105

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 300
    :cond_0
    :goto_0
    return-void

    .line 296
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$OauthItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$OauthItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    const-string v1, "outlook"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 297
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$OauthViewHolder;->icon:Landroid/widget/ImageView;

    const v1, 0x7f08021a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
