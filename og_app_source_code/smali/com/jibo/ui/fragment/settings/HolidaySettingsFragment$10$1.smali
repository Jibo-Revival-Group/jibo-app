.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->a(Lcom/jibo/aws/integration/aws/services/person/model/GetLoopPropertiesRequest;Ljava/util/HashMap;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/HashMap;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;Ljava/util/HashMap;)V
    .locals 0

    .prologue
    .line 462
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->a:Ljava/util/HashMap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 465
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->a:Ljava/util/HashMap;

    invoke-static {v0}, Lcom/jibo/utils/CustomHolidaysUtils;->a(Ljava/util/Map;)Ljava/util/List;

    move-result-object v0

    .line 466
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v1, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V

    .line 467
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iget-object v2, v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->a:Ljava/util/List;

    invoke-static {v1, v2, v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;Ljava/util/List;)V

    .line 468
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->e(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V

    .line 469
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$10;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->g()V

    .line 470
    return-void
.end method
