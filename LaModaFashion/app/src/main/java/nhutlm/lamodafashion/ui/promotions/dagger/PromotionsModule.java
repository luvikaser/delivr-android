package nhutlm.lamodafashion.ui.promotions.dagger;

import dagger.Module;
import dagger.Provides;
import nhutlm.lamodafashion.api.PromotionApi;
import nhutlm.lamodafashion.ui.promotions.PromotionsActivity;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsModel;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsPresenter;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsView;
import nhutlm.lamodafashion.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */
@Module
public class PromotionsModule {
    PromotionsActivity context;

    public PromotionsModule(PromotionsActivity context) {
        this.context = context;
    }



    @PromotionsScope
    @Provides
    PromotionsView provideView() {
        return new PromotionsView(context);
    }

    @PromotionsScope
    @Provides
    PromotionsPresenter providePresenter(RxSchedulers schedulers, PromotionsView view, PromotionsModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new PromotionsPresenter(schedulers, model, view, subscriptions);
    }

    @PromotionsScope
    @Provides
    PromotionsActivity provideContext() {
        return context;
    }

    @PromotionsScope
    @Provides
    PromotionsModel provideModel(PromotionApi api) {
        return new PromotionsModel(context, api);
    }
}
