.class public Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidayComparator;
.super Ljava/lang/Object;
.source "HolidaySettingsFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HolidayComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/jibo/aws/integration/aws/services/person/model/Holiday;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 702
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 703
    return-void
.end method


# virtual methods
.method public a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I
    .locals 2

    .prologue
    .line 706
    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v0

    .line 707
    :goto_0
    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p2}, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;->getName()Ljava/lang/String;

    move-result-object v1

    .line 708
    :goto_1
    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    return v0

    .line 706
    :cond_0
    const-string v0, ""

    goto :goto_0

    .line 707
    :cond_1
    const-string v1, ""

    goto :goto_1
.end method

.method public synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 701
    check-cast p1, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    check-cast p2, Lcom/jibo/aws/integration/aws/services/person/model/Holiday;

    invoke-virtual {p0, p1, p2}, Lcom/jibo/ui/fragment/settings/HolidaySettingsFragment$HolidayComparator;->a(Lcom/jibo/aws/integration/aws/services/person/model/Holiday;Lcom/jibo/aws/integration/aws/services/person/model/Holiday;)I

    move-result v0

    return v0
.end method
