.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->q()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

.field final synthetic b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)V
    .locals 0

    .prologue
    .line 402
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 405
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 406
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$8;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v2

    invoke-static {v1, v0, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    .line 407
    return-void

    .line 406
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
