.class public Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;
.super Ljava/lang/Object;
.source "CustomHolidaySettingsFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

.field private c:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f090101

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    .line 27
    const v0, 0x7f090146

    const-string v1, "field \'holidayName\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    .line 28
    const-string v0, "field \'date\' and method \'selectDate\'"

    invoke-static {p2, v3, v0}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v1

    .line 29
    const-string v0, "field \'date\'"

    const-class v2, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    invoke-static {v1, v3, v0, v2}, Lbutterknife/internal/Utils;->c(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/view/proxima/CustomFontTextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->date:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 30
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 31
    new-instance v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding$1;

    invoke-direct {v0, p0, p1}, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;)V

    invoke-virtual {v1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 37
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 42
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    .line 43
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;

    .line 46
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->holidayName:Lcom/jibo/ui/view/proxima/CustomFontAutoCompleteTextView;

    .line 47
    iput-object v1, v0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment;->date:Lcom/jibo/ui/view/proxima/CustomFontTextView;

    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 50
    iput-object v1, p0, Lcom/jibo/ui/fragment/settings/CustomHolidaySettingsFragment_ViewBinding;->c:Landroid/view/View;

    .line 51
    return-void
.end method
