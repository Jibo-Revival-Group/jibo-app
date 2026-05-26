.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
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

.field final synthetic b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 0

    .prologue
    .line 490
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
    .locals 2

    .prologue
    .line 498
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11$1;

    invoke-direct {v1, p0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 517
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 493
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v1, "remove custom holidays"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 494
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 490
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$11;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V

    return-void
.end method
