package org.zerock.mapper;

import java.util.List;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno >0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);

	public int update(BoardVO board);

	public int delete(Long bno);

	//페이징 처리
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//전체 자료 데이터 개수 처리
	public int getTotalCount(Criteria cri);
}