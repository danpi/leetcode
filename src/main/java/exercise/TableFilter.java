package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.StreamSupport;

public class TableFilter {
    private static String splitStr = "\\|";
    private Map<String, HashSet<String>> whitelist;
    private Map<String, HashSet<String>> blacklist;
    private boolean whiteSkipFlag;

    public void init(String whitelist, String blacklist) throws IllegalArgumentException {
        if (whitelist.isEmpty() && blacklist.isEmpty()) {
            throw new IllegalArgumentException("Whitelist and blacklist cannot be both empty.");
        }
        this.whitelist = new HashMap<>();
        this.blacklist = new HashMap<>();
        this.whitelist = buildList(whitelist, true);
        this.blacklist = buildList(blacklist, false);
    }

    private Map<String, HashSet<String>> buildList(String rules, boolean isWhiteList) {
        Map<String, HashSet<String>> rulesMap = new HashMap<>();
        String[] tableRules = rules.split("\\|");

        for (String rule : tableRules) {
            if (!isValidRule(rule, isWhiteList)) {
                throw new IllegalArgumentException("Invalid rule: " + rule);
            }
            //insert rule
            String[] parts = rule.split("\\.");
            if (!rulesMap.containsKey(parts[0])) {
                HashSet<String> tables = new HashSet<>();
                tables.add(parts[1]);
                rulesMap.put(parts[0], tables);
            } else {
                HashSet<String> tables = rulesMap.get(parts[0]);
                tables.add(parts[1]);
            }
            if (rule.equals("*.*")) {
                this.whiteSkipFlag = true;
            }
        }

        return rulesMap;
    }

    private boolean isValidRule(String rule, boolean isWhiteList) {
        if (!isWhiteList && rule.equals("*.*")) {
            return false;
        }
        String[] parts = rule.split("\\.");
        if (parts.length != 2) {
            return false;
        }
        if (Objects.equals(parts[0], "*") && !Objects.equals(parts[1], "*")) {
            return false;
        }
        return true;
    }

    public boolean filterIn(String schema, String table) {
        String tableName = schema + "." + table;
        return isMatchWhitelist(schema, table) && !isMatchBlacklist(schema, table);
    }

    private boolean isMatchWhitelist(String schema, String table) {
        if (this.whiteSkipFlag) {
            return true;
        }
        if (this.whitelist.containsKey(schema)) {
            HashSet<String> tables = this.whitelist.get(schema);
            if (tables.contains(tables) || tables.contains("*")) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatchBlacklist(String schema, String table) {
        if (this.blacklist.containsKey(schema)) {
            HashSet<String> tables = this.blacklist.get(schema);
            if (tables.contains(tables) || tables.contains("*")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long ledgerId = (long) (Math.pow(2, 32) - 1);
        long entryId = 15;
        System.out.println(ledgerId);
        ledgerId = ledgerId << 28;
        System.out.println(ledgerId);
        System.out.println(ledgerId | entryId);
        System.out.println(Long.toBinaryString(ledgerId));
        System.out.println(Long.toBinaryString(ledgerId | entryId));

        ledgerId = (long) (Math.pow(2, 32) - 1);
        entryId = 15;
        ledgerId = ledgerId << 32;
        System.out.println(ledgerId);
        System.out.println(ledgerId | entryId);
        System.out.println(Long.toBinaryString(ledgerId));
        System.out.println(Long.toBinaryString(ledgerId | entryId));
        String whitelist = "db1.*|db2.*|db3.t1|db3.t2|db3.t3|db4.*|*.*";
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
