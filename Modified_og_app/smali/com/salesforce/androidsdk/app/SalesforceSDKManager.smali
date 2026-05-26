.class public Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
.super Ljava/lang/Object;
.source "SalesforceSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;,
        Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;,
        Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;
    }
.end annotation


# static fields
.field protected static a:Ljava/lang/String;

.field protected static b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

.field private static final k:Ljava/lang/String;


# instance fields
.field protected c:Landroid/content/Context;

.field protected d:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;

.field protected e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

.field protected f:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field protected g:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field protected h:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/ui/PasscodeActivity;",
            ">;"
        }
    .end annotation
.end field

.field protected i:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;",
            ">;"
        }
    .end annotation
.end field

.field private j:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;

.field private l:Ljava/lang/String;

.field private m:Lcom/salesforce/androidsdk/ui/SalesforceR;

.field private n:Lcom/salesforce/androidsdk/security/PasscodeManager;

.field private o:Lcom/salesforce/androidsdk/config/LoginServerManager;

.field private p:Z

.field private q:Z

.field private r:Lcom/salesforce/androidsdk/config/AdminSettingsManager;

.field private s:Lcom/salesforce/androidsdk/config/AdminPermsManager;

.field private t:Lcom/salesforce/androidsdk/push/PushNotificationInterface;

.field private u:Ljava/lang/String;

.field private volatile v:Z

.field private w:Ljava/util/SortedSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/SortedSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private y:Ljava/lang/String;

