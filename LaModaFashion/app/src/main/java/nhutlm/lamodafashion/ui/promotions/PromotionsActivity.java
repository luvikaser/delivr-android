package nhutlm.lamodafashion.ui.promotions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;

import javax.inject.Inject;

import nhutlm.lamodafashion.application.AppController;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsPresenter;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsView;
import nhutlm.lamodafashion.ui.promotions.dagger.DaggerPromotionsComponent;
import nhutlm.lamodafashion.ui.promotions.dagger.PromotionsModule;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class PromotionsActivity extends AppCompatActivity{
    @Inject
    PromotionsView view;
    @Inject
    PromotionsPresenter presenter;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerPromotionsComponent.builder().appComponent(AppController.getNetComponent()).promotionsModule(new PromotionsModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToPromotionDetailsActivity(Promotion promotion) {

//        Intent in = new Intent(this, HeroDetailsActivity.class);
//        in.putExtra("promotion", (Serializable) promotion);
//        startActivity(in);

    }
}
