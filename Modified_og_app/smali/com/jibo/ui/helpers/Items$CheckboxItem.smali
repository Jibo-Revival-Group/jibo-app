.class public Lcom/jibo/ui/helpers/Items$CheckboxItem;
.super Lcom/jibo/ui/helpers/Items$StateSwitchItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckboxItem"
.end annotation


# direct methods
.method public constructor <init>(Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 497
    sget-object v0, Lcom/jibo/ui/helpers/Items$ItemType;->checkbox_row_leftsided:Lcom/jibo/ui/helpers/Items$ItemType;

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V

    .line 498
    return-void
.end method

.method constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 505
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/jibo/ui/helpers/Items$StateSwitchItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V

    .line 506
    return-void
.end method
