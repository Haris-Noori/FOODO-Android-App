package android.example.foodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }

        });

        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
    }

    /**
     * FUNCTION TO Open Sign Up Activity
     */
    public void openActivity3()
    {
        Intent intent =  new Intent(this,Main3Activity.class);
        startActivity(intent);

    }

    /**
     * FUNCTION TO Open Login Activity
     */
    public void openActivity4()
    {
        System.out.println("LOGIN");
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
