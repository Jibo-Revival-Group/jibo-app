.class public Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;
.super Lcom/jibo/ui/helpers/RecyclerCursorAdapter;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MomentsAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/ui/helpers/RecyclerCursorAdapter",
        "<",
        "Landroid/support/v7/widget/RecyclerView$ViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/home/MediaFragment;

.field private final d:Z

.field private e:Lcom/jibo/ui/fragment/home/MediaFragment;

.field private f:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

.field private g:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;"
        }
    .end annotation
.end field

.field private h:Landroid/view/View$OnClickListener;

.field private i:Landroid/view/View$OnClickListener;

.field private j:Landroid/view/View$OnLongClickListener;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment;Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/database/Cursor;Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;)V
    .locals 1

    .prologue
    .line 1114
    iput-object p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1115
    invoke-direct {p0, p3}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;-><init>(Landroid/database/Cursor;)V

    .line 1112
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    .line 1333
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$1;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->h:Landroid/view/View$OnClickListener;

    .line 1356
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$2;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->i:Landroid/view/View$OnClickListener;

    .line 1392
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter$3;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->j:Landroid/view/View$OnLongClickListener;

    .line 1116
    iput-object p2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->e:Lcom/jibo/ui/fragment/home/MediaFragment;

    .line 1117
    iput-object p4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->f:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    .line 1118
    invoke-virtual {p2}, Lcom/jibo/ui/fragment/home/MediaFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->g(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d:Z

    .line 1119
    return-void
.end method

.method private a(Landroid/view/View;)I
    .locals 2

    .prologue
    const/4 v1, -0x1

    .line 1318
    if-nez p1, :cond_1

    move v0, v1

    .line 1330
    :cond_0
    :goto_0
    return v0

    .line 1320
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I

    move-result v0

    .line 1322
    if-ne v0, v1, :cond_0

    .line 1325
    :try_start_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, p1}, Landroid/support/v7/widget/RecyclerView;->getChildViewHolder(Landroid/view/View;)Landroid/support/v7/widget/RecyclerView$ViewHolder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView$ViewHolder;->getAdapterPosition()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    goto :goto_0

    .line 1326
    :catch_0
    move-exception v1

    .line 1327
    invoke-static {v1}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;I)I
    .locals 1

    .prologue
    .line 1108
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->b(I)I

    move-result v0

    return v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;Landroid/view/View;)I
    .locals 1

    .prologue
    .line 1108
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(Landroid/view/View;)I

    move-result v0

    return v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;)Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;
    .locals 1

    .prologue
    .line 1108
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->f:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    return-object v0
.end method

.method private b(I)I
    .locals 10

    .prologue
    const/4 v6, 0x5

    const/4 v9, 0x2

    const/4 v1, 0x4

    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 1142
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v4

    .line 1180
    :goto_0
    return v0

    .line 1144
    :cond_0
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->b()I

    move-result v5

    .line 1145
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    move v0, v5

    goto :goto_0

    .line 1147
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1148
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 1150
    iget v7, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    if-gt v7, p1, :cond_3

    iget v7, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt p1, v7, :cond_3

    .line 1151
    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    sub-int v7, p1, v3

    .line 1152
    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    iget v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    sub-int v0, v3, v0

    add-int/lit8 v3, v0, 0x1

    .line 1153
    div-int/lit8 v0, v3, 0x3

    .line 1154
    rem-int/lit8 v8, v3, 0x3

    .line 1157
    if-ne v8, v9, :cond_4

    .line 1158
    const/4 v0, 0x3

    .line 1166
    :goto_1
    add-int/lit8 v0, v0, -0x1

    .line 1168
    if-lt v7, v0, :cond_8

    if-le v3, v1, :cond_8

    div-int/lit8 v0, v5, 0x3

    goto :goto_0

    .line 1159
    :cond_4
    if-ge v3, v6, :cond_5

    move v0, v3

    .line 1160
    goto :goto_1

    .line 1161
    :cond_5
    if-ne v8, v4, :cond_6

    move v0, v6

    .line 1162
    goto :goto_1

    .line 1163
    :cond_6
    if-nez v8, :cond_d

    .line 1164
    if-ne v0, v9, :cond_7

    move v0, v1

    goto :goto_1

    :cond_7
    move v0, v2

    goto :goto_1

    .line 1171
    :cond_8
    if-le v3, v1, :cond_9

    .line 1172
    :goto_2
    rem-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_a

    .line 1173
    :goto_3
    if-lt v7, v2, :cond_b

    .line 1174
    div-int/lit8 v0, v5, 0x2

    goto :goto_0

    :cond_9
    move v0, v3

    .line 1171
    goto :goto_2

    :cond_a
    move v2, v4

    .line 1172
    goto :goto_3

    :cond_b
    move v0, v5

    .line 1176
    goto :goto_0

    :cond_c
    move v0, v5

    .line 1180
    goto :goto_0

    :cond_d
    move v0, v2

    goto :goto_1
.end method

.method private d()Z
    .locals 1

    .prologue
    .line 1122
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(I)I
    .locals 4

    .prologue
    const/4 v1, -0x1

    .line 1192
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    .line 1201
    :goto_0
    return v0

    .line 1194
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1195
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 1197
    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    if-gt v3, p1, :cond_1

    iget v3, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt p1, v3, :cond_1

    .line 1198
    iget v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->a:I

    sub-int v0, p1, v0

    goto :goto_0

    :cond_2
    move v0, v1

    .line 1201
    goto :goto_0
