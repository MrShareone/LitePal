package com.example.mr_shareone.helloas311;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mr_shareone.helloas311.DataModel.Book;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    @BindView(R.id.create_database)
    Button createDatabase;
    @BindView(R.id.save_data)
    Button saveData;
    @BindView(R.id.logtext)
    TextView logText;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    @OnClick({ R.id.create_database, R.id.save_data})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_database:
                database = LitePal.getDatabase();
                showTable();
                break;
            case R.id.save_data:
                Book book = new Book("think in java", "null", "￥100");
                book.save();
                showTable();
                break;
            default:
                break;
        }
    }
    void showTable() {
        List<Book> allBooks = DataSupport.findAll(Book.class);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < allBooks.size(); i++) {
            stringBuffer.append("authorname:" + allBooks.get(i).getAuthorName() + "\n");
            stringBuffer.append("bookname:" + allBooks.get(i).getBookName() + "\n");
            stringBuffer.append("price:" + allBooks.get(i).getPrice() + "\n");
        }
        logText.setText(stringBuffer.toString());
    }

}
