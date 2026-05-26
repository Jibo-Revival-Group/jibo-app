.class Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "PhotoItemViewHolder"
.end annotation


# instance fields
.field private a:Lcom/jibo/ui/fragment/home/MediaFragment;

.field private b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

.field private c:Z

.field public checkbox:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private d:Lcom/jibo/aws/integration/aws/services/media/model/Media;

.field private e:I

.field private f:F

.field private g:F

.field public photo:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/view/View;Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;Z)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 998
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 1000
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1001
    iput-object p3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    .line 1002
    iput-boolean p4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->c:Z

    .line 1004
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 1006
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->c:Z

    if-eqz v0, :cond_0

    .line 1007
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0}, Landroid/support/v7/widget/RecyclerView;->getWidth()I

    move-result v0

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b()I

    move-result v1

    div-int/2addr v0, v1

    div-int/lit8 v1, v0, 0xf

    .line 1008
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    .line 1009
    invoke-virtual {v0}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 1010
    invoke-virtual {v0, v1, v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 1011
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1013
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;)Lcom/jibo/ui/fragment/home/MediaFragment;
    .locals 1

    .prologue
    .line 975
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    .line 1094
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->c:Z

    if-eqz v0, :cond_2

    .line 1095
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->getAdapterPosition()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->isSelected()Z

    move-result v2

    if-eq v0, v2, :cond_1

    .line 1096
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v2

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    .line 1097
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->getAdapterPosition()I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v0

    if-eqz v0, :cond_3

    iget v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->f:F

    :goto_0
    invoke-virtual {v2, v0}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    .line 1098
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->getAdapterPosition()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v2

    if-eqz v2, :cond_0

    iget v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->g:F

    :cond_0
    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 1099
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 1101
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->getAdapterPosition()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSelected(Z)V

    .line 1103
    :cond_2
    return-void

    :cond_3
    move v0, v1

    .line 1097
    goto :goto_0
.end method

.method public a(I)V
    .locals 0

    .prologue
    .line 1069
    iput p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->e:I

    .line 1070
    return-void
.end method

.method public a(ILcom/jibo/aws/integration/aws/services/media/model/Media;Z)V
    .locals 5

    .prologue
    .line 1016
    iput-object p2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->d:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    .line 1017
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->itemView:Landroid/view/View;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->d:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 1020
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b()I

    move-result v0

    iget v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->e:I

    div-int/2addr v0, v1

    .line 1023
    add-int/lit8 v1, v0, 0x1

    mul-int/lit8 v1, v1, 0x2

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0700e3

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v2

    mul-int/2addr v1, v2

    sub-int v1, p1, v1

    div-int v0, v1, v0

    .line 1026
    int-to-float v1, v0

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->c()F

    move-result v2

    div-float/2addr v1, v2

    float-to-int v1, v1

    .line 1027
    int-to-float v2, v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f070051

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    sub-float/2addr v2, v3

    int-to-float v3, v0

    div-float/2addr v2, v3

    iput v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->f:F

    .line 1028
    int-to-float v2, v1

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f070053

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    sub-float/2addr v2, v3

    int-to-float v3, v1

    div-float/2addr v2, v3

    iput v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->g:F

    .line 1029
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 1030
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1031
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->requestLayout()V

    .line 1034
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(Z)V

    .line 1036
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->d:Lcom/jibo/aws/integration/aws/services/media/model/Media;

    invoke-static {p3, v0}, Lcom/jibo/aws/integration/helpers/MediaHelper;->getUrl(ZLcom/jibo/aws/integration/aws/services/media/model/Media;)Ljava/lang/String;

    move-result-object v0

    .line 1038
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/bumptech/glide/Glide;->b(Landroid/content/Context;)Lcom/bumptech/glide/RequestManager;

    move-result-object v1

    .line 1039
    invoke-virtual {v1, v0}, Lcom/bumptech/glide/RequestManager;->a(Ljava/lang/String;)Lcom/bumptech/glide/DrawableTypeRequest;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder$1;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;)V

    .line 1040
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableTypeRequest;->a(Lcom/bumptech/glide/request/RequestListener;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    .line 1061
    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->a()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    .line 1062
    invoke-virtual {v0}, Lcom/bumptech/glide/DrawableRequestBuilder;->d()Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    sget-object v1, Lcom/bumptech/glide/load/engine/DiskCacheStrategy;->ALL:Lcom/bumptech/glide/load/engine/DiskCacheStrategy;

    .line 1063
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Lcom/bumptech/glide/load/engine/DiskCacheStrategy;)Lcom/bumptech/glide/DrawableRequestBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    .line 1064
    invoke-virtual {v0, v1}, Lcom/bumptech/glide/DrawableRequestBuilder;->a(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/Target;

    .line 1066
    return-void
.end method

.method public a(Z)V
    .locals 8

    .prologue
    const-wide/16 v0, 0xc8

    const-wide/16 v2, 0x0

    const/high16 v4, 0x3f800000    # 1.0f

    .line 1078
    iget-boolean v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->c:Z

    if-eqz v5, :cond_1

    .line 1079
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v5}, Lcom/jibo/ui/fragment/home/MediaFragment;->m(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/activity/TabbedActivity;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/ui/activity/TabbedActivity;->r()Landroid/support/v7/view/ActionMode;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 1080
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    iget-object v6, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->b:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->getAdapterPosition()I

    move-result v7

    invoke-virtual {v6, v7}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setSelected(Z)V

    .line 1081
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1082
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v5

    if-eqz p1, :cond_2

    :goto_0
    invoke-virtual {v5, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    .line 1083
    invoke-virtual {v0}, Landroid/widget/TextView;->isSelected()Z

    move-result v0

    if-eqz v0, :cond_3

    iget v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->f:F

    :goto_1
    invoke-virtual {v1, v0}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    .line 1084
    invoke-virtual {v1}, Landroid/widget/TextView;->isSelected()Z

    move-result v1

    if-eqz v1, :cond_0

    iget v4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->g:F

    :cond_0
    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    .line 1085
    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 1091
    :cond_1
    :goto_2
    return-void

    :cond_2
    move-wide v0, v2

    .line 1082
    goto :goto_0

    :cond_3
    move v0, v4

    .line 1083
    goto :goto_1

    .line 1087
    :cond_4
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->checkbox:Landroid/widget/TextView;

    const/4 v6, 0x4

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1088
    iget-object v5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->photo:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v5

    if-eqz p1, :cond_5

    :goto_3
    invoke-virtual {v5, v0, v1}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleX(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/ViewPropertyAnimator;->scaleY(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    goto :goto_2

    :cond_5
    move-wide v0, v2

    goto :goto_3
.end method
