.class Lcom/salesforce/androidsdk/ui/PasscodeActivity$1;
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
    .line 434
    iput-object p1, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$1;->a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 439
    iget-object v0, p0, Lcom/salesforce/androidsdk/ui/PasscodeActivity$1;->a:Lcom/salesforce/androidsdk/ui/PasscodeActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/salesforce/androidsdk/ui/PasscodeActivity;->a(Lcom/salesforce/androidsdk/ui/PasscodeActivity;Z)Z

    .line 440
    return-void
.end method
