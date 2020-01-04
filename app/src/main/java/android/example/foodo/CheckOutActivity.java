package android.example.foodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CheckOutActivity extends AppCompatActivity {

    private final RequestHandler handler = new RequestHandler();
    private String itemsToShow = "";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        this.setCheckoutItems();
    }



    public void setCheckoutItems() {
        List<String> items = Cart.getCart();
        String temp = "";
        System.out.println("[COA] recieved items list with length : "+items.size());
        for (String item:items) {
            System.out.println("[COA] item = "+item);
            temp += item+"\n";
        }
        System.out.println("Setting items to : "+temp);

        TextView itemView = (TextView) findViewById(R.id.cartItems);
        itemView.setText(temp);
        itemsToShow = temp;
    }


    public void getData(View view) {
        TextView tv1 = (TextView) findViewById(R.id.editText2);
        String name = tv1.getText().toString();

        TextView tv2 = (TextView) findViewById(R.id.editText3);
        String phone = tv2.getText().toString();

        TextView tv3 = (TextView) findViewById(R.id.editText4);
        String address = tv3.getText().toString();

        System.out.println("[COA::getData] Got data : "+name+" - "+phone+" - "+address);
        String orderNumber = randomAlphaNumeric(3);
        String qry = "orderNumber="+orderNumber+"&customerName="+name+"&address="+address+"&item="+itemsToShow;

        handler.execute(qry);
        Cart.emptyCart();
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
