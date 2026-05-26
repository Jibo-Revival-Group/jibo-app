.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Lcom/amazonaws/handlers/AsyncHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a()V
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
        "Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;",
        "Ljava/util/List",
        "<",
        "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 226
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 234
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    new-instance v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;

    invoke-direct {v1, p0, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;-><init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Ljava/lang/Runnable;)V

    .line 240
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3

    .prologue
    .line 229
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v1, "list holidays"

    const/4 v2, 0x1

    invoke-static {v0, p1, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/Throwable;Ljava/lang/String;Z)V

    .line 230
    return-void
.end method

.method public synthetic onSuccess(Lcom/amazonaws/AmazonWebServiceRequest;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 226
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;

    check-cast p2, Ljava/util/List;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a(Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;Ljava/util/List;)V

    return-void
.end method
