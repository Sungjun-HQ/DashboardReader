import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class DashboardReader {
    // If you don't specify the GitHub user id then the sdk will retrieve it via /user endpoint
    // GitHub github = new GitHubBuilder()lder().withOAuthToken("my_personal_token").build();

    // If the token has access to an organization, you can specify it here.
    GitHub github;

    DashboardReader(){
        try {
            github = new GitHubBuilder().withOAuthToken().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DashboardReader dbReader = new DashboardReader();
        try {
            GHRepository ghRepository = dbReader.github.getRepository("Sungjun-HQ/DashboardReader/issues/1");
//            System.out.println("Test: " + ghRepository.getSize());
//            GHIssue ghIssue = ghRepository.getIssue(issueNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
