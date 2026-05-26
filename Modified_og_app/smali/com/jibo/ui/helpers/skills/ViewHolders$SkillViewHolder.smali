.class public Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;
.super Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/skills/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SkillViewHolder"
.end annotation


# instance fields
.field protected icon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;Z)V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;-><init>(Landroid/view/View;Z)V

    .line 92
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 96
    invoke-super {p0}, Lcom/jibo/ui/helpers/skills/ViewHolders$AbstractSkillViewHolder;->invalidateView()V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->isExternal(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 101
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 102
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->icon:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 109
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->getImageForUrl(Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 105
    iget-object v1, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/skills/ViewHolders$SkillViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/skills/Items$SkillItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/Items$SkillItem;->getIcon()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser$ImageUrlMatcher;->getImageForUrl(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
