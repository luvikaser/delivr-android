package nhutlm.lamodafashion.ui.promotion.core;

import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.promotion.PromotionActivity;

/**
 * Created by cpu1-216-local on 25/05/2017.
 */

public class PromotionDetailView {

    @BindView(R.id.thumbnails)
    ViewPager thumbnails;
    @BindView(R.id.category_title)
    TextView categoryTitle;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.market_title)
    TextView marketTitle;
    @BindView(R.id.market)
    TextView market;
    @BindView(R.id.price_title)
    TextView priceTitle;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.product_detail_title)
    TextView productDetailTitle;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.desc)
    TextView productDesc;

    View view;

    public PromotionDetailView(PromotionActivity context, Promotion promotion)
    {
        FrameLayout layout = new FrameLayout(context);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(context).inflate(R.layout.activity_promotion_detail, layout, true);
        ButterKnife.bind(this, view);

        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/font1.ttf");
        categoryTitle.setTypeface(face); category.setTypeface(face);
        marketTitle.setTypeface(face); market.setTypeface(face);
        priceTitle.setTypeface(face); price.setTypeface(face);
        productDetailTitle.setTypeface(face); productName.setTypeface(face); productDesc.setTypeface(face);

        category.setText(TextUtils.isEmpty(promotion.getFields().getCategory()) ? "no category" : promotion.getFields().getCategory());
        market.setText(TextUtils.isEmpty(promotion.getFields().getMarket().toString()) ? "no market" : promotion.getFields().getMarket().toString());
        price.setText(TextUtils.isEmpty(promotion.getFields().getPrice()) ? "no price" : promotion.getFields().getCurrency()+ " " + promotion.getFields().getPrice());
        productName.setText(TextUtils.isEmpty(promotion.getFields().getName()) ? "no name" : promotion.getFields().getName());
        productDesc.setText(TextUtils.isEmpty(promotion.getFields().getDescription()) ? "no description" : promotion.getFields().getDescription());
    }

    public View view()
    {
        return view;
    }



}