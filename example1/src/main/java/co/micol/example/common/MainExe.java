package co.micol.example.common;

import co.micol.example.notice.service.ReplyService;
import co.micol.example.notice.service.ReplyVO;
import co.micol.example.notice.serviceImpl.ReplyServiceImpl;

public class MainExe {
	public static void main(String[] args) {
		ReplyService service = new ReplyServiceImpl();
		
		ReplyVO reply = new ReplyVO();
		reply.setNoticeId(6);
		reply.setReply("매퍼테스트2");
		reply.setReplyer("user1");
		
		
		service.addReply(reply);	
		
		service.replyList(6).forEach((vo) -> {
			System.out.println(vo);
		});
	}
}
