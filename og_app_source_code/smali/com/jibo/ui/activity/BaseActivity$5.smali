.class Lcom/jibo/ui/activity/BaseActivity$5;
.super Ljava/lang/Object;
.source "BaseActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/jibo/ui/activity/BaseActivity;->a(Ljava/lang/Exception;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/jibo/ui/activity/BaseActivity;


# direct methods
.method constructor <init>(Lcom/jibo/ui/activity/BaseActivity;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/jibo/ui/activity/BaseActivity$5;->b:Lcom/jibo/ui/activity/BaseActivity;

    iput-object p2, p0, Lcom/jibo/ui/activity/BaseActivity$5;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 287
    iget-object v0, p0, Lcom/jibo/ui/activity/BaseActivity$5;->b:Lcom/jibo/ui/activity/BaseActivity;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/jibo/ui/activity/BaseActivity$5;->a:Ljava/lang/Exception;

    invoke-static {v0, v1, v2}, Lcom/jibo/utils/ErrorHelper;->a(Landroid/support/v7/app/AppCompatActivity;Landroid/support/v4/app/Fragment;Ljava/lang/Throwable;)Z

    .line 288
    return-void
.end method
