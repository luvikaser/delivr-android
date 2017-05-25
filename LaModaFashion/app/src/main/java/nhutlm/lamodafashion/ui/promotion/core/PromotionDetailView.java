package nhutlm.lamodafashion.ui.promotion.core;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.models.Picture;
import nhutlm.lamodafashion.models.Promotion;
import nhutlm.lamodafashion.ui.Intro.IntroFragment;
import nhutlm.lamodafashion.ui.promotion.PromotionActivity;
import nhutlm.lamodafashion.ui.promotion.verticalviewpager.VerticalViewPager;

/**
 * Created by cpu1-216-local on 25/05/2017.
 */

public class PromotionDetailView {

    @BindView(R.id.thumbnails)
    VerticalViewPager thumbnails;
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
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.favorite)
    ImageView favorite;
    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;

    boolean isFavorited = false;
    View view;
    Context context;
    @OnClick(R.id.favorite)
    void onClick(View v){
        if (isFavorited){
            favorite.setImageResource(R.drawable.favor);
            isFavorited = false;
        } else{
            favorite.setImageResource(R.drawable.favor_filled);
            isFavorited = true;
        }
    }
    private MyViewPagerAdapter myViewPagerAdapter;
    private List<String> listImageUrl = new ArrayList<>();
    private ImageView[] dots;


    public PromotionDetailView(PromotionActivity context, Promotion promotion)
    {
        this.context = context;
        FrameLayout layout = new FrameLayout(context);
        layout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view = LayoutInflater.from(context).inflate(R.layout.activity_promotion_detail, layout, true);
        ButterKnife.bind(this, view);

        context.setSupportActionBar(toolbar);

        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/font1.ttf");
        categoryTitle.setTypeface(face); category.setTypeface(face);
        marketTitle.setTypeface(face); market.setTypeface(face);
        priceTitle.setTypeface(face); price.setTypeface(face);
        productDetailTitle.setTypeface(face); productName.setTypeface(face); productDesc.setTypeface(face);

        for(Picture pic: promotion.getFields().getPicture()){
            listImageUrl.add(pic.getUrl());
        }

        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        thumbnails.setAdapter(myViewPagerAdapter);
        thumbnails.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                thumbnails.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        thumbnails.addOnPageChangeListener(viewPagerPageChangeListener);


        category.setText(TextUtils.isEmpty(promotion.getFields().getCategory()) ? "no category" : promotion.getFields().getCategory());
        market.setText(TextUtils.isEmpty(promotion.getFields().getMarket().toString()) ? "no market" : promotion.getFields().getMarket().toString());
        price.setText(TextUtils.isEmpty(promotion.getFields().getPrice()) ? "no price" : promotion.getFields().getCurrency()+ " " + promotion.getFields().getPrice());
        productName.setText(TextUtils.isEmpty(promotion.getFields().getName()) ? "no name" : promotion.getFields().getName());
        productDesc.setText(TextUtils.isEmpty(promotion.getFields().getDescription()) ? "no description" : promotion.getFields().getDescription());
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    private void addBottomDots(int currentPage) {
        dots = new ImageView[listImageUrl.size()];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(context);
            dots[i].setImageResource(R.drawable.dot_unselect);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(35, 35);
            params.setMargins(0, 0, 0, 8);
            dotsLayout.addView(dots[i], params);
        }

        if (dots.length > 0)
            dots[currentPage].setImageResource(R.drawable.dot_select);
    }

    public View view()
    {
        return view;
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            android.util.Log.e("test", listImageUrl.get(position));
            ImageView view = new ImageView(context);
            Glide.with(context).load(listImageUrl.get(position)).into(view);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return listImageUrl.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}