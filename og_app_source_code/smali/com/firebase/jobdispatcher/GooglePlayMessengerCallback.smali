.class Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;
.super Ljava/lang/Object;
.source "GooglePlayMessengerCallback.java"

# interfaces
.implements Lcom/firebase/jobdispatcher/JobCallback;


# instance fields
.field private final a:Landroid/os/Messenger;

.field private final b:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/os/Messenger;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;->a:Landroid/os/Messenger;

    .line 36
    iput-object p2, p0, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;->b:Ljava/lang/String;

    .line 37
    return-void
.end method

.method private b(I)Landroid/os/Message;
    .locals 4

    .prologue
    .line 50
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 51
    const/4 v1, 0x3

    iput v1, v0, Landroid/os/Message;->what:I

    .line 52
    iput p1, v0, Landroid/os/Message;->arg1:I

    .line 54
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 55
    const-string v2, "tag"

    iget-object v3, p0, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;->b:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    invoke-virtual {v0, v1}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 57
    return-object v0
.end method


# virtual methods
.method public a(I)V
    .locals 2

    .prologue
    .line 42
    :try_start_0
    iget-object v0, p0, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;->a:Landroid/os/Messenger;

    invoke-direct {p0, p1}, Lcom/firebase/jobdispatcher/GooglePlayMessengerCallback;->b(I)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    return-void

    .line 43
    :catch_0
    move-exception v0

    .line 44
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
