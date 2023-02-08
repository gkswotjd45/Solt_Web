package vo;

public class BookVo {
	
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public BookVo() {
		// TODO Auto-generated constructor stub
	}

	public BookVo(String btitle, String bauthor, int bprice) {
		super();
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	
}
