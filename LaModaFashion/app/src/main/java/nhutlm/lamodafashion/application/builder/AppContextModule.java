package nhutlm.lamodafashion.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
