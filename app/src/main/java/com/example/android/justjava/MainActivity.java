/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static com.example.android.justjava.R.id.enterText;
import static com.example.android.justjava.R.id.order_summary_text_view;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;

        display(quantity);

    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Quantiy should not be less than 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int pureCoffeePrice = 10;
        int chocolatePrice = 1;
        int whippedCreamPrice = 2;
        int eachCupPrice;

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);

        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity99", "Has whipped cream:" + hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);

        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity99", "Has whipped cream:" + hasChocolate);

        eachCupPrice = pureCoffeePrice;

        if (hasChocolate)
            eachCupPrice += chocolatePrice;

        if (hasWhippedCream)
            eachCupPrice += whippedCreamPrice;

        Log.v("MainActivity99", "value of eachCupPrice:" + eachCupPrice);

        String priceMessage = "$" + (quantity * eachCupPrice);

        priceMessage += "\nHas whipped cream added? " + hasWhippedCream;
        priceMessage += "\nHas chocolate added? " + hasChocolate;

        EditText customerName = (EditText) findViewById(R.id.enterText);
//        priceMessage += "\nCustomer name is: " + customerName.getText();

//        displayMessage(priceMessage);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order from" + customerName.getText());
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }


    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    /*private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }    */
    public void onCheckboxClicked(View view) {
//        dfdsfdf;
//        sdf;
//        123423;

    }

}