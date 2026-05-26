.class Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$1;
.super Ljava/lang/Object;
.source "CustomHolidaySettingsFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment$1;->a:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->a(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V

    .line 96
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 86
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 91
    return-void
.end method
