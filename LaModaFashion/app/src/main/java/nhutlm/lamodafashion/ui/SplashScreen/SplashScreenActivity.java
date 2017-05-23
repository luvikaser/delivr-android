package nhutlm.lamodafashion.ui.SplashScreen;

import android.os.Bundle;
import android.view.View;

import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.ui.base.BaseActivity;
import nhutlm.lamodafashion.ui.base.BaseFragment;

/**
 * Created by cpu1-216-local on 20/05/2017.
 */

public class SplashScreenActivity extends BaseActivity {

    @Override
    public BaseFragment getFragmentToHost() {
        return SplashScreenFragment.newInstance(new SplashScreenFragment(), getIntent().getExtras());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.MyMaterialTheme);
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }
}