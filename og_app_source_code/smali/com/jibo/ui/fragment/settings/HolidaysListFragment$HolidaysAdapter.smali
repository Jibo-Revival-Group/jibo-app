.class public Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "HolidaysListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HolidaysAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/ui/fragment/settings/HolidaysListFragment;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 241
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 242
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    .line 243
    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->b:Ljava/util/List;

    .line 244
    return-void
.end method


# virtual methods
.method public a(I)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;
    .locals 1

    .prologue
    .line 283
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    return-object v0
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 279
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->empty:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    .line 249
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->ordinal()I

    move-result v0

    .line 250
    :goto_0
    return v0

    .line 249
    :cond_0
    sget-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->holiday:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    .line 250
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->ordinal()I

    move-result v0

    goto :goto_0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 1

    .prologue
    .line 272
    instance-of v0, p1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    if-eqz v0, :cond_0

    .line 273
    check-cast p1, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->b:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;->a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    .line 275
    :cond_0
    return-void
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 5

    .prologue
    .line 255
    .line 256
    sget-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->empty:Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;->ordinal()I

    move-result v0

    if-ne p2, v0, :cond_0

    .line 257
    new-instance v1, Landroid/view/View;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 258
    new-instance v0, Landroid/support/v7/widget/RecyclerView$LayoutParams;

    const/4 v2, -0x1

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    .line 259
    invoke-virtual {v3}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f07004c

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v3

    invoke-direct {v0, v2, v3}, Landroid/support/v7/widget/RecyclerView$LayoutParams;-><init>(II)V

    .line 258
    invoke-virtual {v1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 260
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$EmptyViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$EmptyViewHolder;-><init>(Landroid/view/View;)V

    .line 266
    :goto_0
    return-object v0

    .line 262
    :cond_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00af

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 264
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;->a:Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;-><init>(Landroid/view/View;Lcom/jibo/ui/fragment/settings/HolidaysListFragment;)V

    goto :goto_0
.end method
