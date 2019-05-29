package cafe.jjdev.ajaxcrud.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	// 회원목록 페이징
	public int selectMemberCount();
	
	// 회원목록
	public List<Member> selectMemberList(Map<String, Integer> map);
	
	// 아이디 중복체크
	public int checkDupId(String memberid);
	
	// 회원추가
	public int insertMember(Member member);
	
	// 회원정보 수정
	public int updateMember(Member member);
	
	// 회원 삭제
	public int deleteMember(Member member);
}
