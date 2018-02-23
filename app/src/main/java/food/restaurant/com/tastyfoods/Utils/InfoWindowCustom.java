package food.restaurant.com.tastyfoods.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/14/2018.
 */

public class InfoWindowCustom implements GoogleMap.InfoWindowAdapter {
    Context context;
    LayoutInflater inflater;
    public InfoWindowCustom(Context context) {
        this.context = context;
    }
    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // R.layout.echo_info_window is a layout in my
        // res/layout folder. You can provide your own
        View v = inflater.inflate(R.layout.info_window_custom, null);

        TextView title = (TextView) v.findViewById(R.id.info_window_title);
        TextView subtitle = (TextView) v.findViewById(R.id.info_window_subtitle);
        title.setText(marker.getTitle());
        subtitle.setText(marker.getSnippet());
        return v;
    }
}
