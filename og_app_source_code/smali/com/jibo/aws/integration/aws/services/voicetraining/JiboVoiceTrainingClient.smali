.class public Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;
.super Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>()V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/ClientConfiguration;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/metrics/RequestMetricCollector;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/metrics/RequestMetricCollector;)V

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->a()V

    return-void
.end method

.method private a()V
    .locals 2

    const-string v0, "voicetraining"

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->setServiceNameIntern(Ljava/lang/String;)V

    const-string v0, "voicetraining"

    const-string v1, "VoiceTraining_20151103."

    invoke-virtual {p0, v0, v1}, Lcom/jibo/aws/integration/aws/services/voicetraining/JiboVoiceTrainingClient;->setServiceType(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
