package test_with_remote_apis.methods;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.response.apps.AppsUninstallResponse;
import config.Constants;
import config.SlackTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

// TODO: valid test
@Slf4j
public class apps_Test {

    static SlackTestConfig testConfig = SlackTestConfig.getInstance();
    static Slack slack = Slack.getInstance(testConfig.getConfig());

    @AfterClass
    public static void tearDown() throws InterruptedException {
        SlackTestConfig.awaitCompletion(testConfig);
    }

    @Test
    public void appsUninstall_user() throws IOException, SlackApiException {
        String userToken = System.getenv(Constants.SLACK_SDK_TEST_USER_TOKEN);
        AppsUninstallResponse response = slack.methods().appsUninstall(req -> req
                .token(userToken));
        assertThat(response.getError(), is("not_allowed_token_type"));
        assertThat(response.isOk(), is(false));
    }

    @Ignore
    @Test
    public void appsUninstall_bot() throws IOException, SlackApiException {
        String botToken = System.getenv(Constants.SLACK_SDK_TEST_BOT_TOKEN);
        AppsUninstallResponse response = slack.methods().appsUninstall(req -> req.token(botToken));
        // somehow "internal_error"
        assertThat(response.getError(), is(nullValue()));
    }

}
