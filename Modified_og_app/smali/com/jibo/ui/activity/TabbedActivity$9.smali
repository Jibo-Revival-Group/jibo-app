.class Lcom/jibo/ui/activity/TabbedActivity$9;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity;->D()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;)V
    .locals 0

    .prologue
    .line 607
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$9;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 610
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$9;->a:Lcom/jibo/ui/activity/TabbedActivity;

    iget-object v0, v0, Lcom/jibo/ui/activity/TabbedActivity;->jiboList:Landroid/support/v7/widget/RecyclerView;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/RecyclerView;->setTag(Ljava/lang/Object;)V

    .line 611
    return-void
.end method
