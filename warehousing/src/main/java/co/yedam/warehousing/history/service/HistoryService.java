package co.yedam.warehousing.history.service;

import java.util.List;

public interface HistoryService {
	int historyBuyInsert(HistoryVO vo);
//	int historySellInsert(HistoryVO vo);
//	int historyDissuseInsert(HistoryVO vo);
	List<HistoryVO> historySelectList();
	HistoryVO historySelect(HistoryVO vo);
	int historyDelete(HistoryVO vo);
}
