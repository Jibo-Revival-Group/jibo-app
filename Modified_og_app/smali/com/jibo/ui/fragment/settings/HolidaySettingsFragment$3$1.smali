.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a(Lcom/jibo/aws/integration/aws/services/person/model/ListHolidaysRequest;Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 234
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 237
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;

    iget-object v0, v0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$3$1;->a:Ljava/util/List;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)V

    .line 238
    return-void
.end method
