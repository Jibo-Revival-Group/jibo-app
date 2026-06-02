package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class Types {
    public static ParameterizedType getSuperParameterizedType(Type type, Class<?> cls) {
        Class<?> cls2;
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            Type genericSuperclass = type;
            while (genericSuperclass != null && genericSuperclass != Object.class) {
                if (genericSuperclass instanceof Class) {
                    cls2 = (Class) genericSuperclass;
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                    Class<?> rawClass = getRawClass(parameterizedType);
                    if (rawClass != cls) {
                        if (cls.isInterface()) {
                            for (Type type2 : rawClass.getGenericInterfaces()) {
                                if (cls.isAssignableFrom(type2 instanceof Class ? (Class) type2 : getRawClass((ParameterizedType) type2))) {
                                    genericSuperclass = type2;
                                    break;
                                }
                            }
                        }
                        cls2 = rawClass;
                    } else {
                        return parameterizedType;
                    }
                }
                genericSuperclass = cls2.getGenericSuperclass();
            }
        }
        return null;
    }

    public static boolean isAssignableToOrFrom(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw handleExceptionForNewInstance(e, cls);
        } catch (InstantiationException e2) {
            throw handleExceptionForNewInstance(e2, cls);
        }
    }

    private static IllegalArgumentException handleExceptionForNewInstance(Exception exc, Class<?> cls) {
        StringBuilder sbAppend = new StringBuilder("unable to create new instance of class ").append(cls.getName());
        ArrayList<String> arrayList = new ArrayList();
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (!Modifier.isPublic(cls.getModifiers())) {
                arrayList.add("possibly because it is not public");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException e) {
                    arrayList.add("because it has no accessible default constructor");
                }
            }
        }
        boolean z = false;
        for (String str : arrayList) {
            if (z) {
                sbAppend.append(" and");
            } else {
                z = true;
            }
            sbAppend.append(" ").append(str);
        }
        return new IllegalArgumentException(sbAppend.toString(), exc);
    }

    public static boolean isArray(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static Type getArrayComponentType(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Class<?> getRawClass(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static Type getBound(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length != 0 ? lowerBounds[0] : wildcardType.getUpperBounds()[0];
    }

    public static Type resolveTypeVariable(List<Type> list, TypeVariable<?> typeVariable) {
        Type typeResolveTypeVariable;
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType superParameterizedType = null;
            while (superParameterizedType == null) {
                size--;
                if (size < 0) {
                    break;
                }
                superParameterizedType = getSuperParameterizedType(list.get(size), cls);
            }
            if (superParameterizedType != null) {
                TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                int i = 0;
                while (i < typeParameters.length && !typeParameters[i].equals(typeVariable)) {
                    i++;
                }
                Type type = superParameterizedType.getActualTypeArguments()[i];
                return (!(type instanceof TypeVariable) || (typeResolveTypeVariable = resolveTypeVariable(list, (TypeVariable) type)) == null) ? type : typeResolveTypeVariable;
            }
        }
        return null;
    }

    public static Class<?> getRawArrayComponentType(List<Type> list, Type type) {
        Type typeResolveTypeVariable = type instanceof TypeVariable ? resolveTypeVariable(list, (TypeVariable) type) : type;
        if (typeResolveTypeVariable instanceof GenericArrayType) {
            return Array.newInstance(getRawArrayComponentType(list, getArrayComponentType(typeResolveTypeVariable)), 0).getClass();
        }
        if (typeResolveTypeVariable instanceof Class) {
            return (Class) typeResolveTypeVariable;
        }
        if (typeResolveTypeVariable instanceof ParameterizedType) {
            return getRawClass((ParameterizedType) typeResolveTypeVariable);
        }
        Preconditions.checkArgument(typeResolveTypeVariable == null, "wildcard type is not supported: %s", typeResolveTypeVariable);
        return Object.class;
    }

    public static Type getIterableParameter(Type type) {
        return getActualParameterAtPosition(type, Iterable.class, 0);
    }

    public static Type getMapValueParameter(Type type) {
        return getActualParameterAtPosition(type, Map.class, 1);
    }

    private static Type getActualParameterAtPosition(Type type, Class<?> cls, int i) {
        Type typeResolveTypeVariable;
        ParameterizedType superParameterizedType = getSuperParameterizedType(type, cls);
        if (superParameterizedType == null) {
            return null;
        }
        Type type2 = superParameterizedType.getActualTypeArguments()[i];
        return (!(type2 instanceof TypeVariable) || (typeResolveTypeVariable = resolveTypeVariable(Arrays.asList(type), (TypeVariable) type2)) == null) ? type2 : typeResolveTypeVariable;
    }

    public static <T> Iterable<T> iterableOf(final Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        Preconditions.checkArgument(cls.isArray(), "not an array or Iterable: %s", cls);
        if (!cls.getComponentType().isPrimitive()) {
            return Arrays.asList((Object[]) obj);
        }
        return new Iterable<T>() { // from class: com.google.api.client.util.Types.1
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new Iterator<T>() { // from class: com.google.api.client.util.Types.1.1
                    int index = 0;
                    final int length;

                    {
                        this.length = Array.getLength(obj);
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.index < this.length;
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        Object obj2 = obj;
                        int i = this.index;
                        this.index = i + 1;
                        return (T) Array.get(obj2, i);
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static Object toArray(Collection<?> collection, Class<?> cls) {
        if (!cls.isPrimitive()) {
            return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
        }
        Object objNewInstance = Array.newInstance(cls, collection.size());
        int i = 0;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Array.set(objNewInstance, i, it.next());
            i++;
        }
        return objNewInstance;
    }

    private Types() {
    }
}
