.class public Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "HolidaysPopupFragment.java"


# instance fields
.field private a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    return-void
.end method

.method public static a(Landroid/support/v4/app/FragmentManager;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 3

    .prologue
    .line 30
    new-instance v0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;-><init>()V

    .line 31
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 32
    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 33
    invoke-virtual {v0, v1}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->setArguments(Landroid/os/Bundle;)V

    .line 34
    const-class v1, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 35
    return-void
.end method


# virtual methods
.method public onBtnAddHolidaysClick()V
    .locals 3
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 69
    new-instance v0, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    const-class v1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 70
    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0, v1, v2}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(Ljava/lang/String;Landroid/os/Parcelable;)Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;

    move-result-object v0

    const/16 v1, 0x3fe

    .line 71
    invoke-virtual {v0, v1}, Lcom/jibo/ui/activity/SingleFragmentActivity$Builder;->a(I)V

    .line 72
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->dismiss()V

    .line 73
    return-void
.end method

.method public onBtnCancelClick()V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 77
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->dismiss()V

    .line 78
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 39
    new-instance v1, Landroid/support/v7/app/AppCompatDialog;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v2, 0x1030009

    invoke-direct {v1, v0, v2}, Landroid/support/v7/app/AppCompatDialog;-><init>(Landroid/content/Context;I)V

    .line 40
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b004c

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 41
    invoke-static {p0, v0}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    .line 43
    invoke-virtual {p0, v4}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->setCancelable(Z)V

    .line 45
    invoke-virtual {v1, v0}, Landroid/support/v7/app/AppCompatDialog;->setContentView(Landroid/view/View;)V

    .line 46
    invoke-virtual {v1, v4}, Landroid/support/v7/app/AppCompatDialog;->setCancelable(Z)V

    .line 48
    if-eqz p1, :cond_1

    .line 49
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 54
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v2}, Lcom/jibo/utils/LoopHolidaysAlarmReceiver;->b(Landroid/content/Context;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 56
    return-object v1

    .line 50
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-class v2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 61
    invoke-super {p0, p1}, Landroid/support/v4/app/DialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 62
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    if-eqz v0, :cond_0

    .line 63
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/HolidaysPopupFragment;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 65
    :cond_0
    return-void
.end method
