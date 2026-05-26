.class public Lcom/jibo/ui/activity/WifiActivity;
.super Lcom/jibo/ui/activity/BaseActivity;
.source "WifiActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/activity/WifiActivity$Mode;
    }
.end annotation


# static fields
.field public static final h:Ljava/lang/String;


# instance fields
.field private i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;"
        }
    .end annotation
.end field

.field private k:Lcom/jibo/ui/activity/WifiActivity$Mode;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/ui/activity/WifiActivity;->h:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/activity/BaseActivity;-><init>()V

    .line 41
    sget-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    return-void
.end method

.method private static a(Landroid/app/Activity;Landroid/content/Intent;)V
    .locals 1

    .prologue
    .line 44
    const/16 v0, 0x3e8

    invoke-virtual {p0, p1, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 45
    return-void
.end method

.method public static a(Landroid/app/Activity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 88
    new-instance v1, Landroid/content/Intent;

    const-class v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 89
    const-string v2, "ARGS_MODE"

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT_SUSPENDED:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v0

    :goto_0
    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 90
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 91
    invoke-static {p0, v1}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Landroid/content/Intent;)V

    .line 92
    return-void

    .line 89
    :cond_0
    sget-object v0, Lcom/jibo/ui/activity/WifiActivity$Mode;->RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v0}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v0

    goto :goto_0
.end method

.method public static a(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    new-instance v1, Landroid/content/Intent;

    const-class v0, Lcom/jibo/ui/activity/WifiActivity;

    invoke-direct {v1, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 53
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 54
    :cond_0
    const-string v0, "ARGS_MODE"

    sget-object v2, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 55
    invoke-virtual {v2}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_SHOW_INTRO"

    const/4 v2, 0x1

    .line 56
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    .line 54
    invoke-static {p0, v0}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Landroid/content/Intent;)V

    .line 78
    :goto_0
    return-void

    .line 59
    :cond_1
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 60
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 61
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->isSuspended()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 62
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 67
    :cond_3
    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 68
    const-string v0, "ARGS_MODE"

    sget-object v2, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 69
    invoke-virtual {v2}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_SHOW_INTRO"

    const/4 v2, 0x0

    .line 70
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    .line 68
    invoke-static {p0, v0}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Landroid/content/Intent;)V

    goto :goto_0

    .line 74
    :cond_4
    const-string v0, "ARGS_SUSPENDED_LOOP_LIST"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 75
    const-string v0, "ARGS_MODE"

    sget-object v2, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v2}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/jibo/ui/activity/WifiActivity;->a(Landroid/app/Activity;Landroid/content/Intent;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/jibo/ui/activity/WifiActivity$Mode;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 175
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const-string v0, "com.jibo.ui.activity.WifiActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnCreateTime(Ljava/lang/String;)V

    .line 96
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sget-object v1, Lcom/jibo/ui/activity/BaseActivity;->b:Ljava/lang/String;

    const v2, 0x7f0b001e

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 97
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 99
    if-eqz p1, :cond_1

    .line 100
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 101
    const-string v0, "ARGS_SUSPENDED_LOOP_LIST"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->j:Ljava/util/ArrayList;

    .line 102
    invoke-static {}, Lcom/jibo/ui/activity/WifiActivity$Mode;->values()[Lcom/jibo/ui/activity/WifiActivity$Mode;

    move-result-object v0

    const-string v1, "ARGS_MODE"

    sget-object v2, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v2}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 109
    :goto_0
    if-nez p1, :cond_0

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT_OR_RECONNECT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    if-ne v0, v1, :cond_2

    .line 111
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->s()V

    .line 121
    :cond_0
    :goto_1
    return-void

    .line 104
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 105
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_SUSPENDED_LOOP_LIST"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getParcelableArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->j:Ljava/util/ArrayList;

    .line 106
    invoke-static {}, Lcom/jibo/ui/activity/WifiActivity$Mode;->values()[Lcom/jibo/ui/activity/WifiActivity$Mode;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "ARGS_MODE"

    sget-object v3, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v3}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    goto :goto_0

    .line 114
    :cond_2
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_SHOW_INTRO"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "ARGS_SHOW_INTRO"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 115
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->r()V

    goto :goto_1

    .line 117
    :cond_3
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->q()V

    goto :goto_1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 4

    .prologue
    const v3, 0x7f09013f

    const/4 v0, 0x1

    .line 125
    const v1, 0x102002c

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    if-ne v1, v2, :cond_1

    .line 127
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/support/v4/app/FragmentManager;->a(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 128
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/support/v4/app/FragmentManager;->a(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    instance-of v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiQRCodeFragment;

    if-eqz v1, :cond_0

    .line 129
    invoke-virtual {p0}, Lcom/jibo/ui/activity/WifiActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/wifi/WaitForTapFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;I)Z

    .line 135
    :goto_0
    return v0

    .line 133
    :cond_0
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 135
    :cond_1
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.WifiActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnResumeTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onResume()V

    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 141
    invoke-super {p0, p1}, Lcom/jibo/ui/activity/BaseActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 142
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/activity/WifiActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 143
    const-string v0, "ARGS_SUSPENDED_LOOP_LIST"

    iget-object v1, p0, Lcom/jibo/ui/activity/WifiActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 144
    const-string v0, "ARGS_MODE"

    iget-object v1, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    invoke-virtual {v1}, Lcom/jibo/ui/activity/WifiActivity$Mode;->ordinal()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 145
    return-void
.end method

.method protected onStart()V
    .locals 1

    const-string v0, "com.jibo.ui.activity.WifiActivity"

    invoke-static {v0}, Lcom/google/firebase/perf/metrics/AppStartTrace;->setLauncherActivityOnStartTime(Ljava/lang/String;)V

    invoke-super {p0}, Lcom/jibo/ui/activity/BaseActivity;->onStart()V

    return-void
.end method

.method public q()V
    .locals 3

    .prologue
    .line 148
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 151
    iget-object v1, p0, Lcom/jibo/ui/activity/WifiActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-nez v1, :cond_0

    .line 152
    sget-object v1, Lcom/jibo/ui/activity/WifiActivity$Mode;->INIT:Lcom/jibo/ui/activity/WifiActivity$Mode;

    iput-object v1, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    .line 156
    :goto_0
    const-class v1, Lcom/jibo/ui/fragment/wifi/NetworkSelectionFragment;

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/activity/WifiActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 157
    return-void

    .line 154
    :cond_0
    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/activity/WifiActivity;->i:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto :goto_0
.end method

.method public r()V
    .locals 2

    .prologue
    .line 160
    const-class v0, Lcom/jibo/ui/fragment/wifi/JiboPreparationsFragment;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/jibo/ui/activity/WifiActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 161
    return-void
.end method

.method public s()V
    .locals 3

    .prologue
    .line 164
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 165
    const-string v1, "ARGS_SUSPENDED_LOOP_LIST"

    iget-object v2, p0, Lcom/jibo/ui/activity/WifiActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 166
    const-class v1, Lcom/jibo/ui/fragment/wifi/SetupOrReconnectFragment;

    invoke-virtual {p0, v1, v0}, Lcom/jibo/ui/activity/WifiActivity;->c(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 167
    return-void
.end method

.method public t()Lcom/jibo/ui/activity/WifiActivity$Mode;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/jibo/ui/activity/WifiActivity;->k:Lcom/jibo/ui/activity/WifiActivity$Mode;

    return-object v0
.end method
