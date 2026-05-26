.class public Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "SkillSettingsFragment.java"

# interfaces
.implements Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$DataChangedListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;,
        Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$SpacesItemDecoration;
    }
.end annotation


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/jibo/ui/helpers/Items$Item;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

.field private d:[I

.field private e:Ljava/lang/String;

.field private l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

.field private n:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b:Ljava/util/List;

    .line 66
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    .line 109
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$2;-><init>(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->n:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b:Ljava/util/List;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->c:Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    return-object v0
.end method

.method private b()V
    .locals 4

    .prologue
    .line 225
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 228
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->d:[I

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->n:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    invoke-direct {v0, v1, v2, v3}, Lcom/jibo/ui/helpers/skills/ItemFactory;-><init>([ILcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;)V

    .line 229
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->d:[I

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/ItemFactory;->getItems(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 230
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 231
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 234
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->c:Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;->notifyDataSetChanged()V

    .line 235
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    return-object v0
.end method


# virtual methods
.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 212
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 213
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 214
    return-void
.end method

.method public a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V
    .locals 2

    .prologue
    .line 239
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->m:Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;

    const/4 v1, 0x0

    invoke-interface {v0, p1, p2, v1}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;Lcom/jibo/aws/integration/util/Commons$AsyncCallback;)V

    .line 240
    return-void
.end method

.method public a()[I
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->d:[I

    return-object v0
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 197
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->b(Landroid/os/Bundle;)V

    .line 198
    const-string v0, "PARAM_PATH"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->d:[I

    .line 199
    const-string v0, "PARAM_TITLE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->e:Ljava/lang/String;

    .line 200
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->e:Ljava/lang/String;

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 158
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->setHasOptionsMenu(Z)V

    .line 159
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 190
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 192
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b()V

    .line 193
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 204
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 205
    const-string v0, "PARAM_PATH"

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->d:[I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    .line 206
    const-string v0, "PARAM_TITLE"

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->e:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    const-string v0, "ARGS_SKILL_FRAGMENT"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 208
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 164
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 166
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 168
    new-instance v0, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->b:Ljava/util/List;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 169
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;-><init>(Ljava/util/List;Z)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->c:Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    .line 170
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 171
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 172
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f070116

    const v4, 0x7f07004f

    const v5, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$SpacesItemDecoration;-><init>(Landroid/content/Context;III)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 177
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->c:Lcom/jibo/ui/helpers/skills/SkillBasedRecycleViewAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 179
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 180
    if-eqz v0, :cond_0

    .line 181
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 182
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 183
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 181
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/skills/SkillSettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 186
    :cond_0
    return-void
.end method
