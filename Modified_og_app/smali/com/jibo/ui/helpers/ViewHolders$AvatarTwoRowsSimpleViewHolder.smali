.class public Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvatarTwoRowsSimpleViewHolder"
.end annotation


# instance fields
.field public icon:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 146
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 147
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 151
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->invalidateView()V

    .line 152
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->c()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    .line 154
    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->e()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 155
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->icon:Landroid/widget/ImageView;

    .line 156
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 163
    :goto_0
    return-void

    .line 157
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->d()I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_1

    .line 158
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$AvatarTwoRowsSimpleItem;->d()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 160
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$AvatarTwoRowsSimpleViewHolder;->icon:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method
