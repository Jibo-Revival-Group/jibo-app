.class public Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FooterViewHolder"
.end annotation


# instance fields
.field public footer:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 577
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 578
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 1

    .prologue
    .line 593
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->footer:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 594
    return-void
.end method

.method public invalidateView()V
    .locals 3

    .prologue
    .line 582
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$FooterItem;

    .line 583
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$FooterItem;->a()Ljava/lang/CharSequence;

    move-result-object v1

    instance-of v1, v1, Landroid/text/SpannableStringBuilder;

    if-eqz v1, :cond_0

    .line 584
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->footer:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$FooterItem;->a()Ljava/lang/CharSequence;

    move-result-object v0

    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v1, v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 585
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->footer:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 590
    :goto_0
    return-void

    .line 587
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->footer:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$FooterItem;->a()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 588
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;->footer:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto :goto_0
.end method
