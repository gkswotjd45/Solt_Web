package comment.vo;

public class Comment {
	private int boardNum; // 게시판 번호
	private int commentNum; // 댓글 번호
	private String commentId; // 댓글 아이디
	private String commentContent; // 댓글 내용
	private String commentDate; // 댓글 시각
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int boardNum, int commentNum, String commentId, String commentContent, String commentDate) {
		super();
		this.boardNum = boardNum;
		this.commentNum = commentNum;
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}


}
