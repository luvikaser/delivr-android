package nhutlm.lamodafashion.application.builder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import nhutlm.lamodafashion.api.PromotionApi;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */
@Module
public class PromotionsApiServiceModule {
    private static final String BASE_URL = "https://api.airtable.com/v0/appyFxwSsciobKBM5/";
    @AppScope
    @Provides
    PromotionApi provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter)
    {

        Retrofit retrofit =   new Retrofit.Builder().client(client)
                .baseUrl(BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return  retrofit.create(PromotionApi.class);
    }


}
