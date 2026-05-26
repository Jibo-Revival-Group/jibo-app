.class Lcom/google/maps/OkHttpRequestHandler$Builder$1;
.super Ljava/lang/Object;
.source "OkHttpRequestHandler.java"

# interfaces
.implements Lokhttp3/Authenticator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/maps/OkHttpRequestHandler$Builder;->proxyAuthentication(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/maps/OkHttpRequestHandler$Builder;

.field final synthetic val$password:Ljava/lang/String;

.field final synthetic val$userName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/maps/OkHttpRequestHandler$Builder;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/google/maps/OkHttpRequestHandler$Builder$1;->this$0:Lcom/google/maps/OkHttpRequestHandler$Builder;

    iput-object p2, p0, Lcom/google/maps/OkHttpRequestHandler$Builder$1;->val$userName:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/maps/OkHttpRequestHandler$Builder$1;->val$password:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public authenticate(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 144
    iget-object v0, p0, Lcom/google/maps/OkHttpRequestHandler$Builder$1;->val$userName:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/maps/OkHttpRequestHandler$Builder$1;->val$password:Ljava/lang/String;

    invoke-static {v0, v1}, Lokhttp3/Credentials;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 146
    invoke-virtual {p2}, Lokhttp3/Response;->a()Lokhttp3/Request;

    move-result-object v1

    .line 147
    invoke-virtual {v1}, Lokhttp3/Request;->e()Lokhttp3/Request$Builder;

    move-result-object v1

    const-string v2, "Proxy-Authorization"

    .line 148
    invoke-virtual {v1, v2, v0}, Lokhttp3/Request$Builder;->a(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v0

    .line 149
    invoke-virtual {v0}, Lokhttp3/Request$Builder;->c()Lokhttp3/Request;

    move-result-object v0

    .line 145
    return-object v0
.end method
