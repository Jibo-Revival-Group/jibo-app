.class public Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;
.super Landroid/support/v4/app/DialogFragment;
.source "MaterialDatePickerDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;
    }
.end annotation


# instance fields
.field a:Lbutterknife/Unbinder;

.field private b:Ljava/util/Calendar;

.field private c:Ljava/text/SimpleDateFormat;

.field private d:Ljava/lang/String;

.field datePicker:Landroid/widget/DatePicker;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field private e:Ljava/lang/String;

.field private f:Ljava/lang/Long;

.field private g:Ljava/lang/Long;

.field private h:Ljava/lang/Long;

.field textDayOfMonth:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textMonthYear:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field

.field textTitle:Landroid/widget/TextView;
    .annotation build Lbutterknife/BindView;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    .line 54
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    .line 55
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    return-void
.end method

.method private a(J)J
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 158
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    .line 159
    invoke-virtual {v0, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 160
    const/16 v1, 0xb

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 161
    const/16 v1, 0xc

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 162
    const/16 v1, 0xe

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 163
    const/16 v1, 0xd

    invoke-virtual {v0, v1, v2}, Ljava/util/Calendar;->set(II)V

    .line 165
    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    return-object v0
.end method

.method private a()Z
    .locals 6

    .prologue
    const/4 v0, 0x0

    .line 174
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    if-eqz v1, :cond_2

    .line 176
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-gez v1, :cond_1

    .line 182
    :cond_0
    :goto_0
    return v0

    .line 179
    :cond_1
    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-gtz v1, :cond_0

    .line 182
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private b()V
    .locals 3

    .prologue
    .line 186
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textDayOfMonth:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Ljava/util/Calendar;->get(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textMonthYear:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->c:Ljava/text/SimpleDateFormat;

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    invoke-virtual {v2}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 188
    return-void
.end method

.method static synthetic b(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b()V

    return-void
.end method


# virtual methods
.method public onCancelClick(Landroid/view/View;)V
    .locals 0
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->dismiss()V

    .line 131
    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 59
    new-instance v3, Landroid/support/v7/app/AlertDialog$Builder;

    new-instance v0, Landroid/support/v7/view/ContextThemeWrapper;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v4, 0x7f110118

    invoke-direct {v0, v1, v4}, Landroid/support/v7/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    invoke-direct {v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 61
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0054

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 63
    invoke-static {p0, v4}, Lbutterknife/ButterKnife;->a(Ljava/lang/Object;Landroid/view/View;)Lbutterknife/Unbinder;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a:Lbutterknife/Unbinder;

    .line 65
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    .line 66
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 67
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_DATE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 68
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_DATE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 67
    :goto_0
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    .line 71
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_MAX_VALUE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    :goto_1
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    .line 74
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_MIN_VALUE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_MIN_VALUE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    :goto_2
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    .line 77
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    if-nez v0, :cond_7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    :goto_3
    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    .line 81
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->h:Ljava/lang/Long;

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    :cond_1
    iput-object v2, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->g:Ljava/lang/Long;

    .line 86
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_TITLE"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->d:Ljava/lang/String;

    .line 87
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ARGS_ERROR_TEXT"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->e:Ljava/lang/String;

    .line 89
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-direct {p0, v0, v1}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a(J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    .line 90
    const-string v0, "GMT"

    invoke-static {v0}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Calendar;->getInstance(Ljava/util/TimeZone;)Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    .line 91
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v0, v6, v7}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 93
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 94
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->d:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    :cond_3
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->datePicker:Landroid/widget/DatePicker;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-virtual {v0, v6, v7}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 99
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->datePicker:Landroid/widget/DatePicker;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/Calendar;->get(I)I

    move-result v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    const/4 v5, 0x2

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v2

    iget-object v5, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    new-instance v6, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;

    invoke-direct {v6, p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$1;-><init>(Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;)V

    invoke-virtual {v0, v1, v2, v5, v6}, Landroid/widget/DatePicker;->init(IIILandroid/widget/DatePicker$OnDateChangedListener;)V

    .line 111
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MMMM, yyyy"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->c:Ljava/text/SimpleDateFormat;

    .line 112
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->c:Ljava/text/SimpleDateFormat;

    const-string v1, "GMT"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 113
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b()V

    .line 116
    invoke-virtual {v3, v4}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 118
    invoke-virtual {v3}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    .line 68
    :cond_4
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->f:Ljava/lang/Long;

    .line 69
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    goto/16 :goto_0

    :cond_5
    move-object v0, v2

    .line 71
    goto/16 :goto_1

    :cond_6
    move-object v0, v2

    .line 74
    goto/16 :goto_2

    :cond_7
    move-object v0, v2

    .line 79
    goto/16 :goto_3
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 123
    invoke-super {p0}, Landroid/support/v4/app/DialogFragment;->onDestroyView()V

    .line 125
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a:Lbutterknife/Unbinder;

    invoke-interface {v0}, Lbutterknife/Unbinder;->unbind()V

    .line 126
    return-void
.end method

.method public onSetClick(Landroid/view/View;)V
    .locals 4
    .annotation build Lbutterknife/OnClick;
    .end annotation

    .prologue
    .line 135
    invoke-direct {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->a()Z

    move-result v0

    if-nez v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textTitle:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 137
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->textTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f060074

    invoke-static {v1, v2}, Lcom/jibo/utils/ImageUtils;->b(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 146
    :goto_0
    return-void

    .line 141
    :cond_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;

    if-eqz v0, :cond_1

    .line 142
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;

    iget-object v1, p0, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->b:Ljava/util/Calendar;

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment$OnDateChosenListener;->a(J)V

    .line 145
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/MaterialDatePickerDialogFragment;->dismiss()V

    goto :goto_0
.end method
