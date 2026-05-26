.class public Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HeaderButtonViewHolder"
.end annotation


# instance fields
.field public button:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 402
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 403
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 417
    invoke-super {p0}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->invalidateView()V

    .line 419
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->button:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$HeaderButtonItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$HeaderButtonItem;->a()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 420
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    .line 407
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 409
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->itemView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 410
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 411
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->button:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$HeaderButtonViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$Item;->getOnRowClickListener()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 413
    :cond_0
    return-void
.end method
