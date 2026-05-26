.class public Lcom/jibo/ui/fragment/settings/HolidaysListFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "HolidaysListFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;,
        Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;,
        Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidayViewHolder;,
        Lcom/jibo/ui/fragment/settings/HolidaysListFragment$EmptyViewHolder;,
        Lcom/jibo/ui/fragment/settings/HolidaysListFragment$ItemType;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

.field private c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;"
        }
    .end annotation
.end field

.field private d:Z

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 46
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;ZLjava/util/List;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(ZLjava/util/List;)V

    return-void
.end method

.method private a(ZLjava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 159
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 160
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 161
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 164
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->f()V

    .line 165
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->b:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;

    invoke-direct {v3, p0, p2, p1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/util/List;Z)V

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;->switchHolidays(ZLjava/util/List;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 189
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 147
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 148
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 149
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 2

    .prologue
    .line 153
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_TITLE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 63
    if-eqz p1, :cond_1

    .line 64
    const-string v0, "ARG_ARRAY"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    .line 68
    :cond_0
    :goto_0
    return-void

    .line 65
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_ARRAY"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4

    .prologue
    const v3, 0x7f09002a

    const/4 v2, 0x1

    .line 110
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 111
    const v0, 0x7f0c000b

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 113
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 114
    iput-boolean v2, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->d:Z

    .line 115
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 116
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 117
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->d:Z

    .line 121
    :cond_1
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->d:Z

    if-eqz v0, :cond_3

    const v0, 0x7f100209

    .line 122
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 121
    :goto_0
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 124
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 126
    :cond_2
    return-void

    .line 122
    :cond_3
    const v0, 0x7f100208

    .line 123
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 72
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->setHasOptionsMenu(Z)V

    .line 74
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 130
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const v3, 0x7f09002a

    if-ne v0, v3, :cond_1

    .line 131
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->d:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    invoke-direct {p0, v0, v3}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(ZLjava/util/List;)V

    .line 132
    invoke-interface {p1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 136
    :goto_1
    return v1

    :cond_0
    move v0, v2

    .line 131
    goto :goto_0

    .line 136
    :cond_1
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    goto :goto_1
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 99
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 101
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_ARRAY"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_TITLE"

    .line 102
    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 103
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->onBackPressed()V

    .line 106
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 141
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 142
    const-string v1, "ARG_ARRAY"

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 143
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v2, 0x1

    .line 79
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 81
    new-instance v0, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 82
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/LinearLayoutManager;->b(I)V

    .line 83
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 84
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v2}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 85
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v2, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const v4, 0x7f07004c

    invoke-direct {v2, v3, v4}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 86
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 88
    new-instance v0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->c:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment$HolidaysAdapter;-><init>(Lcom/jibo/ui/fragment/settings/HolidaysListFragment;Ljava/util/List;)V

    .line 89
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 91
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 92
    new-instance v1, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 93
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 94
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->b:Lcom/jibo/aws/integration/aws/services/person/JiboPersonAsyncClient;

    .line 92
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/HolidaysListFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 95
    return-void
.end method
