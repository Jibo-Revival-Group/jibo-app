.class public Lcom/jibo/ui/activity/SingleFragmentActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "SingleFragmentActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;
    }
.end annotation


# static fields
.field public static final h:Ljava/lang/String;

.field public static final i:Ljava/lang/String;


# instance fields
.field private j:Landroid/content/Intent;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    const-class v0, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/SingleFragmentActivity;->h:Ljava/lang/String;

    .line 25
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/jibo/ui/activity/SingleFragmentActivity;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".FRAGMENT_CLASS"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/SingleFragmentActivity;->i:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public e()V
    .locals 1

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getCallingActivity()Landroid/content/ComponentName;

    move-result-object v0

    if-nez v0, :cond_0

    .line 77
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->d()V

    .line 81
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->e()V

    goto :goto_0
.end method

.method public finish()V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    if-eqz v0, :cond_0

    .line 69
    const/4 v0, -0x1

    iget-object v1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 71
    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->finish()V

    .line 72
    return-void
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    if-eqz v0, :cond_0

    .line 61
    const/4 v0, -0x1

    iget-object v1, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity;->setResult(ILandroid/content/Intent;)V

    .line 63
    :cond_0
    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onBackPressed()V

    .line 64
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, -0x1

    const-string v0, "com.jibo.ui.activity.SingleFragmentActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 38
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/SingleFragmentActivity;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 39
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/SingleFragmentActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b001e

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 41
    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 43
    if-nez p1, :cond_1

    .line 44
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->r()V

    .line 47
    :cond_1
    return-void
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.SingleFragmentActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.SingleFragmentActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method

.method public declared-synchronized q()Landroid/content/Intent;
    .locals 1

    .prologue
    .line 29
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    if-nez v0, :cond_0

    .line 30
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;

    .line 32
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/activity/SingleFragmentActivity;->j:Landroid/content/Intent;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public r()V
    .locals 3

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/SingleFragmentActivity;->i:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-static {p0, v0, v1}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/activity/SingleFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 52
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->a()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    const v2, 0x7f09013f

    .line 53
    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentTransaction;->b(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 54
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->a(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 55
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->d()I

    .line 56
    return-void
.end method
