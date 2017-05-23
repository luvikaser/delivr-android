package nhutlm.lamodafashion.ui.promotions.core;

import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.promotions.PromotionsActivity;
import nhutlm.lamodafashion.ui.promotions.list.PromotionsAdapter;
import rx.Observable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class PromotionsView {
    @BindView(R.id.activity_promotions_list_recycleview)
    RecyclerView list;
    @BindView(R.id.promotion_page_title)
    TextView pageTitle;
    @BindView(R.id.product_count)
    TextView countProducts;

    View view;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    PromotionsAdapter adapter;

    public PromotionsView(PromotionsActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_promotion_list, parent, true);
        ButterKnife.bind(this, view);

        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/font1.ttf");
        pageTitle.setTypeface(face);
        countProducts.setTypeface(face);
        adapter = new PromotionsAdapter();
        list.setAdapter(adapter);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        list.setLayoutManager(gaggeredGridLayoutManager);
            }

    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<Promotion> promotions)
    {
        adapter.swapAdapter(promotions);
        countProducts.setText(promotions.size() + " " + view.getContext().getString(R.string.product));

    }
}
