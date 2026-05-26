.class public Lcom/jibo/ui/fragment/jibos/JibosListFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "JibosListFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/ui/fragment/BaseFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;",
        "Lcom/jibo/ui/view/LoopSelectionListView$OnLoopSelectedListener;"
    }
.end annotation


# static fields
.field private static a:I

.field private static b:I


# instance fields
.field private c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

.field private d:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field private e:Z

.field emptyView:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field fab:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const/16 v0, 0x3e8

    sput v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a:I

    .line 57
    const/16 v0, 0x3e9

    sput v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->b:I

    return-void
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 323
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 324
    const-string v1, " ARGS_LOOPS_LIST"

    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 325
    const-string v1, " ARGS_HAS_ACCEPTED_LOOPS"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 326
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/LoopInviteDetailsActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 327
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->startActivity(Landroid/content/Intent;)V

    .line 328
    return-void
.end method

.method private c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation

    .prologue
    .line 331
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 332
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v2

    .line 333
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 334
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->m:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 335
    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 336
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 340
    :cond_1
    return-object v1
.end method


# virtual methods
.method public a(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 221
    packed-switch p1, :pswitch_data_0

    move-object v0, v4

    .line 228
    :goto_0
    return-object v0

    .line 223
    :pswitch_0
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/16 v2, 0x8

    invoke-static {v2}, Lcom/jibo/db/DatabaseContract$EntityEntry;->a(I)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/jibo/db/DatabaseContract$EntityEntry;->a:[Ljava/lang/String;

    const-string v6, "name"

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 221
    nop

    :pswitch_data_0
    .packed-switch 0x7f0901c5
        :pswitch_0
    .end packed-switch
.end method

.method public a(Landroid/support/v4/content/Loader;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 293
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Ljava/util/List;)V

    .line 294
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->notifyDataSetChanged()V

    .line 295
    return-void
.end method

.method public a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/16 v11, 0x8

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 234
    invoke-virtual {p1}, Landroid/support/v4/content/Loader;->n()I

    move-result v0

    const v3, 0x7f0901c5

    if-ne v0, v3, :cond_4

    .line 236
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v5

    .line 237
    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    move v0, v2

    .line 240
    :goto_0
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 241
    const/4 v4, 0x0

    .line 243
    if-nez v0, :cond_3

    .line 244
    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v7

    .line 246
    :goto_1
    invoke-interface {p2}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v3

    if-nez v3, :cond_2

    .line 247
    invoke-static {p2}, Lcom/jibo/db/EntityData;->a(Landroid/database/Cursor;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v3

    .line 248
    invoke-static {v3, v7}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberDeclined(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 249
    invoke-interface {v6, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 251
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v8

    if-eqz v8, :cond_7

    .line 252
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v9

    const-string v10, "ARG_ENTITY_SELECTED"

    invoke-virtual {v9, v10}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 257
    :goto_2
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-object v4, v3

    goto :goto_1

    :cond_1
    move v0, v1

    .line 238
    goto :goto_0

    .line 261
    :cond_2
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v3

    if-nez v3, :cond_5

    move v3, v2

    :goto_3
    or-int/2addr v0, v3

    .line 265
    :cond_3
    if-eqz v0, :cond_6

    .line 266
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->emptyView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 267
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v11}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 268
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->fab:Landroid/view/View;

    invoke-virtual {v0, v11}, Landroid/view/View;->setVisibility(I)V

    .line 269
    iput-boolean v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->e:Z

    .line 282
    :goto_4
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->w()V

    .line 285
    if-eqz v4, :cond_4

    .line 286
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 289
    :cond_4
    return-void

    :cond_5
    move v3, v1

    .line 261
    goto :goto_3

    .line 271
    :cond_6
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->emptyView:Landroid/view/View;

    invoke-virtual {v0, v11}, Landroid/view/View;->setVisibility(I)V

    .line 272
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setVisibility(I)V

    .line 273
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->fab:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 274
    iput-boolean v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->e:Z

    .line 276
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a(Lcom/jibo/aws/integration/aws/services/account/model/Account;Ljava/util/List;)V

    .line 277
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->notifyDataSetChanged()V

    .line 278
    iput-object v6, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->m:Ljava/util/List;

    goto :goto_4

    :cond_7
    move-object v3, v4

    goto :goto_2
.end method

.method public bridge synthetic a(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 52
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 210
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 211
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 212
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isMemberInvited(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 213
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 217
    :goto_0
    return-void

    .line 215
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity;

    const-class v2, Lcom/jibo/ui/fragment/jibos/JiboDetailsFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/TabbedActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public b()V
    .locals 3

    .prologue
    .line 358
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/account/AccountSettingsDetailsFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sget v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->b:I

    .line 359
    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 360
    return-void
.end method

.method public n_()V
    .locals 4

    .prologue
    .line 196
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/service/SyncHelper;->b(Landroid/content/Context;)V

    .line 199
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getView()Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment$2;-><init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 206
    return-void
.end method

.method public o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 299
    const v0, 0x7f100407

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 4

    .prologue
    .line 145
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 147
    sget v0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a:I

    if-ne p1, v0, :cond_1

    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    if-eqz p3, :cond_1

    .line 150
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 151
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 152
    const-string v0, "ARG_TAB_SELECTED"

    const/4 v2, 0x0

    invoke-virtual {p3, v0, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 157
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a()I

    move-result v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v3}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b()I

    move-result v3

    add-int/2addr v2, v3

    if-nez v2, :cond_2

    .line 159
    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v2, :cond_0

    .line 160
    const-string v2, "ARG_ENTITY_SELECTED"

    iget-object v3, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    :cond_0
    const-string v2, "ARG_TAB_SELECTED"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 164
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v2, "ARG_EXTRAS"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 175
    :cond_1
    :goto_0
    return-void

    .line 165
    :cond_2
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a()I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    .line 166
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b()I

    move-result v2

    add-int/2addr v1, v2

    if-lez v1, :cond_1

    .line 169
    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 170
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 171
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/TabbedActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/TabbedActivity;->u()V

    goto :goto_0
.end method

.method public onConnectWifi(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 311
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 126
    const v0, 0x7f0c000f

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/jibo/utils/ImageUtils;->a(Landroid/content/Context;Landroid/view/Menu;)V

    .line 130
    const v0, 0x7f090032

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 131
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 78
    const v0, 0x7f0b0078

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onInviteInfo(Landroid/view/View;)V
    .locals 6
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    const/4 v5, 0x1

    .line 315
    const v0, 0x7f10021a

    .line 316
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f100219

    .line 317
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 318
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 317
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 315
    invoke-static {p0, v5, v0, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->d(Landroid/support/v4/app/Fragment;ILjava/lang/String;Ljava/lang/String;)V

    .line 319
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    .prologue
    .line 135
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 136
    const v1, 0x7f090032

    if-ne v0, v1, :cond_0

    .line 137
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->b()V

    .line 138
    const/4 v0, 0x1

    .line 140
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 179
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 184
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    .line 185
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->a()I

    move-result v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v1}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;->b()I

    move-result v1

    add-int/2addr v0, v1

    if-lez v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 187
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->l:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 190
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 83
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 85
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    invoke-virtual {v0, p0}, Landroid/support/v4/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 86
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->swipeRefreshLayout:Landroid/support/v4/widget/SwipeRefreshLayout;

    const/4 v1, 0x4

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/SwipeRefreshLayout;->setColorSchemeResources([I)V

    .line 89
    new-instance v0, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-direct {v0, v4}, Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;-><init>(Landroid/view/View$OnClickListener;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    .line 91
    new-instance v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v3, v2}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    .line 94
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v1

    const v2, 0x7f0901c5

    invoke-virtual {v1, v2, v4, p0}, Landroid/support/v4/app/LoaderManager;->a(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 96
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 97
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 98
    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c:Lcom/jibo/ui/fragment/jibos/adapter/JibosListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 102
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_MESSAGE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment$1;-><init>(Lcom/jibo/ui/fragment/jibos/JibosListFragment;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 116
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 117
    if-eqz v0, :cond_1

    .line 118
    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 119
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 118
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 121
    :cond_1
    return-void

    .line 86
    nop

    :array_0
    .array-data 4
        0x7f06007b
        0x7f060018
        0x7f060018
        0x7f060018
    .end array-data
.end method

.method public setUpNewJibo(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 353
    invoke-virtual {p0, p1}, Lcom/jibo/ui/fragment/jibos/JibosListFragment;->onConnectWifi(Landroid/view/View;)V

    .line 354
    return-void
.end method
