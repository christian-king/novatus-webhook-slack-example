# Novatus Webhook to Slack Example

This is a simple example of how to use a Novatus webhook to proxy a message to a Slack inbound webhook.

## Setup

This example is most easily deployed to the Heroku platform for testing purposes and is the method that will be described here.

  1. Download and install the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli) and use `heroku login` to login to the CLI.
  2. From where you have checked this project out run the command `heroku create [name]` where name must be a unique identifier for the project.  If you omit this parameter a random name (and URL) will be generated for you.
  3. The `heroku create` command will add a new remote to your repository so all you need to do is run `git push heroku master` to deploy the example.
  4. Run `heroku config:set SLACK_WEBHOOK=[slack webhook URL]` where the url is provided when you create a new inbound webhook in the slack UI.
  5. Finally, add a webhook to Novatus with the hook type of 'After Contract Save', the URL should be `https://[name].herokuapp.com/rest/webhook/slack` Media Type set to application/json and the secret is not used for this example.
  
That's it!  Wherever you have the webhook configured to post to it will give you updates on the status of contracts when they are saved.