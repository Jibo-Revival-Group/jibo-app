.class Lcom/mixpanel/android/viewcrawler/EditorConnection;
.super Ljava/lang/Object;
.source "EditorConnection.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/mixpanel/android/viewcrawler/EditorConnection$WebSocketOutputStream;,
        Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;,
        Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;,
        Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorConnectionException;
    }
.end annotation


# static fields
.field private static final d:Ljava/nio/ByteBuffer;


# instance fields
.field private final a:Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;

.field private final b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

.field private final c:Ljava/net/URI;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 167
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    sput-object v0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->d:Ljava/nio/ByteBuffer;

    return-void
.end method

.method public constructor <init>(Ljava/net/URI;Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;Ljava/net/Socket;)V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorConnectionException;
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p2, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->a:Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;

    .line 48
    iput-object p1, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->c:Ljava/net/URI;

    .line 50
    :try_start_0
    new-instance v0, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    const/16 v1, 0x1388

    invoke-direct {v0, p0, p1, v1, p3}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;-><init>(Lcom/mixpanel/android/viewcrawler/EditorConnection;Ljava/net/URI;ILjava/net/Socket;)V

    iput-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    .line 51
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;->c()Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 55
    return-void

    .line 52
    :catch_0
    move-exception v0

    .line 53
    new-instance v1, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorConnectionException;

    invoke-direct {v1, p0, v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorConnectionException;-><init>(Lcom/mixpanel/android/viewcrawler/EditorConnection;Ljava/lang/Throwable;)V

    throw v1
.end method

.method static synthetic a(Lcom/mixpanel/android/viewcrawler/EditorConnection;)Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->a:Lcom/mixpanel/android/viewcrawler/EditorConnection$Editor;

    return-object v0
.end method

.method static synthetic b(Lcom/mixpanel/android/viewcrawler/EditorConnection;)Ljava/net/URI;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->c:Ljava/net/URI;

    return-object v0
.end method

.method static synthetic c(Lcom/mixpanel/android/viewcrawler/EditorConnection;)Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    return-object v0
.end method

.method static synthetic d()Ljava/nio/ByteBuffer;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->d:Ljava/nio/ByteBuffer;

    return-object v0
.end method


# virtual methods
.method public a()Z
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;->f()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;->g()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;->e()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/mixpanel/android/viewcrawler/EditorConnection;->b:Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;

    invoke-virtual {v0}, Lcom/mixpanel/android/viewcrawler/EditorConnection$EditorClient;->d()Z

    move-result v0

    return v0
.end method

.method public c()Ljava/io/BufferedOutputStream;
    .locals 3

    .prologue
    .line 66
    new-instance v0, Ljava/io/BufferedOutputStream;

    new-instance v1, Lcom/mixpanel/android/viewcrawler/EditorConnection$WebSocketOutputStream;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/mixpanel/android/viewcrawler/EditorConnection$WebSocketOutputStream;-><init>(Lcom/mixpanel/android/viewcrawler/EditorConnection;Lcom/mixpanel/android/viewcrawler/EditorConnection$1;)V

    invoke-direct {v0, v1}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    return-object v0
.end method
