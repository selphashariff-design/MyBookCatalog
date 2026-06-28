package com.example.mybookcatalog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView bookImage = findViewById(R.id.bookImage);
        TextView title = findViewById(R.id.title);
        TextView author = findViewById(R.id.author);
        TextView genre = findViewById(R.id.genre);
        TextView priceView = findViewById(R.id.price);
        TextView description = findViewById(R.id.description);
        Button payBtn = findViewById(R.id.payBtn);

        String bookTitle = getIntent().getStringExtra("title");
        title.setText(bookTitle);
        author.setText("Author: " + getIntent().getStringExtra("author"));
        genre.setText("Genre: " + getIntent().getStringExtra("genre"));
        
        double bookPrice = getIntent().getDoubleExtra("price", 0.0);
        priceView.setText(String.format(Locale.getDefault(), "Price: KSH %,.0f", bookPrice));
        
        description.setText("Description: " + getIntent().getStringExtra("description"));
        
        int imageResId = getIntent().getIntExtra("imageResId", R.drawable.ic_launcher_foreground);
        bookImage.setImageResource(imageResId);

        // Simulation of M-Pesa Payment API
        payBtn.setOnClickListener(v -> {
            Toast.makeText(
                this,
                "Simulated M-Pesa Payment Successful",
                Toast.LENGTH_LONG
            ).show();
        });
    }
}
