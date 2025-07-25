package core.surveys_alert.service.nofifier;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import core.surveys_alert.domain.Alert;
import core.surveys_alert.domain.Email;
import core.surveys_alert.service.MailService;

@Component
@RequiredArgsConstructor
public class AlertNotifier {

    @Value("${recipient.email}")
    private String emailRecipient;

    private final MailService mailService;

    public void notifyAlert(Alert alert) {
        String subject = "Alerta de Pesquisa: " + alert.getDescription();
        String body = String.format("Ponto de venda: %s%nProduto: %s", alert.getPointOfSale(), alert.getProduct());

        Email email = new Email();
        email.addRecipient(emailRecipient);
        email.setSubject(subject);
        email.setBody(body);

        mailService.send(email);
    }

}
