package test_with_remote_apis.methods;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.response.team.TeamAccessLogsResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamBillableInfoResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamInfoResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamIntegrationLogsResponse;
import com.github.seratch.jslack.api.methods.response.team.profile.TeamProfileGetResponse;
import com.github.seratch.jslack.api.model.User;
import config.Constants;
import config.SlackTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class team_Test {

    static SlackTestConfig testConfig = SlackTestConfig.getInstance();
    static Slack slack = Slack.getInstance(testConfig.getConfig());

    @AfterClass
    public static void tearDown() throws InterruptedException {
        SlackTestConfig.awaitCompletion(testConfig);
    }

    String botToken = System.getenv(Constants.SLACK_SDK_TEST_BOT_TOKEN);
    String userToken = System.getenv(Constants.SLACK_SDK_TEST_USER_TOKEN);

    @Test
    public void teamAccessLogs() throws Exception {
        TeamAccessLogsResponse response = slack.methods().teamAccessLogs(r -> r.token(userToken));
        if (response.isOk()) {
            // when you pay for this team
            assertThat(response.getError(), is(nullValue()));
            assertThat(response.isOk(), is(true));
        } else {
            // when you don't pay for this team
            assertThat(response.isOk(), is(false));
            assertThat(response.getError(), is("paid_only"));
        }
    }

    @Test
    public void teamBillableInfo() throws Exception {
        List<User> users = slack.methods().usersList(r -> r.token(botToken)).getMembers();
        User user = null;
        for (User u : users) {
            if (!u.isBot() && !"USLACKBOT".equals(u.getId())) {
                user = u;
                break;
            }
        }
        String userId = user.getId();
        TeamBillableInfoResponse response = slack.methods().teamBillableInfo(r -> r
                .token(userToken)
                .user(userId));
        assertThat(response.getError(), is(nullValue()));
        assertThat(response.isOk(), is(true));
    }

    @Test
    public void teamInfo() throws Exception {
        TeamInfoResponse response = slack.methods().teamInfo(r -> r.token(botToken));
        assertThat(response.getError(), is(nullValue()));
        assertThat(response.isOk(), is(true));
    }

    @Test
    public void teamIntegrationLogs() throws Exception {
        String user = slack.methods().usersList(r -> r.token(botToken)).getMembers().get(0).getId();
        TeamIntegrationLogsResponse response = slack.methods().teamIntegrationLogs(r -> r
                .token(userToken)
                .user(user));
        assertThat(response.getError(), is(nullValue()));
        assertThat(response.isOk(), is(true));
    }

    @Test
    public void teamProfileGet() throws Exception {
        TeamProfileGetResponse response = slack.methods().teamProfileGet(r -> r.token(botToken));
        assertThat(response.getError(), is(nullValue()));
        assertThat(response.isOk(), is(true));
    }

}
