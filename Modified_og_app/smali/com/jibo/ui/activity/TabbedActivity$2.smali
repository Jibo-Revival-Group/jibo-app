.class Lcom/jibo/ui/activity/TabbedActivity$2;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/jibo/ui/activity/TabbedActivity;
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
    .line 122
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$2;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 125
    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity$2;->a:Lcom/jibo/ui/activity/TabbedActivity;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v1, v0}, Lcom/jibo/ui/activity/TabbedActivity;->a(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 126
    return-void
.end method
