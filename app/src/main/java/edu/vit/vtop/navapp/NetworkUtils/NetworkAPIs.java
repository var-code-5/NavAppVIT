package edu.vit.vtop.navapp.NetworkUtils;

import java.util.List;

import edu.vit.vtop.navapp.Utils.DataModel;
import edu.vit.vtop.navapp.Utils.VersionModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import edu.vit.vtop.navapp.BuildConfig;

public interface NetworkAPIs {
    String AUTH_TOKEN = BuildConfig.AUTH_TOKEN;

    @GET("api/getIndependent")
    @Headers({"auth-token: " + AUTH_TOKEN})
    Call<List<DataModel>> getIndependent();

    @GET("api/version")
    @Headers({"auth-token: " + AUTH_TOKEN})
    Call<VersionModel> getVersion();

    @GET("api/getByCategory/{id}")
    @Headers({"auth-token: " + AUTH_TOKEN})
    Call<List<DataModel>> getCategory(@Path("id") String category);

    @GET("api/search")
    @Headers({"auth-token: " + AUTH_TOKEN})
    Call<List<DataModel>> search(@Query("sk") String key);
}
