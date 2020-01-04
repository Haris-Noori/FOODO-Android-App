package android.example.foodo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    private Button btnCheck;
    public int item1_quantity = 0;
    public int item2_quantity = 0;
    public int item3_quantity = 0;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main6, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     * Opens the check Out Activity
     */
    public void openCheckoutActivity(View view) {
        //System.out.println("Hey there");
        Intent i = new Intent(this, CheckOutActivity.class);
        startActivity(i);
    }

    /* ITEM 1 FUNTIONALITIES */
    /**
     * Increment the Quantity of Item 1
     */
    public void incQuantity1(View view)
    {
        //System.out.println("Yahan tak aya increment");
        item1_quantity++;
        displayQty1(item1_quantity);
    }

    /**
     * Increment the Quantity of Item 1
     */
    public void decQuantity1(View view)
    {
        System.out.println("Yahan tak aya decrement");
        item1_quantity--;
        if(item1_quantity < 0)
        {
            item1_quantity = 0;
        }
        displayQty1(item1_quantity);
    }

    public void displayQty1(int num)
    {
        System.out.println("Yahaan b aya");
        TextView qty = (TextView) this.findViewById(R.id.qty1);
        qty.setText("" + num);
    }

    public void addItem1ToCart(View view)
    {
        String item1Name = "Zinger Burger";
        TextView cartView = (TextView) findViewById(R.id.cart);
        cartView.setText("Cart: " + item1Name + " " + item1_quantity);
        Cart.addItemToCart("ZingerBurger", item1_quantity);
    }


    /* ITEM 2 FUNTIONALITIES */
    /**
     * Increment the Quantity of Item 2
     */
    public void incQuantity2(View view)
    {
        item2_quantity++;
        displayQty2(item2_quantity);
    }

    /**
     * Deccrement the Quantity of Item 2
     */
    public void decQuantity2(View view)
    {
        //System.out.println("Yahan tak aya decrement");
        item2_quantity--;
        if(item2_quantity < 0)
        {
            item2_quantity = 0;
        }
        displayQty2(item2_quantity);
    }

    /**
     * Display the Quantity of 2
     * @param num
     */
    public void displayQty2(int num)
    {
        //System.out.println("Yahaan b aya");
        TextView qty = (TextView) this.findViewById(R.id.qty2);
        qty.setText("" + num);
    }

    public void addItem2ToCart(View view)
    {
        String item1Name = "Mighty Burger";
        TextView cartView = (TextView) findViewById(R.id.cart);
        cartView.setText("Cart: " + item1Name + " " + item2_quantity);
        Cart.addItemToCart("MightyBurger", item2_quantity);
    }

    /* ITEM 3 FUNTIONALITIES */
    /**
     * Increment the Quantity of Item 1
     */
    public void incQuantity3(View view)
    {
        //System.out.println("Yahan tak aya increment");
        item3_quantity++;
        displayQty3(item3_quantity);
    }

    /**
     * Increment the Quantity of Item 1
     */
    public void decQuantity3(View view)
    {
        //System.out.println("Yahan tak aya decrement");
        item3_quantity--;
        if(item3_quantity < 0)
        {
            item3_quantity = 0;
        }
        displayQty3(item3_quantity);
    }

    public void displayQty3(int num)
    {
        //System.out.println("Yahaan b aya");
        TextView qty = (TextView) this.findViewById(R.id.qty3);
        qty.setText("" + num);
    }

    public void addItem3ToCart(View view)
    {
        String item1Name = "Afghani Burger";
        TextView cartView = (TextView) findViewById(R.id.cart);
        cartView.setText("Cart: " + item1Name + " " + item3_quantity);
        Cart.addItemToCart("AfghaniBurger", item3_quantity);
    }


}
