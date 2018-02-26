package food.restaurant.com.tastyfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import food.restaurant.com.tastyfoods.R;

public class ForgotOTP extends AppCompatActivity {

    private Button doneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_otp);
        done();
    }


    public void done()
    {
        doneBtn=(Button) findViewById(R.id.done);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgotOTP.this,"password reset successfully",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(ForgotOTP.this,SignIn.class);
                startActivity(intent);
            }
        });
    }
}
