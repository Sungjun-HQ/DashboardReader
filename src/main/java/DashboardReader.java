import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class DashboardReader {
    // If you don't specify the GitHub user id then the sdk will retrieve it via /user endpoint
    // GitHub github = new GitHubBuilder()lder().withOAuthToken("my_personal_token").build();

    public GitHub connectGH() {
        GitHub github = null;
        try {
            // If the token has access to an organization, you can specify it here.
            github = new GitHubBuilder().withOAuthToken("oauthToken", "sungjun-HQ").build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return github;
    }

    public static void main(String[] args) {

    }

}
