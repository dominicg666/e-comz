package food.restaurant.com.tastyfoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import food.restaurant.com.tastyfoods.Font.Calligrapher;


public class StartPage extends AppCompatActivity {
    private Button signupBtn,signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);
        signUp();
        signIn();

    }
    public void signUp()
    {
        signupBtn=(Button)findViewById(R.id.buttonSignUp);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(StartPage.this,SignUp.class);
                startActivity(intent);
            }
        });
    }
    public void signIn()
    {
        signInBtn=(Button)findViewById(R.id.buttonSignIn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartPage.this,SignIn.class);
                startActivity(intent);
            }
        });
    }
}
