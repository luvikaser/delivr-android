package nhutlm.lamodafashion.ui.promotions.core;

import android.util.Log;

import java.util.ArrayList;

import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.models.Promotions;
import nhutlm.lamodafashion.utils.UiUtils;
import nhutlm.lamodafashion.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class PromotionsPresenter {
    PromotionsView view;
    PromotionsModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;
    ArrayList<Promotion> promotionsList = new ArrayList<>();

    public PromotionsPresenter(RxSchedulers schedulers, PromotionsModel model, PromotionsView view, CompositeSubscription sub) {
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = sub;
    }

    public void onCreate() {
        subscriptions.add(getPromotions());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }


    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoPromotionDetailsActivity(promotionsList.get(integer)));
    }


    private Subscription getPromotions() {
        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                // UiUtils.showSnackbar();
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.providePromotions()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(promotions -> {

            view.swapAdapter((ArrayList<Promotion>) promotions.getRecords());
                promotionsList = (ArrayList<Promotion>) promotions.getRecords();
                }, throwable -> {
            android.util.Log.e("test", throwable.toString());

            UiUtils.handleThrowable(throwable);
                }
        );

    }
}
