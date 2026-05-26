.class Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$1;
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
    .line 80
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$1;->a:Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity$1;->a:Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;

    invoke-virtual {v0}, Lcom/salesforce/androidsdk/ui/ManageSpaceActivity;->finish()V

    .line 85
    return-void
.end method
