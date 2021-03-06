package nhutlm.lamodafashion.ui.promotions.core;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

import nhutlm.lamodafashion.api.PromotionApi;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.models.Promotions;
import nhutlm.lamodafashion.ui.promotion.PromotionActivity;
import nhutlm.lamodafashion.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class PromotionsModel {
    Activity context;
    PromotionApi api;

    public PromotionsModel(Activity context, PromotionApi api) {
        this.api = api;
        this.context = context;
    }


    Observable<Promotions> providePromotions() {
        return api.getPromotions(null, "", 10, 100, null, "Grid view");
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }



    public void gotoPromotionDetailsActivity(Promotion promotion) {
        Intent in = new Intent(context, PromotionActivity.class);
        in.putExtra("promotion", (Serializable) promotion);
        context.startActivity(in);
    }

}
