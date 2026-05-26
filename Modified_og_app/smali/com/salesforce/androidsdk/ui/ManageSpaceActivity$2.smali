.class Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$2;
.super Ljava/lang/Object;
.source "ManageSpaceActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->a()Landroid/app/AlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;


# direct methods
.method constructor <init>(Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$2;->a:Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 77
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    iget-object v1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$2;->a:Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Landroid/app/Activity;Z)V

    .line 78
    return-void
.end method
