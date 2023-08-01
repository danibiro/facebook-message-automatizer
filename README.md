# Facebook Message Automatizer

## Description

This is a project that automatizes the process of sending a message to a specific person on Facebook.

## How to use

1. You need to create two files in the `src/test/resources` folder:
   1. `user_config.yaml` - this file contains your Facebook credentials - email and password.
   2. `message_config.yaml` - this file contains the contents of your message - username and message.
      - `username` can be obtained from the desired person's Facebook profile URL, for example from `facebook.com/rick.astley` you'll use `rick.astley` as username.

2. Run the project by executing the `gradle test --rerun-tasks` command. You need to have Chrome and its driver installed on your machine.

## Automatization 

This project can be automatized by using a cron job. I included two scripts, for Windows and Linux respectively, that can be used by the cron job.
This project can not be used to grief people, it's just a fun tool to automate messages. I am in no way responsible for any griefing, spamming or any other malicious activity that you might do with this tool.