package nhutlm.lamodafashion.ui.Intro;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.OnClick;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.ui.base.BaseFragment;
import butterknife.BindView;
/**
 * Created by cpu1-216-local on 20/05/2017.
 */

public class IntroFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;

    @BindView(R.id.btnStart)
    Button btnStart;

    @OnClick(R.id.btnStart)
    void onClick(View v){
        ((IntroActivity)getActivity()).launchHomeScreen();
    }

    private ImageView[] dots;
    private int[] layouts;
    private MyViewPagerAdapter myViewPagerAdapter;
    private int currentPage = 0;
    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    protected int getResLayoutId() {
        return R.layout.fragment_intro;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layouts = new int[]{
                R.layout.intro_slide1,
                R.layout.intro_slide2,
                R.layout.intro_slide3,
                R.layout.intro_slide4};

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/font1.ttf");
        btnStart.setTypeface(face);

        new CountDownTimer(12000, 3000) {

            @Override
            public void onTick(long millisUntilFinished) {
                if (currentPage < layouts.length)
                    viewPager.setCurrentItem(++currentPage, true);
            }

            @Override
            public void onFinish() {
                ((IntroActivity)getActivity()).launchHomeScreen();
            }
            }.start();
    }

    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            //noinspection deprecation
            return context.getResources().getColor(id);
        }
    }

    private void addBottomDots(int currentPage) {
        dots = new ImageView[layouts.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageResource(R.drawable.dot_unselect);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(35, 35);
            params.setMargins(0, 0, 8, 0);
            dotsLayout.addView(dots[i], params);
        }

        if (dots.length > 0)
            dots[currentPage].setImageResource(R.drawable.dot_select);
    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
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


    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView desc = (TextView) view.findViewById(R.id.desc);

            Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/font1.ttf");
            title.setTypeface(face);
            desc.setTypeface(face);
            title.setScaleX(1.1f);
            desc.setScaleX(1.05f);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
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
