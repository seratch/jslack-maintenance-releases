# jSlack Release Notes

## Important Notice

jSlack project is maintenance mode. The successor of this library is https://github.com/slackapi/java-slack-sdk which is one of the official SDKs by Slack.

### WIP: Migration Guide

Most classes and APIs are compatible with jSlack but there are some differences.

* the root package has been removed from `com.seratch.jslack` & `com.seratch.jslack.api` to `com.slack.api`
* some classes have been moved to more suitable package
* the classes that have been deprecated for a while have been removed

More changes may be introduced until java-slack-sdk's initial release. This migration gudie will be updated accordingly.

## version 3.4.1 (2020-02-12)

* fdf29aa Add http proxy support for all the clients by Kazuhiro Sera

## version 3.4.0 (2020-02-09)

* 455adbd Add checkboxes element in Block Kit by Kazuhiro Sera
* 303f25f Fix #1 Add close method for Slack and SlackHttpClient by Kazuhiro Sera
* d834413 Update classes and sample json as the results of tests by Kazuhiro Sera
* a886ea2 Apply test improvements from slackapi/java-slack-sdk by Kazuhiro Sera
* f4108a4 Add admin APIs added on Jan 8 by Kazuhiro Sera
* 0146336 Mark channels / groups / im / mpim as deprecated by Kazuhiro Sera
* bab4169 Mark the fields that are no longer used as deprecated by Kazuhiro Sera
* c256fc5 Fix the various names for chat.scheduledMessages.list by Kazuhiro Sera
* c25b97c Add failOnUnknownProperties flag to make JSON parser's behavior consitent by Kazuhiro Sera
* 2fb8f29 Remove conversation.members as it has not been working by Kazuhiro Sera

## version 3.3.0 (2019-12-18)

* f25ccf7 Add query string support in Lightning web endpoints by Kazuhiro Sera
* 7dc814c Change Lightning implementation to use only auth.test by Kazuhiro Sera
* b540fdf Add bot_id in response for auth.test by Kazuhiro Sera
* a395d7c Add six admin APIs by Kazuhiro Sera
* 9242528 Commonize response_metadata holding message strings for error patterns by Kazuhiro Sera

### Incompatibility

There are two minor breaking changes since version 3.2.x series. Java compiler detects all of them but it would be appreciated if you could understand the decisions.

#### ErrorResponseMetadata

https://github.com/slackapi/java-slack-sdk/commit/92425282a9dc4f2cbb444b43246b4f8b11b2bbed

To commonize `response_metadata` containing `messages` in responses, `com.github.seratch.jslack.api.model.ErrorResponseMetadata` class has been introduced. The following classes have been modified to use the new class instead of their inner classes.

* AdminTeamsCreateResponse
* AdminUsersAssignResponse
* AdminUsersInviteResponse
* AdminUsersRemoveResponse
* AdminUsersSetAdminResponse
* AdminUsersSetOwnerResponse
* AdminUsersSetRegularResponse
* ChatPostMessageResponse
* PinsAddResponse
* ViewsOpenResponse
* ViewsPublishResponse
* ViewsPushResponse
* ViewsUpdateResponse

#### Re-packaging admin APIs

https://github.com/slackapi/java-slack-sdk/commit/a395d7c8408082bc08363de7f4ccf5402b33ea42

* AdminTeamsOwnersListRequest/Response from `admin.teams` to `admin.teams.owners`
* AdminTeamsSettingsSetDescriptionRequest/Response from `admin.teams` to `admin.teams.settings`
* AdminTeamsSettingsSetIconRequest/Response from `admin.teams` to `admin.teams.settings`
* AdminTeamsSettingsSetNameRequest/Response from `admin.teams` to `admin.teams.settings`

## version 3.2.5 (2019-12-11)

* ace41ea slackapi/java-slack-sdk #301 Fix a bug where url_verification doesn't work without bot token by Joel McCance

## version 3.2.4 (2019-12-11)

