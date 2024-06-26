// import DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        Hashmap<String, String> requests = new HashMap<String, String>();
        
        String facilitator_id = request.getParameter("facilitator_id");
        String page           = request.getParameter("page");
        String limit          = request.getParameter("limit");
        String sort           = request.getParameter("sort");
        String order          = request.getParameter("order");
        String name_like      = request.getParameter("name_like");
        String loginId_like   = request.getParameter("loginId_like");

        if (facilitator_id != null) requests.put("facilitator_id", facilitator_id);
        if (page != null)           requests.put("page", page);
        if (limit != null)          requests.put("limit", limit);
        if (sort != null)           requests.put("sort", sort);
        if (order != null)          requests.put("order", order);
        if (name_like != null)      requests.put("name_like", name_like);
        if (loginId_like != null)   requests.put("loginId_like", loginId_like);

        // クエリ生成
        String query = createQueryFromGetRequest(requests);

        
    }

    public String createQueryFromGetRequest(HashMap requests) {
        String query = "SELECT * FROM facilitators_students";

        HashMap<String, String> key_query = new HashMap<String, String>();

        if (requests.size() == 0) {
            query = query + ";";
            return query;
        } else {
            query = query + " WHERE";

            int loop_count = 0;
            for (Map.Entry<String, String> entry : requests.entrySet()) {
                // キーに応じてWHERE句を生成
                if (entry.getKey() == "facilitator_id") {
                    query = query + " facilitator_id = " + entry.getValue();

                } else if (entry.getKey() == "page") {
                    int page  = (int)entry.getValue();
                    int limit = (int)requests.get("limit");

                    String start = String.valueOf((page - 1) * limit + 1);
                    String end   = String.valueOf(page * limit);

                    query = query + " student_id BETWEEN " + start + " AND " + end;

                } else if (entry.getKey() == "limit") {
                    // limitはpageの時に一緒に処理しているのでスキップ
                    continue;

                } else if (entry.getKey() == "sort") {
                    query = query + " ORDER BY " + entry.getValue();
                    query + query + " " + requests.get("order");

                } else if (entry.getKey() == "name_like") {
                    query = query + " student_name LIKE '%" + entry.getValue() + "%'";

                } else if (entry.getKey() == "loginId_like") {
                    query = query + " login_id LIKE '%" + entry.getValue() + "%'";
                }

                // ループの回数とrequestの個数を比較し、まだループが続くなら"AND"、続かないなら";"を付ける
                loop_count++;
                if (loop_count < requests.size()) {
                    query = query + " AND"
                } else {
                    query = query + ";"
                }
            }
        }

        return query;
    }
}
