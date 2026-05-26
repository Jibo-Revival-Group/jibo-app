.class public Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;
.super Ljava/lang/Object;
.source "TipsFragment.java"

# interfaces
.implements Lcom/bignerdranch/expandablerecyclerview/model/Parent;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/tips/TipsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Tip"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/bignerdranch/expandablerecyclerview/model/Parent",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private a:I

.field private b:I

.field private c:I

.field private d:I

.field private e:I

.field private f:I

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private h:Z


# direct methods
.method public constructor <init>(II)V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 324
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 316
    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d:I

    .line 317
    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e:I

    .line 320
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g:Ljava/util/List;

    .line 322
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->h:Z

    .line 325
    iput p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a:I

    .line 326
    iput p2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c:I

    .line 327
    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 0

    .prologue
    .line 338
    invoke-direct {p0, p1, p2}, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;-><init>(II)V

    .line 339
    iput p3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d:I

    .line 340
    iput p4, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e:I

    .line 341
    return-void
.end method

.method public constructor <init>(IIIILjava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IIII",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, -0x1

    .line 329
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 316
    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d:I

    .line 317
    iput v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e:I

    .line 320
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g:Ljava/util/List;

    .line 322
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->h:Z

    .line 330
    iput p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a:I

    .line 331
    iput p2, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->b:I

    .line 332
    iput p3, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c:I

    .line 333
    iput p4, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->f:I

    .line 334
    iput-object p5, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g:Ljava/util/List;

    .line 335
    return-void
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 361
    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->g:Ljava/util/List;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    goto :goto_0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 378
    iput-boolean p1, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->h:Z

    .line 379
    return-void
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 366
    iget-boolean v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->h:Z

    return v0
.end method

.method public c()I
    .locals 1

    .prologue
    .line 344
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->a:I

    return v0
.end method

.method public d()I
    .locals 1

    .prologue
    .line 348
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->c:I

    return v0
.end method

.method public e()I
    .locals 1

    .prologue
    .line 352
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->d:I

    return v0
.end method

.method public f()I
    .locals 1

    .prologue
    .line 356
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->e:I

    return v0
.end method

.method public g()I
    .locals 1

    .prologue
    .line 370
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->f:I

    return v0
.end method

.method public h()I
    .locals 1

    .prologue
    .line 374
    iget v0, p0, Lcom/jibo/ui/fragment/tips/TipsFragment$Tip;->b:I

    return v0
.end method