* 929333a Fix slackapi/java-slack-sdk #298 Add RichTextSectionElement.Color by Kazuhiro Sera
* 0266c43 Add admin.teams.list API by Kazuhiro Sera

## version 3.2.3 (2019-12-08)

* 7e5e725 Fix slackapi/java-slack-sdk #295 Add thread_ts to ChatPostEphemeralRequest by Kazuhiro Sera
* f9c4944 Fix slackapi/java-slack-sdk #293 SlackApiException and other exceptions are not standard by Kazuhiro Sera

## version 3.2.2 (2019-12-04)

* 182c3bc Add oauth.v2.access error handler by Kazuhiro Sera
* ac1a386 Bump jetty-server version to the latest minor by Kazuhiro Sera

## version 3.2.1 (2019-11-30)

* 2b6939c Expose the methods to run api calls etc by Kazuhiro Sera

## version 3.2.0 (2019-11-29)

* 9cd119b Handle message-related events appropriately (breaking change) by Kazuhiro Sera
* 9e89bac Add admin.teams.settings.* endpoints by Kazuhiro Sera
* a8137f8 Run tests with the latest APIs by Kazuhiro Sera

### Incompatibility

* Only newly posted messages are recognized as `MessageEvent`
* Other events having `subtype` (`bot_message`, `message_changed`, `message_deleted`, `thread_broadcast`, `ekm_access_denied`, and `me_message`) are no longer available as `MessageEvent`. They have corresponding classes (e.g., `MessageBotEvent`)

For example, if you have `EventHandler`/`LightningEventHandler` handling `MessageEvent` and expect the code to receive `bot_message` events as `MessageEvent`, the code requires changes to have a `MessageBotEvent` handler for `bot_message` events.

## version 3.1.5 (2019-11-27)

* 4a3fb59 Add more Lombok annotations to make sample JSON generation more stable by Kazuhiro Sera
* a01a1db Add object builders to attachments, views, dialogs, and incoming webhooks by Kazuhiro Sera

## version 3.1.4 (2019-11-26)

* cb1411c Add handy ways to build blocks by Kazuhiro Sera

## version 3.1.3 (2019-11-22)

* 28ea307 Add regexp routing for actions, command, etc by Kazuhiro Sera
* 52cb675 Fix a bug where confirm in block_actions is invalid by Kazuhiro Sera
* 96591f9 Bump the versions of dependencies by Kazuhiro Sera
* 379a61e Lightning Micronaut - let the DI container create the adapter. by Jeff Scott Brown

## version 3.1.2 (2019-11-20)

* c5c3393 Add App#status() and allow skipping calling App#start() method by Kazuhiro Sera
* 588904d Fix View object to be compatible with App Home by Kazuhiro Sera

## version 3.1.1 (2019-11-19)

