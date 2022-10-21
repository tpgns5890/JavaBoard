package Board;

public class Message {
	private String msgTitle;
	private String msgContent;
	private String getMsg;
	private String sendMsg;
	private String creationDate;

	public Message() {
		super();
	}

	public Message(String msgTitle, String msgContent, String getMsg, String sendMsg, String creationDate) {
		super();
		this.msgTitle = msgTitle;
		this.msgContent = msgContent;
		this.getMsg = getMsg;
		this.sendMsg = sendMsg;
		this.creationDate = creationDate;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getGetMsg() {
		return getMsg;
	}

	public void setGetMsg(String getMsg) {
		this.getMsg = getMsg;
	}

	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return String.format("|제목: %-10s", msgTitle) + String.format("|내용: %-20s", msgContent) + "|보낸사람: " + sendMsg + "|" + creationDate;
	}
	public String toStringM() {
		return String.format("|제목: %-10s", msgTitle)+ String.format("|내용: %-20s", msgContent) + "|보낸사람: " + sendMsg + "|" + creationDate;
	}
}
