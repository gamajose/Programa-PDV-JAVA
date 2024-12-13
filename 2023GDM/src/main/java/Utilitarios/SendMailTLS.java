//Outgoing Mail (SMTP) Server
//requires TLS or SSL: smtp.gmail.com (use authentication)
//Use Authentication: Yes
//Port for TLS/STARTTLS: 587
//Port for SSL: 465
package Utilitarios;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendMailTLS {

    public void enviaEmail(String para, String assunto, String senha, String msn) {

        final String username = "gmail@gmail.com"; //seu gmail
        final String password = senha; //sua senha

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(para));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(para));
            message.setSubject(assunto);
            message.setText(msn);

            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Mensagem enviada");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
