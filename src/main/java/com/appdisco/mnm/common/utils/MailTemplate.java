package com.appdisco.mnm.common.utils;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTemplate {

	// -------------------------------------------------------------------------
	// Setter methods for dependency injection
	// -------------------------------------------------------------------------
	private String subject = "";
	private String content = "";

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	// -------------------------------------------------------------------------
	// make Personal MimeMessage
	// -------------------------------------------------------------------------

	public MimeMessage makePersonalMessage(MimeMessage message, String email, String uname, String[][] tag) {
		try {
			String psSubject = subject.toString();
			String psContent = content.toString();
			if (tag != null) {
				String name, value;
				for (int n = 0; n < tag.length; n++) {
					name = tag[n][0];
					value = tag[n][1];
					if (name == null)
						continue;
					if (value == null)
						value = "";
					psSubject = psSubject.replaceAll(name, value);
					psContent = psContent.replaceAll(name, value);
				}
			}

			// 2011.10.27 YNSTAR 쿠폰추천,평가 이미지 깨지는 현상 수정위해 추가
			if (psContent.indexOf("..com") >= 0 || psContent.indexOf("..com") >= 0 || psContent.indexOf("..com") >= 0
					|| psContent.indexOf("..com") >= 0) {
				System.out.println("[YNSTAR_EMAIL_TEMPLATE_REPLACE]email=" + email + ", uname=" + uname + ", com_idx=" + psContent.indexOf("..com")
						+ ", png_idx=" + psContent.indexOf("..png") + ", jpg_idx=" + psContent.indexOf("..jpg") + ", gif_idx="
						+ psContent.indexOf("..gif"));
			}

			psContent = psContent.replaceAll("\\.\\.com", "\\.com");
			psContent = psContent.replaceAll("\\.\\.png", "\\.png");
			psContent = psContent.replaceAll("\\.\\.jpg", "\\.jpg");
			psContent = psContent.replaceAll("\\.\\.gif", "\\.gif");

			message.setSubject(psSubject);
			message.setText(psContent, "utf-8", "html");
			message.setFrom(new InternetAddress("admin@goldincity.com", "GOLDinCITY", "utf-8"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, uname, "utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

}
