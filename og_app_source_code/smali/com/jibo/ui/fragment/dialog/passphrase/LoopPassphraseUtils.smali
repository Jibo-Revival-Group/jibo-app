.class public Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;
.super Ljava/lang/Object;
.source "LoopPassphraseUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;,
        Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;
    }
.end annotation


# direct methods
.method public static a(Landroid/content/Context;Ljava/lang/String;Z)Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;
    .locals 8

    .prologue
    const/4 v0, 0x0

    .line 80
    invoke-static {p1, p0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils;->a(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 99
    :cond_0
    :goto_0
    return-object v0

    .line 84
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 85
    const v1, 0x7f100037

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v4, 0x0

    invoke-virtual {p0, v1, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 86
    const-string v4, "PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE"

    const-wide/16 v6, 0x0

    invoke-interface {v1, v4, v6, v7}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v4

    .line 87
    const-string v6, "PREFERENCE_LAST_SHOWN_DIALOG_TYPE"

    invoke-interface {v1, v6, v0}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 89
    sget-object v6, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FIRST_TIME:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-virtual {v6, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 90
    sub-long/2addr v2, v4

    const-wide/32 v4, 0x5265c00

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    if-eqz p2, :cond_0

    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    goto :goto_0

    .line 92
    :cond_2
    sget-object v6, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-virtual {v6, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 93
    sub-long/2addr v2, v4

    const-wide/32 v4, 0x240c8400

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    goto :goto_0

    .line 95
    :cond_3
    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    invoke-virtual {v2, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->equalsName(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 99
    if-eqz p2, :cond_4

    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->MEDIA_ADDED:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    goto :goto_0

    :cond_4
    sget-object v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->FIRST_TIME:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 4

    .prologue
    .line 136
    const v0, 0x7f100037

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 137
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREFERENCE_LAST_SHOWN_DIALOG_TYPE"

    sget-object v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->WEEK_AFTER:Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    .line 138
    invoke-virtual {v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 139
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;)V
    .locals 4

    .prologue
    .line 42
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f100037

    .line 43
    invoke-virtual {p0, v1}, Landroid/support/v4/app/Fragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    .line 42
    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 44
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "PREFERENCE_LAST_SHOWN_DIALOG_TYPE"

    .line 45
    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 47
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;-><init>()V

    .line 48
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 49
    const-string v2, "ARGS_DIALOG_TYPE"

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->setArguments(Landroid/os/Bundle;)V

    .line 51
    const/16 v1, 0x79

    invoke-virtual {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 52
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseSetDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 53
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->b()Z

    .line 54
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 4

    .prologue
    .line 57
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;-><init>()V

    .line 58
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 59
    const-string v2, "ARGS_DIALOG_TYPE"

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 61
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->setArguments(Landroid/os/Bundle;)V

    .line 62
    const/16 v1, 0x7a

    invoke-virtual {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 63
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseRestoreDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 64
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->b()Z

    .line 65
    return-void
.end method

.method public static a(Landroid/support/v4/app/Fragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 68
    new-instance v0, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;-><init>()V

    .line 69
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 70
    const-string v2, "ARGS_DIALOG_TYPE"

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string v2, "ARGS_PASSPHRASE"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->setArguments(Landroid/os/Bundle;)V

    .line 73
    const/16 v1, 0x7b

    invoke-virtual {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 74
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {p1}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseInfoDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 75
    invoke-virtual {p0}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->b()Z

    .line 76
    return-void
.end method

.method public static a(Ljava/lang/String;Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V
    .locals 3

    .prologue
    .line 164
    invoke-virtual {p1}, Lcom/jibo/ui/fragment/BaseFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->d()Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;

    move-result-object v0

    .line 165
    const/4 v1, 0x0

    new-instance v2, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;

    invoke-direct {v2, p1, p2}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$1;-><init>(Lcom/jibo/ui/fragment/BaseFragment;Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$KeyBackupCheckListener;)V

    invoke-virtual {v0, p0, v1, v2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;

    .line 187
    return-void
.end method

.method public static a(Landroid/support/v4/app/FragmentManager;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 142
    invoke-static {}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->values()[Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;

    move-result-object v2

    .line 143
    array-length v3, v2

    move v1, v0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v4, v2, v1

    .line 144
    invoke-virtual {v4}, Lcom/jibo/ui/fragment/dialog/passphrase/LoopPassphraseUtils$DialogType;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Landroid/support/v4/app/FragmentManager;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    if-eqz v4, :cond_1

    const/4 v0, 0x1

    .line 146
    :cond_0
    return v0

    .line 143
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;)Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 103
    const v0, 0x7f100037

    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 104
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PREFERENCE_PASSPHRASE_LOOP_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
