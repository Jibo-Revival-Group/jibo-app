.class public Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;
.super Landroid/support/v7/app/AppCompatDialogFragment;
.source "SalesforceProgressDialogFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatDialogFragment;-><init>()V

    return-void
.end method

.method public static a(II)Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;
    .locals 2

    .prologue
    .line 55
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 56
    const-string v1, "title"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 57
    const-string v1, "message"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 58
    new-instance v1, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;

    invoke-direct {v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;-><init>()V

    .line 59
    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->setArguments(Landroid/os/Bundle;)V

    .line 60
    return-object v1
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 64
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatDialogFragment;->onCreate(Landroid/os/Bundle;)V

    .line 65
    sget v0, Lcom/salesforce/android/cases/R$style;->Widget_ServiceCase_Dialog:I

    invoke-virtual {p0, v1, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->setStyle(II)V

    .line 66
    invoke-virtual {p0, v1}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->setShowsDialog(Z)V

    .line 67
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->setCancelable(Z)V

    .line 68
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 73
    sget v0, Lcom/salesforce/android/cases/R$layout;->fragment_salesforce_progress_dialog:I

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 74
    invoke-virtual {p0}, Lcom/salesforce/android/cases/ui/internal/features/shared/SalesforceProgressDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    .line 75
    if-eqz v2, :cond_0

    .line 76
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_title:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    const-string v3, "title"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0, v3}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(I)V

    .line 77
    sget v0, Lcom/salesforce/android/cases/R$id;->progress_message:I

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;

    const-string v3, "message"

    .line 78
    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 77
    invoke-virtual {v0, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceTextView;->setText(I)V

    .line 80
    :cond_0
    return-object v1
.end method
