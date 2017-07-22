package com.novatus.examples.slack;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.novatus.examples.slack.bean.Contract;
import com.novatus.examples.slack.bean.SlackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Example slack rest webhook for Novatus contract messages.
 */
@Service("WebhookService")
public class WebhookService {

    Logger LOG = LoggerFactory.getLogger(WebhookService.class);

    final String slackWebhook = System.getenv("SLACK_WEBHOOK");

    @POST
    @Path("/webhook/slack")
    public Response postToSlack(Contract contract) throws UnirestException {
        SlackMessage message = new SlackMessage("Contract " + contract.getNumber()
                + " with company " + contract.getCompany().getName()
                + " moved to status " + contract.getStatus() + ".");
        HttpResponse<String> result = Unirest.post(slackWebhook).body(message).asString();
        LOG.info("Response from slack: " + result.getBody());
        return Response.ok().build();
    }

}
