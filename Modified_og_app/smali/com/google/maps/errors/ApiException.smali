.class public Lcom/google/maps/errors/ApiException;
.super Ljava/lang/Exception;
.source "ApiException.java"


# static fields
.field private static final serialVersionUID:J = -0x5ae86dc8ae3a89e7L


# direct methods
.method protected constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 27
    return-void
.end method

.method public static from(Ljava/lang/String;Ljava/lang/String;)Lcom/google/maps/errors/ApiException;
    .locals 3

    .prologue
    .line 39
    const-string v0, "OK"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 40
    const/4 v0, 0x0

    .line 89
    :goto_0
    return-object v0

    .line 41
    :cond_0
    const-string v0, "INVALID_REQUEST"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 42
    new-instance v0, Lcom/google/maps/errors/InvalidRequestException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/InvalidRequestException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 43
    :cond_1
    const-string v0, "MAX_ELEMENTS_EXCEEDED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 44
    new-instance v0, Lcom/google/maps/errors/MaxElementsExceededException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/MaxElementsExceededException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 45
    :cond_2
    const-string v0, "NOT_FOUND"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 46
    new-instance v0, Lcom/google/maps/errors/NotFoundException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/NotFoundException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 47
    :cond_3
    const-string v0, "OVER_QUERY_LIMIT"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 48
    const-string v0, "You have exceeded your daily request quota for this API."

    .line 49
    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 50
    new-instance v0, Lcom/google/maps/errors/OverDailyLimitException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/OverDailyLimitException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 52
    :cond_4
    new-instance v0, Lcom/google/maps/errors/OverQueryLimitException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/OverQueryLimitException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 53
    :cond_5
    const-string v0, "REQUEST_DENIED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 54
    new-instance v0, Lcom/google/maps/errors/RequestDeniedException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/RequestDeniedException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 55
    :cond_6
    const-string v0, "UNKNOWN_ERROR"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 56
    new-instance v0, Lcom/google/maps/errors/UnknownErrorException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/UnknownErrorException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 57
    :cond_7
    const-string v0, "ZERO_RESULTS"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 58
    new-instance v0, Lcom/google/maps/errors/ZeroResultsException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/ZeroResultsException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 62
    :cond_8
    const-string v0, "ACCESS_NOT_CONFIGURED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 63
    new-instance v0, Lcom/google/maps/errors/AccessNotConfiguredException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/AccessNotConfiguredException;-><init>(Ljava/lang/String;)V

    goto :goto_0

    .line 64
    :cond_9
    const-string v0, "INVALID_ARGUMENT"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 65
    new-instance v0, Lcom/google/maps/errors/InvalidRequestException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/InvalidRequestException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 66
    :cond_a
    const-string v0, "RESOURCE_EXHAUSTED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 67
    new-instance v0, Lcom/google/maps/errors/OverQueryLimitException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/OverQueryLimitException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 68
    :cond_b
    const-string v0, "PERMISSION_DENIED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 69
    new-instance v0, Lcom/google/maps/errors/RequestDeniedException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/RequestDeniedException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 73
    :cond_c
    const-string v0, "keyInvalid"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 74
    new-instance v0, Lcom/google/maps/errors/AccessNotConfiguredException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/AccessNotConfiguredException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 75
    :cond_d
    const-string v0, "dailyLimitExceeded"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 76
    new-instance v0, Lcom/google/maps/errors/OverDailyLimitException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/OverDailyLimitException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 77
    :cond_e
    const-string v0, "userRateLimitExceeded"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 78
    new-instance v0, Lcom/google/maps/errors/OverQueryLimitException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/OverQueryLimitException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 79
    :cond_f
    const-string v0, "notFound"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 80
    new-instance v0, Lcom/google/maps/errors/NotFoundException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/NotFoundException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 81
    :cond_10
    const-string v0, "parseError"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 82
    new-instance v0, Lcom/google/maps/errors/InvalidRequestException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/InvalidRequestException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 83
    :cond_11
    const-string v0, "invalid"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 84
    new-instance v0, Lcom/google/maps/errors/InvalidRequestException;

    invoke-direct {v0, p1}, Lcom/google/maps/errors/InvalidRequestException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 89
    :cond_12
    new-instance v0, Lcom/google/maps/errors/UnknownErrorException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "An unexpected error occurred. Status: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Message: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/maps/errors/UnknownErrorException;-><init>(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
