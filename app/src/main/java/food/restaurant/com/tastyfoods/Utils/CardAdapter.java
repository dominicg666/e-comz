package food.restaurant.com.tastyfoods.Utils;

/**
 * Created by Design-4 on 2/23/2018.
 */

import android.support.v7.widget.CardView;

/**
 * Created by Design-4 on 2/19/2018.
 */

import android.support.v7.widget.CardView;

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 6;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
