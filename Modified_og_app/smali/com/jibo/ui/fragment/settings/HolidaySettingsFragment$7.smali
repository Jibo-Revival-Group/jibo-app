.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;
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
    .line 386
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 389
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 390
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 391
    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-static {v4, v0, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLjava/util/List;)V

    .line 392
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-static {v0, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 393
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v3

    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getEnabled()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_1

    :goto_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$7;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLcom/jibo/aws/integration/aws/services/person/model/Holiday;)V

    .line 394
    return-void

    :cond_0
    move v0, v2

    .line 391
    goto :goto_0

    :cond_1
    move v1, v2

    .line 393
    goto :goto_1
.end method
