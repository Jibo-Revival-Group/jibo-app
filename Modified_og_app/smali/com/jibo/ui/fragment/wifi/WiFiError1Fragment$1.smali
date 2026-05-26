.class Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$1;
.super Ljava/lang/Object;
.source "WiFiError1Fragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment$1;->a:Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;

    invoke-static {v0}, Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;->a(Lcom/jibo/ui/fragment/wifi/WiFiError1Fragment;)V

    .line 50
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 42
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 45
    return-void
.end method
