package food.restaurant.com.tastyfoods.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;
import food.restaurant.com.tastyfoods.R;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Design-4 on 2/22/2018.
 */

public class ChoosePhoto extends BottomSheetDialogFragment {
    //private Unbinder unbinder;
    ImageButton imageButton3;
    ImageButton imageButton4;
    final int SELECT_IMAGE = 1234;
    private static final int CAMERA_REQUEST = 1;
    CircleImageView profile_image;

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.modal_choose_photo, null);
        //unbinder = ButterKnife.bind(this, contentView);
        //dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setContentView(contentView);
//        FrameLayout bottomSheet = (FrameLayout) dialog.getWindow().findViewById(android.support.design.R.id.design_bottom_sheet);
//        bottomSheet.setBackgroundResource(R.drawable.bottomsheet_address);
        profile_image=(CircleImageView) getActivity().findViewById(R.id.profile_image);
        imageButton3=(ImageButton) contentView.findViewById(R.id.imageButton3);
        imageButton4=(ImageButton) contentView.findViewById(R.id.imageButton4);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//

                startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture(v);
            }
        });

        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            imageButton3.setEnabled(false);
            imageButton4.setEnabled(false);
            ActivityCompat.requestPermissions(getActivity(), new String[] { android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        //Dialog dialog = getDialog();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                imageButton3.setEnabled(true);
                imageButton4.setEnabled(true);
            }
        }
    }
    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        Uri file = Uri.fromFile(getOutputMediaFile());
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, CAMERA_REQUEST);


    }
    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE)
        {
            if (resultCode == RESULT_OK)
            {
                if (data != null)
                {
                    try
                    {

                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                        profile_image.setImageBitmap(bitmap);
                        dismiss();

                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        }else if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK && data != null) {

            Bundle extras =  data.getExtras();
            Bitmap bitMap = (Bitmap) extras.get("data");
            profile_image.setImageBitmap(bitMap);
            dismiss();
        }
        else if (resultCode == Activity.RESULT_CANCELED)
        {
            Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

}
