package code.apiStuff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

import javax.swing.*;

public class Exchange {
    private static String getExchange(String apiKey) throws IOException{
        URL url = new URL(apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() != 200) {
            throw new IOException("Error: HTTP response code " + connection.getResponseCode());
        }
        StringBuilder responseContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
        }
        return responseContent.toString();
    }
    private static double getRonRateFromJsonString(String jsonString,String key) throws org.json.JSONException {
        JSONObject dataObject = new JSONObject(jsonString).getJSONObject("data");
        Double ronRate = dataObject.getJSONObject(key).getDouble("value");
        return ronRate;
    }
    public static void convertCurrency(String apiKey,String enteredTypeFrom, String enteredTypeTo, String enteredAmount) {
        try {
            String jsonString = Exchange.getExchange(apiKey);
            double dollarRate = Exchange.getRonRateFromJsonString(jsonString, enteredTypeFrom);
            double valInDollars = Double.parseDouble(enteredAmount) / dollarRate;
            double convertedAmount = valInDollars * Exchange.getRonRateFromJsonString(jsonString, enteredTypeTo);
            JOptionPane.showMessageDialog(null, "The amount in " + enteredTypeTo + " is: " + convertedAmount);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while trying to convert the currency");
        }
    }
}
