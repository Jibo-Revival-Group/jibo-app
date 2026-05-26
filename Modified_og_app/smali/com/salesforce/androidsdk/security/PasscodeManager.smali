.class public Lcom/salesforce/androidsdk/security/PasscodeManager;
.super Ljava/lang/Object;
.source "PasscodeManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/androidsdk/security/PasscodeManager$PasscodeFileFilter;,
        Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;,
        Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;
    }
.end annotation


# instance fields
.field a:Z

.field private b:Ljava/lang/String;

.field private c:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

.field private d:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

.field private e:Landroid/app/Activity;

.field private f:Landroid/os/Handler;

.field private g:J

.field private h:I

.field private i:I

.field private j:Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5

    .prologue
    .line 112
    new-instance v0, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    const-string v1, "vprefix"

    .line 113
    invoke-static {v1}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "vsuffix"

    .line 114
    invoke-static {v2}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "vkey"

    invoke-static {v3}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    const-string v2, "eprefix"

    .line 115
    invoke-static {v2}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "esuffix"

    .line 116
    invoke-static {v3}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ekey"

    invoke-static {v4}, Lcom/salesforce/androidsdk/app/UUIDManager;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    invoke-direct {p0, p1, v0, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;-><init>(Landroid/content/Context;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;)V

    .line 117
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;)V
    .locals 2

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    const/4 v0, 0x4

    iput v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    .line 122
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->k()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->g:J

    .line 123
    iput-object p2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->c:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    .line 124
    iput-object p3, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->d:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    .line 125
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->e(Landroid/content/Context;)V

    .line 128
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    .line 129
    new-instance v0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;-><init>(Lcom/salesforce/androidsdk/security/PasscodeManager;Lcom/salesforce/androidsdk/security/PasscodeManager$1;)V

    iput-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->j:Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;

    .line 130
    return-void
.end method

