.class public Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SimpleViewHolder"
.end annotation


# instance fields
.field public text:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;-><init>(Landroid/view/View;)V

    .line 96
    return-void
.end method


# virtual methods
.method public invalidateView()V
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;->d()I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_1

    .line 101
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->text:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;->d()I

    move-result v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(I)V

    .line 108
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    instance-of v0, v0, Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_2

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->text:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 106
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->text:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$SimpleItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$SimpleItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
