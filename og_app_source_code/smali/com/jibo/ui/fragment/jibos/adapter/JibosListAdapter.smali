.class public Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;
.super Landroid/support/v7/widget/RecyclerView$Adapter;
.source "JibosListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SetupJiboViewHolder;,
        Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;,
        Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;
    }
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
.field private a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private e:Landroid/view/View$OnClickListener;

.field private f:Landroid/util/SparseIntArray;


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/support/v7/widget/RecyclerView$Adapter;-><init>()V

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    .line 53
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->f:Landroid/util/SparseIntArray;

    .line 56
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->e:Landroid/view/View$OnClickListener;

    .line 57
    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public a(I)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 3

    .prologue
    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 178
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    .line 180
    if-ge p1, v1, :cond_0

    .line 181
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 185
    :goto_0
    return-object v0

    .line 182
    :cond_0
    add-int v2, v1, v0

    if-ge p1, v2, :cond_1

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    sub-int v1, p1, v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0

    .line 185
    :cond_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    sub-int v1, p1, v1

    sub-int v0, v1, v0

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    iput-object p1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 67
    if-eqz p2, :cond_0

    if-nez p1, :cond_1

    .line 96
    :cond_0
    return-void

    .line 71
    :cond_1
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 72
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getOwner()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 73
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 74
    :cond_3
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_2

    .line 75
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 76
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 78
    :cond_4
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 7

    .prologue
    const/4 v2, -0x1

    .line 211
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    .line 212
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    .line 216
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 217
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 218
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 223
    :goto_0
    if-ne v1, v2, :cond_2

    .line 224
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 225
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 226
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    add-int v1, v4, v0

    .line 232
    :cond_2
    if-ne v1, v2, :cond_5

    .line 233
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_3
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 234
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 235
    add-int v1, v4, v3

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    add-int/2addr v0, v1

    .line 240
    :goto_1
    if-eq v0, v2, :cond_4

    .line 241
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->f:Landroid/util/SparseIntArray;

    invoke-static {p2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 242
    invoke-virtual {p0, v0, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->notifyItemChanged(ILjava/lang/Object;)V

    .line 244
    :cond_4
    return-void

    :cond_5
    move v0, v1

    goto :goto_1

    :cond_6
    move v1, v2

    goto :goto_0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public c()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    .prologue
    .line 203
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    return-object v0
.end method

.method public getItemCount()I
    .locals 2

    .prologue
    .line 191
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public getItemViewType(I)I
    .locals 3

    .prologue
    .line 100
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 101
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->c:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    .line 103
    if-ge p1, v1, :cond_0

    .line 104
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->invitedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    .line 110
    :goto_0
    return v0

    .line 105
    :cond_0
    add-int v2, v1, v0

    if-ge p1, v2, :cond_1

    .line 106
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->myLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    goto :goto_0

    .line 107
    :cond_1
    add-int/2addr v0, v1

    if-lt p1, v0, :cond_2

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->getItemCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ge p1, v0, :cond_2

    .line 108
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->joinedLoop:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    goto :goto_0

    .line 110
    :cond_2
    sget-object v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->newjibo:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    goto :goto_0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 4

    .prologue
    .line 141
    invoke-static {}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->values()[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 142
    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 150
    :goto_0
    return-void

    :pswitch_0
    move-object v0, p1

    .line 146
    check-cast v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a(I)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->e:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;Landroid/view/View$OnClickListener;)V

    .line 147
    check-cast p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->f:Landroid/util/SparseIntArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p2, v1}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->a(I)V

    goto :goto_0

    .line 142
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 156
    invoke-static {}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->values()[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 158
    sget-object v1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    .line 173
    :cond_0
    :goto_0
    return-void

    .line 162
    :pswitch_0
    if-eqz p3, :cond_1

    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 164
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_0

    .line 165
    check-cast p1, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->f:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p2, v2}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;->a(I)V

    goto :goto_0

    .line 168
    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    goto :goto_0

    .line 158
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 117
    const/4 v0, 0x0

    .line 118
    invoke-static {}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->values()[Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;

    move-result-object v1

    aget-object v1, v1, p2

    .line 120
    sget-object v2, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$1;->a:[I

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboItemTypes;->ordinal()I

    move-result v1

    aget v1, v2, v1

    packed-switch v1, :pswitch_data_0

    .line 136
    :goto_0
    return-object v0

    .line 123
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00b5

    invoke-virtual {v0, v1, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 124
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 127
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00b8

    invoke-virtual {v0, v1, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 128
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$JiboViewHolder;-><init>(Landroid/view/View;)V

    goto :goto_0

    .line 131
    :pswitch_2
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00b9

    invoke-virtual {v0, v1, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 132
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SetupJiboViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->e:Landroid/view/View$OnClickListener;

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter$SetupJiboViewHolder;-><init>(Landroid/view/View;Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 120
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
