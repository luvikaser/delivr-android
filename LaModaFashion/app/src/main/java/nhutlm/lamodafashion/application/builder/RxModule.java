package nhutlm.lamodafashion.application.builder;

import dagger.Module;
import dagger.Provides;
import nhutlm.lamodafashion.utils.rx.AppRxSchedulers;
import nhutlm.lamodafashion.utils.rx.RxSchedulers;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
