.class public Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TwoRowsSimpleViewHolder"
.end annotation


# instance fields
.field public subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field public title:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 119
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 120
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 124
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    instance-of v0, v0, Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->title:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 127
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->title:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 128
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->f()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setVisibility(I)V

    .line 137
    :goto_0
    return-void

    .line 131
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->f()Ljava/lang/CharSequence;

    move-result-object v0

    instance-of v0, v0, Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_2

    .line 132
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 134
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$TwoRowsSimpleItem;->f()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 135
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$TwoRowsSimpleViewHolder;->subtitle:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setVisibility(I)V

    goto :goto_0
.end method
