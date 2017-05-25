package nhutlm.lamodafashion.ui.promotion.dagger;

import dagger.Component;
import nhutlm.lamodafashion.ui.promotion.PromotionActivity;

/**
 * Created by cpu1-216-local on 25/05/2017.
 */

@Component(modules = {PromotionDetailModule.class})
public interface PromotionDetailComponent {
    void inject(PromotionActivity context);
}
