.class public Lcom/jibo/ui/helpers/ViewHolders$OptionsBottomSheetDialogViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OptionsBottomSheetDialogViewHolder"
.end annotation


# instance fields
.field item:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public ivItem:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public tvItem:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 769
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 770
    return-void
.end method


# virtual methods
.method protected invalidateView()V
    .locals 0

    .prologue
    .line 785
    return-void
.end method

.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 2

    .prologue
    .line 774
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 776
    instance-of v0, p1, Lcom/jibo/ui/helpers/Items$IconTextItem;

    if-eqz v0, :cond_0

    .line 777
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$OptionsBottomSheetDialogViewHolder;->tvItem:Landroid/widget/TextView;

    move-object v0, p1

    check-cast v0, Lcom/jibo/ui/helpers/Items$IconTextItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$IconTextItem;->b()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 778
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$OptionsBottomSheetDialogViewHolder;->ivItem:Landroid/widget/ImageView;

    check-cast p1, Lcom/jibo/ui/helpers/Items$IconTextItem;

    invoke-virtual {p1}, Lcom/jibo/ui/helpers/Items$IconTextItem;->a()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 780
    :cond_0
    return-void
.end method
