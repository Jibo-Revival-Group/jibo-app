.class public Lcom/jibo/ui/view/ErrorImageView;
.super Landroid/widget/ImageView;
.source "ErrorImageView.java"


# instance fields
.field private a:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 12
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/ErrorImageView;->a:Z

    .line 16
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/ErrorImageView;->a:Z

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 12
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/jibo/ui/view/ErrorImageView;->a:Z

    .line 24
    return-void
.end method


# virtual methods
.method public getError()Z
    .locals 1

    .prologue
    .line 26
    iget-boolean v0, p0, Lcom/jibo/ui/view/ErrorImageView;->a:Z

    return v0
.end method

.method public setError(Z)V
    .locals 0

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/jibo/ui/view/ErrorImageView;->a:Z

    .line 30
    return-void
.end method
