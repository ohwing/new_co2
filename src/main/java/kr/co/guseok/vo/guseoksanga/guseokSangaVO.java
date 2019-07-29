package kr.co.guseok.vo.guseoksanga;

public class guseokSangaVO {
	private Long seq;
	private String api_tourkey_id = null;
	private String store_id = null;
	private String file_id = null;
	private String store_addr1 = null;
	private String store_addr2 = null;
	private String store_addr3 = null;
	private String event_comment = null;
	private String reg_dt = null;
	private String reg_file_id = null;
	private String mod_dt = null;
	private String mod_file_id = null;

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getApi_tourkey_id() {
		return api_tourkey_id;
	}

	public void setApi_tourkey_id(String api_tourkey_id) {
		this.api_tourkey_id = api_tourkey_id;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getStore_addr1() {
		return store_addr1;
	}

	public void setStore_addr1(String store_addr1) {
		this.store_addr1 = store_addr1;
	}

	public String getStore_addr2() {
		return store_addr2;
	}

	public void setStore_addr2(String store_addr2) {
		this.store_addr2 = store_addr2;
	}

	public String getStore_addr3() {
		return store_addr3;
	}

	public void setStore_addr3(String store_addr3) {
		this.store_addr3 = store_addr3;
	}

	public String getEvent_comment() {
		return event_comment;
	}

	public void setEvent_comment(String event_comment) {
		this.event_comment = event_comment;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getReg_file_id() {
		return reg_file_id;
	}

	public void setReg_file_id(String reg_file_id) {
		this.reg_file_id = reg_file_id;
	}

	public String getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}

	public String getMod_file_id() {
		return mod_file_id;
	}

	public void setMod_file_id(String mod_file_id) {
		this.mod_file_id = mod_file_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

}
