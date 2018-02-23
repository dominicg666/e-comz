package food.restaurant.com.tastyfoods.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import food.restaurant.com.tastyfoods.Model.Slider;
import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/10/2018.
 */

public class SliderAdapter extends PagerAdapter {

    ArrayList<Slider> sliderModel;
    private LayoutInflater inflater;
    private Context context;

    public SliderAdapter(Context context,ArrayList<Slider> sliderModel){
        this.context=context;
        this.sliderModel=sliderModel;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return sliderModel.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view,final int position) {

        Slider slider=sliderModel.get(position);
        SliderAdapter.ViewHolder holder = new SliderAdapter.ViewHolder();
        View myImageLayout = inflater.inflate(R.layout.slider_item, view, false);
        holder.imageView = (ImageView) myImageLayout
                .findViewById(R.id.image);
        holder.imageView.setImageResource(slider.getImage());

        //Picasso.with(context).load("http://hnewsurdu.tv/api/imageprocess/460/220/"+images.get(position)).into(holder.imageView);



//        myImage.setImageResource(images.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    static class ViewHolder {
        ImageView imageView;
    }

}
