.class public Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;
.source "SetupOrReconnectFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog$BackupKeyRestoredListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;
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

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

.field private l:Landroid/view/View$OnClickListener;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;-><init>()V

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    .line 180
    new-instance v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$4;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->l:Landroid/view/View$OnClickListener;

    .line 61
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    return-object v0
.end method

.method private a()V
    .locals 5

    .prologue
    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 100
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$FooterItem;

    const v2, 0x7f10025f

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 113
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->setup_jibo:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)V

    invoke-direct {v1, v2, v3}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 120
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$2;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;)V

    const v4, 0x7f1001dd

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 129
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;->notifyDataSetChanged()V

    .line 130
    return-void

    .line 102
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$FooterItem;

    const v2, 0x7f10028d

    invoke-virtual {p0, v2}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v2, 0x7f100283

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 105
    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    new-instance v3, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;

    iget-object v4, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->l:Landroid/view/View$OnClickListener;

    invoke-direct {v3, v4, v0}, Lcom/jibo/ui/helpers/Items$SuspendedLoopItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 109
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 110
    invoke-direct {p0, v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    goto :goto_1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 49
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 144
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 145
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 147
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/WifiActivity;

    sget-object v2, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT_SUSPENDED:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v0, v2}, Lcom/jibo/ui/activity/WifiActivity;->a(Lcom/jibo/ui/activity/WifiActivity$Mode;)V

    .line 148
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 149
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 49
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private c(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v0

    .line 158
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;

    invoke-direct {v2, p0, p1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$3;-><init>(Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 178
    return-void
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 134
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 135
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 136
    return-void
.end method

.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 153
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 154
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 91
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->b(Landroid/os/Bundle;)V

    .line 92
    const-string v0, "ARGS_SUSPENDED_LOOP_LIST"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->b:Ljava/util/ArrayList;

    .line 93
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 140
    const v0, 0x7f100289

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 66
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 70
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 75
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 77
    new-instance v0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;-><init>(Ljava/util/List;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    .line 78
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f07004f

    const v4, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;II)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->c:Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment$JibosListAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 86
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;->a()V

    .line 87
    return-void
.end method
