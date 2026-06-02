package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BasicAsync<T> implements Async<T>, ResultReceiver<T> {

    /* JADX INFO: renamed from: a */
    private T f13817a;

    /* JADX INFO: renamed from: b */
    private Throwable f13818b;

    /* JADX INFO: renamed from: c */
    private boolean f13819c;

    /* JADX INFO: renamed from: d */
    private boolean f13820d;

    /* JADX INFO: renamed from: e */
    private Set<Async.ResultHandler<? super T>> f13821e = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: f */
    private Set<Async.ErrorHandler> f13822f = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: g */
    private Set<Async.CompletionHandler> f13823g = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: renamed from: g */
    public static <T> BasicAsync<T> m14086g() {
        return new BasicAsync<>();
    }

    /* JADX INFO: renamed from: c */
    public static <T> BasicAsync<T> m14085c(Throwable th) {
        return new BasicAsync().mo12615b(th);
    }

    /* JADX INFO: renamed from: c */
    public static <T> BasicAsync<T> m14084c(T t) {
        return new BasicAsync().mo12614b(t).mo12613b();
    }

    /* JADX INFO: renamed from: h */
    public static <T> BasicAsync<T> m14087h() {
        return new BasicAsync().mo12613b();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: a */
    public Async<T> mo14074a(Async.ResultHandler<? super T> resultHandler) {
        if (!this.f13820d && this.f13818b == null) {
            if (this.f13817a != null) {
                resultHandler.mo9875a(this, this.f13817a);
            }
            if (!this.f13819c) {
                this.f13821e.add(resultHandler);
            }
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: a */
    public Async<T> mo14073a(Async.ErrorHandler errorHandler) {
        if (!this.f13820d && !this.f13819c) {
            if (this.f13818b != null) {
                errorHandler.mo12581a(this, this.f13818b);
            } else {
                this.f13822f.add(errorHandler);
            }
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: a */
    public Async<T> mo14072a(Async.CompletionHandler completionHandler) {
        if (!this.f13820d && this.f13818b == null) {
            if (this.f13819c) {
                completionHandler.mo12580a(this);
            } else {
                this.f13823g.add(completionHandler);
            }
        }
        return this;
    }

    /* JADX WARN: Incorrect types in method signature: <S::Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler<-TT;>;:Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;:Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;>(TS;)Lcom/salesforce/android/service/common/utilities/control/Async<TT;>; */
    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: b */
    public Async mo14077b(Async.ResultHandler resultHandler) {
        mo14074a(resultHandler);
        mo14073a((Async.ErrorHandler) resultHandler);
        mo14072a((Async.CompletionHandler) resultHandler);
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: c */
    public void mo14080c() {
        if (mo14083f()) {
            this.f13820d = true;
            this.f13821e.clear();
            this.f13822f.clear();
        }
    }

    /* JADX INFO: renamed from: d */
    public Async<T> m14091d(Async.ResultHandler<? super T> resultHandler) {
        this.f13821e.remove(resultHandler);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Async<T> m14089b(Async.ErrorHandler errorHandler) {
        this.f13822f.remove(errorHandler);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public Async<T> m14088b(Async.CompletionHandler completionHandler) {
        this.f13823g.remove(completionHandler);
        return this;
    }

    /* JADX WARN: Incorrect types in method signature: <S::Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler<-TT;>;:Lcom/salesforce/android/service/common/utilities/control/Async$ErrorHandler;:Lcom/salesforce/android/service/common/utilities/control/Async$CompletionHandler;>(TS;)Lcom/salesforce/android/service/common/utilities/control/Async<TT;>; */
    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: c */
    public Async mo14079c(Async.ResultHandler resultHandler) {
        m14091d(resultHandler);
        m14089b((Async.ErrorHandler) resultHandler);
        m14088b((Async.CompletionHandler) resultHandler);
        return this;
    }

    /* JADX INFO: renamed from: i */
    public boolean m14093i() {
        return this.f13820d;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: d */
    public boolean mo14081d() {
        return this.f13819c;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: e */
    public boolean mo14082e() {
        return this.f13818b != null;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: f */
    public boolean mo14083f() {
        return (m14093i() || mo14081d() || mo14082e()) ? false : true;
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public <S> BasicAsync<S> mo14076a(Function<? super T, ? extends S> function) {
        return new MappedAsync(this, function);
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public <S> BasicAsync<S> mo14078b(Function<? super T, ? extends Async<? extends S>> function) {
        return new ChainedAsync(this, function);
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async
    /* JADX INFO: renamed from: a */
    public Async<T> mo14075a(final ResultReceiver<? super T> resultReceiver) {
        if (resultReceiver != this) {
            mo14077b((Async.ResultHandler) new Async.Handler<T>() { // from class: com.salesforce.android.service.common.utilities.control.BasicAsync.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public void mo9875a(Async<?> async, T t) {
                    resultReceiver.mo12614b(t);
                }

                @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
                /* JADX INFO: renamed from: a */
                public void mo12581a(Async<?> async, Throwable th) {
                    resultReceiver.mo12615b(th);
                }

                @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
                /* JADX INFO: renamed from: a */
                public void mo12580a(Async<?> async) {
                    resultReceiver.mo12613b();
                }
            });
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BasicAsync<T> mo12614b(T t) {
        if (mo14083f() && t != null) {
            this.f13817a = t;
            Iterator<Async.ResultHandler<? super T>> it = this.f13821e.iterator();
            while (it.hasNext()) {
                it.next().mo9875a(this, t);
            }
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BasicAsync<T> mo12615b(Throwable th) {
        if (mo14083f()) {
            this.f13818b = th;
            Iterator<Async.ErrorHandler> it = this.f13822f.iterator();
            while (it.hasNext()) {
                it.next().mo12581a(this, th);
            }
            this.f13821e.clear();
            this.f13822f.clear();
            this.f13823g.clear();
        }
        return this;
    }

    @Override // com.salesforce.android.service.common.utilities.control.ResultReceiver
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BasicAsync<T> mo12613b() {
        if (mo14083f()) {
            this.f13819c = true;
            Iterator<Async.CompletionHandler> it = this.f13823g.iterator();
            while (it.hasNext()) {
                it.next().mo12580a(this);
            }
            this.f13821e.clear();
            this.f13822f.clear();
            this.f13823g.clear();
        }
        return this;
    }

    private static class MappedAsync<T, S> extends BasicAsync<S> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {

        /* JADX INFO: renamed from: a */
        private final BasicAsync<T> f13829a;

        /* JADX INFO: renamed from: b */
        private final Function<? super T, ? extends S> f13830b;

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: a */
        public /* synthetic */ Async mo14076a(Function function) {
            return super.mo14076a(function);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: b */
        public /* synthetic */ Async mo14078b(Function function) {
            return super.mo14078b(function);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12613b() {
            return super.mo12613b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12614b(Object obj) {
            return super.mo12614b(obj);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12615b(Throwable th) {
            return super.mo12615b(th);
        }

        MappedAsync(BasicAsync<T> basicAsync, Function<? super T, ? extends S> function) {
            this.f13829a = basicAsync;
            this.f13830b = function;
            basicAsync.mo14077b((Async.ResultHandler) this);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: c */
        public void mo14080c() {
            super.mo14080c();
            this.f13829a.mo14080c();
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            mo12615b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            try {
                mo12614b(this.f13830b.mo12236a(t));
            } catch (Throwable th) {
                mo12615b(th);
            }
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo12580a(Async<?> async) {
            mo12613b();
        }
    }

    private static class ChainedAsync<T, S> extends BasicAsync<S> implements Async.ErrorHandler, Async.ResultHandler<T> {

        /* JADX INFO: renamed from: a */
        private final BasicAsync<T> f13826a;

        /* JADX INFO: renamed from: b */
        private Async<? extends S> f13827b;

        /* JADX INFO: renamed from: c */
        private final Function<? super T, ? extends Async<? extends S>> f13828c;

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: a */
        public /* synthetic */ Async mo14076a(Function function) {
            return super.mo14076a(function);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: b */
        public /* synthetic */ Async mo14078b(Function function) {
            return super.mo14078b(function);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12613b() {
            return super.mo12613b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12614b(Object obj) {
            return super.mo12614b(obj);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.ResultReceiver
        /* JADX INFO: renamed from: b */
        public /* synthetic */ ResultReceiver mo12615b(Throwable th) {
            return super.mo12615b(th);
        }

        ChainedAsync(BasicAsync<T> basicAsync, Function<? super T, ? extends Async<? extends S>> function) {
            this.f13826a = basicAsync;
            this.f13828c = function;
            this.f13826a.mo14073a((Async.ErrorHandler) this);
            this.f13826a.mo14074a((Async.ResultHandler) this);
        }

        @Override // com.salesforce.android.service.common.utilities.control.BasicAsync, com.salesforce.android.service.common.utilities.control.Async
        /* JADX INFO: renamed from: c */
        public void mo14080c() {
            super.mo14080c();
            this.f13826a.mo14080c();
            if (this.f13827b != null) {
                this.f13827b.mo14080c();
            }
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
        /* JADX INFO: renamed from: a */
        public void mo12581a(Async<?> async, Throwable th) {
            mo12615b(th);
        }

        @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
        /* JADX INFO: renamed from: a */
        public void mo9875a(Async<?> async, T t) {
            try {
                this.f13827b = this.f13828c.mo12236a(t);
                this.f13827b.mo14075a((ResultReceiver<? super Object>) this);
            } catch (Throwable th) {
                mo12615b(th);
            }
        }
    }
}
