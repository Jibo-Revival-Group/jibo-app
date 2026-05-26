.class public Lcom/jibo/ui/fragment/account/AccountSettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "AccountSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;
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

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private d:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

.field private e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

.field private l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field list:Landroid/support/v7/widget/RecyclerView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    const-class v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 61
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->d:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 166
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    .line 168
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 169
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 171
    :cond_0
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    if-eqz v1, :cond_1

    if-eqz v0, :cond_1

    .line 172
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->f()V

    .line 173
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    invoke-virtual {v1, v0, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;->getSkillsJson(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 214
    :cond_1
    return-void
.end method

.method private q()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 218
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 220
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v1

    .line 222
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v3, 0x7f10028b

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 223
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-static {v0, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->getMemberForAccount(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/account/model/Account;)Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    move-result-object v0

    .line 224
    if-nez v0, :cond_0

    .line 225
    new-instance v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;-><init>()V

    .line 226
    new-instance v2, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;

    invoke-direct {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;-><init>()V

    .line 227
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getBirthday()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setBirthday(Ljava/lang/Long;)V

    .line 228
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getEmail()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setEmail(Ljava/lang/String;)V

    .line 229
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setFirstName(Ljava/lang/String;)V

    .line 230
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getGender()Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setGender(Lcom/jibo/aws/integration/aws/services/account/model/Account$Gender;)V

    .line 231
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setLastName(Ljava/lang/String;)V

    .line 232
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFullName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setNickName(Ljava/lang/String;)V

    .line 233
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->setPhotoUrl(Ljava/lang/String;)V

    .line 234
    invoke-virtual {v0, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setAccount(Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;)V

    .line 235
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/MemberAccount;->getNickName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Member;->setNickname(Ljava/lang/String;)V

    .line 237
    :cond_0
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 238
    const-string v3, "string"

    const v4, 0x7f1002fb

    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v4, Lcom/jibo/ui/helpers/Items$MemberItem;

    new-instance v5, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$2;

    invoke-direct {v5, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$2;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    invoke-direct {v4, v5, v1, v0, v2}, Lcom/jibo/ui/helpers/Items$MemberItem;-><init>(Landroid/view/View$OnClickListener;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Member;Landroid/os/Bundle;)V

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 249
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v3, 0x7f1002e0

    invoke-direct {v2, v3}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 250
    if-eqz v1, :cond_1

    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 251
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 252
    new-instance v0, Lcom/jibo/ui/helpers/skills/ItemFactory;

    invoke-direct {v0, v6, v6}, Lcom/jibo/ui/helpers/skills/ItemFactory;-><init>([ILcom/jibo/ui/fragment/account/skills/SkillSettingsFragment$DataPublisher;)V

    .line 253
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v1

    invoke-virtual {v1, v6}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getViews([I)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/ItemFactory;->getItems(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 254
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 255
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 269
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v2, 0x7f100337

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 270
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SwitchRowItem;

    new-instance v2, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$3;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v3, 0x7f100322

    .line 284
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/utils/SharedPreferencesUtil;->p(Landroid/content/Context;)Z

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SwitchRowItem;-><init>(Landroid/view/View$OnClickListener;IZ)V

    .line 270
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 285
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SubheaderItem;

    const v2, 0x7f10034e

    invoke-direct {v1, v2}, Lcom/jibo/ui/helpers/Items$SubheaderItem;-><init>(I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 286
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$4;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f10030c

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 295
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$5;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f10033b

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 303
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_bold_single_row:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$6;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$6;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f10031b

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 312
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$7;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$7;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f100334

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 320
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$8;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$8;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f100350

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 328
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$9;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$9;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f100315

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 338
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 339
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v2, Lcom/jibo/ui/helpers/Items$FooterItem;

    const v3, 0x7f1002f5

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {p0, v3, v4}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/jibo/ui/helpers/Items$FooterItem;-><init>(Ljava/lang/CharSequence;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 343
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    new-instance v1, Lcom/jibo/ui/helpers/Items$SimpleItem;

    sget-object v2, Lcom/jibo/ui/helpers/Items$ItemType;->text_button_small_red:Lcom/jibo/ui/helpers/Items$ItemType;

    new-instance v3, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$10;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$10;-><init>(Lcom/jibo/ui/fragment/account/AccountSettingsFragment;)V

    const v4, 0x7f10004f

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 350
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->d:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;->notifyDataSetChanged()V

    .line 351
    return-void

    .line 340
    :catch_0
    move-exception v0

    .line 341
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->a(Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v0, 0x0

    .line 135
    .line 139
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->c:Ljava/util/ArrayList;

    if-eqz v1, :cond_1

    .line 140
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move v1, v0

    move v2, v0

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 141
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v5

    invoke-virtual {v5}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v0, v5}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 142
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    move v1, v3

    :goto_1
    move v2, v1

    move v1, v0

    .line 148
    goto :goto_0

    :cond_0
    move v0, v3

    move v1, v2

    .line 145
    goto :goto_1

    :cond_1
    move v1, v0

    move v2, v0

    .line 150
    :cond_2
    if-eqz v1, :cond_3

    .line 151
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;-><init>()V

    .line 152
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CantDeleteDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 160
    :goto_2
    return-void

    .line 154
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->a(Landroid/content/Context;)V

    .line 155
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    const-class v1, Lcom/jibo/ui/fragment/account/AccountDeleteFragment;

    .line 156
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 157
    const-string v1, "ARG_IS_OWNER_AND_SUSPENDED"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Z)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    .line 158
    const/16 v1, 0x3ea

    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    goto :goto_2

    :cond_4
    move v0, v1

    move v1, v2

    goto :goto_1
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 126
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 127
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    const v0, 0x7f1003f8

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 79
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_LOOPS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARG_LOOPS"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->c:Ljava/util/ArrayList;

    .line 82
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 83
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 87
    const v0, 0x7f0b0083

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 117
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 120
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b()V

    .line 121
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 92
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 94
    new-instance v0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->b:Ljava/util/List;

    .line 95
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v2

    .line 96
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v3

    .line 95
    invoke-static {v2, v3}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;-><init>(Ljava/util/List;Z)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->d:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    .line 97
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    invoke-virtual {v0, v4}, Landroid/support/v7/widget/RecyclerView;->setHasFixedSize(Z)V

    .line 98
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/DefaultItemAnimator;

    invoke-direct {v1}, Landroid/support/v7/widget/DefaultItemAnimator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setItemAnimator(Landroid/support/v7/widget/RecyclerView$ItemAnimator;)V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Landroid/support/v7/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v4, v3}, Landroid/support/v7/widget/LinearLayoutManager;-><init>(Landroid/content/Context;IZ)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setLayoutManager(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V

    .line 100
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    new-instance v1, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$SpacesItemDecoration;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f07004f

    const v4, 0x7f0700b6

    invoke-direct {v1, v2, v3, v4}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter$SpacesItemDecoration;-><init>(Landroid/content/Context;II)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->addItemDecoration(Landroid/support/v7/widget/RecyclerView$ItemDecoration;)V

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->list:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->d:Lcom/jibo/ui/fragment/account/AccountSettingsFragment$SettingsItemsAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setAdapter(Landroid/support/v7/widget/RecyclerView$Adapter;)V

    .line 106
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    if-eqz v0, :cond_0

    .line 107
    new-instance v0, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 108
    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->e:Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 109
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->l:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 107
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 112
    :cond_0
    invoke-direct {p0}, Lcom/jibo/ui/fragment/account/AccountSettingsFragment;->q()V

    .line 113
    return-void
.end method
