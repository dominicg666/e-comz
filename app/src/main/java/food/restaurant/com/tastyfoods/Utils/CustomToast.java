package food.restaurant.com.tastyfoods.Utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/9/2018.
 */

public class CustomToast {

    public CustomToast(Context context,String message){

        LayoutInflater inflater =(LayoutInflater)  context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) ((Activity) context).findViewById(R.id.toastTextView));
        // set a message
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);

        // Toast...
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}

