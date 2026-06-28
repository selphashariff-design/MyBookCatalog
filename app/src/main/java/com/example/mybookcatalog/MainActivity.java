package com.example.mybookcatalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.bookGrid);

        books = new ArrayList<>();

        books.add(new Book(
                "The Last Ember",
                "Daniel Roth",
                "Historical Thriller",
                "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.",
                2500.0,
                R.drawable.chatgpt_image_jun_28_2026_07_59_01_am
        ));

        books.add(new Book(
                "Quantum Mirage",
                "Lila Chen",
                "Science Fiction",
                "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.",
                1800.0,
                R.drawable.chatgpt_image_jun_28_2026_07_59_20_am
        ));

        books.add(new Book(
                "Roots & Wings",
                "Maria Esteban",
                "Literary Fiction",
                "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.",
                2200.0,
                R.drawable.chatgpt_image_jun_28_2026_08_07_03_am_1
        ));

        books.add(new Book(
                "The Mind Sculptor",
                "Dr. Evan Shaw",
                "Psychology / Non-Fiction",
                "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.",
                2800.0,
                R.drawable.chatgpt_image_jun_28_2026_08_07_22_am
        ));

        books.add(new Book(
                "Inkbound: Chronicles of the Lost Library",
                "J.R. Faulkner",
                "Fantasy / Adventure",
                "A young librarian discovers that ancient books can open portals to other worlds—but not all stories have happy endings.",
                1500.0,
                R.drawable.chatgpt_image_jun_28_2026_08_10_38_am
        ));

        books.add(new Book(
                "Startup Savage",
                "Nicole Vega",
                "Business / Entrepreneurship",
                "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.",
                2600.0,
                R.drawable.chatgpt_image_jun_28_2026_08_11_27_am
        ));

        books.add(new Book(
                "Beneath Crimson Skies",
                "Tomasz Novak",
                "Historical Fiction / WWII",
                "The intertwined lives of resistance fighters, spies, and survivors during the Nazi occupation of Warsaw.",
                2100.0,
                R.drawable.chatgpt_image_jun_28_2026_08_11_40_am
        ));

        books.add(new Book(
                "The Art of Stillness",
                "Tara Bell",
                "Self-Help / Mindfulness",
                "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.",
                1200.0,
                R.drawable.chatgpt_image_jun_28_2026_08_11_54_am
        ));

        books.add(new Book(
                "Neon Ghosts",
                "Khalid Jones",
                "Urban Fantasy / Mystery",
                "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.",
                1900.0,
                R.drawable.chatgpt_image_jun_28_2026_08_12_25_am
        ));

        books.add(new Book(
                "Eat Green, Live Clean",
                "Dr. Sanjay Patel",
                "Health & Wellness",
                "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.",
                3000.0,
                R.drawable.eat_green_live_clean_cover
        ));

        BookAdapter adapter = new BookAdapter(this, R.layout.item_book, books);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            Book selectedBook = books.get(position);
            intent.putExtra("title", selectedBook.title);
            intent.putExtra("author", selectedBook.author);
            intent.putExtra("genre", selectedBook.genre);
            intent.putExtra("description", selectedBook.description);
            intent.putExtra("price", selectedBook.price);
            intent.putExtra("imageResId", selectedBook.imageResId);
            startActivity(intent);
        });
    }
}
