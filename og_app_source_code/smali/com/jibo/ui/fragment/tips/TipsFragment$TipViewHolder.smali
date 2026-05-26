.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TipViewHolder"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field image:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field imageAboveTitle:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field title:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 197
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 198
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 199
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 200
    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;)V
    .locals 6

    .prologue
    const/16 v1, 0x8

    const/4 v2, 0x0

    const/4 v5, -0x1

    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->text:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c()I

    move-result v4

    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 204
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 206
    iget-object v3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e()I

    move-result v0

    if-ne v0, v5, :cond_2

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 207
    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e()I

    move-result v0

    if-eq v0, v5, :cond_0

    .line 208
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->imageAboveTitle:Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->f()I

    move-result v3

    if-ne v3, v5, :cond_3

    :goto_1
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 213
    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->f()I

    move-result v0

    if-eq v0, v5, :cond_1

    .line 214
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->f()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipViewHolder;->imageAboveTitle:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 216
    :cond_1
    return-void

    :cond_2
    move v0, v2

    .line 206
    goto :goto_0

    :cond_3
    move v1, v2

    .line 211
    goto :goto_1
.end method