.field private z:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 111
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 214
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 142
    const-class v0, Lcom/salesforce/androidsdk/ui/LoginActivity;

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->g:Ljava/lang/Class;

    .line 143
    const-class v0, Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h:Ljava/lang/Class;

    .line 144
    const-class v0, Lcom/salesforce/androidsdk/ui/AccountSwitcherActivity;

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->i:Ljava/lang/Class;

    .line 146
    new-instance v0, Lcom/salesforce/androidsdk/ui/SalesforceR;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/ui/SalesforceR;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->m:Lcom/salesforce/androidsdk/ui/SalesforceR;

    .line 149
    iput-boolean v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->p:Z

    .line 150
    iput-boolean v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q:Z

    .line 155
    iput-boolean v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v:Z

    .line 163
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->z:Ljava/lang/Object;

    .line 215
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v2, "android_id"

    invoke-static {v0, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->u:Ljava/lang/String;

    .line 216
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    .line 217
    iput-object p2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;

    .line 218
    iput-object p3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f:Ljava/lang/Class;

    .line 219
    if-eqz p4, :cond_0

    .line 220
    iput-object p4, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->g:Ljava/lang/Class;

    .line 222
    :cond_0
    new-instance v0, Ljava/util/TreeSet;

    sget-object v2, Ljava/lang/String;->CASE_INSENSITIVE_ORDER:Ljava/util/Comparator;

    invoke-direct {v0, v2}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->w:Ljava/util/SortedSet;

    .line 228
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c()Ljava/lang/String;

    move-result-object v0

    .line 229
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 232
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 233
    iget-object v0, v0, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v0, v0, Landroid/content/pm/ApplicationInfo;->labelRes:I

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 237
    :goto_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 238
    invoke-static {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Ljava/lang/String;)V

    .line 243
    :cond_1
    new-instance v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;

    invoke-direct {v0, p0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;

    .line 244
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$CleanupReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "com.salesforce.CLEANUP"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 245
    return-void

    .line 234
    :catch_0
    move-exception v0

    .line 235
    const-string v2, "SalesforceSDKManager"

    const-string v3, "Package not found"

    invoke-static {v2, v3, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    goto :goto_0
.end method

.method static synthetic G()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k:Ljava/lang/String;

    return-object v0
.end method

.method private H()V
    .locals 2

    .prologue
    .line 1228
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.LOGOUT_COMPLETE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1229
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 1230
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 1231
    return-void
.end method

.method public static a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
    .locals 2

    .prologue
    .line 171
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    if-eqz v0, :cond_0

    .line 172
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    return-object v0

    .line 174
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Applications need to call SalesforceSDKManager.init() first."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private a(Landroid/app/Activity;Landroid/accounts/Account;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 690
    invoke-static {}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 693
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 696
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 698
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v0

    .line 701
    if-eqz p1, :cond_1

    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-gt v1, v3, :cond_1

    .line 702
    :cond_0
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 713
    :cond_1
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gt v0, v3, :cond_3

    .line 714
    :cond_2
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->p()Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/AdminSettingsManager;->c()V

    .line 715
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q()Lcom/salesforce/androidsdk/config/AdminPermsManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/config/AdminPermsManager;->c()V

    .line 716
    iput-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->r:Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    .line 717
    iput-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s:Lcom/salesforce/androidsdk/config/AdminPermsManager;

    .line 718
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;)V

    .line 719
    iput-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 720
    iput-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l:Ljava/lang/String;

    .line 721
    invoke-static {}, Lcom/salesforce/androidsdk/app/UUIDManager;->a()V

    .line 723
    :cond_3
    return-void
.end method

.method private declared-synchronized a(Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 8

    .prologue
    .line 851
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 853
    :try_start_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_0
    move-object v0, p0

    move-object v1, p2

    move v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    move-object v6, p7

    move-object/from16 v7, p8

    .line 857
    :try_start_2
    invoke-direct/range {v0 .. v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 859
    :cond_0
    monitor-exit p0

    return-void

    .line 854
    :catch_0
    move-exception v0

    .line 855
    :try_start_3
    const-string v1, "SalesforceSDKManager"

    const-string v2, "Exception occurred while unregistering"

    invoke-static {v1, v2, v0}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 851
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 410
    invoke-static {p0}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a(Landroid/content/Context;)Z

    .line 413
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->y()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/auth/HttpAccess;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 416
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKUpgradeManager;->b()V

    .line 417
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 91
    invoke-direct/range {p0 .. p8}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Z)V
    .locals 0

    .prologue
    .line 91
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Z)V

    return-void
.end method

.method private a(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 12

    .prologue
    .line 797
    new-instance v10, Landroid/content/IntentFilter;

    const-string v1, "com.salesfore.mobilesdk.c2dm.UNREGISTERED"

    invoke-direct {v10, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 798
    new-instance v1, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    move-object v5, p3

    move-object/from16 v6, p4

    move-object/from16 v7, p5

    move-object/from16 v8, p6

    move-object/from16 v9, p7

    invoke-direct/range {v1 .. v9}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$1;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 808
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1, v10}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 811
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v2

    move-object/from16 v0, p6

    invoke-virtual {v2, v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v2

    .line 812
    iget-object v3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v3, v2}, Lcom/salesforce/androidsdk/push/PushMessaging;->b(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 818
    new-instance v2, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;

    move-object v3, p0

    move-object v4, v1

    move-object v5, p1

    move v6, p2

    move-object v7, p3

    move-object/from16 v8, p4

    move-object/from16 v9, p5

    move-object/from16 v10, p6

    move-object/from16 v11, p7

    invoke-direct/range {v2 .. v11}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Landroid/content/BroadcastReceiver;Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 829
    invoke-virtual {v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$2;->start()V

    .line 830
    return-void
.end method

.method public static a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 192
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 193
    sput-object p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a:Ljava/lang/String;

    .line 195
    :cond_0
    return-void
.end method

.method private a(Z)V
    .locals 2

    .prologue
    .line 1002
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->LogoutComplete:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V

    .line 1003
    invoke-direct {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->H()V

    .line 1004
    if-eqz p1, :cond_0

    .line 1005
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->x()V

    .line 1007
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;)Z
    .locals 1

    .prologue
    .line 91
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v:Z

    return v0
.end method

.method private b(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 3

    .prologue
    .line 1234
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.salesforce.CLEANUP"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1235
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 1236
    const-string v1, "processId"

    sget-object v2, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1237
    if-eqz p1, :cond_0

    .line 1238
    const-string v1, "userAccount"

    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->w()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 1240
    :cond_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 1241
    return-void
.end method

.method private b(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 950
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v:Z

    .line 951
    invoke-direct {p0, p7, p6}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;Landroid/accounts/Account;)V

    .line 962
    if-nez p6, :cond_4

    .line 963
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    .line 964
    if-eqz v0, :cond_3

    .line 965
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v2

    .line 966
    array-length v0, v2

    if-lez v0, :cond_2

    move v0, v1

    .line 967
    :goto_0
    array-length v3, v2

    add-int/lit8 v3, v3, -0x1

    if-ge v0, v3, :cond_0

    .line 968
    invoke-virtual {p1, v2}, Lcom/salesforce/androidsdk/rest/ClientManager;->a([Landroid/accounts/Account;)V

    .line 967
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 970
    :cond_0
    array-length v0, v2

    add-int/lit8 v0, v0, -0x1

    aget-object v0, v2, v0

    new-instance v2, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;

    invoke-direct {v2, p0, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$3;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Z)V

    invoke-virtual {p1, v0, v2}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;)V

    .line 993
    :goto_1
    iput-boolean v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q:Z

    .line 996
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v0

    if-eqz v0, :cond_1

    if-eqz p6, :cond_1

    if-eqz p3, :cond_1

    .line 997
    new-instance v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;

    invoke-direct {v0, p0, p3, p4, p5}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$RevokeTokenTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 999
    :cond_1
    return-void

    .line 979
    :cond_2
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Z)V

    goto :goto_1

    .line 982
    :cond_3
    invoke-direct {p0, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Z)V

    goto :goto_1

    .line 985
    :cond_4
    new-instance v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$4;

    invoke-direct {v0, p0, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$4;-><init>(Lcom/salesforce/androidsdk/app/SalesforceSDKManager;Z)V

    invoke-virtual {p1, p6, v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;)V

    goto :goto_1
.end method

.method public static b()Z
    .locals 1

    .prologue
    .line 183
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a:Ljava/lang/String;

    return-object v0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1102
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1113
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public A()Z
    .locals 1

    .prologue
    .line 1065
    const/4 v0, 0x0

    return v0
.end method

.method public B()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1074
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e()Lcom/salesforce/androidsdk/ui/SalesforceR;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/ui/SalesforceR;->a()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public C()Z
    .locals 1

    .prologue
    .line 1150
    sget-object v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b:Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    iget-boolean v0, v0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->p:Z

    return v0
.end method

.method public D()Z
    .locals 1

    .prologue
    .line 1168
    iget-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q:Z

    return v0
.end method

.method public E()Lcom/salesforce/androidsdk/rest/ClientManager;
    .locals 5

    .prologue
    .line 1175
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v3

    const/4 v4, 0x1

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    return-object v0
.end method

.method public F()V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x15
    .end annotation

    .prologue
    .line 1191
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x15

    if-lt v0, v1, :cond_0

    .line 1192
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/webkit/CookieManager;->removeAllCookies(Landroid/webkit/ValueCallback;)V

    .line 1197
    :goto_0
    return-void

    .line 1194
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 1195
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeAllCookie()V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 369
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    if-nez v0, :cond_1

    .line 370
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/salesforce/androidsdk/config/BootConfig;->a(Landroid/content/Context;)Lcom/salesforce/androidsdk/config/BootConfig;

    move-result-object v1

    .line 371
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 372
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->b()Ljava/lang/String;

    move-result-object v3

    .line 373
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->c()[Ljava/lang/String;

    move-result-object v5

    move-object v1, p2

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    .line 382
    :goto_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    return-object v0

    .line 375
    :cond_0
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->b()Ljava/lang/String;

    move-result-object v3

    .line 376
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/config/BootConfig;->c()[Ljava/lang/String;

    move-result-object v5

    move-object v1, p2

    move-object v7, p1

    invoke-direct/range {v0 .. v7}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    goto :goto_0

    .line 379
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->a(Ljava/lang/String;)V

    .line 380
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e:Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    invoke-virtual {v0, p2}, Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;->b(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(Landroid/accounts/Account;Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 877
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/accounts/Account;Landroid/app/Activity;Z)V

    .line 878
    return-void
.end method

.method public a(Landroid/accounts/Account;Landroid/app/Activity;Z)V
    .locals 8

    .prologue
    const/4 v5, 0x0

    .line 903
    const-string v0, "userLogout"

    const-string v1, "SalesforceSDKManager"

    invoke-static {v0, v5, v1, v5}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 904
    new-instance v1, Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    .line 905
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v3

    invoke-direct {v1, v0, v2, v5, v3}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    .line 906
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->q:Z

    .line 907
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    .line 911
    if-eqz p1, :cond_1

    .line 912
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t()Ljava/lang/String;

    move-result-object v2

    .line 913
    invoke-virtual {v0, p1}, Landroid/accounts/AccountManager;->getPassword(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 915
    const-string v4, "clientId"

    invoke-virtual {v0, p1, v4}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 917
    const-string v5, "instanceUrl"

    invoke-virtual {v0, p1, v5}, Landroid/accounts/AccountManager;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 925
    :goto_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/accounts/Account;)Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    .line 926
    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-static {v2, v0}, Lcom/salesforce/androidsdk/push/PushMessaging;->f(Landroid/content/Context;Lcom/salesforce/androidsdk/accounts/UserAccount;)Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz v3, :cond_0

    .line 927
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->v:Z

    move-object v0, p0

    move v2, p3

    move-object v6, p1

    move-object v7, p2

    .line 928
    invoke-direct/range {v0 .. v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    .line 934
    :goto_1
    return-void

    :cond_0
    move-object v0, p0

    move v2, p3

    move-object v6, p1

    move-object v7, p2

    .line 931
    invoke-direct/range {v0 .. v7}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V

    goto :goto_1

    :cond_1
    move-object v4, v5

    move-object v3, v5

    goto :goto_0
.end method

.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 867
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;Z)V

    .line 868
    return-void
.end method

.method public a(Landroid/app/Activity;Z)V
    .locals 5

    .prologue
    .line 888
    new-instance v0, Lcom/salesforce/androidsdk/rest/ClientManager;

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    .line 889
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->j()Z

    move-result v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/salesforce/androidsdk/rest/ClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;Z)V

    .line 890
    invoke-virtual {v0}, Lcom/salesforce/androidsdk/rest/ClientManager;->c()Landroid/accounts/Account;

    move-result-object v0

    .line 891
    invoke-virtual {p0, v0, p1, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/accounts/Account;Landroid/app/Activity;Z)V

    .line 892
    return-void
.end method

.method protected a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 0

    .prologue
    .line 731
    invoke-static {p1}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->b(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 732
    invoke-static {p1}, Lcom/salesforce/androidsdk/rest/RestClient;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    .line 733
    return-void
.end method

.method public declared-synchronized a(Lcom/salesforce/androidsdk/push/PushNotificationInterface;)V
    .locals 1

    .prologue
    .line 505
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t:Lcom/salesforce/androidsdk/push/PushNotificationInterface;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 506
    monitor-exit p0

    return-void

    .line 505
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public b(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 323
    const/4 v0, 0x0

    .line 324
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;

    if-eqz v1, :cond_0

    .line 325
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d:Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;

    invoke-interface {v0, p1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager$KeyInterface;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 327
    :cond_0
    return-object v0
.end method

.method public declared-synchronized b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 571
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1, p2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 579
    :goto_0
    monitor-exit p0

    return-void

    .line 576
    :cond_0
    const/4 v0, 0x0

    :try_start_1
    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l:Ljava/lang/String;

    .line 577
    invoke-static {p1, p2}, Lcom/salesforce/androidsdk/analytics/SalesforceAnalyticsManager;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 578
    invoke-static {p1, p2}, Lcom/salesforce/androidsdk/rest/ClientManager;->a(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 571
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized c(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 600
    monitor-enter p0

    if-eqz p1, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_0

    .line 606
    :goto_0
    monitor-exit p0

    return-object p1

    .line 603
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 604
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l:Ljava/lang/String;

    .line 606
    :cond_1
    iget-object p1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->l:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 600
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected c(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2

    .prologue
    .line 589
    if-nez p1, :cond_0

    if-eqz p2, :cond_2

    :cond_0
    if-eqz p1, :cond_1

    if-eqz p2, :cond_1

    .line 590
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    .line 589
    :goto_0
    return v0

    .line 590
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public d()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 253
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->f:Ljava/lang/Class;

    return-object v0
.end method

.method public d(Ljava/lang/String;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 1020
    const-string v2, ""

    .line 1021
    const-string v0, ""

    .line 1023
    :try_start_0
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    iget-object v3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    .line 1024
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    iget-object v4, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->labelRes:I

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 1025
    :try_start_1
    iget-object v0, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Landroid/content/res/Resources$NotFoundException; {:try_start_1 .. :try_end_1} :catch_2

    .line 1033
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->z()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1034
    const-string v3, "SalesforceMobileSDK/%s android mobile/%s (%s) %s/%s %s uid_%s ftr_%s"

    const/16 v4, 0x8

    new-array v4, v4, [Ljava/lang/Object;

    const-string v5, "5.3.0"

    aput-object v5, v4, v6

    const/4 v5, 0x1

    sget-object v6, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x2

    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x3

    aput-object v1, v4, v5

    const/4 v1, 0x4

    aput-object v0, v4, v1

    const/4 v0, 0x5

    aput-object v2, v4, v0

    const/4 v0, 0x6

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->u:Ljava/lang/String;

    aput-object v1, v4, v0

    const/4 v0, 0x7

    const-string v1, "."

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->w:Ljava/util/SortedSet;

    .line 1035
    invoke-static {v1, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v0

    .line 1034
    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 1026
    :catch_0
    move-exception v1

    move-object v7, v1

    move-object v1, v2

    move-object v2, v7

    .line 1027
    :goto_1
    const-string v3, "SalesforceSDKManager"

    const-string v4, "Package info could not be retrieved"

    invoke-static {v3, v4, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1028
    :catch_1
    move-exception v1

    move-object v7, v1

    move-object v1, v2

    move-object v2, v7

    .line 1031
    :goto_2
    const-string v3, "SalesforceSDKManager"

    const-string v4, "Package info could not be retrieved"

    invoke-static {v3, v4, v2}, Lcom/salesforce/androidsdk/util/SalesforceSDKLogger;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 1028
    :catch_2
    move-exception v2

    goto :goto_2

    .line 1026
    :catch_3
    move-exception v2

    goto :goto_1
.end method

.method public e()Lcom/salesforce/androidsdk/ui/SalesforceR;
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->m:Lcom/salesforce/androidsdk/ui/SalesforceR;

    return-object v0
.end method

.method public e(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1042
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->w:Ljava/util/SortedSet;

    invoke-interface {v0, p1}, Ljava/util/SortedSet;->add(Ljava/lang/Object;)Z

    .line 1043
    return-void
.end method

.method public f()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 347
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->g:Ljava/lang/Class;

    return-object v0
.end method

.method public f(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1049
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->w:Ljava/util/SortedSet;

    invoke-interface {v0, p1}, Ljava/util/SortedSet;->remove(Ljava/lang/Object;)Z

    .line 1050
    return-void
.end method

.method public g()Ljava/lang/String;
    .locals 1

    .prologue
    .line 356
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->u:Ljava/lang/String;

    return-object v0
.end method

.method public h()Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 365
    invoke-virtual {p0, v0, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/salesforce/androidsdk/rest/ClientManager$LoginOptions;

    move-result-object v0

    return-object v0
.end method

.method public i()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Lcom/salesforce/androidsdk/ui/PasscodeActivity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 463
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->h:Ljava/lang/Class;

    return-object v0
.end method

.method public j()Z
    .locals 1

    .prologue
    .line 475
    const/4 v0, 0x1

    return v0
.end method

.method public k()Landroid/content/Context;
    .locals 1

    .prologue
    .line 484
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    return-object v0
.end method

.method public declared-synchronized l()Lcom/salesforce/androidsdk/config/LoginServerManager;
    .locals 2

    .prologue
    .line 493
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o:Lcom/salesforce/androidsdk/config/LoginServerManager;

    if-nez v0, :cond_0

    .line 494
    new-instance v0, Lcom/salesforce/androidsdk/config/LoginServerManager;

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/salesforce/androidsdk/config/LoginServerManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o:Lcom/salesforce/androidsdk/config/LoginServerManager;

    .line 496
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o:Lcom/salesforce/androidsdk/config/LoginServerManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 493
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized m()Lcom/salesforce/androidsdk/push/PushNotificationInterface;
    .locals 1

    .prologue
    .line 514
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->t:Lcom/salesforce/androidsdk/push/PushNotificationInterface;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public n()Lcom/salesforce/androidsdk/security/PasscodeManager;
    .locals 3

    .prologue
    .line 523
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->z:Ljava/lang/Object;

    monitor-enter v1

    .line 524
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    if-nez v0, :cond_0

    .line 525
    new-instance v0, Lcom/salesforce/androidsdk/security/PasscodeManager;

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-direct {v0, v2}, Lcom/salesforce/androidsdk/security/PasscodeManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    .line 527
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    monitor-exit v1

    return-object v0

    .line 528
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;
    .locals 1

    .prologue
    .line 537
    invoke-static {}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized p()Lcom/salesforce/androidsdk/config/AdminSettingsManager;
    .locals 1

    .prologue
    .line 546
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->r:Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    if-nez v0, :cond_0

    .line 547
    new-instance v0, Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/config/AdminSettingsManager;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->r:Lcom/salesforce/androidsdk/config/AdminSettingsManager;

    .line 549
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->r:Lcom/salesforce/androidsdk/config/AdminSettingsManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 546
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized q()Lcom/salesforce/androidsdk/config/AdminPermsManager;
    .locals 1

    .prologue
    .line 558
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s:Lcom/salesforce/androidsdk/config/AdminPermsManager;

    if-nez v0, :cond_0

    .line 559
    new-instance v0, Lcom/salesforce/androidsdk/config/AdminPermsManager;

    invoke-direct {v0}, Lcom/salesforce/androidsdk/config/AdminPermsManager;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s:Lcom/salesforce/androidsdk/config/AdminPermsManager;

    .line 561
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->s:Lcom/salesforce/androidsdk/config/AdminPermsManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 558
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public r()Ljava/lang/String;
    .locals 1

    .prologue
    .line 615
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->y:Ljava/lang/String;

    return-object v0
.end method

.method public s()Ljava/lang/String;
    .locals 1

    .prologue
    .line 635
    const-string v0, "Salesforce"

    return-object v0
.end method

.method public t()Ljava/lang/String;
    .locals 1

    .prologue
    .line 644
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n()Lcom/salesforce/androidsdk/security/PasscodeManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1079
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1080
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": {\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   accountType: "

    .line 1081
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->B()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   userAgent: "

    .line 1082
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->y()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   mainActivityClass: "

    .line 1083
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "   isFileSystemEncrypted: "

    .line 1084
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->b()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1085
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    if-eqz v1, :cond_0

    .line 1088
    const-string v1, "   hasStoredPasscode: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->n:Lcom/salesforce/androidsdk/security/PasscodeManager;

    iget-object v3, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v2, v3}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/content/Context;)Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1090
    :cond_0
    const-string v1, "}\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1091
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public u()Ljava/lang/String;
    .locals 2

    .prologue
    .line 653
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public v()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 680
    iget-object v0, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->x:Ljava/util/List;

    return-object v0
.end method

.method protected w()V
    .locals 3

    .prologue
    .line 741
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->F()V

    .line 744
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d()Ljava/lang/Class;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 745
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 746
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 747
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 748
    return-void
.end method

.method public x()V
    .locals 4

    .prologue
    .line 756
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->F()V

    .line 765
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v1

    .line 766
    invoke-virtual {v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v0

    .line 767
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 768
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->w()V

    .line 776
    :goto_0
    return-void

    .line 769
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 770
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;ILandroid/os/Bundle;)V

    goto :goto_0

    .line 772
    :cond_2
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    iget-object v2, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->i:Ljava/lang/Class;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 773
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 774
    iget-object v1, p0, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->c:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public final y()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1016
    const-string v0, ""

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public z()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1056
    const-string v0, "Native"

    return-object v0
.end method
