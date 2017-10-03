package indirimtakip.rt.com.indirimtakip.utils.callbacks;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class RequestHandler {
    private String requestResponse;
    private String URL;
    private JSONArray jsonArray;
    private JSONObject jsonObject;

    public RequestHandler(String URL) {
        this.URL = URL;
    }

    public String sendRequest(final VolleyCallback callback) {


        final String TAG = "RequestHandler";
        StringRequest req = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);

                        response = response.replaceAll("^\"|\"$", "");
                        try {

                            requestResponse = response;
                            callback.onSuccess(requestResponse);
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());


            }
        });

        // Adding request to request queue
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);
        VolleyController.getInstance().addToRequestQueue(req);


        return requestResponse;

    }

    public JSONObject makeJsonObjectRequest(final VolleyCallback callback) {
        final String TAG = "JsonObjectReq";
        JsonObjectRequest req = new JsonObjectRequest(URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        try {
                            jsonObject = response;
                            callback.onSuccess(jsonObject.toString());

                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());


            }
        });

        // Adding request to request queue
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);
        VolleyController.getInstance().addToRequestQueue(req);

        return jsonObject;
    }

    public JSONArray makeJsonArrayRequest(final VolleyCallback callback) {

        final String TAG = "JsonArrayReq";
        JsonArrayRequest req = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            jsonArray = new JSONArray();
                            jsonArray = response;
                            callback.onSuccess(jsonArray.toString());

                        } catch (Exception e) {
                            e.printStackTrace();

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                System.out.print(error.getMessage());

            }
        });
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        req.setRetryPolicy(policy);
        VolleyController.getInstance().addToRequestQueue(req);

        return jsonArray;

    }

    public interface VolleyCallback {
        void onSuccess(String requestResponse);
    }


}
