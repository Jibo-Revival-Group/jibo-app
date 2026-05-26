.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazonaws/handlers/AsyncHandler",
        "<",
        "Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;",
        "Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;)V
    .locals 8

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 85
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    const/4 v0, 0x0

    .line 89
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;->getComplete()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 90
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v3, v3, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 91
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v3, "Robot is online, closing wifi setup"

    invoke-static {v0, v3}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    .line 93
    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v0

    .line 92
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v3, v0}, Lcom/jibo/JiboAnalytics;->b(Landroid/content/Context;Z)V

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/JiboAnalytics;->f(Landroid/content/Context;)V

    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Runnable;)V

    .line 191
    :goto_1
    return-void

    :cond_0
    move v0, v2

    .line 92
    goto :goto_0

    .line 109
    :cond_1
    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v3, v3, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v3, v3, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->listLoops()Ljava/util/List;

    move-result-object v3

    .line 110
    new-instance v4, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$2;

    invoke-direct {v4, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$2;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;)V

    invoke-static {v3, v4}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 118
    if-eqz v3, :cond_6

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_6

    .line 119
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-object v3, v0

    .line 124
    :goto_2
    if-eqz v3, :cond_5

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getUpdated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isLessThanFiveMinutes(JJ)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 126
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getCreated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getUpdated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Lcom/jibo/aws/integration/util/DateTimeUtils;->isLessThanFiveMinutes(JJ)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 130
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b:Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v6, v6, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v6}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v6

    .line 131
    invoke-virtual {v6}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v6

    invoke-virtual {v6}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'s"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " Jibo"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 130
    invoke-virtual {v0, v4, v5}, Lcom/jibo/aws/integration/aws/services/loop/JiboLoopAsyncClient;->updateLoop(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    .line 133
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v4, v4, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v4}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-static {v4}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v4

    .line 134
    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "\'s"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " Jibo"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 133
    invoke-virtual {v3, v0}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->setName(Ljava/lang/String;)V

    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v3}, Lcom/jibo/utils/LoopHolidaysAlarmReceiver;->a(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 144
    :goto_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, v3, v1}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Z)V

    .line 149
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/jibo/db/EntityData;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/SharedPreferencesUtil;->a(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 158
    :cond_2
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v1, "Robot found, showing Success screen"

    invoke-static {v0, v1}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;

    invoke-direct {v1, p0, v3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$3;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Runnable;)V

    goto/16 :goto_1

    .line 139
    :catch_0
    move-exception v0

    .line 140
    iget-object v4, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v4, v4, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    const-string v5, "update loop"

    invoke-static {v4, v0, v5, v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->b(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 141
    sget-object v4, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v5, "update loop"

    invoke-static {v4, v5, v0}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 172
    :cond_3
    sget-object v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a:Ljava/lang/String;

    const-string v3, "Robot is online, closing wifi setup"

    invoke-static {v0, v3}, Lcom/jibo/utils/LogUtils;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v3, v3, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    .line 174
    invoke-virtual {v3}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lcom/jibo/db/EntityData;->a(Landroid/content/Context;)Lcom/jibo/db/EntityData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/db/EntityData;->i()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getPhotoUrl()Ljava/lang/String;

    move-result-object v3

    .line 173
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    :goto_4
    invoke-static {v0, v1}, Lcom/jibo/JiboAnalytics;->b(Landroid/content/Context;Z)V

    .line 175
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    new-instance v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$4;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$4;-><init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Ljava/lang/Runnable;)V

    goto/16 :goto_1

    :cond_4
    move v1, v2

    .line 173
    goto :goto_4

    .line 188
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->c()Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    invoke-static {v1}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_1

    :cond_6
    move-object v3, v0

    goto/16 :goto_2
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 80
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;

    const-string v1, "get status"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;->a(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 81
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 77
    check-cast p1, Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;)V

    return-void
.end method
