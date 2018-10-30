package com.zhwykj.greendaodemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhwykj.greendaodemo.R;
import com.zhwykj.greendaodemo.app.MyApplication;
import com.zhwykj.greendaodemo.bean.Book;
import com.zhwykj.greendaodemo.bean.Category;
import com.zhwykj.greendaodemo.greendao.BookDao;
import com.zhwykj.greendaodemo.greendao.CategoryDao;
import com.zhwykj.greendaodemo.greendao.DaoSession;

import java.util.List;

/**
 * 参考：https://github.com/greenrobot/greenDAO
 * https://mp.weixin.qq.com/s/4Nx2DacsK65O5LanPZUszA
 */
public class GreenDaoActivity extends AppCompatActivity {
    private Button btnBuild, btnCreate, btnRetrieve, btnUpdate, btnDelete;

    private BookDao bookDao;
    private CategoryDao categoryDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);

        getDao();
        initView();
        setListener();
    }

    private void getDao() {
        DaoSession daoSession = ((MyApplication) getApplication()).getDaoSession();
        bookDao = daoSession.getBookDao();
        categoryDao = daoSession.getCategoryDao();
    }

    private void initView() {
        btnBuild = (Button) findViewById(R.id.btn_green_dao_build);
        btnCreate = (Button) findViewById(R.id.btn_green_dao_create);
        btnRetrieve = (Button) findViewById(R.id.btn_green_dao_retrieve);
        btnUpdate = (Button) findViewById(R.id.btn_green_dao_update);
        btnDelete = (Button) findViewById(R.id.btn_green_dao_delete);
    }

    private void setListener() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Book book1 = new Book();
                book1.setAuthor("郭霖");
                book1.setPrice(79.00);
                book1.setPages(570);
                book1.setName("第一行代码");

                Book book2 = new Book();
                book2.setAuthor("任玉刚");
                book2.setPrice(79.00);
                book2.setPages(507);
                book2.setName("Android开发艺术探索");

                Category category = new Category();
                category.setCategory_name("Android");
                category.setCategory_code(001);

                bookDao.insert(book1);
                bookDao.insert(book2);
                categoryDao.insert(category);

            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = bookDao.queryBuilder().offset(0).limit(5).list();
                for (int i = 0; i < books.size(); i++) {
                    Log.e("book" + i, books.get(i).getId() + "/"
                            + books.get(i).getAuthor() + "/"
                            + books.get(i).getPrice() + "/"
                            + books.get(i).getPages() + "/"
                            + books.get(i).getName());
                }
                List<Category> categories = categoryDao.queryBuilder().list();
                for (int i = 0; i < categories.size(); i++) {
                    Log.e("category" + i, categories.get(i).getId() + "/"
                            + categories.get(i).getCategory_name() + "/"
                            + categories.get(i).getCategory_code());
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = bookDao.queryBuilder().where(BookDao.Properties.Author.eq("郭霖")).unique();
                book.setName("第二行代码");
                bookDao.update(book);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = bookDao.queryBuilder().where(BookDao.Properties.Author.eq("郭霖")).unique();
                bookDao.delete(book);
            }
        });
    }

}
