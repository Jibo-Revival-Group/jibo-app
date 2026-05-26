.class public Lcom/jibo/ui/fragment/account/skills/LocationFragment;
.super Lcom/jibo/ui/fragment/settings/LocationFragment;
.source "LocationFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

.field private c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

.field private p:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

.field protected txtLocation:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field protected txtTimezone:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-class v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/LocationFragment;-><init>()V

    .line 56
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/account/skills/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 37
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->p:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    return-object v0
.end method


# virtual methods
.method protected a()V
    .locals 3

    .prologue
    .line 178
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 179
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyLocation()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_0
    const v0, 0x7f100278

    .line 180
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 179
    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 182
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtLocation:Landroid/widget/TextView;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 183
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyTimezone()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    .line 184
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyTimezone()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\\/"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 186
    :goto_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->txtTimezone:Landroid/widget/TextView;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    const v0, 0x7f10031a

    .line 187
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 186
    :cond_1
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 189
    return-void

    .line 180
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    .line 181
    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;->getFriendlyLocation()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 184
    :cond_3
    const-string v0, ""

    goto :goto_1
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 164
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 165
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 166
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 150
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->b(Landroid/os/Bundle;)V

    .line 152
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isCreated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 160
    :goto_0
    return-void

    .line 156
    :cond_0
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v1, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    .line 158
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataValue;

    goto :goto_0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 170
    const v0, 0x7f100408

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 143
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 144
    const-class v0, Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$LocationDataItem;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    const-string v0, "ARGS_SKILL_FRAGMENT"

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 146
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 60
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 62
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 63
    if-eqz v0, :cond_0

    .line 64
    new-instance v1, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 65
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 66
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->p:Lcom/jibo/aws/integration/aws/services/skills/JiboSkillsAsyncClient;

    .line 64
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 69
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment$1;-><init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->n:Lcom/jibo/ui/fragment/settings/LocationFragment$AsyncGeocoderTaskProcessor;

    .line 139
    return-void
.end method

.method public setManuallyClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 193
    new-instance v0, Lcom/jibo/ui/fragment/account/skills/LocationFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment$2;-><init>(Lcom/jibo/ui/fragment/account/skills/LocationFragment;)V

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/account/skills/LocationFragment;->a(Lcom/jibo/ui/fragment/settings/LocationFragment$ManualLocationFragmentListener;)V

    .line 199
    return-void
.end method
