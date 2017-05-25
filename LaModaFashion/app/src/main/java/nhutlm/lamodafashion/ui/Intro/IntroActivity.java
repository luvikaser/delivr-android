package nhutlm.lamodafashion.ui.Intro;

import android.content.Intent;
import android.os.Bundle;

import nhutlm.lamodafashion.ui.base.BaseActivity;
import nhutlm.lamodafashion.ui.base.BaseFragment;
import nhutlm.lamodafashion.ui.main.MainActivity;
import nhutlm.lamodafashion.utils.PrefManager;

/**
 * Created by cpu1-216-local on 20/05/2017.
 */

public class IntroActivity extends BaseActivity {
    PrefManager prefManager;
    @Override
    public BaseFragment getFragmentToHost() {
        return IntroFragment.newInstance(new IntroFragment(), getIntent().getExtras());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
    }

    public void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
