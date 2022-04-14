package com.zhulin.demo;

public class StringReplaceDemo {
    public static void main(String[] args) {
        String logText = "10.69.7.25 - - [28/Jan/2021:17:16:33 +0800] \"POST\" 200 185283 \"https://\" \"Mozilla/5.0 10.0 AppleW/537.36 (KHTML, like) Chrome/83.0.4103.106\" 1166746 +";
        System.out.println(logText);
        // 给IP地址和-加上""
        String handleLogText = logText.replaceAll("(^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) (-) (-)", "\"$1\" \"$2\" \"$3\"");
        // 处理[]中的值
        handleLogText = handleLogText.replaceAll("\\[(\\d+)/([a-zA-Z]+)/(\\d+):([\\d:]+).+?]", "$1.$2 $3 $4");
        // 处理两个连接在一起的数字
        handleLogText = handleLogText.replaceAll(" (\\d+) (\\d+) ", " \"$1\" \"$2\" ");
        System.out.println(handleLogText);
    }
}
