.class Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;
.super Landroid/support/v7/widget/RecyclerView$ViewHolder;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "HeaderViewHolder"
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;

.field public selectAll:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public text1:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/view/View;Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 948
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 949
    invoke-direct {p0, p2}, Landroid/support/v7/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 950
    invoke-static {p0, p2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 951
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    invoke-virtual {v0, p3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 952
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 961
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 963
    iget v1, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    :goto_0
    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt v1, v3, :cond_2

    .line 964
    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/home/MediaFragment;->b(Lcom/jibo/ui/fragment/home/MediaFragment;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a(I)Z

    move-result v3

    if-nez v3, :cond_0

    .line 965
    const/4 v0, 0x1

    .line 970
    :goto_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    if-eqz v0, :cond_1

    :goto_2
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 971
    return-void

    .line 963
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 970
    :cond_1
    const/4 v2, 0x4

    goto :goto_2

    :cond_2
    move v0, v2

    goto :goto_1
.end method

.method public a(Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;)V
    .locals 2

    .prologue
    .line 955
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->text1:Landroid/widget/TextView;

    iget-object v1, p1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 956
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->selectAll:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 957
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->a()V

    .line 958
    return-void
.end method
