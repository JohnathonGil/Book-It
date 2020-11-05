package com.example.cmput301f20t18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

public class MyBooksAddBook extends AppCompatActivity {

    TextView labelAuthor, labelTitle, labelYear, labelISBN, actTitle;
    EditText author, bookTitle, year, isbn;
    Button done, cancel;
    //ImageButton addPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books_add_book);

        actTitle = (TextView) findViewById(R.id.title_new_book);
        labelAuthor = (TextView) findViewById(R.id.author_prompt);
        labelTitle = (TextView) findViewById(R.id.book_title_prompt);
        labelYear = (TextView) findViewById(R.id.year_prompt);
        labelISBN = (TextView) findViewById(R.id.isbn_prompt);

        Toolbar toolbar = findViewById(R.id.add_book_toolbar);

        author = (EditText) findViewById(R.id.author_input);
        bookTitle = (EditText) findViewById(R.id.title_input);
        year = (EditText) findViewById(R.id.year_input);
        isbn = (EditText) findViewById(R.id.isbn_input);

        done = (Button) findViewById(R.id.done_add_book);
        cancel = (Button) findViewById(R.id.return_to_my_books);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addTitle = bookTitle.getText().toString();
                String addAuthor = author.getText().toString();
                int addYear = Integer.parseInt(year.getText().toString());
                long addISBN = Long.parseLong(isbn.getText().toString());

                Book newBook = new Book(addTitle,addISBN,addAuthor,0,0,null,addYear);

            }
        });


    }
}