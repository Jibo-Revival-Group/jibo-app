package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a */
    private State f8517a = State.NOT_READY;

    /* JADX INFO: renamed from: b */
    private T f8518b;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX INFO: renamed from: a */
    protected abstract T mo8982a();

    protected AbstractIterator() {
    }

    /* JADX INFO: renamed from: b */
    protected final T m8983b() {
        this.f8517a = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.m9022b(this.f8517a != State.FAILED);
        switch (this.f8517a) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
                return m8981c();
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m8981c() {
        this.f8517a = State.FAILED;
        this.f8518b = mo8982a();
        if (this.f8517a == State.DONE) {
            return false;
        }
        this.f8517a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f8517a = State.NOT_READY;
        T t = this.f8518b;
        this.f8518b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
