.class public Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;
.super Lcom/jibo/ui/fragment/BaseFragment;
.source "RobotSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field private b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

.field btnAbout:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field btnPassphrase:Landroid/view/View;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private c:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

.field private d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

.field private e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field iconPassphrase:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field imgJiboAvatar:Landroid/widget/ImageView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field mRemoteSwitch:Landroid/widget/Switch;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private n:Landroid/view/View$OnClickListener;

.field private o:Landroid/view/View$OnClickListener;

.field passphraseText:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtJiboLocation:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtJiboName:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field txtJiboWifi:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 70
    const-class v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/BaseFragment;-><init>()V

    .line 495
    new-instance v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$7;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$7;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->n:Landroid/view/View$OnClickListener;

    .line 502
    new-instance v0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$8;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->o:Landroid/view/View$OnClickListener;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->n:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object p1
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->l:Ljava/lang/String;

    return-object p1
.end method

.method private a()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 251
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 252
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    .line 251
    invoke-static {v0, v2}, Lcom/jibo/aws/integration/util/KeyManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager;

    move-result-object v0

    .line 256
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/jibo/aws/integration/util/KeyManager;->obtainKeyHolder(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/util/KeyManager$SymmetricKeyHolder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 261
    :goto_0
    if-eqz v0, :cond_0

    const/4 v0, 0x1

    .line 263
    :goto_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v2

    .line 264
    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;

    invoke-direct {v4, p0, v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$2;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Z)V

    invoke-virtual {v2, v3, v1, v4}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 305
    return-void

    .line 257
    :catch_0
    move-exception v0

    move-object v0, v1

    .line 258
    goto :goto_0

    .line 261
    :cond_0
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private a(Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 3

    .prologue
    .line 390
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobotFriendlyId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;

    invoke-direct {v2, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$5;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 453
    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/notification/model/StatusContainer;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b(Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->o:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->m:Ljava/lang/String;

    return-object p1
.end method

.method private b()V
    .locals 3

    .prologue
    .line 312
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->f()V

    .line 313
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    if-eqz v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getRobot()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;

    invoke-direct {v2, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$3;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;->getStatus(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 344
    :cond_0
    :goto_0
    return-void

    .line 341
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method private b(Z)V
    .locals 3

    .prologue
    .line 358
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "remoteEnabled"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 359
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "remoteEnabled"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 361
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 362
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 363
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 366
    :cond_0
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 367
    if-eqz p1, :cond_1

    const v0, 0x7f100266

    :goto_0
    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 368
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 369
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 371
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    new-instance v2, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;

    invoke-direct {v2, p0, p1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$4;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Z)V

    invoke-virtual {v0, v1, v2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 384
    return-void

    .line 367
    :cond_1
    const v0, 0x7f100264

    goto :goto_0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 69
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->l:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->m:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->q()V

    return-void
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic j(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method private q()V
    .locals 3

    .prologue
    .line 347
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "remoteEnabled"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 349
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->mRemoteSwitch:Landroid/widget/Switch;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "remoteEnabled"

    invoke-virtual {v1, v2}, Lcom/google/gson/JsonObject;->c(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/gson/JsonElement;->g()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Switch;->setChecked(Z)V
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    .line 354
    :cond_0
    :goto_0
    return-void

    .line 350
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private r()V
    .locals 4

    .prologue
    .line 456
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->s()V

    .line 457
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$6;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateLoop(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 478
    return-void
.end method

.method private s()V
    .locals 3

    .prologue
    .line 488
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->g()V

    .line 490
    new-instance v0, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 491
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    const v1, 0x7f100211

    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->c(Ljava/lang/String;)V

    .line 492
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->e:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "CircleFragment"

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 493
    return-void
.end method


# virtual methods
.method public a(IILjava/lang/Object;)V
    .locals 2

    .prologue
    .line 183
    invoke-super {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/BaseFragment;->a(IILjava/lang/Object;)V

    .line 184
    const/16 v0, 0x6f

    if-ne p1, v0, :cond_0

    const v0, 0x7f090275

    if-ne p2, v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    check-cast p3, Ljava/lang/String;

    invoke-virtual {v0, p3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setName(Ljava/lang/String;)V

    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->r()V

    .line 189
    :cond_0
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 1

    .prologue
    .line 172
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 173
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 174
    return-void
.end method

.method public btnEnableRemoteClick()V
    .locals 1
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 237
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->mRemoteSwitch:Landroid/widget/Switch;

    invoke-virtual {v0}, Landroid/widget/Switch;->toggle()V

    .line 238
    return-void
.end method

.method public btnHolidaysClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 242
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 243
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 244
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 245
    return-void
.end method

.method public btnJiboAvatarClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 211
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 212
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 213
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 214
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 217
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->q()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/settings/AvatarSelectionFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    return-void
.end method

.method public btnLocationClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 227
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 228
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 229
    const-string v0, "ARGS_LOCATION"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->l:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 230
    const-string v0, "timezone"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->m:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 233
    return-void
.end method

.method public btnWiFiSettingsClick()V
    .locals 2
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 222
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 223
    return-void
.end method

.method public changeName(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 201
    new-instance v0, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;-><init>()V

    .line 202
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 203
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 204
    const/16 v2, 0x6f

    invoke-virtual {v0, p0, v2}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 205
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->setArguments(Landroid/os/Bundle;)V

    .line 206
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/ChangeLoopNameDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 207
    return-void
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .prologue
    .line 178
    const v0, 0x7f100426

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 104
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 106
    if-eqz p1, :cond_1

    .line 107
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    .line 111
    :cond_0
    :goto_0
    return-void

    .line 108
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 109
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 115
    const v0, 0x7f0b008a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 0

    .prologue
    .line 512
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a()V

    .line 513
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 141
    invoke-super {p0}, Lcom/jibo/ui/fragment/BaseFragment;->onResume()V

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 144
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment$1;-><init>(Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;)V

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 161
    :goto_0
    return-void

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->txtJiboName:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    if-eqz v0, :cond_1

    .line 157
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->imgJiboAvatar:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-static {v1}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getAvatar(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageLevel(I)V

    .line 160
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b()V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 165
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/BaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 167
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 168
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 120
    invoke-super {p0, p1, p2}, Lcom/jibo/ui/fragment/BaseFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 122
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v0, :cond_0

    .line 123
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/SharedPreferencesUtil;->f(Landroid/content/Context;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 126
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    .line 127
    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/helpers/LoopHelper;->isOwner(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v1

    invoke-virtual {v1}, Lcom/jibo/db/EntityData;->g()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->b:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    .line 130
    new-instance v1, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    new-instance v2, Lcom/amazonaws/auth/BasicAWSCredentials;

    .line 131
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v3

    .line 132
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v2}, Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->c:Lcom/jibo/aws/integration/aws/services/notification/JiboNotificationAsyncClient;

    .line 130
    invoke-virtual {p0, v1}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;)V

    .line 135
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->a()V

    .line 137
    return-void
.end method

.method public showAbout(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 193
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 194
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 195
    const-class v0, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->d:Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 196
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/settings/RobotSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/RobotAboutFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 197
    return-void
.end method
