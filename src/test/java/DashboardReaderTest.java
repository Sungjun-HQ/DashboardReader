import org.junit.jupiter.api.Test;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DashboardReaderTest {
    private final DashboardReader dbReader = new DashboardReader();

    @Test
    void getGHRepositoryTest() throws IOException {
        GHRepository repo = dbReader.github.getRepository("Sungjun-HQ/DashboardReader/");
        List<GHIssue> list = repo.getIssues(GHIssueState.OPEN);

        System.out.println("list size: " + list.size());
        assertTrue(list.size() > 0);

        for (GHIssue issue :
                list) {
            System.out.println(issue.getBody());
        }

        List<GHIssueComment> comments = list.get(0).getComments();

        System.out.println("comments list size: " + comments.size());
        assertTrue(comments.size() > 0);

        for (GHIssueComment com :
                comments) {
            System.out.println(com.getBody());
        }

//        System.out.println("comments body: " + comments.get(0).getBody());

//        int i = 0;
//        for (GHIssue event :
//                list) {
//            assertNotNull(event.getIssue());
//        }
    }
}