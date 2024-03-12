package co.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BookServiceImpl implements BookService {
	SqlSession session = DataSource.getInstance().openSession();
	BookMapper mapper = session.getMapper(BookMapper.class);

@Override
public List<BookVO> bookList() {
	  return mapper.bookList();
   }
   
}
