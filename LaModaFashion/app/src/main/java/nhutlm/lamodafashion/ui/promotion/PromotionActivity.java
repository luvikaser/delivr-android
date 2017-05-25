package nhutlm.lamodafashion.ui.promotion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.promotion.core.PromotionDetailView;
import nhutlm.lamodafashion.ui.promotion.dagger.DaggerPromotionDetailComponent;
import nhutlm.lamodafashion.ui.promotion.dagger.PromotionDetailModule;

/**
 * Created by cpu1-216-local on 25/05/2017.
 */

public class PromotionActivity extends AppCompatActivity {
    @Inject
    PromotionDetailView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Promotion promotion = (Promotion) getIntent().getExtras().get("promotion");
        DaggerPromotionDetailComponent.builder().promotionDetailModule(new PromotionDetailModule(this, promotion)).build().inject(this);
        setContentView(view.view());
    }
}
