.class public Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;
.super Landroid/support/v7/app/AppCompatDialogFragment;
.source "SalesforceConfirmationDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;
    }
.end annotation


# instance fields
.field private a:Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatDialogFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;)Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;

    return-object v0
.end method

.method public static a(II)Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 58
    const-string v1, "title"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 59
    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 60
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;

    invoke-direct {v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;-><init>()V

    .line 61
    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 63
    return-object v1
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->a:Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$SalesforceConfirmationDialogListener;

    .line 68
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 71
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatDialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    sget v0, Lcom/salesforce/android/cases/R$style;->Widget_ServiceCase_Dialog:I

    invoke-virtual {p0, v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->setStyle(II)V

    .line 73
    invoke-virtual {p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->setShowsDialog(Z)V

    .line 74
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->setCancelable(Z)V

    .line 75
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 81
    sget v0, Lcom/salesforce/android/cases/R$layout;->fragment_salesforce_confirmation_dialog:I

    const/4 v1, 0x0

    .line 82
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 84
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    .line 85
    if-eqz v2, :cond_0

    .line 86
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_title:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    const-string v3, "title"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(I)V

    .line 87
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_message:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    const-string v3, "message"

    .line 88
    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 87
    invoke-virtual {v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(I)V

    .line 91
    :cond_0
    sget v0, Lcom/salesforce/android/cases/R$id;->continue_button:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$1;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$1;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    sget v0, Lcom/salesforce/android/cases/R$id;->cancel_button:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v2, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$2;

    invoke-direct {v2, p0}, Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment$2;-><init>(Lcom/salesforce/android/cases/ui/internal/features/publisher/SalesforceConfirmationDialogFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    return-object v1
.end method
