package cafe.jjdev.ajaxcrud.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.service.MemberService;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@RestController
public class MemberController {
	@Autowired private MemberMapper memberMapper;
	@Autowired private MemberService memberService;
	
	// 멤버 리스트
	@GetMapping("/getMembers")
	public Map<String, Object> getMembers(@RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		System.out.println("/getMembers 요청");
		Map<String, Object> map = memberService.getMemberList(currentPage);
		System.out.println("[MemberController] getMembers map:"+map);
		return map;
	}
	
	// 멤버 추가
	@PostMapping("/addMembers")
	public void addMembser(Member member) {
		System.out.println("/addMembers 요청");
		System.out.println("[MemberController]addMember member : "+ member);
		memberMapper.insertMember(member);
	}
	
	// 멤버 삭제
	@PostMapping("/removeMembers")
	public void removeMember(@RequestParam(value="ck[]") String[] ck) { // List<String> ck
		System.out.println("/removeMembers 요청");
		System.out.println("[MemberController]removeMember ck: "+ ck);
		for(String id : ck) {
			Member member = new Member();
			member.setId(id);
			memberMapper.deleteMember(member);
		}
	}
	
	// 멤버 수정
	@PostMapping("/modifyMembers")
	public void modifyMember(Member member) {
		System.out.println("/modifyMembers 요청");
		System.out.println("[MemberController]modifyMember member : "+ member);
		memberMapper.updateMember(member);
	}
	
}
