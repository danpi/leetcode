package concurrent.printnumber;

import java.util.HashSet;

public class TableFilter {
    //点错了，刚刚来了个电话，麻烦再打一下
    private static String splitStr = "\\|";
    private HashSet<String> whiteStrategy;
    private HashSet<String> blackStrategy;

    /**
     * 根据黑、白名单进行初始化，二者不能同时为空
     *
     * @param whitelist 白名单
     * @param blacklist 黑名单
     * @throws IllegalArgumentException 当黑、白名单不符合规则时
     */
    public void init(String whitelist, String blacklist) throws IllegalArgumentException {
        if (whitelist == null && blacklist == null) {
            throw new IllegalArgumentException("Whitelist and blacklist cannot be both empty.");
        }
        this.whiteStrategy = new HashSet<>();
        this.blackStrategy = new HashSet<>();
        buildList(whitelist, whiteStrategy, true);
        buildList(blacklist, blackStrategy, false);
    }

    private void buildList(String list, HashSet<String> strategy, boolean isWhiteList) {
        String[] splitRules = list.split(splitStr);
        for (String rule : splitRules) {
            if (!isValidRule(rule, isWhiteList)) {
                throw new IllegalArgumentException("Invalid rule: " + rule);
            }
            strategy.add(rule);
        }
    }

    private boolean isValidRule(String rule, boolean isWhitelist) {
        if (rule.endsWith(".*")) {
            return true;
        }
        if (isWhitelist && rule.equals("*.*")) {
            return true;
        }

        String[] parts = rule.split(".");
        return parts.length == 2 && !parts[1].equals("table");
    }

    /**
     * 判断 schema.table 是否需要被同步，即在白名单中且不在黑名单中
     *
     * @return true 当 schema.table 在白名单中且不在黑名单中时；反之返回 false
     */
    public boolean filterIn(String schema, String table) {
        if (inWhiteList(schema, table) && !inBlackList(schema, table)) {
            return true;
        }
        return false;
    }

    private boolean inWhiteList(String schema, String table) {
        for (String strategy : this.whiteStrategy){
            if (isMatchWhiteStrategy(schema, table, strategy)) {
                return true;
            }
        }
        return false;
    }

    private boolean inBlackList(String schema, String table) {
        for (String strategy : this.blackStrategy){
            if (isMatchBlackStrategy(schema, table, strategy)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatchWhiteStrategy(String schema, String table, String strategy) {
        return true;
    }

    private boolean isMatchBlackStrategy(String schema, String table, String strategy) {
        return true;
    }

    public static void main(String[] args) {
        String whitelist = "db1.*|db2.*|db3.t1|db3.t2|db3.t3|db4.*";
        String blacklist = "db1.t1|db2.t1|db5.*";
        TableFilter tableFilter = new TableFilter();
        tableFilter.init(whitelist, blacklist);

        System.out.println(tableFilter.filterIn("db1", "t2") ? "passed" : "NOT passed");
        System.out.println(tableFilter.filterIn("db2", "t2") ? "passed" : "NOT passed");
        System.out.println(tableFilter.filterIn("db3", "t1") ? "passed" : "NOT passed");
        System.out.println(tableFilter.filterIn("db4", "t1") ? "passed" : "NOT passed");

        System.out.println(!tableFilter.filterIn("db1", "t1") ? "passed" : "NOT passed");
        System.out.println(!tableFilter.filterIn("db2", "t1") ? "passed" : "NOT passed");
        System.out.println(!tableFilter.filterIn("db3", "t4") ? "passed" : "NOT passed");
        System.out.println(!tableFilter.filterIn("db5", "t1") ? "passed" : "NOT passed");
        System.out.println(!tableFilter.filterIn("db6", "t1") ? "passed" : "NOT passed");
    }
}