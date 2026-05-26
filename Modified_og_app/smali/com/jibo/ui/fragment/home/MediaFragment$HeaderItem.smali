.class Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;
.super Ljava/lang/Object;
.source "MediaFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/fragment/home/MediaFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "HeaderItem"
.end annotation


# instance fields
.field public a:I

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:I

.field public e:I


# direct methods
.method public constructor <init>(ILjava/lang/String;IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 925
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 926
    iput p1, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->a:I

    .line 927
    iput-object p2, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->b:Ljava/lang/String;

    .line 928
    iput p3, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->d:I

    .line 929
    iput p4, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->e:I

    .line 930
    iput-object p5, p0, Lcom/jibo/ui/fragment/home/MediaFragment$HeaderItem;->c:Ljava/lang/String;

    .line 931
    return-void
.end method
