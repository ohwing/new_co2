package kr.co.guseok.vo.guseoksanga;

public class guseokSangaUploadVO {
	private int seq = 0;
	private int file_id = 0;
	private String atchmnfl_mask_nm = null;
	private String atchmnfl_nm = null;
	private String reg_dt = null;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getAtchmnfl_mask_nm() {
		return atchmnfl_mask_nm;
	}

	public void setAtchmnfl_mask_nm(String atchmnfl_mask_nm) {
		this.atchmnfl_mask_nm = atchmnfl_mask_nm;
	}

	public String getAtchmnfl_nm() {
		return atchmnfl_nm;
	}

	public void setAtchmnfl_nm(String atchmnfl_nm) {
		this.atchmnfl_nm = atchmnfl_nm;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
}
