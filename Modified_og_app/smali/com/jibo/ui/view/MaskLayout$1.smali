.class Lcom/jibo/ui/view/MaskLayout$1;
.super Ljava/lang/Object;
.source "MaskLayout.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/view/MaskLayout;->a()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/view/ViewTreeObserver;

.field final synthetic b:Lcom/jibo/ui/view/MaskLayout;


# direct methods
.method constructor <init>(Lcom/jibo/ui/view/MaskLayout;Landroid/view/ViewTreeObserver;)V
    .locals 0

    .prologue
    .line 215
    iput-object p1, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    iput-object p2, p0, Lcom/jibo/ui/view/MaskLayout$1;->a:Landroid/view/ViewTreeObserver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 3

    .prologue
    .line 218
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout$1;->a:Landroid/view/ViewTreeObserver;

    .line 219
    invoke-virtual {v0}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v1

    if-nez v1, :cond_0

    .line 220
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    invoke-virtual {v0}, Lcom/jibo/ui/view/MaskLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 222
    :cond_0
    if-eqz v0, :cond_2

    .line 223
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x10

    if-lt v1, v2, :cond_1

    .line 224
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 231
    :goto_0
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    iget-object v1, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    iget-object v2, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    invoke-static {v2}, Lcom/jibo/ui/view/MaskLayout;->a(Lcom/jibo/ui/view/MaskLayout;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/ui/view/MaskLayout;->a(Lcom/jibo/ui/view/MaskLayout;Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Lcom/jibo/ui/view/MaskLayout;Landroid/graphics/Bitmap;)V

    .line 232
    return-void

    .line 226
    :cond_1
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0

    .line 229
    :cond_2
    iget-object v0, p0, Lcom/jibo/ui/view/MaskLayout$1;->b:Lcom/jibo/ui/view/MaskLayout;

    const-string v1, "GlobalLayoutListener not removed as ViewTreeObserver is not valid"

    invoke-static {v0, v1}, Lcom/jibo/ui/view/MaskLayout;->a(Lcom/jibo/ui/view/MaskLayout;Ljava/lang/String;)V

    goto :goto_0
.end method
