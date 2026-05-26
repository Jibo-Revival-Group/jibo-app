.class Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;
.super Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;
.source "StationsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/account/skills/StationsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "StationItem"
.end annotation


# instance fields
.field private a:Lcom/jibo/api/iheart/model/Station;


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Lcom/jibo/api/iheart/model/Station;Z)V
    .locals 2

    .prologue
    .line 467
    invoke-virtual {p2}, Lcom/jibo/api/iheart/model/Station;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/jibo/api/iheart/model/Station;->f()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1, p3}, Lcom/jibo/ui/helpers/Items$AvatarRadioTwoRowsSimpleItem;-><init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 468
    iput-object p2, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a:Lcom/jibo/api/iheart/model/Station;

    .line 469
    return-void
.end method


# virtual methods
.method public a()Lcom/jibo/api/iheart/model/Station;
    .locals 1

    .prologue
    .line 472
    iget-object v0, p0, Lcom/jibo/ui/fragment/account/skills/StationsFragment$StationItem;->a:Lcom/jibo/api/iheart/model/Station;

    return-object v0
.end method
