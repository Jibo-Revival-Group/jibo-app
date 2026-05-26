.class Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


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
    .line 409
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iput-object p2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 6

    .prologue
    const/4 v2, 0x2

    const/4 v5, 0x1

    .line 412
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    iget-object v1, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->a:Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-static {v0, v1}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    .line 414
    new-array v0, v2, [I

    fill-array-data v0, :array_0

    .line 418
    new-array v1, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const v4, 0x7f100028

    .line 419
    invoke-virtual {v3, v4}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const v3, 0x7f100269

    .line 420
    invoke-virtual {v2, v3}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    .line 422
    iget-object v2, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    const/16 v3, 0x7c

    iget-object v4, p0, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$9;->b:Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    .line 425
    invoke-static {v4}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;->d(Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;)Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    move-result-object v4

    invoke-virtual {v4}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v4

    .line 422
    invoke-static {v2, v3, v4, v0, v1}, Lcom/jibo/ui/fragment/dialog/DialogUtils;->a(Landroid/support/v4/app/Fragment;ILjava/lang/String;[I[Ljava/lang/String;)V

    .line 429
    return v5

    .line 414
    nop

    :array_0
    .array-data 4
        0x7f08013a
        0x7f080166
    .end array-data
.end method
