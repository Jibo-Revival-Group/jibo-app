.class Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "TipVideoViewHolder"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/tips/TipsFragment;

.field contentImage:Landroid/widget/RelativeLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field image:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field text:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/tips/TipsFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    .line 231
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 232
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 233
    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;)V
    .locals 3

    .prologue
    .line 236
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->a:Lcom/jibo/ui/fragment/tips/TipsFragment;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/tips/TipsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 238
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->d()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/Integer;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableTypeRequest;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 240
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;->contentImage:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder$1;-><init>(Lcom/jibo/ui/fragment/tips/TipsFragment$TipVideoViewHolder;Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 250
    return-void
.end method