.end method

.method public a(Landroid/support/v7/widget/RecyclerView$ViewHolder;Landroid/database/Cursor;)V
    .locals 3

    .prologue
    .line 1273
    instance-of v0, p1, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    if-eqz v0, :cond_0

    .line 1274
    iget-object v0, p1, Landroid/support/v7/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    invoke-static {p2}, Lcom/jibo/db/EntityData;->c(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    .line 1275
    check-cast p1, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->e:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/home/MediaFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1}, Landroid/support/v7/widget/RecyclerView;->getWidth()I

    move-result v1

    iget-boolean v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d:Z

    invoke-virtual {p1, v1, v0, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(ILcom/jibo/aws/integration/aws/services/media/model/Media;Z)V

    .line 1277
    :cond_0
    return-void
.end method

.method public a(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1313
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1314
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 1315
    return-void
.end method

.method public getItemCount()I
    .locals 2

    .prologue
    .line 1309
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->getItemCount()I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 4

    .prologue
    const/4 v2, -0x1

    .line 1208
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v2

    .line 1219
    :goto_0
    return v0

    .line 1210
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1211
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    .line 1213
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, p1, :cond_2

    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->header:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->ordinal()I

    move-result v0

    goto :goto_0

    .line 1215
    :cond_2
    iget v0, v1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    if-gt v0, p1, :cond_1

    iget v0, v1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    if-gt p1, v0, :cond_1

    .line 1216
    sget-object v0, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->media:Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->ordinal()I

    move-result v0

    goto :goto_0

    :cond_3
    move v0, v2

    .line 1219
    goto :goto_0
.end method

.method public onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 1253
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemViewType(I)I

    move-result v0

    if-ne v0, v3, :cond_1

    .line 1269
    :cond_0
    :goto_0
    return-void

    .line 1255
    :cond_1
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->values()[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 1256
    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$8;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 1258
    :pswitch_0
    check-cast p1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->g:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;

    invoke-virtual {p1, v0}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->a(Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;)V

    goto :goto_0

    .line 1261
    :pswitch_1
    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a(I)I

    move-result v1

    .line 1262
    invoke-direct {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->b(I)I

    move-result v2

    .line 1263
    if-eq v1, v3, :cond_0

    move-object v0, p1

    .line 1264
    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(I)V

    .line 1265
    invoke-super {p0, p1, v1}, Lcom/jibo/ui/helpers/RecyclerCursorAdapter;->onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    goto :goto_0

    .line 1256
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
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

    .line 1282
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemViewType(I)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 1305
    :cond_0
    :goto_0
    return-void

    .line 1284
    :cond_1
    if-eqz p3, :cond_2

    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1285
    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->onBindViewHolder(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V

    goto :goto_0

    .line 1287
    :cond_3
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->values()[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    move-result-object v0

    invoke-virtual {p0, p2}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->getItemViewType(I)I

    move-result v1

    aget-object v0, v0, v1

    .line 1288
    sget-object v1, Lcom/jibo/ui/fragment/home/MediaFragment$8;->a:[I

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 1290
    :pswitch_0
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Landroid/support/v7/view/ActionMode$Callback;

    if-eqz v0, :cond_0

    .line 1291
    check-cast p1, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;->a()V

    goto :goto_0

    .line 1295
    :pswitch_1
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    if-eqz v0, :cond_4

    move-object v0, p1

    .line 1296
    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a()V

    .line 1298
    :cond_4
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Landroid/support/v7/view/ActionMode$Callback;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 1299
    check-cast v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a(Z)V

    .line 1300
    check-cast p1, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;->a()V

    goto :goto_0

    .line 1288
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 1225
    const/4 v0, 0x0

    .line 1227
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->d()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, -0x1

    if-ne p2, v1, :cond_1

    .line 1228
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$EmptyViewHolder;

    new-instance v1, Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/home/MediaFragment$EmptyViewHolder;-><init>(Landroid/view/View;)V

    .line 1247
    :goto_0
    return-object v0

    .line 1230
    :cond_1
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->values()[Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;

    move-result-object v1

    aget-object v1, v1, p2

    .line 1231
    sget-object v2, Lcom/jibo/ui/fragment/home/MediaFragment$8;->a:[I

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/home/MediaFragment$ViewType;->ordinal()I

    move-result v1

    aget v1, v2, v1

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 1233
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 1234
    invoke-static {}, Lcom/jibo/ui/fragment/home/MediaFragment$ModesHelper;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    const v0, 0x7f0b00da

    .line 1233
    :goto_1
    invoke-virtual {v1, v0, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 1237
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->a:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->h:Landroid/view/View$OnClickListener;

    invoke-direct {v0, v2, v1, v3}, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderViewHolder;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/view/View;Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 1234
    :cond_2
    const v0, 0x7f0b00b3

    goto :goto_1

    .line 1240
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b00c7

    .line 1241
    invoke-virtual {v0, v1, p1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 1242
    new-instance v0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;

    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->e:Lcom/jibo/ui/fragment/home/MediaFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->f:Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;

    const/4 v4, 0x1

    invoke-direct {v0, v2, v1, v3, v4}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoItemViewHolder;-><init>(Lcom/jibo/ui/fragment/home/MediaFragment;Landroid/view/View;Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;Z)V

    .line 1243
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->i:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1244
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$MomentsAdapter;->j:Landroid/view/View$OnLongClickListener;

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    goto :goto_0

    .line 1231
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
