package board.vo;



// board라는 테이블로 연결되어 있는 형태. 그래서 새로운 필드명을 생서아고자 하면, vo를 별도로 만들어서 생성하는 것이 좋음
public class Board {


	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardAuthor;
	private String boardDate; // sql에서는 datetime으로 잡음.
	private String boardLike;
	private int CommentCount; // 댓글수


	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, String boardTitle, String boardContent, String boardAuthor, String boardDate,
			String boardLike, int CommentCount) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardAuthor = boardAuthor;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
		this.CommentCount = CommentCount;
	}

	public int getCommentCount() {
		return CommentCount;
	}

	public void setCommentCount(int commentCount) {
		CommentCount = commentCount;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(String boardLike) {
		this.boardLike = boardLike;
	}
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardAuthor=" + boardAuthor + ", boardDate=" + boardDate + ", boardLike=" + boardLike
				+ ", CommentCount=" + CommentCount + "]";
	}	
}
