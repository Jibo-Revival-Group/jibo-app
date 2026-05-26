.class Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;
.super Ljava/lang/Object;
.source "PasscodeActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/PasscodeActivity;->y()Landroid/app/AlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/PasscodeActivity;)V
    .locals 0

    .prologue
    .line 404
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;->a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 409
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->o()Lcom/salesforce/androidsdk/accounts/UserAccountManager;

    move-result-object v3

    .line 410
    invoke-virtual {v3}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->d()Ljava/util/List;

    move-result-object v4

    .line 419
    if-eqz v4, :cond_2

    .line 420
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v5

    .line 421
    if-lez v5, :cond_1

    move v1, v2

    .line 422
    :goto_0
    add-int/lit8 v0, v5, -0x1

    if-ge v1, v0, :cond_0

    .line 423
    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 424
    const/4 v6, 0x0

    invoke-virtual {v3, v0, v6, v2}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/app/Activity;Z)V

    .line 422
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 426
    :cond_0
    add-int/lit8 v0, v5, -0x1

    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 427
    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;->a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    invoke-virtual {v3, v0, v1}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Lcom/salesforce/androidsdk/accounts/UserAccount;Landroid/app/Activity;)V

    .line 432
    :cond_1
    :goto_1
    return-void

    .line 430
    :cond_2
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$2;->a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    invoke-virtual {v3, v0}, Lcom/salesforce/androidsdk/accounts/UserAccountManager;->a(Landroid/app/Activity;)V

    goto :goto_1
.end method
