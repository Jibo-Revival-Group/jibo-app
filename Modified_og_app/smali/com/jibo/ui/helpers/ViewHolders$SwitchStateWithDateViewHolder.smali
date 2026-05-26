.class public Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;
.super Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;
.source "ViewHolders.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/ViewHolders;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwitchStateWithDateViewHolder"
.end annotation


# instance fields
.field public dateText:Lcom/jibo/ui/view/proxima/CustomFontTextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 710
    invoke-direct {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;-><init>(Landroid/view/View;)V

    .line 711
    return-void
.end method


# virtual methods
.method public setData(Lcom/jibo/ui/helpers/Items$Item;)V
    .locals 5

    .prologue
    .line 715
    invoke-super {p0, p1}, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 718
    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    instance-of v0, v0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;->mItem:Lcom/jibo/ui/helpers/Items$Item;

    check-cast v0, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;

    .line 720
    :goto_0
    if-eqz v0, :cond_1

    .line 723
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 724
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;->dateText:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->b()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/lang/String;)J

    move-result-wide v2

    const-string v4, "MMMM d, yyyy"

    invoke-static {v2, v3, v4}, Lcom/jibo/aws/integration/util/DateTimeUtils;->getBirthdayString(JLjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setText(Ljava/lang/CharSequence;)V

    .line 728
    :cond_0
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->a()Landroid/view/View$OnLongClickListener;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 729
    iget-object v1, p0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$CheckboxDateItem;->a()Landroid/view/View$OnLongClickListener;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 733
    :cond_1
    return-void

    .line 718
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
