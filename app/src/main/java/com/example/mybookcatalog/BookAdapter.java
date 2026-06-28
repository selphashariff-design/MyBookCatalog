package com.example.mybookcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Locale;

public class BookAdapter extends ArrayAdapter<Book> {

    private Context context;
    private int resource;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Book book = getItem(position);

        ImageView cover = convertView.findViewById(R.id.bookCover);
        TextView title = convertView.findViewById(R.id.bookTitle);
        TextView author = convertView.findViewById(R.id.bookAuthor);
        TextView genre = convertView.findViewById(R.id.bookGenre);
        TextView price = convertView.findViewById(R.id.bookPrice);

        if (book != null) {
            cover.setImageResource(book.imageResId);
            title.setText(book.title);
            author.setText(book.author);
            genre.setText(book.genre);
            // Changed to KSH
            price.setText(String.format(Locale.getDefault(), "KSH %,.0f", book.price));
        }

        return convertView;
    }
}