.method static synthetic a(Lcom/salesforce/androidsdk/security/PasscodeManager;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    return-object v0
.end method

.method private a(Ljava/lang/String;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 588
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p2, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p2, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->b:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p2, Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;->c:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/analytics/security/Encryptor;->d(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private b(I)V
    .locals 3

    .prologue
    .line 364
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    const-string v1, "user"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 365
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 366
    const-string v1, "failed_attempts"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 367
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 368
    return-void
.end method

.method private d(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 327
    if-nez p1, :cond_1

    move v0, v1

    .line 328
    :goto_0
    if-lez v0, :cond_0

    const-string v2, "\n"

    invoke-virtual {p1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 329
    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p1, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 331
    :cond_0
    return-object p1

    .line 327
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    goto :goto_0
.end method

.method private d(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 192
    if-eqz p1, :cond_0

    .line 193
    const-string v0, "mobile_policy"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 195
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 196
    const-string v1, "access_timeout"

    iget v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 197
    const-string v1, "passcode_length"

    iget v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 198
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 200
    :cond_0
    return-void
.end method

.method private e(Landroid/content/Context;)V
    .locals 4

    .prologue
    const/4 v3, 0x4

    const/4 v2, 0x0

    .line 210
    if-eqz p1, :cond_1

    .line 211
    const-string v0, "mobile_policy"

    invoke-virtual {p1, v0, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 213
    const-string v1, "access_timeout"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "passcode_length"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 214
    :cond_0
    iput v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    .line 215
    iput v3, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    .line 216
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d(Landroid/content/Context;)V

    .line 222
    :cond_1
    :goto_0
    return-void

    .line 219
    :cond_2
    const-string v1, "access_timeout"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    .line 220
    const-string v1, "passcode_length"

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    goto :goto_0
.end method

.method private l()V
    .locals 2

    .prologue
    .line 576
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->k()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->g:J

    .line 577
    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 3

    .prologue
    .line 471
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    if-ne v0, p1, :cond_0

    .line 490
    :goto_0
    return-void

    .line 480
    :cond_0
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    if-lez v0, :cond_2

    if-lez p1, :cond_2

    .line 481
    :cond_1
    iput p1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    .line 482
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d(Landroid/content/Context;)V

    goto :goto_0

    .line 487
    :cond_2
    iput p1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    .line 488
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->b:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 489
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public a(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 434
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Z)V

    .line 435
    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/4 v1, 0x0

    .line 230
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/shared_prefs"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 231
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 232
    new-instance v3, Lcom/salesforce/androidsdk/security/PasscodeManager$PasscodeFileFilter;

    invoke-direct {v3, v8}, Lcom/salesforce/androidsdk/security/PasscodeManager$PasscodeFileFilter;-><init>(Lcom/salesforce/androidsdk/security/PasscodeManager$1;)V

    .line 233
    invoke-virtual {v2}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    array-length v5, v4

    move v0, v1

    :goto_0
    if-ge v0, v5, :cond_1

    aget-object v6, v4, v0

    .line 234
    if-eqz v6, :cond_0

    invoke-virtual {v6}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v2, v7}, Lcom/salesforce/androidsdk/security/PasscodeManager$PasscodeFileFilter;->accept(Ljava/io/File;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 235
    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 233
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 238
    :cond_1
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->k()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->g:J

    .line 239
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    .line 240
    iput-object v8, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->b:Ljava/lang/String;

    .line 241
    const-string v0, "user"

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 243
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 244
    const-string v2, "passcode"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 245
    const-string v2, "failed_attempts"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 246
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 247
    iput v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    .line 248
    const/4 v0, 0x4

    iput v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    .line 249
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d(Landroid/content/Context;)V

    .line 250
    iput-object v8, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    .line 251
    return-void
.end method

.method public a(Landroid/content/Context;Z)V
    .locals 2

    .prologue
    .line 535
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    .line 536
    if-eqz p1, :cond_1

    .line 537
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->i()Ljava/lang/Class;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 538
    const/high16 v1, 0x20000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 539
    const/high16 v1, 0x40000000    # 2.0f

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 540
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 541
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v1

    if-ne p1, v1, :cond_0

    .line 542
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 544
    :cond_0
    const-string v1, "change_passcode"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 545
    instance-of v1, p1, Landroid/app/Activity;

    if-eqz v1, :cond_2

    .line 546
    check-cast p1, Landroid/app/Activity;

    const/16 v1, 0x309

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 551
    :cond_1
    :goto_0
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppLocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V

    .line 552
    return-void

    .line 548
    :cond_2
    invoke-virtual {p1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public a(Lcom/salesforce/androidsdk/accounts/UserAccount;II)V
    .locals 3

    .prologue
    .line 172
    if-nez p1, :cond_0

    .line 182
    :goto_0
    return-void

    .line 175
    :cond_0
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    .line 176
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "mobile_policy"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 177
    invoke-virtual {p1}, Lcom/salesforce/androidsdk/accounts/UserAccount;->t()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    .line 176
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 178
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 179
    const-string v1, "access_timeout"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 180
    const-string v1, "passcode_length"

    invoke-interface {v0, v1, p3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 181
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 555
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->b:Ljava/lang/String;

    .line 556
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->j()V

    .line 557
    return-void
.end method

.method public a(Z)V
    .locals 4

    .prologue
    .line 274
    if-eqz p1, :cond_0

    .line 275
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    .line 276
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->j:Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;

    const-wide/16 v2, 0x4e20

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 283
    :goto_0
    return-void

    .line 278
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    if-eqz v0, :cond_1

    .line 279
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    iget-object v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->j:Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 281
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    goto :goto_0
.end method

.method public a()Z
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->f:Landroid/os/Handler;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/app/Activity;Z)Z
    .locals 1

    .prologue
    .line 408
    if-eqz p1, :cond_0

    .line 409
    iput-object p1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->e:Landroid/app/Activity;

    .line 410
    :cond_0
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->e()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->i()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 411
    :cond_1
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->e:Landroid/app/Activity;

    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->c(Landroid/content/Context;)V

    .line 412
    const/4 v0, 0x1

    .line 415
    :goto_0
    return v0

    .line 414
    :cond_2
    if-eqz p2, :cond_3

    invoke-direct {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->l()V

    .line 415
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public a(Landroid/content/Context;I)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 510
    const/4 v1, 0x0

    .line 511
    iget v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    if-le p2, v2, :cond_0

    .line 512
    iput p2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    .line 520
    invoke-virtual {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 521
    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;Z)V

    .line 525
    :goto_0
    iput p2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    .line 526
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d(Landroid/content/Context;)V

    .line 527
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public a(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 307
    const-string v0, "user"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 308
    const-string v1, "passcode"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 309
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 310
    if-eqz v0, :cond_0

    .line 311
    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 317
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 296
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->c()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .line 297
    invoke-direct {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(I)V

    .line 298
    return v0
.end method

.method public b(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 580
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->c:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    invoke-direct {p0, p1, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public b(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 340
    const-string v0, "user"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 341
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 342
    const-string v1, "passcode"

    invoke-virtual {p0, p2}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 343
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 344
    return-void
.end method

.method public b(Landroid/app/Activity;)Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 447
    invoke-virtual {p0, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Z)V

    .line 450
    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/app/Activity;Z)Z

    .line 453
    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->e()Z

    move-result v1

    if-nez v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b(Landroid/content/Context;)Z
    .locals 2

    .prologue
    .line 351
    const-string v0, "user"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 352
    const-string v1, "passcode"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public c()I
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 359
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->k()Landroid/content/Context;

    move-result-object v0

    const-string v1, "user"

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 360
    const-string v1, "failed_attempts"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public c(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 584
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->d:Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;

    invoke-direct {p0, p1, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/security/PasscodeManager$HashConfig;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public c(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 399
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/content/Context;Z)V

    .line 400
    return-void
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 374
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->b:Ljava/lang/String;

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 392
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    if-lez v0, :cond_0

    iget-boolean v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public f()V
    .locals 0

    .prologue
    .line 460
    invoke-direct {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->l()V

    .line 461
    return-void
.end method

.method public g()I
    .locals 1

    .prologue
    .line 493
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    return v0
.end method

.method public h()I
    .locals 1

    .prologue
    .line 497
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->i:I

    return v0
.end method

.method public i()Z
    .locals 6

    .prologue
    .line 531
    iget v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->k()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->g:J

    iget v4, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->h:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public j()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 564
    const-string v0, "passcodeUnlock"

    const-string v1, "PasscodeManager"

    invoke-static {v0, v3, v1, v3}, Lcom/salesforce/androidsdk/analytics/EventBuilderHelper;->a(Ljava/lang/String;Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;Lorg/json/JSONObject;)V

    .line 565
    iput-boolean v2, p0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    .line 566
    invoke-direct {p0, v2}, Lcom/salesforce/androidsdk/security/PasscodeManager;->b(I)V

    .line 567
    invoke-direct {p0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->l()V

    .line 568
    invoke-static {}, Lcom/salesforce/androidsdk/util/EventsObservable;->a()Lcom/salesforce/androidsdk/util/EventsObservable;

    move-result-object v0

    sget-object v1, Lcom/salesforce/androidsdk/util/EventsObservable$EventType;->AppUnlocked:Lcom/salesforce/androidsdk/util/EventsObservable$EventType;

    invoke-virtual {v0, v1}, Lcom/salesforce/androidsdk/util/EventsObservable;->a(Lcom/salesforce/androidsdk/util/EventsObservable$EventType;)V

    .line 569
    return-void
.end method

.method protected k()J
    .locals 2

    .prologue
    .line 572
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method
