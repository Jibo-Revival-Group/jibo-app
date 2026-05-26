.class Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;
.super Ljava/lang/Object;
.source "TakeoverInAppActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;->a(Landroid/widget/Button;Lcom/mixpanel/android/mpmetrics/InAppButton;Lcom/mixpanel/android/mpmetrics/InAppNotification;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Landroid/graphics/drawable/GradientDrawable;

.field final synthetic c:Lcom/mixpanel/android/mpmetrics/InAppButton;

.field final synthetic d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;


# direct methods
.method constructor <init>(Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;ILandroid/graphics/drawable/GradientDrawable;Lcom/mixpanel/android/mpmetrics/InAppButton;)V
    .locals 0

    .prologue
    .line 154
    iput-object p1, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->d:Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity;

    iput p2, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->a:I

    iput-object p3, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->b:Landroid/graphics/drawable/GradientDrawable;

    iput-object p4, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->c:Lcom/mixpanel/android/mpmetrics/InAppButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 158
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 159
    iget v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->a:I

    .line 160
    iget-object v1, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->b:Landroid/graphics/drawable/GradientDrawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    .line 164
    :goto_0
    const/4 v0, 0x0

    return v0

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->b:Landroid/graphics/drawable/GradientDrawable;

    iget-object v1, p0, Lcom/mixpanel/android/takeoverinapp/TakeoverInAppActivity$2;->c:Lcom/mixpanel/android/mpmetrics/InAppButton;

    invoke-virtual {v1}, Lcom/mixpanel/android/mpmetrics/InAppButton;->c()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V

    goto :goto_0
.end method
