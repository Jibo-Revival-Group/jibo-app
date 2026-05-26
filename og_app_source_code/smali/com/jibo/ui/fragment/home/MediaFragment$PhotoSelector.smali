.class Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;
.super Ljava/lang/Object;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PhotoSelector"
.end annotation


# instance fields
.field private a:Landroid/util/SparseBooleanArray;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 1695
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1697
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    return-void
.end method

.method synthetic constructor <init>(Lcom/jibo/ui/fragment/home/MediaFragment$1;)V
    .locals 0

    .prologue
    .line 1695
    invoke-direct {p0}, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1708
    move v1, v0

    .line 1709
    :goto_0
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    invoke-virtual {v2}, Landroid/util/SparseBooleanArray;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 1710
    iget-object v2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    invoke-virtual {v2, v0}, Landroid/util/SparseBooleanArray;->valueAt(I)Z

    move-result v2

    if-eqz v2, :cond_0

    add-int/lit8 v1, v1, 0x1

    .line 1709
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1712
    :cond_1
    return v1
.end method

.method public a(IZ)V
    .locals 1

    .prologue
    .line 1700
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 1701
    return-void
.end method

.method public a(I)Z
    .locals 2

    .prologue
    .line 1704
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    return v0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 1716
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 1717
    return-void
.end method

.method public c()Landroid/util/SparseBooleanArray;
    .locals 1

    .prologue
    .line 1720
    iget-object v0, p0, Lcom/jibo/ui/fragment/home/MediaFragment$PhotoSelector;->a:Landroid/util/SparseBooleanArray;

    return-object v0
.end method
