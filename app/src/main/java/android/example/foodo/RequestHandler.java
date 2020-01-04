package android.example.foodo;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler extends AsyncTask<String, Void, Boolean> {

    private final String apiURL = "https://ooad-api.herokuapp.com/postOrder?";
    public HttpURLConnection request;


    @Override
    protected Boolean doInBackground(String... urls) {

        System.out.println("[Request] got query + "+urls);

        try {
            URL url = new URL(apiURL+urls[0]);
            System.out.println("[RequestHandler] posting order : "+apiURL+urls[0]);
            request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");
            int status = request.getResponseCode();
            if(status == 200) {
                System.out.println("[Request] Order Posted Successfully");
            } else {
                System.out.println("[Request] Failed Posting order, Status code : "+status);
            }
            return true;
        } catch (Exception e) {
            System.out.println("[RequestHandler] Something went wrong : "+e.getMessage());
            System.out.println(e);
        }
        return false;
    }







}
