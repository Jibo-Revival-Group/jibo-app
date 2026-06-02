package okhttp3;

/* JADX INFO: loaded from: classes2.dex */
abstract class EventListener {

    /* JADX INFO: renamed from: a */
    public static final EventListener f15063a = new EventListener() { // from class: okhttp3.EventListener.1
    };

    public interface Factory {
        /* JADX INFO: renamed from: a */
        EventListener mo15604a(Call call);
    }

    EventListener() {
    }

    /* JADX INFO: renamed from: a */
    static Factory m15603a(EventListener eventListener) {
        return new Factory() { // from class: okhttp3.EventListener.2
            @Override // okhttp3.EventListener.Factory
            /* JADX INFO: renamed from: a */
            public EventListener mo15604a(Call call) {
                return EventListener.this;
            }
        };
    }
}
