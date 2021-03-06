package com.zhwykj.greendaodemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.zhwykj.greendaodemo.bean.Book;
import com.zhwykj.greendaodemo.bean.Category;

import com.zhwykj.greendaodemo.greendao.BookDao;
import com.zhwykj.greendaodemo.greendao.CategoryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookDaoConfig;
    private final DaoConfig categoryDaoConfig;

    private final BookDao bookDao;
    private final CategoryDao categoryDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookDaoConfig = daoConfigMap.get(BookDao.class).clone();
        bookDaoConfig.initIdentityScope(type);

        categoryDaoConfig = daoConfigMap.get(CategoryDao.class).clone();
        categoryDaoConfig.initIdentityScope(type);

        bookDao = new BookDao(bookDaoConfig, this);
        categoryDao = new CategoryDao(categoryDaoConfig, this);

        registerDao(Book.class, bookDao);
        registerDao(Category.class, categoryDao);
    }
    
    public void clear() {
        bookDaoConfig.clearIdentityScope();
        categoryDaoConfig.clearIdentityScope();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

}
