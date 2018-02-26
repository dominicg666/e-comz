package food.restaurant.com.tastyfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import food.restaurant.com.tastyfoods.Font.Calligrapher;


public class SignUp extends AppCompatActivity {
    private TextView tvGuideDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);
        alreadyRegistered();
        termsConditions();
        signUp();

    }
 public void alreadyRegistered()
    {
        TextView tvGuideDesc = (TextView) this.findViewById(R.id.already);
        tvGuideDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,SignIn.class);
                startActivity(intent);
            }
        });
    }
    public void termsConditions()
    {
        TextView tvGuideDesc = (TextView) this.findViewById(R.id.termsConditions);
        tvGuideDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(SignUp.this,TermsConditions.class);
//                startActivity(intent);
            }
        });
    }
    public void signUp(){
       Button SignUp = (Button) findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
