package food.restaurant.com.tastyfoods.Utils;

import android.app.Dialog;
import android.graphics.Point;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import food.restaurant.com.tastyfoods.R;

/**
 * Created by Design-4 on 2/13/2018.
 */

public class AddressBottomsheet extends BottomSheetDialogFragment {
    //private Unbinder unbinder;

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.modal_address_new, null);
        //unbinder = ButterKnife.bind(this, contentView);
        //dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setContentView(contentView);
        FrameLayout bottomSheet = (FrameLayout) dialog.getWindow().findViewById(android.support.design.R.id.design_bottom_sheet);
        bottomSheet.setBackgroundResource(R.drawable.bottomsheet_address);

    }
    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            //int height = ViewGroup.LayoutParams.MATCH_PARENT;
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            //int width = (int)(size.x * 0.96);
            int h = (int)(size.y * 0.96);

            dialog.getWindow().setLayout(width, h);
        }
    }

//    @Override
//    public void onCancel(DialogInterface dialog)
//    {
//        super.onCancel(dialog);
//        Toast.makeText(MainApp.get(), "CANCEL", Toast.LENGTH_SHORT).show();
//    }
}
