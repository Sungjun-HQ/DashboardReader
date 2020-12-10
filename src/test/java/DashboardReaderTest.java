import org.junit.jupiter.api.Test;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DashboardReaderTest {

    @Test
    void getGHRepositoryTest() throws IOException {

        DashboardReader dashboardReader = new DashboardReader();

        // 접속한 github에서 태스트용 저장소로 이동
//        GHRepository repo = dashboardReader.connectGH().getRepository("Sungjun-HQ/DashboardReader/");
        GHRepository repo = dashboardReader.connectGH().getRepository("whiteship/live-study/");

        // 저장소에서 이슈 상태가 OPEN (ALL, CLOSED)
        List<GHIssue> list = repo.getIssues(GHIssueState.ALL);
//        List<GHIssue> list = repo.getIssues(GHIssueState.OPEN);

        assertTrue(list.size() > 0);

        Map<String, Integer> map1 = new HashMap<>();

        for (GHIssue ghIssue : list) {
            GHUser user;
            List<GHIssueComment> commentsList = ghIssue.getComments();

            if (commentsList.size() > 0) {
                for (GHIssueComment comment : commentsList) {
                    user = comment.getUser();

                    // 유저의 로그인 id 가져오기
                    if (map1.get(user.getLogin()) == null) {
                        map1.put(user.getLogin(), 1);
                    } else {
                        map1.put(user.getLogin(), map1.get(user.getLogin()) + 1);
                    }
                }
            }
        }

        // map1 출력
        /*for (String key : map1.keySet()) {
            int value = map1.get(key);
            System.out.println(key + ", " + value);
        }*/

        // map1 소수점 출력
        for (String i :
                map1.keySet()) {
            float progressFloat = map1.get(i);
            progressFloat = progressFloat / 18 * 100;
            System.out.print("name: " + i);
            System.out.println(", progress: " + String.format("%.2f", progressFloat));
        }
    }
}