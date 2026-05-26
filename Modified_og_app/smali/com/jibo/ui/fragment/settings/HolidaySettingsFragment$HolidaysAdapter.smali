.class public Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Lcom/jibo/ui/view/RecyclerViewFastScroller$BubbleTextGetter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HolidaysAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;",
        ">;",
        "Lcom/jibo/ui/view/RecyclerViewFastScroller$BubbleTextGetter;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 609
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 607
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    .line 610
    return-void
.end method


# virtual methods
.method public a(I)Lcom/jibo/ui/helpers/Items$Item;
    .locals 1

    .prologue
    .line 656
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 4

    .prologue
    .line 626
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    aget-object v0, v0, p2

    .line 628
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->getLayoutId()I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 629
    sget-object v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$13;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    aget v0, v2, v0

    packed-switch v0, :pswitch_data_0

    .line 639
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    .line 642
    :goto_0
    return-object v0

    .line 632
    :pswitch_0
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 635
    :pswitch_1
    new-instance v0, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/helpers/ViewHolders$SwitchStateWithDateViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 629
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V
    .locals 1

    .prologue
    .line 646
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 647
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 650
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 651
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 652
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->notifyDataSetChanged()V

    .line 653
    return-void
.end method

.method public b(I)V
    .locals 1

    .prologue
    .line 660
    if-ltz p1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    .line 661
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 663
    :cond_0
    return-void
.end method

.method public c(I)Ljava/lang/String;
    .locals 3

    .prologue
    .line 667
    if-lez p1, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    .line 668
    :goto_0
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/jibo/ui/helpers/Items$CheckboxItem;

    if-eqz v1, :cond_1

    .line 669
    check-cast v0, Lcom/jibo/ui/helpers/Items$CheckboxItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$CheckboxItem;->e()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 671
    :goto_1
    return-object v0

    .line 667
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 671
    :cond_1
    const-string v0, ""

    goto :goto_1
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 619
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 614
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$Item;->getItemType()Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    return v0
.end method

.method public synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .prologue
    .line 605
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 605
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidaysAdapter;->a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method
