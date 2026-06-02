package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ClassesInfoCache {

    /* JADX INFO: renamed from: a */
    static ClassesInfoCache f22a = new ClassesInfoCache();

    /* JADX INFO: renamed from: b */
    private final Map<Class, CallbackInfo> f23b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Map<Class, Boolean> f24c = new HashMap();

    ClassesInfoCache() {
    }

    /* JADX INFO: renamed from: a */
    boolean m25a(Class cls) {
        if (this.f24c.containsKey(cls)) {
            return this.f24c.get(cls).booleanValue();
        }
        Method[] methodArrM24c = m24c(cls);
        for (Method method : methodArrM24c) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                m22a(cls, methodArrM24c);
                return true;
            }
        }
        this.f24c.put(cls, false);
        return false;
    }

    /* JADX INFO: renamed from: c */
    private Method[] m24c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: renamed from: b */
    CallbackInfo m26b(Class cls) {
        CallbackInfo callbackInfo = this.f23b.get(cls);
        if (callbackInfo == null) {
            return m22a(cls, null);
        }
        return callbackInfo;
    }

    /* JADX INFO: renamed from: a */
    private void m23a(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + methodReference.f28b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        }
        if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    /* JADX INFO: renamed from: a */
    private CallbackInfo m22a(Class cls, Method[] methodArr) {
        int i;
        boolean z;
        CallbackInfo callbackInfoM26b;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (callbackInfoM26b = m26b(superclass)) != null) {
            map.putAll(callbackInfoM26b.f26b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : m26b(cls2).f26b.entrySet()) {
                m23a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m24c(cls);
        }
        int length = methodArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            Method method = methodArr[i2];
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent == null) {
                z = z2;
            } else {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                Lifecycle.Event eventM87a = onLifecycleEvent.m87a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (eventM87a != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m23a(map, new MethodReference(i, method), eventM87a, cls);
                z = true;
            }
            i2++;
            z2 = z;
        }
        CallbackInfo callbackInfo = new CallbackInfo(map);
        this.f23b.put(cls, callbackInfo);
        this.f24c.put(cls, Boolean.valueOf(z2));
        return callbackInfo;
    }

    static class CallbackInfo {

        /* JADX INFO: renamed from: a */
        final Map<Lifecycle.Event, List<MethodReference>> f25a = new HashMap();

        /* JADX INFO: renamed from: b */
        final Map<MethodReference, Lifecycle.Event> f26b;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.f26b = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> arrayList = this.f25a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f25a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        /* JADX INFO: renamed from: a */
        void m28a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            m27a(this.f25a.get(event), lifecycleOwner, event, obj);
            m27a(this.f25a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }

        /* JADX INFO: renamed from: a */
        private static void m27a(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m29a(lifecycleOwner, event, obj);
                }
            }
        }
    }

    static class MethodReference {

        /* JADX INFO: renamed from: a */
        final int f27a;

        /* JADX INFO: renamed from: b */
        final Method f28b;

        MethodReference(int i, Method method) {
            this.f27a = i;
            this.f28b = method;
            this.f28b.setAccessible(true);
        }

        /* JADX INFO: renamed from: a */
        void m29a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                switch (this.f27a) {
                    case 0:
                        this.f28b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f28b.invoke(obj, lifecycleOwner);
                        return;
                    case 2:
                        this.f28b.invoke(obj, lifecycleOwner, event);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.f27a == methodReference.f27a && this.f28b.getName().equals(methodReference.f28b.getName());
        }

        public int hashCode() {
            return (this.f27a * 31) + this.f28b.getName().hashCode();
        }
    }
}
