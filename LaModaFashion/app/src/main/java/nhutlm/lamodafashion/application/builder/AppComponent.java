package nhutlm.lamodafashion.application.builder;

import android.content.Context;

import dagger.Component;
import nhutlm.lamodafashion.api.PromotionApi;
import nhutlm.lamodafashion.utils.rx.RxSchedulers;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, PromotionsApiServiceModule.class})
public interface AppComponent {

    Context getAppContext();

    RxSchedulers rxSchedulers();

    PromotionApi apiService();

}
