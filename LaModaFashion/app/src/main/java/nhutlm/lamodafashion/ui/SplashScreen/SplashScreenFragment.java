package nhutlm.lamodafashion.ui.SplashScreen;

import android.Manifest;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.ui.Intro.IntroActivity;
import nhutlm.lamodafashion.ui.base.RuntimePermissionFragment;

/**
 * Created by cpu1-216-local on 20/05/2017.
 */

public class SplashScreenFragment extends RuntimePermissionFragment {

    public static final int STARTUP_DELAY = 200;
    public static final int ANIM_ITEM_DURATION = 500;
    public static final int ITEM_DELAY = 300;

    @BindView(R.id.img_logo)
    ImageView logoImageView;

    @BindView(R.id.container)
    ViewGroup container;

    @BindView(R.id.slogan)
    TextView slogan;


    private boolean checkGrantedPermissionReadExternal() {
//        return isPermissionGranted(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                RuntimePermissionFragment.PERMISSION_READ_STORAGE_CODE);
        return true;
    }

    private void animate() {
        Typeface face = Typeface.createFromAsset(getContext().getAssets(), "fonts/font.ttf");
        slogan.setTypeface(face);
        ViewCompat.animate(logoImageView)
                .translationY(-30)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION).setInterpolator(
                new DecelerateInterpolator(1.2f)).start();
        ViewPropertyAnimatorCompat viewAnimator = null;
        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);


            if (!(v instanceof Button)) {
                viewAnimator = ViewCompat.animate(v)
                        .translationY(60).alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(1000);
            } else {
                viewAnimator = ViewCompat.animate(v)
                        .scaleY(1).scaleX(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(500);
            }


            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }

        viewAnimator.setListener(new ViewPropertyAnimatorListener() {
            @Override
            public void onAnimationStart(View view) {

            }

            @Override
            public void onAnimationEnd(View view) {
                if (checkGrantedPermissionReadExternal()) {
                    openMainActivity();
                }
            }

            @Override
            public void onAnimationCancel(View view) {

            }
        });

    }

    private void openMainActivity() {
        Intent intent = new Intent(getActivity(), IntroActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animate();
    }

    @Override
    protected void permissionGranted(int permissionRequestCode) {
        switch (permissionRequestCode) {
            case RuntimePermissionFragment.PERMISSION_READ_STORAGE_CODE:
                openMainActivity();
                break;
        }
    }

    @Override
    protected void setupFragmentComponent() {

    }

    @Override
    protected int getResLayoutId() {
        return R.layout.activity_splash_screen_onboarding_center;
    }
}