package cafe.jjdev.ajaxcrud.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;

	// 회원목록 페이징
	public Map<String, Object> getMemberList(int currentPage) {
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage - 1)*ROW_PER_PAGE;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		List<Member> list = memberMapper.selectMemberList(map);
		int memberCount = memberMapper.selectMemberCount();

		int lastPage = memberCount/ROW_PER_PAGE;
		if(memberCount/ROW_PER_PAGE != 0 ) {
			lastPage++;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("memberCount", memberCount);
		returnMap.put("currentPage", currentPage);
		return returnMap;
	}
}
