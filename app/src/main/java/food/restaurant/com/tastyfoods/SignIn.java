package food.restaurant.com.tastyfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import food.restaurant.com.tastyfoods.Font.Calligrapher;


public class SignIn extends AppCompatActivity {

private TextView forgot;
    private TextView newuser;
    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);
        forgotPassword();
        newUser();
     }

    public void forgotPassword()
    {
        forgot=(TextView)findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    public void newUser()
    {
        TextView newuser = (TextView) this.findViewById(R.id.newuserText);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignIn.this,SignUp.class);
                startActivity(intent);
            }
        });
    }

    public void signin(View view)
    {
        /*signInBtn=(Button)findViewById(R.id.signIn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {*/
                Intent intent=new Intent(SignIn.this,MainActivity.class);
                startActivity(intent);

       /*     }
        });*/

    }


}
