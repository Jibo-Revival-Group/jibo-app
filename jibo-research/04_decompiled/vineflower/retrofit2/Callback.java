package retrofit2;

public interface Callback<T> {
   void a(Call<T> var1, Throwable var2);

   void a(Call<T> var1, Response<T> var2);
}
