.class Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$2;
.super Ljava/lang/Object;
.source "WiFiBaseQRCodeFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;->a(Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/jibo/aws/integration/aws/services/loop/model/Loop;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;


# direct methods
.method constructor <init>(Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$2;->a:Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I
    .locals 2

    .prologue
    .line 113
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getUpdated()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;->getUpdated()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v0

    return v0
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 110
    check-cast p1, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/wifi/WiFiBaseQRCodeFragment$1$1$2;->a(Lcom/jibo/aws/integration/aws/services/loop/model/Loop;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)I

    move-result v0

    return v0
.end method
