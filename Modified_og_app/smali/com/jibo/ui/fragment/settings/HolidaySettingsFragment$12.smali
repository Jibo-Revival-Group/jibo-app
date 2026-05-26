.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
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
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

.field final synthetic b:Z

.field final synthetic c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;Z)V
    .locals 0

    .prologue
    .line 534
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    iput-boolean p3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->b:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 543
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 562
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 537
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    iget-boolean v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->b:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->setEnabled(Ljava/lang/Boolean;)V

    .line 538
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->c:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v2, "switch custom holidays"

    invoke-static {v0, p1, v2, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 539
    return-void

    .line 537
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 534
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$12;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
