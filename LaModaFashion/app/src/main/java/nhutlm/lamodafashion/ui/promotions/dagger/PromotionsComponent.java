package nhutlm.lamodafashion.ui.promotions.dagger;

import dagger.Component;
import nhutlm.lamodafashion.application.builder.AppComponent;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsView;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */

@PromotionsScope
@Component(dependencies = {AppComponent.class} , modules = {PromotionsModule.class})
public interface PromotionsComponent {

    void inject(PromotionsView promotionsView);
}