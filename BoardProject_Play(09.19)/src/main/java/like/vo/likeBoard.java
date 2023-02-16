 package like.vo;

public class likeBoard {
	
	private int likeNo; // 좋아요 순번 _ 주요키
	private int likeBoarderNum; // 게시글 번호
	private String likememberId; // 아이디 
	
	public likeBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public likeBoard(int likeNo, int likeBoarderNum, String likememberId) {
		super();
		this.likeNo = likeNo;
		this.likeBoarderNum = likeBoarderNum;
		this.likememberId = likememberId;
	}
	
	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public int getLikeBoarderNum() {
		return likeBoarderNum;
	}

	public void setLikeBoarderNum(int likeBoarderNum) {
		this.likeBoarderNum = likeBoarderNum;
	}


	public String getLikememberId() {
		return likememberId;
	}

	public void setLikememberId(String likememberId) {
		this.likememberId = likememberId;
	}
	
	
	
}
