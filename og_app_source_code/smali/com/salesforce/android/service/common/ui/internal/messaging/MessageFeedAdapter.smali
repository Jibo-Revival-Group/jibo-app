.class public Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;
.super Ljava/lang/Object;
.source "MessageFeedAdapter.java"

# interfaces
.implements Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

.field private final b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

.field private final c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate",
            "<",
            "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final d:J

.field private e:Landroid/support/v7/widget/RecyclerView;

.field private f:Landroid/support/v7/widget/LinearLayoutManager;

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;)V
    .locals 2

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    .line 84
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    .line 85
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    .line 86
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    .line 87
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    invoke-virtual {v0, p0}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->a(Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapter;)V

    .line 88
    iget-object v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter$Builder;->d:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->d:J

    .line 89
    return-void
.end method

.method private a(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V
    .locals 1

    .prologue
    .line 287
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;

    if-eqz v0, :cond_0

    .line 288
    check-cast p1, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;->a()V

    .line 290
    :cond_0
    return-void
.end method

.method private a(Lcom/salesforce/android/service/common/ui/internal/messaging/Message;Lcom/salesforce/android/service/common/ui/internal/messaging/Message;)Z
    .locals 4

    .prologue
    .line 275
    invoke-interface {p2}, Lcom/salesforce/android/service/common/ui/internal/messaging/Message;->d()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    invoke-interface {p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/Message;->d()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    iget-wide v2, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->d:J

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;)Z
    .locals 2

    .prologue
    .line 283
    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Lcom/salesforce/android/service/common/ui/internal/messaging/Message;Lcom/salesforce/android/service/common/ui/internal/messaging/Message;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;->e()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2}, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 241
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 254
    :cond_0
    :goto_0
    return v0

    .line 245
    :cond_1
    const-class v1, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;

    invoke-direct {p0, p1, p2, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 248
    check-cast p1, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;

    check-cast p2, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;

    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;)Z

    move-result v0

    goto :goto_0

    .line 249
    :cond_2
    const-class v1, Lcom/salesforce/android/service/common/ui/internal/messaging/Message;

    invoke-direct {p0, p1, p2, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-class v1, Lcom/salesforce/android/service/common/ui/internal/messaging/MultiActorMessage;

    .line 250
    invoke-direct {p0, p1, p2, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->b(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 251
    check-cast p1, Lcom/salesforce/android/service/common/ui/internal/messaging/Message;

    check-cast p2, Lcom/salesforce/android/service/common/ui/internal/messaging/Message;

    invoke-direct {p0, p1, p2}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Lcom/salesforce/android/service/common/ui/internal/messaging/Message;Lcom/salesforce/android/service/common/ui/internal/messaging/Message;)Z

    move-result v0

    goto :goto_0
.end method

.method private a(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Z
    .locals 1

    .prologue
    .line 261
    invoke-virtual {p3, p1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p3, p2}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private b(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V
    .locals 1

    .prologue
    .line 293
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;

    if-eqz v0, :cond_0

    .line 294
    check-cast p1, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;

    invoke-interface {p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/GroupableView;->b()V

    .line 296
    :cond_0
    return-void
.end method

.method private b(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)Z
    .locals 1

    .prologue
    .line 268
    invoke-virtual {p3, p1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p3, p2}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge p1, v0, :cond_0

    if-gez p1, :cond_1

    .line 172
    :cond_0
    const/4 v0, 0x0

    .line 175
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public a()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->notifyDataSetChanged()V

    .line 138
    return-void
.end method

.method public a(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 97
    return-void
.end method

.method public a(Ljava/lang/Object;)V
    .locals 2

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->b()Ljava/lang/Object;

    move-result-object v0

    .line 106
    invoke-direct {p0, v0, p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 107
    invoke-virtual {p0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c()Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->notifyItemInserted(I)V

    .line 112
    return-void
.end method

.method public b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method c()Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 2

    .prologue
    .line 213
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->e:Landroid/support/v7/widget/RecyclerView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 214
    :cond_0
    const/4 v0, 0x0

    .line 217
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->e:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->findViewHolderForAdapterPosition(I)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemCount()I
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 158
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->c:Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;

    invoke-virtual {v0, p1}, Lcom/salesforce/android/service/common/ui/internal/android/RecyclerViewAdapterDelegate;->getItemId(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 163
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    invoke-interface {v1, v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;->a(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public onAttachedToRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 1

    .prologue
    .line 225
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->e:Landroid/support/v7/widget/RecyclerView;

    .line 226
    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView;->getLayoutManager()Landroid/support/v7/widget/RecyclerView$LayoutManager;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/LinearLayoutManager;

    iput-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->f:Landroid/support/v7/widget/LinearLayoutManager;

    .line 227
    return-void
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 3

    .prologue
    .line 200
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->g:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 201
    add-int/lit8 v1, p2, 0x1

    invoke-virtual {p0, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(I)Ljava/lang/Object;

    move-result-object v1

    .line 203
    invoke-direct {p0, v0, v1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 204
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V

    .line 209
    :goto_0
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    invoke-virtual {p1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;->getItemViewType()I

    move-result v2

    invoke-interface {v1, p1, v2, v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;->a(Landroid/support/v7/widget/RecyclerView$ViewHolder;ILjava/lang/Object;)V

    .line 210
    return-void

    .line 206
    :cond_0
    invoke-direct {p0, p1}, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->b(Landroid/support/v7/widget/RecyclerView$ViewHolder;)V

    goto :goto_0
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->b:Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/ui/internal/android/LayoutInflaterFactory;->a(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 196
    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->a:Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;

    invoke-interface {v1, p1, p2, v0}, Lcom/salesforce/android/service/common/ui/internal/messaging/ViewHolderFactory;->a(Landroid/view/ViewGroup;ILandroid/view/LayoutInflater;)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public onDetachedFromRecyclerView(Landroid/support/v7/widget/RecyclerView;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 230
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->e:Landroid/support/v7/widget/RecyclerView;

    if-ne v0, p1, :cond_0

    .line 231
    iput-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->e:Landroid/support/v7/widget/RecyclerView;

    .line 232
    iput-object v1, p0, Lcom/salesforce/android/service/common/ui/internal/messaging/MessageFeedAdapter;->f:Landroid/support/v7/widget/LinearLayoutManager;

    .line 234
    :cond_0
    return-void
.end method
