.class Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;
.super Ljava/lang/Object;
.source "LocationFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a(Landroid/os/Bundle;)V
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
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
        "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Landroid/text/SpannableStringBuilder;

.field final synthetic b:Landroid/os/Bundle;

.field final synthetic c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/LocationFragment$1;Landroid/text/SpannableStringBuilder;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->a:Landroid/text/SpannableStringBuilder;

    iput-object p3, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 118
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/LocationFragment;->d()Z

    move-result v0

    if-nez v0, :cond_0

    .line 163
    :goto_0
    return-void

    .line 121
    :cond_0
    new-instance v0, Lcom/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/google/gson/JsonObject;-><init>()V

    .line 122
    const-string v1, "lat"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "lat"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    .line 123
    const-string v1, "lng"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "lng"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/Number;)V

    .line 124
    const-string v1, "city"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "city"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v1, "state"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "state"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string v1, "zipcode"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "zipcode"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    const-string v1, "country"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "country"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    const-string v1, "countryCode"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "countryCode"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const-string v1, "timezone"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "timezone"

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v5, "timezone"

    .line 130
    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 129
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v1

    const-string v2, "locationOverride"

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    .line 133
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "timezone"

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v3, "timezone"

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->b:Landroid/os/Bundle;

    const-string v5, "timezone"

    .line 134
    invoke-virtual {v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 133
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "avatar"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 136
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "connectedAt"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 137
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "SSID"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 138
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "serialNumber"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 139
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;->getPayload()Lcom/google/gson/JsonObject;

    move-result-object v0

    const-string v1, "platform"

    invoke-virtual {v0, v1}, Lcom/google/gson/JsonObject;->a(Ljava/lang/String;)Lcom/google/gson/JsonElement;

    .line 142
    :try_start_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->e:Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;

    invoke-virtual {v0, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    .line 143
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-static {p2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getLocation(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->l:Ljava/lang/String;

    .line 144
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    invoke-static {p2}, Lcom/jibo/aws/integration/helpers/RobotHelper;->getTimeZone(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->m:Ljava/lang/String;

    .line 146
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1$1;-><init>(Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Ljava/lang/Runnable;)V

    .line 153
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const v1, 0x7f10020c

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/LocationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 154
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    invoke-virtual {v1, v0}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->a(Ljava/lang/String;)V

    .line 155
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 157
    :catch_0
    move-exception v0

    .line 158
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const-string v2, "update robot"

    const/4 v3, 0x0

    invoke-static {v1, v0, v2, v3}, Lcom/jibo/ui/fragment/settings/LocationFragment;->b(Lcom/jibo/ui/fragment/settings/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 160
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->a:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 161
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iput-object v6, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    goto/16 :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 109
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->a:Landroid/text/SpannableStringBuilder;

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;->b(Landroid/text/SpannableStringBuilder;)V

    .line 110
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/LocationFragment;->o:Lcom/jibo/ui/fragment/dialog/CircleProgressFragment;

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->c:Lcom/jibo/ui/fragment/settings/LocationFragment$1;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/LocationFragment$1;->a:Lcom/jibo/ui/fragment/settings/LocationFragment;

    const-string v1, "get robot properties"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/LocationFragment;->a(Lcom/jibo/ui/fragment/settings/LocationFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 113
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 106
    check-cast p1, Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/LocationFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)V

    return-void
.end method
