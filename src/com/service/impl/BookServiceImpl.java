package com.service.impl;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.po.BookBean;
import com.service.BookService;

public class BookServiceImpl implements BookService {



	@Override
	public int add(BookBean p) {
		BookDao dao=new BookDaoImpl();
		return dao.add(p);
	}

}
