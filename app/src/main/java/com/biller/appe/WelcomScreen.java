package com.biller.appe;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

/**
 * Created by Ingenian on 21/11/2016.
 */

public class WelcomScreen extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimaryDark)
                .page(new TitlePage(R.drawable.wallet,
                        "Title")
                )
                .page(new BasicPage(R.drawable.cloud,
                        "Header",
                        "More text.")
                        .background(R.color.red_background)
                )
                .page(new BasicPage(R.drawable.basket,
                        "Lorem ipsum",
                        "dolor sit amet.")
                )
                .swipeToDismiss(true)
                .build();
    }

    public static String welcomeKey() {
        return "WelcomeScreen";
    }
}
