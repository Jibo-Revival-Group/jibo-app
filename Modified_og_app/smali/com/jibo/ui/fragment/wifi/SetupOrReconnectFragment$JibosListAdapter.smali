.class public Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "SetupOrReconnectFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JibosListAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter$SpacesItemDecoration;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v7/widget/RecyclerView$Adapter",
        "<",
        "Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/util/SparseIntArray;


# direct methods
.method public constructor <init>(Ljava/util/List;)V
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
    .line 237
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 235
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->b:Landroid/util/SparseIntArray;

    .line 238
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

    .line 239
    return-void
.end method


# virtual methods
.method public a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;
    .locals 5

    .prologue
    .line 249
    const/4 v1, 0x0

    .line 250
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    aget-object v0, v0, p2

    .line 252
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->getLayoutId()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 253
    sget-object v3, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$5;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    aget v0, v3, v0

    packed-switch v0, :pswitch_data_0

    .line 272
    :goto_0
    return-object v1

    .line 255
    :pswitch_0
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$SubheaderViewHolder;

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/ViewHolders$SubheaderViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 258
    :pswitch_1
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 261
    :pswitch_2
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    move-object v0, v1

    .line 262
    check-cast v0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;

    iget-object v0, v0, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;->text:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    const/high16 v2, -0x1000000

    invoke-virtual {v0, v2}, Lcom/jibo/ui/view/proxima/CustomFontTextView;->setTextColor(I)V

    goto :goto_0

    .line 265
    :pswitch_3
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/ViewHolders$FooterViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 268
    :pswitch_4
    new-instance v1, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/ViewHolders$SimpleViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 253
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;->setData(Lcom/jibo/ui/helpers/Items$Item;)V

    .line 277
    return-void
.end method

.method public a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;ILjava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 281
    invoke-static {}, Lcom/jibo/ui/helpers/Items$ItemType;->values()[Lcom/jibo/ui/helpers/Items$ItemType;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 283
    sget-object v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$5;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/Items$ItemType;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 296
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    .line 299
    :cond_0
    :goto_0
    return-void

    .line 285
    :pswitch_0
    if-eqz p3, :cond_1

    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 287
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_0

    .line 288
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->b:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p2, v2}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/jibo/ui/helpers/ViewHolders$SuspendedJiboViewHolder;->a(I)V

    goto :goto_0

    .line 291
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    goto :goto_0

    .line 283
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public a(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 307
    .line 310
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/Items$Item;

    .line 311
    instance-of v1, v0, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    .line 312
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    move-object v1, v0

    check-cast v1, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    .line 313
    invoke-virtual {v1}, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;->a()Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 314
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 319
    :goto_0
    if-eq v0, v2, :cond_1

    .line 320
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->b:Landroid/util/SparseIntArray;

    invoke-static {p2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 321
    invoke-virtual {p0, v0, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->notifyItemChanged(ILjava/lang/Object;)V

    .line 323
    :cond_1
    return-void

    :cond_2
    move v0, v2

    goto :goto_0
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a:Ljava/util/List;

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
    .line 231
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;I)V

    return-void
.end method

.method public synthetic onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V
    .locals 0

    .prologue
    .line 231
    check-cast p1, Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;ILjava/util/List;)V

    return-void
.end method

.method public synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 1

    .prologue
    .line 231
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->a(Landroid/view/ViewGroup;I)Lcom/jibo/ui/helpers/ViewHolders$AbstractViewHolder;

    move-result-object v0

    return-object v0
.end method
