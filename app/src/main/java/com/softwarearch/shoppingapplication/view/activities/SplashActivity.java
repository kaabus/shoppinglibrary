package com.softwarearch.shoppingapplication.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.softwarearch.shoppingapplication.R;
import com.softwarearch.shoppingapplication.application.ShoppingApplication;
import com.softwarearch.shoppingapplication.components.ApplicationComponent;
import com.softwarearch.shoppingapplication.components.DaggerSplashActivityComponent;
import com.softwarearch.shoppingapplication.components.SplashActivityComponent;
import com.softwarearch.shoppingapplication.context.ApplicationContext;
import com.softwarearch.shoppingapplication.context_modules.SplashActivityContextModule;
import com.softwarearch.shoppingapplication.contracts.SplashActivityContract;
import com.softwarearch.shoppingapplication.models.database_models.User;
import com.softwarearch.shoppingapplication.mvp_modules.SplashActivityMvpModule;
import com.softwarearch.shoppingapplication.presenter.SplashPresenterImpl;
import com.softwarearch.shoppingapplication.view.adapters.IntroSliderAdapter;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements SplashActivityContract.View{

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private IntroSliderAdapter introSliderAdapter;
    @BindView(R.id.layoutDots)
    LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    @BindView(R.id.btn_skip)
    Button btnSkip;
    @BindView(R.id.btn_next)
    Button btnNext;

    SplashActivityComponent mSplashActivityComponent;
    @Inject
    @ApplicationContext
    public Context context;

    @Inject
    SplashPresenterImpl splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        ApplicationComponent applicationComponent = ShoppingApplication.get(this).getApplicationComponent();

        mSplashActivityComponent = DaggerSplashActivityComponent.builder()
                .splashActivityContextModule(new SplashActivityContextModule(this))
                .splashActivityMvpModule(new SplashActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();
        mSplashActivityComponent.injectSplashActivity(this);
        if (!splashPresenter.isUserFirstTime()){
            try {
                launchHomeScreen(splashPresenter.getUser());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide4};

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        changeStatusBarColor();

        introSliderAdapter = new IntroSliderAdapter(this,layouts);
        viewPager.setAdapter(introSliderAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


    }

    @OnClick(R.id.btn_skip)
    public void onBtnSkipClicked(View view){
        try {
            launchHomeScreen(splashPresenter.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btn_next)
    public void onBtnNextClicked(View view){
        int current = getItem(+1);
        if (current < layouts.length) {
            // move to next screen
            viewPager.setCurrentItem(current);
        } else {
            try {

                launchHomeScreen(new User.UserBuilder().withOptionalFirstLaunch(true).buildUser());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(boolean firstLaunch) {

    }

    @Override
    public void showError(String call, String statusMessage) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showComplete() {

    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private void launchHomeScreen(User user) throws Exception {
        splashPresenter.addUser(user);
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
