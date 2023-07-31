package co.yedam.warehousing.history.service;

import java.util.List;

public interface HistoryService {
	int historyInsert(HistoryVO vo);
//	int historySellInsert(HistoryVO vo);
//	int historyDissuseInsert(HistoryVO vo);
	List<HistoryVO> historySelectList();
	List<HistoryVO> historySelect(String str);
	int historyDelete(int no);
}
