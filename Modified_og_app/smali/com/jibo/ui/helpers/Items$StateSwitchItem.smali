.class public abstract Lcom/jibo/ui/helpers/Items$StateSwitchItem;
.super Lcom/jibo/ui/helpers/Items$SimpleItem;
.source "Items.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/helpers/Items;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "StateSwitchItem"
.end annotation


# instance fields
.field private a:Z


# direct methods
.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;IZ)V
    .locals 1

    .prologue
    .line 462
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;I)V

    .line 459
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    .line 463
    iput-boolean p4, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    .line 464
    return-void
.end method

.method public constructor <init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 467
    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/ui/helpers/Items$SimpleItem;-><init>(Lcom/jibo/ui/helpers/Items$ItemType;Landroid/view/View$OnClickListener;Ljava/lang/CharSequence;)V

    .line 459
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    .line 468
    iput-boolean p4, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    .line 469
    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    .prologue
    .line 476
    iput-boolean p1, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    .line 477
    return-void
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 472
    iget-boolean v0, p0, Lcom/jibo/ui/helpers/Items$StateSwitchItem;->a:Z

    return v0
.end method
