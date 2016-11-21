package com.biller.appe;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;

import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.stephentuso.welcome.WelcomeHelper;

public class MainActivity extends AppCompatActivity implements BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener {

    private BottomBar mBottomBar;
    private FragNavController mNavController;
    private android.support.v7.app.ActionBar mActionBar;
    private Activity mActivity;

    private final int INDEX_CATEGORIES = FragNavController.TAB3;
    private final int INDEX_DASHBOARD = FragNavController.TAB2;
    private final int INDEX_PERFIL = FragNavController.TAB4;
    private final int INDEX_PRESUPUESTO = FragNavController.TAB1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActionBar = this.getSupportActionBar();

        mActivity = this;

        mNavController =
                new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.contentContainer,this,5, INDEX_PRESUPUESTO);

        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_categories:
                        mNavController.switchTab(INDEX_CATEGORIES);
                        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7B1FA2")));
                        setStatusBarColor(mActivity,"#7B1FA2");
                        break;
                    case R.id.tab_dashboard:
                        mNavController.switchTab(INDEX_DASHBOARD);
                        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d32f2f")));
                        setStatusBarColor(mActivity,"#d32f2f");
                        break;
                    case R.id.tab_perfil:
                        mNavController.switchTab(INDEX_PERFIL);
                        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1976D2")));
                        setStatusBarColor(mActivity,"#1976D2");
                        break;
                    case R.id.tab_presupuesto:
                        mNavController.switchTab(INDEX_PRESUPUESTO);
                        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#388E3C")));
                        setStatusBarColor(mActivity,"#388E3C");
                        break;
                }
            }
        });

        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId){
                mNavController.clearStack();
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mNavController.canPop()) {
            mNavController.pop();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.push(fragment);
        }
    }

    @Override
    public void onTabTransaction(Fragment fragment, int index) {
        //do tabby stuff
    }

    @Override
    public void onFragmentTransaction(Fragment fragment) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {
            case INDEX_CATEGORIES:
                return CatFragment.newInstance(0);
            case INDEX_DASHBOARD:
                return DashFragment.newInstance(0);
            case INDEX_PERFIL:
                return PrFragment.newInstance(0);
            case INDEX_PRESUPUESTO:
                return PresupuestoFragment.newInstance(0);
        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    public static void setStatusBarColor(Activity activity,String color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // If both system bars are black, we can remove these from our layout,
            // removing or shrinking the SurfaceFlinger overlay required for our views.


            //change here
            Window window = activity.getWindow();

            // By -->>>>> Window window = getWindow();

            //or by this if call in Fragment
            // -->>>>> Window window = getActivity().getWindow();


            int statusBarColor = Color.parseColor(color);

            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }

}
