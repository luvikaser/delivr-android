package nhutlm.lamodafashion.ui.promotions.core;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.models.Promotions;
import nhutlm.lamodafashion.utils.UiUtils;
import nhutlm.lamodafashion.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static android.view.View.GONE;

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

        view.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                view.messPromotion.setVisibility(GONE);
                subscriptions.add(getPromotions());
            }
        });
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
            if (!networkAvailable && view.messPromotion != null && view.mSwipeRefreshLayout != null) {
                view.swapAdapter(new ArrayList<Promotion>());
                view.messPromotion.setText(model.context.getString(R.string.mess_no_internet));
                view.mSwipeRefreshLayout.setRefreshing(false);

            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.providePromotions()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(promotions -> {
                    if (promotions.getRecords().size() == 0 && view.messPromotion != null) {
                        view.messPromotion.setVisibility(View.VISIBLE);
                        view.messPromotion.setText(model.context.getString(R.string.mess_no_product));
                    }
                    view.swapAdapter((ArrayList<Promotion>) promotions.getRecords());
                    promotionsList = (ArrayList<Promotion>) promotions.getRecords();
                    if (view.mSwipeRefreshLayout != null)
                        view.mSwipeRefreshLayout.setRefreshing(false);
                }, throwable -> {
                    view.swapAdapter(new ArrayList<Promotion>());
                    if (view.mSwipeRefreshLayout != null)
                        view.mSwipeRefreshLayout.setRefreshing(false);
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
