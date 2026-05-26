.class public Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;
.super Ljava/lang/Object;
.source "MaterialDatePickerDialogFragment_ViewBinding.java"

# interfaces
.implements Lbutterknife/Unbinder;


# instance fields
.field private b:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

.field private c:Landroid/view/View;

.field private d:Landroid/view/View;


# direct methods
.method public constructor <init>(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;Landroid/view/View;)V
    .locals 3

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    .line 29
    const v0, 0x7f0902d8

    const-string v1, "field \'textDayOfMonth\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textDayOfMonth:Landroid/widget/TextView;

    .line 30
    const v0, 0x7f0902d9

    const-string v1, "field \'textMonthYear\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textMonthYear:Landroid/widget/TextView;

    .line 31
    const v0, 0x7f090103

    const-string v1, "field \'datePicker\'"

    const-class v2, Landroid/widget/DatePicker;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/DatePicker;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->datePicker:Landroid/widget/DatePicker;

    .line 32
    const v0, 0x7f0902de

    const-string v1, "field \'textTitle\'"

    const-class v2, Landroid/widget/TextView;

    invoke-static {p2, v0, v1, v2}, Lbutterknife/internal/Utils;->b(Landroid/view/View;ILjava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textTitle:Landroid/widget/TextView;

    .line 33
    const v0, 0x7f09005b

    const-string v1, "method \'onCancelClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 34
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->c:Landroid/view/View;

    .line 35
    new-instance v1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding$1;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding$1;-><init>(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    const v0, 0x7f09008d

    const-string v1, "method \'onSetClick\'"

    invoke-static {p2, v0, v1}, Lbutterknife/internal/Utils;->a(Landroid/view/View;ILjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 42
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->d:Landroid/view/View;

    .line 43
    new-instance v1, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding$2;-><init>(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    return-void
.end method


# virtual methods
.method public unbind()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 54
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    .line 55
    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Bindings already cleared."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 56
    :cond_0
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->b:Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;

    .line 58
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textDayOfMonth:Landroid/widget/TextView;

    .line 59
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textMonthYear:Landroid/widget/TextView;

    .line 60
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->datePicker:Landroid/widget/DatePicker;

    .line 61
    iput-object v1, v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textTitle:Landroid/widget/TextView;

    .line 63
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 64
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->c:Landroid/view/View;

    .line 65
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->d:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    iput-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment_ViewBinding;->d:Landroid/view/View;

    .line 67
    return-void
.end method
