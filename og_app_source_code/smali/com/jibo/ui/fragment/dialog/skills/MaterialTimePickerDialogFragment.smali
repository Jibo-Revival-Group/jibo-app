.class public Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "MaterialTimePickerDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$DataChangedListener;
    }
.end annotation


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

.field private c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

.field simpleTimePicker:Landroid/widget/TimePicker;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;)Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    return-object v0
.end method


# virtual methods
.method public onCancelClick(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->dismiss()V

    .line 111
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 41
    if-eqz p1, :cond_0

    const-string v0, "ARGS_SKILL_FRAGMENT"

    invoke-virtual {p1, v0, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->isCreated()Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/activity/OnBoardingActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 43
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 44
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 46
    new-instance v0, Landroid/app/Dialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    .line 90
    :goto_0
    return-object v0

    .line 49
    :cond_0
    new-instance v1, Landroid/support/v7/app/AlertDialog$Builder;

    new-instance v0, Landroid/support/v7/view/ContextThemeWrapper;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f110118

    invoke-direct {v0, v2, v3}, Landroid/support/v7/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    invoke-direct {v1, v0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b0055

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 53
    invoke-static {p0, v2}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->a:Lbutterknife/Unbinder;

    .line 55
    if-eqz p1, :cond_1

    .line 56
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    const-class v3, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-class v4, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0, v3, v4}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    .line 58
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 59
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    const-class v4, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-class v4, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0, v3, v4}, Lcom/google/gson/Gson;->a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    .line 62
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    if-eqz v0, :cond_4

    .line 63
    invoke-static {}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->getInstance()Lcom/jibo/ui/helpers/skills/SkillsJsonParser;

    move-result-object v0

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0, v3}, Lcom/jibo/ui/helpers/skills/SkillsJsonParser;->setItemDataValue(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;)V

    .line 64
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;->getDataValue()Lcom/jibo/ui/helpers/skills/DataItems$DataValue;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    .line 69
    :goto_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    if-nez v0, :cond_3

    .line 70
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-direct {v0, v5, v5}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;-><init>(II)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    .line 73
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setIs24HourView(Ljava/lang/Boolean;)V

    .line 74
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v0, v3, :cond_5

    .line 75
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getHour()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setHour(I)V

    .line 76
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getMin()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setMinute(I)V

    .line 81
    :goto_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    new-instance v3, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$1;

    invoke-direct {v3, p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$1;-><init>(Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setOnTimeChangedListener(Landroid/widget/TimePicker$OnTimeChangedListener;)V

    .line 88
    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 90
    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    goto/16 :goto_0

    .line 66
    :cond_4
    new-instance v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-direct {v0, v5, v5}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;-><init>(II)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    goto :goto_1

    .line 78
    :cond_5
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getHour()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setCurrentHour(Ljava/lang/Integer;)V

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->simpleTimePicker:Landroid/widget/TimePicker;

    iget-object v3, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-virtual {v3}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->getMin()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TimePicker;->setCurrentMinute(Ljava/lang/Integer;)V

    goto :goto_2
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 101
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->a:Lbutterknife/Unbinder;

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 106
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 95
    const-class v0, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/google/gson/Gson;

    invoke-direct {v1}, Lcom/google/gson/Gson;-><init>()V

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    invoke-virtual {v1, v2}, Lcom/google/gson/Gson;->b(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    const-string v0, "ARGS_SKILL_FRAGMENT"

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "ARGS_SKILL_FRAGMENT"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 97
    return-void
.end method

.method public onSetClick(Landroid/view/View;)V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 116
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 117
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$DataChangedListener;

    if-eqz v0, :cond_0

    .line 118
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$DataChangedListener;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->b:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataItem;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->c:Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    invoke-interface {v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$DataChangedListener;->a(Lcom/jibo/ui/helpers/skills/DataItems$DataItem;Lcom/jibo/ui/helpers/skills/DataItems$DataValue;)V

    .line 120
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->dismiss()V

    .line 121
    return-void
.end method
