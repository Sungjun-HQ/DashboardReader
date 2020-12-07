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
        GHRepository repo = dashboardReader.connectGH().getRepository("Sungjun-HQ/DashboardReader/");

        // 저장소에서 이슈 상태가 OPEN (ALL, CLOSED)
        List<GHIssue> list = repo.getIssues(GHIssueState.OPEN);

//        System.out.println("Issue list size: " + list.size());
        assertTrue(list.size() > 0);

        Map<String, Integer> map1 = new HashMap<>();

        // 이름, 코맨트가 있을 경우에 한해서만 내용 읽고 횟수 저장후 계산
        for (GHIssue ghIssue : list) {
            GHUser user;
            List<GHIssueComment> comments;

//            ArrayList<String> userList = new ArrayList();
//            System.out.println("list(" + i + "): " + list.get(i).getTitle());

            // 해당 리스트의 코맨트 리스트
            comments = ghIssue.getComments();

            if (comments.size() > 0) {
                for (GHIssueComment comment : comments) {
                    user = comment.getUser();

                    // 유저의 로그인 id 가져오기
//                    System.out.println("user name: " + user.getLogin());
//                    userList.add(user.getLogin());
                    if (map1.get(user.getLogin()) == null) {
                        map1.put(user.getLogin(), 1);
                    } else {
                        map1.put(user.getLogin(), map1.get(user.getLogin()) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < map1.size(); i++) {
            System.out.println(map1.keySet() + " : " + map1.values());
        }


//        System.out.println("comments list size: " + comments.size());
//        assertTrue(comments.size() > 0);

//        for (GHIssueComment com : comments) {
//            System.out.println(com.getBody());
//        }

//        System.out.println("comments body: " + comments.get(0).getBody());

//        int i = 0;
//        for (GHIssue event :
//                list) {
//            assertNotNull(event.getIssue());
//        }
    }
}