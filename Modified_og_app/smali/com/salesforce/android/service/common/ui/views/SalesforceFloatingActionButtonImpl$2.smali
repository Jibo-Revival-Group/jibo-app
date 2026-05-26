.class Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;
.super Landroid/animation/AnimatorListenerAdapter;
.source "SalesforceFloatingActionButtonImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Lcom/salesforce/android/service/common/utilities/spatial/Coordinate;)Landroid/animation/Animator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;


# direct methods
.method constructor <init>(Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 3

    .prologue
    .line 174
    iget-object v0, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget-object v1, v1, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->h:Landroid/graphics/drawable/Drawable;

    iget-object v2, p0, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl$2;->a:Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;

    iget v2, v2, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->j:I

    invoke-virtual {v0, v1, v2}, Lcom/salesforce/android/service/common/ui/views/SalesforceFloatingActionButtonImpl;->a(Landroid/graphics/drawable/Drawable;I)V

    .line 175
    return-void
.end method
