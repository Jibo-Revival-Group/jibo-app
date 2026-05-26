.class public Lcom/jibo/ui/helpers/Items$SwitchRowItem;
.super Lcom/jibo/ui/helpers/Items$StateSwitchItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SwitchRowItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;IZ)V
    .locals 1

    .prologue
    .line 483
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->switch_row:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;IZ)V

    .line 484
    return-void
.end method
