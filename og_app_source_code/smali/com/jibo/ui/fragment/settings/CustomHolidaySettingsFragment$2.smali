.class Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;
.super Ljava/lang/Object;
.source "CustomHolidaySettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->v()V
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
        "Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;",
        "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 338
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 339
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;-><init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 349
    :goto_0
    return-void

    .line 347
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 333
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    const-string v1, "create custom holidays"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 334
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 330
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
