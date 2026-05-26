.class public Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;
.super Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;
.source "TipsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoTip"
.end annotation


# instance fields
.field private a:I


# direct methods
.method public constructor <init>(III)V
    .locals 0

    .prologue
    .line 388
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    .line 389
    iput p3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->a:I

    .line 390
    return-void
.end method

.method public constructor <init>(IIIII)V
    .locals 0

    .prologue
    .line 394
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(IIII)V

    .line 395
    iput p5, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->a:I

    .line 396
    return-void
.end method


# virtual methods
.method public i()I
    .locals 1

    .prologue
    .line 400
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$VideoTip;->a:I

    return v0
.end method
