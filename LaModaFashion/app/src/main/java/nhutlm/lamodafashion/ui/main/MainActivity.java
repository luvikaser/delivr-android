package nhutlm.lamodafashion.ui.main;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import nhutlm.lamodafashion.R;
import nhutlm.lamodafashion.ui.promotions.core.PromotionsView;

/**
 * Created by Luvi Kaser on 5/23/2017.
 */

public class MainActivity extends AppCompatActivity{
        private BottomNavigationView mBottomNav;
        private int mSelectedItem;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        selectFragment(mBottomNav.getMenu().getItem(2));
    }

    private void selectFragment(MenuItem item) {
        Fragment frag = null;
        switch (item.getItemId()) {
            case R.id.add:
                frag = PromotionsView.newInstance(new PromotionsView(), null);
                break;
        }

        // update selected item
        mSelectedItem = item.getItemId();
        android.util.Log.e("selectFragment: ", item.getItemId()+"");
        // uncheck the other items.
        for (int i = 0; i< mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(i);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }


        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, frag, frag.getTag());
            ft.commit();
        }
    }
}
