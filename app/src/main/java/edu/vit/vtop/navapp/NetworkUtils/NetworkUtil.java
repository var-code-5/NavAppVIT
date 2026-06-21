package edu.vit.vtop.navapp.NetworkUtils;

import edu.vit.vtop.navapp.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtil {

    public static OkHttpClient getClientInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                        .addInterceptor(interceptor)
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }
        public static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClientInstance())
                .addConverterFactory(GsonConverterFactory.create()).build();

        public static NetworkAPIs networkAPI = retrofit.create(NetworkAPIs.class);

}