* 443ab0d Fix a potential parse error with some Events API payloads by Kazuhiro Sera
* ce89db8 Add Spring Boot examples by Kazuhiro Sera
* 436caa3 Micronaut support (#274) by Kazuhiro Sera
* 4a327cd Fix deprecation warnings in tests by Kazuhiro Sera
* 5253798 Fix Quarkus example by Kazuhiro Sera
* ed840bf Add Quarkus Docker image example by Kazuhiro Sera
* 0ad83f1 Add Quarkus app examples by Kazuhiro Sera
* 16e0ef5 Bump the versions of okhttp, gson, lombok, slf4j-api by Kazuhiro Sera

## version 3.1.0 (2019-11-15)

* 40bd9c0 Fix slackapi/java-slack-sdk #267 Wrong "metadata" property type in the jslack.api.model.Attachment by Kazuhiro Sera
* f3f9688 Support rich_text_list, rich_text_quote, rich_text_preformatted slackapi/java-slack-sdk #266 slackapi/java-slack-sdk #268 by Kazuhiro Sera
* c7647a5 Fix slackapi/java-slack-sdk #264 Unknown RichTextSectionElement type: broadcast by Kazuhiro Sera

### Incompatibility

To support more `rich_text` block elements, we had to introduce some breaking changes to the JSON parser by https://github.com/slackapi/java-slack-sdk/pull/269

* Rename `GsonRichTextSectionElementFactory` to `GsonRichTextElementFactory`
* Extract `RichTextSectionElement.Element` as `RichTextElement`

`Attachment#metadata` used to be string type but it was wrong. https://github.com/slackapi/java-slack-sdk/pull/270 changed the field to be correct.

## version 3.0.5 (2019-11-14)

* a52cff8 Update README by Kazuhiro Sera
* b714317 Add admin.inviteRequests.* APIs by Kazuhiro Sera
* 3f150fd Fix slackapi/java-slack-sdk #260 Enable jSlack users to configure API url prefix (#262) by Kazuhiro Sera

## version 3.0.4 (2019-11-12)

* 82d7a1a Add enterprise_id in event request context by Kazuhiro Sera
* 5d06fe6 Ensure team and enterprise ids are set on requests by Joel McCance

## version 3.0.3 (2019-11-09)

* 55cc2c5 Fix postAsBot to actually post as bot, not as user by Antonio Tomac
* f54633c Add new fields in Audit Logs API by Kazuhiro Sera
* d34a372 Fix slackapi/java-slack-sdk #254 Lightning UrlVerification fails signature validation by Joel McCance

## version 3.0.2 (2019-11-06)

* 6262137 Add bot_link to latest field by Kazuhiro Sera
* b510128 Fix slackapi/java-slack-sdk #249 Incorrect BlockActionPayload definition (#253) by Kazuhiro Sera
* b7ca3d8 Add missing types of rich sections (#251) by Kostiantyn Severynov

## version 3.0.1 (2019-10-26)

* 356b5b0 Lightning: Add ssl_check request handler by Kazuhiro Sera

## version 3.0.0 (2019-10-26)

* 69c5589 Add admin.* apis added in Oct 2019 by Kazuhiro Sera
* 090da30 Add App Home support by Kazuhiro Sera
* c98befc Add Granular Bot Permissions support by Kazuhiro Sera
* de175cb Add a GitHub Action to build Docker images by Kazuhiro Sera
* 6b8a9b6 Add Docker examples (Amazon ECS, Google Cloud Run) by Kazuhiro Sera
* 8851614 Add user.is_workflow_bot in response by Kazuhiro Sera
* 9a71bc8 Add historical data support and incoming webhooks in InstallationService slackapi/java-slack-sdk #234 by Kazuhiro Sera
* 382c311 Fix slackapi/java-slack-sdk #235 MultiTeamsAuthorization fails due to missing team_id / enterprise_id in ActionContext by Kazuhiro Sera
* 395a09a Mark workspace app related properties as deprecated by Kazuhiro Sera
* 638d43a Fix slackapi/java-slack-sdk #230 selectedUsers in ViewState is missing by Kazuhiro Sera
* 7c783b3 Add bot_profile etc (added recently) by Kazuhiro Sera
* eaf6ced Fix dnd.teamInfo has been broken by Kazuhiro Sera
* f6b1044 Add Lightning README by Kazuhiro Sera
* 995c587 Add OAuth flow support in Lightning by Kazuhiro Sera
* 162dab1 Fix oauth.access API to use basic auth by Kazuhiro Sera
* 783507b Add Lightning, new module to build Slack apps quickly ⚡ by Kazuhiro Sera
* e5deef6 Apply a bunch of improvements for Slack app dev by Kazuhiro Sera
* 773a699 Add include_num_members to conversations.info params by Kazuhiro Sera

### Topics

#### Lightning to build Slack apps easily!

Check [the readme](https://github.com/slackapi/java-slack-sdk/tree/master/jslack-lightning) and [Kotlin examples](https://github.com/slackapi/java-slack-sdk/tree/master/jslack-lightning-kotlin-examples/src/main/kotlin/examples)!

### Incompatibility

The following classes are no longer internal classes. They are in the same package as independent ones.
 
* DialogSuggestionResponse.Option
* DialogSuggestionResponse.OptionGroup
* BlockSuggestionResponse.Option
* BlockSuggestionResponse.OptionGroup

## version 2.2.3 (2019-10-02)

* c27dbd1 slackapi/java-slack-sdk #224 Add block_suggestion support by Kazuhiro Sera
* 4902d12 Change the type in view payloads to be immutable by Kazuhiro Sera

## version 2.2.2 (2019-10-01)

* f6b2cde slackapi/java-slack-sdk #223 Add view payload JSON samples by Kazuhiro Sera
* 659abe9 slackapi/java-slack-sdk #223 Add multi select blocks & fix input block errors by Kazuhiro Sera

## version 2.2.1 (2019-10-01)

* 08ba6d4 Add view to block_actions payload (ref slackapi/java-slack-sdk #217) by Kazuhiro Sera
* fe4f4d6 Update search results to be compatible with the latest test results by Kazuhiro Sera
* f57235e Add a bunch of pref actions newly added in Audit Logs API by Kazuhiro Sera
* 565f4a6 Fix slackapi/java-slack-sdk #220 rich_text blocks support by Kazuhiro Sera

## version 2.2.0 (2019-09-28)

* ebcd160 slackapi/java-slack-sdk #217 Add Block Kit in Modals support by Kazuhiro Sera
* e867f4e Fix slackapi/java-slack-sdk #218 by adding missing properties in event payloads by Kazuhiro Sera
* a7448d9 Fix slackapi/java-slack-sdk #128 chat.update test issues by Kazuhiro Sera

## version 2.1.4 (2019-09-12)

* 7fce724 Fix slackapi/java-slack-sdk #214 by providing EventTypeExtractor interface by Kazuhiro Sera

## version 2.1.3 (2019-09-05)

* ff74841 subtype property for the app_mention event (#213) by Subrahmanyam
* 98e6dd0 Add shared-channel related attributes to conversation by Kazuhiro Sera

## version 2.1.2 (2019-08-28)

* 1be4469 Add status API client by Kazuhiro Sera
* 9c26259 Add pref.ent_required_browser_name to known audit actions by Kazuhiro Sera

## version 2.1.1 (2019-08-24)

* 7bc8b9d Change the types of user.enterprise_user.is_admin, is_owner (string -> boolean) by Kazuhiro Sera

`user.enterprise_user.is_admin`, `user.enterprise_user.is_owner` are added in 2.1.0. 
We assume no one uses the version as it was released on the same day. 
But, if you had to deal with the incompatibility in your projects, we're sorry for that inconvenience.

## version 2.1.0 (2019-08-24)

* 5034343 Add admin.apps APIs to the library by Kazuhiro Sera
* 3962f7b Fix slackapi/java-slack-sdk #208 conversation.is_moved by Kazuhiro Sera

### Incompatibility

The following two classes have been re-packaged.

* `com.github.seratch.jslack.api.methods.request.admin.AdminUsersSessionResetRequest` -> `com.github.seratch.jslack.api.methods.request.admin.users.AdminUsersSessionResetRequest`
* `com.github.seratch.jslack.api.methods.response.admin.AdminUsersSessionResetResponse` -> `com.github.seratch.jslack.api.methods.response.admin.users.AdminUsersSessionResetResponse`

## version 2.0.0 (2019-08-17)

* 93f8146 Bump okhttp version to 4.1.0 - fixes slackapi/java-slack-sdk #179 by Kazuhiro Sera
* 4b98417 Add a constants for Audit Logs Actions by Kazuhiro Sera
* e1cb75d Improve SCIM, Audit API clients by Kazuhiro Sera
* 5d39d92 Remove starchart due to its unstability by Kazuhiro Sera
* 99b41f1 Rename blocksText to blocksAsString + support similar methods too by Kazuhiro Sera
* a430097 modified the ChatPostMessage to set blocks as string by Subbu

## Memo

```
git log --pretty=format:'%h %s by %an' --abbrev-commit | grep -v "Merge pull request " | head -50
```
