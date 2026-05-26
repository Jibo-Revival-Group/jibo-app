.class Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;
.super Ljava/lang/Object;
.source "CustomHolidaySettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a(Lcom/jibo/aws/integration/aws/services/person/model/SetLoopPropertyRequest;Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;)V
    .locals 0

    .prologue
    .line 339
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 342
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->g()V

    .line 343
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2$1;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$2;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->c()V

    .line 344
    return-void
.end method
