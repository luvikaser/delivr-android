package nhutlm.lamodafashion.ui.promotions.dagger;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import nhutlm.lamodafashion.api.PromotionApi;
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
    PromotionsView view;

    public PromotionsModule(PromotionsView view) {
        this.view = view;
    }



    @PromotionsScope
    @Provides
    PromotionsView provideView() {
        return view;
    }

    @PromotionsScope
    @Provides
    PromotionsPresenter providePresenter(RxSchedulers schedulers, PromotionsView view, PromotionsModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new PromotionsPresenter(schedulers, model, view, subscriptions);
    }

    @PromotionsScope
    @Provides
    Context provideContext() {
        return view.getActivity();
    }

    @PromotionsScope
    @Provides
    PromotionsModel provideModel(PromotionApi api) {
        return new PromotionsModel(view.getActivity(), api);
    }
}
