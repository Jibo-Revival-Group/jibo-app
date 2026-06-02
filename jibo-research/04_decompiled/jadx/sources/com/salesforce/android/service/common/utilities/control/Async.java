package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.functional.Function;

/* JADX INFO: loaded from: classes.dex */
public interface Async<T> {

    public interface CompletionHandler {
        /* JADX INFO: renamed from: a */
        void mo12580a(Async<?> async);
    }

    public interface ErrorHandler {
        /* JADX INFO: renamed from: a */
        void mo12581a(Async<?> async, Throwable th);
    }

    public interface Handler extends CompletionHandler, ErrorHandler, ResultHandler {
    }

    public interface ResultHandler<T> {
        /* JADX INFO: renamed from: a */
        void mo9875a(Async<?> async, T t);
    }

    /* JADX INFO: renamed from: a */
    Async<T> mo14072a(CompletionHandler completionHandler);

    /* JADX INFO: renamed from: a */
    Async<T> mo14073a(ErrorHandler errorHandler);

    /* JADX INFO: renamed from: a */
    Async<T> mo14074a(ResultHandler<? super T> resultHandler);

    /* JADX INFO: renamed from: a */
    Async<T> mo14075a(ResultReceiver<? super T> resultReceiver);

    /* JADX INFO: renamed from: a */
    <S> Async<S> mo14076a(Function<? super T, ? extends S> function);

    /* JADX WARN: Incorrect types in method signature: <S::Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler<-TT;>;:Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;:Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;>(TS;)Lcom/salesforce/android/service/common/utilities/control/Async<TT;>; */
    /* JADX INFO: renamed from: b */
    Async mo14077b(ResultHandler resultHandler);

    /* JADX INFO: renamed from: b */
    <S> Async<S> mo14078b(Function<? super T, ? extends Async<? extends S>> function);

    /* JADX WARN: Incorrect types in method signature: <S::Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler<-TT;>;:Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;:Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;>(TS;)Lcom/salesforce/android/service/common/utilities/control/Async<TT;>; */
    /* JADX INFO: renamed from: c */
    Async mo14079c(ResultHandler resultHandler);

    /* JADX INFO: renamed from: c */
    void mo14080c();

    /* JADX INFO: renamed from: d */
    boolean mo14081d();

    /* JADX INFO: renamed from: e */
    boolean mo14082e();

    /* JADX INFO: renamed from: f */
    boolean mo14083f();
}
