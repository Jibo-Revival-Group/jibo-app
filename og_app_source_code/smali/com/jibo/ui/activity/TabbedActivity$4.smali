.class Lcom/jibo/ui/activity/TabbedActivity$4;
.super Ljava/lang/Object;
.source "TabbedActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/TabbedActivity;->a(Landroid/content/Loader;Landroid/database/Cursor;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

.field final synthetic b:Lcom/jibo/ui/activity/TabbedActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/jibo/ui/activity/TabbedActivity$4;->b:Lcom/jibo/ui/activity/TabbedActivity;

    iput-object p2, p0, Lcom/jibo/ui/activity/TabbedActivity$4;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 367
    iget-object v0, p0, Lcom/jibo/ui/activity/TabbedActivity$4;->b:Lcom/jibo/ui/activity/TabbedActivity;

    iget-object v1, p0, Lcom/jibo/ui/activity/TabbedActivity$4;->a:Lcom/jibo/aws/integration/aws/services/loop/model/Loop;

    invoke-static {v0, v1}, Lcom/jibo/ui/activity/TabbedActivity;->b(Lcom/jibo/ui/activity/TabbedActivity;Lcom/jibo/aws/integration/aws/services/loop/model/Loop;)V

    .line 368
    return-void
.end method
