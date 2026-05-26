.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/util/List;)V
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
        "Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;",
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Lcom/google/gson/JsonObject;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 450
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;Ljava/util/HashMap;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/gson/JsonObject;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 462
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;Ljava/util/HashMap;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 472
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 453
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v1, "list custom holidays"

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 455
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 456
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->a:Ljava/util/List;

    invoke-static {v1, v2, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Ljava/util/List;)V

    .line 457
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    .line 458
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 450
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;

    check-cast p2, Ljava/util/HashMap;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->a(Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;Ljava/util/HashMap;)V

    return-void
.end method
