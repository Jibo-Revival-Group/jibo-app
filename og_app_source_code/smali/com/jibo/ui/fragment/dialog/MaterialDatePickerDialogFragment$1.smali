.class Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;
.super Ljava/lang/Object;
.source "MaterialDatePickerDialogFragment.java"

# interfaces
.implements Landroid/widget/DatePicker$OnDateChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDateChanged(Landroid/widget/DatePicker;III)V
    .locals 2

    .prologue
    .line 103
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1, p4}, Ljava/util/Calendar;->set(II)V

    .line 104
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p3}, Ljava/util/Calendar;->set(II)V

    .line 105
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)Ljava/util/Calendar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p2}, Ljava/util/Calendar;->set(II)V

    .line 107
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V

    .line 108
    return-void
.end method
