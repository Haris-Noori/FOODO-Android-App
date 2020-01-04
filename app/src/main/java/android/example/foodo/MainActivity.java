package android.example.foodo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1500);  //Delay of 3 seconds

                    openActivity2();
//                    MainActivity.this.finish();
                }

                catch (Exception e) { }

                finally {

//                    openActivity2();
                    /*Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();*/
                }
            }
        };
        welcomeThread.start();

    }

    /**
     * This Function Opens Activity 2
     */
    public void openActivity2()    // this function opens activity 2
    {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

}
