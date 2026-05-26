.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;
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
    .line 357
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 361
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, v1, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b:Ljava/util/ArrayList;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->b(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 364
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 365
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-static {v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->c(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 366
    const-string v2, "args_custom_holidays"

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 367
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$6;->a:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v0}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/activity/BaseActivity;

    const-class v2, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-virtual {v0, v2, v1}, Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 368
    return-void
.end method
