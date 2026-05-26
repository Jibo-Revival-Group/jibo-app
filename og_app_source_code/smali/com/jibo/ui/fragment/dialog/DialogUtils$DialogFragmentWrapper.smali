.class public Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;
.super Landroid/support/v4/app/DialogFragment;
.source "DialogUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/dialog/DialogUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DialogFragmentWrapper"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;,
        Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogType;
    }
.end annotation


# instance fields
.field private a:Ljava/lang/String;

.field private b:Landroid/content/DialogInterface$OnClickListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 287
    invoke-direct {p0}, Landroid/support/v4/app/DialogFragment;-><init>()V

    .line 736
    new-instance v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;

    invoke-direct {v0, p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$6;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;)V

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    .line 288
    return-void
.end method

.method private a(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 6

    .prologue
    .line 375
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 376
    const-string v0, "ARGS_CHOICES_RES"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 378
    new-instance v3, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v3, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 379
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 380
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v4, 0x7f0b0059

    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 381
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 382
    invoke-virtual {v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 384
    :cond_0
    new-instance v0, Landroid/widget/ArrayAdapter;

    const v1, 0x7f0b0133

    .line 385
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 384
    invoke-virtual {v3, v0, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 387
    invoke-virtual {v3}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private a(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 428
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 429
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 430
    const-string v0, "ARGS_OK_TEXT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 431
    const-string v0, "ARGS_CANCEL_TEXT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 433
    new-instance v5, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v5, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 435
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 436
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v6, 0x7f0b0059

    invoke-virtual {v0, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 437
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 438
    invoke-virtual {v5, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 440
    :cond_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 441
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b0052

    invoke-virtual {v0, v2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 442
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 443
    invoke-virtual {v5, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 445
    :cond_1
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {v5, v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 446
    iget-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {v5, v4, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 448
    invoke-virtual {v5}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private a(IILjava/lang/Object;)V
    .locals 1

    .prologue
    .line 745
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    if-eqz v0, :cond_1

    .line 746
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;->a(IILjava/lang/Object;)V

    .line 750
    :cond_0
    :goto_0
    return-void

    .line 747
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    if-eqz v0, :cond_0

    .line 748
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;

    invoke-interface {v0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapperClickListener;->a(IILjava/lang/Object;)V

    goto :goto_0
.end method

.method static synthetic a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 256
    invoke-static {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V

    return-void
.end method

.method static synthetic a(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 256
    invoke-static {p0, p1, p2, p3, p4}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;IILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 256
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(IILjava/lang/Object;)V

    return-void
.end method

.method private b(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v4, -0x1

    .line 392
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 393
    const-string v0, "ARGS_CHOICES_RES"

    invoke-virtual {p2, v0, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 394
    const-string v0, "ARGS_CHOSEN_ITEM"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 395
    const-string v0, "ARGS_CHOICES_ARRAY"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    .line 396
    if-eq v1, v4, :cond_1

    .line 397
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    move-object v1, v0

    .line 400
    :goto_0
    new-instance v4, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v4, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 401
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 402
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v5, 0x7f0b0059

    const/4 v6, 0x0

    invoke-virtual {v0, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 403
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 404
    invoke-virtual {v4, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 406
    :cond_0
    new-instance v0, Landroid/widget/ArrayAdapter;

    const v2, 0x7f0b0134

    invoke-direct {v0, p1, v2, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    invoke-virtual {v4, v0, v3, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 409
    invoke-virtual {v4}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    :cond_1
    move-object v1, v0

    goto :goto_0
.end method

.method private b(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 452
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 454
    new-instance v1, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v1, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 455
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f0b0049

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 456
    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 457
    invoke-virtual {v1, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 458
    const v0, 0x104000a

    new-instance v3, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;

    invoke-direct {v3, p0, v2, p1}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$2;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Landroid/content/Context;)V

    invoke-virtual {v1, v0, v3}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 474
    const/high16 v0, 0x1040000

    invoke-virtual {v1, v0, v4}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 476
    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private static b(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 364
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-static {p0, p1, v0, p2, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V

    .line 365
    return-void
.end method

.method private static b(Landroid/os/Bundle;Landroid/support/v4/app/Fragment;Landroid/support/v4/app/FragmentManager;ILjava/lang/String;)V
    .locals 1

    .prologue
    .line 368
    new-instance v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;

    invoke-direct {v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;-><init>()V

    .line 369
    invoke-virtual {v0, p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->setArguments(Landroid/os/Bundle;)V

    .line 370
    invoke-virtual {v0, p1, p3}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 371
    invoke-virtual {v0, p2, p4}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 372
    return-void
.end method

.method private c(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 413
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 414
    const-string v0, "ARGS_OK_TEXT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 416
    new-instance v3, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v3, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 417
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 418
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v4, 0x7f0b0053

    invoke-virtual {v0, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 419
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 420
    invoke-virtual {v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 422
    :cond_0
    invoke-virtual {v3, v2, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 423
    const/high16 v0, 0x1040000

    invoke-virtual {v3, v0, v5}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 424
    invoke-virtual {v3}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private c(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 480
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 481
    const-string v0, "ARGS_ACCOUNT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/jibo/aws/integration/aws/services/account/model/Account;

    .line 483
    new-instance v8, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v8, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 484
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b0059

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 485
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 486
    invoke-virtual {v8, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 487
    const/high16 v0, 0x1040000

    invoke-virtual {v8, v0, v4}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 488
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b004b

    invoke-virtual {v0, v1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 490
    invoke-virtual {v8, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 492
    const v0, 0x7f090137

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Landroid/widget/EditText;

    .line 493
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getFirstName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 494
    const v0, 0x7f0901ae

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v7, v0

    check-cast v7, Landroid/widget/EditText;

    .line 495
    invoke-virtual {v3}, Lcom/jibo/aws/integration/aws/services/account/model/Account;->getLastName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 497
    new-array v0, v9, [Landroid/text/InputFilter;

    new-instance v1, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v1}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v1, v0, v5

    invoke-virtual {v6, v0}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 498
    new-array v0, v9, [Landroid/text/InputFilter;

    new-instance v1, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v1}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v1, v0, v5

    invoke-virtual {v7, v0}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 500
    const v9, 0x7f100285

    new-instance v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;

    move-object v1, p0

    move-object v4, p3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$3;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Lcom/jibo/aws/integration/aws/services/account/model/Account;Landroid/support/v4/app/Fragment;Landroid/content/Context;)V

    invoke-virtual {v8, v9, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 532
    invoke-virtual {v8}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 534
    new-instance v1, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/app/Dialog;)V

    invoke-virtual {v7, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 535
    new-instance v1, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$DialogCheckForEmptyTextWatcher;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/app/Dialog;)V

    invoke-virtual {v6, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 537
    return-object v0
.end method

.method private d(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 9

    .prologue
    const v7, 0x7f0700b1

    const/4 v8, 0x0

    .line 571
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 572
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 573
    const-string v0, "ARGS_OK_TEXT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 574
    const-string v0, "ARGS_CANCEL_TEXT"

    const/high16 v4, 0x1040000

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2, v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 576
    new-instance v5, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v5, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 577
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 578
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v6, 0x7f0b0059

    invoke-virtual {v0, v6, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 579
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 580
    invoke-virtual {v5, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 582
    :cond_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 583
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v6, 0x7f0b0052

    invoke-virtual {v0, v6, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 584
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 585
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 586
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 587
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v6, 0x7f0700b2

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 588
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    const/4 v7, 0x0

    .line 586
    invoke-virtual {v0, v1, v2, v6, v7}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 590
    :cond_1
    invoke-virtual {v5, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 592
    :cond_2
    invoke-virtual {v5, v3, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 593
    invoke-virtual {v5, v4, v8}, Landroid/support/v7/app/AlertDialog$Builder;->b(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 594
    invoke-virtual {v5}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private d(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;
    .locals 11

    .prologue
    const/4 v10, 0x0

    const v9, 0x7f0902e1

    .line 648
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 649
    const-string v0, "ARGS_NICKNAME"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 650
    const-string v0, "ARGS_LOOP"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    .line 652
    new-instance v6, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v6, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 654
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b0059

    invoke-virtual {v0, v2, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 656
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 657
    invoke-virtual {v6, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 659
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0057

    invoke-virtual {v0, v1, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 661
    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/text/InputFilter;

    const/4 v5, 0x0

    new-instance v7, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;

    invoke-direct {v7}, Lcom/jibo/ui/view/proxima/CustomFontEditText$NameInputFilter;-><init>()V

    aput-object v7, v1, v5

    const/4 v5, 0x1

    new-instance v7, Landroid/text/InputFilter$LengthFilter;

    const/16 v8, 0x14

    invoke-direct {v7, v8}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v7, v1, v5

    .line 662
    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 663
    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    const v1, 0x7f100221

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 664
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 665
    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 667
    :cond_0
    invoke-virtual {v6, v2}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 668
    const/high16 v0, 0x1040000

    invoke-virtual {v6, v0, v10}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 669
    const v7, 0x7f100285

    new-instance v0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;

    move-object v1, p0

    move-object v4, p3

    move-object v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$4;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/view/View;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Landroid/support/v4/app/Fragment;Landroid/content/Context;)V

    invoke-virtual {v6, v7, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 688
    invoke-virtual {v6}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private e(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 598
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 599
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 600
    const-string v1, "ARGS_OK_TEXT"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 601
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v0, ""

    :cond_0
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    .line 603
    new-instance v4, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v4, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 604
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 605
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v5, 0x7f0b0059

    invoke-virtual {v0, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 606
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 607
    invoke-virtual {v4, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 609
    :cond_1
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 610
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v2, 0x7f0b0052

    invoke-virtual {v0, v2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 611
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 612
    invoke-virtual {v4, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 614
    :cond_2
    if-nez v1, :cond_3

    const v0, 0x7f100231

    invoke-virtual {p0, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {v4, v0, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 616
    invoke-virtual {v4}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0

    :cond_3
    move-object v0, v1

    .line 614
    goto :goto_0
.end method

.method private f(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 620
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 621
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 622
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 624
    new-instance v3, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v3, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 625
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 626
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v4, 0x7f0b0059

    invoke-virtual {v0, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 627
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 628
    invoke-virtual {v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 630
    :cond_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 631
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f0b0052

    invoke-virtual {v0, v1, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 632
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 633
    invoke-virtual {v3, v0}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 635
    :cond_1
    const v0, 0x104000a

    invoke-virtual {v3, v0, p3}, Landroid/support/v7/app/AlertDialog$Builder;->a(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 636
    invoke-virtual {v3}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    .line 639
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetRequestCode()I

    move-result v1

    const/16 v2, 0x64

    if-ne v1, v2, :cond_2

    .line 640
    invoke-virtual {p0, v5}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->setCancelable(Z)V

    .line 641
    invoke-virtual {v0, v5}, Landroid/support/v7/app/AlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 644
    :cond_2
    return-object v0
.end method

.method private g(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 693
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 694
    const-string v0, "ARGS_MESSAGE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 695
    const-string v0, "ARGS_OK_TEXT"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 696
    const-class v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Member;

    .line 698
    new-instance v5, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v5, p1}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 699
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 700
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v6, 0x7f0b0059

    invoke-virtual {v1, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 701
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 702
    invoke-virtual {v5, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 704
    :cond_0
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 705
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f0b0052

    invoke-virtual {v1, v2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 706
    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 707
    invoke-virtual {v5, v1}, Landroid/support/v7/app/AlertDialog$Builder;->b(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 709
    :cond_1
    new-instance v1, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;

    invoke-direct {v1, p0, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$5;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Lcom/jibo/aws/integration/aws/services/loop/model/Member;)V

    invoke-virtual {v5, v4, v1}, Landroid/support/v7/app/AlertDialog$Builder;->a(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 716
    const/high16 v0, 0x1040000

    invoke-virtual {v5, v0, p3}, Landroid/support/v7/app/AlertDialog$Builder;->b(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 717
    invoke-virtual {v5}, Landroid/support/v7/app/AlertDialog$Builder;->b()Landroid/support/v7/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method

.method private h(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;
    .locals 4

    .prologue
    .line 722
    const-string v0, "ARGS_TITLE"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 723
    const-string v1, "ARGS_CHOICES_RES"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getIntArray(Ljava/lang/String;)[I

    move-result-object v1

    .line 724
    const-string v2, "ARGS_CHOICES_ARRAY"

    invoke-virtual {p2, v2}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 726
    new-instance v3, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;

    invoke-direct {v3, p1}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;-><init>(Landroid/content/Context;)V

    .line 727
    invoke-virtual {v3, v0}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a(Ljava/lang/String;)V

    .line 728
    invoke-virtual {v3, v1}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a([I)V

    .line 729
    invoke-virtual {v3, v2}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a([Ljava/lang/String;)V

    .line 730
    invoke-virtual {v3, p3}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->a(Landroid/content/DialogInterface$OnClickListener;)V

    .line 731
    invoke-virtual {v3}, Lcom/jibo/ui/fragment/dialog/OptionsBottomSheetDialog;->c()V

    .line 733
    return-object v3
.end method


# virtual methods
.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 4

    .prologue
    .line 293
    const/4 v1, 0x0

    .line 294
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-nez v0, :cond_1

    .line 360
    :cond_0
    :goto_0
    return-object v1

    .line 298
    :cond_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "ARGS_TYPE"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a:Ljava/lang/String;

    .line 299
    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a:Ljava/lang/String;

    const/4 v0, -0x1

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    :cond_2
    :goto_1
    packed-switch v0, :pswitch_data_0

    .line 338
    :goto_2
    instance-of v0, v1, Landroid/support/v7/app/AlertDialog;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 339
    check-cast v0, Landroid/support/v7/app/AlertDialog;

    .line 340
    new-instance v2, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;

    invoke-direct {v2, p0, v0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper$1;-><init>(Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;Landroid/support/v7/app/AlertDialog;)V

    invoke-virtual {v0, v2}, Landroid/support/v7/app/AlertDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V

    goto :goto_0

    .line 299
    :sswitch_0
    const-string v3, "SINGLE_CHOICE"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x0

    goto :goto_1

    :sswitch_1
    const-string v3, "SINGLE_CHOICE_RADIO"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x1

    goto :goto_1

    :sswitch_2
    const-string v3, "CONFIRMATION_DIALOG"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x2

    goto :goto_1

    :sswitch_3
    const-string v3, "CONFIRMATION_DIALOG_GREY"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x3

    goto :goto_1

    :sswitch_4
    const-string v3, "CONFIRMATION_DIALOG_ADD_CHILD"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x4

    goto :goto_1

    :sswitch_5
    const-string v3, "INFO_DIALOG"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x5

    goto :goto_1

    :sswitch_6
    const-string v3, "INFO_DIALOG_MAINTENANCE"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x6

    goto :goto_1

    :sswitch_7
    const-string v3, "EMAIL_ENTER"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/4 v0, 0x7

    goto :goto_1

    :sswitch_8
    const-string v3, "NICKNAME_ENTER"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v0, 0x8

    goto :goto_1

    :sswitch_9
    const-string v3, "NAME_ENTER"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v0, 0x9

    goto :goto_1

    :sswitch_a
    const-string v3, "REGULAR"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v0, 0xa

    goto/16 :goto_1

    :sswitch_b
    const-string v3, "BOTTOM_DIALOG"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v0, 0xb

    goto/16 :goto_1

    .line 301
    :pswitch_0
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 304
    :pswitch_1
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 307
    :pswitch_2
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->c(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 310
    :pswitch_3
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->d(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 313
    :pswitch_4
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->g(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 316
    :pswitch_5
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->e(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 319
    :pswitch_6
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->f(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 322
    :pswitch_7
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 325
    :pswitch_8
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->d(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 328
    :pswitch_9
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->c(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 331
    :pswitch_a
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->a(Landroid/content/Context;Landroid/os/Bundle;Landroid/support/v4/app/Fragment;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 334
    :pswitch_b
    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p0}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->b:Landroid/content/DialogInterface$OnClickListener;

    invoke-direct {p0, v0, v1, v2}, Lcom/jibo/ui/fragment/dialog/DialogUtils$DialogFragmentWrapper;->h(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/Dialog;

    move-result-object v1

    goto/16 :goto_2

    .line 299
    nop

    :sswitch_data_0
    .sparse-switch
        -0x69af05ac -> :sswitch_1
        -0x69986e07 -> :sswitch_5
        -0x4dfa8059 -> :sswitch_8
        -0x3fed8a88 -> :sswitch_0
        -0x29c9b653 -> :sswitch_6
        -0x5ccd624 -> :sswitch_b
        0x3237026c -> :sswitch_3
        0x3a969004 -> :sswitch_9
        0x3ab83835 -> :sswitch_7
        0x6b636851 -> :sswitch_4
        0x6b8dab7c -> :sswitch_a
        0x6db34492 -> :sswitch_2
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method
