package kr.co.guseok.vo.guseoksanga;

public class guseokTourRankVO {
	private int seq = 0;
	private String store_id;
	private double rank = 0;
	private String rank_comment;
	private String reg_user_id;
	private String reg_dt;
	
	//해당 상가 관광지 
	private String tour_addr3;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getRank_comment() {
		return rank_comment;
	}

	public void setRank_comment(String rank_comment) {
		this.rank_comment = rank_comment;
	}

	public String getReg_user_id() {
		return reg_user_id;
	}

	public void setReg_user_id(String reg_user_id) {
		this.reg_user_id = reg_user_id;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getTour_addr3() {
		return tour_addr3;
	}

	public void setTour_addr3(String tour_addr3) {
		this.tour_addr3 = tour_addr3;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}
}
