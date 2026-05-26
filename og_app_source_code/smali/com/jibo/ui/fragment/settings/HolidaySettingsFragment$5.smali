.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;
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
.field final synthetic a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 346
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 349
    instance-of v0, p1, Landroid/widget/CompoundButton;

    if-eqz v0, :cond_1

    .line 350
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    check-cast p1, Landroid/widget/CompoundButton;

    invoke-virtual {p1}, Landroid/widget/CompoundButton;->isChecked()Z

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v3, "birthday"

    invoke-static {v2, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLjava/util/List;)V

    .line 354
    :cond_0
    :goto_0
    return-void

    .line 351
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/helpers/Items$SwitchRowItem;

    if-eqz v0, :cond_0

    .line 352
    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$5;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const-string v3, "birthday"

    invoke-static {v2, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-static {v1, v0, v2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;ZLjava/util/List;)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method
