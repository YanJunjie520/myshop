package com.shop.myshop.utils;

import com.shop.myshop.entity.User;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 1、首先需要获取发送邮件的Session对象
 * Session session = Session.getDefaultInstance(Properties prop)
 * 2、使用session对象  获取待发送的邮件信息
 * MimeMessage mime = new MimeMessage(session)
 * 3、设置发件人 收件人 标题 邮件内容 附件 发送时间等等
 * 4、利用Transport 发送邮件
 */
public class EmailUtils {
    public static void sendEmail(User user) {
        //发送方
        String myAccount = "2357164215@qq.com";
        //授权码
        String myPass = "mirgthhpttmbebhi";
        //发件人  邮箱的SMTP服务器地址
        String SMTPHost = "smtp.qq.com";
        //组成 properties
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");    //设置协议类型
        prop.setProperty("mail.smtp.host", SMTPHost);    //定义发件人的邮箱服务器地址
        prop.setProperty("mail.smtp.auth", "true");      //设置请求验证
        prop.setProperty("mail.smtp.port","465");      //设置使用的端口
        prop.setProperty("mail.smtp.ssl.enable","true");    //允许ssl
        //1、Session对象  创建会话  用于和邮箱服务器进行交互
        Session session = Session.getDefaultInstance(prop);
        //设置debug模式  可以查看详细发送信息 可略
        session.setDebug(true);

        //创建方法 用来组成一封完整的邮件
        //参数  session（参数配置）， myAccount 发送方， user.getEmail() 接收方
        MimeMessage message = createMsg(session, myAccount, user);
        //利用Transport 发送邮件
        try {
            Transport tran = session.getTransport();
            //连接服务器  确认发送方  是否授权
            tran.connect(myAccount, myPass);
            //发送邮件   将message对象传给Transport对象  将邮件发送出去
            //参数1 要发的内容    参数2 要给哪些人发
            //message。getAllRecipients()  获取到所有的收件人|抄送|密送
            tran.sendMessage(message, message.getAllRecipients());
            //关闭连接
            tran.close();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static MimeMessage createMsg(Session session, String myAccount, User user) {
        //使用session对象 获取待发送的邮件信息
        MimeMessage message = new MimeMessage(session);
        //3、设置发件人  收件人  标题  邮件内容  附件  发送时间等等
        try {
            //3.1  发件人from
            message.setFrom(new InternetAddress(myAccount, "品优购", "utf-8"));
            //3.2  收件人 to 支持可以添加多个收件人|抄送|密送  如果想要发送给多个人 可以重复下面代码多次
            /**
             * MimeMessage.RecipientType.TO 发送
             * MimeMessage.RecipientType.CC 抄送
             * MimeMessage.RecipientType.BCC 密送
             */
            message.setRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(user.getUemail(), user.getUname(), "utf-8"));
            //3.3  生成邮件主题
            message.setSubject("品优购账号激活邮件", "utf-8");
//            String ip = Inet4Address.getLocalHost().getHostAddress();
//            String url = "http://" + ip + ":8080/myshop/user?method=activate&c=" + user.getUcode();
            String url = "http://120.25.176.243:8080/myshop/user?method=activate&c=" + user.getUcode();
            //设置邮件正文 setContent 可以使用html标签
            message.setContent(user.getUname() + "你好<br>欢迎注册品优购商城！请点击链接进行激活：<a href='" + url + "'>"
                    + url + "</a>", "text/html; charset=utf-8");
            //设置邮件的发送时间 是立即发送
            message.setSentDate(new Date());
            //保存设置
            message.saveChanges();
        } catch (UnsupportedEncodingException | MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return message;
    }

    public static void sendPayEmail(User user) {
        //发送方
        String myAccount = "2357164215@qq.com";
        //授权码
        String myPass = "mirgthhpttmbebhi";
        //发件人  邮箱的SMTP服务器地址
        String SMTPHost = "smtp.qq.com";
        //组成 properties
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");    //设置协议类型
        prop.setProperty("mail.smtp.host", SMTPHost);    //定义发件人的邮箱服务器地址
        prop.setProperty("mail.smtp.auth", "true");      //设置请求验证
        prop.setProperty("mail.smtp.port","465");      //设置使用的端口
        prop.setProperty("mail.smtp.ssl.enable","true");    //允许ssl
        //1、Session对象  创建会话  用于和邮箱服务器进行交互
        Session session = Session.getDefaultInstance(prop);
        //设置debug模式  可以查看详细发送信息 可略
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccount, "品优购", "utf-8"));
            message.setRecipient(MimeMessage.RecipientType.TO,
                    new InternetAddress(user.getUemail(), user.getUname(), "utf-8"));
            message.setSubject("品优购付款成功——邮件通知", "utf-8");
            //设置邮件正文 setContent 可以使用html标签
            message.setContent(user.getUname() + "您好<br>您的订单已经支付成功，祝您生活愉快！", "text/html; charset=utf-8");
            //设置邮件的发送时间 是立即发送
            message.setSentDate(new Date());
            //保存设置
            message.saveChanges();
        } catch (UnsupportedEncodingException | MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //利用Transport 发送邮件
        try {
            Transport tran = session.getTransport();
            //连接服务器  确认发送方  是否授权
            tran.connect(myAccount, myPass);
            //发送邮件   将message对象传给Transport对象  将邮件发送出去
            //参数1 要发的内容    参数2 要给哪些人发
            //message。getAllRecipients()  获取到所有的收件人|抄送|密送
            tran.sendMessage(message, message.getAllRecipients());
            //关闭连接
            tran.close();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
