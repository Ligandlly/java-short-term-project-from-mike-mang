package gui;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMail {
    public static void main(String[] args) throws GeneralSecurityException {
        // 收件人电子邮箱
        String to = "lly200038@163.com";

        // 发件人电子邮箱
        String from = "976720383@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com"; // QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("976720383@qq.com", "oivybyhivtwsbejj"); // 发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("VCampus 验证码");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    static public void sendMail(String to, String content) {
        // 发件人电子邮箱
        String from = "976720383@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com"; // QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("976720383@qq.com", "oivybyhivtwsbejj"); // 发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("VCampus 验证码");

            // 设置消息体
            message.setText(content);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}