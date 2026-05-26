.class public Lcom/jibo/api/iheart/IHeartApiServiceGenerator;
.super Ljava/lang/Object;
.source "IHeartApiServiceGenerator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jibo/api/iheart/IHeartApiServiceGenerator$DataDeserializer;,
        Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;
    }
.end annotation


# static fields
.field private static a:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static b:Lcom/google/gson/Gson;

.field private static c:Lokhttp3/logging/HttpLoggingInterceptor;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 37
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    .line 40
    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    const-string v1, "US"

    const-string v2, "https://us.api.iheart.com/"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    const-string v1, "AU"

    const-string v2, "https://au.api.iheart.com/"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    const-string v1, "CA"

    const-string v2, "https://ca.api.iheart.com/"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    const-string v1, "NZ"

    const-string v2, "https://nz.api.iheart.com/"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    new-instance v1, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$2;

    invoke-direct {v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$2;-><init>()V

    .line 52
    invoke-virtual {v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$2;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    new-instance v2, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$DataDeserializer;

    invoke-direct {v2}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$DataDeserializer;-><init>()V

    .line 51
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    new-instance v1, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$1;

    invoke-direct {v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$1;-><init>()V

    .line 54
    invoke-virtual {v1}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    new-instance v2, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$DataDeserializer;

    invoke-direct {v2}, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$DataDeserializer;-><init>()V

    .line 53
    invoke-virtual {v0, v1, v2}, Lcom/google/gson/GsonBuilder;->a(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;

    move-result-object v0

    .line 55
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->a()Lcom/google/gson/Gson;

    move-result-object v0

    sput-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->b:Lcom/google/gson/Gson;

    .line 57
    new-instance v0, Lokhttp3/logging/HttpLoggingInterceptor;

    invoke-direct {v0}, Lokhttp3/logging/HttpLoggingInterceptor;-><init>()V

    sget-object v1, Lokhttp3/logging/HttpLoggingInterceptor$Level;->NONE:Lokhttp3/logging/HttpLoggingInterceptor$Level;

    invoke-virtual {v0, v1}, Lokhttp3/logging/HttpLoggingInterceptor;->a(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;

    move-result-object v0

    sput-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->c:Lokhttp3/logging/HttpLoggingInterceptor;

    return-void
.end method

.method public static a(Ljava/lang/String;Lokhttp3/Interceptor;)Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;
    .locals 5

    .prologue
    .line 76
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 77
    new-instance v0, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v0}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    .line 78
    new-instance v1, Lretrofit2/Retrofit$Builder;

    invoke-direct {v1}, Lretrofit2/Retrofit$Builder;-><init>()V

    invoke-virtual {v1, p0}, Lretrofit2/Retrofit$Builder;->a(Ljava/lang/String;)Lretrofit2/Retrofit$Builder;

    move-result-object v1

    sget-object v2, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->b:Lcom/google/gson/Gson;

    .line 79
    invoke-static {v2}, Lretrofit2/converter/gson/GsonConverterFactory;->a(Lcom/google/gson/Gson;)Lretrofit2/converter/gson/GsonConverterFactory;

    move-result-object v2

    invoke-virtual {v1, v2}, Lretrofit2/Retrofit$Builder;->a(Lretrofit2/Converter$Factory;)Lretrofit2/Retrofit$Builder;

    move-result-object v1

    .line 81
    const-wide/16 v2, 0xa

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v4}, Lokhttp3/OkHttpClient$Builder;->b(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;

    .line 82
    sget-object v2, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->c:Lokhttp3/logging/HttpLoggingInterceptor;

    invoke-virtual {v0, v2}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 84
    if-eqz p1, :cond_0

    invoke-virtual {v0, p1}, Lokhttp3/OkHttpClient$Builder;->a(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;

    .line 86
    :cond_0
    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->a()Lokhttp3/OkHttpClient;

    move-result-object v0

    invoke-virtual {v1, v0}, Lretrofit2/Retrofit$Builder;->a(Lokhttp3/OkHttpClient;)Lretrofit2/Retrofit$Builder;

    .line 87
    invoke-virtual {v1}, Lretrofit2/Retrofit$Builder;->a()Lretrofit2/Retrofit;

    move-result-object v0

    .line 88
    const-class v1, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator$IHeartStationsApiService;

    .line 90
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/jibo/api/iheart/IHeartApiServiceGenerator;->a:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
