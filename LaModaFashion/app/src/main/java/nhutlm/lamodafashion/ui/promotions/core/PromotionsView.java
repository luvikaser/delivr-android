package nhutlm.lamodafashion.ui.promotions.core;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.application.AppController;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.base.BaseFragment;
import nhutlm.lamodafashion.ui.promotions.dagger.DaggerPromotionsComponent;
import nhutlm.lamodafashion.ui.promotions.dagger.PromotionsModule;
import nhutlm.lamodafashion.ui.promotions.list.EndlessRecyclerViewScrollListener;
import nhutlm.lamodafashion.ui.promotions.list.PromotionsAdapter;
import rx.Observable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class PromotionsView extends BaseFragment {
    @Inject
    PromotionsPresenter presenter;

    @BindView(R.id.activity_promotions_list_recycleview)
    RecyclerView list;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.text_mess_promotion)
    TextView messPromotion;
    @BindView(R.id.promotion_page_title)
    TextView pageTitle;
    @BindView(R.id.product_count)
    TextView countProducts;

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    PromotionsAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DaggerPromotionsComponent.builder().appComponent(AppController.getNetComponent()).promotionsModule(new PromotionsModule(this)).build().inject(this);

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font1.ttf");
        pageTitle.setTypeface(face);
        countProducts.setTypeface(face);
        adapter = new PromotionsAdapter();
        list.setAdapter(adapter);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        list.setLayoutManager(gaggeredGridLayoutManager);

        list.addOnScrollListener(new EndlessRecyclerViewScrollListener(gaggeredGridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

            }
        });

        presenter.onCreate();

    }


    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public void swapAdapter(ArrayList<Promotion> promotions)
    {
        adapter.swapAdapter(promotions);
        if (countProducts != null) {
            countProducts.setText(promotions.size() + " " + getActivity().getString(R.string.product));
        }
    }

    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_promotion_list;
    }
}
