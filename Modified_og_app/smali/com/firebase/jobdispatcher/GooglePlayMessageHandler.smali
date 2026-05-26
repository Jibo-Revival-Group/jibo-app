.class Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;
.super Landroid/os/Handler;
.source "GooglePlayMessageHandler.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x15
.end annotation


# instance fields
.field private final a:Lcom/firebase/jobdispatcher/GooglePlayReceiver;


# direct methods
.method public constructor <init>(Landroid/os/Looper;Lcom/firebase/jobdispatcher/GooglePlayReceiver;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 46
    iput-object p2, p0, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->a:Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    .line 47
    return-void
.end method

.method private a(Landroid/os/Message;)V
    .locals 4

    .prologue
    .line 85
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 87
    iget-object v1, p1, Landroid/os/Message;->replyTo:Landroid/os/Messenger;

    .line 88
    const-string v2, "tag"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 89
    if-eqz v1, :cond_0

    if-nez v2, :cond_2

    .line 90
    :cond_0
    const-string v0, "FJD.GooglePlayReceiver"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 91
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Invalid start execution message."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    :cond_1
    :goto_0
    return-void

    .line 96
    :cond_2
    new-instance v3, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;

    invoke-direct {v3, v1, v2}, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;-><init>(Landroid/os/Messenger;Ljava/lang/String;)V

    .line 97
    iget-object v1, p0, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->a:Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    invoke-virtual {v1, v3, v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a(Lcom/firebase/jobdispatcher/JobCallback;Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    .line 98
    iget-object v1, p0, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->a:Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    invoke-virtual {v1}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->a()Lcom/firebase/jobdispatcher/ExecutionDelegator;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/firebase/jobdispatcher/ExecutionDelegator;->a(Lcom/firebase/jobdispatcher/JobInvocation;)V

    goto :goto_0
.end method

.method private b(Landroid/os/Message;)V
    .locals 2

    .prologue
    .line 102
    invoke-static {}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->b()Lcom/firebase/jobdispatcher/JobCoder;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/firebase/jobdispatcher/JobCoder;->b(Landroid/os/Bundle;)Lcom/firebase/jobdispatcher/JobInvocation$Builder;

    move-result-object v0

    .line 103
    if-nez v0, :cond_1

    .line 104
    const-string v0, "FJD.GooglePlayReceiver"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Invalid stop execution message."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/JobInvocation$Builder;->a()Lcom/firebase/jobdispatcher/JobInvocation;

    move-result-object v0

    .line 110
    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/firebase/jobdispatcher/ExecutionDelegator;->a(Lcom/firebase/jobdispatcher/JobInvocation;Z)V

    goto :goto_0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3

    .prologue
    .line 51
    if-nez p1, :cond_0

    .line 82
    :goto_0
    :pswitch_0
    return-void

    .line 55
    :cond_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->a:Lcom/firebase/jobdispatcher/GooglePlayReceiver;

    .line 57
    invoke-virtual {v0}, Lcom/firebase/jobdispatcher/GooglePlayReceiver;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "appops"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AppOpsManager;

    .line 59
    :try_start_0
    iget v1, p1, Landroid/os/Message;->sendingUid:I

    const-string v2, "com.google.android.gms"

    invoke-virtual {v0, v1, v2}, Landroid/app/AppOpsManager;->checkPackage(ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 79
    :pswitch_1
    const-string v0, "FJD.GooglePlayReceiver"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unrecognized message received: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 60
    :catch_0
    move-exception v0

    .line 61
    const-string v0, "FJD.GooglePlayReceiver"

    const-string v1, "Message was not sent from GCM."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 67
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->a(Landroid/os/Message;)V

    goto :goto_0

    .line 71
    :pswitch_3
    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayMessageHandler;->b(Landroid/os/Message;)V

    goto :goto_0

    .line 65
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
