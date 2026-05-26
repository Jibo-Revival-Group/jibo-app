.class Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;
.super Ljava/lang/Object;
.source "PasscodeManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/androidsdk/security/PasscodeManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LockChecker"
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/security/PasscodeManager;


# direct methods
.method private constructor <init>(Lcom/salesforce/androidsdk/security/PasscodeManager;)V
    .locals 0

    .prologue
    .line 595
    iput-object p1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/salesforce/androidsdk/security/PasscodeManager;Lcom/salesforce/androidsdk/security/PasscodeManager$1;)V
    .locals 0

    .prologue
    .line 595
    invoke-direct {p0, p1}, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;-><init>(Lcom/salesforce/androidsdk/security/PasscodeManager;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const-wide/16 v4, 0x4e20

    .line 598
    :try_start_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    iget-boolean v0, v0, Lcom/salesforce/androidsdk/security/PasscodeManager;->a:Z

    if-nez v0, :cond_0

    .line 599
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Landroid/app/Activity;Z)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 602
    :cond_0
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-static {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/security/PasscodeManager;)Landroid/os/Handler;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 603
    iget-object v0, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-static {v0}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/security/PasscodeManager;)Landroid/os/Handler;

    move-result-object v0

    invoke-virtual {v0, p0, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 606
    :cond_1
    return-void

    .line 602
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-static {v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/security/PasscodeManager;)Landroid/os/Handler;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 603
    iget-object v1, p0, Lcom/salesforce/androidsdk/security/PasscodeManager$LockChecker;->a:Lcom/salesforce/androidsdk/security/PasscodeManager;

    invoke-static {v1}, Lcom/salesforce/androidsdk/security/PasscodeManager;->a(Lcom/salesforce/androidsdk/security/PasscodeManager;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1, p0, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_2
    throw v0
.end method
