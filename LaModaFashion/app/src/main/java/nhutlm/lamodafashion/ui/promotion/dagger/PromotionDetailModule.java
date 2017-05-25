package nhutlm.lamodafashion.ui.promotion.dagger;

import dagger.Module;
import dagger.Provides;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.promotion.PromotionActivity;
import nhutlm.lamodafashion.ui.promotion.core.PromotionDetailView;

/**
 * Created by cpu1-216-local on 25/05/2017.
 */

@Module
public class PromotionDetailModule  {

    PromotionActivity detailsContext;
    Promotion promotion;

    public PromotionDetailModule(PromotionActivity context, Promotion promotion)
    {
        this.detailsContext = context;
        this.promotion = promotion;
    }

    @Provides
    PromotionDetailView provideView()
    {
        return  new PromotionDetailView(detailsContext, promotion);
    }
}
