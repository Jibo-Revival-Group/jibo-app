.class Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$1;
.super Ljava/lang/Object;
.source "MaterialTimePickerDialogFragment.java"

# interfaces
.implements Landroid/widget/TimePicker$OnTimeChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTimeChanged(Landroid/widget/TimePicker;II)V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment$1;->a:Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;->a(Lcom/jibo/ui/fragment/dialog/skills/MaterialTimePickerDialogFragment;)Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Lcom/jibo/ui/helpers/skills/DataItems$TimeDataValue;->setTime(II)V

    .line 85
    return-void
.end method
