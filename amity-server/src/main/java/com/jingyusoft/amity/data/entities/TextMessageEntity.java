package com.jingyusoft.amity.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "text_message")
public class TextMessageEntity extends MessageEntityBase {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "sender", foreignKey = @ForeignKey(name = "fk_text_message_sender"))
	private AmityUserEntity sender;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "recipient", foreignKey = @ForeignKey(name = "fk_text_message_recipient"))
	private AmityUserEntity recipient;

	@Lob
	@Column(name = "message_text")
	private String text;

	public AmityUserEntity getRecipient() {
		return recipient;
	}

	public AmityUserEntity getSender() {
		return sender;
	}

	public String getText() {
		return text;
	}

	public void setRecipient(AmityUserEntity recipient) {
		this.recipient = recipient;
	}

	public void setSender(AmityUserEntity sender) {
		this.sender = sender;
	}

	public void setText(String text) {
		this.text = text;
	}
}
