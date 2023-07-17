package org.example;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;


public class SlackNotifier {
    private String webHooksUrl = "https://hooks.slack.com/services/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";
    private String oAuthToken = "xoxb-4879309807072-4855661038194-dYHdvYrZYESqSyz2feIxsoAk";
    private String slackChannel = "OOP";
    public void sendMassage(String massage){
        try{
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append(massage);

            Payload payload = Payload.builder().channel(slackChannel).text(msgBuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(webHooksUrl, payload);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
