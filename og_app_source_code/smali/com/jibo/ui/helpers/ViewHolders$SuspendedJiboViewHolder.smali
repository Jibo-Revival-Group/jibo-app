.class public Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuspendedJiboViewHolder"
.end annotation


# instance fields
.field avatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field titleText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 664
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 665
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 1

    .prologue
    .line 674
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;->avatar:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 675
    return-void
.end method

.method public invalidateView()V
    .locals 6

    .prologue
    .line 669
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 670
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;->titleText:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f100260

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 671
    return-void
.end method
