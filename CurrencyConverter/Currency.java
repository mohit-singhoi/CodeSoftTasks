// package CurrencyConverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Currency {

    // Replace with your ExchangeRate-API key
    private static final String API_KEY = "f5bb5a599c99688ec92ce281";  
    private static final String BASE_ENDPOINT = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Common currency codes
    private static final String[] CURRENCY_CODES = {
        "USD - United States Dollar",
        "INR - Indian Rupee",
        "EUR - Euro",
        "GBP - British Pound",
        "JPY - Japanese Yen",
        "AUD - Australian Dollar",
        "CAD - Canadian Dollar",
        "CHF - Swiss Franc",
        "CNY - Chinese Yuan",
        "NZD - New Zealand Dollar",
        "SGD - Singapore Dollar",
        "HKD - Hong Kong Dollar",
        "ZAR - South African Rand",
        "AED - UAE Dirham",
        "SAR - Saudi Riyal"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Show available currency codes
            System.out.println("Available Currencies:");
            for (String code : CURRENCY_CODES) {
                System.out.println("   " + code);
            }
            System.out.println("-----------------------------------");

            // Step 1: Input base and target currency
            System.out.print("Enter base currency (e.g., USD, EUR): ");
            String base = sc.next().toUpperCase();

            System.out.print("Enter target currency (e.g., INR, GBP): ");
            String target = sc.next().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            // Step 2: Fetch exchange rate
            double rate = fetchExchangeRate(base, target);

            if (rate < 0) {
                System.out.println("Unable to fetch exchange rate. Check currency codes or API key.");
            } else {
                // Step 3: Conversion
                double converted = amount * rate;
                System.out.printf("%.2f %s = %.2f %s%n", amount, base, converted, target);
            }

        } catch (Exception e) {
            System.out.println("⚠ Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to fetch exchange rate (no Gson needed)
    private static double fetchExchangeRate(String base, String target) throws Exception {
        String urlStr = BASE_ENDPOINT + base;
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            return -1;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Simple JSON parsing without Gson
        String json = response.toString();

        // Find "conversion_rates"
        int ratesIndex = json.indexOf("\"conversion_rates\"");
        if (ratesIndex == -1) return -1;

        // Find target currency inside JSON
        int targetIndex = json.indexOf("\"" + target + "\":", ratesIndex);
        if (targetIndex == -1) return -1;

        // Extract number after target
        int start = json.indexOf(":", targetIndex) + 1;
        int end = json.indexOf(",", start);
        if (end == -1) {
            end = json.indexOf("}", start);
        }

        String valueStr = json.substring(start, end).trim();
        return Double.parseDouble(valueStr);
    }
}
