.class public abstract Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;
.super Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;
.source "WiFiBaseQRCodeFragment.java"


# static fields
.field public static final a:Ljava/lang/String;


# instance fields
.field protected b:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

.field protected c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

.field protected l:I

.field protected m:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

.field protected o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

.field private p:Ljava/lang/String;

.field private final q:Ljava/lang/Runnable;

.field private r:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;-><init>()V

    .line 57
    const/4 v0, 0x0

    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->l:I

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    .line 62
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->q:Ljava/lang/Runnable;

    .line 198
    new-instance v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->r:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->q:Ljava/lang/Runnable;

    return-object v0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 396
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 397
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 398
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    rem-int v2, v0, v2

    invoke-virtual {p2, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v3

    xor-int/2addr v2, v3

    int-to-char v2, v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 397
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 400
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 42
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 42
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 42
    invoke-virtual {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Throwable;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic d(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->u()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic e(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->v()V

    return-void
.end method

.method static synthetic f(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic g(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic h(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->k:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    return-object v0
.end method

.method static synthetic i(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/Runnable;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->r:Ljava/lang/Runnable;

    return-object v0
.end method

.method private t()V
    .locals 4

    .prologue
    .line 384
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->b()Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    .line 386
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->isTerminated()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 387
    :cond_0
    new-instance v0, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    new-instance v1, Lcom/amazonaws/auth/BasicAWSCredentials;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v2

    .line 388
    invoke-virtual {v2}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v2

    invoke-virtual {v2}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getAccessKeyId()Ljava/lang/String;

    move-result-object v2

    .line 389
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getSecretAccessKey()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    .line 393
    :cond_1
    return-void
.end method

.method private u()Ljava/lang/String;
    .locals 5

    .prologue
    .line 409
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 410
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_SSID"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 411
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_PASSWORD"

    const-string v4, ""

    .line 412
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 413
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 422
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_IPADDRESS"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_SUBNETMASK"

    const-string v3, ""

    .line 423
    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_ROUTER"

    const-string v3, ""

    .line 424
    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_DNS1"

    const-string v3, ""

    .line 425
    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_DNS2"

    const-string v3, ""

    .line 426
    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 427
    :cond_0
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v2, "ARG_IPADDRESS"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 428
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_SUBNETMASK"

    const-string v4, ""

    .line 429
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 430
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_ROUTER"

    const-string v4, ""

    .line 431
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 432
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_DNS1"

    const-string v4, ""

    .line 433
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 434
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->e:Landroid/os/Bundle;

    const-string v3, "ARG_DNS2"

    const-string v4, ""

    .line 435
    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    .line 436
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 438
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v1}, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;->getToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 439
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private v()V
    .locals 9

    .prologue
    const/4 v0, 0x0

    .line 445
    :try_start_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v1

    if-nez v1, :cond_1

    .line 481
    :cond_0
    :goto_0
    return-void

    .line 448
    :cond_1
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->u()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    .line 451
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    const-string v2, "Wow, you cracked our secret code. Impressive. Maybe you should check out jibo.com/jobs."

    invoke-direct {p0, v1, v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 452
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "codeContent: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 453
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x42480000    # 50.0f

    div-float/2addr v1, v2

    float-to-double v2, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v2

    double-to-int v5, v2

    .line 455
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v1

    int-to-float v1, v1

    int-to-float v2, v5

    div-float/2addr v1, v2

    float-to-double v2, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v6, v2

    .line 458
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 459
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 460
    const/4 v1, 0x1

    move v2, v1

    move v3, v0

    :goto_1
    if-gt v2, v5, :cond_4

    .line 461
    const/4 v1, 0x0

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->length()I

    move-result v8

    invoke-virtual {v7, v1, v8}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    .line 462
    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v8, "/"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v8, "\n"

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 463
    add-int v1, v3, v6

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v8

    if-ge v1, v8, :cond_2

    if-ne v2, v5, :cond_3

    .line 464
    :cond_2
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v1

    .line 463
    :goto_2
    invoke-virtual {v4, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 465
    add-int/2addr v3, v6

    .line 466
    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 460
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    .line 464
    :cond_3
    add-int v1, v3, v6

    goto :goto_2

    :cond_4
    move v1, v0

    .line 474
    :goto_3
    if-ge v1, v5, :cond_0

    .line 475
    sget-object v2, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "code #"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ": "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 474
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 478
    :catch_0
    move-exception v0

    .line 479
    sget-object v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v2, "generateQRCodes"

    invoke-static {v1, v2, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_0
.end method


# virtual methods
.method protected a()V
    .locals 2

    .prologue
    .line 360
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->r:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 361
    return-void
.end method

.method protected a(Landroid/support/v7/app/ActionBar;)V
    .locals 0

    .prologue
    .line 354
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->a(Landroid/support/v7/app/ActionBar;)V

    .line 355
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->k()V

    .line 356
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 335
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->b(Landroid/os/Bundle;)V

    .line 337
    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    .line 338
    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    :goto_0
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    .line 340
    const-string v0, "ARG_QR_CODE_IND"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "ARG_QR_CODE_IND"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    :goto_1
    iput v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->l:I

    .line 341
    const-string v0, "ARG_QR_CODES"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "ARG_QR_CODES"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    :goto_2
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    .line 342
    const-string v0, "ARG_QR_CODE_CONTENT"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "ARG_QR_CODE_CONTENT"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_3
    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    .line 343
    return-void

    .line 338
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    goto :goto_0

    .line 340
    :cond_1
    iget v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->l:I

    goto :goto_1

    .line 341
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    goto :goto_2

    .line 342
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    goto :goto_3
.end method

.method public h()Z
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 347
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/jibo/ui/fragment/wifi/WaitForTapFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 349
    return v2
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 325
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onDestroyView()V

    .line 327
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    if-eqz v0, :cond_0

    .line 328
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->shutdown()V

    .line 329
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c:Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;

    .line 331
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 301
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onPause()V

    .line 303
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->r()V

    .line 305
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->g()V

    .line 307
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a()V

    .line 309
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 311
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 294
    invoke-super {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onResume()V

    .line 296
    invoke-direct {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->t()V

    .line 297
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 315
    invoke-super {p0, p1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 317
    const-class v0, Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->n:Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 318
    const-string v0, "ARG_QR_CODE_IND"

    iget v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->l:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 319
    const-string v1, "ARG_QR_CODES"

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->m:Ljava/util/List;

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 320
    const-string v0, "ARG_QR_CODE_CONTENT"

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->p:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    return-void
.end method

.method protected q()V
    .locals 4

    .prologue
    .line 365
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->q:Ljava/lang/Runnable;

    const-wide/16 v2, 0xfa0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 366
    return-void
.end method

.method protected r()V
    .locals 2

    .prologue
    .line 369
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->r:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 370
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->q:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 371
    return-void
.end method

.method protected abstract s()V
.end method
